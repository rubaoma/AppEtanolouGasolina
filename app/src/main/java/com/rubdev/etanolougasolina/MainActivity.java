package com.rubdev.etanolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoEtanol;
    private TextInputEditText editPrecoGasolina;
    private TextView textResultado;
    private Button calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoEtanol = findViewById(R.id.editPrecoEtanol);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }


    public void calcularPreco(View view) {
        // recuperar valores digitados
        String precoEtanol = editPrecoEtanol.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();
        Boolean camposValidados = validarCampos(precoEtanol, precoGasolina);

        if (camposValidados){

            Double valorEtanol = Double.parseDouble( precoEtanol);
            Double valorGasolina = Double.parseDouble( precoGasolina);

            if ( valorEtanol / valorGasolina >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina");
            } else {
                textResultado.setText("Melhor utilizar Etanol");
            }

        }else {
            textResultado.setText("Preencha os preços primeiro!");
        }


    }

    public Boolean validarCampos(String pEtanol, String pGasolina){
        Boolean camposValidados = true;

        if (pEtanol == null || pEtanol.equals("")){
            camposValidados = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }


}
