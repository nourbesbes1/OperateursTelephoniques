package com.example.tp3_operateurstelephoniques_nourbesbes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    EditText _edtLogin,_edtPwd;
    Button _btnConnexion;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _edtLogin = (EditText) findViewById(R.id.edtLogin);
        _edtPwd = (EditText) findViewById(R.id.edtPwd);
        _btnConnexion = (Button) findViewById(R.id.btnConnexion);

        db = openOrCreateDatabase("Operateurs",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS USERS (login varchar primary key, password varchar);");
        SQLiteStatement s = db.compileStatement("select count(*) from users;");
        long c = s.simpleQueryForLong();
        if (c==0){
            db.execSQL("insert into users (login, password) values (?,?)", new String[] {"nour", sha256("123456")});
        }
        _btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strLogin = _edtLogin.getText().toString();
                String strPwd = _edtPwd.getText().toString();
                Cursor cur = db.rawQuery("select password from users where login =?", new String[] {strLogin});
                try {
                    cur.moveToFirst();
                    String p = cur.getString(0);
                    if (p.equals(sha256(strPwd))){
                        Toast.makeText(getApplicationContext(),"Bienvenue " + strLogin, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(),Operateurs.class);
                        i.putExtra("USERNAME", strLogin);
                        startActivity(i);
                    }else{
                        _edtLogin.setText("");
                        _edtPwd.setText("");
                        Toast.makeText(getApplicationContext(),"Echec de connexion",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    _edtLogin.setText("");
                    _edtPwd.setText("");
                    Toast.makeText(getApplicationContext(),"Utilisateur Inexistant",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });




    }

    private String sha256(String s) {
        try {
            // Création du hash SHA256
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA256");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Création du chaîne en héxa
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length;i++){
                hexString.append(Integer.toHexString(messageDigest[i] & 0xFF));

            }
            return  hexString.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}