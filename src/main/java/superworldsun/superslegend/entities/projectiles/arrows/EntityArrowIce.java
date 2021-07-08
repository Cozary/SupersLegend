package superworldsun.superslegend.entities.projectiles.arrows;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import superworldsun.superslegend.init.EntityInit;
import superworldsun.superslegend.init.SoundInit;
import superworldsun.superslegend.lists.ItemList;

public class EntityArrowIce extends AbstractArrowEntity
{

    public EntityArrowIce(EntityType<? extends EntityArrowIce> type, World world) {
        super(type, world);
    }

    public EntityArrowIce(World worldIn, LivingEntity shooter) {
        super(EntityInit.ICE_ARROW.get(), shooter, worldIn);
        this.setBaseDamage(this.getBaseDamage() + 2.0F);
    }

    public EntityArrowIce(World worldIn, double x, double y, double z) {
        super(EntityInit.ICE_ARROW.get(), x, y, z, worldIn);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemList.ice_arrow);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        living.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 70, 255));
        BlockPos currentPos = living.blockPosition();
        living.level.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_ICE, SoundCategory.PLAYERS, 1f, 1f);
        if(living.equals(EntityType.BLAZE)||living.equals(EntityType.MAGMA_CUBE)||living.equals(EntityType.HUSK))
        {
            this.setBaseDamage(this.getBaseDamage()*2);
        }
        if(living.equals(EntityType.POLAR_BEAR)||living.equals(EntityType.STRAY))
        {
            this.setBaseDamage(this.getBaseDamage()/2);
        }
        super.doPostHurtEffects(living);
    }



    @Override
    public void tick() {
        super.tick();
        if(this.inGround){
        		if (level.isEmptyBlock(this.blockPosition()))
                level.setBlock(this.blockPosition(), Blocks.SNOW.defaultBlockState(), 11);


                BlockPos currentPos = this.blockPosition();
                this.level.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_ICE, SoundCategory.PLAYERS, 1f, 1f);

                this.remove();
            }

        if (!this.inGround)
        {
            this.level.addParticle(ParticleTypes.ITEM_SNOWBALL, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D,
                    0.0D);
            this.level.addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D,
                    0.0D);
        }


        if(this.isInWater())
        {
        	level.setBlock(this.blockPosition(), Blocks.FROSTED_ICE.defaultBlockState(), 11);

        	BlockPos currentPos = this.blockPosition();
            this.level.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_ICE, SoundCategory.PLAYERS, 1f, 1f);

        	this.remove();
        }

        if(this.isInLava())
        {

            level.setBlockAndUpdate(this.getOnPos(), Blocks.COBBLESTONE.defaultBlockState());

            BlockPos currentPos = this.blockPosition();
            this.level.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_ICE, SoundCategory.PLAYERS, 1f, 1f);

            this.remove();
        }

    }

    //Removes Block Beneath it sometimes instead of just the fire
    /*@Override
    protected void onInsideBlock(BlockState state) {
        if (!this.isAirBorne) {
            BlockState block = world.getBlockState(getPosition());
            if(block == Blocks.FIRE.getDefaultState())
            {
                world.setBlockState(this.getOnPosition(), Blocks.AIR.getDefaultState());
                this.remove();
            }
        }
    }*/




}
