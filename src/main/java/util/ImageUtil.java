package util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ImageUtil {
    public static String toBase64(String imagePath) throws Exception {
        byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
