import org.bytedeco.javacpp.*;

import java.io.File;

import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;

public class Reader {
    public String read(File file) {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init("src", "lav") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead(file.getAbsolutePath());
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        String res = outText.getString();

        api.End();
        outText.deallocate();
        pixDestroy(image);

        return res;
    }
}