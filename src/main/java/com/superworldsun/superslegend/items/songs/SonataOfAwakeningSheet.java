package com.superworldsun.superslegend.items.songs;

import java.util.List;

import com.superworldsun.superslegend.registries.OcarinaSongInit;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class SonataOfAwakeningSheet extends SongSheetItem
{
	public SonataOfAwakeningSheet()
	{
		super(OcarinaSongInit.SONATA_OF_AWAKENING);
	}
	
	@Override
	protected void addSongDescription(List<ITextComponent> list)
	{
		list.add(new StringTextComponent(TextFormatting.GRAY + "Playing this will wake the heaviest of sleepers"));
	}
}