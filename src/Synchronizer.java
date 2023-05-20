public class Synchronizer {

    public static boolean synchronizeContent(String path, int offset) {

        if (offset == 0) {
            System.out.println("The offset value must be nonzero");
            return false;
        }

        String[] splitedContent = transformToStringArray(FileIO.read(path), "\n\n");
        
        if (splitedContent.length <= 1) {
            System.out.println("The file appears to be empty");
            return false;
        }
        String contentToWrite = synchronizeTime(splitedContent, offset);
        FileIO.write(contentToWrite);

        return true;
    }

    public static String[] transformToStringArray(String content, String separator) {
        return content.split(separator);

    }

    public static String synchronizeTime(String[] content, int offset) {
        String res = "";
        int counter = 1;
        for (String subtitle : content) {
            String[] temp = transformToStringArray(subtitle, "\n");
            String[] time = transformToStringArray(temp[1], " --> ");

            String currentUpdated = "";
            String updatedTimer = SubtitleTimer.updateTimer(time[0], time[1], offset);

            for (int i = 0; i < temp.length; i++) {
                if (i == 0) {
                    currentUpdated += counter + "\n";
                    counter++;
                } else if (i == 1) {
                    currentUpdated += updatedTimer + "\n";
                } else {
                    currentUpdated += temp[i] + "\n";
                }
            }
            res += currentUpdated + "\n";
        }
        return res;

    }

}
