package superworldsun.superslegend.entities.projectiles.arrows;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import superworldsun.superslegend.init.SoundInit;
import superworldsun.superslegend.lists.ItemList;

public class EntityArrowAncient extends ArrowEntity
{

    public EntityArrowAncient(World worldIn, double x, double y, double z){
        super(worldIn, x, y, z);
    }

    public EntityArrowAncient(World worldIn, LivingEntity shooter){
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(ItemList.ancient_arrow);
    }

    @Override
    protected void arrowHit(LivingEntity entity) {

        int i = this.getColor();

        @SuppressWarnings("unused")
		double d0 = (double)(i >> 16 & 255) / 255.0D;
        @SuppressWarnings("unused")
		double d1 = (double)(i >> 8 & 255) / 255.0D;
        @SuppressWarnings("unused")
		double d2 = (double)(i >> 0 & 255) / 255.0D;

        super.arrowHit(entity);
        if(entity.isNonBoss()){
        	BlockPos currentPos = entity.getPosition();
            entity.world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_ANCIENT, SoundCategory.PLAYERS, 1f, 1f);
            entity.setHealth(0);
        }else {
        	BlockPos currentPos = entity.getPosition();
            entity.world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.ARROW_HIT_ANCIENT, SoundCategory.PLAYERS, 1f, 1f);
            entity.setHealth(entity.getHealth()-45);
        }
    }
}