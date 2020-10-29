

public class GregorianDate extends Date {


    GregorianDate() {
        super(1970, 1, 1);
        long now = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        long daysSince1970 = (now / (1000 * 60 * 60 * 24));
        addDays(daysSince1970);

    }

    GregorianDate(int year, int month, int day) {
        super(year, month, day);
    }

    @Override
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }


}







