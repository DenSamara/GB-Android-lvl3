package ru.home.denis.konovalov.homework;

import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyView extends LinearLayout {
    private @Model.ModelID int id;
    private TextView textView;
    private AppCompatButton button;

    public MyView(View parent, @Model.ModelID int id) {
        super(parent.getContext());

        textView = parent.findViewById(R.id.text);
        button = parent.findViewById(R.id.button);
        this.id = id;
    }

    public static MyView newInstance(View container, @Model.ModelID int id){
        return new MyView(container, id);
    }

    public void setButtonClickListener(View.OnClickListener listener){
        button.setOnClickListener(listener);
    }

    public void setButtonText(String text) {
        this.button.setText(text);
    }

    public void setText(String text) {
        this.textView.setText(text);
    }

    public @Model.ModelID int ID() {
        return id;
    }
}
