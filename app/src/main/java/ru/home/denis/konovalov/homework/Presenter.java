package ru.home.denis.konovalov.homework;

import android.content.Context;
import android.view.View;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    private Contract.Model model;

    public Presenter(Contract.Model model) {
        this.model = model;
    }

    @Override
    public void onButtonClicked(@Model.ModelID int id) {
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
    public void onAttachView(View parent, Contract.View view) {
        this.view = view;

        //Надо проставить значения для кнопок и ярлыков
        if (parent != null && model != null && this.view != null) {
            Context ctx = parent.getContext();

            this.view.changeText(Model.HOUR, Formatter.formatLabelText(model.getData(Model.HOUR)));
            this.view.changeButtonText(Model.HOUR, ctx.getString(R.string.hour));

            this.view.changeText(Model.MINUTE, Formatter.formatLabelText(model.getData(Model.MINUTE)));
            this.view.changeButtonText(Model.MINUTE, ctx.getString(R.string.minutes));

            this.view.changeText(Model.SECOND, Formatter.formatLabelText(model.getData(Model.SECOND)));
            this.view.changeButtonText(Model.SECOND, ctx.getString(R.string.seconds));
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
