package com.superworldsun.superslegend.items.ammobags;

import java.util.List;

import javax.annotation.Nullable;

import com.superworldsun.superslegend.registries.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BombBagItem extends AmmoContainerItem
{
	public BombBagItem(int capacity)
	{
		super(capacity);
	}
	
	@Override
	public boolean canHoldItem(ItemStack itemStack)
	{
		return itemStack.getItem() == ItemInit.BOMB.get();
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if (getContents(stack) != null && getContents(stack) != null)
		{
			tooltip.add(new StringTextComponent(TextFormatting.AQUA + getContents(stack).getRight().toString()));
			tooltip.add(new StringTextComponent(TextFormatting.WHITE + getContents(stack).getLeft().getHoverName().getString()));
			tooltip.add(new StringTextComponent(TextFormatting.YELLOW + "Right click to get bombs."));
		}
	}
}