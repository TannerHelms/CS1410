

public class JulianDate extends Date {


    JulianDate() {
        super(1, 1, 1);
        long now = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        long daysSince1 = 719164 + now / (1000 * 60 * 60 * 24);
        addDays(daysSince1);

    }

    JulianDate(int year, int month, int day) {
        super(year, month, day);
    }
    @Override
    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
