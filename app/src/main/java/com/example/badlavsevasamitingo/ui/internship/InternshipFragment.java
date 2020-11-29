package com.example.badlavsevasamitingo.ui.internship;
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
import com.example.badlavsevasamitingo.busscale;
import com.example.badlavsevasamitingo.contectwriting;
import com.example.badlavsevasamitingo.fundraising;
import com.example.badlavsevasamitingo.graphicdesign;
import com.example.badlavsevasamitingo.socialmedia;
import com.example.badlavsevasamitingo.telecalling;
import com.example.badlavsevasamitingo.webdevelopment;

public class InternshipFragment extends Fragment {

    private Button content1_btn,funrising_btn,graphic1_btn,social_bttn,telecalling_btn,webdeve_btn,bdevl_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_intenship,container,false);

          content1_btn=(Button)view.findViewById(R.id.content_btn);
        funrising_btn=(Button)view.findViewById(R.id.fund_btn);
        graphic1_btn=(Button)view.findViewById(R.id.graphic_btn);
        social_bttn=(Button)view.findViewById(R.id.social_btn);
        telecalling_btn=(Button)view.findViewById(R.id.tele_btn);
        webdeve_btn=(Button)view.findViewById(R.id.web_btn);
        bdevl_btn=(Button)view.findViewById(R.id.bdsale_btn);

        content1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), contectwriting.class);
                startActivity(in);
            }
        });
        telecalling_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), telecalling.class);
                startActivity(in);
            }
        });
        webdeve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), webdevelopment.class);
                startActivity(in);
            }
        });
        bdevl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), busscale.class);
                startActivity(in);
            }
        });
        graphic1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), graphicdesign.class) ;
                startActivity(in);
            }
        });
        funrising_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), fundraising.class) ;
                startActivity(in);
            }
        });
        social_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), socialmedia.class) ;
                startActivity(in);
            }
        });
        return view;
    }
}
