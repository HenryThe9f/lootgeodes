package net.henrythe9ph.loot_geodes.entity.custom;


import net.henrythe9ph.loot_geodes.entity.ModEntities;
import net.henrythe9ph.loot_geodes.item.Moditems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.List;


public class SmallMoltenGeodeEntity extends ThrowableItemProjectile {

  public static final ResourceLocation GEODE_LOOT = new ResourceLocation("loot_geodes","entities/nether_geode");

    public SmallMoltenGeodeEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SmallMoltenGeodeEntity(Level pLevel) {
        super(ModEntities.MOLTEN_GEODE_BALL.get(), pLevel);
    }

    public SmallMoltenGeodeEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.MOLTEN_GEODE_BALL.get(), livingEntity, pLevel);
    }

    public void handleEntityEvent(byte pId) {
        if (pId == 3) {
            double $$1 = 0.08;

            for(int $$2 = 0; $$2 < 8; ++$$2) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5) * 0.8, ((double)this.random.nextFloat() - 0.5) * 0.8, ((double)this.random.nextFloat() - 0.5) * 0.8);
            }
        }

    }

    @Override
    protected Item getDefaultItem() {
        return Moditems.SMALLMOLTENGEODEHELD.get();
    }





    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            ServerLevel serverlevel = (ServerLevel)this.level();
            LootTable loottable = serverlevel.getServer().getLootData().getLootTable(GEODE_LOOT);
            LootParams lootparams = (new LootParams.Builder(serverlevel)).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.GIFT);
            List<ItemStack> list = loottable.getRandomItems(lootparams);
            for (ItemStack itemstack : list) {
                this.spawnAtLocation(itemstack, 0);
            }



           // this.spawnAtLocation(new ItemStack(Items.DIAMOND));
          //  this.spawnAtLocation(new ItemStack(Items.EMERALD));
            this.playSound(SoundEvents.AMETHYST_BLOCK_BREAK, 1.0F, 0.5F);


            //this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), this.getItem));
           // this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3, false, Level.ExplosionInteraction.MOB);
        }
        this.discard();
        super.onHitBlock(pResult);
    }
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            ServerLevel serverlevel = (ServerLevel)this.level();
            LootTable loottable = serverlevel.getServer().getLootData().getLootTable(GEODE_LOOT);
            LootParams lootparams = (new LootParams.Builder(serverlevel)).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.GIFT);
            List<ItemStack> list = loottable.getRandomItems(lootparams);
            for (ItemStack itemstack : list) {
                this.spawnAtLocation(itemstack, 0);
            }
            Entity entity = this.getOwner();
            if (entity instanceof LivingEntity livingentity) {
                pResult.getEntity().hurt(this.damageSources().mobProjectile(this, livingentity), 5.0F);
            }
            this.playSound(SoundEvents.AMETHYST_BLOCK_BREAK, 1.0F, 0.5F);

        }
        this.discard();
        super.onHitEntity(pResult);
    }


}
