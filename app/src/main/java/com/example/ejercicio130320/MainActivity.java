package com.example.ejercicio130320;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText nombre,telefono,correo, edad;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAceptar=(Button)findViewById(R.id.btnEnviar);
        nombre =(EditText)findViewById(R.id.nombre);
        telefono=(EditText)findViewById(R.id.telefono);
        correo = (EditText)findViewById(R.id.correo);
        edad = (EditText)findViewById(R.id.edad);
        text = (TextView)findViewById(R.id.text);
        String nombreM = "";
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            nombreM = extras.getString("MAYUS").toLowerCase();
            text.setText(nombreM);
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("NOMBRE",nombre.getText().toString());
                i.putExtra("TELEFONO",telefono.getText().toString());
                i.putExtra("CORREO",correo.getText().toString());
                i.putExtra("EDAD",edad.getText().toString());
                startActivity(i);
            }
        });
    }
}
