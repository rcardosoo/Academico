package com.example.rafael.jogoarrocha;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int valorCerto;
    private int valorEntrada;

    private Button btn;
    private EditText inpt;
    private TextView min;
    private TextView max;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////
        this.alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("ARROCHA");
        ////

        //gerar valor
        this.valorCerto = this.gerarValor();

        //min/max
        this.min = (TextView) findViewById(R.id.tvMainMinimo);
        this.max = (TextView) findViewById(R.id.tvMainMaximo);

        //pegar entrada
        this.btn = (Button) findViewById(R.id.btMainChecar);
        this.btn.setOnClickListener(new Botaoclique());

    }

    public int gerarValor() {
        Random r = new Random();
        return r.nextInt(98) + 2;
    }

    private class Botaoclique implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MainActivity.this.inpt = (EditText) findViewById(R.id.etMainNumero);
            MainActivity.this.valorEntrada = Integer.parseInt(MainActivity.this.inpt.getText().toString());

            if (MainActivity.this.valorEntrada < Integer.parseInt(MainActivity.this.min.getText().toString()) || MainActivity.this.valorEntrada > Integer.parseInt(MainActivity.this.max.getText().toString())) {
                MainActivity.this.alertDialog.setMessage("Digite um valor maior que o mínimo e menor que o máximo");
                MainActivity.this.alertDialog.show();
            } else {
                // --- se for o valorCerto, setar vencedor
                if (MainActivity.this.valorEntrada == MainActivity.this.valorCerto) {
                    MainActivity.this.alertDialog.setMessage("Você venceu! número: "+MainActivity.this.valorCerto);
                    MainActivity.this.alertDialog.show();

                } else {

                    if (MainActivity.this.valorEntrada > MainActivity.this.valorCerto) {
                        MainActivity.this.max.setText(Integer.toString(MainActivity.this.valorEntrada));
                    } else {
                        MainActivity.this.min.setText(Integer.toString(MainActivity.this.valorEntrada));
                    }
                    int vMinimo = Integer.parseInt(MainActivity.this.min.getText().toString());
                    int vMaximo = Integer.parseInt(MainActivity.this.max.getText().toString());
                    if (vMinimo == MainActivity.this.valorCerto-2 && vMaximo == MainActivity.this.valorCerto+2) {
                        MainActivity.this.alertDialog.setMessage("Você perdeu! número: "+MainActivity.this.valorCerto);
                        MainActivity.this.alertDialog.show();
                    }
                }
            }
        }
    }
}
