package top.lihugang.mc.mod.mtr_cr_speed_rails;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.registry.CreativeModeTabHolder;
import org.mtr.mod.CreativeModeTabs;
import org.mtr.mod.Init;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mtr_cr_speed_rails.MODID)
public class Mtr_cr_speed_rails {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "mtr_cr_speed_rails";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "mtr_cr_speed_rails" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "mtr_cr_speed_rails" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final Object railConnector100  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_100"),
            (itemSettings) -> {
        return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                CustomRailType.RAIL_100,
                itemSettings));
    }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector100oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_100_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_100,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector140  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_140"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_140,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector140oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_140_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_140,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector170  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_170"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_170,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector170oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_170_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_170,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector220  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_220"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_220,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector220oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_220_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_220,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector250  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_250"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_250,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector250oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_250_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_250,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector275  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_275"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_275,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector260  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_260"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_260,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector260oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_260_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_260,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector275oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_275_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_275,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector290  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_290"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_290,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector290oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_290_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_290,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector310  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_310"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_310,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector310oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_310_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_310,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector350  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_350"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_350,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector350oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_350_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_350,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector355  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_355"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_355,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector355oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_355_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_355,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector380  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_380"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_380,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector380oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_380_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_380,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector400  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_400"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_400,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector400oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_400_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_400,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector420  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_420"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_420,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector420oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_420_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_420,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector450  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_450"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_450,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector450oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_450_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_450,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector486  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_486"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_486,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector486oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_486_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_486,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector500  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_500"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, false,
                        CustomRailType.RAIL_500,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});
    public static final Object railConnector500oneWay  = Init.REGISTRY.registerItem(new Identifier(MODID,
                    "rail_connector_500_oneway"),
            (itemSettings) -> {
                return new org.mtr.mapping.holder.Item(new CustomItemRailModifier(true, false, true, true,
                        CustomRailType.RAIL_500,
                        itemSettings));
            }, new CreativeModeTabHolder[]{CreativeModeTabs.CORE});

    public Mtr_cr_speed_rails() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
    }
}
