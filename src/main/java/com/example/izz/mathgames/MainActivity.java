package com.example.izz.mathgames;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegister;
    private EditText email;
    private EditText password;
    private TextView SignIn;

    private ProgressDialog progressDialog;

    //define firebase object
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize firebase auth object
        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), GamesActivity.class));
        }

        progressDialog = new ProgressDialog( this);

        //initialize view
        btnRegister = (Button) findViewById(R.id.btnRegister);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        SignIn = (TextView) findViewById(R.id.SignIn);

        //attach listener to button
        btnRegister.setOnClickListener(this);
        SignIn.setOnClickListener(this);

    }

    private void registerUser(){
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if(TextUtils.isEmpty(Email)) {
            //email is empty
            Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show();

            //stop the function
            return;
        }

        if (TextUtils.isEmpty(Password)){
            //password is empty
            Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show();

            //stop the function
            return;
        }

        //if everything okay
        progressDialog.setMessage("Registering the user...");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            //user successfully registered and log in
                            if (mAuth.getCurrentUser() != null){
                                finish();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Registered Unsuccessful, please try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

    @Override
    public void onClick(View view) {
        if(view == btnRegister) {
            registerUser();
        }

        if(view == SignIn) {
            //Open sign in activity
            startActivity(new Intent(this, LoginActivity.class));
        }

    }

    public static class LoginActivity extends AppCompatActivity implements View.OnClickListener {

        private Button btnSignIn;
        private EditText email;
        private EditText password;
        private TextView SignUp;

        private FirebaseAuth mAuth;

        private ProgressDialog progressDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            mAuth = FirebaseAuth.getInstance();


            if (mAuth.getCurrentUser() != null){
                //profile activity here
                finish();
                startActivity(new Intent(getApplicationContext(), GamesActivity.class));
            }

            email = (EditText) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);
            btnSignIn = (Button) findViewById(R.id.btnSignIn);
            SignUp = (TextView) findViewById(R.id.SignUp);

            progressDialog = new ProgressDialog(this);

            btnSignIn.setOnClickListener(this);
            SignUp.setOnClickListener(this);

        }

        private void userLogIn(){
            final String Email = email.getText().toString().trim();
            final String Password = password.getText().toString().trim();



                if (TextUtils.isEmpty(Email)) {
                    //email is empty
                    Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show();

                    //stop the function
                    return;
                }

                if (TextUtils.isEmpty(Password)) {
                    //password is empty
                    Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show();

                    //stop the function
                    return;
                }

                //if everything okay
                progressDialog.setMessage("Signing in the user...");
                progressDialog.show();


            mAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();


                                if (task.isSuccessful()) {
                                    // start the profile activity
                                    finish();
                                    startActivity(new Intent(getApplicationContext(), GamesActivity.class));
                                } else {
                                    Toast.makeText(LoginActivity.this, "Incorrect Email or Password, please try again!", Toast.LENGTH_LONG).show();
                                }
                            }

                    });

        }

        @Override
        public void onClick(View view) {
            if (view == btnSignIn){
                userLogIn();
            }

            if (view == SignUp) {
                startActivity(new Intent(this, MainActivity.class));
            }
        }


        }
    }

