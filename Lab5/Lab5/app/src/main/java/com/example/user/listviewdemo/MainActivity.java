package com.example.user.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Model> items;
    private TextView txt;
    CustomAdapter customAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.lst);
        items = new ArrayList<>();
        items.add(new Model("IphoneX",f));
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

        customAdapter = new CustomAdapter(this,items);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Model selectedModel = items.get(adapterContextMenuInfo.position);
        menu.setHeaderTitle(selectedModel.getType());
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = adapterContextMenuInfo.position;
        switch ((item.getItemId())) {
            case R.id.deleteBtn:
                items.remove(position);
                customAdapter.notifyDataSetChanged();
            default:
                View view = adapterContextMenuInfo.targetView;
                CheckBox ckb = view.findViewById(R.id.checkBox);
                ckb.setChecked(!ckb.isChecked());
                item.setChecked(ckb.isChecked());
                return super.onContextItemSelected(item);
        }


    }
}
