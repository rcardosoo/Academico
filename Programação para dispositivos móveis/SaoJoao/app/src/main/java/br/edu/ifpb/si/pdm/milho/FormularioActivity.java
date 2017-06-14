package br.edu.ifpb.si.pdm.milho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FormularioActivity extends AppCompatActivity {
    private EditText descricao;
    private EditText quantidade;
    private EditText valor;
    private Button salvar;
    private Button cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.descricao  = (EditText) findViewById(R.id.etFormularioDescricao);
        this.quantidade = (EditText) findViewById(R.id.etFormularioQtde);
        this.valor      = (EditText) findViewById(R.id.etFormularioValor);

        this.salvar     = (Button) findViewById(R.id.btFormularioSalvar);
        this.cancelar   = (Button) findViewById(R.id.btFormularioCancelar);

        this.salvar.setOnClickListener(new BotaoCliqueSalvar());
        this.cancelar.setOnClickListener(new BotaoCliqueCancelar());

        //----------------------------------------------------------
    }

    private class BotaoCliqueSalvar implements View.OnClickListener {
        private String descricao;
        private int quantidade;
        private float valor;
        private Gasto gasto;
        private Cadastro cadastro;

        @Override
        public void onClick(View v) {
            this.descricao = FormularioActivity.this.descricao.getText().toString();
            this.quantidade = Integer.parseInt(FormularioActivity.this.quantidade.getText().toString());
            this.valor = Float.parseFloat(FormularioActivity.this.valor.getText().toString());

            this.gasto = new Gasto(this.descricao, this.quantidade, this.valor);
            Intent it = new Intent();
            it.putExtra("GASTO", this.gasto);

            setResult(RESULT_OK, it);
            finish();
        }
    }

    private class BotaoCliqueCancelar implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //
        }
    }
}
