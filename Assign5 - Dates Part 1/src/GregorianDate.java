

public class GregorianDate {
    private int currDay = 1;
    private int currMonth = 1;
    private int currYear = 1970;

    GregorianDate () {
        long now = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        long daysSince1970 = (now/(1000 * 60 * 60 * 24));
        addDays(daysSince1970);

    }
    GregorianDate(int year, int month, int day) {
        this.currYear = year;
        this.currMonth = month;
        this.currDay = day;
    }
    void printShortDate() {
        System.out.printf("%d/%d/%d", currMonth,currDay,currYear);
    }
    void printLongDate() {
        System.out.printf("%s %d, %d", getCurrentMonthName(), currDay,currYear);

    }
    int getCurrentYear () {
        return currYear;
    }
    int getCurrentMonth() {
        return currMonth;
    }

    String getCurrentMonthName() {
        return getMonthName(currMonth);
    }
    int getCurrentDayOfMonth() {
        return currDay;
    }
    void addDays(long days) {
        for (int i = 0; i < days; i++) {
            currDay++;
            if (currDay > getNumberOfDaysInMonth(currYear, currMonth)) {
                currMonth ++;
                currDay = 1;
            }
            if (currMonth > 12) {
                currYear ++;
                currMonth = 1;
            }
        }
    }
    void subtractDays(int days) {
        for (int i = 0; i < days; i++) {
            currDay--;
            if (currDay == 0) {
                currMonth --;
                if (currMonth == 0) {
                    currYear --;
                    currMonth = 12;
                }
                currDay = getNumberOfDaysInMonth(currYear,currMonth);
            }

        }
    }
    boolean isLeapYear() {
        if ((currYear % 4 == 0) && (currYear % 100 != 0) || (currYear % 400 == 0)){
            return true;
        }
        return false;
    }

    private int getNumberOfDaysInMonth(int year, int month){


        currYear = year;
        currMonth = month;
        String monthName = "";
        int numOfDays = 0;
        switch (currMonth) {
            case 1:
                monthName = "January";
                numOfDays = 31;
                break;
            case 2:
                monthName = "February";
                if (isLeapYear()) {
                    numOfDays = 29;
                } else {
                    numOfDays = 28;
                }
                break;
            case 3:
                monthName = "March";
                numOfDays = 31;
                break;
            case 4:
                monthName = "April";
                numOfDays = 30;
                break;
            case 5:
                monthName = "May";
                numOfDays = 31;
                break;
            case 6:
                monthName = "June";
                numOfDays = 30;
                break;
            case 7:
                monthName = "July";
                numOfDays = 31;
                break;
            case 8:
                monthName = "August";
                numOfDays = 31;
                break;
            case 9:
                monthName = "September";
                numOfDays = 30;
                break;
            case 10:
                monthName = "October";
                numOfDays = 31;
                break;
            case 11:
                monthName = "November";
                numOfDays = 30;
                break;
            case 12:
                monthName = "December";
                numOfDays = 31;
                break;
        }

        return numOfDays;
    }
    int getNumberOfDaysInYear(int year) {
        currYear = year;
        if (isLeapYear()) {
            return 366;
        }
        return 365;
    }
    String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                if (isLeapYear()) {
                }
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }



}







