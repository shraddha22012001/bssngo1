package com.example.badlavsevasamitingo.ui.addevent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.badlavsevasamitingo.LoginActivity;
import com.example.badlavsevasamitingo.R;
import com.example.badlavsevasamitingo.RegisterActivity;
import com.example.badlavsevasamitingo.SubActivity;

public class AddeventFragment extends Fragment {
    private Button joinNowButton,loginNowButton;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_addevent,container,false);
        joinNowButton= (Button) view.findViewById(R.id.register_now_btn);
        loginNowButton = (Button) view.findViewById(R.id.login_now_btn);
        loginNowButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), LoginActivity.class);
                startActivity(in);

            }
        });
        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), RegisterActivity.class);
                startActivity(in);
            }
        });
       return view;
    }

    }
