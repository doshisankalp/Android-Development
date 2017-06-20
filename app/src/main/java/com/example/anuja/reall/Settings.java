package com.example.anuja.reall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Settings extends AppCompatActivity {

    CheckBox checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.conscience_Box:
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.conscience_sub_Box);
                CheckBox checkBox2 = (CheckBox) findViewById(R.id.charity_Box);
                CheckBox checkBox3 = (CheckBox) findViewById(R.id.crime_Box);
                CheckBox checkBox4 = (CheckBox) findViewById(R.id.volunteer_Box);
                CheckBox checkBox5 = (CheckBox) findViewById(R.id.greed_Box);
                CheckBox checkBox6 = (CheckBox) findViewById(R.id.selfSacrifice_Box);
                CheckBox checkBox7 = (CheckBox) findViewById(R.id.truthfulness_Box);
                CheckBox checkBox8 = (CheckBox) findViewById(R.id.takingAStand_Box);
                if (checked) {
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    checkBox4.setChecked(true);
                    checkBox5.setChecked(true);
                    checkBox6.setChecked(true);
                    checkBox7.setChecked(true);
                    checkBox8.setChecked(true);
                }
                // Put some meat on the sandwich
                else{
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                }

                break;
            case R.id.governmentHumanRights_Box:
                if (checked) {
                }
                // Cheese me
                else
                    // I'm lactose intolerant
                    break;
                // TODO: Veggie sandwich
        }
    }


//    public void mainCheckbox(View view)
//    {
//
//    }


}

