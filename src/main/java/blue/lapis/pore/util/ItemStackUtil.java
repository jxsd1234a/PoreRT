package blue.lapis.pore.util;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Created by Frani on 13/10/2018.
 */
public class ItemStackUtil {

    public static ItemStack fromNative(net.minecraft.item.ItemStack item) {
        return (ItemStack) (Object) item;
    }

}
