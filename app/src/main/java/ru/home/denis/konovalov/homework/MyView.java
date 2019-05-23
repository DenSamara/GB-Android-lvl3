package ru.home.denis.konovalov.homework;

import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

public class MyView {
    private byte id;
    private TextView textView;
    private AppCompatButton button;

    public static MyView newInstance(View view, byte id){
        TextView textView = view.findViewById(R.id.text);
        AppCompatButton button = view.findViewById(R.id.button);

        return new MyView(id, textView, button);
    }

    public MyView(byte id, TextView textView, AppCompatButton button){
        this.id = id;
        this.textView = textView;
        this.button = button;
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

    public byte getId() {
        return id;
    }
}
