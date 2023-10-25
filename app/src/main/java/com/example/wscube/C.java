package com.example.wscube;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
public class C extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String name[]={"Viraj Benade","Sujal Bukshet","Satyajeet Patil",
                "Kishor Dholi","Sunny Banjari","Yuvraj Benade","Sandesh Lole",
                "Viraj Benade","Sujal Bukshet","Satyajeet Patil",
                "Viraj Benade","Sujal Bukshet","Satyajeet Patil",
                "Kishor Dholi","Sunny Banjari","Yuvraj Benade","Sandesh Lole",
                "Viraj Benade","Sujal Bukshet","Satyajeet Patil","Viraj Benade","Sujal Bukshet","Satyajeet Patil",
                "Kishor Dholi","Sunny Banjari","Yuvraj Benade","Sandesh Lole",
                "Viraj Benade","Sujal Bukshet","Satyajeet Patil"};
        String contactnumber[]={"9765723117","9960721485","9158785570","9960247899","9356050189",
                                "9765723117","9960721485","9158785570","9960247899","9356050189",
                "9765723117","9960721485","9158785570","9960247899","9356050189",
                "9765723117","9960721485","9158785570","9960247899","9356050189","9765723117","9960721485","9158785570","9960247899","9356050189",
                "9765723117","9960721485","9158785570","9960247899","9356050189"};
        View view=inflater.inflate(R.layout.fragment_c, container, false);
        ListView listView;
        listView=view.findViewById(R.id.contactlist);
        Myadapter2 myadapter2=new Myadapter2(name,contactnumber,getContext());
        listView.setAdapter(myadapter2);
        return view;
    }
}