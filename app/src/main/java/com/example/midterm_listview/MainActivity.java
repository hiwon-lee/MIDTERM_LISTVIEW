package com.example.midterm_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    final ArrayList<String> midList = new ArrayList<String>();
    private ListView listView1;
    private EditText etItem;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 동적 추가 & 삭제 테스트");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, midList);
        listView1 = findViewById(R.id.listView1);

        listView1.setAdapter(adapter);

        etItem = findViewById(R.id.etItem);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v->{
            midList.add(etItem.getText().toString());
            adapter.notifyDataSetChanged();
        });
        listView1.setOnItemClickListener((AdapterView.OnItemClickListener)
                (parent, view, position, id) -> {
                    midList.remove(position);
                    adapter.notifyDataSetChanged();
                });
    }
}