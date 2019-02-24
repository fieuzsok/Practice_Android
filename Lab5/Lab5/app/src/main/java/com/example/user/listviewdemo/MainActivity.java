package com.example.user.listviewdemo;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private ArrayList<Model> items;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    txt = findViewById(R.id.textView);
        items = new ArrayList<>();
        items.add(new Model("IphoneX",true));
        items.add(new Model("Samsung",false));
        items.add(new Model("Nokia",false));
        items.add(new Model("Oppo",false));
        items.add(new Model("IphoneX1",false));
        items.add(new Model("Samsung1",false));
        items.add(new Model("Nokia1",false));
        items.add(new Model("Oppo1",false));
        items.add(new Model("IphoneX2",false));
        items.add(new Model("Samsung2",false));
        items.add(new Model("Nokia2",false));
        items.add(new Model("Oppo2",false));

        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        CustomAdapter customAdapter = new CustomAdapter(this,items);
        setListAdapter(customAdapter);



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String itemData = items.get(position).getType();
        CheckBox cb  = findViewById(R.id.checkBox);
        boolean isCheck = cb.isChecked();
        items.get(position).setCheck(isCheck);
        cb.setChecked(isCheck);
        txt.setText(itemData);

        Toast.makeText(MainActivity.this,"Chọn "  ,Toast.LENGTH_LONG).show();
    }
}
