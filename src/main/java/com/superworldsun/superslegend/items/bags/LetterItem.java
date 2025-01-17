package com.superworldsun.superslegend.items.bags;

import com.superworldsun.superslegend.container.bag.LetterContainer;
import com.superworldsun.superslegend.registries.ItemGroupInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class LetterItem extends BagItem
{
	public LetterItem()
	{
		super(new Properties().tab(ItemGroupInit.RESOURCES));
	}
	
	@Override
	public Container createContainer(int windowId, PlayerInventory playerInventory, PlayerEntity player, Hand hand)
	{
		return new LetterContainer(windowId, player.inventory, hand);
	}

	@Override
	public boolean canHoldItem(ItemStack stack)
	{
		return true;
	}
}
