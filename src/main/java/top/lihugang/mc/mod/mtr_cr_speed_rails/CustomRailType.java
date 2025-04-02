//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.lihugang.mc.mod.mtr_cr_speed_rails;

import org.mtr.core.data.Rail;
import org.mtr.core.data.Rail.Shape;
import org.mtr.mapping.holder.MapColor;
import org.mtr.mod.data.IGui;

public enum CustomRailType implements IGui {
    WOODEN(20, MapColor.getOakTanMapped(), false, true, true, Shape.QUADRATIC),
    STONE(40, MapColor.getStoneGrayMapped(), false, true, true, Shape.QUADRATIC),
    EMERALD(60, MapColor.getEmeraldGreenMapped(), false, true, true, Shape.QUADRATIC),
    IRON(80, MapColor.getIronGrayMapped(), false, true, true, Shape.QUADRATIC),
    OBSIDIAN(120, MapColor.getPurpleMapped(), false, true, true, Shape.QUADRATIC),
    BLAZE(160, MapColor.getOrangeMapped(), false, true, true, Shape.QUADRATIC),
    QUARTZ(200, MapColor.getOffWhiteMapped(), false, true, true, Shape.QUADRATIC),
    DIAMOND(300, MapColor.getDiamondBlueMapped(), false, true, true, Shape.QUADRATIC),
    PLATFORM(80, MapColor.getRedMapped(), true, false, true, Shape.QUADRATIC),
    SIDING(40, MapColor.getYellowMapped(), true, false, true, Shape.QUADRATIC),
    TURN_BACK(80, MapColor.getBlueMapped(), false, false, true, Shape.QUADRATIC),
    CABLE_CAR(30, MapColor.getWhiteMapped(), false, true, true, Shape.CABLE),
    CABLE_CAR_STATION(2, MapColor.getWhiteMapped(), false, true, true, Shape.QUADRATIC),
    RUNWAY(300, MapColor.getPalePurpleMapped(), false, true, false, Shape.QUADRATIC),
    AIRPLANE_DUMMY(900, MapColor.getBlackMapped(), false, true, false, Shape.QUADRATIC),

    RAIL_100(100, MapColor.getGrayMapped(), false, true, true, Shape.QUADRATIC), // 货运
    RAIL_140(140, MapColor.getLightGrayMapped(), false, true, true, Shape.QUADRATIC), // 25K / 25Z
    RAIL_170(170, MapColor.getOrangeMapped(), false, true, true, Shape.QUADRATIC), // DF11G
    RAIL_220(220, MapColor.getWhiteMapped(), false, true, true, Shape.QUADRATIC), // 高速道岔
    RAIL_250(250, MapColor.getCyanMapped(), false, true, true, Shape.QUADRATIC), // 250km/h 等级铁路
    RAIL_260(260, MapColor.getCyanMapped(), false, true, true, Shape.QUADRATIC), // 沪宁城际常用限速
    RAIL_275(275, MapColor.getCyanMapped(), false, true, true, Shape.QUADRATIC), // 沪宁城际常用限速
    RAIL_290(290, MapColor.getCyanMapped(), false, true, true, Shape.QUADRATIC), // 沪宁城际常用限速
    RAIL_310(310, MapColor.getDiamondBlueMapped(), false, true, true, Shape.QUADRATIC), // CRH380 运营速度 (高阻)
    RAIL_350(350, MapColor.getLightBlueMapped(), false, true, true, Shape.QUADRATIC), // CR400 运营速度，CRH380 运营速度 (跨越)
    RAIL_355(355, MapColor.getLightBlueMapped(), false, true, true, Shape.QUADRATIC), // CR400 ATP 限速
    RAIL_380(380, MapColor.getPinkMapped(), false, true, true, Shape.QUADRATIC), // CRH380 设计时速
    RAIL_400(400, MapColor.getLimeMapped(), false, true, true, Shape.QUADRATIC), // CR400 设计时速，CIT 400 动检时速
    RAIL_420(420, MapColor.getTerracottaLimeMapped(), false, true, true, Shape.QUADRATIC), // 380 线路验收标准, 380D, 380CL 最高实验速度
    RAIL_450(450, MapColor.getPalePurpleMapped(), false, true, true, Shape.QUADRATIC), // CR450 / CRH380AM-0204 / CIT 500 设计时速
    RAIL_486(486, MapColor.getGoldMapped(), false, true, true, Shape.QUADRATIC), // CRH380AL-2541 冲高时速
    RAIL_500(500, MapColor.getYellowMapped(), false, true, true, Shape.QUADRATIC); // CRH380AM-0204 / CIT500 最高速度

    public final int speedLimit;
    public final int color;
    public final boolean isSavedRail;
    public final boolean canAccelerate;
    public final boolean hasSignal;
    public final Rail.Shape railShape;

    CustomRailType(int speedLimit, MapColor mapColor, boolean isSavedRail, boolean canAccelerate, boolean hasSignal, Rail.Shape railShape) {
        this.speedLimit = speedLimit;
        this.color = mapColor.getColorMapped() | -16777216;
        this.isSavedRail = isSavedRail;
        this.canAccelerate = canAccelerate;
        this.hasSignal = hasSignal;
        this.railShape = railShape;
    }

    public static int getRailColor(Rail rail) {
        if (rail.isPlatform()) {
            return PLATFORM.color;
        } else if (rail.isSiding()) {
            return SIDING.color;
        } else if (rail.canTurnBack()) {
            return TURN_BACK.color;
        } else if (rail.canConnectRemotely()) {
            return RUNWAY.color;
        } else {
            CustomRailType[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                CustomRailType railType = var1[var3];
                if ((long)railType.speedLimit == Math.max(rail.getSpeedLimitKilometersPerHour(false), rail.getSpeedLimitKilometersPerHour(true))) {
                    return railType.color;
                }
            }

            return -16777216;
        }
    }
}
