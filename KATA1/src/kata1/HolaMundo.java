package kata1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HolaMundo {
	
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        System.out.println("Adiossssss Mundo");

        Calendar f1 = GregorianCalendar.getInstance();
        f1.set(1991, 8, 3);
        Person p1 = new Person("Pablito", "Diaz", f1);
        System.out.println(p1.getFullName());
        System.out.println(p1.getAge() + " años");
    }
}