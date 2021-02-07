package com.example.mobileprogrammingapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprogrammingapp.Fragment.Courses;
import com.example.mobileprogrammingapp.Fragment.Profile;
import com.example.mobileprogrammingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btmNavView;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialSetup();

        username = getIntent().getStringExtra("username");

        new getMessage().execute();

    }

    private void initialSetup() {
        btmNavView = findViewById(R.id.bottomnavigation);
        btmNavView.setOnNavigationItemSelectedListener(btmNavListener);

        btmNavView.setSelectedItemId(R.id.btmMenuCourses);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener btmNavListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.btmMenuCourses:
                    Courses courses = new Courses();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    transaction.replace(R.id.contentView, courses);
                    transaction.commit();
                    return true;
                case R.id.btmMenuQuiz:

                    return true;
                case R.id.btmMenuProfile:
                    Profile profile = new Profile();
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    transaction1.replace(R.id.contentView, profile);
                    transaction1.commit();
                    return true;
            }

            return false;
        }
    };


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public class getMessage extends AsyncTask<Void,Void,Void> {

        String message = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("http://undispensed-rose.000webhostapp.com/x.php");
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                message=getData(reader);

                Log.d("MESSAGE", message);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getData(InputStreamReader reader) throws IOException{
            String result="";
            int data=reader.read();
            while (data!=-1){
                char now=(char) data;
                result+=now;
                data=reader.read();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Hi, " + username + "!");
            builder.setMessage(message);
            builder.setPositiveButton("OK", null);
            builder.create().show();
        }
    }

}