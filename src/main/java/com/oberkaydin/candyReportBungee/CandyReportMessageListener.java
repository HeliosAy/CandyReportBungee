package com.oberkaydin.candyReportBungee;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CandyReportMessageListener implements Listener {

    private final CandyReportBungee plugin;

    public CandyReportMessageListener(CandyReportBungee plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPluginMessage(PluginMessageEvent event) {
        if (!event.getTag().equals("BungeeCord")) {
            return;
        }

        try (ByteArrayInputStream b = new ByteArrayInputStream(event.getData());
             DataInputStream in = new DataInputStream(b)) {

            String subChannel = in.readUTF();

            if (!subChannel.equals("Forward")) {
                return;
            }

            String target = in.readUTF(); // "ALL"
            String channel = in.readUTF(); // "candyreport:notification"

            if (!channel.equals("candyreport:notification")) {
                return;
            }

            short len = in.readShort();
            byte[] msgBytes = new byte[len];
            in.readFully(msgBytes);

            try (ByteArrayInputStream msgStream = new ByteArrayInputStream(msgBytes);
                 DataInputStream msgIn = new DataInputStream(msgStream)) {

                String reportedPlayer = msgIn.readUTF();
                String reporter = msgIn.readUTF();
                String reason = msgIn.readUTF();

                forwardNotificationToServers(reportedPlayer, reporter, reason);

            } catch (IOException e) {
                plugin.getLogger().severe("Failed to parse notification message: " + e.getMessage());
            }

        } catch (IOException e) {
            plugin.getLogger().severe("Failed to handle plugin message: " + e.getMessage());
        }
    }

    private void forwardNotificationToServers(String reportedPlayer, String reporter, String reason) {
        try (ByteArrayOutputStream b = new ByteArrayOutputStream();
             DataOutputStream out = new DataOutputStream(b)) {

            out.writeUTF(reportedPlayer);
            out.writeUTF(reporter);
            out.writeUTF(reason);

            plugin.getProxy().getServers().values().forEach(server -> {
                server.sendData("candyreport:notification", b.toByteArray());
            });

        } catch (IOException e) {
            plugin.getLogger().severe("Failed to forward notification: " + e.getMessage());
        }
    }
}