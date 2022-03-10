package de.phil.coordinatesviewer;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("coordinatesviewer")
public class Controller
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Controller() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(GuiOverlay.class);
        MinecraftForge.EVENT_BUS.register(KeyBindings.class);

    }

    private void onSetup(final FMLCommonSetupEvent event) {
        KeyBindings.setUp();
    }
}
