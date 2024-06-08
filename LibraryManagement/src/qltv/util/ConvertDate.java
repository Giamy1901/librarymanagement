package qltv.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ConvertDate {
    // Chuyển date java sang sql
    public static java.sql.Date convertDate(Date date){
        if(date != null)
        return new java.sql.Date(date.getTime());
        return null;
    }
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
         // Lấy ra ngày hiện tại
        System.out.println(sdf.format(new Date()));
    }
    
    
    
}
