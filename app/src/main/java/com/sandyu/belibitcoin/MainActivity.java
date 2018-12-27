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
               double BTC = 0;
               try {
                   BTC = Double.parseDouble(Btc);
               }catch (NumberFormatException nfe){
                   nfe.printStackTrace();
               }





                //Error handling rp
                double RP = 93650;

                try{
                    RP = Double.parseDouble(rP);
                } catch (NumberFormatException nfc){
                    nfc.printStackTrace();
                }

                //Mengubah hasil konversi menjadi digit 3
                NumberFormat formatter = new DecimalFormat("#,###,###");
               double hsl = BTC * RP;
               String hsl_format = formatter.format(hsl);
                rp.setText(String.valueOf(hsl_format));

                //Disable Button Lanjut
                lanjut.setEnabled(!Btc.isEmpty() && !rP.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });
    }



}
