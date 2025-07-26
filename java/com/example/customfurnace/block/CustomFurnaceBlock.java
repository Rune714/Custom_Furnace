package com.example.customfurnace.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;

public class CustomFurnaceBlock extends Block {
    // BlockStatePropertiesの定数を使用することを推奨
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public CustomFurnaceBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE)
                .strength(3.5F)
                .requiresCorrectToolForDrops()
        );
        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite())
                .setValue(LIT, false);
    }

    /**
     * 外部から呼び出し可能：ブロックの lit 状態を切替。
     * @param world ワールド
     * @param pos ブロックの位置
     * @param isLit 点灯状態
     */
    @SuppressWarnings("unused")
    public void setLit(Level world, BlockPos pos, boolean isLit) {
        BlockState state = world.getBlockState(pos);
        // ブロックが正しい種類かチェック
        if (state.getBlock() != this) {
            return;
        }

        if (state.getValue(LIT) != isLit) {
            world.setBlockAndUpdate(pos, state.setValue(LIT, isLit));
        }
    }
}