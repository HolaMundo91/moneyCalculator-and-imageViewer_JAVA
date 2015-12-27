package kata1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private final String name;
    private final String surName;
    private final Calendar birthday;
    private long MILLESECOND_PER_YEAR = (long) (1000*60*60*24*365.25);

    public Person(String name, String surName, Calendar birthday) {
        this.name = name;
        this.surName = surName;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Calendar getBirthday() {
        return birthday;
    }
    
    public String getFullName() {
        return name + " " + surName;
    }
    
    public int getAge() {
        Calendar today = GregorianCalendar.getInstance();
        
        return (int) getMillis(today.getTimeInMillis() - birthday.getTimeInMillis());
    }
    
    private long getMillis(long milli) {
        return milli/MILLESECOND_PER_YEAR;
    }

}
