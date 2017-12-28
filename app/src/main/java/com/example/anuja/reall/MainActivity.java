package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
SharedPreferences pref;
ImageButton play;
Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        play=(ImageButton)findViewById(R.id.playbutton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Loading.class);
                startActivity(intent);

            }
        });


            btn_exit = (Button) findViewById(R.id.button5);
            btn_exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("token","");
                    editor.putString("username","");
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this,login.class);
                    startActivity(intent);
                }
            });



    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, Loadlife.class);
        startActivity(intent);

    }

    public void loadlife(View view)
    {
        Intent intent = new Intent(MainActivity.this, DesignALife.class);
        startActivity(intent);

    }

    public void tocompletedlives(View view)
    {
        Intent intent = new Intent(MainActivity.this, CompletedLives.class);
        startActivity(intent);

    }

    public void tolivealife(View view)
    {
        Intent intent = new Intent(MainActivity.this, Loading.class);
        startActivity(intent);

    }

    public void tosettings(View view)
    {
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);

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
