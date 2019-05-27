package ru.home.denis.konovalov.homework;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyView extends LinearLayout {
    private Model.ID id;
    private TextView textView;
    private AppCompatButton button;

    public MyView(Context context, Model.ID id) {
        super(context);
        this.id = id;
    }

    public static MyView newInstance(Context ctx, Model.ID id){
        return new MyView(ctx, id);
    }

//    public MyView(byte id, TextView textView, AppCompatButton button){
//        this.id = id;
//        this.textView = textView;
//        this.button = button;
//    }

    public void setButtonClickListener(View.OnClickListener listener){
        button.setOnClickListener(listener);
    }

    public void setButtonText(String text) {
        this.button.setText(text);
    }

    public void setText(String text) {
        this.textView.setText(text);
    }

    public Model.ID ID() {
        return id;
    }
}
