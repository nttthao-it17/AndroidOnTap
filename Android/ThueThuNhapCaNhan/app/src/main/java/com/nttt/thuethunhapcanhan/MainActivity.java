package com.nttt.thuethunhapcanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner spNam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Xử lý spinner năm
        ArrayList<String> dsNam = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        dsNam.add("Chọn...");
        for (int i = 2000; i <= thisYear; i++) {
            dsNam.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dsNam);

        Spinner spinYear = findViewById(R.id.spNam);
        spinYear.setAdapter(adapter);
    }
}
