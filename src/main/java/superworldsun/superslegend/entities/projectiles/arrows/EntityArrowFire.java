package superworldsun.superslegend.entities.projectiles.arrows;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import superworldsun.superslegend.init.SoundInit;
import superworldsun.superslegend.lists.ItemList;

public class EntityArrowFire extends ArrowEntity {

    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("zeldamod:textures/entity/arrows/arrow_fire.png");

    public EntityArrowFire(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityArrowFire(World worldIn, LivingEntity shooter) {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(ItemList.fire_arrow);
    }

    @Override
    protected void arrowHit(LivingEntity entity) {
        super.arrowHit(entity);
        if (!world.isRaining() && !world.isThundering()) {
            entity.setFire(6);

            BlockPos currentPos = entity.getPosition();
            entity.world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_FIRE, SoundCategory.PLAYERS, 1f, 1f);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.isWet() || !this.isInWater()) {
            if (this.world.isRemote && !this.inGround && this.isBurning()) {
                this.world.addParticle(ParticleTypes.FLAME, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D,
                        0.0D);
            }
        }


                if (this.inGround) {
                    if (!this.isWet() || !this.isInWater()) {
                        if (world.isAirBlock(this.getPosition()))
                            world.setBlockState(this.getPosition(), Blocks.FIRE.getDefaultState(), 11);

                        BlockPos currentPos = this.getPosition();
                        this.world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_FIRE, SoundCategory.PLAYERS, 1f, 1f);

                        this.remove();
                    }
                    if (!this.isWet() || !this.isInWater()) {
                        if (world.isAirBlock(this.getPosition().west()))
                            world.setBlockState(this.getPosition().west(), Blocks.FIRE.getDefaultState(), 11);

                    }
                    if (!this.isWet() || !this.isInWater()) {
                        if (world.isAirBlock(this.getPosition().east()))
                            world.setBlockState(this.getPosition().east(), Blocks.FIRE.getDefaultState(), 11);

                    }
                    if (!this.isWet() || !this.isInWater()) {
                        if (world.isAirBlock(this.getPosition().north()))
                            world.setBlockState(this.getPosition().north(), Blocks.FIRE.getDefaultState(), 11);

                    }
                    if (!this.isWet() || !this.isInWater()) {
                        if (world.isAirBlock(this.getPosition().south()))
                            world.setBlockState(this.getPosition().south(), Blocks.FIRE.getDefaultState(), 11);

                    }
                }


                if (this.isInWater()) {
                    BlockPos currentPos = this.getPosition();
                    this.world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 1f, 1f);
                    this.remove();
                }
            }
        }