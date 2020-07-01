package com.nttt.tinhgiaxelanbanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edtGiaXe;
    private Spinner spLoaiXe, spDiaPhuong;
    private Button btnTinh;
    private TextView tvGia, tvTruocBa, tvDuongBo, tvTNDS, tvBienSo, tvDangKiem, tvTong, tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtGiaXe.getText().toString().equals("") &&
                        spLoaiXe.getSelectedItemPosition() != 0 && spDiaPhuong.getSelectedItemPosition() != 0) {
                    double giaXe = Double.parseDouble(edtGiaXe.getText().toString());
                    double dkBienSo = 3000000;   //phí đăng ký
                    double truocBa = 0.03; //phí trước bạ
                    if (spDiaPhuong.getSelectedItemPosition() == 1) {
                        truocBa = 0.1;
                        dkBienSo = 11000000;
                    }
                    double duongBo = 2160000;   //phí đường bộ (cho xe tải nhỏ)
                    double baoHiem = 953000;   //bảo hiểm (cho xe tải nhỏ)
                    double dangKiem = 540000;    //phí đăng kiểm (cho xe tải nhỏ)
                    switch (spLoaiXe.getSelectedItem().toString()) {
                        case "Xe du lịch dưới 10 chỗ":
                            baoHiem = 794000;
                            duongBo = 1560000;
                            dangKiem = 340000;
                            break;
                        case "Xe bán tải":
                            baoHiem = 933000;
                            break;
                    }
                    double giaDP = Double.parseDouble(edtGiaXe.getText().toString());
                    truocBa *= giaDP;
                    NumberFormat formatter = new DecimalFormat("#,###");
                    double tong = giaDP + truocBa + duongBo + baoHiem + dkBienSo + dangKiem;
                    //
                    tvGia.setText(String.valueOf(formatter.format(giaDP)));
                    tvTruocBa.setText(String.valueOf(formatter.format(truocBa)));
                    tvDuongBo.setText(String.valueOf(formatter.format(duongBo)));
                    tvTNDS.setText(String.valueOf(formatter.format(baoHiem)));
                    tvBienSo.setText(String.valueOf(formatter.format(dkBienSo)));
                    tvDangKiem.setText(String.valueOf(formatter.format(dangKiem)));
                    tvTong.setText(String.valueOf(formatter.format(tong)));
                    tvKetQua.setText(String.valueOf(formatter.format(tong)));
                } else {
                    Toast.makeText(getApplicationContext(), "Hãy kiểm tra lại thông tin nhập!", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }

    public void anhXa(){
        edtGiaXe = (EditText)findViewById(R.id.edt_Giaxe);
        spLoaiXe = (Spinner)findViewById(R.id.sp_Loaixe);
        spDiaPhuong = (Spinner)findViewById(R.id.sp_DiaPhuong);
        btnTinh = (Button)findViewById(R.id.btnTinh);
        tvGia = (TextView) findViewById(R.id.tv_damPhan);
        tvTruocBa = (TextView) findViewById(R.id.tv_truocBa);
        tvDuongBo = (TextView) findViewById(R.id.tv_sdDuongBo);
        tvTNDS = (TextView) findViewById(R.id.tv_tnds);
        tvBienSo = (TextView) findViewById(R.id.tv_dkBienSo);
        tvDangKiem = (TextView) findViewById(R.id.tv_dangKiem);
        tvTong = (TextView) findViewById(R.id.tvTong);
        tvKetQua = (TextView) findViewById(R.id.tv_ketQua);
    }
}
