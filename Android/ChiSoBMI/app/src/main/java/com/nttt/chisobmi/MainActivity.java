package com.nttt.chisobmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnTinh;
    RadioButton rbNam, rbNu;
    EditText edtChieuCao, edtCanNang;
    TextView tvBMI, tvNhanXet1, tvNhanXet2, tvNhanXet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        start();
    }

    public void anhXa(){
        edtChieuCao = findViewById(R.id.edt_chieucao);
        edtCanNang = findViewById(R.id.edt_cannang);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        tvBMI = findViewById(R.id.tv_BMI);
        btnTinh = findViewById(R.id.btnTinh);
        tvNhanXet1 = findViewById(R.id.tvNhanxet1);
        tvNhanXet2 = findViewById(R.id.tvNhanxet2);
    }
    public void start() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checked();
            }
        });
    }
    public void Checked() {
        if (rbNam.isChecked() == true)
            Nam();
        else
            Nu();
    }
    public void Nam() {
        double bmi = BMI();
        bmi = Math.round(bmi*10)/10;

        if (bmi < 18.5)
        {
            tvNhanXet1.setText("Cảnh báo!");
            tvNhanXet2.setText("Bạn có thể trạng thấp gầy, chỉ số BMI thấp.");
        }
        else  if (bmi < 25) {
            tvNhanXet1.setText("Chúc mừng bạn!");
            tvNhanXet2.setText("Bạn có thể trạng cân đối, chỉ số BMI bình thường.");
        }
        else  if (bmi == 25) {
            tvNhanXet1.setText("Bạn có thể trạng hơi thừa cân, chỉ số BMI đạt 23!");
            tvNhanXet2.setText("Bạn nên vận động phù hợp để giảm cân.");
        }
        else  if (bmi < 30) {
            tvNhanXet1.setText("Bạn có thể trạng tiền béo phì, chỉ số BMI cao!");
            tvNhanXet2.setText("Lời khuyên: Nên tập thể dục và ăn uống điều độ.");
        }
        else  if (bmi < 35) {
            tvNhanXet1.setText("Bạn có thể trạng béo phì độ I, chỉ số BMI khá cao!");
            tvNhanXet2.setText("Lời khuyên: Nên tập thể dục và cần giảm cân.");
        }
        else  if (bmi < 40) {
            tvNhanXet1.setText("Bạn có thể trạng béo phì độ II, chỉ số BMI cao!");
            tvNhanXet2.setText("Cảnh báo: Nên tập thể dục và cần giảm cân ngay.");
        }
        else  if (bmi >= 40) {
            tvNhanXet1.setText("Bạn có thể trạng béo phì độ III, chỉ số BMI quá cao!");
            tvNhanXet2.setText("Cảnh báo: Nên tập thể dục và cần giảm cân gấp.");
        }
        tvBMI.setText(String.valueOf(bmi));
    }
    public void Nu() {
        double bmi = BMI();
        bmi = Math.round(bmi*10)/10;

        if (bmi < 18.5)
        {
            tvNhanXet1.setText("Cảnh báo!");
            tvNhanXet2.setText("Bạn có thể trạng thấp gầy, chỉ số BMI thấp.");
        }
        else  if (bmi < 23) {
            tvNhanXet1.setText("Chúc mừng bạn!");
            tvNhanXet2.setText("Bạn có thể trạng cân đối, chỉ số BMI bình thường.");
        }
        else  if (bmi == 23) {
            tvNhanXet1.setText("Bạn có thể trạng hơi thừa cân, chỉ số BMI đạt 23!");
            tvNhanXet2.setText("Bạn nên vận động phù hợp để giảm cân.");
        }
        else  if (bmi < 25) {
            tvNhanXet1.setText("Bạn có thể trạng tiền béo phì, chỉ số BMI cao!");
            tvNhanXet2.setText("Lời khuyên: Nên tập thể dục và ăn uống điều độ.");
        }
        else  if (bmi < 30) {
            tvNhanXet1.setText("Bạn có thể trạng béo phì độ I, chỉ số BMI khá cao!");
            tvNhanXet2.setText("Lời khuyên: Nên tập thể dục và cần giảm cân.");
        }
        else  if (bmi < 40) {
            tvNhanXet1.setText("Bạn có thể trạng béo phì độ II, chỉ số BMI cao!");
            tvNhanXet2.setText("Cảnh báo: Nên tập thể dục và cần giảm cân ngay.");
        }
        else  if (bmi >= 40) {
            tvNhanXet1.setText("Bạn có thể trạng béo phì độ III, chỉ số BMI quá cao!");
            tvNhanXet2.setText("Cảnh báo: Nên tập thể dục và cần giảm cân gấp.");
        }
        tvBMI.setText(String.valueOf(bmi));
    }

    public double BMI() {
        double bmi, cc, cn;
        cc = Double.parseDouble(edtChieuCao.getText().toString()) / 100;
        cn = Double.parseDouble(edtCanNang.getText().toString());
        return bmi = cn / (cc * cc);
    }
}
