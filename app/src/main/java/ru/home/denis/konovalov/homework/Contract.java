package ru.home.denis.konovalov.homework;

import android.content.Context;

public interface Contract {
    interface View {
        void changeText(byte id, String text);
        void changeButtonText(byte id, String text);
    }
    interface Presenter{
        void onButtonClicked(byte id);
        void onAttachView(Context ctx, Contract.View view);
        void onDetachView();
        void onDestroy();
    }
    interface Model{
        void inc(ru.home.denis.konovalov.homework.Model.ID id);
        short getData(ru.home.denis.konovalov.homework.Model.ID id);
    }
}
