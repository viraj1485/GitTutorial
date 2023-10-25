package com.example.wscube;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

public class B extends Fragment {
    TabLayout tabLayout;
    statusadapter statusadapter1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_b, container, false);
        tabLayout=view.findViewById(R.id.tablayout);
        ViewPager viewPager=view.findViewById(R.id.viewpager);

//        tabLayout.addTab(tabLayout.newTab().setText("Chat"));
//        tabLayout.addTab(tabLayout.newTab().setText("Status"));
//        tabLayout.addTab(tabLayout.newTab().setText("Call"));

        viewPager.setAdapter(new statusadapter(getParentFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


        return view;
    }
}