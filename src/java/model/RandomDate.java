package model;

import java.time.LocalDate;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author quang
 */
public class RandomDate {
    public static Date randomDate() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();

        // set the calendar to a random date between 1900 and 2003
        calendar.set(Calendar.YEAR, 1900 + random.nextInt(104));
        calendar.set(Calendar.MONTH, random.nextInt(12));
        calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(31));

        return calendar.getTime();
    }

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
