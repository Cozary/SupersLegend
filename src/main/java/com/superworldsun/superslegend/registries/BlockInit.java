package com.superworldsun.superslegend.registries;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.blocks.*;

import com.superworldsun.superslegend.blocks.BushBlock;
import com.superworldsun.superslegend.blocks.natural.plants.DekuFlowerCrop;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SupersLegendMain.MOD_ID);

	//public static final RegistryObject<Block> CRACKED_FLOOR = BLOCKS.register("cracked_floor", () -> new CrackedFloor(PropertiesInit.WRECKAGE));
	//public static final RegistryObject<Block> QUICK_SAND = BLOCKS.register("quick_sand", () -> new QuickSand(PropertiesInit.QUICK_SAND));
	public static final RegistryObject<Block> RUPEE_BLOCK = BLOCKS.register("rupee_block", () ->
			new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(1).harvestTool(ToolType.PICKAXE).strength(2.0f,2.0f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BLUE_RUPEE_BLOCK = BLOCKS.register("blue_rupee_block", () ->
			new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(1).harvestTool(ToolType.PICKAXE).strength(2.0f,2.0f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> RED_RUPEE_BLOCK = BLOCKS.register("red_rupee_block", () ->
			new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(1).harvestTool(ToolType.PICKAXE).strength(2.0f,2.0f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> SILVER_RUPEE_BLOCK = BLOCKS.register("silver_rupee_block", () ->
			new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(1).harvestTool(ToolType.PICKAXE).strength(2.0f,2.0f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> GOLD_RUPEE_BLOCK = BLOCKS.register("gold_rupee_block", () ->
			new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(1).harvestTool(ToolType.PICKAXE).strength(2.0f,2.0f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> SPIKES_BLOCK = BLOCKS.register("spikes_block", () ->
			new SpikesBlock(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(13.0f,13.0f).sound(SoundType.METAL)));
	//public static final RegistryObject<Block> ANCIENT_TABLET = BLOCKS.register("ancient_tablet", () -> new AncientTablet(PropertiesInit.WRECKAGE));
	//public static final RegistryObject<Block> ANCIENT_TABLET_RUBBLE = BLOCKS.register("ancient_tablet_rubble", () -> new Block(PropertiesInit.WRECKAGE));
	//public static final RegistryObject<Block> ANCIENT_TABLET_BOMBOS = BLOCKS.register("ancient_tablet_bombos", () -> new AncientTablet(PropertiesInit.WRECKAGE));
	//public static final RegistryObject<Block> ANCIENT_TABLET_ETHER = BLOCKS.register("ancient_tablet_ether", () -> new AncientTablet(PropertiesInit.WRECKAGE));
	//public static final RegistryObject<Block> ANCIENT_TABLET_QUAKE = BLOCKS.register("ancient_tablet_quake", () -> new AncientTablet(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> GOSSIP_STONE_BLOCK = BLOCKS.register("gossip_stone_block", () ->
			new GossipStoneBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(11.0f,11.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GOSSIP_STONE_TOP = BLOCKS.register("gossip_stone_top", () ->
			new GossipStoneTopBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(11.0f,11.0f).sound(SoundType.STONE)));

	/*public static final RegistryObject<Block> SMALL_LOCK = BLOCKS.register("small_lock", () ->
			new SmallLock(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(5.0f,999.0f).sound(SoundType.METAL).noOcclusion()));
	public static final RegistryObject<Block> LOCKED_DOOR = BLOCKS.register("locked_door", () ->
			new LockedDoor(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(5.0f,999.0f).sound(SoundType.METAL)));*/
	public static final RegistryObject<Block> LOCKED_DOOR_TOP = BLOCKS.register("locked_door_top", () ->
			new LockedDoorTop(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(5.0f,999.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> DUNGEON_DOOR = BLOCKS.register("dungeon_door", () ->
			new DungeonDoor(AbstractBlock.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(5.0f,99.0f).sound(SoundType.METAL).noOcclusion()));
	public static final RegistryObject<Block> LOCKED_DUNGEON_DOOR = BLOCKS.register("locked_dungeon_door", () ->
			new LockedDungeonDoor(AbstractBlock.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(Float.MAX_VALUE,Float.MAX_VALUE).sound(SoundType.METAL).noOcclusion()));
	public static final RegistryObject<Block> BOSS_DOOR = BLOCKS.register("boss_door", () ->
			new DungeonDoor(AbstractBlock.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(5.0f,99.0f).sound(SoundType.METAL).noOcclusion()));
	public static final RegistryObject<Block> LOCKED_BOSS_DOOR = BLOCKS.register("locked_boss_door", () ->
			new LockedBossDoor(AbstractBlock.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(Float.MAX_VALUE,Float.MAX_VALUE).sound(SoundType.METAL).noOcclusion()));
	public static final RegistryObject<Block> LOCKED_WOODEN_DOOR = BLOCKS.register("locked_wooden_door", () ->
			new LockedWoodenDoor(AbstractBlock.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(Float.MAX_VALUE,Float.MAX_VALUE).sound(SoundType.METAL).noOcclusion()));
	public static final RegistryObject<Block> WOODEN_BOSS_DOOR = BLOCKS.register("wooden_boss_door", () ->
			new LockedWoodenBossDoor(AbstractBlock.Properties.of(Material.HEAVY_METAL).requiresCorrectToolForDrops().harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(Float.MAX_VALUE,Float.MAX_VALUE).sound(SoundType.METAL).noOcclusion()));

	public static final RegistryObject<Block> BUSH_BLOCK = BLOCKS.register("bush_block", () ->
			new BushBlock(AbstractBlock.Properties.of(Material.PLANT).harvestTool(ToolType.AXE).strength(0.1f,0.1f).sound(SoundType.CROP)));
	public static final RegistryObject<Block> CHAIN_LINK_FENCE_BLOCK = BLOCKS.register("chain_link_fence_block", () ->
			new ChainLinkFenceBlock(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0f,5.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> GRAPPLE_BLOCK = BLOCKS.register("grapple_block", () ->
			new Block(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(7.0f,7.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> DEKU_FLOWER_BLOCK = BLOCKS.register("deku_flower_block", () ->
			new DekuFlowerBlock(AbstractBlock.Properties.of(Material.PLANT).harvestLevel(0).harvestTool(ToolType.AXE).strength(0.5f,0.5f).sound(SoundType.CROP)));
	public static final RegistryObject<Block> YELLOW_DEKU_FLOWER_BLOCK = BLOCKS.register("yellow_deku_flower_block", () ->
			new DekuFlowerBlock(AbstractBlock.Properties.of(Material.PLANT).harvestLevel(0).harvestTool(ToolType.AXE).strength(0.5f,0.5f).sound(SoundType.CROP)));
	public static final RegistryObject<Block> POT_BLOCK = BLOCKS.register("pot_block", () ->
			new PotBlock(AbstractBlock.Properties.of(Material.CLAY).harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(0.1f,0.1f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> JAR_BLOCK = BLOCKS.register("jar_block", () ->
			new JarBlock(AbstractBlock.Properties.of(Material.CLAY).harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(0.1f,0.1f).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> POSTBOX_BLOCK = BLOCKS.register("postbox_block", () ->
			new PostboxBlock(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(1).harvestTool(ToolType.AXE).strength(2.0f,2.0f).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> POSTBOX_TOP = BLOCKS.register("postbox_top", () ->
			new PostboxTopBlock(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(1).harvestTool(ToolType.AXE).strength(2.0f,2.0f).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> GRATE_BLOCK = BLOCKS.register("grate_block", () ->
			new GrateBlock(AbstractBlock.Properties.of(Material.METAL).harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(6.0f,6.0f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> CRATE_BLOCK = BLOCKS.register("crate_block", () ->
			new CrateBlock(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).strength(4.0f,3.0f).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PUSH_STONE = BLOCKS.register("push_stone", () ->
			new PushStoneBlock(AbstractBlock.Properties.of(Material.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(6.0f,6.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
		public static final RegistryObject<Block> SILVER_PUSH_STONE = BLOCKS.register("silver_push_stone", () ->
			new SilverPushStoneBlock(AbstractBlock.Properties.of(Material.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(8.0f,25.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLACK_PUSH_STONE = BLOCKS.register("black_push_stone", () ->
			new BlackPushStoneBlock(AbstractBlock.Properties.of(Material.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE).strength(60.0f,1300.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final RegistryObject<Block> GRASS_PATCH_BLOCK = BLOCKS.register("grass_patch_block", () ->
			new GrassPatch(AbstractBlock.Properties.of(Material.PLANT).harvestLevel(0).strength(0.1f,0.1f).sound(SoundType.CROP)));
	public static final RegistryObject<Block> ODD_MUSHROOM = BLOCKS.register("odd_mushroom", () ->
			new OddMushroomBlock(AbstractBlock.Properties.of(Material.PLANT).sound(SoundType.GRASS).noOcclusion().instabreak().randomTicks()));
	public static final RegistryObject<Block> MAGIC_MUSHROOM = BLOCKS.register("magic_mushroom", () ->
			new MagicMushroomBlock(AbstractBlock.Properties.of(Material.PLANT).sound(SoundType.GRASS).noOcclusion().instabreak().randomTicks()));
	public static final RegistryObject<Block> TORCH_TOWER = BLOCKS.register("torch_tower", () ->
			new TorchTower(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD).harvestLevel(1).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> TORCH_TOWER_TOP_UNLIT = BLOCKS.register("torch_tower_top_unlit", () ->
			new TorchTowerTopUnlit(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD).harvestLevel(1).harvestTool(ToolType.AXE).noCollission()));
	public static final RegistryObject<Block> TORCH_TOWER_TOP_LIT = BLOCKS.register("torch_tower_top_lit", () ->
			new TorchTowerTopLit(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD).harvestLevel(1).harvestTool(ToolType.AXE).noCollission().lightLevel(value -> 15)));
	public static final RegistryObject<Block> MASTER_ORE_BLOCK = BLOCKS.register("master_ore_block", () ->
			new Block(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(3).harvestTool(ToolType.PICKAXE).strength(100.0f,400.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CRACKED_BOMB_WALL = BLOCKS.register("cracked_bomb_wall", () ->
			new CrackedBombWall(AbstractBlock.Properties.of(Material.STONE).strength(Float.MAX_VALUE, 0.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BLUE_FLOOR_SWITCH = BLOCKS.register("blue_floor_switch", () ->
			new BlueFloorSwitch(BlueFloorSwitch.SensitivityMod.PLAYER, AbstractBlock.Properties.of(Material.METAL).strength(3.5f, 5f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> YELLOW_FLOOR_SWITCH = BLOCKS.register("yellow_floor_switch", () ->
			new YellowFloorSwitch(YellowFloorSwitch.SensitivityMod.PLAYER, AbstractBlock.Properties.of(Material.METAL).strength(3.5f, 5f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> RED_FLOOR_SWITCH = BLOCKS.register("red_floor_switch", () ->
			new RedFloorSwitch(RedFloorSwitch.SensitivityMod.PLAYER, AbstractBlock.Properties.of(Material.METAL).strength(3.5f, 5f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> RUSTED_FLOOR_SWITCH = BLOCKS.register("rusted_floor_switch", () ->
			new RustedFloorSwitch(AbstractBlock.Properties.of(Material.METAL).strength(3.5f, 5f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> OAK_PEG_BLOCK = BLOCKS.register("oak_peg_block", () ->
			new WoodenPegOak(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SPRUCE_PEG_BLOCK = BLOCKS.register("spruce_peg_block", () ->
			new WoodenPegSpruce(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIRCH_PEG_BLOCK = BLOCKS.register("birch_peg_block", () ->
			new WoodenPegBirch(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> JUNGLE_PEG_BLOCK = BLOCKS.register("jungle_peg_block", () ->
			new WoodenPegJungle(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ACACIA_PEG_BLOCK = BLOCKS.register("acacia_peg_block", () ->
			new WoodenPegAcacia(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DARK_OAK_PEG_BLOCK = BLOCKS.register("dark_oak_peg_block", () ->
			new WoodenPegDarkOak(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUSTED_PEG_BLOCK = BLOCKS.register("rusted_peg_block", () ->
			new RustedPegBlock(AbstractBlock.Properties.of(Material.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> SPIKED_PEG_BLOCK = BLOCKS.register("spiked_peg_block", () ->
			new SpikedPegBlock(AbstractBlock.Properties.of(Material.WOOD).harvestLevel(2).harvestTool(ToolType.AXE).strength(80.0f,100.0f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_OAK = BLOCKS.register("hammered_wooden_peg_oak", () ->
			new HammeredWoodenPegOak(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_SPRUCE = BLOCKS.register("hammered_wooden_peg_spruce", () ->
			new HammeredWoodenPegSpruce(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_BIRCH = BLOCKS.register("hammered_wooden_peg_birch", () ->
			new HammeredWoodenPegBirch(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_JUNGLE = BLOCKS.register("hammered_wooden_peg_jungle", () ->
			new HammeredWoodenPegJungle(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_ACACIA = BLOCKS.register("hammered_wooden_peg_acacia", () ->
			new HammeredWoodenPegAcacia(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_DARK_OAK = BLOCKS.register("hammered_wooden_peg_dark_oak", () ->
			new HammeredWoodenPegDarkOak(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HAMMERED_RUSTED_PEG_BLOCK = BLOCKS.register("hammered_rusted_peg_block", () ->
			new HammeredRustedPegBlock(AbstractBlock.Properties.of(Material.METAL).strength(3.0F, 3.0F).sound(SoundType.METAL).harvestLevel(0).harvestTool(ToolType.PICKAXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HAMMERED_SPIKED_PEG_BLOCK = BLOCKS.register("hammered_spiked_peg_block", () ->
			new HammeredSpikedPegBlock(AbstractBlock.Properties.of(Material.WOOD).strength(3.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE).randomTicks().requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SHADOW_BLOCK = BLOCKS.register("shadow_block", () ->
			new ShadowBlock(AbstractBlock.Properties.of(Material.GLASS).noOcclusion().strength(4.0F, 3.0F).sound(SoundType.GLASS).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> FALSE_SHADOW_BLOCK = BLOCKS.register("false_shadow_block", () ->
			new FalseShadowBlock(AbstractBlock.Properties.of(Material.GLASS).noOcclusion().strength(4.0F, 3.0F).sound(SoundType.GLASS).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> HIDDEN_SHADOW_BLOCK = BLOCKS.register("hidden_shadow_block", () ->
			new HiddenShadowBlock(AbstractBlock.Properties.of(Material.GLASS).noOcclusion().strength(4.0F, 3.0F).sound(SoundType.GLASS).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SHADOW_MODEL_BLOCK = BLOCKS.register("shadow_model_block", ShadowModelBlock::new);
	public static final RegistryObject<Block> TOMBSTONE_BLOCK = BLOCKS.register("tombstone_block", () ->
			new TombstoneBlock(AbstractBlock.Properties.of(Material.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(3.0f,3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
	public static final RegistryObject<Block> STONE_PATH_BLOCK = BLOCKS.register("stone_path_block", () ->
			new StonePathBlock(AbstractBlock.Properties.of(Material.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(0.7f,0.7f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> STONE_TILE_BLOCK = BLOCKS.register("stone_tile_block", () ->
			new StoneTileBlock(AbstractBlock.Properties.of(Material.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE).strength(0.7f,0.7f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DINS_FLAME = BLOCKS.register("dins_flame", () ->
			new DinsFlame(AbstractBlock.Properties.of(Material.FIRE).lightLevel((state) -> 15).noOcclusion().noCollission().strength(Integer.MAX_VALUE, Integer.MAX_VALUE)));
	public static final RegistryObject<Block> FARORES_FLAME = BLOCKS.register("farores_flame", () ->
			new FaroresFlame(AbstractBlock.Properties.of(Material.FIRE).lightLevel((state) -> 15).noOcclusion().noCollission().strength(Integer.MAX_VALUE, Integer.MAX_VALUE)));
	public static final RegistryObject<Block> NAYRUS_FLAME = BLOCKS.register("nayrus_flame", () ->
			new NayrusFlame(AbstractBlock.Properties.of(Material.FIRE).lightLevel((state) -> 15).noOcclusion().noCollission().strength(Integer.MAX_VALUE, Integer.MAX_VALUE)));
	public static final RegistryObject<Block> DINS_SACRED_PEDESTAL = BLOCKS.register("dins_sacred_pedestal", () ->
			new DinsSacredPedestal(AbstractBlock.Properties.of(Material.METAL).strength(30F, 30F).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> 11)));
	public static final RegistryObject<Block> FARORES_SACRED_PEDESTAL = BLOCKS.register("farores_sacred_pedestal", () ->
			new FaroresSacredPedestal(AbstractBlock.Properties.of(Material.METAL).strength(30F, 30F).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> 11)));
	public static final RegistryObject<Block> NAYRUS_SACRED_PEDESTAL = BLOCKS.register("nayrus_sacred_pedestal", () ->
			new NayrusSacredPedestal(AbstractBlock.Properties.of(Material.METAL).strength(30F, 30F).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> 11)));
	public static final RegistryObject<Block> PEDESTAL = BLOCKS.register("pedestal", () ->
			new PedestalBlock(AbstractBlock.Properties.of(Material.STONE).strength(2.2F, 2.2F).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> FAN = BLOCKS.register("fan", () ->
			new FanBlock(AbstractBlock.Properties.of(Material.STONE).strength(7.0F, 10.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> SWITCHABLE_FAN = BLOCKS.register("switchable_fan", () ->
			new SwitchableFanBlock(AbstractBlock.Properties.of(Material.STONE).strength(7.0F, 10.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<FluidBlock> LIQUID_POISON = BLOCKS.register("liquid_poison", () -> new FluidBlock(FluidInit.POISON_SOURCE));
	public static final RegistryObject<FluidBlock> LIQUID_MUD = BLOCKS.register("liquid_mud", () -> new FluidBlock(FluidInit.MUD_SOURCE));
	public static final RegistryObject<Block> LIGHT_EMITTER = BLOCKS.register("light_emitter", LightEmitterBlock::new);
	public static final RegistryObject<Block> LIGHT_PRISM = BLOCKS.register("light_prism", LightPrismBlock::new);
	//public static final RegistryObject<Block> RIDGED_WALL_RAIL = BLOCKS.register("ridged_wall_rail", () -> new RidgedWallRail(AbstractBlock.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL)));

	/*public static final RegistryObject<Block> TALKING_TIMBER_PLANKS = BLOCKS.register("talking_timber_planks", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_SAPLING = BLOCKS.register("talking_timber_sapling", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_LOG = BLOCKS.register("talking_timber_log", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_STRIPPED_LOG = BLOCKS.register("talking_timber_stripped_log", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_STRIPPED_WOOD = BLOCKS.register("talking_timber_stripped_wood", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_WOOD = BLOCKS.register("talking_timber_wood", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_LEAVES = BLOCKS.register("talking_timber_leaves", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_SLAB = BLOCKS.register("talking_timber_slab", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_PLATE = BLOCKS.register("talking_timber_plate", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_FENCE = BLOCKS.register("talking_timber_fence", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_TRAPDOOR = BLOCKS.register("talking_timber_trapdoor", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_FENCE_GATE = BLOCKS.register("talking_timber_fence_gate", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_STAIRS = BLOCKS.register("talking_timber_stairs", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_BUTTON = BLOCKS.register("talking_timber_button", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_DOOR = BLOCKS.register("talking_timber_door", () -> new Block(PropertiesInit.WRECKAGE));
	public static final RegistryObject<Block> TALKING_TIMBER_SIGN = BLOCKS.register("talking_timber_sign", () -> new Block(PropertiesInit.WRECKAGE));*/
	public static final RegistryObject<Block> ROYAL_TILE = BLOCKS.register("royal_tile", () ->
			new RoyalTileBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(0.5f,0.5f)));
	public static final RegistryObject<Block> BLOCK_OF_TIME = BLOCKS.register("block_of_time", () ->
			new TimeBlock(AbstractBlock.Properties.of(Material.HEAVY_METAL).sound(SoundType.METAL).harvestLevel(3).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(30f,120F)));
	public static final RegistryObject<Block> OWL_STATUE = BLOCKS.register("owl_statue", () ->
			new OwlStatueBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(8f,8f)));
	//public static final RegistryObject<Block> COOKING_POT = BLOCKS.register("cooking_pot", CookingPotBlock::new);
	public static final RegistryObject<Block> SUN_SWITCH = BLOCKS.register("sun_switch", SunSwitchBlock::new);
	public static final RegistryObject<Block> WARP_PAD = BLOCKS.register("warp_pad", WarpPadBlock::new);
	public static final RegistryObject<WarpPadBlock> WARP_PAD_LIGHT = BLOCKS.register("warp_pad_light", WarpPadBlock::new);
	public static final RegistryObject<WarpPadBlock> WARP_PAD_FOREST = BLOCKS.register("warp_pad_forest", WarpPadBlock::new);
	public static final RegistryObject<WarpPadBlock> WARP_PAD_FIRE = BLOCKS.register("warp_pad_fire", WarpPadBlock::new);
	public static final RegistryObject<WarpPadBlock> WARP_PAD_WATER = BLOCKS.register("warp_pad_water", WarpPadBlock::new);
	public static final RegistryObject<WarpPadBlock> WARP_PAD_SPIRIT = BLOCKS.register("warp_pad_spirit", WarpPadBlock::new);
	public static final RegistryObject<WarpPadBlock> WARP_PAD_SHADOW = BLOCKS.register("warp_pad_shadow", WarpPadBlock::new);

	//Crops
	//TODO The growth stages of 2-6 have broken models where the models look fine but the textures are scrambled
	public static final RegistryObject<Block> DEKU_FLOWER_CROP = BLOCKS.register("deku_flower_crop",
				() -> new DekuFlowerCrop(AbstractBlock.Properties.copy(Blocks.WHEAT).randomTicks().instabreak()));

	//For cooking pot
	public static final RegistryObject<Block> COOKING_POT = BLOCKS.register("cooking_pot", () -> new SimpleCookingPotBlock());
}