package com.superworldsun.superslegend.entities.projectiles.seeds;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.registries.EntityTypeInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class MelonSeedEntity extends SeedEntity
{
	public MelonSeedEntity(EntityType<? extends MelonSeedEntity> type, World world)
	{
		super(type, world);
	}
	
	public MelonSeedEntity(World worldIn, LivingEntity shooter)
	{
		super(EntityTypeInit.MELON_SEED.get(), shooter, worldIn);
	}
	
	@Override
	protected ItemStack getPickupItem()
	{
		return new ItemStack(Items.MELON_SEEDS);
	}
	
	public static EntityType<MelonSeedEntity> createEntityType()
	{
		return EntityType.Builder.<MelonSeedEntity>of(MelonSeedEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).build(SupersLegendMain.MOD_ID + ":melon_seed");
	}
}