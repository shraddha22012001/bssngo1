package com.example.badlavsevasamitingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.badlavsevasamitingo.ui.addevent.AddeventFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
   private Button CreateAccountButton;
   private EditText InputUsername,InputEmailaddress,InputPassword,InputNgocode;

    private ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CreateAccountButton=(Button) findViewById(R.id.register_btn);
        InputUsername =(EditText) findViewById(R.id.register_Username_input);
        InputEmailaddress =(EditText) findViewById(R.id.register_email_address_input);
        InputPassword =(EditText) findViewById(R.id.register_password_input);
        InputNgocode =(EditText) findViewById(R.id.register_ngo_input);
        loadingBar =new ProgressDialog(this);

     CreateAccountButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             CreateAccount();
         }
     });
    }


    private void CreateAccount()
    {
        String username=InputUsername.getText().toString();
        String emailaddress=InputEmailaddress.getText().toString();
        String password=InputPassword.getText().toString();
        String ngocode=InputNgocode.getText().toString();

        if(TextUtils.isEmpty(username))
            {
                Toast.makeText(this,"Please Enter UserName..",Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(emailaddress))
            {
                Toast.makeText(this,"Please Enter Your Email address..",Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(password))
            {
                Toast.makeText(this,"Please Enter Your Password..",Toast.LENGTH_SHORT).show();
            }
        else if(TextUtils.isEmpty(ngocode))
        {
            Toast.makeText(this,"Please Enter Your Six digit Ngo code..",Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("please wait ,While we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

  Validateemailaddress(username,emailaddress,password,ngocode);

        }
    }

    private void Validateemailaddress(String username, String emailaddress, String password, String ngocode) {

         final DatabaseReference RootRef;
         RootRef= FirebaseDatabase.getInstance().getReference();
          RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (((!(snapshot.child("Users").child(emailaddress).exists()))&&(!(snapshot.child("Users").child(password).exists())))) {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("username", username);
                    userdataMap.put("emailaddress", emailaddress);
                    userdataMap.put("password", password);
                    userdataMap.put("ngocode", ngocode);
                    RootRef.child("Users").child(username).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Congratulations ,Your accout is created Successfuly", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();

                                        Intent intent = new Intent(RegisterActivity.this, AddeventFragment.class);
                                        startActivity(intent);
                                    } else {
                                        loadingBar.dismiss();
                                        Toast.makeText(RegisterActivity.this, "Network Error: Try again", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }

                else if((snapshot.child("Users").child(emailaddress).exists())&&(snapshot.child("Users").child(password).exists())) {
                    Toast.makeText(RegisterActivity.this,"this "+ emailaddress + "and"+ password +"already exist",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this,"please try again using another Email id  and password ",Toast.LENGTH_SHORT).show();

                }

                else if(snapshot.child("Users").child(emailaddress).exists())
                {
                    Toast.makeText(RegisterActivity.this,"this "+ emailaddress + "already exist",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this,"please try again using another Email id ",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"this "+ password+ "already exist",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this,"please try again using another Password ",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}