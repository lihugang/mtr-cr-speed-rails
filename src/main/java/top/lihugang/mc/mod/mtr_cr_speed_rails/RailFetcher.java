package top.lihugang.mc.mod.mtr_cr_speed_rails;

import mtr.data.RailType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RailFetcher {
    static public List<RailType> customRails = new ArrayList<>();

    static {
        Field valuesField = null;
        try {
            valuesField = RailType.class.getDeclaredField("$VALUES");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        valuesField.setAccessible(true);
        try {
            List<RailType> result = Arrays.asList((RailType[]) valuesField.get(null));

            boolean customRailRead = false;

            for (RailType rail: result) {
                if (rail.speedLimit == 100) customRailRead = true;
                if (customRailRead) customRails.add(rail);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static public RailType getSpecifiedRail(int speedLimit) {
        RailType result = null;

        for (RailType rail: customRails) {
            if (rail.speedLimit == speedLimit) {
                result = rail;
                break;
            }
        }

        return result;
    }
}
