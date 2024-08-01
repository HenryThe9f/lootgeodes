package net.henrythe9ph.loot_geodes.item;

import net.henrythe9ph.loot_geodes.Loot_Geodes;
import net.henrythe9ph.loot_geodes.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Loot_Geodes.MODID);

    public static final RegistryObject<CreativeModeTab> BIOME_TAB = CREATIVE_MODE_TABS.register("biome_tab", ()-> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.SMALLGEODEHELD.get()))
            .title(Component.translatable("creativetab.biome_tab"))
            .displayItems((pParameters, pOutput) -> {

                pOutput.accept(ModBlocks.SMALL_GEODE.get());
                pOutput.accept(ModBlocks.DEEPSLATE_SMALL_GEODE.get());
                pOutput.accept(ModBlocks.NETHERRACK_SMALL_GEODE.get());
                pOutput.accept(Moditems.SMALLGEODEHELD.get());
                pOutput.accept(Moditems.SMALLMOLTENGEODEHELD.get());
                pOutput.accept(Moditems.GEODEGRENADEHELD.get());
                pOutput.accept(Moditems.GEODENUKEHELD.get());
                pOutput.accept(ModBlocks.GEODE_INTERIOR.get());
                pOutput.accept(Moditems.DREAMSHARD.get());
                pOutput.accept(ModBlocks.MOLTENBLOCK.get());
                pOutput.accept(Moditems.MOLTENSHARD.get());
            })
            .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);

    }
}
