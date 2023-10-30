package net.ibeetle.darkness_unleashed.item;

import net.ibeetle.darkness_unleashed.DarknessUnleashedMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DarknessUnleashedMod.MODID);

    public static final RegistryObject<Item> RUNE_OF_DARKNESS = ITEMS.register("rune_of_darkness", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
