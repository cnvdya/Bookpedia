package com.cnvdya.android.bookpedia.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cnvdya on 17-Apr-18.
 */

class FirebaseActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if(mFirebaseUser == null){
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        }
    }


    protected View.OnClickListener getLogoutListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        };
    }

    private void logout() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        if (mFirebaseAuth == null) {
            return;
        }
        mFirebaseAuth.signOut();
        Toast.makeText(this, "Logged out of Bookpedia", Toast.LENGTH_LONG).show();
    }
}
