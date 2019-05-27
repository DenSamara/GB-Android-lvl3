package ru.home.denis.konovalov.homework;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Model implements Contract.Model{
    @Retention(SOURCE)
    @IntDef({HOUR, MINUTE, SECOND})
    public @interface ModelID{}
    public static final byte HOUR = 1;
    public static final byte MINUTE = 2;
    public static final byte SECOND = 3;

    private short hour;
    private short minute;
    private short second;

    public Model(){
        reset();
    }

//    public void setHour(short hour) {
//        this.hour = hour;
//    }
//
//    public void setMinute(short minute) {
//        this.minute = minute;
//    }
//
//    public void setSecond(short second) {
//        this.second = second;
//    }
//
//    public short getHour() {
//        return hour;
//    }
//
//    public short getMinute() {
//        return minute;
//    }
//
//    public short getSecond() {
//        return second;
//    }

    public void reset(){
        hour = 0;
        minute = 0;
        hour = 0;
    }

    @Override
    public void inc(@ModelID int id){
        switch (id){
            case HOUR:
                ++hour;
                break;
            case MINUTE:
                ++minute;
                break;
            case SECOND:
                ++second;
                break;
        }
    }

    @Override
    public short getData(@ModelID int id) {
        switch (id){
            case HOUR:
                return hour;
            case MINUTE:
                return minute;
            case SECOND:
                return second;
        }
        return -1;
    }
}
