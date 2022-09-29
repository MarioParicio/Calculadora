package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadora.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    static String c2 = "";

    String operacion(EditText primerNumero, EditText segundoNumero, String operacion){

        if (!primerNumero.getText().toString().isEmpty() && !segundoNumero.getText().toString().isEmpty()) {
            double numero1 = Double.parseDouble(primerNumero.getText().toString());
            double numero2 = Double.parseDouble(segundoNumero.getText().toString());
            switch (operacion){
                case "+":
                    return Double.toString(numero1 + numero2);
                case "-":
                    return Double.toString(numero1 - numero2);
                case "*":
                    return Double.toString(numero1 * numero2);
                case "/":
                    return Double.toString(numero1 / numero2);
            }
            return (Double.toString(numero1 + numero2));}
        else {
            Log.d("MainActivity", "Un campo esta vacio");
            Toast.makeText(MainActivity.this, R.string.Fallo_introducir_valores, Toast.LENGTH_LONG).show();
            return "";
        }

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText primerNumero = binding.EtNumero1;
        EditText segundoNumero = binding.EtNumero1;
        TextView resultado = binding.tvResultado;


        binding.btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultado.setText(operacion(primerNumero, segundoNumero, "+"));
            }});
         binding.btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultado.setText(operacion(primerNumero, segundoNumero, "-"));

            }
        });
          binding.btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultado.setText(operacion(primerNumero, segundoNumero, "*"));

            }
        });
          binding.btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultado.setText(operacion(primerNumero, segundoNumero, "/"));

            }
        }
        );



    }
}