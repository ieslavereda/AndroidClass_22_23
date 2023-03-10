package es.ieslavereda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        display = findViewById(R.id.display);
    }

    @Override
    public void onClick(View view) {
        if(display.getText().equals("0"))
            display.setText(((Button)view).getText());
        else
            display.setText(String.valueOf(display.getText())+((Button)view).getText());

    }
}