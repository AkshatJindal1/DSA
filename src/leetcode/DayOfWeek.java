package leetcode;

public class DayOfWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"}; // 1/1/1971 was friday

        int numDays = day - 1;
        for(int i = 1; i < month; ++i) numDays += daysInMonths[i - 1];
        System.out.println(numDays);
        if(((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month > 2) numDays++; // for leap year
        for(int i = 1971; i < year; ++i)
            numDays += ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) ? 366 : 365;
        System.out.println(numDays);
        return days[numDays % 7];
    }

    public static void main(String[] args) {
        System.out.println(new DayOfWeek().dayOfTheWeek(29, 2, 2016));
        System.out.println(new DayOfWeek().dayOfTheWeek(31, 8, 2019));
    }
}
