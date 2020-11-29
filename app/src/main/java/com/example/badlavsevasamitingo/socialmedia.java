package com.example.badlavsevasamitingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class socialmedia extends AppCompatActivity {
    private Button appy_now_btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialmedia);
        appy_now_btn = (Button)findViewById(R.id.apply_social);
        appy_now_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://docs.google.com/forms/d/e/1FAIpQLScPi9CzWOYz7Sb1DEhn3do587xX_Rxfol_wbvMpgLg1H09nIQ/viewform");
            }
        });
    }
    private void gotoUrl(String s){
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}