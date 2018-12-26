package com.sandyu.belibitcoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   private EditText rp, btc;
   Button lanjut;
   Double hsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Variabel
        btc =  findViewById(R.id.nom_bitcoin);
        rp = findViewById(R.id.nom_rp);
        lanjut = findViewById(R.id.btn_lanjut);



        btc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Btc = btc.getText().toString().trim();

                //Error handling btc
                int BTC = 0;
                try {
                    BTC = Integer.parseInt(Btc);
                } catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }

                String Rp = "93650";
                //Error handling rupiah
                int RP = 0;
                try {
                     RP = Integer.parseInt(Rp);
                } catch (NumberFormatException nfc){
                    nfc.printStackTrace();
                }

                int hsl = BTC * RP;
                rp.setText(String.valueOf(hsl));

                //Disable Button Lanjut
                lanjut.setEnabled(!Btc.isEmpty() && !Rp.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



}
