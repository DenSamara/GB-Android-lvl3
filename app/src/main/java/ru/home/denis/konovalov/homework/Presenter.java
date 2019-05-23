package ru.home.denis.konovalov.homework;

import java.util.Locale;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    private Contract.Model model;

    public Presenter(){

    }

    public void setModel(Contract.Model model) {
        this.model = model;
    }

    @Override
    public void onButtonClicked(byte id) {
        if (model != null) {
            model.inc(id);
            short newValue = model.getData(id);
            if (view != null){
                view.changeText(id, String.format(Locale.ENGLISH, "Value: %d", newValue));
                view.changeButtonText(id, String.format(Locale.ENGLISH, "Button was pressed: %d", id));
            }
        }
    }

    @Override
    public void onAttachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
        model = null;
    }
}
