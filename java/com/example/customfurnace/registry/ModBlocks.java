package com.example.customfurnace.registry;

import com.example.customfurnace.CustomFurnace;
import com.example.customfurnace.block.CustomFurnaceBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * ModBlocks クラス：カスタムブロックを登録するためのクラス
 */
public class ModBlocks {
    // Block 登録用の DeferredRegister
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CustomFurnace.MOD_ID);

    // Item(BlockItem) 登録用の DeferredRegister
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CustomFurnace.MOD_ID);

    // custom_furnace ブロックを登録
    public static final RegistryObject<Block> CUSTOM_FURNACE = BLOCKS.register(
            "custom_furnace",
            CustomFurnaceBlock::new
    );

    // ブロックアイテムを登録（クリエイティブタブに表示）
    public static final RegistryObject<Item> CUSTOM_FURNACE_ITEM = ITEMS.register(
            "custom_furnace",
            () -> new BlockItem(
                    CUSTOM_FURNACE.get(),
                    new Item.Properties().tab(CustomFurnace.CREATIVE_TAB)
            )
    );

    // イベントバスに DeferredRegister を登録
    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
