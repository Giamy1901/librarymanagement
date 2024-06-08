package qltv.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class CalendarAdapter {
    public static String formatCalendar(GregorianCalendar c){
		return String.format("%02d-%02d-%02d",c.get(GregorianCalendar.DATE),c.get(GregorianCalendar.MONTH),c.get(GregorianCalendar.YEAR));
	}
   
	
	public static String getCurrentDate(){
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(d);
	}
	
	public static String SQLDateToString(java.sql.Date d){
		String r = new String();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		r = dateFormat.format(d);
		return r;
	}
	
	public static String DateToString(Date d){
		String r = new String();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		r = dateFormat.format(d);
		return r;
	}
        public static String StringToDatee(String s){
            String[] spl = new String[3];
            spl = s.split("-");
            String str = null;
            str = spl[2] + "-" + spl[1] + "-" + spl[0];
            return str;
            
        }
        
        // 30-10-2016 -> 10/30/2016
        
        public static String StringToDateUpdate(String s){
            String[] spl = new String[3];
            spl = s.split("-");
            String str = null;
            str = spl[1] + "/" + spl[0] + "/" + spl[2];
            return str;
        }
                
                
	public static Date StringToDate(String s){
		if(s==null) return new Date();
		String [] spl = new String[3];
		spl = s.split("-",3);
		int date = Integer.parseInt(spl[0]), month = Integer.parseInt(spl[1]), year = Integer.parseInt(spl[2]);
		
		@SuppressWarnings("deprecation")
		Date d = new Date(year-1900,month-1,date);
		return d;
	}
        
        public static GregorianCalendar SQLDateToCal(java.sql.Date d){
            if(d==null) return null;
            String s = SQLDateToString(d);
            String [] spl = new String[3];
            spl = s.split("-",3);
            return new GregorianCalendar(Integer.parseInt(spl[2]),Integer.parseInt(spl[1]),Integer.parseInt(spl[0]));
        }
}
