package com.shimul.datepickerdialouge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker datePicker = new DatePicker(MainActivity.this);
                int currentdate = datePicker.getDayOfMonth();
                int month = datePicker.getMonth()+1;
                int year = datePicker.getYear();

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        textView.setText("YEAR: "+i+" MONTH: "+(i1+1)+" DAY: "+i2);

                    }
                }, year, month, currentdate);

                datePickerDialog.show();
            }
        });
    }

    private void init() {
        textView = findViewById(R.id.dateTV);
        button = findViewById(R.id.openBTN);

    }
}
