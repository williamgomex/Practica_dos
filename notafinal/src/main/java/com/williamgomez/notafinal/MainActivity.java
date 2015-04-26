package com.williamgomez.notafinal;

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

     EditText nota1;
     EditText nota2;
     EditText nota3;
     EditText nota4;
     Button bcalcular;
     TextView ttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      nota1=(EditText) findViewById(R.id.nota1);
      nota2=(EditText) findViewById(R.id.nota2);
      nota3=(EditText) findViewById(R.id.nota3);
      nota4=(EditText) findViewById(R.id.nota4);
      bcalcular = (Button) findViewById(R.id.bcalcular);
      ttotal= (TextView) findViewById(R.id.ttotal);

        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.comentario);
        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);


        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nota1.getText().toString().isEmpty() && !nota2.getText().toString().isEmpty() && !nota3.getText().toString().isEmpty() && !nota4.getText().toString().isEmpty() ){
                    ttotal.setText(Float.toString( (float)0.25*(Float.parseFloat(nota1.getText().toString())+Float.parseFloat(nota2.getText().toString())+Float.parseFloat(nota3.getText().toString())+Float.parseFloat(nota4.getText().toString()))  ));
                }
                else{
                    ttotal.setText(Float.toString(0));
                    toast.show();
                }
            }
        });



    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString("total", ttotal.getText().toString());

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
