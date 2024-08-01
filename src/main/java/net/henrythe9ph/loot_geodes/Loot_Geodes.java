package net.henrythe9ph.loot_geodes;

import com.mojang.logging.LogUtils;
import net.henrythe9ph.loot_geodes.block.ModBlocks;
import net.henrythe9ph.loot_geodes.entity.ModEntities;
import net.henrythe9ph.loot_geodes.item.ModCreativeModTabs;
import net.henrythe9ph.loot_geodes.item.Moditems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Loot_Geodes.MODID)
public class Loot_Geodes
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "loot_geodes";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Loot_Geodes()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
       // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

      //  if (Config.logDirtBlock)
        //    LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

     //   LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

     //   Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {


    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
           // LOGGER.info("HELLO FROM CLIENT SETUP");
            //LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            EntityRenderers.register(ModEntities.GEODE_BALL.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GEODE_GRENADE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.MOLTEN_GEODE_BALL.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GEODE_NUKE.get(), ThrownItemRenderer::new);
        }
    }
}
