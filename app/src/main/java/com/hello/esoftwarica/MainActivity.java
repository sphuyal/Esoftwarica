package com.hello.esoftwarica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hello.esoftwarica.Fragments.Aboutfragment;
import com.hello.esoftwarica.Fragments.Addfragment;
import com.hello.esoftwarica.Fragments.Homefragment;
import com.hello.esoftwarica.Recycleview.Softwarica;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Softwarica> softwaricans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new Homefragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selFragment = null;

                    switch (menuItem.getItemId()){
                        case  R.id.nav_home:
                            selFragment = new Homefragment();
                            break;
                    }
                    switch (menuItem.getItemId()){
                        case R.id.nav_add:
                            selFragment = new Addfragment();
                            break;
                    }
                    switch (menuItem.getItemId()){
                        case  R.id.nav_about:
                            selFragment = new Aboutfragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                            selFragment).commit();
                    return true;
                }
            };
}
