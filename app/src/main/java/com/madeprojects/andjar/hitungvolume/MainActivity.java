package com.madeprojects.andjar.hitungvolume;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputPanjang, inputLebar, inputTinggi;
    private TextView hasilVolume;
    private Button hitungVolume;
    private static final String STATE_HASIL="state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPanjang = findViewById(R.id.edtTextPanjangID);
        inputLebar = findViewById(R.id.edtTextLebarID);
        inputTinggi = findViewById(R.id.edtTextTinggiID);
        hasilVolume = findViewById(R.id.tvHasilVolumeID);
        hitungVolume = findViewById(R.id.btnHitungVolumeID);

        hitungVolume.setOnClickListener(this);

        if (savedInstanceState!=null){
            String hasilHitungVolume = savedInstanceState.getString(STATE_HASIL);
            hitungVolume.setText(hasilHitungVolume);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHitungVolumeID){
            String panjang = inputPanjang.getText().toString().trim();
            String lebar = inputLebar.getText().toString().trim();
            String tinggi = inputTinggi.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(panjang)){
                isEmptyFields = true;
                inputPanjang.setError("Field ini Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(lebar)){
                isEmptyFields = true;
                inputLebar.setError("Field ini Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(tinggi)){
                isEmptyFields = true;
                inputTinggi.setError("Field ini Tidak Boleh Kosong");
            }

            if (!isEmptyFields){
                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double t = Double.parseDouble(tinggi);
                double volume = p * l * t;
                hasilVolume.setText(String.valueOf(volume));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, hasilVolume.getText().toString());

        super.onSaveInstanceState(outState);
    }
}
