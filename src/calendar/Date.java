package calendar;
public class Date implements Comparable<Date>{

    private int day, month, year;
    private String monthName;
    private int format;
    public Date(){ // La fecha predeterminada es el 1 de enero de 2017. El formato predeterminado es 0 (cero)
        this(1, 1, 2017, 0);
    }
    public Date(int day, int month, int year){
        this(day, month, year, 0);
    }
    public Date(int day, int month, int year, int format){
        this.setFormat(format);
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }
    // Rango de valores permitidos para day :
    //   [1..30] si month∈{4 ,6 ,9,11}
    //   [1..28] si month=2
    //   [1..31] si month∈{1, 3,5, 7, 8 ,10 ,12}
    public void setDay(int day) {
        if (this.getMonth() == 2 && day >= 1 && day <= 28){
            this.day = day;
        } else if ((this.getMonth() == 4 || this.getMonth() == 6 || this.getMonth() == 9 || this.getMonth() == 11) && day >= 1 && day <= 30){
            this.day = day;
        } else if ((this.getMonth() == 1 || this.getMonth() == 3 || this.getMonth() == 5 || this.getMonth() == 7 || this.getMonth() == 8 || this.getMonth() == 10 || this.getMonth() == 12) && day >= 1 && day <= 31){
            this.day = day;
        }
    }

    public void setMonth(int month) { // Rango de valores permitidos para month : [1..12]
        if (month >= 1 && month <= 12){
            this.month = month;
        }
        // El método setMonth debe también actualizar el nombre del mes
        // Rango de valores permitidos para monthName = [“Enero”, “Febrero”,… “Diciembre”]
        switch (month) {
            case 1 -> this.monthName = "Enero";
            case 2 -> this.monthName = "Febrero";
            case 3 -> this.monthName = "Marzo";
            case 4 -> this.monthName = "Abril";
            case 5 -> this.monthName = "Mayo";
            case 6 -> this.monthName = "Junio";
            case 7 -> this.monthName = "Julio";
            case 8 -> this.monthName = "Agosto";
            case 9 -> this.monthName = "Septiembre";
            case 10 -> this.monthName = "Octubre";
            case 11 -> this.monthName = "Noviembre";
            case 12 -> this.monthName = "Diciembre";
        }
    }

    public void setYear(int year) { // Rango de valores permitidos para year : [1900 .. 3000]
        if (year >= 1900 && year <= 3000){
            this.year = year;
        }
    }

    public void setFormat(int format) { // Rango de valores permitidos para format : [0..2]
        if (format >= 0 && format <= 2){
            this.format = format;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMonthName() {
        return monthName;
    }

    public int getFormat() {
        return format;
    }

    // Método para retornar una string con la fecha dependiendo del formato
    public String toString(){
        // El método toString debe regresar (se considera la fecha predeterminada para fines del ejemplo):
        //   i. “01/01/17”, si format = 0
        //   ii. “1-Ene-2017”, si format = 1
        //   iii. “1 de enero de 2017”, si format = 2
        int format = this.getFormat();
        String date = "";
        switch (format) {
            case 0 -> date = String.format("%02d/%02d/%02d", this.getDay(), this.getMonth(), this.getYear() % 100);
            case 1 -> date = String.format("%d-%s-%d", this.getDay(), this.getMonthName().substring(0, 3), this.getYear());
            case 2 -> date = String.format("%d de %s de %d", this.getDay(), this.getMonthName(), this.getYear());
        }
        return date;
    }

    @Override
    public boolean equals(Object o){ // El método equals(obj) devuelve: true, si el día, mes y año de obj parámetro son iguales al més día y año de este objeto. false, en cualquier otro caso.
        //   Muy importante, la implementación del método equals debe ser una sobreescritura del método equals definido en la clase Object.
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Date date = (Date) o;

        return this.getDay() == date.getDay() && this.getMonth() == date.getMonth() && this.getYear() == date.getYear();
    }
    public Date clone(){ // El método clone devuelve: un objeto de tipo mx.iteso.calendar.Date con los valores actuales de los cuatro atributos de la clase.
        Date date = new Date();
        date.setDay(this.getDay());
        date.setMonth(this.getMonth());
        date.setYear(this.getYear());
        date.setFormat(this.getFormat());
        return date;
    }
    public void next(){ // El método next, asigna a todos los atributos los valores correspondientes al día siguiente.
        if (this.getDay() == 31 && this.getMonth() == 12){
            this.setDay(1);
            this.setMonth(1);
            this.setYear(this.getYear() + 1);
        } else if (this.getDay() == 28 && this.getMonth() == 2){
            this.setDay(1);
            this.setMonth(3);
        } else if (this.getDay() == 30 && this.getMonth() == 4){
            this.setDay(1);
            this.setMonth(5);
        } else if (this.getDay() == 30 && this.getMonth() == 6){
            this.setDay(1);
            this.setMonth(7);
        } else if (this.getDay() == 30 && this.getMonth() == 9){
            this.setDay(1);
            this.setMonth(10);
        } else if (this.getDay() == 30 && this.getMonth() == 11){
            this.setDay(1);
            this.setMonth(12);
        } else if (this.getDay() == 31){
            this.setDay(1);
            this.setMonth(this.getMonth() + 1);
        } else {
            this.setDay(this.getDay() + 1);
        }
    }
    @Override
    public int compareTo(Date other) {
        if (this.getYear() > other.getYear()) {
            return 1;
        } else if (this.getYear() < other.getYear()) {
            return -1;
        } else {
            if (this.getMonth() > other.getMonth()) {
                return 1;
            } else if (this.getMonth() < other.getMonth()) {
                return -1;
            } else {
                if (this.getDay() > other.getDay()) {
                    return 1;
                } else if (this.getDay() < other.getDay()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
