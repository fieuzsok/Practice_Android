package tdt.com.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tdt.com.listviewdemo.adapter.StudentAdapter;
import tdt.com.listviewdemo.model.Student;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Student> dataList;
    private ListView lstV;
    private Button btnAdd;
    private Button btnDel;
    private Button btnDellAll;
    private EditText editMssv;
    private EditText edihoten;
    private int[] listImg;
    private StudentAdapter adapter;
    private int idImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setData();
        handleEvent();
    }

    private void setData() {
        listImg = new int[]{R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,
                R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,R.drawable.a13};
        dataList = new ArrayList<>();
        for(int i = 0; i<listImg.length;i++){
            dataList.add(new Student("00"+i,"Sinh Viên" + i,listImg[i],false));
        }
        adapter = new StudentAdapter(this,R.layout.row_item,dataList);
        lstV.setAdapter(adapter);
    }

    private void handleEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mssv = editMssv.getText().toString();
                String hoTen = edihoten.getText().toString();
                if(!(mssv.isEmpty() && hoTen.isEmpty())){
                    idImg++;
                    idImg = idImg % listImg.length;
                    dataList.add(new Student(mssv,hoTen,listImg[idImg],false));
                    adapter.notifyDataSetChanged();
                    editMssv.setText("");
                    edihoten.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this,"Vui lòng điền vô ",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean tagDel = false;
                for(int i = 0; i<dataList.size();i++){
                    if(dataList.get(i).isSelected()){
                        dataList.remove(i);
                        i--;
                        tagDel = true;
                    }
                }
                if(tagDel){
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnDellAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.clear();
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void initView() {
        lstV = (ListView) findViewById(R.id.listV);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDellAll = (Button) findViewById(R.id.btnDellAll);
        editMssv =  (EditText) findViewById(R.id.mssvEdit);
        edihoten = (EditText) findViewById(R.id.hotenEdit);

    }
}
