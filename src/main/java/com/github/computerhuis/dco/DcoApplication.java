package com.github.computerhuis.dco;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class DcoApplication {

    public static void main(final String... args) throws URISyntaxException, IOException {
        Locale.setDefault(Locale.of("nl", "NL"));

        val headless = GraphicsEnvironment.isHeadless();
        val application = new SpringApplicationBuilder(DcoApplication.class)
            .headless(headless)
            .run(args);

        if (!headless && SystemTray.isSupported()) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                log.warn("Exception: {}", e.getMessage());
            }

            EventQueue.invokeLater(() -> {
                val tray = application.getBean(DcoSystemTray.class);
                tray.start();
            });
        }
    }
}
