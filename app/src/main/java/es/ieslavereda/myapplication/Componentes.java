package es.ieslavereda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Componentes extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView textView;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes);

        List<String> sexo = new ArrayList<>();
        sexo.add("hombre");
        sexo.add("mujer");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Joaquin","Alonso Saiz"));
        usuarios.add(new Usuario("Pedro","Garcia Lopez"));

        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButtonM:
                        textView.setText("Mujer");
                        break;
                    case R.id.radioButton:
                        textView.setText("Hombre");
                        break;
                    case R.id.radioButtonNSNC:
                        textView.setText("NSNC");
                        break;
                }

            }
        });

//        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sexo);
//        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this,R.array.valores_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<Usuario> myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,usuarios);
        spinner.setAdapter(myAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(sexo.get(i));
//                adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}