package com.example.wscube;
import static android.content.Context.MODE_PRIVATE;
import static com.example.wscube.R.*;
import static com.example.wscube.R.drawable.round;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;


public class A extends Fragment {
    ImageSlider imageSlider;
    Button button;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(layout.fragment_a, container, false);
        button=view.findViewById(id.Logout);
        imageSlider=view.findViewById(id.image_slider);
        ArrayList<SlideModel> arrayList=new ArrayList<>();
        arrayList.add(new SlideModel(drawable.vk1,ScaleTypes.FIT));
        arrayList.add(new SlideModel(drawable.vk2,ScaleTypes.FIT));
        arrayList.add(new SlideModel(drawable.vk3,ScaleTypes.FIT));
        arrayList.add(new SlideModel(drawable.vk4,ScaleTypes.FIT));
        arrayList.add(new SlideModel(drawable.vk5,ScaleTypes.FIT));
        arrayList.add(new SlideModel(drawable.vk6,ScaleTypes.FIT));
        imageSlider.setBackgroundDrawable(getResources().getDrawable(round));
        imageSlider.setImageList(arrayList);
        context=getContext();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= context.getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("flag",false);
                editor.apply();
                Toast.makeText(getActivity(), "User Logout SuccessFully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}