package com.williamgomez.notafinal;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nota1=(EditText) findViewById(R.id.nota1);
        final EditText nota2=(EditText) findViewById(R.id.nota2);
        final EditText nota3=(EditText) findViewById(R.id.nota3);
        final EditText nota4=(EditText) findViewById(R.id.nota4);
        final Button bcalcular = (Button) findViewById(R.id.bcalcular);
        final TextView ttotal= (TextView) findViewById(R.id.ttotal);

        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttotal.setText(Float.toString( (float)0.25*(Float.parseFloat(nota1.getText().toString())+Float.parseFloat(nota2.getText().toString())+Float.parseFloat(nota3.getText().toString())+Float.parseFloat(nota4.getText().toString()))  ));
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
