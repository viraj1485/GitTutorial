package com.example.wscube;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Fragment {

    Button button;
    TextView textView;
    EditText editText1,editText2;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        button=view.findViewById(R.id.submit);
        textView=view.findViewById(R.id.register);
        editText1=view.findViewById(R.id.user);
        editText2=view.findViewById(R.id.pass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=editText1.getText().toString();
                String str1=editText2.getText().toString();
                if(str.isEmpty() || str1.isEmpty() || str.matches("[0-9]+" )|| str1.matches("[0-9]+"))
                {
                    Toast.makeText(getContext(), "Please Check The Information", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences sharedPreferences=getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("flag",true);
                    editor.apply();

                    Intent intent=new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.frame,new RegisterFragment()).commit();
            }
        });
        return view;
    }
}