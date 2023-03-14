package es.ieslavereda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAceptar;
    private Button btnCancelar;
    private TextInputEditText etxt;

    private Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
        etxt = findViewById(R.id.etxt);


        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(new MyListener(etxt));



//        btnAceptar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                etxt.setText("Aceptar");
//            }
//        });
//
//        btnCancelar.setOnClickListener( v -> etxt.setText("Cancelar"));
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnAceptar)
            etxt.setText("Aceptar");
        else
            etxt.setText("Cancelar");

//        Button b = (Button) view;
//        etxt.setText(b.getText());
    }
}