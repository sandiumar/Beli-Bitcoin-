package com.sandyu.belibitcoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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
                String rP = rp.getText().toString().trim();

                //Error handling btc
                long BTC = 0;

                try {
                    BTC = Long.parseLong(Btc);
                } catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }

                //Format digit 3 angka
                /*DecimalFormat formatter = new DecimalFormat("#,###,###");
                String  rp_format = formatter.format(93650);
                long hsl_konversi = Long.parseLong(rp_format); */


                //Error handling rp
                long RP = 93650;
                try{
                    RP = Long.parseLong(rP);
                } catch (NumberFormatException nfc){
                    nfc.printStackTrace();
                }



               Long hsl = BTC * RP;
                rp.setText(String.valueOf(hsl));

                //Disable Button Lanjut
                lanjut.setEnabled(!Btc.isEmpty() && !rP.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });
    }



}
