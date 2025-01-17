package com.superworldsun.superslegend.loot;

import java.util.Random;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.registries.ItemInit;

import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = SupersLegendMain.MOD_ID)
public class VanillaMobDrops {
	// This is so when the player uses other mods with monsters it will at least drop something and not stack
	// with lower.A more fine tuned drop rate will be listed for vanilla mobs/
	@SubscribeEvent
	public static void customLootMonsterEntity(LivingDropsEvent event) {
		Random random = new Random();

		// This should make it so any type of monster from other mods should also drop rupees occasionally
		if (event.getSource().getEntity() instanceof PlayerEntity && event.getEntityLiving() instanceof MonsterEntity
				&& !(event.getEntityLiving() instanceof BlazeEntity) && !(event.getEntityLiving() instanceof CaveSpiderEntity)
				&& !(event.getEntityLiving() instanceof CreeperEntity) && !(event.getEntityLiving() instanceof DrownedEntity)
				&& !(event.getEntityLiving() instanceof ElderGuardianEntity) && !(event.getEntityLiving() instanceof EndermanEntity)
				&& !(event.getEntityLiving() instanceof EndermiteEntity) && !(event.getEntityLiving() instanceof EnderDragonEntity)
				&& !(event.getEntityLiving() instanceof EvokerEntity) && !(event.getEntityLiving() instanceof GhastEntity)
				&& !(event.getEntityLiving() instanceof GuardianEntity) && !(event.getEntityLiving() instanceof HuskEntity)
				&& !(event.getEntityLiving() instanceof IllusionerEntity) && !(event.getEntityLiving() instanceof MagmaCubeEntity)
				&& !(event.getEntityLiving() instanceof PhantomEntity) && !(event.getEntityLiving() instanceof PillagerEntity)
				&& !(event.getEntityLiving() instanceof RavagerEntity) && !(event.getEntityLiving() instanceof ShulkerEntity)
				&& !(event.getEntityLiving() instanceof SilverfishEntity) && !(event.getEntityLiving() instanceof SkeletonEntity)
				&& !(event.getEntityLiving() instanceof SlimeEntity) && !(event.getEntityLiving() instanceof SpiderEntity)
				&& !(event.getEntityLiving() instanceof StrayEntity) && !(event.getEntityLiving() instanceof VindicatorEntity)
				&& !(event.getEntityLiving() instanceof WitchEntity) && !(event.getEntityLiving() instanceof WitherEntity)
				&& !(event.getEntityLiving() instanceof WitherSkeletonEntity) && !(event.getEntityLiving() instanceof ZombieVillagerEntity)
				&& !(event.getEntityLiving() instanceof ZombifiedPiglinEntity) && !(event.getEntityLiving() instanceof ZombieEntity)) {
			if (random.nextInt(7) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), random.nextInt(3)));
			if (random.nextInt(14) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootRingDrop(LivingDropsEvent event) {
		Random random = new Random();

		// This should make it so any type of monster from other mods should also drop rupees occasionally
		if (event.getSource().getEntity() instanceof PlayerEntity && event.getEntityLiving() instanceof MonsterEntity) {
			if (random.nextInt(45) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.UNAPPRAISED_RING.get(), random.nextInt(3)));
		}
	}

	@SubscribeEvent
	public static void customLootBlaze(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof BlazeEntity)) {
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), random.nextInt(3)));
			if (random.nextInt(10) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(60) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_POWER_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootCaveSpider(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof CaveSpiderEntity)) {
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), random.nextInt(3)));
			if (random.nextInt(14) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(50) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_COURAGE_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootCreeper(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof CreeperEntity)) {
			if (random.nextInt(4) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), random.nextInt(3)));
			if (random.nextInt(7) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootDrowned(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof DrownedEntity)) {
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), random.nextInt(3)));
			if (random.nextInt(14) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(70) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_COURAGE_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootElderGuardian(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof ElderGuardianEntity)) {
			if (random.nextInt(14) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RED_RUPEE.get(), 1));
			if (random.nextInt(1) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_COURAGE_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootEnderman(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof EndermanEntity)) {
			if (random.nextInt(3) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(8) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootEndermite(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof EndermiteEntity)) {
			if (random.nextInt(3) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(7) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootEvoker(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof EvokerEntity)) {
			if (random.nextInt(3) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(25) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_WISDOM_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootGhast(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof GhastEntity)) {
			if (random.nextInt(2) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(4) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(35) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_POWER_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootGuardian(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof GuardianEntity)) {
			if (random.nextInt(4) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(55) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_COURAGE_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootHusk(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof HuskEntity)) {
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(12) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootMagmaCube(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof MagmaCubeEntity)) {
			if (random.nextInt(8) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(10) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(90) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_POWER_SHARD.get(), 1));
			if (random.nextInt(20) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RED_JELLY.get(), 1));
			if (random.nextInt(60) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_JELLY.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootPhantom(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof PhantomEntity)) {
			if (random.nextInt(5) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(10) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(45) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_WISDOM_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootPillager(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof PillagerEntity)) {
			if (random.nextInt(3) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(5) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(60) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_WISDOM_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootRavager(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof RavagerEntity)) {
			if (random.nextInt(5) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(8) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(65) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_WISDOM_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootShulker(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof ShulkerEntity)) {
			if (random.nextInt(5) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(8) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(65) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_WISDOM_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootSilverfish(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof SilverfishEntity)) {
			if (random.nextInt(4) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(15) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootSkeleton(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof SkeletonEntity)) {
			if (random.nextInt(5) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(16) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(75) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_WISDOM_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootSlime(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity
				&& (event.getEntityLiving() instanceof SlimeEntity && !(event.getEntityLiving() instanceof MagmaCubeEntity))) {
			if (random.nextInt(9) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(11) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(15) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.GREEN_JELLY.get(), 1));
			if (random.nextInt(65) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_JELLY.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootSpider(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof SpiderEntity)) {
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(10) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootStray(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof StrayEntity)) {
			if (random.nextInt(7) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(12) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootVindicator(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof VindicatorEntity)) {
			if (random.nextInt(2) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 3));
			if (random.nextInt(5) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(25) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_COURAGE_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootWitch(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof WitchEntity)) {
			if (random.nextInt(2) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(4) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(20) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_WISDOM_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootWitherSkeleton(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof WitherSkeletonEntity)) {
			if (random.nextInt(3) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(40) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_POWER_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootZombieVillager(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof ZombieVillagerEntity)) {
			if (random.nextInt(7) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(12) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootZombifiedPig(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof ZombifiedPiglinEntity)) {
			if (random.nextInt(6) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(13) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
			if (random.nextInt(70) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.TRIFORCE_POWER_SHARD.get(), 1));
		}
	}

	@SubscribeEvent
	public static void customLootZombie(LivingDropsEvent event) {
		Random random = new Random();

		if (event.getSource().getEntity() instanceof PlayerEntity && (event.getEntityLiving() instanceof ZombieEntity)) {
			if (random.nextInt(7) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.RUPEE.get(), 4));
			if (random.nextInt(17) == 0)
				event.getEntityLiving().spawnAtLocation(new ItemStack(ItemInit.BLUE_RUPEE.get(), 1));
		}
	}
}
