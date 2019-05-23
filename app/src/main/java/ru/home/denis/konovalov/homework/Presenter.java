package ru.home.denis.konovalov.homework;

import android.content.Context;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    private Contract.Model model;

    public Presenter() {

    }

    public void setModel(Contract.Model model) {
        this.model = model;
    }

    @Override
    public void onButtonClicked(byte id) {
        if (model != null) {
            model.inc(id);
            short newValue = model.getData(id);
            if (view != null) {
                view.changeText(id, Formatter.formatLabelText(newValue));
//                view.changeButtonText(id, Formatter.formatButtonText(id, newValue));
            }
        }
    }


    @Override
    public void onAttachView(Context ctx, Contract.View view) {
        this.view = view;

        //Надо проставить значения для кнопок и ярлыков
        if (model != null && this.view != null) {
            this.view.changeText(Model.ID_HOUR, Formatter.formatLabelText(model.getData(Model.ID_HOUR)));
            this.view.changeButtonText(Model.ID_HOUR, ctx.getString(R.string.hour));

            this.view.changeText(Model.ID_MINUTE, Formatter.formatLabelText(model.getData(Model.ID_MINUTE)));
            this.view.changeButtonText(Model.ID_MINUTE, ctx.getString(R.string.minutes));

            this.view.changeText(Model.ID_SECOND, Formatter.formatLabelText(model.getData(Model.ID_SECOND)));
            this.view.changeButtonText(Model.ID_SECOND, ctx.getString(R.string.seconds));
        }
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
