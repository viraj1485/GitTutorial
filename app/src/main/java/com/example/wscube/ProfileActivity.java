package com.example.wscube;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.github.dhaval2404.imagepicker.ImagePicker;
public class ProfileActivity extends AppCompatActivity{
    ImageView imageView;
    public static final String ChannelId="VirajBenade";
    NotificationManager nm;
    Notification notification;
    public static final  int NOTIFICATION=100;
    ImageButton imageButton;
    public static final int REQUEST_CODE=1000;
    EditText e1,e2,e3,e4;
    Button button;

    String emailregex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    String nameregex="^[a-zA-Z\\s'-]+$";

    ImageButton imageButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.wscube,null);
        BitmapDrawable bitmapDrawable=(BitmapDrawable)drawable;
        Bitmap bitmap=bitmapDrawable.getBitmap();


        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification=new Notification.Builder(this)
                    .setLargeIcon(bitmap)
                    .setSmallIcon(R.drawable.wscube)
                    .setChannelId(ChannelId)
                    .setContentText("Welcome To WSCUBE-TECH We Hiring Fresher Android Developer")
                    .setSubText("I am very glad to tell us that WSCUBE-TECH hiring newely freshers android developer" +
                            "Interested Candidate Please Share Your Resume at WhatsApp-8625881485")
                    .build();
            nm.createNotificationChannel(new NotificationChannel(ChannelId,"mychannel",NotificationManager.IMPORTANCE_HIGH));
            nm.notify(NOTIFICATION,notification);
        }
        else {
            notification=new Notification.Builder(this)
                    .setLargeIcon(bitmap)
                    .setSmallIcon(R.drawable.wscube)
                    .setContentText("Welcome To WSCUBE-TECH We Hiring Fresher Android Developer")
                    .setSubText("I am very glad to tell us that WSCUBE-TECH hiring newely freshers android developer" +
                            "Interested Candidate Please Share Your Resume at WhatsApp-8625881485")
                    .build();
            nm.notify(NOTIFICATION,notification);
        }

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        e3=(EditText) findViewById(R.id.e3);
        e4=(EditText) findViewById(R.id.e4);
        button=(Button)findViewById(R.id.submit) ;

        imageView=findViewById(R.id.externalimage);
        imageButton1 =findViewById(R.id.select);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(ProfileActivity.this)
                        .galleryOnly()
                        .cropSquare()
                        .start();
            }
        });
        e1.addTextChangedListener(textWatcher);
        e2.addTextChangedListener(textWatcher);
        e3.addTextChangedListener(textWatcher);
        e4.addTextChangedListener(textWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(check())
                    {
                        LayoutInflater layoutInflater=getLayoutInflater();
                        View view1=layoutInflater.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.customtoast1));
                        Toast toast=new Toast(ProfileActivity.this);
                        toast.setView(view1);
                        toast.show();
                    }
                    else
                    {
                        Toast.makeText(ProfileActivity.this, "Please Check The All Information", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
           Uri uri=data.getData();
           imageView.setImageURI(uri);
            Toast.makeText(this, "Image Uploaded SuccessFully", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean check()
    {
        String s1=e1.getText().toString();
        String s2=e2.getText().toString();
        String s3=e3.getText().toString();
        String s4=e4.getText().toString();
            if (!s1.matches(nameregex))
            {
                showerror(e1,"In-Correct user-name");
                return false;
            }
            else if (s2.isEmpty() || s2.length()<10 || s2.length()>10)
            {
                showerror(e2,"In-Correct Phone Number");
                return false;
            }
            else if (s4.isEmpty() || s4.length()<8)
            {
                showerror(e4,"Password Must be 8 Digit");
                return false;
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(s3).matches())
            {
                showerror(e3,"In-Correct Email");
                return false;
            }
        return true;
    }
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String s1=e1.getText().toString().trim();
            String s2=e2.getText().toString().trim();
            String s3=e3.getText().toString().trim();
            String s4=e4.getText().toString().trim();
            button.setEnabled(!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty() && !s4.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void showerror(EditText e1, String s)
    {
        e1.setError(s);
        e1.requestFocus();
    }
}
