package superworldsun.superslegend.entities.ai;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import superworldsun.superslegend.entities.mobs.poe.PoeEntity;

import java.util.EnumSet;


public class PoeAttackGoal extends MeleeAttackGoal {
        private final PoeEntity poe;
        private final double speedTowardsTarget;
        private final boolean longMemory;
        private Path path;
        private double targetX;
        private double targetY;
        private double targetZ;
        private int delayCounter;
        private int field_234037_i_;
        private final int attackInterval = 20;
        private long field_220720_k;
        private int failedPathFindingPenalty = 0;
        private boolean canPenalize = false;

        public PoeAttackGoal(PoeEntity poe, double speedIn, boolean useLongMemory) {
            super(poe, speedIn, useLongMemory);
            this.poe = poe;
            this.speedTowardsTarget = speedIn;
            this.longMemory = useLongMemory;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            long i = this.poe.world.getGameTime();
            if (i - this.field_220720_k < 20L) {
                return false;
            } else {
                this.field_220720_k = i;
                LivingEntity livingentity = this.poe.getAttackTarget();
                if (livingentity == null) {
                    return false;
                } else if (!livingentity.isAlive()) {
                    return false;
                } else {
                    if (canPenalize) {
                        if (--this.delayCounter <= 0) {
                            this.path = this.poe.getNavigator().getPathToEntity(livingentity, 0);
                            this.delayCounter = 4 + this.poe.getRNG().nextInt(7);
                            return this.path != null;
                        } else {
                            return true;
                        }
                    }
                    this.path = this.poe.getNavigator().getPathToEntity(livingentity, 0);
                    if (this.path != null) {
                        return true;
                    } else {
                        return this.getAttackReachSqr(livingentity) >= this.poe.getDistanceSq(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ());
                    }
                }
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            LivingEntity livingentity = this.poe.getAttackTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else if (!this.longMemory) {
                return !this.poe.getNavigator().noPath();
            } else if (!this.poe.isWithinHomeDistanceFromPosition(livingentity.getPosition())) {
                return false;
            } else {
                return !(livingentity instanceof PlayerEntity) || !livingentity.isSpectator() && !((PlayerEntity)livingentity).isCreative();
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.poe.getNavigator().setPath(this.path, this.speedTowardsTarget);
            this.poe.setAggroed(true);
            this.delayCounter = 0;
            this.field_234037_i_ = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            LivingEntity livingentity = this.poe.getAttackTarget();
            if (!EntityPredicates.CAN_AI_TARGET.test(livingentity)) {
                this.poe.setAttackTarget((LivingEntity)null);
            }

            this.poe.setAggroed(false);
            this.poe.getNavigator().clearPath();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            LivingEntity livingentity = this.poe.getAttackTarget();
            this.poe.getLookController().setLookPositionWithEntity(livingentity, 30.0F, 30.0F);
            double d0 = this.poe.getDistanceSq(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ());
            this.delayCounter = Math.max(this.delayCounter - 1, 0);
            if ((this.longMemory || this.poe.getEntitySenses().canSee(livingentity)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || livingentity.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.poe.getRNG().nextFloat() < 0.05F)) {
                this.targetX = livingentity.getPosX();
                this.targetY = livingentity.getPosY();
                this.targetZ = livingentity.getPosZ();
                this.delayCounter = 4 + this.poe.getRNG().nextInt(7);
                if (this.canPenalize) {
                    this.delayCounter += failedPathFindingPenalty;
                    if (this.poe.getNavigator().getPath() != null) {
                        net.minecraft.pathfinding.PathPoint finalPathPoint = this.poe.getNavigator().getPath().getFinalPathPoint();
                        if (finalPathPoint != null && livingentity.getDistanceSq(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
                            failedPathFindingPenalty = 0;
                        else
                            failedPathFindingPenalty += 10;
                    } else {
                        failedPathFindingPenalty += 10;
                    }
                }
                if (d0 > 1024.0D) {
                    this.delayCounter += 10;
                } else if (d0 > 256.0D) {
                    this.delayCounter += 5;
                }

                if (!this.poe.getNavigator().tryMoveToEntityLiving(livingentity, this.speedTowardsTarget)) {
                    this.delayCounter += 15;
                }
            }

            this.field_234037_i_ = Math.max(this.field_234037_i_ - 1, 0);
            this.checkAndPerformAttack(livingentity, d0);
        }

        protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
            double d0 = this.getAttackReachSqr(enemy);
            if (distToEnemySqr <= d0 && this.field_234037_i_ <= 0) {
                this.func_234039_g_();
                this.poe.swingArm(Hand.MAIN_HAND);
                this.poe.attackEntityAsMob(enemy);
            }

        }

        protected void func_234039_g_() {
            this.field_234037_i_ = 20;
        }

        protected boolean func_234040_h_() {
            return this.field_234037_i_ <= 0;
        }

        protected int func_234041_j_() {
            return this.field_234037_i_;
        }

        protected int func_234042_k_() {
            return 20;
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return (double)(this.poe.getWidth() * 2.0F * this.poe.getWidth() * 2.0F + attackTarget.getWidth());
        }
    }