//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.lihugang.mc.mod.mtr_cr_speed_rails;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import org.mtr.core.data.Position;
import org.mtr.core.data.Rail;
import org.mtr.core.data.TransportMode;
import org.mtr.core.data.TwoPositionsBase;
import org.mtr.core.data.Rail.Shape;
import org.mtr.core.tool.Angle;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.mtr.mapping.holder.*;
import org.mtr.mod.Init;
import org.mtr.mod.block.BlockNode;
import org.mtr.mod.generated.lang.TranslationProvider;
import org.mtr.mod.item.ItemNodeModifierBase;
import org.mtr.mod.packet.PacketDeleteData;
import org.mtr.mod.packet.PacketUpdateData;
import org.mtr.mod.packet.PacketUpdateLastRailStyles;

import static top.lihugang.mc.mod.mtr_cr_speed_rails.CustomRailType.*;

public class CustomItemRailModifier extends ItemNodeModifierBase {
    private final boolean isOneWay;
    private final CustomRailType railType;

    public CustomItemRailModifier(ItemSettings itemSettings) {
        super(true, true, true, false, itemSettings);
        this.isOneWay = false;
        this.railType = null;
    }

    public CustomItemRailModifier(boolean forNonContinuousMovementNode, boolean forContinuousMovementNode, boolean forAirplaneNode, boolean isOneWay, CustomRailType railType, ItemSettings itemSettings) {
        super(forNonContinuousMovementNode, forContinuousMovementNode, forAirplaneNode, true, itemSettings);
        this.isOneWay = isOneWay;
        this.railType = railType;
    }


    public void addTooltips(ItemStack stack, @Nullable World world, List<MutableText> tooltip, TooltipContext options) {
        if (this.isConnector && this.railType != null && this.railType.canAccelerate) {
            tooltip.add(TranslationProvider.TOOLTIP_MTR_RAIL_SPEED_LIMIT.getMutableText(new Object[]{this.railType.speedLimit}).formatted(TextFormatting.GRAY));
        }

        super.addTooltips(stack, world, tooltip, options);
    }

    protected void onConnect(World world, ItemStack stack, TransportMode transportMode, BlockState stateStart, BlockState stateEnd, BlockPos posStart, BlockPos posEnd, Angle facingStart, Angle facingEnd, @Nullable ServerPlayerEntity player) {
        if (this.railType != null) {
            Rail rail = this.createRail(player == null ? null : player.getUuid(), transportMode, stateStart, stateEnd, posStart, posEnd, facingStart, facingEnd);
            if (rail != null) {
                world.setBlockState(posStart, stateStart.with(new Property((net.minecraft.world.level.block.state.properties.Property)BlockNode.IS_CONNECTED.data), true));
                world.setBlockState(posEnd, stateEnd.with(new Property((net.minecraft.world.level.block.state.properties.Property)BlockNode.IS_CONNECTED.data), true));
                PacketUpdateData.sendDirectlyToServerRail(ServerWorld.cast(world), rail);
            } else if (player != null) {
                player.sendMessage(TranslationProvider.GUI_MTR_INVALID_ORIENTATION.getText(new Object[0]), true);
            }
        }

    }

    protected void onRemove(World world, BlockPos posStart, BlockPos posEnd, @Nullable ServerPlayerEntity player) {
        PacketDeleteData.sendDirectlyToServerRailId(ServerWorld.cast(world), TwoPositionsBase.getHexId(Init.blockPosToPosition(posStart), Init.blockPosToPosition(posEnd)));
    }

    @Nullable
    public Rail createRail(@Nullable UUID uuid, TransportMode transportMode, BlockState stateStart, BlockState stateEnd, BlockPos posStart, BlockPos posEnd, Angle facingStart, Angle facingEnd) {
        if (this.railType != null && uuid != null) {
            boolean isValidContinuousMovement;
            CustomRailType newRailType;
            if (transportMode.continuousMovement) {
                Block blockStart = stateStart.getBlock();
                Block blockEnd = stateEnd.getBlock();
                if (blockStart.data instanceof BlockNode.BlockContinuousMovementNode && blockEnd.data instanceof BlockNode.BlockContinuousMovementNode && ((BlockNode.BlockContinuousMovementNode)blockStart.data).isStation && ((BlockNode.BlockContinuousMovementNode)blockEnd.data).isStation) {
                    isValidContinuousMovement = true;
                    newRailType = this.railType.isSavedRail ? this.railType : CustomRailType.CABLE_CAR_STATION;
                } else {
                    int differenceX = posEnd.getX() - posStart.getX();
                    int differenceZ = posEnd.getZ() - posStart.getZ();
                    boolean var10000;
                    if (this.railType.isSavedRail || !facingStart.isParallel(facingEnd) || (facingStart != Angle.N && facingStart != Angle.S || differenceX != 0) && (facingStart != Angle.E && facingStart != Angle.W || differenceZ != 0) && (facingStart != Angle.NE && facingStart != Angle.SW || differenceX != -differenceZ) && (facingStart != Angle.SE && facingStart != Angle.NW || differenceX != differenceZ)) {
                        var10000 = false;
                    } else {
                        var10000 = true;
                    }

                    isValidContinuousMovement = var10000;
                    newRailType = CustomRailType.CABLE_CAR;
                }
            } else {
                isValidContinuousMovement = true;
                newRailType = this.railType;
            }

            Position positionStart = Init.blockPosToPosition(posStart);
            Position positionEnd = Init.blockPosToPosition(posEnd);
            Rail rail;
            switch (newRailType) {
                case PLATFORM -> rail = Rail.newPlatformRail(positionStart, facingStart, positionEnd, facingEnd, Shape.QUADRATIC, 0.0, new ObjectArrayList(), transportMode);
                case SIDING -> rail = Rail.newSidingRail(positionStart, facingStart, positionEnd, facingEnd, Shape.QUADRATIC, 0.0, new ObjectArrayList(), transportMode);
                case TURN_BACK -> rail = Rail.newTurnBackRail(positionStart, facingStart, positionEnd, facingEnd, Shape.QUADRATIC, 0.0, new ObjectArrayList(), transportMode);
                default -> rail = Rail.newRail(positionStart, facingStart, positionEnd, facingEnd, newRailType.railShape, 0.0, new ObjectArrayList(), this.isOneWay ? 0L : (long)newRailType.speedLimit, (long)newRailType.speedLimit, false, false, newRailType.canAccelerate, newRailType == CustomRailType.RUNWAY, newRailType.hasSignal, transportMode);
            }

            if (rail.isValid() && isValidContinuousMovement) {
                return PacketUpdateLastRailStyles.SERVER_CACHE.getRailWithLastStyles(uuid, rail);
            }
        }

        return null;
    }
}
