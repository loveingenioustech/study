package demo.dates;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatesDemo
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        DatesDemo dd = new DatesDemo();
        dd.demoCalendar();
        dd.demoCalculateDates();
        dd.demoDiffer();
        dd.demoCompare();
    }

    public String formatDate(Calendar cal)
    {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("MMM dd yyyy hh:mm:ss aaa");
        return simpleFormatter.format(cal.getTime());
    }

    private void demoCalendar()
    {
        Calendar gCal = Calendar.getInstance();
        // Month is based upon a zero index, January is equal to 0,
        // so we need to add one to the month for it to be in
        // a standard format
        int month = gCal.get(Calendar.MONTH) + 1;
        int day = gCal.get(Calendar.DATE);
        int yr = gCal.get(Calendar.YEAR);
        String dateStr = month + "/" + day + "/" + yr;
        System.out.println(dateStr);

        int dayOfWeek = gCal.get(Calendar.DAY_OF_WEEK);
        // Print out the integer value for the day of the week
        System.out.println(dayOfWeek);
        int hour = gCal.get(Calendar.HOUR);
        int min = gCal.get(Calendar.MINUTE);
        int sec = gCal.get(Calendar.SECOND);
        // Print out the time
        System.out.println(hour + ":" + min + ":" + sec);
        // Create new DateFormatSymbols instance to obtain the String
        // value for dates
        DateFormatSymbols symbols = new DateFormatSymbols();

        String[] days = symbols.getWeekdays();
        System.out.println(days[dayOfWeek]);
        // Get crazy with the date!
        int dayOfYear = gCal.get(Calendar.DAY_OF_YEAR);
        System.out.println(dayOfYear);
        // Print the number of days left in the year
        System.out.println("Days left in " + yr + ": " + (365 - dayOfYear));
        int week = gCal.get(Calendar.WEEK_OF_YEAR);
        // Print the week of the year
        System.out.println(week);
    }

    private void demoCalculateDates()
    {
        Calendar cal = Calendar.getInstance();
        System.out.println("January = " + Calendar.JANUARY);
        System.out.println("June = " + Calendar.JUNE);
        System.out.println("Current Date: " + formatDate(cal));
        // Add two months to current date
        cal.add(Calendar.MONTH, 2);
        System.out.println("Current Date Plus 2 Months: " + formatDate(cal));
        cal = Calendar.getInstance();
        // Subtract 8 months from current date
        cal.add(Calendar.MONTH, -8);
        System.out.println("Current Date Minus 8 Months: " + formatDate(cal));
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -8);
        System.out.println("Current Date Minus 8 Days: " + formatDate(cal));
        // Add 15 hours to current date
        cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 15);
        System.out.println("Current Date Plus 15 Hours: " + formatDate(cal));
    }

    private void demoDiffer()
    {
        // Obtain two instances of the Calendar class
        Calendar cal1 = Calendar.getInstance();

        Calendar cal2 = Calendar.getInstance();
        // Set the date to 01/01/2010:12:00
        cal2.set(2010, 0, 1, 12, 0);
        Date date1 = cal2.getTime();
        System.out.println(date1);
        long mill = Math.abs(cal1.getTimeInMillis() - date1.getTime());
        // Convert to hours
        long hours = TimeUnit.MILLISECONDS.toHours(mill);
        // Convert to days
        Long days = TimeUnit.HOURS.toDays(hours);
        String diff = String.format("%d hour(s) %d min(s)", hours, TimeUnit.MILLISECONDS.toMinutes(mill)
                - TimeUnit.HOURS.toMinutes(hours));
        System.out.println(diff);

        diff = String.format("%d days", days);
        System.out.println(diff);
        // Divide the number of days by seven for the weeks
        int weeks = days.intValue() / 7;
        diff = String.format("%d weeks", weeks);
        System.out.println(diff);
    }

    private void demoCompare()
    {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        // Set the date to 01/01/2010:12:00
        cal2.set(2010, 0, 1, 12, 0);
        System.out.println(formatDate(cal1) + " before " + formatDate(cal2) + "? " + cal1.before(cal2));
        System.out.println(cal2.compareTo(cal1));
    }

}
