
package netflix;

import java.util.Calendar;

public class Calender {

    public static void printDateTime(Calendar cal) {
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH)+1;
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        int mi= cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);
    }

}
