package com.example.vii_mook.firebaselogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Profile extends AppCompatActivity {

    public ProgressBar progressBar;
    public FirebaseAuth.AuthStateListener authStateListener;
    public  FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        auth = FirebaseAuth.getInstance();

        final Button logout_action = (Button) findViewById(R.id.btn_logout);
        logout_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this,"Logged out!",Toast.LENGTH_SHORT).show();
                signout();
            }
        });
    }

    private void signout() {
        auth.signOut();
        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
