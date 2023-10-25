package com.example.wscube;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class FlashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);
    }
    protected void onResume()
    {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                boolean b=sharedPreferences.getBoolean("flag",false);
                Intent intent;
                if (b)
                {
                     intent=new Intent(FlashScreen.this,MainActivity.class);
                }
                else
                {
                    intent=new Intent(FlashScreen.this,LoginOrRegister.class);
                }
                startActivity(intent);
            }},3000);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        super.onDestroy();
    }
}