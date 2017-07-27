package com.umg.admin.loginumg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText Nombre;
    private EditText Contra;
    private TextView Info;
    private Button Loge;
    private int contador = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Nombre = (EditText) findViewById(R.id.etNombre);
         Contra = (EditText) findViewById(R.id.etPassword);
         Info = (TextView)findViewById(R.id.tvInfo);
         Loge = (Button)findViewById(R.id.btnLogin);


         Info.setText("Numero de intentos: 5, Si no se recuerda comuniquese con el Administrador");

        Loge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Nombre.getText().toString(),Contra.getText().toString());

            }
        });



    }

            private void validate(String userName, String userPassword){
            if ((userName.equals("Admin"))&& (userPassword.equals("1234"))){
                Intent intent = new  Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }else{
                contador--;

                Info.setText("Numero de intentos: " + String.valueOf(contador));
                Info.setText("le quedan intentos " + String.valueOf(contador) );
                if(contador == 0){
                    Loge.setEnabled(false);

                }
            }




        }
}
