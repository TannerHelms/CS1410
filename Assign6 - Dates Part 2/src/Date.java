public class Date {
    private int currDay;
    private int currMonth;
    private int currYear;


    Date(int year, int month, int day) {
        this.currDay = day;
        this.currMonth = month;
        this.currYear = year;

    }


    void printShortDate() {
        System.out.printf("%d/%d/%d", currMonth, currDay, currYear);
    }

    void printLongDate() {
        System.out.printf("%s %d, %d", getCurrentMonthName(), currDay, currYear);

    }

    int getYear() {
        return currYear;
    }

    int getMonth() {
        return currMonth;
    }

    String getCurrentMonthName() {
        return getMonthName(currMonth);
    }

    int getDayOfMonth() {
        return currDay;
    }


    void addDays(long days) {
        for (int i = 0; i < days; i++) {
            currDay++;
            if (currDay > getNumberOfDaysInMonth(currYear, currMonth)) {
                currMonth++;
                currDay = 1;
            }
            if (currMonth > 12) {
                currYear++;
                currMonth = 1;
            }
        }
    }

    void subtractDays(int days) {
        for (int i = 0; i < days; i++) {
            currDay--;
            if (currDay == 0) {
                currMonth--;
                if (currMonth == 0) {
                    currYear--;
                    currMonth = 12;
                }
                currDay = getNumberOfDaysInMonth(currYear, currMonth);
            }

        }
    }



    private int getNumberOfDaysInMonth(int year, int month) {
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
    public boolean isLeapYear(int year){
        return true;
    }

    public boolean isLeapYear() {
        return isLeapYear(this.currYear);
    }
}
