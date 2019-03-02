package com.example.user.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Model> {

    private ArrayList<Model> items;
    private Context context;

    public CustomAdapter(Context context,ArrayList<Model> items) {
        super(context,R.layout.row_item,items);
        this.items = items;
       this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row_item,null);

        TextView textView = convertView.findViewById(R.id.typeTV);
        textView.setText(items.get(position).getType());

        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        boolean isCheck = items.get(position).isCheck();
        checkBox.setChecked(isCheck);


        return convertView;
    }

}
