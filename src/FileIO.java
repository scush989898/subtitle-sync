import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class FileIO {
    public static String read(String filepath) {
        String content = "";
        try {
            Path path = Paths.get(filepath).normalize();
            BufferedReader reader = Files.newBufferedReader(path);
            String line;

            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
            reader.close();

        } catch (IOException e) {
            return "Wrong filepath";
        }
        return content;
    }

    public static void write(String content) {
        try {
            Path path = Paths.get("output/shifted.srt").normalize();

            BufferedWriter writer = Files.newBufferedWriter(path);
            String[] splited = content.split("\n");
            for (String line : splited) {
                writer.write(line + "\n");

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
