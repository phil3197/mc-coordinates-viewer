package de.phil.coordinatesviewer;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    private static final String CATEGORY = "Coordinates Viewer";

    public static KeyMapping toggleCoordinatesDisplay = new KeyMapping("Toggle Coordinates", GLFW.GLFW_KEY_BACKSLASH, CATEGORY);

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerKeyBinding(RegisterKeyMappingsEvent event) {
        event.register(toggleCoordinatesDisplay);
    }

}
