package dot.relith.rsu.mixin;

import dot.relith.rsu.SurvivalUpdateMod;
import dot.relith.rsu.util.IFoodItemMaxCount;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;

@Mixin(Item.class)
public abstract class FoodItemMixin implements IFoodItemMaxCount {
    @Final
    @Mutable
    @Shadow
    private int maxCount;
    @Override
    public void setMaxCount(int i) {
        this.maxCount = i;
    }
}
