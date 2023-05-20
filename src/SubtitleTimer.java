import java.util.stream.Stream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class SubtitleTimer {

    public static String updateTimer(String initialTimer, String endTimer, int offset) {

        int[] initial = splitTimer(initialTimer);
        int[] end = splitTimer(endTimer);
        
        int initialHours = initial[0];
        int initialMinutes = initial[1];
        int initialSeconds = initial[2];
        int initialMiliseconds = initial[3];

        int endHours = end[0];
        int endMinutes = end[1];
        int endSeconds = end[2];
        int endMiliseconds = end[3];

        String timePattern = "HH:mm:ss,SSS";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);

        LocalTime initFinaltime = LocalTime.of(initialHours, initialMinutes, initialSeconds)
                .plus(initialMiliseconds + offset, ChronoUnit.MILLIS);

        LocalTime endFinalTime = LocalTime.of(endHours, endMinutes, endSeconds)
                .plus(endMiliseconds + offset, ChronoUnit.MILLIS);


        long initialTimerInMiliseconds = transformToMiliseconds(initialHours, initialMinutes,
                initialSeconds, initialMiliseconds);

        long endTimerInMiliseconds = transformToMiliseconds(endHours, endMinutes, endSeconds,
                endMiliseconds);

        if ((initialTimerInMiliseconds + offset) < 0) {
            initFinaltime = LocalTime.of(00, 00, 00).plus(000,
                    ChronoUnit.MILLIS);
        }
        if ((endTimerInMiliseconds + offset) < 0) {
            endFinalTime = LocalTime.of(00, 00, 00).plus(000,
                    ChronoUnit.MILLIS);
        }

        return initFinaltime.format(timeFormatter) + " --> " + endFinalTime.format(timeFormatter);
    }

    public static int[] splitTimer(String timer) {
        String[] arr = timer.replace(",", ":").split(":");
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }

    public static long transformToMiliseconds(int hours, int minutes, int seconds, int miliseconds) {
        long res = 0;
        res += hours * 3600000;
        res += minutes * 60000;
        res += seconds * 1000;
        res += miliseconds;
        return res;
    }

}
