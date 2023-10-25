package com.example.wscube;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Myadapter extends BaseAdapter {
    String name[];
    Context context;
    LayoutInflater inflater;
    public Myadapter(String name[],Context context)
    {
        this.name=name;
        this.context=context;
        this.inflater=LayoutInflater.from(context);
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
        view=inflater.inflate(R.layout.blayout,viewGroup,false);
        TextView textView=view.findViewById(R.id.name);
        textView.setText(name[i]);
        return  view;
    }
}
