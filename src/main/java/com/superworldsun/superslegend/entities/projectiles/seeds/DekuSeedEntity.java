package com.superworldsun.superslegend.entities.projectiles.seeds;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.registries.EntityTypeInit;
import com.superworldsun.superslegend.registries.ItemInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class DekuSeedEntity extends AbstractArrowEntity
{
	public DekuSeedEntity(EntityType<? extends DekuSeedEntity> type, World world)
	{
		super(type, world);
	}
	
	public DekuSeedEntity(World worldIn, LivingEntity shooter)
	{
		super(EntityTypeInit.PELLET.get(), shooter, worldIn);
	}
	
	@Override
	public void onAddedToWorld()
	{
		super.onAddedToWorld();
		setBaseDamage(2.0D);
	}
	
	@Override
	protected ItemStack getPickupItem()
	{
		return new ItemStack(ItemInit.DEKU_SEEDS.get());
	}
	
	protected SoundEvent getDefaultHitGroundSoundEvent()
	{
		return SoundEvents.BAMBOO_BREAK;
	}
	
	@Override
	public IPacket<?> getAddEntityPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	public void tick()
	{
		super.tick();
		
		if (inGround)
		{
			remove();
		}
	}
	
	@Override
	protected void onHitEntity(EntityRayTraceResult result)
	{
		super.onHitEntity(result);
		
		if (result.getEntity() instanceof LivingEntity)
		{
			LivingEntity target = (LivingEntity) result.getEntity();
			
			if (!level.isClientSide && getPierceLevel() <= 0)
			{
				target.setArrowCount(target.getArrowCount() - 1);
			}
		}
	}
	
	public static EntityType<DekuSeedEntity> createEntityType()
	{
		return EntityType.Builder.<DekuSeedEntity>of(DekuSeedEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).build(SupersLegendMain.MOD_ID + ":pellet");
	}
}