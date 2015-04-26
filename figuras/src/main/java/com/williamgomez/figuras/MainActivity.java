package com.williamgomez.figuras;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText ebase;
    EditText eradio;
    EditText ealtura;
    EditText elado;
    RadioButton rtriang;
    RadioButton rrect;
    RadioButton rcuad;
    RadioButton rcirc;
    TextView ttotal;
    Button bcal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ebase = (EditText) findViewById(R.id.ebase);
        eradio = (EditText) findViewById(R.id.eradio);
        ealtura = (EditText) findViewById(R.id.ealtura);
        elado = (EditText) findViewById(R.id.elado);
        rtriang= (RadioButton) findViewById(R.id.rtrian);
        rrect= (RadioButton) findViewById(R.id.rrect);
        rcuad= (RadioButton) findViewById(R.id.rcuad);
        rcirc= (RadioButton) findViewById(R.id.rcirc);
        ttotal = (TextView) findViewById(R.id.ttotal);
        bcal = (Button) findViewById(R.id.bcalcular);

        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.comentario);
        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);

        eradio.setVisibility(View.INVISIBLE);
        elado.setVisibility(View.INVISIBLE);
        ealtura.setVisibility(View.INVISIBLE);
        ebase.setVisibility(View.INVISIBLE);

        bcal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(rtriang.isChecked()==true){
                    if(!ebase.getText().toString().isEmpty()&&!ealtura.getText().toString().isEmpty())
                    {
                        ttotal.setText(Float.toString((Float.parseFloat(ebase.getText().toString())*Float.parseFloat(ealtura.getText().toString()))/2));
                    }
                    else
                    {
                        ttotal.setText(Float.toString(0));
                        toast.show();
                    }
                }
                if(rrect.isChecked()==true){
                    if(!ebase.getText().toString().isEmpty()&&!ealtura.getText().toString().isEmpty()){
                        ttotal.setText(Float.toString(Float.parseFloat(ebase.getText().toString())*Float.parseFloat(ealtura.getText().toString())));
                    }
                    else{
                        ttotal.setText(Float.toString(0));
                        toast.show();
                    }
                }
                if(rcuad.isChecked()==true){
                    if(!elado.getText().toString().isEmpty()){
                        ttotal.setText(Float.toString(Float.parseFloat(elado.getText().toString())*Float.parseFloat(elado.getText().toString())));
                    }
                    else
                    {
                        ttotal.setText(Float.toString(0));
                        toast.show();
                    }
                }
                if(rcirc.isChecked()==true){
                    if(!eradio.getText().toString().isEmpty()){
                        ttotal.setText(Float.toString( (float)(Math.pow(Float.parseFloat(eradio.getText().toString()),2)*Math.PI) ));
                    }
                    else
                    {
                        ttotal.setText(Float.toString(0));
                        toast.show();
                    }
                }
            }
        });


        rtriang.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                eradio.setVisibility(View.INVISIBLE);
                elado.setVisibility(View.INVISIBLE);
                ealtura.setVisibility(View.VISIBLE);
                ebase.setVisibility(View.VISIBLE);
            }
        });
        rcirc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                eradio.setVisibility(View.VISIBLE);
                elado.setVisibility(View.INVISIBLE);
                ealtura.setVisibility(View.INVISIBLE);
                ebase.setVisibility(View.INVISIBLE);
            }
        });
        rrect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                eradio.setVisibility(View.INVISIBLE);
                elado.setVisibility(View.INVISIBLE);
                ealtura.setVisibility(View.VISIBLE);
                ebase.setVisibility(View.VISIBLE);
            }
        });
        rcuad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                eradio.setVisibility(View.INVISIBLE);
                elado.setVisibility(View.VISIBLE);
                ealtura.setVisibility(View.INVISIBLE);
                ebase.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString("total",ttotal.getText().toString());

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        ttotal.setText(savedInstanceState.getString("total"));

        if(rtriang.isChecked()==true)
        {
                eradio.setVisibility(View.INVISIBLE);
                elado.setVisibility(View.INVISIBLE);
                ealtura.setVisibility(View.VISIBLE);
                ebase.setVisibility(View.VISIBLE);
        }
        if(rcirc.isChecked()==true)
        {
                eradio.setVisibility(View.VISIBLE);
                elado.setVisibility(View.INVISIBLE);
                ealtura.setVisibility(View.INVISIBLE);
                ebase.setVisibility(View.INVISIBLE);
        }

        if(rrect.isChecked()==true)
        {
            eradio.setVisibility(View.INVISIBLE);
            elado.setVisibility(View.INVISIBLE);
            ealtura.setVisibility(View.VISIBLE);
            ebase.setVisibility(View.VISIBLE);
        }
        if(rcuad.isChecked()==true)
        {
                eradio.setVisibility(View.INVISIBLE);
                elado.setVisibility(View.VISIBLE);
                ealtura.setVisibility(View.INVISIBLE);
                ebase.setVisibility(View.INVISIBLE);
        }

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
