package superworldsun.superslegend.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superworldsun.superslegend.lists.ItemList;

import java.util.Random;

public class NayrusFlame extends Block {
	private Object ItemEntity;

	public NayrusFlame(Properties properties) {
		super(properties);
		this.fireDamage = 0;
	}

	private final float fireDamage;
																									//  16        1         16
	protected static final VoxelShape shapeDown = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

																								//0,        0,            0
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return shapeDown;
	}

	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}


	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return this.isValidPosition(stateIn, worldIn, currentPos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return !worldIn.isAirBlock(pos.down());
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entity) {

		if(entity instanceof ItemEntity) {
			ItemEntity itemEntity = (ItemEntity) entity;
			ItemStack stack = itemEntity.getItem();
			ItemStack newsword = new ItemStack(ItemList.master_sword_n);
			ItemEntity sword = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), newsword);
			if(stack.getItem() == ItemList.master_sword_v2) {
				stack.getAttachedEntity().remove();
				worldIn.addEntity(sword);
			}else {
				itemEntity.setPositionAndUpdate(itemEntity.lastTickPosX + ((worldIn.rand.nextDouble() * 2D) - 1D), itemEntity.lastTickPosY + ((worldIn.rand.nextDouble() * 4D) - 2D), itemEntity.lastTickPosZ + ((worldIn.rand.nextDouble() * 2D) - 1D));
			}
		}

		if(entity instanceof ItemEntity) {
			ItemEntity itemEntity = (ItemEntity) entity;
			ItemStack stack = itemEntity.getItem();
			ItemStack newsword = new ItemStack(ItemList.master_sword_dn);
			ItemEntity sword = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), newsword);
			if(stack.getItem() == ItemList.master_sword_d) {
				stack.getAttachedEntity().remove();
				worldIn.addEntity(sword);
			}else {
				itemEntity.setPositionAndUpdate(itemEntity.lastTickPosX + ((worldIn.rand.nextDouble() * 2D) - 1D), itemEntity.lastTickPosY + ((worldIn.rand.nextDouble() * 4D) - 2D), itemEntity.lastTickPosZ + ((worldIn.rand.nextDouble() * 2D) - 1D));
			}
		}

		if(entity instanceof ItemEntity) {
			ItemEntity itemEntity = (ItemEntity) entity;
			ItemStack stack = itemEntity.getItem();
			ItemStack newsword = new ItemStack(ItemList.master_sword_nf);
			ItemEntity sword = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), newsword);
			if(stack.getItem() == ItemList.master_sword_f) {
				stack.getAttachedEntity().remove();
				worldIn.addEntity(sword);
			}else {
				itemEntity.setPositionAndUpdate(itemEntity.lastTickPosX + ((worldIn.rand.nextDouble() * 2D) - 1D), itemEntity.lastTickPosY + ((worldIn.rand.nextDouble() * 4D) - 2D), itemEntity.lastTickPosZ + ((worldIn.rand.nextDouble() * 2D) - 1D));
			}
		}

		if(entity instanceof ItemEntity) {
			ItemEntity itemEntity = (ItemEntity) entity;
			ItemStack stack = itemEntity.getItem();
			ItemStack newsword = new ItemStack(ItemList.true_master_sword);
			ItemEntity sword = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), newsword);
			if(stack.getItem() == ItemList.master_sword_fd) {
				stack.getAttachedEntity().remove();
				worldIn.addEntity(sword);
			}else {
				itemEntity.setPositionAndUpdate(itemEntity.lastTickPosX + ((worldIn.rand.nextDouble() * 2D) - 1D), itemEntity.lastTickPosY + ((worldIn.rand.nextDouble() * 4D) - 2D), itemEntity.lastTickPosZ + ((worldIn.rand.nextDouble() * 2D) - 1D));
			}
		}
		super.onEntityCollision(state, worldIn, pos, entity);
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(24) == 0) {
			worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}

		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (!this.canBurn(blockstate) && !blockstate.isSolidSide(worldIn, blockpos, Direction.UP)) {
			if (this.canBurn(worldIn.getBlockState(pos.west()))) {
				for(int j = 0; j < 2; ++j) {
					double d3 = (double)pos.getX() + rand.nextDouble() * (double)0.1F;
					double d8 = (double)pos.getY() + rand.nextDouble();
					double d13 = (double)pos.getZ() + rand.nextDouble();
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.east()))) {
				for(int k = 0; k < 2; ++k) {
					double d4 = (double)(pos.getX() + 1) - rand.nextDouble() * (double)0.1F;
					double d9 = (double)pos.getY() + rand.nextDouble();
					double d14 = (double)pos.getZ() + rand.nextDouble();
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, d4, d9, d14, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.north()))) {
				for(int l = 0; l < 2; ++l) {
					double d5 = (double)pos.getX() + rand.nextDouble();
					double d10 = (double)pos.getY() + rand.nextDouble();
					double d15 = (double)pos.getZ() + rand.nextDouble() * (double)0.1F;
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, d5, d10, d15, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.south()))) {
				for(int i1 = 0; i1 < 2; ++i1) {
					double d6 = (double)pos.getX() + rand.nextDouble();
					double d11 = (double)pos.getY() + rand.nextDouble();
					double d16 = (double)(pos.getZ() + 1) - rand.nextDouble() * (double)0.1F;
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, d6, d11, d16, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.up()))) {
				for(int j1 = 0; j1 < 2; ++j1) {
					double d7 = (double)pos.getX() + rand.nextDouble();
					double d12 = (double)(pos.getY() + 1) - rand.nextDouble() * (double)0.1F;
					double d17 = (double)pos.getZ() + rand.nextDouble();
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, d7, d12, d17, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for(int i = 0; i < 3; ++i) {
				double d0 = (double)pos.getX() + rand.nextDouble();
				double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
				double d2 = (double)pos.getZ() + rand.nextDouble();
				worldIn.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}

	}

	protected boolean canBurn(BlockState state) {
		return true;
	}
}
