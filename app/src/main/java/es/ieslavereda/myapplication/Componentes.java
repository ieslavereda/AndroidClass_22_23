package es.ieslavereda.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Componentes extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView textView;

    private Spinner spinner;

    private TextInputEditText tietxtNombre;
    private TextInputEditText tietxtApelidos;
    private Button buttonAdd;
    private ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes);

        tietxtApelidos = findViewById(R.id.tietxApellidos);
        tietxtNombre = findViewById(R.id.tietxNombre);
        buttonAdd = findViewById(R.id.buttonAdd);

        List<String> sexo = new ArrayList<>();
        sexo.add("hombre");
        sexo.add("mujer");

        if(savedInstanceState!=null)
            usuarios = (ArrayList<Usuario>) savedInstanceState.getSerializable("usuarios");
        else {
            usuarios = new ArrayList<>();
            usuarios.add(new Usuario("Joaquin", "Alonso Saiz"));
            usuarios.add(new Usuario("Pedro", "Garcia Lopez"));
        }
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

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = tietxtNombre.getText().toString();
                String apellidos = tietxtApelidos.getText().toString();
                usuarios.add(new Usuario(nombre,apellidos));
                tietxtNombre.setText("");
                tietxtApelidos.setText("");
                myAdapter.notifyDataSetChanged();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(usuarios.get(i).toString());
//                adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("usuarios",usuarios);
    }
}