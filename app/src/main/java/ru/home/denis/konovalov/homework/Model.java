package ru.home.denis.konovalov.homework;

public class Model implements Contract.Model{
    public final static byte ID_HOUR = 1;
    public final static byte ID_MINUTE = 2;
    public final static byte ID_SECOND = 3;

    public enum ID{
        HOUR, MINUTE, SECOND
    }

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
    public void inc(ID id){
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
    public short getData(ID id) {
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
