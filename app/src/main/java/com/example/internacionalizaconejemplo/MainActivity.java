package com.example.internacionalizaconejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button boton1;
    String guardandoVariable;
    public static final String EXTRA_SAVE="MANTENIENDO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);
        boton1 = findViewById(R.id.button3);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("hola");
            }
        });
      if(savedInstanceState != null){ //ya se esta recreando la actividad al girar la pantalla, y paso los datos
            guardandoVariable=savedInstanceState.getString(EXTRA_SAVE, "ninguno");
            txt.setText(guardandoVariable);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) { //guardo los datos al girar la pantalla para usarlo luego, se ejecua al rotar el dispostivo
        super.onSaveInstanceState(bundle);
        String datoGuardar= txt.getText().toString();
        bundle.putString(EXTRA_SAVE, datoGuardar); //poniendo el string en el bundle, esa llave solo tiene que ver con el bundle, no con el intento
    }
}