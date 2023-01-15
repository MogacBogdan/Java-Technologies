package info.uaic.ro.laboratory7;

import info.uaic.ro.laboratory7.services.DocumentService;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Stateless
@Asynchronous
public class DocumentTracker {
    private static final Logger logger = Logger.getLogger(DocumentService.class.getName());
    FileHandler fileHandler;

    public DocumentTracker() {
        try {
            fileHandler = new FileHandler("doc.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fileHandler);
    }

    public void log(String message) {
        logger.info(message);
    }
}
