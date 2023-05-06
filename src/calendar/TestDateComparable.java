package calendar;
import java.util.ArrayList;
import java.util.Collections;

public class TestDateComparable {
    public static void main(String[] args){
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(1, 1, 2019);
        Date date3 = new Date(15, 5, 2021);
        Date date4 = new Date(15, 5, 2021);

        ArrayList<Date> dateList = new ArrayList<>();
        dateList.add(date1);
        dateList.add(date2);
        dateList.add(date3);
        dateList.add(date4);

        System.out.println("Lista de fechas sin ordenar:");
        for (Date date : dateList) {
            System.out.println(date.toString());
        }

        Collections.sort(dateList);

        System.out.println("Lista de fechas ordenada:");
        for (Date date : dateList) {
            System.out.println(date.toString());
        }
    }
}