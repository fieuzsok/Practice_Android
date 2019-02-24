package com.example.user.lab2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etResult = (EditText) findViewById(R.id.editText2);
    }

    public void calculateValue(View view){
        String value = view.getTag().toString();
        String currentValue = etResult.getText().toString();
        etResult.setText(currentValue + value);
    }
}
