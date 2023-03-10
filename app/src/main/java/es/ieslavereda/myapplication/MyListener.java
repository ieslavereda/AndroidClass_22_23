package es.ieslavereda.myapplication;

import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MyListener implements View.OnClickListener{

    private TextInputEditText etxt;

    public MyListener(TextInputEditText etxt) {
        this.etxt = etxt;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnAceptar)
            etxt.setText("Aceptar");
        else
            etxt.setText("Cancelar");
    }
}
