package dot.relith.rsu;

import dot.relith.rsu.util.IFoodItemMaxCount;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Waterloggable;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SurvivalUpdateMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("relith-survival-update");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		//Lnet/minecraft/entity/player/HungerManager;update(Lnet/minecraft/entity/player/PlayerEntity;)V

		for (Item item : Registries.ITEM) {
			if (item.isFood()) {
				switch (Registries.ITEM.getId(item).toString()) {
					case "minecraft:cookie":
					case "minecraft:dried_kelp":
					case "minecraft:spider_eye":
					case "minecraft:beetroot":
					case "minecraft:potato":
					case "minecraft:tropical_fish":
						((IFoodItemMaxCount) item).setMaxCount(16);
						break;
					case "minecraft:melon_slice":
					case "minecraft:sweet_berries":
					case "minecraft:glow_berries":
						((IFoodItemMaxCount) item).setMaxCount(8);
						break;
					case "minecraft:honey_bottle":
					case "minecraft:apple":
						((IFoodItemMaxCount) item).setMaxCount(4);
						break;
					default:
						((IFoodItemMaxCount) item).setMaxCount(1);
						break;
				}
			}
		}
		LOGGER.info("Hello Fabric world!");
	}
	public static boolean supportsWaterlogged(Block block) {
		return block instanceof Waterloggable;
	}
}