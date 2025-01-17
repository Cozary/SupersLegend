package com.superworldsun.superslegend.items.weapons;

import java.util.List;
import java.util.function.Predicate;

import com.superworldsun.superslegend.capability.mana.ManaHelper;
import com.superworldsun.superslegend.entities.projectiles.magic.FireballEntity;
import com.superworldsun.superslegend.items.custom.NonEnchantItem;
import com.superworldsun.superslegend.registries.ItemGroupInit;
import com.superworldsun.superslegend.registries.TagInit;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class FireRod extends NonEnchantItem
{
	public FireRod()
	{
		super(new Item.Properties().stacksTo(1).tab(ItemGroupInit.RESOURCES));
	}

	//TODO Fire should melt thin snow layers super easily with held right click

	//TODO Change the fire ball explosion sound
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
	{
		if (playerEntity.isCrouching())
		{
			if (!world.isClientSide)
			{
				// per use
				float manacost = 2F;
				
				if (ManaHelper.hasMana(playerEntity, manacost))
				{
					float fireballSpeed = 0.5F;
					Vector3d playerLookVec = playerEntity.getLookAngle();
					Vector3d fireballPosition = playerEntity.getEyePosition(1F).add(playerLookVec);
					Vector3d fireballMotion = playerLookVec.multiply(fireballSpeed, fireballSpeed, fireballSpeed);
					FireballEntity fireballEntity = new FireballEntity(fireballPosition, fireballMotion, world, playerEntity);
					world.addFreshEntity(fireballEntity);
					ManaHelper.spendMana(playerEntity, manacost);
					playerEntity.getCooldowns().addCooldown(this, 16);
					world.playSound(null, playerEntity.position().x, playerEntity.position().y, playerEntity.position().z, SoundEvents.FIRECHARGE_USE, SoundCategory.PLAYERS, 1F, 1F);
				}
			}
		}
		else
		{
			playerEntity.startUsingItem(hand);
		}
		
		return ActionResult.consume(playerEntity.getItemInHand(hand));
	}
	
	@Override
	public UseAction getUseAnimation(ItemStack itemStack)
	{
		return UseAction.BOW;
	}
	
	@Override
	public int getUseDuration(ItemStack itemStack)
	{
		return 72000;
	}
	
	@Override
	public void onUseTick(World world, LivingEntity livingEntity, ItemStack itemStack, int timeInUse) {
		if (livingEntity instanceof PlayerEntity) {
			// per tick
			float manacost = 0.025F;
			PlayerEntity player = (PlayerEntity) livingEntity;

			if (!ManaHelper.hasMana(player, manacost)) {
				// no effect in not enough mana and not in creative mod
				return;
			}

			int particlesDensity = 2;
			int secondsOnFire = 3;
			float particlesSpread = 0.3F;
			float particlesSpeed = 1F;
			float effectRange = 6F;
			float damage = 1F;

			Vector3d playerLookVec = player.getLookAngle();
			Vector3d effectStart = player.getEyePosition(1F).add(playerLookVec);
			Vector3d effectEnd = effectStart.add(playerLookVec.multiply(effectRange, effectRange, effectRange));
			Vector3d particlesMotionVec = playerLookVec.multiply(particlesSpeed, particlesSpeed, particlesSpeed);

			for (int i = 0; i < particlesDensity; i++) {
				double particleX = effectStart.x + (player.getRandom().nextFloat() * 2 - 1) * particlesSpread;
				double particleY = effectStart.y + (player.getRandom().nextFloat() * 2 - 1) * particlesSpread;
				double particleZ = effectStart.z + (player.getRandom().nextFloat() * 2 - 1) * particlesSpread;
				double particleMotionX = particlesMotionVec.x + (player.getRandom().nextFloat() * 2 - 1) * particlesSpread / 5F;
				double particleMotionY = particlesMotionVec.y + (player.getRandom().nextFloat() * 2 - 1) * particlesSpread / 5F;
				double particleMotionZ = particlesMotionVec.z + (player.getRandom().nextFloat() * 2 - 1) * particlesSpread / 5F;
				world.addParticle(ParticleTypes.FLAME, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ);
			}

			BlockRayTraceResult blockRayTraceResult = world.clip(new RayTraceContext(effectStart, effectEnd, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, null));

			if (blockRayTraceResult.getType() != RayTraceResult.Type.MISS && !world.isClientSide()) {
				// if we hit block, area of effect ends at the hit location
				effectEnd = blockRayTraceResult.getLocation();
				// blocks effect
				// once between 5 - 15 Ticks at random
				if (timeInUse % (5 + random.nextInt(10)) == 0) {
					BlockPos hitPos = blockRayTraceResult.getBlockPos();

					if (world.getBlockState(hitPos).is(TagInit.CAN_MELT) || world.getBlockState(hitPos).is(BlockTags.ICE)) {
						// replaces meltable blocks with air
						world.setBlock(hitPos, Blocks.AIR.defaultBlockState(), 3);
					}
					//TODO i want it so that you can light torch towers but this dosent seem to work
					/*else if (world.getBlockState(hitPos).getBlock() instanceof TorchTowerTopUnlit) {
						world.setBlock(hitPos, BlockInit.TORCH_TOWER_TOP_LIT.get().defaultBlockState(), 3);
						world.playSound(null, hitPos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1F, 1F);
					}*/
					else {
						BlockPos firePos = hitPos.relative(blockRayTraceResult.getDirection());
						// sets other blocks on fire
						if (AbstractFireBlock.canBePlacedAt(world, firePos, blockRayTraceResult.getDirection())) {
							BlockState fireBlockState = AbstractFireBlock.getState(world, firePos);
							world.setBlock(firePos, fireBlockState, 11);
						}
					}
				}
			}

			// we want to only attack living entities
			Predicate<Entity> canHit = e -> e instanceof LivingEntity;
			EntityRayTraceResult entityRayTraceResult = ProjectileHelper.getEntityHitResult(world, player, effectStart, effectEnd, new AxisAlignedBB(effectStart, effectEnd).inflate(1.0D), canHit);
			
			// if we hit entity
			if (entityRayTraceResult != null)
			{
				DamageSource damageSource = DamageSource.playerAttack(player).setIsFire();
				entityRayTraceResult.getEntity().hurt(damageSource, damage);
				entityRayTraceResult.getEntity().setSecondsOnFire(secondsOnFire);
			}
			
			ManaHelper.spendMana(player, manacost);
			
			// plays sound 4 times per second
			if (timeInUse % 5 == 0)
			{
				world.playSound(null, player.position().x, player.position().y, player.position().z, SoundEvents.FIRECHARGE_USE, SoundCategory.PLAYERS, 1F, 1F);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> list, @Nonnull ITooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);
		list.add(new StringTextComponent(TextFormatting.DARK_RED + "Hold Right-Click to create fire"));
		list.add(new StringTextComponent(TextFormatting.DARK_RED + "Sneak+Right-Click to shoot a ball of fire"));
		list.add(new StringTextComponent(TextFormatting.GRAY + "Uses Magic on use"));
	}
}
