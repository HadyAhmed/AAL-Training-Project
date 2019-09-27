package com.example.queizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.increase_btn:
                Toast.makeText(this, "increase", Toast.LENGTH_SHORT).show();
                break;
            case R.id.decrease_btn:

                break;

            default:

                break;
        }
    }
}
