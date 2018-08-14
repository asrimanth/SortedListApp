package com.example.asrimanth.sortedlistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.nameEditText);
        button = findViewById(R.id.addButton);
        listView = findViewById(R.id.myListView);

        list = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateList();

            }
        });
    }

    private void updateList() {

        String name = editText.getText().toString();

        list.add(name.toUpperCase());
        Collections.sort(list);
        editText.setText("");

        adapter.notifyDataSetChanged();
    }
}
