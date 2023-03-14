package es.ieslavereda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private TextView display;
    private Button buttonPlus;
    private Button buttonEquals;
    private Operacion operacion;
    private float operando1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        display = findViewById(R.id.display);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEquals = findViewById(R.id.buttonEquals);

        inicializar();

    }

    private void inicializar() {
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operando1=Float.parseFloat(String.valueOf(display.getText()));
                operacion = Operacion.SUMA;
                display.setText("0");
            }
        });

        buttonEquals.setOnClickListener(v->{
            switch (operacion){
                case SUMA:display.setText(String.valueOf(operando1 + Float.parseFloat(String.valueOf(display.getText()))));
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(display.getText().equals("0"))
            display.setText(((Button)view).getText());
        else
            display.setText(String.valueOf(display.getText())+((Button)view).getText());

    }
}