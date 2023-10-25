package com.example.wscube;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;
public class D extends Fragment {
    Button bt1,bt2,bt3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_d, container, false);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.rotation);
        ImageView image= view.findViewById(R.id.rotate);
        bt1=view.findViewById(R.id.btn1);
        bt2=view.findViewById(R.id.btn2);
        bt3=view.findViewById(R.id.btn3);
        MediaPlayer mp=new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String path="android.resource://"+getContext().getPackageName()+"/raw/apana";
        Uri uri=Uri.parse(path);
        try {
            mp.setDataSource(getContext(),uri);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image.startAnimation(animation);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
                mp.seekTo(0);
            }
        });


        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

    }
}