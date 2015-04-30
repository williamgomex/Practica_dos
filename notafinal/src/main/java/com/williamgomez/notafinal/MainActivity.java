package com.williamgomez.notafinal;

import android.content.Context;
import android.content.Intent;
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
     int p1=15,p2=20,p3=25,p4=30;
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

        Toast.makeText(this,"OnCreate()",Toast.LENGTH_SHORT).show();

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
                    ttotal.setText(Float.toString( ((float)p1/100*Float.parseFloat(nota1.getText().toString())+(float)p2/100*Float.parseFloat(nota2.getText().toString())+(float)p3/100*Float.parseFloat(nota3.getText().toString())+(float)p4/100*Float.parseFloat(nota4.getText().toString()))  ));
                }
                else{
                    ttotal.setText(Float.toString(0));
                    toast.show();
                }
            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"OnStop()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"OnDestroy()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"OnStart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"OnResume()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"OnPause()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"OnRestart()",Toast.LENGTH_SHORT).show();
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
            Intent k = new Intent(this,SettingsActivity.class);
            k.putExtra("pQuiz",p1);
            k.putExtra("pExp",p2);
            k.putExtra("pPra",p3);
            k.putExtra("pPre",p4);
            startActivityForResult(k, 2014);
            return true;
        }
        if(id == R.id.idmenuabout){
            Intent k = new Intent(this,Aboutactivity.class);
            startActivity(k);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==2014 && resultCode==RESULT_OK){
            p1= Integer.parseInt(data.getStringExtra("pQuizS"));
            p2= Integer.parseInt(data.getStringExtra("pExpS"));
            p3= Integer.parseInt(data.getStringExtra("pPraS"));
            p4= Integer.parseInt(data.getStringExtra("pProS"));
        }
    }
}
