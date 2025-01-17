package com.superworldsun.superslegend.items.items;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.capability.mana.ManaHelper;

import com.superworldsun.superslegend.registries.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DinsFire extends Item {
   public DinsFire(Properties builder) {
      super(builder);
   }

   /**
    * This function is called when the player stops using the item.
    */
   @Override
   public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity player) {
      return super.finishUsingItem(itemStack, world, player);
   }

   @Override
   public UseAction getUseAnimation(ItemStack itemStack) {
      return UseAction.BOW;
   }

   //TODO The fire attack can be used with a instant right click instead of the full charged right click

   //TODO The fire blast also sets the user on fire so it is set to clear fire, find a better solution if possible

   float manaCost = 6.0F;

   /**
    * If the player has enough mana, and the item has been used for more than 72000 ticks, then set all nearby entities on
    * fire
    */
   @Override
   public void releaseUsing(ItemStack itemStack, World world, LivingEntity livingEntity, int remainingUseTicks)
   {
      float manacost = 6F;
      PlayerEntity player = (PlayerEntity) livingEntity;
      boolean hasMana = ManaHelper.hasMana(player, manacost);
	  if (hasMana)
      {
         if(livingEntity instanceof PlayerEntity)
         {
            if (!world.isClientSide)
            {
            fibonacci_sphere(player);

            AxisAlignedBB targetBox = new AxisAlignedBB(player.position(), player.position()).inflate(6);

            List<LivingEntity> foundTarget =
                    world.getEntitiesOfClass(LivingEntity.class, targetBox, AVOID_PLAYERS);

            SupersLegendMain.LOGGER.info(hasMana);
            SupersLegendMain.LOGGER.info(!foundTarget.isEmpty());
            SupersLegendMain.LOGGER.info(getUseDuration(itemStack));

            if (!foundTarget.isEmpty() && hasMana && getUseDuration(itemStack) >= 72000)
               {
                  world.playSound(player, player.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                  for (LivingEntity living : foundTarget)
                  {
                     ManaHelper.spendMana(player, manaCost);
                     player.getCooldowns().addCooldown(this, 16);
                     living.setSecondsOnFire(6);

                     BlockPos playerPos = player.blockPosition();
                     int radius = 10;
                     BlockState blockToReplace = BlockInit.TORCH_TOWER_TOP_UNLIT.get().defaultBlockState();
                     BlockState blockToReplaceWith = BlockInit.TORCH_TOWER_TOP_LIT.get().defaultBlockState();
                     // Create the fire field around the player
                     // Replace blocks within the field
                     replaceBlocksAroundPlayer(player, world, playerPos, radius, blockToReplace, blockToReplaceWith);

                     player.clearFire();
                  }
               }
            }
         }
      }
      if (player.isCreative())
      {
         BlockPos playerPos = player.blockPosition();
         int radius = 10;
         BlockState blockToReplace = BlockInit.TORCH_TOWER_TOP_UNLIT.get().defaultBlockState();
         BlockState blockToReplaceWith = BlockInit.TORCH_TOWER_TOP_LIT.get().defaultBlockState();
         // Create the fire field around the player
         // Replace blocks within the field
         replaceBlocksAroundPlayer(player, world, playerPos, radius, blockToReplace, blockToReplaceWith);
      }
   }

   private void replaceBlocksAroundPlayer(PlayerEntity player, World world, BlockPos playerPos, int radius, BlockState blockToReplace, BlockState blockToReplaceWith) {
      for (BlockPos pos : BlockPos.betweenClosed(playerPos.offset(-radius, -radius, -radius), playerPos.offset(radius, radius, radius))) {
         if (pos.distSqr(playerPos) <= radius * radius && world.getBlockState(pos) == blockToReplace) {
            world.setBlock(pos, blockToReplaceWith, 3);
         }
      }
   }

   @Override
   public int getUseDuration(ItemStack itemStack) {
      return 72000;
   }

   public void fibonacci_sphere(PlayerEntity player) {
      int samples = 1000;
      double phi = Math.PI * (3. - Math.sqrt(5.));

      for(int i = 0; i < samples; i++) {
         int i1 = samples - 1;
         int y = 1 - (i / i1) *2;
         double radius = Math.sqrt(1 - y * y);

         double theta = phi * i;

         double x = Math.cos(theta) * radius;
         double z = Math.sin(theta) * radius;

         ((ServerWorld) player.getCommandSenderWorld()).sendParticles(ParticleTypes.FLAME, player.getX() + x, player.getY() + y, player.getZ() + z, 1, 0.0, 0.0, 0.0, 0.1);
      }
   }

   // It's a filter that checks if the entity is a player, and if it is, it checks if the player is in creative mode or is
   // a spectator. If it is, it returns false, otherwise it returns true.
   private static final Predicate<Entity> AVOID_PLAYERS = (player) -> {
      return !player.isDiscrete() && EntityPredicates.NO_CREATIVE_OR_SPECTATOR.test(player);
   };

   /**
    * If the player is using the item in their hand, start using it.
    */
   @Override
   public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
      ItemStack itemstack = player.getItemInHand(hand);
      player.startUsingItem(hand);
      return ActionResult.consume(itemstack);
   }

   @OnlyIn(Dist.CLIENT)
   @Override
	public void appendHoverText(@Nonnull ItemStack stack, World world,@Nonnull List<ITextComponent> list,@Nonnull ITooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.RED + "Through Din, you can set the world ablaze"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Right-click to use"));
		list.add(new StringTextComponent(TextFormatting.GRAY + "Uses Magic on use"));
	}
}