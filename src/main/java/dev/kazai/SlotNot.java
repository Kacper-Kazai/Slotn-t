package dev.kazai;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SlotNot implements ModInitializer {
	public static final String MODID = "slotnot";
	public static final Item GUI_BACKGROUND = new Item(new FabricItemSettings().maxCount(1));

	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier(MODID, "gui_background"), GUI_BACKGROUND);
	}
}