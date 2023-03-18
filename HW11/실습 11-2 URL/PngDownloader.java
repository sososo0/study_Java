import java.io.*;
import java.net.URL;

import java.nio.file.*;

public class PngDownloader {
    public static Path get(String a){
        try {
            URL url = new URL(a);
            InputStream in  = url.openStream();
            File file = new File("png");
            FileOutputStream fos = new FileOutputStream(file);

            while(true){
                int data = in.read();
                if(data == -1){
                    break;
                }
                fos.write(data);
            }
            in.close();
            fos.close();

            return Paths.get(file.getPath());
        }catch (IOException e){
            return Paths.get(a);
        }
    }
}