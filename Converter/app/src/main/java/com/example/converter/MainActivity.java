package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Spinner spn1, spn2;
    ImageButton btSwap, btStart;
    TextView txt1, txt2, txt3, txt4;
    EditText txtNhap;
    int temp1, temp2;
    String s1, s2;
    double money = 0, eMoney = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSwap = findViewById(R.id.btSwap);
        btStart = findViewById(R.id.btStart);

        txt1 = findViewById(R.id.text1);
        txt2 = findViewById(R.id.text2);

        txtNhap = findViewById(R.id.txtNhap);

        spn1 = findViewById(R.id.spn1);
        spn2 = findViewById(R.id.spn2);
        spn2.setSelection(2);
        SwapClick();
        StartClick();
    }

    public void SwapClick() {
        temp1 = spn1.getSelectedItemPosition();
        temp2 = spn2.getSelectedItemPosition();
        btSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn1.setSelection(temp2);
                spn2.setSelection(temp1);
            }
        });
    }


    public void StartClick() {
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp1 = spn1.getSelectedItemPosition();
                temp2 = spn2.getSelectedItemPosition();
                if (txtNhap.getText().toString().length() > 0)
                    money = Double.parseDouble(txtNhap.getText().toString());
                eMoney = ExchangeMoney(money, temp1);
                if (temp2 == 1) {
                    s2 = "USD";
                    eMoney = eMoney / 23150;
                }
                else if (temp2 == 2) {
                    s2 = "EUR";
                    eMoney = eMoney / 26079;
                }
                else s2 = "VND";
                txt1.setText(String.valueOf(money) + s1 + " = ");
                txt2.setText(String.valueOf(new DecimalFormat("#.######").format(eMoney)) + " " + s2);
            }
        });
    }

    //doi sang tien viet
    public double ExchangeMoney(double tien, int nuoc) {
        s1 = "VND";
        if (nuoc == 1) {
            s1 = "USD";
            tien = tien * 23150;
        }

        else if (nuoc == 2) {
            s1 = "EUR";
            tien = tien * 26079;
        }
        return tien;
    }
}
