package tdt.com.listviewdemo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import tdt.com.listviewdemo.R;
import tdt.com.listviewdemo.model.Student;

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private  int res;
    private  ArrayList<Student> data;
    public StudentAdapter(@Nullable Context context, int resource ,ArrayList<Student> data) {
        super(context, resource, data);
        this.context = context;
        this.res = resource;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(this.res,null);
        }
        ImageView imgV = convertView.findViewById(R.id.img);
        final CheckBox ckb = convertView.findViewById(R.id.ckb);
        TextView mssvV = convertView.findViewById(R.id.mssv);
        TextView hoTenV = convertView.findViewById(R.id.hoten);

        ckb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getItem(position).setSelected(isChecked);
            }
        });

        imgV.setImageResource(data.get(position).getSrcID());
        hoTenV.setText(data.get(position).getHoTen());
        mssvV.setText(data.get(position).getmSSV());
        ckb.setChecked(data.get(position).isSelected());

        return convertView;
    }
}
