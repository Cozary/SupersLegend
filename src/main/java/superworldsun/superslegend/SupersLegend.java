package superworldsun.superslegend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import superworldsun.superslegend.CustomLootMobs.CustomLootBlaze;
import superworldsun.superslegend.CustomLootMobs.CustomLootCavespider;
import superworldsun.superslegend.CustomLootMobs.CustomLootCreeper;
import superworldsun.superslegend.CustomLootMobs.CustomLootDragon;
import superworldsun.superslegend.CustomLootMobs.CustomLootDrowned;
import superworldsun.superslegend.CustomLootMobs.CustomLootElderguardian;
import superworldsun.superslegend.CustomLootMobs.CustomLootEnderman;
import superworldsun.superslegend.CustomLootMobs.CustomLootEndermite;
import superworldsun.superslegend.CustomLootMobs.CustomLootEvoker;
import superworldsun.superslegend.CustomLootMobs.CustomLootGhast;
import superworldsun.superslegend.CustomLootMobs.CustomLootGuardian;
import superworldsun.superslegend.CustomLootMobs.CustomLootHusk;
import superworldsun.superslegend.CustomLootMobs.CustomLootMagmacube;
import superworldsun.superslegend.CustomLootMobs.CustomLootPhantom;
import superworldsun.superslegend.CustomLootMobs.CustomLootPillager;
import superworldsun.superslegend.CustomLootMobs.CustomLootRavager;
import superworldsun.superslegend.CustomLootMobs.CustomLootShulker;
import superworldsun.superslegend.CustomLootMobs.CustomLootSilverfish;
import superworldsun.superslegend.CustomLootMobs.CustomLootSkeleton;
import superworldsun.superslegend.CustomLootMobs.CustomLootSlime;
import superworldsun.superslegend.CustomLootMobs.CustomLootSpider;
import superworldsun.superslegend.CustomLootMobs.CustomLootStray;
import superworldsun.superslegend.CustomLootMobs.CustomLootVindicator;
import superworldsun.superslegend.CustomLootMobs.CustomLootWitch;
import superworldsun.superslegend.CustomLootMobs.CustomLootWither;
import superworldsun.superslegend.CustomLootMobs.CustomLootWitherskeleton;
import superworldsun.superslegend.CustomLootMobs.CustomLootZombie;
import superworldsun.superslegend.CustomLootMobs.CustomLootZombievillager;
import superworldsun.superslegend.blocks.BushBlock;
import superworldsun.superslegend.blocks.ChainLinkFenceBlock;
import superworldsun.superslegend.blocks.DekuFlowerBlock;
import superworldsun.superslegend.blocks.GossipStoneBlock;
import superworldsun.superslegend.blocks.GrassPatch;
import superworldsun.superslegend.blocks.GrateBlock;
import superworldsun.superslegend.blocks.PotBlock;
import superworldsun.superslegend.blocks.SpikesBlock;
import superworldsun.superslegend.blocks.TorchTowerBlockBottom;
import superworldsun.superslegend.blocks.TorchTowerBlockTop;
import superworldsun.superslegend.fluids.FluidLiquid;
import superworldsun.superslegend.items.ArmorDarkEffects;
import superworldsun.superslegend.items.ArmorFlamebreakerEffects;
import superworldsun.superslegend.items.ArmorFlippersEffects;
import superworldsun.superslegend.items.ArmorGoronEffects;
import superworldsun.superslegend.items.ArmorKokiriEffects;
import superworldsun.superslegend.items.ArmorPurpleEffects;
import superworldsun.superslegend.items.ArmorZoraArmorEffects;
import superworldsun.superslegend.items.ArmorZoraEffects;
import superworldsun.superslegend.items.DinsFire;
import superworldsun.superslegend.items.FaroresWind;
import superworldsun.superslegend.items.GoldenScale;
import superworldsun.superslegend.items.HerosSecretStash;
import superworldsun.superslegend.items.HoverBoots;
import superworldsun.superslegend.items.IronBoots;
import superworldsun.superslegend.items.ItemCustomAxe;
import superworldsun.superslegend.items.ItemCustomBow;
import superworldsun.superslegend.items.ItemCustomHoe;
import superworldsun.superslegend.items.ItemCustomPickaxe;
import superworldsun.superslegend.items.ItemCustomSword;
import superworldsun.superslegend.items.MagicCape;
import superworldsun.superslegend.items.MagicMirror;
//import superworldsun.superslegend.items.MagneticGlove;
import superworldsun.superslegend.items.MaskAllnightmaskEffects;
import superworldsun.superslegend.items.MaskBlastmask;
import superworldsun.superslegend.items.MaskBunnyhoodEffects;
import superworldsun.superslegend.items.MaskCaptainshat;
import superworldsun.superslegend.items.MaskCouplesmask;
import superworldsun.superslegend.items.MaskDekumask;
import superworldsun.superslegend.items.MaskDongerosmaskEffects;
import superworldsun.superslegend.items.MaskFiercedeitysmask;
import superworldsun.superslegend.items.MaskGarosmask;
import superworldsun.superslegend.items.MaskGiantsmask;
import superworldsun.superslegend.items.MaskGibdomask;
import superworldsun.superslegend.items.MaskGoronmask;
import superworldsun.superslegend.items.MaskGreatfairymask;
import superworldsun.superslegend.items.MaskKafeismask;
import superworldsun.superslegend.items.MaskKamarosmask;
import superworldsun.superslegend.items.MaskKeatonmask;
import superworldsun.superslegend.items.MaskMajorasmask;
import superworldsun.superslegend.items.MaskMaskofTruth;
import superworldsun.superslegend.items.MaskMaskofscents;
import superworldsun.superslegend.items.MaskPostmanshat;
import superworldsun.superslegend.items.MaskRomanismask;
import superworldsun.superslegend.items.MaskStonemaskEffects;
import superworldsun.superslegend.items.MaskTroupeleadersmask;
import superworldsun.superslegend.items.MaskZoramask;
import superworldsun.superslegend.items.MaskBremenmask;
import superworldsun.superslegend.items.MoonPearl;
import superworldsun.superslegend.items.NayrusLove;
import superworldsun.superslegend.items.PegasusBoots;
import superworldsun.superslegend.items.RocsCapeEffects;
import superworldsun.superslegend.items.RocsFeather;
import superworldsun.superslegend.items.SilverScale;
import superworldsun.superslegend.items.TorchTower;
import superworldsun.superslegend.items.Triforce;
import superworldsun.superslegend.items.TriforceCourage;
import superworldsun.superslegend.items.TriforcePower;
import superworldsun.superslegend.items.TriforceWisdom;
import superworldsun.superslegend.lists.BlockList;
import superworldsun.superslegend.lists.ItemList;
import superworldsun.superslegend.lists.ToolMaterialList;
import superworldsun.superslegend.world.gen.OreGeneration;

@Mod("superslegend")
public class SupersLegend 
{
	public static SupersLegend istance;
	public static final String modid = "superslegend";
	private static final Logger Logger = LogManager.getLogger(modid);
	
	public static final ItemGroup supers_legend = new SupersLegendItemGroup();
	
	
	public SupersLegend() 
	{
		istance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		//Custom Loot Drops
				CustomLootZombie customLootZombie = new CustomLootZombie();
				MinecraftForge.EVENT_BUS.register(customLootZombie);
				
				CustomLootSkeleton customLootSkeleton = new CustomLootSkeleton();
				MinecraftForge.EVENT_BUS.register(customLootSkeleton);
				
				CustomLootSpider customLootSpider = new CustomLootSpider();
				MinecraftForge.EVENT_BUS.register(customLootSpider);
				
				CustomLootSlime customLootSlime = new CustomLootSlime();
				MinecraftForge.EVENT_BUS.register(customLootSlime);
				
				CustomLootCreeper customLootCreeper = new CustomLootCreeper();
				MinecraftForge.EVENT_BUS.register(customLootCreeper);
				
				CustomLootSilverfish customLootSilverfish = new CustomLootSilverfish();
				MinecraftForge.EVENT_BUS.register(customLootSilverfish);
				
				CustomLootPhantom customLootPhantom = new CustomLootPhantom();
				MinecraftForge.EVENT_BUS.register(customLootPhantom);
				
				CustomLootEnderman customLootEnderman = new CustomLootEnderman();
				MinecraftForge.EVENT_BUS.register(customLootEnderman);
				
				CustomLootCavespider customLootCavespider = new CustomLootCavespider();
				MinecraftForge.EVENT_BUS.register(customLootCavespider);
				
				CustomLootBlaze customLootBlaze = new CustomLootBlaze();
				MinecraftForge.EVENT_BUS.register(customLootBlaze);
				
				CustomLootGhast customLootGhast = new CustomLootGhast();
				MinecraftForge.EVENT_BUS.register(customLootGhast);
				
				CustomLootWitch customLootWitch = new CustomLootWitch();
				MinecraftForge.EVENT_BUS.register(customLootWitch);
				
				CustomLootWitherskeleton customLootWitherskeleton = new CustomLootWitherskeleton();
				MinecraftForge.EVENT_BUS.register(customLootWitherskeleton);
				
				CustomLootMagmacube customLootMagmacube = new CustomLootMagmacube();
				MinecraftForge.EVENT_BUS.register(customLootMagmacube);
				
				CustomLootDrowned customLootDrowned = new CustomLootDrowned();
				MinecraftForge.EVENT_BUS.register(customLootDrowned);
				
				CustomLootGuardian customLootGuardian = new CustomLootGuardian();
				MinecraftForge.EVENT_BUS.register(customLootGuardian);
				
				CustomLootElderguardian customLootElderguardian = new CustomLootElderguardian();
				MinecraftForge.EVENT_BUS.register(customLootElderguardian);
				
				CustomLootEndermite customLootEdermite = new CustomLootEndermite();
				MinecraftForge.EVENT_BUS.register(customLootEdermite);
				
				CustomLootShulker customLootShulker = new CustomLootShulker();
				MinecraftForge.EVENT_BUS.register(customLootShulker);
				
				CustomLootDragon customLootDragon = new CustomLootDragon();
				MinecraftForge.EVENT_BUS.register(customLootDragon);
				
				CustomLootWither customLootWither = new CustomLootWither();
				MinecraftForge.EVENT_BUS.register(customLootWither);
				
				CustomLootEvoker customLootEvoker = new CustomLootEvoker();
				MinecraftForge.EVENT_BUS.register(customLootEvoker);
				
				CustomLootStray customLootStray = new CustomLootStray();
				MinecraftForge.EVENT_BUS.register(customLootStray);
				
				CustomLootHusk customLootHusk = new CustomLootHusk();
				MinecraftForge.EVENT_BUS.register(customLootHusk);
				
				CustomLootZombievillager customLootZombievillager = new CustomLootZombievillager();
				MinecraftForge.EVENT_BUS.register(customLootZombievillager);
				
				CustomLootPillager customLootPillager = new CustomLootPillager();
				MinecraftForge.EVENT_BUS.register(customLootPillager);
				
				CustomLootRavager customLootRavager = new CustomLootRavager();
				MinecraftForge.EVENT_BUS.register(customLootRavager);
				
				CustomLootVindicator CustomLootVindicator = new CustomLootVindicator();
				MinecraftForge.EVENT_BUS.register(CustomLootVindicator);
		
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreWorldGen();
		Logger.info("Setup method registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		Logger.info("ClientRegistries method registered");
	}
	

	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(	
		//Items
					
			ItemList.rupee = new Item(new Item.Properties().group(supers_legend)).setRegistryName(location("rupee")),
			ItemList.blue_rupee = new Item(new Item.Properties().group(supers_legend)).setRegistryName(location("blue_rupee")),
			ItemList.red_rupee = new Item(new Item.Properties().group(supers_legend)).setRegistryName(location("red_rupee")),
			ItemList.orange_rupee = new Item(new Item.Properties().group(supers_legend)).setRegistryName(location("orange_rupee")),
			ItemList.triforce_power_shard = new Item(new Item.Properties().maxStackSize(7).group(supers_legend)).setRegistryName(location("triforce_power_shard")),
			ItemList.triforce_wisdom_shard = new Item(new Item.Properties().maxStackSize(7).group(supers_legend)).setRegistryName(location("triforce_wisdom_shard")),
			ItemList.triforce_courage_shard = new Item(new Item.Properties().maxStackSize(7).group(supers_legend)).setRegistryName(location("triforce_courage_shard")),
			ItemList.rupee_pouch = new Item(new Item.Properties().maxStackSize(1)).setRegistryName(location("rupee_pouch")),
			ItemList.odolwas_remains = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("odolwas_remains")),
			ItemList.gohts_remains = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("gohts_remains")),
			ItemList.gyorgs_remains = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("gyorgs_remains")),
			ItemList.twinmolds_remains = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("twinmolds_remains")),
			ItemList.master_ore = new Item(new Item.Properties().maxStackSize(16).group(supers_legend)).setRegistryName(location("master_ore")),
			ItemList.master_sword_blade = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("master_sword_blade")),
			ItemList.master_sword_hilt = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("master_sword_hilt")),
			
		//Block Items
			
			ItemList.rupee_block = new BlockItem(BlockList.rupee_block, new Item.Properties().maxStackSize(5).group(supers_legend)).setRegistryName(BlockList.rupee_block.getRegistryName()),
			ItemList.blue_rupee_block = new BlockItem(BlockList.blue_rupee_block, new Item.Properties().maxStackSize(5).group(supers_legend)).setRegistryName(BlockList.blue_rupee_block.getRegistryName()),
			ItemList.red_rupee_block = new BlockItem(BlockList.red_rupee_block, new Item.Properties().maxStackSize(5).group(supers_legend)).setRegistryName(BlockList.red_rupee_block.getRegistryName()),
			ItemList.orange_rupee_block = new BlockItem(BlockList.orange_rupee_block, new Item.Properties().maxStackSize(5).group(supers_legend)).setRegistryName(BlockList.orange_rupee_block.getRegistryName()),
			ItemList.spikes_block = new BlockItem(BlockList.spikes_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.spikes_block.getRegistryName()),
			ItemList.gossip_stone_block = new BlockItem(BlockList.gossip_stone_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.gossip_stone_block.getRegistryName()),
			ItemList.bush_block = new BlockItem(BlockList.bush_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.bush_block.getRegistryName()),
			ItemList.chain_link_fence_block = new BlockItem(BlockList.chain_link_fence_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.chain_link_fence_block.getRegistryName()),
			ItemList.deku_flower_block = new BlockItem(BlockList.deku_flower_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.deku_flower_block.getRegistryName()),
			ItemList.pot_block = new BlockItem(BlockList.pot_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.pot_block.getRegistryName()),
			ItemList.grate_block = new BlockItem(BlockList.grate_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.grate_block.getRegistryName()),
			ItemList.grass_patch_block = new BlockItem(BlockList.grass_patch_block, new Item.Properties().group(supers_legend)).setRegistryName(BlockList.grass_patch_block.getRegistryName()),
			ItemList.torch_tower = new TorchTower(new Item.Properties().maxStackSize(16).group(supers_legend)).setRegistryName(location("torch_tower")),
			ItemList.master_ore_block = new BlockItem(BlockList.master_ore_block, new Item.Properties().maxStackSize(64).group(supers_legend)).setRegistryName(BlockList.master_ore_block.getRegistryName()),
			
		//Weapons
			
			ItemList.kokiri_sword = new ItemCustomSword(ToolMaterialList.kokiri_sword,		(int) 2, -2.3f, new Item.Properties().group(supers_legend)).setRegistryName(location("kokiri_sword")),
			ItemList.razor_sword = new ItemCustomSword(ToolMaterialList.razor_sword, 			(int) 2, -2.5f, new Item.Properties().group(supers_legend)).setRegistryName(location("razor_sword")),
			ItemList.gilded_sword = new ItemCustomSword(ToolMaterialList.gilded_sword, 		(int) 2, -2.4f, new Item.Properties().group(supers_legend)).setRegistryName(location("gilded_sword")),
			ItemList.master_sword = new ItemCustomSword(ToolMaterialList.master_sword,		(int) 2, -2.3f, new Item.Properties().group(supers_legend)).setRegistryName(location("master_sword")),
			ItemList.heros_bow = new ItemCustomBow(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("heros_bow")),
			ItemList.hylian_shield = new ShieldItem(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("hylian_shield")),
			
			ItemList.moon_pearl = new MoonPearl(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("moon_pearl")),
			ItemList.heros_secret_stash = new HerosSecretStash(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("heros_secret_stash")),
			ItemList.book_of_mudora = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("book_of_mudora")),
			ItemList.silver_scale = new SilverScale(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("silver_scale")),
			ItemList.golden_scale = new GoldenScale(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("golden_scale")),
			ItemList.rocs_feather = new RocsFeather(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("rocs_feather")),
			ItemList.magic_mirror = new MagicMirror(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("magic_mirror")),
			ItemList.magic_cape = new MagicCape(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("magic_cape")),
			ItemList.empty_container = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("empty_container")),
			ItemList.farores_wind = new FaroresWind(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("farores_wind")),
			ItemList.dins_fire = new DinsFire(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("dins_fire")),
			ItemList.nayrus_love = new NayrusLove(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("nayrus_love")),
			//ItemList.magnetic_glove = new MagneticGlove(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("magnetic_glove")),
			ItemList.triforce = new Triforce(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("triforce")),
			ItemList.triforce_power = new TriforcePower(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("triforce_power")),
			ItemList.triforce_wisdom = new TriforceWisdom(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("triforce_wisdom")),
			ItemList.triforce_courage = new TriforceCourage(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("triforce_courage")),
		//Tools
			ItemList.rupee_sword = new ItemCustomSword(ToolMaterialList.rupee_sword, 				(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("rupee_sword")),
			ItemList.blue_rupee_sword = new ItemCustomSword(ToolMaterialList.blue_rupee_sword, 	(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("blue_rupee_sword")),
			ItemList.red_rupee_sword = new ItemCustomSword(ToolMaterialList.red_rupee_sword, 		(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("red_rupee_sword")),
			ItemList.orange_rupee_sword = new ItemCustomSword(ToolMaterialList.orange_rupee_sword,(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("orange_rupee_sword")),
			
			ItemList.rupee_pickaxe = new ItemCustomPickaxe(ToolMaterialList.rupee_pickaxe, 				(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("rupee_pickaxe")),
			ItemList.blue_rupee_pickaxe = new ItemCustomPickaxe(ToolMaterialList.blue_rupee_pickaxe, 	(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("blue_rupee_pickaxe")),
			ItemList.red_rupee_pickaxe = new ItemCustomPickaxe(ToolMaterialList.red_rupee_pickaxe, 		(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("red_rupee_pickaxe")),
			ItemList.orange_rupee_pickaxe = new ItemCustomPickaxe(ToolMaterialList.orange_rupee_pickaxe,(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("orange_rupee_pickaxe")),
			
			ItemList.rupee_axe = new ItemCustomAxe(ToolMaterialList.rupee_axe, 						(int) 0, -3.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("rupee_axe")),
			ItemList.blue_rupee_axe = new ItemCustomAxe(ToolMaterialList.blue_rupee_axe, 			(int) 0, -3.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("blue_rupee_axe")),
			ItemList.red_rupee_axe = new ItemCustomAxe(ToolMaterialList.red_rupee_axe, 				(int) 0, -3.1f, new Item.Properties().group(supers_legend)).setRegistryName(location("red_rupee_axe")),
			ItemList.orange_rupee_axe = new ItemCustomAxe(ToolMaterialList.orange_rupee_axe, 		(int) 0, -3.1f, new Item.Properties().group(supers_legend)).setRegistryName(location("orange_rupee_axe")),
			
			ItemList.rupee_shovel = new ShovelItem(ToolMaterialList.rupee_shovel, 				(int) 0, -2.8f, new Item.Properties().group(supers_legend)).setRegistryName(location("rupee_shovel")),
			ItemList.blue_rupee_shovel = new ShovelItem(ToolMaterialList.blue_rupee_shovel, 	(int) 0, -2.8f, new Item.Properties().group(supers_legend)).setRegistryName(location("blue_rupee_shovel")),
			ItemList.red_rupee_shovel = new ShovelItem(ToolMaterialList.red_rupee_shovel, 		(int) 0, -2.6f, new Item.Properties().group(supers_legend)).setRegistryName(location("red_rupee_shovel")),
			ItemList.orange_rupee_shovel = new ShovelItem(ToolMaterialList.orange_rupee_shovel,	(int) 0, -2.6f, new Item.Properties().group(supers_legend)).setRegistryName(location("orange_rupee_shovel")),
			
			ItemList.rupee_hoe = new ItemCustomHoe(ToolMaterialList.rupee_hoe, 				(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("rupee_hoe")),
			ItemList.blue_rupee_hoe = new ItemCustomHoe(ToolMaterialList.blue_rupee_hoe, 	(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("blue_rupee_hoe")),
			ItemList.red_rupee_hoe = new ItemCustomHoe(ToolMaterialList.red_rupee_hoe, 		(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("red_rupee_hoe")),
			ItemList.orange_rupee_hoe = new ItemCustomHoe(ToolMaterialList.orange_rupee_hoe,(int) 0, -2.2f, new Item.Properties().group(supers_legend)).setRegistryName(location("orange_rupee_hoe")),
			
		//Masks
			ItemList.mask_clay = new Item(new Item.Properties().maxStackSize(1).group(supers_legend)).setRegistryName(location("mask_clay")),
			ItemList.mask_postmanshat = new MaskPostmanshat("mask_postmanshat", EquipmentSlotType.HEAD),
			ItemList.mask_allnightmask = new MaskAllnightmaskEffects("mask_allnightmask", EquipmentSlotType.HEAD),
			ItemList.mask_blastmask = new MaskBlastmask("mask_blastmask", EquipmentSlotType.HEAD),
			ItemList.mask_stonemask = new MaskStonemaskEffects("mask_stonemask", EquipmentSlotType.HEAD),
			ItemList.mask_bremenmask = new MaskBremenmask("mask_bremenmask", EquipmentSlotType.HEAD),
			ItemList.mask_greatfairymask = new MaskGreatfairymask("mask_greatfairymask", EquipmentSlotType.HEAD),
			ItemList.mask_dekumask = new MaskDekumask("mask_dekumask", EquipmentSlotType.HEAD),
			ItemList.mask_keatonmask = new MaskKeatonmask("mask_keatonmask", EquipmentSlotType.HEAD),
			ItemList.mask_bunnyhood = new MaskBunnyhoodEffects("mask_bunnyhood", EquipmentSlotType.HEAD),
			ItemList.mask_dongerosmask = new MaskDongerosmaskEffects("mask_dongerosmask", EquipmentSlotType.HEAD),
			ItemList.mask_maskofscents = new MaskMaskofscents("mask_maskofscents", EquipmentSlotType.HEAD),
			ItemList.mask_goronmask = new MaskGoronmask("mask_goronmask", EquipmentSlotType.HEAD),
			ItemList.mask_romanismask = new MaskRomanismask("mask_romanismask", EquipmentSlotType.HEAD),
			ItemList.mask_troupeleadersmask = new MaskTroupeleadersmask("mask_troupeleadersmask", EquipmentSlotType.HEAD),
			ItemList.mask_kafeismask = new MaskKafeismask("mask_kafeismask", EquipmentSlotType.HEAD),
			ItemList.mask_couplesmask = new MaskCouplesmask("mask_couplesmask", EquipmentSlotType.HEAD),
			ItemList.mask_maskoftruth = new MaskMaskofTruth("mask_maskoftruth", EquipmentSlotType.HEAD),
			ItemList.mask_zoramask = new MaskZoramask("mask_zoramask", EquipmentSlotType.HEAD),
			ItemList.mask_kamarosmask = new MaskKamarosmask("mask_kamarosmask", EquipmentSlotType.HEAD),
			ItemList.mask_gibdomask = new MaskGibdomask("mask_gibdomask", EquipmentSlotType.HEAD),
			ItemList.mask_garosmask = new MaskGarosmask("mask_garosmask", EquipmentSlotType.HEAD),
			ItemList.mask_captainshat = new MaskCaptainshat("mask_captainshat", EquipmentSlotType.HEAD),
			ItemList.mask_giantsmask = new MaskGiantsmask("mask_giantsmask", EquipmentSlotType.HEAD),
			ItemList.mask_fiercedeitysmask = new MaskFiercedeitysmask("mask_fiercedeitysmask", EquipmentSlotType.HEAD),
			ItemList.mask_majorasmask = new MaskMajorasmask("mask_majorasmask",EquipmentSlotType.HEAD),
			
		//Armors
			ItemList.rocs_cape = new RocsCapeEffects("rocs_cape",EquipmentSlotType.CHEST),
			ItemList.kokiri_cap = new ArmorKokiriEffects("kokiri_cap",EquipmentSlotType.HEAD),
			ItemList.kokiri_tunic = new ArmorKokiriEffects("kokiri_tunic",EquipmentSlotType.CHEST),
			ItemList.kokiri_leggings = new ArmorKokiriEffects("kokiri_leggings",EquipmentSlotType.LEGS),
			ItemList.kokiri_boots = new ArmorKokiriEffects("kokiri_boots",EquipmentSlotType.FEET),
			ItemList.zora_cap = new ArmorZoraEffects("zora_cap", EquipmentSlotType.HEAD),
			ItemList.zora_tunic = new ArmorZoraEffects("zora_tunic", EquipmentSlotType.CHEST),
			ItemList.zora_leggings = new ArmorZoraEffects("zora_leggings", EquipmentSlotType.LEGS),
			ItemList.iron_boots = new IronBoots("iron_boots", EquipmentSlotType.FEET),
			
			ItemList.zoras_flippers = new ArmorFlippersEffects("zoras_flippers", EquipmentSlotType.FEET),
			
			ItemList.goron_cap = new ArmorGoronEffects("goron_cap", EquipmentSlotType.HEAD),
			ItemList.goron_tunic = new ArmorGoronEffects("goron_tunic", EquipmentSlotType.CHEST),
			ItemList.goron_leggings = new ArmorGoronEffects("goron_leggings", EquipmentSlotType.LEGS),
			ItemList.hover_boots = new HoverBoots("hover_boots", EquipmentSlotType.FEET),

			ItemList.purple_cap = new ArmorPurpleEffects("purple_cap",EquipmentSlotType.HEAD),
			ItemList.purple_tunic = new ArmorPurpleEffects("purple_tunic",EquipmentSlotType.CHEST),
			ItemList.purple_leggings = new ArmorPurpleEffects("purple_leggings",EquipmentSlotType.LEGS),
			ItemList.pegasus_boots = new PegasusBoots("pegasus_boots",EquipmentSlotType.FEET),
			
			ItemList.dark_cap = new ArmorDarkEffects("dark_cap",EquipmentSlotType.HEAD),
			ItemList.dark_tunic = new ArmorDarkEffects("dark_tunic",EquipmentSlotType.CHEST),
			ItemList.dark_leggings = new ArmorDarkEffects("dark_leggings",EquipmentSlotType.LEGS),
			ItemList.dark_boots = new ArmorDarkEffects("dark_boots",EquipmentSlotType.FEET),
			
			ItemList.zora_armor_cap = new ArmorZoraArmorEffects("zora_armor_cap",EquipmentSlotType.HEAD),
			ItemList.zora_armor_tunic = new ArmorZoraArmorEffects("zora_armor_tunic",EquipmentSlotType.CHEST),
			ItemList.zora_armor_leggings = new ArmorZoraArmorEffects("zora_armor_leggings",EquipmentSlotType.LEGS),
			ItemList.zora_armor_flippers = new ArmorZoraArmorEffects("zora_armor_flippers",EquipmentSlotType.FEET),
			
			ItemList.flamebreaker_helmet = new ArmorFlamebreakerEffects("flamebreaker_helmet",EquipmentSlotType.HEAD),
			ItemList.flamebreaker_tunic = new ArmorFlamebreakerEffects("flamebreaker_tunic",EquipmentSlotType.CHEST),
			ItemList.flamebreaker_leggings = new ArmorFlamebreakerEffects("flamebreaker_leggings",EquipmentSlotType.LEGS),
			ItemList.flamebreaker_boots = new ArmorFlamebreakerEffects("flamebreaker_boots",EquipmentSlotType.FEET)
			
			
			);
			Logger.info("Items registered.");		
		}
		
		
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(	
				//Blocks
					
					BlockList.rupee_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 1.0f).lightValue(0).sound(SoundType.GLASS)).setRegistryName(location("rupee_block")),
					BlockList.blue_rupee_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 1.0f).lightValue(0).sound(SoundType.GLASS)).setRegistryName(location("blue_rupee_block")),
					BlockList.red_rupee_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 1.0f).lightValue(0).sound(SoundType.GLASS)).setRegistryName(location("red_rupee_block")),
					BlockList.orange_rupee_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 1.0f).lightValue(0).sound(SoundType.GLASS)).setRegistryName(location("orange_rupee_block")),
					BlockList.spikes_block = new SpikesBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(13.0f, 13.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("spikes_block")),
					BlockList.gossip_stone_block = new GossipStoneBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f, 1.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("gossip_stone_block")),
					BlockList.bush_block = new BushBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f, 0.0f).lightValue(0).sound(SoundType.CROP)).setRegistryName(location("bush_block")),
					BlockList.chain_link_fence_block = new ChainLinkFenceBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("chain_link_fence_block")),
					BlockList.torch_tower_block_bottom = new TorchTowerBlockBottom(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.8f, 0.8f).lightValue(0).sound(SoundType.WOOD)).setRegistryName(location("torch_tower_block_bottom")),
					BlockList.torch_tower_block_top = new TorchTowerBlockTop(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.8f, 0.8f).lightValue(15).sound(SoundType.WOOD)).setRegistryName(location("torch_tower_block_top")),
					BlockList.deku_flower_block = new DekuFlowerBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.4f, 0.4f).lightValue(0).sound(SoundType.CROP)).setRegistryName(location("deku_flower_block")),
					BlockList.pot_block = new PotBlock(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.1f, 0.1f).lightValue(0).sound(SoundType.GLASS)).setRegistryName(location("pot_block")),
					BlockList.grate_block = new GrateBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("grate_block")),
					BlockList.grass_patch_block = new GrassPatch(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f, 0.2f).lightValue(0).sound(SoundType.SWEET_BERRY_BUSH)).setRegistryName(location("grass_patch_block")),
					BlockList.master_ore_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(100.0f, 400.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("master_ore_block"))
			);
			Logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
		
		 public void onFluidRegistry(final RegistryEvent.Register<Fluid> event) 
		 {
		        IForgeRegistry<Fluid> registry = event.getRegistry();

		        FluidLiquid.register(registry);
		 }
	}
}