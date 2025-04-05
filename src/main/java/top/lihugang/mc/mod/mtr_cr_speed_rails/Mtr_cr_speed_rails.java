package top.lihugang.mc.mod.mtr_cr_speed_rails;

import mtr.MTRFabric;
import mtr.RegistryObject;
import mtr.item.ItemRailModifier;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Mtr_cr_speed_rails implements ModInitializer {

    static RegistryObject<Item> RAIL_CONNECTOR_100 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(100));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_100_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(100));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_140 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(140));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_140_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(140));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_170 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(170));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_170_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(170));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_220 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(220));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_220_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(220));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_250 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(250));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_250_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(250));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_260 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(260));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_260_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(260));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_275 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(275));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_275_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(275));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_290 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(290));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_290_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(290));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_310 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(310));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_310_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(310));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_350 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(350));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_350_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(350));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_355 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(355));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_355_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(355));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_380 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(380));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_380_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(380));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_400 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(400));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_400_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(400));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_420 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(420));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_420_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(420));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_450 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(450));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_450_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(450));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_486 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(486));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_486_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(486));
    });


    static RegistryObject<Item> RAIL_CONNECTOR_500 = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, false, RailFetcher.getSpecifiedRail(500));
    });
    static RegistryObject<Item> RAIL_CONNECTOR_500_ONE_WAY = new RegistryObject(() -> {
        return new ItemRailModifier(true, false, true, true, RailFetcher.getSpecifiedRail(500));
    });


    @Override
    public void onInitialize() {
        try {
            Method method = MTRFabric.class.getDeclaredMethod("registerItem", String.class, RegistryObject.class);
            method.setAccessible(true);
            method.invoke(null, "rail_connector_100", RAIL_CONNECTOR_100);
            method.invoke(null, "rail_connector_100_oneway", RAIL_CONNECTOR_100_ONE_WAY);

            method.invoke(null, "rail_connector_140", RAIL_CONNECTOR_140);
            method.invoke(null, "rail_connector_140_oneway", RAIL_CONNECTOR_140_ONE_WAY);

            method.invoke(null, "rail_connector_170", RAIL_CONNECTOR_170);
            method.invoke(null, "rail_connector_170_oneway", RAIL_CONNECTOR_170_ONE_WAY);

            method.invoke(null, "rail_connector_220", RAIL_CONNECTOR_220);
            method.invoke(null, "rail_connector_220_oneway", RAIL_CONNECTOR_220_ONE_WAY);

            method.invoke(null, "rail_connector_250", RAIL_CONNECTOR_250);
            method.invoke(null, "rail_connector_250_oneway", RAIL_CONNECTOR_250_ONE_WAY);

            method.invoke(null, "rail_connector_260", RAIL_CONNECTOR_260);
            method.invoke(null, "rail_connector_260_oneway", RAIL_CONNECTOR_260_ONE_WAY);

            method.invoke(null, "rail_connector_275", RAIL_CONNECTOR_275);
            method.invoke(null, "rail_connector_275_oneway", RAIL_CONNECTOR_275_ONE_WAY);

            method.invoke(null, "rail_connector_290", RAIL_CONNECTOR_290);
            method.invoke(null, "rail_connector_290_oneway", RAIL_CONNECTOR_290_ONE_WAY);

            method.invoke(null, "rail_connector_310", RAIL_CONNECTOR_310);
            method.invoke(null, "rail_connector_310_oneway", RAIL_CONNECTOR_310_ONE_WAY);

            method.invoke(null, "rail_connector_350", RAIL_CONNECTOR_350);
            method.invoke(null, "rail_connector_350_oneway", RAIL_CONNECTOR_350_ONE_WAY);

            method.invoke(null, "rail_connector_355", RAIL_CONNECTOR_355);
            method.invoke(null, "rail_connector_355_oneway", RAIL_CONNECTOR_355_ONE_WAY);

            method.invoke(null, "rail_connector_380", RAIL_CONNECTOR_380);
            method.invoke(null, "rail_connector_380_oneway", RAIL_CONNECTOR_380_ONE_WAY);

            method.invoke(null, "rail_connector_400", RAIL_CONNECTOR_400);
            method.invoke(null, "rail_connector_400_oneway", RAIL_CONNECTOR_400_ONE_WAY);

            method.invoke(null, "rail_connector_420", RAIL_CONNECTOR_420);
            method.invoke(null, "rail_connector_420_oneway", RAIL_CONNECTOR_420_ONE_WAY);

            method.invoke(null, "rail_connector_450", RAIL_CONNECTOR_450);
            method.invoke(null, "rail_connector_450_oneway", RAIL_CONNECTOR_450_ONE_WAY);

            method.invoke(null, "rail_connector_486", RAIL_CONNECTOR_486);
            method.invoke(null, "rail_connector_486_oneway", RAIL_CONNECTOR_486_ONE_WAY);

            method.invoke(null, "rail_connector_500", RAIL_CONNECTOR_500);
            method.invoke(null, "rail_connector_500_oneway", RAIL_CONNECTOR_500_ONE_WAY);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
