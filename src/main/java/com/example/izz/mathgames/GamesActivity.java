package com.example.izz.mathgames;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GamesActivity extends AppCompatActivity {

    private Question mQuestionLibrary = new Question();

    private TextView mScoreView, mTimerView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonQuit;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonQuit = (Button) findViewById(R.id.quit);
        mTimerView = (TextView) findViewById(R.id.timer);
        updateQuestion();
        reverseTime(40, mTimerView);


            //Start of Button Listener for Button1
            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice1.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        //This line of code is optiona
                        Toast.makeText(GamesActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(GamesActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });

            //End of Button Listener for Button1

            //Start of Button Listener for Button2
            mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice2.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        //This line of code is optiona
                        Toast.makeText(GamesActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(GamesActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });

            //End of Button Listener for Button2


            //Start of Button Listener for Button3
            mButtonChoice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice3.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        //This line of code is optiona
                        Toast.makeText(GamesActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(GamesActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }

                }

            });
            //End of Button Listener for Button3


        //Quit button
        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mButtonQuit) {
                    finish();
                    System.exit(0);
                }

            }
        });


    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);

    }

    private void updateQuestion() {
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
        }

        public void reverseTime ( int seconds, final TextView mTimerView){
            new CountDownTimer(seconds * 1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    int seconds = (int) (millisUntilFinished / 1000);
                    int minutes = seconds / 60;
                    seconds = seconds % 60;
                    mTimerView.setText(String.format("%2d", minutes) + ":" + String.format("%2d", seconds));
                }


                public void onFinish() {
                    mTimerView.setText("Completed!");
                        mScoreView.setText("" + mScore);
                        Intent intent = new Intent(GamesActivity.this, ResultActivity.class);
                        intent.putExtra("mScore", String.valueOf(mScore));
                        startActivity(intent);


                }
            }.start();


        }


    }

