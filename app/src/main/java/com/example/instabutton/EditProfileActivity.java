package com.example.instabutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.shadow.ShadowRenderer;

public class EditProfileActivity extends AppCompatActivity {

    EditText edit_name;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edit_name = (EditText) findViewById(R.id.et_name);
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        // 앱 재실행 시 값을 불러와야 함
        String value = sharedPreferences.getString("key값",""); // 값 불러오기
        edit_name.setText(value);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = edit_name.getText().toString();
        editor.putString("key값",value);
        editor.commit(); // save를 완료해라
        // 앱 종료시 SharedPreference로 저장완료
    }

}