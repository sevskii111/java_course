import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lab1 {
    public static String formCalendarForMonth(int year, int month, int offset) {
        ArrayList<String> monthCalendarStrLines = new ArrayList<>();
        monthCalendarStrLines.add("LABEL WILL BE HERE");
        Calendar calendar = new GregorianCalendar(year, month, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) + (offset - 1);
        dayOfWeek = dayOfWeek % 7 + dayOfWeek / 7;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<String> dayNamesList = Arrays.asList(DateFormatSymbols.getInstance().getShortWeekdays());
        Collections.rotate(dayNamesList, dayNamesList.size() - (offset));

        String[] dayNames = dayNamesList.toArray(new String[0]);
        monthCalendarStrLines.add(" " + " ".repeat(3 - dayNames[0].length())
                + String.join(" " + " ".repeat(3 - dayNames[0].length()), dayNames));

        StringBuilder monthCalendarStrLine;
        for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
            if (dayOfMonth == 1) {
                monthCalendarStrLine = new StringBuilder(" ".repeat((dayOfWeek - 1) * 4 + 2));
            } else {
                monthCalendarStrLine = new StringBuilder(" ".repeat(2));
            }
            for (int j = i == 0 ? dayOfWeek - 1 : 0; j < 7 && (dayOfMonth <= daysInMonth); j++) {
                monthCalendarStrLine.append(String.format("%2d  ", dayOfMonth));
                dayOfMonth++;
            }
            monthCalendarStrLines.add(monthCalendarStrLine.toString());
        }

        while (monthCalendarStrLines.size() < 8) {
            monthCalendarStrLines.add("");
        }

        int maxLen = 0;
        for (String line : monthCalendarStrLines) {
            maxLen = Math.max(maxLen, line.length());
        }

        String label = new SimpleDateFormat("LLLL").format(calendar.getTime());
        int labelOffset = maxLen / 2 - label.length() / 2;
        monthCalendarStrLines.set(0, " ".repeat(labelOffset) + label);

        for (int i = 0; i < monthCalendarStrLines.size(); i++) {
            monthCalendarStrLines.set(i,
                    monthCalendarStrLines.get(i) + " ".repeat(maxLen - monthCalendarStrLines.get(i).length()));
        }

        return String.join(System.lineSeparator(), monthCalendarStrLines);
    }

    public static String formCalendarForYear(int year, int width, int offset) {
        StringBuilder yearCalendarStr = new StringBuilder();
        int cols = (int) Math.ceil(12. / width);
        for (int col = 0; col < cols; col++) {
            String calendarForMonth = formCalendarForMonth(year, col * width, offset);
            String[] yearCalendarRowStrs = calendarForMonth.split(System.lineSeparator());
            for (int row = 1; row < width && col * width + row < 12; row++) {
                String[] calendarForMonthLines = formCalendarForMonth(year, col * width + row, offset)
                        .split(System.lineSeparator());
                for (int l = 0; l < calendarForMonthLines.length; l++) {
                    yearCalendarRowStrs[l] += " ".repeat((5)) + calendarForMonthLines[l];
                }

            }
            yearCalendarStr.append(String.join(System.lineSeparator(), yearCalendarRowStrs))
                    .append(System.lineSeparator().repeat(2));
        }
        return yearCalendarStr.toString();
    }

    public static void main(String[] args) {
        int offset = 1;
        if (args.length > 0) {
            offset = Integer.parseInt(args[0]);
        }

        System.out.println(formCalendarForYear(2021, 3, offset));

    }

}
