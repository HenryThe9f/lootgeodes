package net.henrythe9ph.loot_geodes.item;

import net.henrythe9ph.loot_geodes.Loot_Geodes;
import net.henrythe9ph.loot_geodes.item.custom.GeodeGrenadeItem;
import net.henrythe9ph.loot_geodes.item.custom.GeodeNukeItem;
import net.henrythe9ph.loot_geodes.item.custom.SmallGeodeItem;
import net.henrythe9ph.loot_geodes.item.custom.SmallMoltenGeodeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Loot_Geodes.MODID);


    public static final RegistryObject<Item> SMALLGEODEHELD = ITEMS.register("smallgeodeheld", ()->new SmallGeodeItem(new Item.Properties()));

    public static final RegistryObject<Item> SMALLMOLTENGEODEHELD = ITEMS.register("smallmoltengeodeheld", ()->new SmallMoltenGeodeItem(new Item.Properties()));

    public static final RegistryObject<Item> GEODEGRENADEHELD = ITEMS.register("geodegrenadeheld", ()->new GeodeGrenadeItem(new Item.Properties()));

    public static final RegistryObject<Item> GEODENUKEHELD = ITEMS.register("geodenukeheld", ()->new GeodeNukeItem(new Item.Properties()));


    public static final RegistryObject<Item> DREAMSHARD = ITEMS.register("dreamshard", ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> MOLTENSHARD = ITEMS.register("moltenshard", ()->new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
