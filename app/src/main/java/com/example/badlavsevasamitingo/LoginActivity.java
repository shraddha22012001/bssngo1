package com.example.badlavsevasamitingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.badlavsevasamitingo.Module.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText InputUsername, InputPassword;
    private ProgressDialog loadingBar;
    private String parentDbName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginButton = (Button) findViewById(R.id.login_btn);
        InputUsername = (EditText) findViewById(R.id.login_username_input);
        InputPassword = (EditText) findViewById(R.id.login_Password);
        loadingBar = new ProgressDialog(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });
    }

    private void LoginUser() {
        String username = InputUsername.getText().toString();
        String password = InputPassword.getText().toString();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please Enter UserName..", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Enter Your Password..", Toast.LENGTH_SHORT).show();
        } else {
            loadingBar.setTitle("Login to Account");
            loadingBar.setMessage("please wait ,While we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            allowaccesstoaccount(username, password);
        }
    }

    private void allowaccesstoaccount(String username, String password) {
        final DatabaseReference RootRef;
        RootRef=FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot snapshot) {
          if (snapshot.child(parentDbName).child(username).exists()){
                      Users userData=snapshot.child(parentDbName).child(username).getValue(Users.class);
              if(userData.getUsername().equals(username)){
                       if(userData.getPassword().equals(password))
                       {
                        Toast.makeText(LoginActivity.this, "logged in successfully", Toast.LENGTH_SHORT).show();
                           loadingBar.dismiss();

                       Intent intent = new Intent(LoginActivity.this,LoginnextActivity.class);
                         startActivity(intent);
                      }
                       else{Toast.makeText(LoginActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                           loadingBar.dismiss();

                       }
               }

          }
          else {
              Toast.makeText(LoginActivity.this, "account with this " + username + "do not exist", Toast.LENGTH_SHORT).show();
              loadingBar.dismiss();
          }
      }

      @Override
      public void onCancelled(@NonNull DatabaseError error) {

      }
  });

    }
}