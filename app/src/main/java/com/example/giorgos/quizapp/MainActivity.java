package com.example.giorgos.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sbm= (Button) findViewById(R.id.submit);
        sbm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sumbitAnswers(view);
            }
        });

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                resetScore();
            }
        });
    }

    public void sumbitAnswers(View view){

        EditText q1an = (EditText) this.findViewById(R.id.a1);
        if(q1an.getText().toString().toLowerCase().replaceAll("\\s","").equals("russia")) score++ ;

        RadioButton q2an = (RadioButton) this.findViewById(R.id.qa2);
        if(q2an.isChecked()) score++ ;

        RadioButton q3an = (RadioButton) this.findViewById(R.id.qa3);
        if(q3an.isChecked()) score++ ;

        //here we want both the right questions checked and the wroong unchecked to increase score
        CheckBox q4an1 = (CheckBox) this.findViewById(R.id.qa41);
        CheckBox q4an2 = (CheckBox) this.findViewById(R.id.qa42);
        CheckBox wa4 = (CheckBox) this.findViewById(R.id.w4);
        boolean a4 = q4an1.isChecked()&&q4an2.isChecked()&&!wa4.isChecked();
        if(a4) score++;

        RadioButton q5an = (RadioButton) this.findViewById(R.id.qa5);
        if(q5an.isChecked()) score++ ;

        RadioButton q6an = (RadioButton) this.findViewById(R.id.qa6);
        if(q6an.isChecked()) score++ ;

        displayScore(score);
        score = 0;
    }

    public void displayScore(int score){

        if(score>6){
            Toast.makeText(MainActivity.this, "Something went wrong!The creater is a poor programmer!!",
                    Toast.LENGTH_LONG).show();
            resetScore();
        }else{//you get different toast according to your result
            EditText result= (EditText) this.findViewById(R.id.result);
            if(score>=3){
                Toast.makeText(MainActivity.this, "\"What a time to be alive,you scored \""  +score+ "\" out of 6\"",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "\"Have you heared about geography before? \n \"Score " +score+ "\" out of 6\"",
                        Toast.LENGTH_LONG).show();

            }
        }
    }

    public void resetScore(){
        //it scrolls up to the top of thw app
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.scrollview);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        //here we declare everything (radiogroups,checkboxes,editext)
        EditText q1 = (EditText) this.findViewById(R.id.a1);

        CheckBox q41=(CheckBox) this.findViewById(R.id.qa41);
        CheckBox q42=(CheckBox) this.findViewById(R.id.qa42);
        CheckBox w4=(CheckBox) this.findViewById(R.id.w4);

        RadioGroup rg1=(RadioGroup) this.findViewById(R.id.rg1);
        RadioGroup rg2=(RadioGroup) this.findViewById(R.id.rg2);
        RadioGroup rg3=(RadioGroup) this.findViewById(R.id.rg3);
        RadioGroup rg4=(RadioGroup) this.findViewById(R.id.rg4);

        //we clear checks or set them false and set text to space
        rg1.clearCheck();
        rg2.clearCheck();
        rg3.clearCheck();
        rg4.clearCheck();
        q1.setText("");
        q41.setChecked(false);
        q42.setChecked(false);
        w4.setChecked(false);


    }



}
