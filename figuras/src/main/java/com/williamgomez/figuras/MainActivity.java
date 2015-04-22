package com.williamgomez.figuras;

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

        final EditText ebase = (EditText) findViewById(R.id.ebase);
        final EditText eradio = (EditText) findViewById(R.id.eradio);
        final EditText ealtura = (EditText) findViewById(R.id.ealtura);
        final EditText elado = (EditText) findViewById(R.id.elado);
        final RadioButton rtriang= (RadioButton) findViewById(R.id.rtrian);
        final RadioButton rrect= (RadioButton) findViewById(R.id.rrect);
        final RadioButton rcuad= (RadioButton) findViewById(R.id.rcuad);
        final RadioButton rcirc= (RadioButton) findViewById(R.id.rcirc);
        final TextView ttotal = (TextView) findViewById(R.id.ttotal);
        final Button bcal = (Button) findViewById(R.id.bcalcular);

        bcal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(rtriang.isChecked()==true){
                    ttotal.setText(Float.toString(Float.parseFloat(ebase.getText().toString())*Float.parseFloat(ealtura.getText().toString())/2));
                }
                if(rrect.isChecked()==true){
                    ttotal.setText(Float.toString(Float.parseFloat(ebase.getText().toString())*Float.parseFloat(ealtura.getText().toString())));
                }
                if(rcuad.isChecked()==true){
                    ttotal.setText(Float.toString(Float.parseFloat(elado.getText().toString())*Float.parseFloat(elado.getText().toString())));
                }
                if(rcirc.isChecked()==true){
                    ttotal.setText(Float.toString( (float)(Math.pow(Float.parseFloat(eradio.getText().toString()),2)*Math.PI) ));
                }
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
