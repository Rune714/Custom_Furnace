package com.example.customfurnace;

import com.example.customfurnace.registry.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;

/**
 * メイン mod クラス。
 * mods.toml に記載されている modid に一致させてください。
 */
@Mod(CustomFurnace.MOD_ID)
public class CustomFurnace {
    public static final String MOD_ID = "custom_furnace";

    /**
     * カスタムクリエイティブタブの定義。
     * makeIcon() メソッドでアイコンを指定します。
     */
    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab("customFurnaceTab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            // 登録済みのカスタムかまどのアイテムをアイコンに使用
            return new ItemStack(ModBlocks.CUSTOM_FURNACE_ITEM.get());
        }
    };

    public CustomFurnace() {
        // ブロックとアイテムの DeferredRegister をイベントバスに登録
        ModBlocks.register();
    }
}