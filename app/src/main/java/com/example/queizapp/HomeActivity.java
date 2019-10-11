package com.example.queizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final String COUNTER_STATE = "counter_state_key";
    private int counter = 0;

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(COUNTER_STATE)) {
            counter = savedInstanceState.getInt(COUNTER_STATE);
            display(counter);
        }
    }

    private Button resetBtn;
    private Button increaseBtn;
    private Button decreaseBtn;
    private TextView counterTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        counterTv = findViewById(R.id.counter_tv);
        resetBtn = findViewById(R.id.reset_counter_btn);
        increaseBtn = findViewById(R.id.increase_btn);
        decreaseBtn = findViewById(R.id.decrease_btn);

        initUI();
    }

    private void initUI() {
        resetBtn.setOnClickListener(this);
        increaseBtn.setOnClickListener(this);
        decreaseBtn.setOnClickListener(this);
    }

    /**
     * this will show up counter value to the view
     *
     * @param counter the counter value
     */
    private void display(int counter) {
        counterTv.setText(String.valueOf(counter));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.increase_btn:
                increaseCounter();
                break;
            case R.id.decrease_btn:
                decrementCounter();
                break;
            default:
                resetCounter();
                break;
        }
    }


    private void resetCounter() {
        counter = 0;
        display(counter);
    }

    private void increaseCounter() {
        counter++;
        display(counter);
    }

    private void decrementCounter() {
        if (counter < 1)
            display(0);
        else {
            counter--;
            display(counter);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_STATE, counter);
    }
}
