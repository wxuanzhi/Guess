package com.wxuanzhi.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int secret = new Random().nextInt(10) + 1;
    private EditText gue;
    private TextView point;
    private TextView edcounter;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gue = findViewById(R.id.guess);
        point = findViewById(R.id.result);
        edcounter = findViewById(R.id.counter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

            }
        });
    }


    public void enter(View view){
        int guess = Integer.parseInt(gue.getText().toString());
        counter++;
        edcounter.setText(counter+"");

        if(guess > secret){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("haha")
                    .setMessage("Smaller")
                    .setPositiveButton("OK",null).show();
        }
        else if(guess < secret){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("haha")
                    .setMessage("Bigger")
                    .setPositiveButton("OK",null).show();
        }
        else if(guess == secret){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("haha")
                    .setMessage("Bingo")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            secret = new Random().nextInt(10)+1;
                            edcounter.setText(counter+"");
                        }
                    });
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
