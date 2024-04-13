package dev.kazai.mixin;

import dev.kazai.SlotNot;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {
	@Inject(at = @At("HEAD"), method = "updateItems")
	public void updateItems(CallbackInfo callbackInfo) {
		for(int i=9; i < 36; i++)
			((PlayerInventory)(Object)this).main.set(i, SlotNot.GUI_BACKGROUND.getDefaultStack());
	}
}