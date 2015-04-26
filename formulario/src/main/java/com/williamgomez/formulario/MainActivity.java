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
    Spinner sciudad;
    RadioButton mascu;
    RadioButton femen;
    DatePicker fecha;
    EditText eNombre;
    EditText eCorreo;
    EditText eTel;
    TextView tNombre;
    TextView tTel;
    TextView tCorreo;
    TextView tHobbies;
    TextView tCiudad;
    TextView tGenero;
    TextView tFecha;

    CheckBox hobby1;
    CheckBox hobby2;
    CheckBox hobby3;
    CheckBox hobby4;

    Button bOk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sciudad = (Spinner) findViewById(R.id.sciudad);
        mascu = (RadioButton) findViewById(R.id.rmasc);
        femen = (RadioButton) findViewById(R.id.rfem);
        fecha = (DatePicker) findViewById(R.id.datef);
        eNombre = (EditText) findViewById(R.id.eNombre);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eTel = (EditText) findViewById(R.id.eTel);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sciudad.setAdapter(adapter);
        tNombre = (TextView) findViewById(R.id.tNombre);
        tTel = (TextView) findViewById(R.id.tTel);
        tCorreo = (TextView) findViewById(R.id.tCorreo);
        tHobbies = (TextView) findViewById(R.id.tHobbies);
        tCiudad = (TextView) findViewById(R.id.tCiudad);
        tGenero = (TextView) findViewById(R.id.tGenero);
        tFecha = (TextView) findViewById(R.id.tFecha);

        hobby1 = (CheckBox) findViewById(R.id.hobby1);
        hobby2 = (CheckBox) findViewById(R.id.hobby2);
        hobby3 = (CheckBox) findViewById(R.id.hobby3);
        hobby4 = (CheckBox) findViewById(R.id.hobby4);

        bOk = (Button) findViewById(R.id.boton);

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

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString("nombre", tNombre.getText().toString());
        savedInstanceState.putString("correo", tCorreo.getText().toString());
        savedInstanceState.putString("telefono", tTel.getText().toString());
        savedInstanceState.putString("genero", tGenero.getText().toString());
        savedInstanceState.putString("ciudad", tCiudad.getText().toString());
        savedInstanceState.putString("hobbies", tHobbies.getText().toString());
        savedInstanceState.putString("fecha", tFecha.getText().toString());


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        tNombre.setText(savedInstanceState.getString("nombre"));
        tCorreo.setText(savedInstanceState.getString("correo"));
        tTel.setText(savedInstanceState.getString("telefono"));
        tGenero.setText(savedInstanceState.getString("genero"));
        tCiudad.setText(savedInstanceState.getString("ciudad"));
        tHobbies.setText(savedInstanceState.getString("hobbies"));
        tFecha.setText(savedInstanceState.getString("fecha"));

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
