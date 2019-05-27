package ru.home.denis.konovalov.homework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Contract.View, Contract.RecourceManager {
    private final static String TAG = MainActivity.class.getSimpleName();
    private Presenter presenter;
    private SparseArray<MyView> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView(R.layout.activity_main);

        presenter = new Presenter(ModelManager.getInstance().getModel());
        presenter.onAttachView(this, this);
    }

    public void setupView(int viewID) {
        setContentView(viewID);

        MyView view1 = MyView.newInstance(findViewById(R.id.hour), Model.HOUR);
        view1.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked(MainActivity.this, Model.HOUR);
            }
        });

        MyView view2 = MyView.newInstance(findViewById(R.id.minute), Model.MINUTE);
        view2.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked(MainActivity.this, Model.MINUTE);
            }
        });

        MyView view3 = MyView.newInstance(findViewById(R.id.second), Model.SECOND);
        view3.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked(MainActivity.this, Model.SECOND);
            }
        });

        items = new SparseArray<>();
        items.put(Model.HOUR, view1);
        items.put(Model.MINUTE, view2);
        items.put(Model.SECOND, view3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetachView();
        presenter.onDestroy();
    }

    @Override
    public void changeText(@Model.ModelID int id, String text) {
        MyView item = items.get(id);
        item.setText(text);
    }

    @Override
    public void changeButtonText(@Model.ModelID int id, String text) {
        MyView item = items.get(id);
        item.setButtonText(text);
    }

    @Override
    public String getLabelString(int id, short value) {
        return String.format(Locale.ENGLISH, "%02d", value);
    }

    @Override
    public String getButtonString(int id, short value) {
        String txt = getString(R.string.unknown);
        switch (id){
            case Model.HOUR:
                txt = getString(R.string.hour);
                break;
            case Model.MINUTE:
                txt = getString(R.string.minutes);
                break;
            case Model.SECOND:
                txt = getString(R.string.seconds);
                break;

        }
        return String.format(Locale.ENGLISH, getString(R.string.txt_button), txt);
    }
}
