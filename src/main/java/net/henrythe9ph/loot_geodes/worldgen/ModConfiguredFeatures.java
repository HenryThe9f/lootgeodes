package net.henrythe9ph.loot_geodes.worldgen;

import net.henrythe9ph.loot_geodes.Loot_Geodes;
import net.henrythe9ph.loot_geodes.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_GEODE_ORE_KEY = registerKey("small_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_GEODE_ORE_KEY = registerKey("nether_small_geode");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldGeodeOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SMALL_GEODE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_SMALL_GEODE.get().defaultBlockState()));

        register(context, OVERWORLD_GEODE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldGeodeOres, 3));
        register(context, NETHER_GEODE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceable,
                ModBlocks.NETHERRACK_SMALL_GEODE.get().defaultBlockState(), 3));
    }


public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
    return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Loot_Geodes.MODID, name));
}

private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                      ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
}
}