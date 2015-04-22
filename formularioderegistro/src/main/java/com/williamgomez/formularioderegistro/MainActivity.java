package com.williamgomez.formularioderegistro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono = (EditText) findViewById(R.id.eTel);
        final TextView tName = (TextView) findViewById(R.id.tNombre);
        final TextView tMail = (TextView) findViewById(R.id.tCorreo);
        final TextView tTel = (TextView) findViewById(R.id.tTel);
        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tName.setText(eNombre.getText());
                tMail.setText(eCorreo.getText());
                tTel.setText(eTelefono.getText());
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
