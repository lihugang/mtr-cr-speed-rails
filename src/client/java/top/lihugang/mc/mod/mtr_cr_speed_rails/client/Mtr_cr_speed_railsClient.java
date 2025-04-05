package top.lihugang.mc.mod.mtr_cr_speed_rails.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.text.Text;
import top.lihugang.mc.mod.mtr_cr_speed_rails.RailFetcher;

public class Mtr_cr_speed_railsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if (client.player != null) {
                if (RailFetcher.getSpecifiedRail(486) != null) {
                    client.player.sendMessage(Text.translatable("msg.mtr_cr_speed_rails.mixin.success"), false);
                    client.player.sendMessage(Text.translatable("msg.mtr_cr_speed_rails.alert"), false);
                } else {
                    client.player.sendMessage(Text.translatable("msg.mtr_cr_speed_rails.mixin.failure"), false);
                }
            }
        });
    }
}
