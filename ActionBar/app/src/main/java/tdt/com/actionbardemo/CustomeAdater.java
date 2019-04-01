package tdt.com.actionbardemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import tdt.com.actionbardemo.ViewComponent.RowItemComponent;
import tdt.com.actionbardemo.model.ItemClass;


public class CustomeAdater extends ArrayAdapter<ItemClass> {
    private Context context;
    private int res;
    private ArrayList<ItemClass> data;
    private int positionRowItem;

    public CustomeAdater(Context context, int resource, ArrayList<ItemClass> objects) {
        super(context, resource, objects);
        this.context = context;
        this.res = resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        //convert item xml to view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(res, null);
        }

        RowItemComponent rowItemComponent = new RowItemComponent(convertView);
        rowItemComponent.getTxtName().setText(data.get(position).getName());
        rowItemComponent.getImg().setImageResource(data.get(position).getSrcID());

       /* rowItemComponent.setLongClickListener(new LongClickListener() {
            @Override
            public void onItemLongClick() {
                positionRowItem = position;
                //String rowItemName = data.get(position).getName();
                //Toast.makeText(context,rowItemName,Toast.LENGTH_LONG).show();
            }
        });*/
        return convertView;
    }

    public void getSelectContextMenu(MenuItem item) {
        switch ((item.getItemId())) {
            case R.id.deleteMenu:
                //Toast.makeText(context,  "Delete ne", Toast.LENGTH_SHORT).show();
                data.remove(positionRowItem);
                this.notifyDataSetChanged();
            default:


        }
    }

}
