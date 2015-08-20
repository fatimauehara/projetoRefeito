package com.example.xubuntu_developer.testeapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AtividadePrincipal extends ActionBarActivity {
    private ArrayAdapter<String> mAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_principal);

        String [] dados= {
                "Contatos",
                "Famíla",
                "Amigos",
                "Trabalho "

        };
        List<String> grupos = new ArrayList<>(Arrays.asList(dados));

        //CRIAR O ADAPTADOR
        mAdaptador= new ArrayAdapter<>(
                getApplicationContext(), //contexto atual
                R.layout.item_lista_principal, //nome do ID do layout
                R.id.item_texto, //ID do TextView a ser prenchido
                grupos);

        ListView listView = (ListView) findViewById(R.id.lista_principal);
        listView.setAdapter(mAdaptador);

        listView.setOnItemClickListener(new ItemClicado());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atividade_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ItemClicado implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            Intent detailIntent = new Intent(getApplicationContext(),AtividadeDetalhes.class);
            detailIntent.putExtra(Intent.EXTRA_TEXT,mAdaptador.getItem(position));
            startActivity(detailIntent);


        }
    }

}
