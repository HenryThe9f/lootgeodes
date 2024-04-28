package net.henry.fantastic_biomes.item;

import net.henry.fantastic_biomes.Fantastic_Biomes;
import net.henry.fantastic_biomes.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fantastic_Biomes.MODID);

    public static final RegistryObject<CreativeModeTab> BIOME_TAB = CREATIVE_MODE_TABS.register("biome_tab", ()-> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.OVERPEARL.get()))
            .title(Component.translatable("creativetab.biome_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(Moditems.OVERPEARL.get());
                pOutput.accept(Moditems.OLDSWORD.get());
                pOutput.accept(Moditems.REPAIREDSWORD.get());
                pOutput.accept(Moditems.BABYSWORD.get());
                pOutput.accept(ModBlocks.LIMESTONE.get());
                pOutput.accept(ModBlocks.LIMESTONE_BRICKS.get());
                pOutput.accept(ModBlocks.CHISELED_LIMESTONE_BRICKS.get());
            })
            .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);

    }
}
