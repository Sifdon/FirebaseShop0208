package com.ptp.phamtanphat.firebaseshop0208.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ptp.phamtanphat.firebaseshop0208.Model.Sanpham;
import com.ptp.phamtanphat.firebaseshop0208.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChitietSanPhamActivity extends AppCompatActivity {

    Sanpham sanpham = null;
    TextView txttenchitiet,txtgiachitiet,txtmota;
    ImageView imgchitiet;
    Button btnmua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_san_pham);
        Intent intent = getIntent();
        sanpham = intent.getParcelableExtra("sanpham");
        anhxa();
        txttenchitiet.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgiachitiet.setText("Giá : " + decimalFormat.format(Integer.parseInt(sanpham.getGiasp())));
        txtmota.setText(sanpham.getMotasp());
        Picasso.with(ChitietSanPhamActivity.this).load(sanpham.getHinhanhsp()).into(imgchitiet);

    }

    private void anhxa() {
        txttenchitiet = (TextView) findViewById(R.id.textviewtenchitiet);
        txtgiachitiet = (TextView) findViewById(R.id.textviewgiachitiet);
        txtmota = (TextView) findViewById(R.id.textviewmota);
        imgchitiet = (ImageView) findViewById(R.id.imageviewchitietsp);
        btnmua = (Button) findViewById(R.id.buttonmua);
    }
}
