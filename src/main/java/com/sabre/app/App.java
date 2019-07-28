package com.sabre.app;

import com.sabre.app.service.FileService;
import com.sabre.app.service.WordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger log = LogManager.getLogger(FileService.class);

    public static void main(String[] args) {
        log.info("App is starting...");
        if (args.length != 0) {
            WordService wordService = new WordService();
            wordService.computeFile(args[0]);

        } else {
            log.error("No args given!");
        }
        log.info("App is closing...");
    }
}
