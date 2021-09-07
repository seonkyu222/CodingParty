package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends Activity {
    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    Button btnAdd;
    Button btnDel;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_main);


        listView = (ListView) findViewById(R.id.listView1);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);

        //어댑터 객체 생성
        adapter =
                new ArrayAdapter<String>(this,//Context 객체
                        android.R.layout.simple_list_item_single_choice,//보여질 레이아웃 형태
                        list //보여질 데이터를 담고 있는 배열
                );

        //하나의 항목을 선택할 수 있는 모드 설정
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //어댑터와 리스트뷰 연결하기
        listView.setAdapter(adapter);

        //항목을 선택했을 때 수행할 동작 처리(이벤트 처리)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, //이벤트가 발생된 뷰
                                    View v,//이벤트가 발생된 차일드 뷰
                                    int position,//이벤트가 발생된 항목의 위치
                                    long id//이벤트가 발생된 뷰 id
            ) {
                //ArrayList에서 position에 해당하는 데이터 얻어오기
                String item = list.get(position);

                //토스트로 출력하기
                Toast.makeText(SubActivity.this,
                        "선택항목" + item,
                        Toast.LENGTH_SHORT).show();
            }
        });

        final EditText edt = (EditText) findViewById(R.id.edt1);

        //버튼을 눌렀을 때 입력된 항목 추가하기
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력된 문자열 얻어오기
                String str = edt.getText().toString();
                //입력된 값을 ArrayList에 추가하기
                list.add(str);
                //모델 객체가 변경되었음을 어댑터 뷰에 알리기
                adapter.notifyDataSetChanged();
                //입력된 값 지우기
                edt.setText("");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //선택한 항목의 인덱스 얻어오기
                int pos=listView.getCheckedItemPosition();
                //ArrayList에서 항목 지우기
                list.remove(pos);
                //어댑터에서 항목이 바뀜을 알리기
                adapter.notifyDataSetChanged();
                //선택한 항목표시 없애기
                listView.clearChoices();
            }
        });
    }
}
