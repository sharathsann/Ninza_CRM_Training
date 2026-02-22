package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
    public int randomNumber()
    
    {
	Random r = new Random();
	int randcount=r.nextInt(1000);
	return randcount;
	
    }
    
    public String dateAndTime(int days)
    {
    	Date d=new Date();
    	SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
    	s.format(d);
    	Calendar cal = s.getCalendar();
    	
		cal.add(Calendar.DAY_OF_MONTH,days);
    	
    	String datareq = s.format(cal.getTime());
    	return datareq;
    }
}
