package com.example.wscube;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class LoginOrRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        getSupportFragmentManager().beginTransaction().add(R.id.frame,new Login()).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        super.onDestroy();
    }
}