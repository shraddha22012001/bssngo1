package com.example.badlavsevasamitingo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.badlavsevasamitingo.R;
import com.example.badlavsevasamitingo.SubActivity;

public class HomeFragment extends Fragment{
        private Button nextpageButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.fragment_home,container,false);

           nextpageButton= (Button) view.findViewById(R.id.next_page_home);

        nextpageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), SubActivity.class);
                startActivity(in);

            }
        });
        return view;


    }


}