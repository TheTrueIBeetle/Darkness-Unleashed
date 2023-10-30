package net.ibeetle.darkness_unleashed.item;

import net.ibeetle.darkness_unleashed.DarknessUnleashedMod;
import net.ibeetle.darkness_unleashed.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DarknessUnleashedMod.MODID);

    public static final RegistryObject<CreativeModeTab> DARKNESS_UNLEASHED_TAB = CREATIVE_MODE_TABS.register("darkness_unleashed_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUNE_OF_DARKNESS.get()))
                    .title(Component.translatable("creativetab.darkness_unleashed_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RUNE_OF_DARKNESS.get());
                        pOutput.accept(ModBlocks.RUNE_FORGE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
