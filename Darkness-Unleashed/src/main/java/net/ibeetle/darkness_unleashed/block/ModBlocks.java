package net.ibeetle.darkness_unleashed.block;

import net.ibeetle.darkness_unleashed.DarknessUnleashedMod;
import net.ibeetle.darkness_unleashed.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DarknessUnleashedMod.MODID);

    public static final RegistryObject<Block> RUNE_FORGE_BLOCK = registerBlock("rune_forge_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANVIL).sound(SoundType.ANVIL))); //TODO: change behaviour using .of
    public static final RegistryObject<Block> UMBRALITE_BLOCK = registerBlock("umbralite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
    public static final RegistryObject<Block> RAW_UMBRALITE_BLOCK = registerBlock("raw_umbralite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> UMBRALITE_ORE = registerBlock("umbralite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6))); //TODO: change numbers


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> regItem = BLOCKS.register(name, block);
        registerBlockItem(name, regItem);
        return regItem;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
