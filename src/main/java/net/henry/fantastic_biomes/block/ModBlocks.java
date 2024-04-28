package net.henry.fantastic_biomes.block;

import net.henry.fantastic_biomes.Fantastic_Biomes;
import net.henry.fantastic_biomes.item.Moditems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Fantastic_Biomes.MODID);

    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> LIMESTONE_BRICKS = registerBlock("limestone_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE)));

    public static final RegistryObject<Block> CHISELED_LIMESTONE_BRICKS = registerBlock("chiseled_limestone_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE)));

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
