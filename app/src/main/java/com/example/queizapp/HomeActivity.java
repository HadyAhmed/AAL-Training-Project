package com.example.queizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {


    private int counter = 0;

    private Button resetBtn;
    private Button increaseBtn;
    private Button decreaseBtn;
    private TextView counterTv;
    int counter = 65 ;

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

    public void decrement () {
        if (counter<1)
            display(0);
        else {
        counter--;
        display(counter);}

    }
    private void initUI() {
        resetBtn.setOnClickListener(this);
        increaseBtn.setOnClickListener(this);
        decreaseBtn.setOnClickListener(this);
    }

    private void display (String text) {
        TextView textView_counter = findViewById(R.id.counter_tv);
        textView_counter.setText(""+text);
    }

    private void display (int text) {
        TextView textView_counter = findViewById(R.id.counter_tv);
        textView_counter.setText(""+text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.increase_btn:
                Increas();
                break;
            case R.id.decrease_btn:
                Toast.makeText(this, "decrease", Toast.LENGTH_SHORT).show();
                decrement();
                break;
            default:
                Toast.makeText(this, "reset", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void Increas (){
        counter ++;
        String c = String.valueOf(counter);
        counterTv.setText(c);

    }

}
