package dev.kazai.mixin;

import dev.kazai.SlotNot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slot.class)
public abstract class SlotMixin {
    @Inject(at = @At("HEAD"), method = "canTakeItems", cancellable = true)
    public void canTakeItems(PlayerEntity playerEntity, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if(!((Slot)(Object)this).getStack().getItem().equals(SlotNot.GUI_BACKGROUND)) return;
        callbackInfoReturnable.setReturnValue(false);
        callbackInfoReturnable.cancel();
    }
    @Inject(at = @At("HEAD"), method = "canInsert", cancellable = true)
    public void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if(!((Slot)(Object)this).getStack().getItem().equals(SlotNot.GUI_BACKGROUND)) return;
        callbackInfoReturnable.setReturnValue(false);
        callbackInfoReturnable.cancel();
    }
    @Inject(at = @At("HEAD"), method = "method_51306", cancellable = true)
    public void canBeHighlighted(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if(!((Slot)(Object)this).getStack().getItem().equals(SlotNot.GUI_BACKGROUND)) return;
        callbackInfoReturnable.setReturnValue(false);
        callbackInfoReturnable.cancel();
    }
}
