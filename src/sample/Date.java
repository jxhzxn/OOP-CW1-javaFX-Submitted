package sample;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(){

    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.day = month;
        this.day = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
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

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}