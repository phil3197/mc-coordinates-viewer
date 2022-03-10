package de.phil.coordinatesviewer;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    private static final String CATEGORY = "Coordinates";

    public static KeyMapping toggleCoordinatesDisplay = new KeyMapping("Coordinates", GLFW.GLFW_KEY_BACKSLASH,CATEGORY);

    public static void setUp() {
        ClientRegistry.registerKeyBinding(toggleCoordinatesDisplay);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void eventInput(InputEvent inputEvent) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || Minecraft.getInstance().screen != null || Minecraft.getInstance().level == null) {
            return;
        }

        if(toggleCoordinatesDisplay.consumeClick()) {
            GuiOverlay.displayCoordinates = !GuiOverlay.displayCoordinates;
        }
    }
}
