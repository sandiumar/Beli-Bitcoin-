package com.sandyu.belibitcoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   private EditText rp, btc;
   Double hsl;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btc =  findViewById(R.id.nom_bitcoin);

        rp = findViewById(R.id.nom_rp);



        btc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Btc = btc.getText().toString();
                
                //Error handling konversi bilangan
                int BTC = 0;
                try {
                    BTC = Integer.parseInt(Btc);
                } catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }

               int RP = Integer.parseInt("93650");

                int hsl = BTC * RP;
                rp.setText(String.valueOf(hsl));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



}
