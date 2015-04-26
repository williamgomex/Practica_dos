package com.williamgomez.dosnumeros;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText enumero1;
    EditText enumero2;
    RadioButton rsuma;
    RadioButton rresta;
    RadioButton rmul;
    RadioButton rdiv;
    Button bcalcular;
    TextView ttotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enumero1=(EditText) findViewById(R.id.enumero1);
        enumero2=(EditText) findViewById(R.id.enumero2);
        rsuma=(RadioButton) findViewById(R.id.rsuma);
        rresta=(RadioButton) findViewById(R.id.rresta);
        rmul=(RadioButton) findViewById(R.id.rmul);
        rdiv=(RadioButton) findViewById(R.id.rdiv);
        bcalcular= (Button) findViewById(R.id.bcalcular);
        ttotal= (TextView) findViewById(R.id.ttotal);


        Context context = getApplicationContext();
        CharSequence text = "Ingrese todos los campos";
        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context,getResources().getString(R.string.comentario),duration);




        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!enumero1.getText().toString().isEmpty()&&!enumero2.getText().toString().isEmpty())
                {
                    if(rsuma.isChecked()==true){
                        ttotal.setText(Float.toString(Float.parseFloat(enumero1.getText().toString())+Float.parseFloat(enumero2.getText().toString())));
                    }
                    else if(rresta.isChecked()==true){
                        ttotal.setText(Float.toString(Float.parseFloat(enumero1.getText().toString())-Float.parseFloat(enumero2.getText().toString())));
                    }
                    else if(rmul.isChecked()==true){
                        ttotal.setText(Float.toString(Float.parseFloat(enumero1.getText().toString())*Float.parseFloat(enumero2.getText().toString())));
                    }
                    else if(rdiv.isChecked()==true){
                        ttotal.setText(Float.toString(Float.parseFloat(enumero1.getText().toString())/Float.parseFloat(enumero2.getText().toString())));
                    }
                }
                else
                {
                    ttotal.setText(Float.toString(0));
                    toast.show();
                }

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