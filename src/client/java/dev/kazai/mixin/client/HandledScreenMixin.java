// Zakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakZakolak zakolakvv
// kazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazaikazai
// https://clips.twitch.tv/LovelyCarelessSandwichHoneyBadger-oVksVAh_c6pGVbSl HEHEHEHHEEHEHEHEHE
// https://clips.twitch.tv/ApatheticCleanIcecreamPicoMause-GdcOel-JM10qY35k masz na druga noge, moze kiedys ktos sie z tego posmieje
package dev.kazai.mixin.client;

import dev.kazai.SlotNot;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {
	@Shadow
	@Nullable
	protected Slot focusedSlot;

	@Inject(at = @At("HEAD"), method = "drawMouseoverTooltip", cancellable = true)
	protected void drawMouseoverTooltip(DrawContext context, int x, int y, CallbackInfo info) {
		if (this.focusedSlot == null || !this.focusedSlot.hasStack() || !this.focusedSlot.getStack().getItem().equals(SlotNot.GUI_BACKGROUND)) return;
		info.cancel();
	}
}