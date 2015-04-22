package com.williamgomez.dosnumeros;

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


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText enumero1=(EditText) findViewById(R.id.enumero1);
        final EditText enumero2=(EditText) findViewById(R.id.enumero2);
        final RadioButton rsuma=(RadioButton) findViewById(R.id.rsuma);
        final RadioButton rresta=(RadioButton) findViewById(R.id.rresta);
        final RadioButton rmul=(RadioButton) findViewById(R.id.rmul);
        final RadioButton rdiv=(RadioButton) findViewById(R.id.rdiv);
        final Button bcalcular= (Button) findViewById(R.id.bcalcular);
        final TextView ttotal= (TextView) findViewById(R.id.ttotal);

        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
