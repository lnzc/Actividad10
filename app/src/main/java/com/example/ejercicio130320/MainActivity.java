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
    public cPersona persona =new cPersona();
    String nombre,telefono,correo, edad;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAceptar=(Button)findViewById(R.id.btnEnviar);
        Button btnLimpiar=(Button)findViewById(R.id.btnLimpiar);
        final EditText edtNombre =(EditText)findViewById(R.id.edtNombre);
        final EditText edtTelefono=(EditText)findViewById(R.id.telefono);
        final EditText edtCorreo = (EditText)findViewById(R.id.correo);
        final EditText edtEdad = (EditText)findViewById(R.id.edad);
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
                nombre=edtNombre.getText().toString();
                edad=edtEdad.getText().toString();
                correo=edtCorreo.getText().toString();
                telefono=edtTelefono.getText().toString();
                persona.setNombre(nombre);
                persona.setEdad(edad);
                persona.setMail(correo);
                persona.setTelefono(telefono);
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("persona",persona);
                startActivity(i);
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCorreo.setText("");
                edtNombre.setText("");
                edtEdad.setText("");
                edtTelefono.setText("");
                nombre="";
                correo="";
                edad="";
                telefono="";
                edtNombre.requestFocus();

            }
        });
    }

    }

