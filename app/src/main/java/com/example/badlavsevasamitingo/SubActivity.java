package com.example.badlavsevasamitingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.badlavsevasamitingo.ui.home.HomeFragment;

public class SubActivity extends AppCompatActivity {

    private  Button join_ngo_button,donate_now_button;
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
       join_ngo_button=(Button)findViewById(R.id.join_ngo_btn);
       donate_now_button=(Button)findViewById(R.id.Donate_ngo_btn);

       join_ngo_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gotoUrl("https://docs.google.com/forms/d/e/1FAIpQLSedge5e-pD8DOc7fsTj2wW0aVNUyVn7GWKHaB8AXxFMvhIr-g/viewform");
           }
       });
        donate_now_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://badlavsevasamiti.org/donation/index.php");
            }
        });

    }

    private void gotoUrl(String s){
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}
