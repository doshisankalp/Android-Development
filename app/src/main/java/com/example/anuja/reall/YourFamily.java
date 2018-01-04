package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import android.widget.*;

import static java.lang.Character.isDigit;

public class YourFamily extends AppCompatActivity {
    ImageButton btn_back;
    Intent i;
    int siblings;
    static String st;
    JSONObject responce_object;
    TextView net_worh, income,avg_world_income1,avg_world_income2,avg_world_income3;
    ProgressBar averageWorldIncomeBar,yourIncomeBar,averageNationalIncomeBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_family);

        net_worh = (TextView) findViewById(R.id.netWorthYourFamily);
        income = (TextView) findViewById(R.id.incomeYourFamily);
        averageWorldIncomeBar=(ProgressBar)findViewById(R.id.averageWorldIncomeBar);
        yourIncomeBar=(ProgressBar)findViewById(R.id.yourIncomeBar);
        averageNationalIncomeBar=(ProgressBar)findViewById(R.id.averageNationalIncomeBar);
        avg_world_income1=(TextView)findViewById(R.id.avg_world_income1);
        avg_world_income2=(TextView)findViewById(R.id.avg_world_income2);
        avg_world_income3=(TextView)findViewById(R.id.avg_world_income3);

        yourIncomeBar.setMax(10000);
        averageNationalIncomeBar.setMax(10000);

        i = getIntent();
        String responce_string = i.getStringExtra("responce_object");
        try {
            responce_object = new JSONObject(responce_string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        siblings=responce_object.length()-3;
        Log.e("Siblings", String.valueOf(siblings));

        create_sibling();

        try {
            JSONObject self = responce_object.getJSONObject("SELF");
            JSONObject expenses = self.getJSONObject("expense");
            net_worh.setText(expenses.getString("householdNetWorth"));
            income.setText(expenses.getString("householdIncome"));
            averageWorldIncomeBar.setProgress(10000);
            avg_world_income1.setText(String.format("Average World Income:%d", 10000));
            JSONObject country=self.getJSONObject("country");
            Double exchange_rate=country.getDouble("exchangeRate");
            int hoseholdincome= (int) expenses.getDouble("householdIncome");
            int yourIncomebar= (int) ((hoseholdincome*12)/exchange_rate);
            yourIncomeBar.setProgress(yourIncomebar);
            avg_world_income2.setText(String.format("Average World Income:%d",yourIncomebar));
            int prodPerCapita= (int) country.getDouble("prodPerCapita");
            avg_world_income3.setText(String.format("Average World Income:%d",prodPerCapita));
            averageNationalIncomeBar.setProgress(prodPerCapita);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        ImageButton btn_back = (ImageButton) findViewById(R.id.Backbutton);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourFamily.this, LiveALife.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void create_sibling() {
        LinearLayout[] frame = new LinearLayout[20];
        LinearLayout[] parent = new LinearLayout[20];
        LinearLayout[] layout2 = new LinearLayout[20];
        LinearLayout[] layout3 = new LinearLayout[20];

        for (int i = 0;i < 3; i++) {
            frame[i] = new LinearLayout(this);
            frame[i].setPadding(10, 10, 10, 10);
            frame[i].setOrientation(LinearLayout.VERTICAL);
            parent[i] = new LinearLayout(this);
            // parent[i].setLayoutParams(new ViewGroup.LayoutParams(300, 300));
            parent[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            parent[i].setOrientation(LinearLayout.VERTICAL);
            parent[i].setBackgroundResource(R.drawable.layout_bg);
            parent[i].setPadding(20, 20, 20, 20);

            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.man_small);
            iv.setPadding(0, 10, 0, 0);
            TextView tv = new TextView(this);
            tv.setPadding(20, 10, 10, 10);
            tv.setTextSize(20);

            layout2[i] = new LinearLayout(this);

            layout2[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout2[i].setOrientation(LinearLayout.HORIZONTAL);
            layout2[i].addView(iv);
            layout2[i].addView(tv);
            parent[i].addView(layout2[i]);

            layout3[i] = new LinearLayout(this);
            layout3[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout3[i].setOrientation(LinearLayout.VERTICAL);
            layout3[i].setPadding(20, 10, 20, 10);

            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            TextView tv4 = new TextView(this);

            tv1.setPadding(20, 0, 10, 0);
            tv1.setTextSize(15);
            tv2.setPadding(20, 0, 10, 0);
            tv2.setTextSize(15);
            //tv3.setText("Problems : Wasting, Grunting");
            tv3.setPadding(20, 0, 10, 0);
            tv3.setTextSize(15);
            tv4.setPadding(20, 0, 10, 0);
            tv4.setTextSize(15);

            String[] name={"SELF","SELF_FATHER","SELF_MOTHER"};
            String name1=name[i];
            try {
                JSONObject sibling=responce_object.getJSONObject(name1);
                if(i==0)
                {
                    tv.setText("You:\n" + sibling.getString("firstName") + ", " + sibling.getString("age"));
                }
                else if(i==1)
                {
                    tv.setText("Father:\n" + sibling.getString("firstName") + ", " + sibling.getString("age"));
                }
                else if(i==2)
                {
                    tv.setText("Mother:\n" + sibling.getString("firstName") + ", " + sibling.getString("age"));
                }

                tv4.setText("Income: "+sibling.getString("income"));
                JSONObject job=sibling.getJSONObject("job");
                tv1.setText("Job: "+job.getString("jobDisplayName"));
                JSONObject traits=sibling.getJSONObject("traits");
                tv2.setText("Health: "+traits.getString("health")+" Health");
                tv3.setText("Problems: ");

                JSONObject healthproblem=sibling.getJSONObject("healthDisease");
                Log.e("hi", String.valueOf(healthproblem));
                st=healthproblem.toString();
                Log.e("S",st);
                String temp1="";
                int j1=0;
                String problem="";
                for(int k=0;k<st.length();k++)
                {
                    if(st.charAt(k)=='"')
                    {
                        temp1="";
                        j1=k+1;

                        if(Character.isDigit(st.charAt(j1)))
                        {
                            while(st.charAt(j1)!='"')
                            {
                                temp1+=st.charAt(j1);
                                j1++;
                            }
                            //System.out.println(temp);
                            Log.e("Temp",temp1);
                            JSONObject prob=healthproblem.getJSONObject(temp1);
                            problem+=prob.getString("diseaseName")+",\n";
                        }
                        k=j1+1;

                    }
                }

                tv3.setText("Problem:"+problem.substring(0,problem.length()));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            layout3[i].addView(tv1);
            layout3[i].addView(tv2);
            layout3[i].addView(tv3);
            layout3[i].addView(tv4);
            parent[i].addView(layout3[i]);
            frame[i].addView(parent[i]);
            ((LinearLayout) findViewById(R.id.linear)).addView(frame[i]);
        }



        for (int i = 1; i <= siblings; i++) {
            frame[i] = new LinearLayout(this);
            frame[i].setPadding(10, 10, 10, 10);
            frame[i].setOrientation(LinearLayout.VERTICAL);
            parent[i] = new LinearLayout(this);
            // parent[i].setLayoutParams(new ViewGroup.LayoutParams(300, 300));
            parent[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            parent[i].setOrientation(LinearLayout.VERTICAL);
            parent[i].setBackgroundResource(R.drawable.layout_bg);
            parent[i].setPadding(20, 20, 20, 20);

            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.man_small);
            iv.setPadding(0, 10, 0, 0);
            TextView tv = new TextView(this);
            tv.setPadding(20, 10, 10, 10);
            tv.setTextSize(20);

            layout2[i] = new LinearLayout(this);

            layout2[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout2[i].setOrientation(LinearLayout.HORIZONTAL);
            layout2[i].addView(iv);
            layout2[i].addView(tv);
            parent[i].addView(layout2[i]);

            layout3[i] = new LinearLayout(this);
            layout3[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout3[i].setOrientation(LinearLayout.VERTICAL);
            layout3[i].setPadding(20, 10, 20, 10);

            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            TextView tv4 = new TextView(this);

            tv1.setPadding(20, 0, 10, 0);
            tv1.setTextSize(15);
            tv2.setPadding(20, 0, 10, 0);
            tv2.setTextSize(15);
            //tv3.setText("Problems : Wasting, Grunting");
            tv3.setPadding(20, 0, 10, 0);
            tv3.setTextSize(15);
            tv4.setPadding(20, 0, 10, 0);
            tv4.setTextSize(15);

            String count=String.valueOf(i);
            String name="SELF_SIBLING_"+count;
            try {
                JSONObject sibling=responce_object.getJSONObject(name);
                if(sibling.getString("sex").equals("M")) {
                    tv.setText("Brother:\n" + sibling.getString("firstName") + ", " + sibling.getString("age"));
                }
                else {
                    tv.setText("Sister:\n" + sibling.getString("firstName") + ", " + sibling.getString("age"));
                }
                tv4.setText("Income: "+sibling.getString("income"));
                JSONObject job=sibling.getJSONObject("job");
                tv1.setText("Job: "+job.getString("jobDisplayName"));
                JSONObject traits=sibling.getJSONObject("traits");
                tv2.setText("Health: "+traits.getString("health")+" Health");
                tv3.setText("Problems:");

                JSONObject healthproblem=sibling.getJSONObject("healthDisease");
                Log.e("hi", String.valueOf(healthproblem));
                st=healthproblem.toString();
                Log.e("S",st);
                String temp1="";
                int j1=0;
                String problem="";
                for(int k=0;k<st.length();k++)
                {
                    if(st.charAt(k)=='"')
                    {
                        temp1="";
                        j1=k+1;

                        if(Character.isDigit(st.charAt(j1)))
                        {
                            while(st.charAt(j1)!='"')
                            {
                                temp1+=st.charAt(j1);
                                j1++;
                            }
                            //System.out.println(temp);
                            Log.e("Temp",temp1);
                            JSONObject prob=healthproblem.getJSONObject(temp1);
                            problem+=prob.getString("diseaseName")+",\n";
                        }
                        k=j1+1;

                    }
                }


                tv3.setText("Problem:"+problem.substring(0,problem.length()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            layout3[i].addView(tv1);
            layout3[i].addView(tv2);
            layout3[i].addView(tv3);
            layout3[i].addView(tv4);
            parent[i].addView(layout3[i]);
            frame[i].addView(parent[i]);
            ((LinearLayout) findViewById(R.id.linear)).addView(frame[i]);
        }

    }

}