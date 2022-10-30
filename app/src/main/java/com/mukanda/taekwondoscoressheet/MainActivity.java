package com.mukanda.taekwondoscoressheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int counter;
     String period;
    Button button1, button2,player1,player2 ,timer,sround;
    int ScoreTeamA=0, ScoreTeamB=0,Round=1,Timer=0;
    int Foul=0;
    int Foul1=0;
    Button btn1;

    TextView text1, text12 ,round;
    EditText stimer;
    Button button;
    Intent intent=null, chooser=null;
    LinearLayout main, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Resources.Theme.App


         setTitle("               Scores Board");
        button1=findViewById(R.id.teama);
       // btn_new=(Button) findViewById(R.id.new_game);
        button2=findViewById(R.id.teamb);
        btn1=findViewById(R.id.TEAMA1);
        text1=findViewById(R.id.play1);
        round=findViewById(R.id.round);
        timer=findViewById(R.id.timer);
        stimer=findViewById(R.id.timer_show);
        sround=findViewById(R.id.round_show);

        text12=findViewById(R.id.play12);
        player1=findViewById(R.id.player1);

        player2=findViewById(R.id.player2);
        button=findViewById(R.id.end_game);
        period=stimer.getText().toString().trim();

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer( 1000,1000)
                {
                    @Override
                    public void onTick(long l) {
                        stimer.setText(String.valueOf(period));
                        counter--;
                    }

                    @Override
                    public void onFinish() {
                        stimer.setText("END");
                        addround();
                    }
                }.start();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endgame();

//                try {
//                    intent=new Intent(Intent.ACTION_VIEW);
//                    String phoneNo="746364856";
//                    String message="This is my test message";
//                    intent.setData(Uri.parse("http://api.whatsapp.com/send? phone=+254" + phoneNo + "&text=" + message));
//                    startActivity(intent);
//
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(), "Error launching whatssap" + e, Toast.LENGTH_SHORT).show();
//                }
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Foul<9)
                {
                    addOne("teamB", "one");
                }
                else if (Foul==9)
                {
                    startActivity(new Intent(MainActivity.this,RESULT1.class));
                }
                else
                {

                }
                addOneFoul();


            }
        });

        text12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Foul1<9)
                {
                    addOne("teamA", "one");
                }
                else if(Foul1==9)
                {
               startActivity(new Intent(MainActivity.this,RESULTS.class));
                }
                else
                {

                }
                addOneFoul1();


            }
        });

    }

    public void teama1(View v) {
        addOne("teamA", "one");
        Toast.makeText(MainActivity.this,"punch",Toast.LENGTH_LONG).show();

    }

    public void teama2(View v) {
        addtwo("teamA", "two");
        //Toast.makeText(MainActivity.this,"Team A2 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teama3(View v) {
        addthree("teamA", "three");
        //Toast.makeText(MainActivity.this,"Team A3 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teama4(View v) {
        addfour("teamA", "four");
        //Toast.makeText(MainActivity.this,"Team A3 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teama5(View v) {
        addfive("teamA", "five");
        //Toast.makeText(MainActivity.this,"Team A3 clicked",Toast.LENGTH_SHORT).show();

    }

    public void teamb1(View v) {
        addOne("teamB", "one");
        Toast.makeText(MainActivity.this,"punch",Toast.LENGTH_LONG).show();
    }

    public void teamb2(View v) {
        addtwo("teamB", "two");


    }

    public void teamb3(View v) {
        addthree("teamB", "three");
        //Toast.makeText(MainActivity.this,"Team B3 clicked",Toast.LENGTH_SHORT).show();

    }
    public void teamb4(View v) {
        addfour("teamB", "four");
        //Toast.makeText(MainActivity.this,"Team B3 clicked",Toast.LENGTH_SHORT).show();

    }
    public void teamb5(View v) {
        addfive("teamB", "five");
        //Toast.makeText(MainActivity.this,"Team B3 clicked",Toast.LENGTH_SHORT).show();

    }
    public void addround() {
        Round=Round + 1;

            sround.setText(Round + "");
        }

    public void addOne(String team1, String score1) {
        String team=team1;
        String score=score1;
        ScoreTeamA=ScoreTeamA + 1;
        if (team == "teamA" && score == "one") {

            button1.setText(ScoreTeamA + "");

        } else if (team == "teamB" && score == "one") {
            ScoreTeamB=ScoreTeamB + 1;
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addtwo(String team2, String score2) {
        String team=team2;
        String score=score2;
        ScoreTeamA=ScoreTeamA + 2;
        if (team == "teamA" && score == "two") {
            Toast.makeText(MainActivity.this,"Trunk",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "two") {
            ScoreTeamB=ScoreTeamB + 2;
            Toast.makeText(MainActivity.this,"Trunk",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addthree(String team3, String score3) {
        String team=team3;
        String score=score3;
        ScoreTeamA=ScoreTeamA + 3;
        if (team == "teamA" && score == "three") {
            Toast.makeText(MainActivity.this,"Headshot!",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "three") {
            ScoreTeamB=ScoreTeamB + 3;
            Toast.makeText(MainActivity.this,"Headshot!",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addfour(String team4, String score4) {
        String team=team4;
        String score=score4;
        ScoreTeamA=ScoreTeamA + 4;
        if (team == "teamA" && score == "four") {
            Toast.makeText(MainActivity.this,"Headshot!",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "four") {
            ScoreTeamB=ScoreTeamB + 4;
            Toast.makeText(MainActivity.this,"Headshot!",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public void addfive(String team5, String score5) {
        String team=team5;
        String score=score5;
        ScoreTeamA=ScoreTeamA + 5;
        if (team == "teamA" && score == "five") {
            Toast.makeText(MainActivity.this,"Headshot!",Toast.LENGTH_LONG).show();


            button1.setText(ScoreTeamA + "");
        } else if (team == "teamB" && score == "five") {
            ScoreTeamB=ScoreTeamB + 5;
            Toast.makeText(MainActivity.this,"Headshot!",Toast.LENGTH_LONG).show();
            button2.setText(ScoreTeamB + "");
        } else {

        }

    }

    public  void endgame()
    {


            if (ScoreTeamB == ScoreTeamA) {
                Toast.makeText(MainActivity.this,"No winner",Toast.LENGTH_LONG).show();

            } else if (ScoreTeamA > ScoreTeamB) {
                startActivity(new Intent(MainActivity.this, RESULTS.class));
            } else {
                startActivity(new Intent(MainActivity.this, RESULT1.class));
                // Toast.makeText(MainActivity.this,"No winner",Toast.LENGTH_LONG).show();
            }
    }

    public void addOneFoul() {

        Foul=Foul + 1;


        if (Foul < 11)
        {

            player1.setText(Foul + "");
        }

        else
        {

        }


    }

    public void addOneFoul1() {

        Foul1=Foul1 + 1;


        if (Foul1 < 11)
        {

            player2.setText(Foul1 + "");
        }

        else
        {

        }


    }

}
