package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AttributesActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button mybutton;
    Button next;

    public static JSONObject countryObject;
    public static JSONObject cityObject;
    public static JSONObject traits=new JSONObject();
    public static String gen;
    RadioButton rbmale,rbfemale,rburban,rbrural;
    SeekBar health,resis,happy,intel,art,music,ath,stren,phy,spirit,goodlooks;
    static int proghealth,progresis,proghappy,progintel,progart,progmusic,progath,progstren,progphy,progspirit,proglooks;
    String gender,locale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attributes);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        next=(Button)findViewById(R.id.selectNameButton);
        rbmale=findViewById(R.id.male);
        rbfemale=findViewById(R.id.female);
        rburban=findViewById(R.id.urban);
        rbrural=findViewById(R.id.rural);

        health=findViewById(R.id.SeekBar1);
        health.setMax(100);
        health.setProgress(0);

        resis=findViewById(R.id.SeekBar2);
        resis.setMax(100);
        resis.setProgress(0);

        happy=findViewById(R.id.SeekBar3);
        happy.setMax(100);
        happy.setProgress(0);

        intel=findViewById(R.id.SeekBar4);
        intel.setMax(100);
        intel.setProgress(0);

        art=findViewById(R.id.SeekBar5);
        art.setMax(100);
        art.setProgress(0);

        music=findViewById(R.id.SeekBar6);
        music.setMax(100);
        music.setProgress(0);

        ath=findViewById(R.id.SeekBar7);
        ath.setMax(100);
        ath.setProgress(0);

        stren=findViewById(R.id.SeekBar8);
        stren.setMax(100);
        stren.setProgress(0);

        phy=findViewById(R.id.SeekBar9);
        phy.setMax(100);
        phy.setProgress(0);

        spirit=findViewById(R.id.SeekBar10);
        spirit.setMax(100);
        spirit.setProgress(0);

        goodlooks=findViewById(R.id.SeekBar11);
        goodlooks.setMax(100);
        goodlooks.setProgress(0);

        Intent i=getIntent();
        try {
            countryObject=new JSONObject(i.getStringExtra("countryObject"));
            cityObject=new JSONObject(i.getStringExtra("cityObject"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("countryInAtt",countryObject.toString());
        Log.e("cityInAtt",cityObject.toString());


        calc();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AttributesActivity.this,ActivityFirstName.class);
                intent.putExtra("countryObject",countryObject.toString());
                intent.putExtra("cityObject",cityObject.toString());
                intent.putExtra("gender",gender);
                intent.putExtra("locale",locale);
                   intent.putExtra("traitsObject",traits.toString());

                startActivity(intent);
            }
        });


    }



    public void update() {
        if (gender != null || locale != null || progart != 0 || progath != 0 || proglooks != 0 || proghappy != 0 || proghealth != 0 || progintel != 0 || progmusic != 0 || progphy != 0 || progresis != 0 || progspirit != 0 || progstren != 0) {
            try {

                if (traits.has("artistic")) {
                    traits.remove("artistic");
                }
                traits.put("artistic", progart);

                if (traits.has("athletic")) {
                    traits.remove("athletic");
                }
                traits.put("athletic", progath);

                if (traits.has("goodLooks")) {
                    traits.remove("goodLooks");
                }
                traits.put("goodLooks", proglooks);

                if (traits.has("happiness")) {
                    traits.remove("happiness");
                }
                traits.put("happiness", proghappy);

                if (traits.has("health")) {
                    traits.remove("health");
                }
                traits.put("health", proghealth);

                if (traits.has("intelligence")) {
                    traits.remove("intelligence");
                }
                traits.put("intelligence", progintel);

                if (traits.has("musical")) {
                    traits.remove("musical");
                }
                traits.put("musical", progmusic);

                if (traits.has("physicalEndurance")) {
                    traits.remove("physicalEndurance");
                }
                traits.put("physicalEndurance", progphy);

                if (traits.has("resistance")) {
                    traits.remove("resistance");
                }
                traits.put("resistance", progresis);

                if (traits.has("spiritual")) {
                    traits.remove("spiritual");
                }
                traits.put("spiritual", progspirit);

                if (traits.has("strength")) {
                    traits.remove("strength");
                }
                traits.put("strength", progstren);


                Log.e("traitsinAtt",traits.toString());


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }



    void calc()
    {
        rbmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender=String.valueOf(rbmale.getText().charAt(0));
                Log.e("DATA",gender);
                update();
            }
        });

        rbfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender=String.valueOf(rbfemale.getText().charAt(0));
                Log.e("DATA",gender);
                update();
            }
        });

        rburban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locale=String.valueOf(rburban.getText().charAt(0));
                Log.e("DATA",locale);
                update();
            }
        });

        rbrural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locale=String.valueOf(rbrural.getText().charAt(0));
                Log.e("DATA",locale);
                update();
            }
        });
        //else if()

        health.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                proghealth=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  Toast.makeText(v.getContext(),"Health:"+String.valueOf(proghealth),Toast.LENGTH_SHORT).show();
                update();

            }
        });

        resis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progresis=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(v.getContext(),"Resistance:"+String.valueOf(progresis),Toast.LENGTH_SHORT).show();
                update();

            }
        });

        happy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                proghappy=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(v.getContext(),"Happiness:"+String.valueOf(proghappy),Toast.LENGTH_SHORT).show();
                update();

            }
        });


        intel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progintel=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(v.getContext(),"Intelligence:"+String.valueOf(progintel),Toast.LENGTH_SHORT).show();
                update();

            }
        });

        art.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progart=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(v.getContext(),"Artistic:"+String.valueOf(progart),Toast.LENGTH_SHORT).show();
                update();

            }
        });


        music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progmusic=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  Toast.makeText(v.getContext(),"Musical:"+String.valueOf(progmusic),Toast.LENGTH_SHORT).show();
                update();

            }
        });



        ath.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progath=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  Toast.makeText(v.getContext(),"Athletic:"+String.valueOf(progath),Toast.LENGTH_SHORT).show();
                update();

            }
        });




        stren.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progstren=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(v.getContext(),"Strength:"+String.valueOf(progstren),Toast.LENGTH_SHORT).show();
                update();

            }
        });



        phy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progphy=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(v.getContext(),"Physical:"+String.valueOf(progphy),Toast.LENGTH_SHORT).show();
                update();

            }
        });


        spirit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progspirit=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  Toast.makeText(v.getContext(),"Spiritual:"+String.valueOf(progspirit),Toast.LENGTH_SHORT).show();
                update();

            }
        });


        goodlooks.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                proglooks=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  Toast.makeText(v.getContext(),"Good Looks:"+String.valueOf(proglooks),Toast.LENGTH_SHORT).show();
                update();

            }
        });
    }





    public void tomainactivity(View view) {
        Intent intent = new Intent(AttributesActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void toselectcity(View view) {
        Intent i=getIntent();
        //Log.e("traitsObject",i.getStringExtra("traitsObject"));

        Intent intent = new Intent(AttributesActivity.this,Selectcity.class);
        startActivity(intent);
    }






}

