package com.nttt.vaytieudung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtThuNhap, edtChiPhi, edtTienVay;
    Spinner spLaiSuat;
    RadioButton rb12, rb18, rb24, rb30, rb36, rb42, rb48, rb54, rb60;
    Button btnTinh;
    TextView tvKetQua;
    int check = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        buttonCLick();
    }

    public void anhXa(){
        edtThuNhap = findViewById(R.id.edt_thunhap);
        edtChiPhi = findViewById(R.id.edt_chiphi);
        edtTienVay = findViewById(R.id.edt_muonvay);

        spLaiSuat = findViewById(R.id.sp_laisuat);

        btnTinh = findViewById(R.id.btn_Tinh);

        tvKetQua = findViewById(R.id.tv_KetQua);

        rb12 = findViewById(R.id.rb12t);
        rb18 = findViewById(R.id.rb18t);
        rb24 = findViewById(R.id.rb24t);
        rb30 = findViewById(R.id.rb30t);
        rb36 = findViewById(R.id.rb36t);
        rb42 = findViewById(R.id.rb42t);
        rb48 = findViewById(R.id.rb48t);
        rb54 = findViewById(R.id.rb54t);
        rb60 = findViewById(R.id.rb60t);
    }

    public double thoiGian() {
        if (rb12.isChecked() == true)
            return 1;
        else if (rb18.isChecked() == true)
            return 1.5;
        else if (rb24.isChecked() == true)
            return 2;
        else if (rb30.isChecked() == true)
            return 2.5;
        else if (rb36.isChecked() == true)
            return 3;
        else if (rb42.isChecked() == true)
            return 3.5;
        else if (rb48.isChecked() == true)
            return 4;
        else if (rb54.isChecked() == true)
            return 4.5;
        else return 5;
    }

    public double laiSuat() {
        int check = spLaiSuat.getSelectedItemPosition();
        if (check == 1)
            return 0.16;
        else if (check == 2)
            return 0.17;
        else return 0.18;
    }

    public void buttonCLick() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double thuNhap = Double.parseDouble(edtThuNhap.getText().toString());
                double chiPhi = Double.parseDouble(edtChiPhi.getText().toString());
                double tienVay = Double.parseDouble(edtTienVay.getText().toString());
                if ((thuNhap-chiPhi)*10 < tienVay)
                    tvKetQua.setText("Số tiền vay vượt quá 10 lần số tiền còn lại!");
                else if (tienVay < 20000000)
                    tvKetQua.setText("Số tiền vay không được thấp hơn 20 triệu!");
                else if( !rb12.isChecked() == true && !rb18.isChecked() == true && !rb24.isChecked() == true &&
                        !rb30.isChecked() == true && !rb36.isChecked() == true && !rb42.isChecked() == true &&
                        !rb48.isChecked() == true && !rb54.isChecked() == true && !rb60.isChecked() == true){
                    Toast.makeText(getApplicationContext(), "Thời gian vay không được để trống!", Toast.LENGTH_LONG).show();
                }
                else if (spLaiSuat.getSelectedItemPosition() == 0) {
                    Toast.makeText(getApplicationContext(), "Chọn sai Lãi suất mong muốn!", Toast.LENGTH_LONG).show();
                }
                /* else if (edtThuNhap.getText().toString().equals("") && edtChiPhi.getText().toString().equals("") &&
                        edtTienVay.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Các trường không được bỏ trống!", Toast.LENGTH_LONG).show();
                } */
                else{
                    double tongTien = (tienVay * Math.pow(1 + laiSuat(), thoiGian())) / 12;
                    tvKetQua.setText(String.valueOf(new DecimalFormat("#.##").format(tongTien)) + "VNĐ");
                }
            }
        });
    }
}
