package corgitaco.modid;

import corgitaco.modid.river.WorldPathGenerator;
import corgitaco.modid.river.WorldStructureAwarePathGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "modid";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Path CONFIG_PATH = new File(String.valueOf(FMLPaths.CONFIGDIR.get().resolve(MOD_ID))).toPath();

    public Main() {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class WorldGenRegistries {
        @SubscribeEvent
        public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
            Feature<NoFeatureConfig> path = WorldPathGenerator.PATH;
            Feature<NoFeatureConfig> path2 = WorldStructureAwarePathGenerator.PATH;
            event.getRegistry().registerAll(path, path2);
        }
    }
}
