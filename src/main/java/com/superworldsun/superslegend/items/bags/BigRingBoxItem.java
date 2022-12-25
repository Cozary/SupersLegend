package com.superworldsun.superslegend.items.bags;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.container.BigRingBoxContainer;
import com.superworldsun.superslegend.items.RingItem;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class BigRingBoxItem extends BagItem
{
	public BigRingBoxItem()
	{
		super(new Properties().tab(SupersLegendMain.RESOURCES));
	}
	
	@Override
	public Container getContainer(int windowId, PlayerInventory playerInventory, PlayerEntity player, Hand hand)
	{
		return new BigRingBoxContainer(windowId, player.inventory, hand);
	}
	
	@Override
	public boolean canHoldItem(ItemStack stack)
	{
		return stack.getItem() instanceof RingItem;
	}
}