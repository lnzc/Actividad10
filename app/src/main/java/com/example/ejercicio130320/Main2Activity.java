package com.example.ejercicio130320;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class Main2Activity extends Activity {
    TextView txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnRegresar = (Button) findViewById(R.id.btnRegresar);
        final TextView txtResutado = (TextView) findViewById(R.id.txtResultado);
        Bundle extras = getIntent().getExtras();
        cPersona otro= (cPersona)
                getIntent().getExtras().getParcelable("persona");
        String nombre = otro.getNombre();
        String telefono = otro.getTelefono();
        String correo = otro.getMail();
        String edad = otro.getEdad();
        txtResutado.setText(otro.getDatos());

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i2);
            }
        });
    }

}
