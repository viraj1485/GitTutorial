package com.example.wscube;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFragment extends Fragment {
    Button submit1;
    EditText e1,e2,e3,e4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register, container, false);
        submit1=view.findViewById(R.id.submit1);
        e1=view.findViewById(R.id.e1);
        e2=view.findViewById(R.id.e2);
        e3=view.findViewById(R.id.e3);
        e4=view.findViewById(R.id.e4);
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=e1.getText().toString();
                String str1=e2.getText().toString();
                String str2=e3.getText().toString();
                String str3=e4.getText().toString();
                if(str.matches("[0-9]+") || str1.length()>10 ||
                        str2.matches("[0-9]+") || str3.matches("[0-9]") || str.length()<0 ||
                        str1.length()<0 || str2.length()<0 || str3.length()<0){
                    Toast.makeText(getContext(), "Please Check All The Information", Toast.LENGTH_SHORT).show();
                }
               else
                {
                   getParentFragmentManager().beginTransaction().replace(R.id.frame,new Login()).commit();
                   Toast.makeText(getContext(), "You Need Login To Again  After Register", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}