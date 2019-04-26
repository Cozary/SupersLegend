package io.superworldsun.superslegend.items.tools;

import io.superworldsun.superslegend.SupersLegend;
import io.superworldsun.superslegend.init.ItemList;
import io.superworldsun.superslegend.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel{

	public ToolSword(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemList.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		SupersLegend.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
