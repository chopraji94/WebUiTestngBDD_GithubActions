package Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Commons {

    public static String getDateTime(String dateTimeFormat){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        Date date = new Date();
        LocalDateTime now = LocalDateTime.now();
        return now.format(dateFormat);
    }
}

