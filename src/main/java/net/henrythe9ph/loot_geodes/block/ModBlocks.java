package net.henrythe9ph.loot_geodes.block;

import net.henrythe9ph.loot_geodes.Loot_Geodes;
import net.henrythe9ph.loot_geodes.Loot_Geodes;
import net.henrythe9ph.loot_geodes.item.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Loot_Geodes.MODID);

    public static final RegistryObject<Block> SMALL_GEODE = registerBlock("small_geode",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15).strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)) {
            });
    public static final RegistryObject<Block> DEEPSLATE_SMALL_GEODE = registerBlock("deepslate_small_geode",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)) {
            });

    public static final RegistryObject<Block> NETHERRACK_SMALL_GEODE = registerBlock("netherrack_small_geode",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)) {
            });

    public static final RegistryObject<Block> GEODE_INTERIOR = registerBlock("geode_interior",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15)) {
            });

    public static final RegistryObject<Block> MOLTENBLOCK = registerBlock("molten_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15)) {
            });

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
