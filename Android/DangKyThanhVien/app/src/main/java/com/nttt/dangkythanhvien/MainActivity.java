package com.nttt.dangkythanhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT = "Text";

    private EditText edtHoTen, edtUsername, edtMatKhau, edtNgaySinh;
    //private RadioButton rdNam, rdNu;
    private Spinner spQuocTich;
    private Button btnTao;
    AwesomeValidation awe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        awe = new AwesomeValidation(ValidationStyle.BASIC);
        int count = 0;
        String regexPassword = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        awe.addValidation(this, R.id.edt_HoTen, RegexTemplate.NOT_EMPTY, R.string.null_name);
        awe.addValidation(this, R.id.edt_username, "[a-zA-Z0-9]+", R.string.er_user);
        awe.addValidation(this, R.id.edt_username, RegexTemplate.NOT_EMPTY, R.string.null_user);
        awe.addValidation(this, R.id.edt_matKhau, regexPassword, R.string.er_pass);
        awe.addValidation(this, R.id.edt_ngaySinh, RegexTemplate.NOT_EMPTY, R.string.null_date);
        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtHoTen.getText().toString();

                if (awe.validate()) {
                    Toast.makeText(MainActivity.this, "Bạn đã Đăng ký thành viên thành công!", Toast.LENGTH_SHORT).show();
                    byExtras(text);
                }
            }
        });
    }

    public void byExtras(String text) {
        Intent intent = new Intent(MainActivity.this, HelloActivity.class);
        intent.putExtra(TEXT, text);
        startActivity(intent);
    }

    public void anhXa(){
        edtHoTen = (EditText)findViewById(R.id.edt_HoTen);
        edtUsername = (EditText)findViewById(R.id.edt_username);
        edtMatKhau = (EditText)findViewById(R.id.edt_matKhau);
        edtNgaySinh = (EditText)findViewById(R.id.edt_ngaySinh);
        //rdNam = (RadioButton) findViewById(R.id.rdNam);
        //rdNu = (RadioButton) findViewById(R.id.rdNu);
        spQuocTich = (Spinner) findViewById(R.id.sp_quocTich);
        btnTao = (Button)findViewById(R.id.btnTao);
    }
}
