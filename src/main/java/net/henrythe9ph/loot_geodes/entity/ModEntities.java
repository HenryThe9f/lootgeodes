package net.henrythe9ph.loot_geodes.entity;

import net.henrythe9ph.loot_geodes.Loot_Geodes;
import net.henrythe9ph.loot_geodes.entity.custom.GeodeGrenadeEntity;
import net.henrythe9ph.loot_geodes.entity.custom.GeodeNukeEntity;
import net.henrythe9ph.loot_geodes.entity.custom.SmallMoltenGeodeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.henrythe9ph.loot_geodes.entity.custom.SmallGeodeEntity;
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Loot_Geodes.MODID);
    public static final RegistryObject<EntityType<SmallGeodeEntity>> GEODE_BALL =
            ENTITY_TYPES.register("small_geode", () -> EntityType.Builder.<SmallGeodeEntity>of(SmallGeodeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("small_geode"));

    public static final RegistryObject<EntityType<GeodeGrenadeEntity>> GEODE_GRENADE =
            ENTITY_TYPES.register("geode_grenade", () -> EntityType.Builder.<GeodeGrenadeEntity>of(GeodeGrenadeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("geode_grenade"));

    public static final RegistryObject<EntityType<SmallMoltenGeodeEntity>> MOLTEN_GEODE_BALL =
            ENTITY_TYPES.register("molten_small_geode", () -> EntityType.Builder.<SmallMoltenGeodeEntity>of(SmallMoltenGeodeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("molten_small_geode"));

    public static final RegistryObject<EntityType<GeodeNukeEntity>> GEODE_NUKE =
            ENTITY_TYPES.register("geode_nuke", () -> EntityType.Builder.<GeodeNukeEntity>of(GeodeNukeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("geode_nuke"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
