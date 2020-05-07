package com.example.asignaturas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView myList;
List<String> asignaturas=new ArrayList<String>(Arrays.asList("Facultativa II", "Planificaciòn TIC", "Investigaciòn Aplicada"));
MyAdapterlist Adapter;
EditText editText_Asignaturas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_Asignaturas=(EditText)findViewById(R.id.editText_Asignaturas);
        myList=(ListView)findViewById(R.id.list1);
        fillList();
        SelectItemList();
    }
    void fillList () {
        Adapter = new MyAdapterlist(this, R.layout.item_list, asignaturas);
        myList.setAdapter(Adapter);
    }

    void SelectItemList () {

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Asignatura:" + asignaturas.get(position), Toast.LENGTH_LONG).show();

            }
        });
    }

    void nuevo(String asignatura) {
        if(!asignatura.isEmpty())
        {
            asignaturas.add(asignatura);
            editText_Asignaturas.setText("");
            fillList();
            Toast.makeText(MainActivity.this, "Asignatura guardada" , Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Necesita agregar una asignatura" , Toast.LENGTH_LONG).show();
        }
    }

    //para el botòn
    public void Agregar(View v){
        String asignaturas=editText_Asignaturas.getText().toString();
        nuevo(asignaturas);
    }
}
