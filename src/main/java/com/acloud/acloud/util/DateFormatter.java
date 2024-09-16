package com.acloud.acloud.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String dateToDMY(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String[] fDate = simpleDateFormat.format(date).split("-");

        String result = "";

        switch (fDate[2].substring(fDate[2].length() - 1)) {
            case "1":
                result += fDate[2] + "st";
                break;
            case "2":
                result += fDate[2] + "nd";
                break;
            case "3":
                result += fDate[2] + "rd";
                break;
            default:
                result += fDate[2] + "th";
                break;
        }

        switch (fDate[1]) {
            case "01":
                result += " Jan";
                break;
            case "02":
                result += " Feb";
                break;
            case "03":
                result += " Mar";
                break;
            case "04":
                result += " Apr";
                break;
            case "05":
                result += " May";
                break;
            case "06":
                result += " Jun";
                break;
            case "07":
                result += " Jul";
                break;
            case "08":
                result += " Aug";
                break;
            case "09":
                result += " Sep";
                break;
            case "10":
                result += " Oct";
                break;
            case "11":
                result += " Nov";
                break;
            case "12":
                result += " Dec";
                break;
            default:
                result += " ??";
                break;
        }
        
        result += ", " + fDate[0];

        return result;
    }
}
