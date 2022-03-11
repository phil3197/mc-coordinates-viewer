package de.phil.coordinatesviewer;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiOverlay {

    public static boolean displayCoordinates = true;

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
        if (!displayCoordinates || event.isCanceled() || event.getType() != RenderGameOverlayEvent.ElementType.TEXT) {
            return;
        }
        Minecraft.getInstance().font.drawShadow(event.getMatrixStack(), getFormattedCoordinates(), 4, 4, 0xffffffff);
    }

    private static String getFormattedCoordinates() {
        Vec3 playerCoordinates = Minecraft.getInstance().player.getPosition(0);
        String coordinatesString = String.format("X:%d Y:%d Z:%d",
                (long) playerCoordinates.x,
                (long) playerCoordinates.y,
                (long) playerCoordinates.z);
        return coordinatesString;
    }

}
