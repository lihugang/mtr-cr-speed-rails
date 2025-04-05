package top.lihugang.mc.mod.mtr_cr_speed_rails.mixin;

import mtr.data.RailType;
import mtr.data.RailType.RailSlopeStyle;
import net.minecraft.block.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.util.Arrays;
@Mixin(RailType.class)
public abstract class RailTypeMixin {

    private static final Unsafe UNSAFE = getUnsafe();
    private static long nameOffset;
    private static long ordinalOffset;

    static {
        try {
            Field nameField = Enum.class.getDeclaredField("name");
            nameOffset = UNSAFE.objectFieldOffset(nameField);

            Field ordinalField = Enum.class.getDeclaredField("ordinal");
            ordinalOffset = UNSAFE.objectFieldOffset(ordinalField);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get Enum Offset", e);
        }
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void injectNewRailTypes(CallbackInfo ci) {
        try {
            Field valuesField = RailType.class.getDeclaredField("$VALUES");
            long valuesOffset = UNSAFE.staticFieldOffset(valuesField);
            RailType[] originalValues = (RailType[]) UNSAFE.getObject(RailType.class, valuesOffset);
            RailType[] newValues = createNewRails(originalValues);
            UNSAFE.putObjectVolatile(RailType.class, valuesOffset, newValues);

            resetEnumCache(RailType.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static RailType[] createNewRails(RailType[] originalValues) {
        Object[][] newRailParams = new Object[][]{
                {"RAIL_100", originalValues.length, 100, MapColor.GRAY,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_140", originalValues.length + 1, 140, MapColor.LIGHT_GRAY,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_170", originalValues.length + 2, 170, MapColor.TERRACOTTA_ORANGE,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_220", originalValues.length + 3, 220, MapColor.TERRACOTTA_WHITE,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_250", originalValues.length + 4, 250, MapColor.CYAN,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_260", originalValues.length + 5, 260, MapColor.CYAN,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_275", originalValues.length + 6, 275, MapColor.CYAN,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_290", originalValues.length + 7, 290, MapColor.CYAN,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_310", originalValues.length + 8, 310, MapColor.DIAMOND_BLUE,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_350", originalValues.length + 9, 350, MapColor.LIGHT_BLUE,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_355", originalValues.length + 10, 355, MapColor.LIGHT_BLUE,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_380", originalValues.length + 11, 380, MapColor.PINK,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_400", originalValues.length + 12, 400, MapColor.LIME,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_420", originalValues.length + 13, 420, MapColor.TERRACOTTA_LIME,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_450", originalValues.length + 14, 450, MapColor.PALE_PURPLE,  false, true, true,
                        RailSlopeStyle.CURVE},
                {"RAIL_486", originalValues.length + 15, 486, MapColor.GOLD,  false, true, true, RailSlopeStyle.CURVE},
                {"RAIL_500", originalValues.length + 16, 500, MapColor.YELLOW,  false, true, true,
                        RailSlopeStyle.CURVE},        };

        RailType[] newValues = Arrays.copyOf(originalValues, originalValues.length + newRailParams.length);
        for (int i = 0; i < newRailParams.length; i++) {
            Object[] params = newRailParams[i];
            RailType rail = createRail(
                    (String) params[0], (int) params[1],
                    (int) params[2], (MapColor) params[3],
                    (boolean) params[4], (boolean) params[5],
                    (boolean) params[6], (RailSlopeStyle) params[7]
            );
            newValues[originalValues.length + i] = rail;
        }
        return newValues;
    }

    private static RailType createRail(String name, int ordinal, int speedLimit, MapColor color,
                                       boolean hasSavedRail, boolean canAccelerate,
                                       boolean hasSignal, RailSlopeStyle slopeStyle) {
        try {
            RailType rail = (RailType) UNSAFE.allocateInstance(RailType.class);

            UNSAFE.putObject(rail, nameOffset, name);
            UNSAFE.putInt(rail, ordinalOffset, ordinal);

            setField(rail, "speedLimit", speedLimit);
            setField(rail, "maxBlocksPerTick", speedLimit / 3.6F / 20);
            setField(rail, "color", color.color | 0xFF000000);
            setField(rail, "hasSavedRail", hasSavedRail);
            setField(rail, "canAccelerate", canAccelerate);
            setField(rail, "hasSignal", hasSignal);
            setField(rail, "railSlopeStyle", slopeStyle);

            return rail;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        long offset = UNSAFE.objectFieldOffset(field);
        if (field.getType() == int.class) {
            UNSAFE.putInt(obj, offset, (int) value);
        } else if (field.getType() == float.class) {
            UNSAFE.putFloat(obj, offset, (float) value);
        } else {
            UNSAFE.putObject(obj, offset, value);
        }
    }

    private static void resetEnumCache(Class<?> enumClass) throws Exception {
        Field enumConstants = Class.class.getDeclaredField("enumConstants");
        UNSAFE.putObjectVolatile(enumClass, UNSAFE.objectFieldOffset(enumConstants), null);

        Field enumConstantDirectory = Class.class.getDeclaredField("enumConstantDirectory");
        UNSAFE.putObjectVolatile(enumClass, UNSAFE.objectFieldOffset(enumConstantDirectory), null);
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get Unsafe Instance", e);
        }
    }
}