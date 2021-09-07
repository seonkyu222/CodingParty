package com.example.instabutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text_ok;
    EditText edit_name, edit_username, edit_website, edit_introduce;
    String s_name = "name";
    String s_username = "username";
    String s_website = "website";
    String s_introduce = "introduce";

    TextView text_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        text_ok = (TextView) findViewById(R.id.tv_ok);
        text_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences_name = getSharedPreferences(s_name,0);
                SharedPreferences.Editor editor_name = sharedPreferences_name.edit();
                String s_name = edit_name.getText().toString();
                editor_name.putString("k_name",s_name);

                SharedPreferences sharedPreferences_username = getSharedPreferences(s_username,0);
                SharedPreferences.Editor editor_username = sharedPreferences_username.edit();
                String s_username = edit_username.getText().toString();
                editor_username.putString("k_username",s_username);

                SharedPreferences sharedPreferences_website = getSharedPreferences(s_website,0);
                SharedPreferences.Editor editor_website = sharedPreferences_website.edit();
                String s_website = edit_website.getText().toString();
                editor_website.putString("k_site", s_website);

                SharedPreferences sharedPreferences_introduce = getSharedPreferences(s_introduce,0);
                SharedPreferences.Editor editor_introduce = sharedPreferences_introduce.edit();
                String s_introduce = edit_introduce.getText().toString();
                editor_introduce.putString("k_introduce",s_introduce);

                editor_name.commit();
                editor_username.commit();
                editor_website.commit();
                editor_introduce.commit();

            }
        });

        edit_name = (EditText) findViewById(R.id.et_name);
        SharedPreferences sharedPreferences_name = getSharedPreferences(s_name, 0);
        String s_name = sharedPreferences_name.getString("k_name",""); // 값 불러오기
        edit_name.setText(s_name);

        edit_username = (EditText) findViewById(R.id.et_username);
        SharedPreferences sharedPreferences_username = getSharedPreferences(s_username,0);
        String s_username = sharedPreferences_username.getString("k_username","");
        edit_username.setText(s_username);

        edit_website = (EditText) findViewById(R.id.et_site);
        SharedPreferences sharedPreferences_site = getSharedPreferences(s_website,0);
        String s_website = sharedPreferences_site.getString("k_site", "");
        edit_website.setText(s_website);

        edit_introduce = (EditText) findViewById(R.id.et_introduce);
        SharedPreferences sharedPreferences_introduce = getSharedPreferences(s_introduce, 0);
        String s_introduce = sharedPreferences_introduce.getString("k_introduce","");
        edit_introduce.setText(s_introduce);


    }


}