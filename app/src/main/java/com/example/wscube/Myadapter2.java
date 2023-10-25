package com.example.wscube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Myadapter2 extends BaseAdapter {
    String name[];
    String contact[];
    Context context;
    LayoutInflater inflater;
    public Myadapter2(String name[],String contact[],Context context)
    {
        this.name=name;
        this.contact=contact;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view=inflater.inflate(R.layout.contactmodel,viewGroup,false);
        TextView textView=view.findViewById(R.id.contactname);
        TextView textView1=view.findViewById(R.id.contactnumber);
        textView.setText(name[i]);
        textView1.setText(contact[i]);
        return view;
    }
}
