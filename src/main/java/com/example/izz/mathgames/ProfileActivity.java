package com.example.izz.mathgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private TextView UserEmail;
    private Button btnLogOut;
    private Button btnMathGames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.LoginActivity.class));
        }
        FirebaseUser user = mAuth.getCurrentUser();


    }

    @Override
    public void onClick(View view) {

        if(view == btnLogOut){
            mAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.LoginActivity.class));
        }



    }

}
