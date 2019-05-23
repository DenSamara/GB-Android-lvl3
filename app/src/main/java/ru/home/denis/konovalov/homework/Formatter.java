package ru.home.denis.konovalov.homework;

import java.util.Locale;

public class Formatter {

    public static String formatLabelText(short value){
        return String.format(Locale.ENGLISH, "%02d", value);
    }

    public static String formatButtonText(byte id, short value){
        return String.format(Locale.ENGLISH, "Value: %d", value);
    }
}
