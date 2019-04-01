package tdt.com.actionbardemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import tdt.com.actionbardemo.model.ItemClass;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemClass> dataList;
    private CustomeAdater customeAdater;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thực hành về Menu");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);

        initView();
        bindingData();



    }

    private void bindingData() {
        int[] imgLocal;
        imgLocal = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8};
        dataList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dataList.add(new ItemClass(imgLocal[i], "Item " + i));
        }

        customeAdater = new CustomeAdater(this, R.layout.activity_list_row, dataList);
        listView.setAdapter(customeAdater);
        registerForContextMenu(listView);
    }

    private void initView() {
        listView = findViewById(R.id.lst);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ((item.getItemId())) {
            case R.id.addMenu:
                Toast.makeText(MainActivity.this, "Search ne", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddItemController.class);
                startActivityForResult(intent, 100);
                //startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 400) {
            String input = data.getStringExtra("itemName");
            ItemClass tmp = new ItemClass(R.drawable.a9, input);
            dataList.add(tmp);
            customeAdater.notifyDataSetChanged();

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = adapterContextMenuInfo.position;
        switch ((item.getItemId())) {
            case R.id.deleteMenu:
                //Toast.makeText(context,  "Delete ne", Toast.LENGTH_SHORT).show();
                dataList.remove(position);
                customeAdater.notifyDataSetChanged();
            default:


                //customeAdater.getSelectContextMenu(item);
                return super.onContextItemSelected(item);
    }


    }
}