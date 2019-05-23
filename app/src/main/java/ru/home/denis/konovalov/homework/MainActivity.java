package ru.home.denis.konovalov.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewParent;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private final static String TAG = MainActivity.class.getSimpleName();
    private Presenter presenter;
    private SparseArray<MyView> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView(R.layout.activity_main);

        presenter = new Presenter();
        presenter.setModel(ModelManager.getInstance().getModel());
        presenter.onAttachView(getApplicationContext(), this);
    }

    public void setupView(int viewID) {
        setContentView(viewID);

        MyView view1 = MyView.newInstance(findViewById(R.id.hour), Model.ID_HOUR);
        view1.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked(Model.ID_HOUR);
            }
        });

        MyView view2 = MyView.newInstance(findViewById(R.id.minute), Model.ID_MINUTE);
        view2.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked(Model.ID_MINUTE);
            }
        });

        MyView view3 = MyView.newInstance(findViewById(R.id.second), Model.ID_SECOND);
        view3.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked(Model.ID_SECOND);
            }
        });

        items = new SparseArray<>();
        items.put(Model.ID_HOUR, view1);
        items.put(Model.ID_MINUTE, view2);
        items.put(Model.ID_SECOND, view3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetachView();
        presenter.onDestroy();
    }

    @Override
    public void changeText(byte id, String text) {
        MyView item = items.get(id);
        item.setText(text);
    }

    @Override
    public void changeButtonText(byte id, String text) {
        MyView item = items.get(id);
        item.setButtonText(text);
    }
}
