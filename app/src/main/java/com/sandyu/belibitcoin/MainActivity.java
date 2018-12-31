package com.sandyu.belibitcoin;

import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout inputBtc;
    private TextInputLayout inputRp;
    private EditText rp, btc;
    private SwipeRefreshLayout angka_random;
    private TextView warning;

    //Set Variabel Widget
   Button lanjut;
   Double hsl;
   double BTC = 0;
   double RP = 93650;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Variabel
        btc =  findViewById(R.id.nom_bitcoin);
        rp = findViewById(R.id.nom_rp);
        lanjut = findViewById(R.id.btn_lanjut);
        inputBtc = findViewById(R.id.input_bitcoin);
        inputRp = findViewById(R.id.input_rp);
        warning = findViewById(R.id.warn);
        angka_random = findViewById(R.id.swipe_random);

        //Untuk merubah angka btc dan rupiah secara random
        angka_random.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                generateRandom();

            }
        });



        btc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Btc = btc.getText().toString().trim();
                String rP = rp.getText().toString().trim();

                //Error handling btc
                try {
                   BTC = Double.parseDouble(Btc);
               }catch (NumberFormatException nfe){
                   nfe.printStackTrace();
               }


                //Error handling rp
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
//                lanjut.setEnabled(!Btc.isEmpty() && !rP.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



    private void generateRandom(){
        double start = 1;
        double end = 10;
        double random = new Random().nextDouble();

        //Menset hasil result agar memiliki format
        NumberFormat result_format = new DecimalFormat("#,###,###");
        double result = random * RP * Double.valueOf(btc.getText().toString());
        String rst_format = result_format.format(result);

        rp.setText(String.valueOf(result));
        angka_random.setRefreshing(false);
    }





}
