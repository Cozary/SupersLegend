package com.superworldsun.superslegend.blocks.natural.plants;

import com.superworldsun.superslegend.registries.BlockInit;
import com.superworldsun.superslegend.registries.ItemInit;
import net.minecraft.block.*;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class DekuFlowerCrop extends CropsBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 2.0D, 12.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 3.0D, 12.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 5.0D, 12.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 11.0D, 13.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D)};

    public DekuFlowerCrop(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        return p_200014_1_.is(Blocks.GRASS_BLOCK);
    }

    protected IItemProvider getSeedsItem() {
        return ItemInit.DEKU_SEEDS.get();
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
    }


    //TODO dosent seem to work at all. I want to make it so when the crop grows to its max stage the crop turns into a deku flower block
    /*public void tick(BlockState state, World world, BlockPos pos, Random random) {
        super.tick(state, (ServerWorld) world, pos, random);
        if (state.getValue(AGE) == 7) {
            BlockState flowerState = BlockInit.DEKU_FLOWER_BLOCK.get().defaultBlockState();
            world.setBlock(pos, flowerState,3);
        }
    }*/
    
    @Override
    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos)
    {
        return !world.isEmptyBlock(pos.below()) && (world.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)
                || (world.getBlockState(pos.below()).is(Blocks.DIRT) || (world.getBlockState(pos.below()).is(Blocks.COARSE_DIRT))));
    }
}