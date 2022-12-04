package de.phil.coordinatesviewer;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiOverlay {

    public static boolean displayCoordinates = true;

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void renderGameOverlayEvent(RenderGuiOverlayEvent event) {
        if (!displayCoordinates || event.isCanceled()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.font.drawShadow(event.getPoseStack(), getFormattedCoordinates(minecraft), 4, 4, 0xffffffff);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void eventInput(InputEvent inputEvent) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || Minecraft.getInstance().screen != null || Minecraft.getInstance().level == null) {
            return;
        }

        if (KeyBindings.toggleCoordinatesDisplay.consumeClick()) {
            GuiOverlay.displayCoordinates = !GuiOverlay.displayCoordinates;
        }
    }

    private static String getFormattedCoordinates(Minecraft minecraft) {
        Vec3 playerCoordinates = Minecraft.getInstance().player.getPosition(0);

        String coordinatesString = String.format("X:%d Y:%d Z:%d %s",
                (long) playerCoordinates.x,
                (long) playerCoordinates.y,
                (long) playerCoordinates.z,
                getDayTime(minecraft));
        return coordinatesString;
    }

    private static String getDayTime(Minecraft minecraft) {
        float time = minecraft.level.getTimeOfDay(0);
        if (time >= 0.25 && time <= 0.75) {
            return "Night";
        } else {
            return "Day";
        }
    }
}
