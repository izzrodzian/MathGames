package com.example.izz.mathgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{


    private FirebaseAuth mAuth;

    private Button buttonLogout;
    private TextView mScoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,ResultActivity.class));
        }

        FirebaseUser user = mAuth.getCurrentUser();

        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.LoginActivity.class));
        }


        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        mScoreTV = (TextView) findViewById(R.id.mScoreTV);

        Intent i = getIntent();

        String mScore = i.getStringExtra("mScore");

        mScoreTV.setText(mScore);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == buttonLogout) {
                    mAuth.signOut();
                    finish();
                    Intent intent = new Intent(ResultActivity.this,MainActivity.LoginActivity.class);
                    startActivity(intent);

                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ResultActivity.this,MainActivity.LoginActivity.class);
        startActivity(intent);
    }
}
