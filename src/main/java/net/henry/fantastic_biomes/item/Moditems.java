package net.henry.fantastic_biomes.item;

import net.henry.fantastic_biomes.Fantastic_Biomes;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Fantastic_Biomes.MODID);
    public static final RegistryObject<Item> OVERPEARL = ITEMS.register("overpearl", ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> OLDSWORD = ITEMS.register("oldsword", ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> REPAIREDSWORD = ITEMS.register("repairedsword", ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> BABYSWORD = ITEMS.register("babysword", ()->new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
