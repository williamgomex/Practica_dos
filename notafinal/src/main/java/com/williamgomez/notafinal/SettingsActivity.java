package com.williamgomez.notafinal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SettingsActivity extends ActionBarActivity {
    EditText Quiz;
    EditText Expo;
    EditText Proy;
    EditText Prac;
    Button Calcular;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Quiz = (EditText) findViewById(R.id.p1);
        Expo = (EditText) findViewById(R.id.p2);
        Prac = (EditText) findViewById(R.id.p3);
        Proy = (EditText) findViewById(R.id.p4);
        Calcular = (Button) findViewById(R.id.bconfig);

        Bundle extras = getIntent().getExtras();
        Quiz.setText(String.valueOf(extras.getInt("pQuiz")));
        Expo.setText(String.valueOf(extras.getInt("pExp")));
        Prac.setText(String.valueOf(extras.getInt("pPra")));
        Proy.setText(String.valueOf(extras.getInt("pPre")));



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

    public void listenerbconfig(View view){
        Intent k = new Intent();
        k.putExtra("pQuizS",Quiz.getText().toString());
        k.putExtra("pExpS",Expo.getText().toString());
        k.putExtra("pPraS",Prac.getText().toString());
        k.putExtra("pProS",Proy.getText().toString());
        setResult(RESULT_OK,k);
        finish();
    }
}

