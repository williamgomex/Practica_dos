package com.williamgomez.formulario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner sciudad = (Spinner) findViewById(R.id.sciudad);
        final RadioButton mascu = (RadioButton) findViewById(R.id.rmasc);
        final RadioButton femen = (RadioButton) findViewById(R.id.rfem);
        final DatePicker fecha = (DatePicker) findViewById(R.id.datef);
        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTel = (EditText) findViewById(R.id.eTel);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sciudad.setAdapter(adapter);
        final TextView tNombre = (TextView) findViewById(R.id.tNombre);
        final TextView tTel = (TextView) findViewById(R.id.tTel);
        final TextView tCorreo = (TextView) findViewById(R.id.tCorreo);
        final TextView tHobbies = (TextView) findViewById(R.id.tHobbies);
        final TextView tCiudad = (TextView) findViewById(R.id.tCiudad);
        final TextView tGenero = (TextView) findViewById(R.id.tGenero);
        final TextView tFecha = (TextView) findViewById(R.id.tFecha);

        final CheckBox hobby1 = (CheckBox) findViewById(R.id.hobby1);
        final CheckBox hobby2 = (CheckBox) findViewById(R.id.hobby2);
        final CheckBox hobby3 = (CheckBox) findViewById(R.id.hobby3);
        final CheckBox hobby4 = (CheckBox) findViewById(R.id.hobby4);

        final Button bOk = (Button) findViewById(R.id.boton);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tNombre.setText(eNombre.getText());
                tCorreo.setText(eCorreo.getText());
                tTel.setText(eTel.getText());

                if(mascu.isChecked()==true){
                    tGenero.setText("Masculino");
                }
                if(femen.isChecked()==true){
                    tGenero.setText("Femenino");
                }
                String hobbies = new String();

                if(hobby1.isChecked()==true){
                    hobbies += getResources().getString(R.string.hobby1);
                }
                if(hobby2.isChecked()==true){
                    hobbies += "\n";
                    hobbies += getResources().getString(R.string.hobby2);
                }
                if(hobby3.isChecked()==true){
                    hobbies += "\n";
                    hobbies += getResources().getString(R.string.hobby3);
                }
                if(hobby4.isChecked()==true){
                    hobbies += "\n";
                    hobbies += getResources().getString(R.string.hobby4);
                }
                tHobbies.setText(hobbies);




                tFecha.setText(Integer.toString(fecha.getDayOfMonth())+"/"+
                Integer.toString(fecha.getMonth()+1)+"/"+
                Integer.toString(fecha.getYear()));
                String[] aciudades = getResources().getStringArray(R.array.ciudades);
                tCiudad.setText(aciudades[(int)sciudad.getSelectedItemId()]);
            }
        });

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
