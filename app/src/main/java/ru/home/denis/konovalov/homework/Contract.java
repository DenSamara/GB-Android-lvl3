package ru.home.denis.konovalov.homework;

public interface Contract {
    interface View {
        void changeText(@ru.home.denis.konovalov.homework.Model.ModelID int id, String text);
        void changeButtonText(@ru.home.denis.konovalov.homework.Model.ModelID int id, String text);
    }

    interface Presenter{
        void onButtonClicked(Contract.RecourceManager manager, @ru.home.denis.konovalov.homework.Model.ModelID int id);
        void onAttachView(RecourceManager manager, Contract.View view);
        void onDetachView();
        void onDestroy();
    }

    interface Model{
        void inc(@ru.home.denis.konovalov.homework.Model.ModelID int id);
        short getData(@ru.home.denis.konovalov.homework.Model.ModelID int id);
    }

    interface RecourceManager{
        String getLabelString(@ru.home.denis.konovalov.homework.Model.ModelID int id, short value);
        String getButtonString(@ru.home.denis.konovalov.homework.Model.ModelID int id, short value);
    }
}
