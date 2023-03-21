package com.example.tp3_operateurstelephoniques_nourbesbes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Operateurs extends AppCompatActivity {

    ImageView _imgLogin;
    EditText _edtNumero,_edtCode,_edtRecharge,_edtSolde;

    TextView _txtLigne,_txtCode;

    Button _btnRecharge, _btnSolde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operateurs);
        String username = getIntent().getStringExtra("USERNAME");

        _edtNumero = (EditText) findViewById(R.id.edtNumero);
        _edtCode = (EditText) findViewById(R.id.edtCode);
        _edtRecharge = (EditText) findViewById(R.id.edtRecharge);
        _edtSolde = (EditText) findViewById(R.id.edtSolde);
        _edtCode.setEnabled(false);
        _edtRecharge.setEnabled(false);
        _edtSolde.setEnabled(false);
        _txtLigne = (TextView) findViewById(R.id.txtLigne);
        _txtCode = (TextView) findViewById(R.id.txtCode);
        _btnRecharge = (Button) findViewById(R.id.btnRecharge);
        _btnSolde = (Button) findViewById(R.id.btnSolde);
        _btnRecharge.setEnabled(false);
        _btnSolde.setEnabled(false);
        _imgLogin = (ImageView) findViewById(R.id.imgLogin);
        TextView TextToChange = findViewById(R.id.txtLogin);
        TextToChange.setText(username.toUpperCase());
        TextToChange.setTextColor(Color.parseColor("#808080"));


        _edtNumero.addTextChangedListener(new TextWatcher(){

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (_edtNumero.getText().toString().startsWith("5") && _edtNumero.length() == 8) {
                    _txtLigne.setText("Votre ligne est Orange");
                    _txtLigne.setTextColor(Color.parseColor("#F28A1D"));
                    _txtCode.setText("Entrez votre code de recharge (14 chiffres)");
                    _edtCode.setEnabled(true);
                    _btnSolde.setEnabled(true);
                    _edtRecharge.setBackgroundColor(Color.parseColor("#F28A1D"));
                    _edtSolde.setText("*101#");
                    _edtSolde.setBackgroundColor(Color.parseColor("#F28A1D"));
                    _edtCode.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(14)});
                } else if (_edtNumero.getText().toString().startsWith("9") && _edtNumero.length() == 8) {
                    _txtLigne.setText("Votre ligne est Tunisie Telecom");
                    _txtLigne.setTextColor(Color.parseColor("#6FA8DC"));
                    _txtCode.setText("Entrez votre code de recharge (13 chiffres)");
                    _edtCode.setEnabled(true);
                    _btnSolde.setEnabled(true);
                    _edtRecharge.setBackgroundColor(Color.parseColor("#6FA8DC"));
                    _edtSolde.setText("*122#");
                    _edtSolde.setBackgroundColor(Color.parseColor("#6FA8DC"));
                    _edtCode.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(13)});
                }
                else if (_edtNumero.getText().toString().startsWith("2") && _edtNumero.length() == 8) {
                    _txtLigne.setText("Votre ligne est Ooredoo");
                    _txtLigne.setTextColor(Color.parseColor("#F44336"));
                    _txtCode.setText("Entrez votre code de recharge (14 chiffres)");
                    _edtCode.setEnabled(true);
                    _btnSolde.setEnabled(true);
                    _edtRecharge.setBackgroundColor(Color.parseColor("#F44336"));
                    _edtSolde.setText("*100#");
                    _edtSolde.setBackgroundColor(Color.parseColor("#F44336"));
                    _edtCode.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(14)});
                }
                else if (_edtNumero.getText().toString().isEmpty() ) {
                    _txtLigne.setText("Votre ligne est ...");
                    _txtLigne.setTextColor(Color.parseColor("#000000"));
                    _txtCode.setText(String.format("Entrez votre code de recharge"));
                    _edtRecharge.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _edtSolde.setText(String.format(""));
                    _edtSolde.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _edtRecharge.setText(String.format(""));

                }
                else {
                    _btnRecharge.setEnabled(false);
                    _btnSolde.setEnabled(false);
                    _edtCode.setEnabled(false);
                    _edtCode.setText(String.format(""));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
            }
            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        _edtCode.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (_edtNumero.getText().toString().startsWith("5") && _edtNumero.length() == 8) {
                    _edtRecharge.setText(String.format("*100*"+ _edtCode.getText().toString() + "#"));
                    _btnRecharge.setEnabled(true);
                    _btnSolde.setEnabled(true);
                } else if (_edtNumero.getText().toString().startsWith("9") && _edtNumero.length() == 8) {
                    _edtRecharge.setText(String.format("*123*"+ _edtCode.getText().toString() + "#"));
                    _btnRecharge.setEnabled(true);
                    _btnSolde.setEnabled(true);
                }
                else if (_edtNumero.getText().toString().startsWith("2") && _edtNumero.length() == 8) {
                    _edtRecharge.setText(String.format("*101*"+ _edtCode.getText().toString() + "#"));
                    _btnRecharge.setEnabled(true);
                    _btnSolde.setEnabled(true);
                }
                else {
                    _btnRecharge.setEnabled(false);
                    _btnSolde.setEnabled(false);
                    _edtCode.setEnabled(false);
                    _edtCode.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(0)});
                    _edtRecharge.setText(String.format(""));
                }
            }

        });


        _btnRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri numero = Uri.parse("tel:" + Uri.encode(_edtRecharge.getText().toString()));
                Intent composer = new Intent(Intent.ACTION_DIAL, numero);
                startActivity(composer);

            }
        });

        _btnSolde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri numero = Uri.parse("tel:" + Uri.encode(_edtSolde.getText().toString()));
                Intent composer = new Intent(Intent.ACTION_DIAL, numero);
                startActivity(composer);

            }
        });

    }
}