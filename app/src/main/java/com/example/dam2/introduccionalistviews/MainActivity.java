package com.example.dam2.introduccionalistviews;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends ListActivity {

    private TextView selection;
    private static final String[] items ={"En","un","lugar","de",
            "la","mancha","de","cuyo","nombre","no","quiero",
            "acordarme","no","ha","mucho","tiempo","que","vivia",
            "un","hidalgo","de","los","de","lanza","en","astillero",
            "adarga","antigua","rocin","flaco","y","galgo","corredor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,
                        items);
        setListAdapter(arrayAdapter);
        selection=(TextView) findViewById(R.id.elemento_seleccionado);

    }

    @Override
    public void onListItemClick(ListView parent, View v, int position,long id){
        SparseBooleanArray marcados = parent.getCheckedItemPositions();
        StringBuilder elementos = new StringBuilder();
        if (marcados != null){
            for (int i=0;i<marcados.size();i++){
                if(marcados.valueAt(i)){
                    elementos.append(items[marcados.keyAt(i)]);
                    elementos.append(" + ");
                }
            }
            elementos.delete(elementos.lastIndexOf(" + "),elementos.length()-1);
        }
        selection.setText(elementos.toString());
    }
}
