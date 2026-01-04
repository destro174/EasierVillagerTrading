package de.guntram.mcmod.easiervillagertrading.mixins;

import de.guntram.mcmod.easiervillagertrading.BetterGuiMerchant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.MerchantMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MenuScreens.class)
public abstract class GuiMerchantMixin {
    
    @Inject(method = "create", at = @At("HEAD"), cancellable = true)
    private static void displayVillagerTradeGui(MenuType menuType, Minecraft minecraft, int i, Component component, CallbackInfo ci) {
        if (minecraft.player == null) {
            return;
        }

        if (menuType == MenuType.MERCHANT) {
            AbstractContainerMenu container = menuType.create(i, minecraft.player.getInventory());
            BetterGuiMerchant screen = new BetterGuiMerchant((MerchantMenu) container, minecraft.player.getInventory(), component);
            minecraft.player.containerMenu = container;
            minecraft.setScreen(screen);
            ci.cancel();
        }
    }
}
