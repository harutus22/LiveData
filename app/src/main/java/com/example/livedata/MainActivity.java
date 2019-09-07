package com.example.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyViewModel viewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        createViewModel();
    }

    private void findView() {
        textView = findViewById(R.id.numberView);
    }

    private void createViewModel() {
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getNumber().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
    }

    public void minus(View view){
        viewModel.minusOne();
    }

    public void plus(View view){
        viewModel.plusOne();
    }
}