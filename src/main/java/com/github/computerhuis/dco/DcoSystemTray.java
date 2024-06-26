package com.github.computerhuis.dco;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Component
public class DcoSystemTray {

    private final ApplicationContext applicationContext;

    @Value("${server.port}")
    private String serverPort;
    @Value("${server.address:localhost}")
    private String serverIp;

    public void close() {
        log.info("Stop running spotj");

        val tray = java.awt.SystemTray.getSystemTray();
        for (val icon : tray.getTrayIcons()) {
            tray.remove(icon);
        }

        try {
            SpringApplication.exit(applicationContext);
        } catch (Exception ise) {
            // probably is application is already closed
            log.debug("IllegalStateException: {}", ise.getMessage());
        }
        try {
            Thread.sleep(1010);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public void start() {
        EventQueue.invokeLater(() -> {
            try {
                val menu = new PopupMenu();
                var open = new MenuItem("Open balie");
                open.addActionListener(e -> {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://%s:%s/balie.faces".formatted(serverIp, serverPort)));
                            } catch (Exception browserE) {
                                log.error("Exception: {}", browserE.getMessage());
                            }
                        }
                    }
                );
                menu.add(open);

                open = new MenuItem("Open educatie");
                open.addActionListener(e -> {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://%s:%s/educatie.faces".formatted(serverIp, serverPort)));
                            } catch (Exception browserE) {
                                log.error("Exception: {}", browserE.getMessage());
                            }
                        }
                    }
                );
                menu.add(open);

                open = new MenuItem("Open werkplaats");
                open.addActionListener(e -> {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://%s:%s/werkplaats.faces".formatted(serverIp, serverPort)));
                            } catch (Exception browserE) {
                                log.error("Exception: {}", browserE.getMessage());
                            }
                        }
                    }
                );
                menu.add(open);

                open = new MenuItem("Open admin");
                open.addActionListener(e -> {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://%s:%s/admin.faces".formatted(serverIp, serverPort)));
                            } catch (Exception browserE) {
                                log.error("Exception: {}", browserE.getMessage());
                            }
                        }
                    }
                );
                menu.add(open);

                val close = new MenuItem("Afsluiten");
                close.addActionListener(e -> close());
                menu.add(close);

                val tray = java.awt.SystemTray.getSystemTray();

                // Remove old
                for (val icon : tray.getTrayIcons()) {
                    tray.remove(icon);
                }

                // Add new
                val image = new ImageIcon(DcoSystemTray.class.getResource("/logo.png")).getImage();
                val trayIcon = new TrayIcon(image, "DCO", menu);
                trayIcon.setImageAutoSize(true);
                tray.add(trayIcon);
            } catch (Exception e) {
                log.warn("Exception: {}", e.getMessage());
            }
        });
    }
}
