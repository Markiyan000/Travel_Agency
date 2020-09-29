package app.utils;

import java.time.LocalDate;
import java.util.stream.Stream;

public class LocalDates {

    public static LocalDate minDate(LocalDate first, LocalDate two) {
        return Stream.of(first, two).min(LocalDate::compareTo).get();
    }

    public static LocalDate maxDate(LocalDate first, LocalDate two) {
        return Stream.of(first, two).max(LocalDate::compareTo).get();
    }

    public static boolean checkDates(LocalDate first, LocalDate second) {
        return !first.isEqual(second) && first.isBefore(second);
    }
}
