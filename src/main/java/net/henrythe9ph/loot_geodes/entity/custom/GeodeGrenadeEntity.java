package net.henrythe9ph.loot_geodes.entity.custom;


import net.henrythe9ph.loot_geodes.entity.ModEntities;
import net.henrythe9ph.loot_geodes.item.Moditems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;


public class GeodeGrenadeEntity extends ThrowableItemProjectile {


    public GeodeGrenadeEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public GeodeGrenadeEntity(Level pLevel) {
        super(ModEntities.GEODE_GRENADE.get(), pLevel);
    }

    public GeodeGrenadeEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.GEODE_GRENADE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return Moditems.GEODEGRENADEHELD.get();
    }



    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
           // ServerLevel serverlevel = (ServerLevel)this.level();
           this.level().explode(this, this.getX(), this.getY(), this.getZ(), 4, false, Level.ExplosionInteraction.MOB);
        }
        this.discard();
        super.onHitBlock(pResult);
    }
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            // ServerLevel serverlevel = (ServerLevel)this.level();
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 5, false, Level.ExplosionInteraction.MOB);

        }
        this.discard();
        super.onHitEntity(pResult);
    }


}
