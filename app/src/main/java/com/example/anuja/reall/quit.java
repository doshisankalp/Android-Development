package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 8/1/18.
 */

public class quit extends AppCompatActivity{
Button yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_quit);


        yes=(Button)findViewById(R.id.parents_dialog_moveout);
        no=(Button)findViewById(R.id.parents_dialog_cancel);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(quit.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }

}
