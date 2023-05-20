public class App {
    public static void main(String[] args) throws Exception {

        // update the value bellow with your subtitle path 
        // and dont forget to add doble \ on each subdirectory
        
        String filepath = "C:\\Users\\default\\folder\\srtfile.srt";

        // change the value bellow and remember to set in miliseconds
        // example => offset = 1000
        // other example => offset = -1000
        // the value should be a nonzero integer. Can be positive or negative.

        int offsetInMiliseconds = 2000;

        Synchronizer.synchronizeContent(filepath, offsetInMiliseconds);
    }
}
