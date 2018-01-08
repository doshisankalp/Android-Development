package com.example.anuja.reall;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ANUJA on 08/Jun/2017.
 */


public class PersonalityFragment extends Fragment {
    RadioButton rbmale,rbfemale,rburban,rbrural;
    SeekBar health,resis,happy,intel,art,music,ath,stren,phy,spirit,goodlooks;
    static int proghealth,progresis,proghappy,progintel,progart,progmusic,progath,progstren,progphy,progspirit,proglooks;
    public static JSONObject traits=new JSONObject();
    static Bundle b;

    public static String gender,locale;

    ObjectDataInter objectDataInter;


    public PersonalityFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
    }

    public void update()
    {
        if(gender!=null&&locale!=null&&progart!=0&&progath!=0&&proglooks!=0&&proghappy!=0&&proghealth!=0&&progintel!=0&&progmusic!=0&&progphy!=0&&progresis!=0&&progspirit!=0&&progstren!=0) {
            try {
                /*if(traits.has("sex"))
                {
                    traits.remove("sex");
                }
                traits.put("sex",gender);


                if(traits.has("urbanRular"))
                {
                    traits.remove("urbanRular");
                }
                traits.put("urbanRular",locale);*/

                if(traits.has("artistic")) {
                    traits.remove("artistic");
                }
                traits.put("artistic", progart);

                if(traits.has("athletic")) {
                    traits.remove("athletic");
                }
                traits.put("athletic", progath);

                if(traits.has("goodLooks")) {
                    traits.remove("goodLooks");
                }
                traits.put("goodLooks", proglooks);

                if(traits.has("happiness")) {
                    traits.remove("happiness");
                }
                traits.put("happiness", proghappy);

                if(traits.has("health")) {
                    traits.remove("health");
                }
                traits.put("health", proghealth);

                if(traits.has("intelligence")) {
                    traits.remove("intelligence");
                }
                traits.put("intelligence", progintel);

                if(traits.has("musical")) {
                    traits.remove("musical");
                }
                traits.put("musical", progmusic);

                if(traits.has("physicalEndurance")) {
                    traits.remove("physicalEndurance");
                }
                traits.put("physicalEndurance", progphy);

                if(traits.has("resistance")) {
                    traits.remove("resistance");
                }
                traits.put("resistance", progresis);

                if(traits.has("spiritual")) {
                    traits.remove("spiritual");
                }
                traits.put("spiritual", progspirit);

                if(traits.has("strength")) {
                    traits.remove("strength");
                }
                traits.put("strength", progstren);

                SharedPreferences pref = this.getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sex",gender);
                editor.commit();




            } catch (JSONException e) {
                e.printStackTrace();
            }



            objectDataInter.getObjectData(traits.toString());



        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View v=inflater.inflate(R.layout.fragment_personality,container,false);


        //trialbutton=v.findViewById(R.id.playlifebutton);
        rbmale=v.findViewById(R.id.male);
        rbfemale=v.findViewById(R.id.female);
        rburban=v.findViewById(R.id.urban);
        rbrural=v.findViewById(R.id.rural);

        health=v.findViewById(R.id.SeekBar1);
        health.setMax(100);
        health.setProgress(0);

        resis=v.findViewById(R.id.SeekBar2);
        resis.setMax(100);
        resis.setProgress(0);

        happy=v.findViewById(R.id.SeekBar3);
        happy.setMax(100);
        happy.setProgress(0);

        intel=v.findViewById(R.id.SeekBar4);
        intel.setMax(100);
        intel.setProgress(0);

        art=v.findViewById(R.id.SeekBar5);
        art.setMax(100);
        art.setProgress(0);

        music=v.findViewById(R.id.SeekBar6);
        music.setMax(100);
        music.setProgress(0);

        ath=v.findViewById(R.id.SeekBar7);
        ath.setMax(100);
        ath.setProgress(0);

        stren=v.findViewById(R.id.SeekBar8);
        stren.setMax(100);
        stren.setProgress(0);

        phy=v.findViewById(R.id.SeekBar9);
        phy.setMax(100);
        phy.setProgress(0);

        spirit=v.findViewById(R.id.SeekBar10);
        spirit.setMax(100);
        spirit.setProgress(0);

        goodlooks=v.findViewById(R.id.SeekBar11);
        goodlooks.setMax(100);
        goodlooks.setProgress(0);



        rbmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender=String.valueOf(rbmale.getText().charAt(0));
                update();
            }
        });

        rbfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender=String.valueOf(rbfemale.getText().charAt(0));
                update();
            }
        });

        rburban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locale=String.valueOf(rburban.getText().charAt(0));
                update();
            }
        });

        rbrural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locale=String.valueOf(rbrural.getText().charAt(0));
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








        return v;
    }


    public interface ObjectDataInter{
        public void getObjectData(String value);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            objectDataInter = (ObjectDataInter) context;
        }
        catch (Exception e){}

    }
}
