package br.edu.ifpb.si.pdm.milho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private static final int FORMULARIO = 1;
    private Cadastro cadastro;
    private ListView lvGastos;

    public MainActivity () {
        this.cadastro = new Cadastro();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar novo item?", Snackbar.LENGTH_LONG)
                        .setAction("Sim", new BotaoClickListener()).show();
            }
        });

        this.lvGastos = (ListView) findViewById(R.id.listaGastos);

        ArrayAdapter<Gasto> adapter = new ArrayAdapter<Gasto>(this, android.R.layout.simple_list_item_1, this.cadastro.getGastos());
        this.lvGastos.setAdapter(adapter);
        this.lvGastos.setOnItemClickListener(new ItemListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_orcamento) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == FORMULARIO) {
                Gasto g = (Gasto) data.getSerializableExtra("GASTO");

                MainActivity.this.cadastro.add(g);
                Log.i("TESTE", "Quantidade: "+MainActivity.this.cadastro.getQuantidade());
                ((ArrayAdapter) MainActivity.this.lvGastos.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private class BotaoClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent it = new Intent(MainActivity.this, FormularioActivity.class);
            startActivityForResult(it, FORMULARIO);
        }
    }

    private class ItemListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Gasto g = MainActivity.this.cadastro.getGastoPosicao(position);
            Log.i("TESTE", g.toString());
        }
    }
}
