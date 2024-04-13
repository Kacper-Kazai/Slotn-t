// https://open.spotify.com/playlist/3AgGzLGK8PyRhpc7q48x7A?si=aI28yzhxT5qs9d8WVflp1Q&pi=e-LyRCGGDcSZOH
package dev.kazai.mixin;

import dev.kazai.SlotNot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(at = @At("HEAD"), method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", cancellable = true)
    public void dropItem(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> callbackInfoReturnable) {
        if(!(stack).getItem().equals(SlotNot.GUI_BACKGROUND)) return;
        callbackInfoReturnable.setReturnValue(null);
        callbackInfoReturnable.cancel();
    }
}
