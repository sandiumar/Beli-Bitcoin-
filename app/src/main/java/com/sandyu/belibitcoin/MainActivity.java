package com.sandyu.belibitcoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText rp, btc;
    Double Hasil, dRp, dBtc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Variabel
        rp = (EditText)findViewById(R.id.nom_rp);
        rp.addTextChangedListener(watchRp);
        btc = (EditText)findViewById(R.id.nom_bitcoin);


    }

    public void konver(){
        //konversi inputan ke double
        dBtc= Double.parseDouble(btc.getText().toString());

    }


    private TextWatcher watchRp = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            dRp = dBtc * 93.630;
           btc.setText(dRp.toString());
        }
    };
}
