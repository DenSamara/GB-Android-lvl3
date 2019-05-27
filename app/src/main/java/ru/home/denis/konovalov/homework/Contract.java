package ru.home.denis.konovalov.homework;

public interface Contract {
    interface View {
        void changeText(@ru.home.denis.konovalov.homework.Model.ModelID int id, String text);
        void changeButtonText(@ru.home.denis.konovalov.homework.Model.ModelID int id, String text);
    }

    interface Presenter{
        void onButtonClicked(@ru.home.denis.konovalov.homework.Model.ModelID int id);
        void onAttachView(android.view.View parent, Contract.View view);
        void onDetachView();
        void onDestroy();
    }

    interface Model{
        void inc(@ru.home.denis.konovalov.homework.Model.ModelID int id);
        short getData(@ru.home.denis.konovalov.homework.Model.ModelID int id);
    }
}
