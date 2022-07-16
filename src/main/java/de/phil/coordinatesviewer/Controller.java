package de.phil.coordinatesviewer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("coordinatesviewer")
public class Controller {

    public Controller() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(GuiOverlay.class);

        FMLJavaModLoadingContext.get().getModEventBus().register(KeyBindings.class);
    }
}