package com.example.wscube;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle toggle;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        navigationView=(NavigationView)findViewById(R.id.navigation);
       // toolbar=(Toolbar) findViewById(R.id.toolbar);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        bottomNavigationView.setSelectedItemId(R.id.person1);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new A()).commit();
        navigationView.getMenu().findItem(R.id.person).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.person)
                {
                    navigationView.getMenu().findItem(R.id.person).setChecked(true);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new A()).commit();
                    bottomNavigationView.getMenu().findItem(R.id.person).setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.status) {
                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(true);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new B()).commit();
                    bottomNavigationView.getMenu().findItem(R.id.status).setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);

                } else if (item.getItemId() == R.id.call) {
                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(true);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new C()).commit();
                    bottomNavigationView.getMenu().findItem(R.id.call).setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.setting) {
                    bottomNavigationView.getMenu().findItem(R.id.setting).setChecked(true);
                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(true);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new D()).commit();
                    bottomNavigationView.getMenu().findItem(R.id.setting).setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId() ==R.id.profile)
                {
                    Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(intent);
                    bottomNavigationView.getMenu().findItem(R.id.profile).setChecked(true);

                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(true);


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.person) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new A()).commit();

                    bottomNavigationView.getMenu().findItem(R.id.person).setChecked(true);
                    navigationView.getMenu().findItem(R.id.person).setChecked(true);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);


                } else if (item.getItemId() == R.id.status) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new B()).commit();

                    bottomNavigationView.getMenu().findItem(R.id.status).setChecked(true);
                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(true);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);

                } else if (item.getItemId() == R.id.call) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new C()).commit();

                    bottomNavigationView.getMenu().findItem(R.id.call).setChecked(true);
                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(true);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);
                } else if (item.getItemId() == R.id.setting) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new D()).commit();

                    bottomNavigationView.getMenu().findItem(R.id.setting).setChecked(true);
                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(true);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);
                }
                else if (item.getItemId()==R.id.profile)
                {
                    Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(intent);
                    bottomNavigationView.getMenu().findItem(R.id.profile).setChecked(true);

                    navigationView.getMenu().findItem(R.id.person).setChecked(false);
                    navigationView.getMenu().findItem(R.id.status).setChecked(false);
                    navigationView.getMenu().findItem(R.id.call).setChecked(false);
                    navigationView.getMenu().findItem(R.id.setting).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(false);
                    navigationView.getMenu().findItem(R.id.profile).setChecked(true);
                }
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}