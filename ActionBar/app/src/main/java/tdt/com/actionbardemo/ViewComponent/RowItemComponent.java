package tdt.com.actionbardemo.ViewComponent;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tdt.com.actionbardemo.LongClickListener;
import tdt.com.actionbardemo.R;

public class RowItemComponent {
//implements  View.OnLongClickListener
    private  TextView txtName;
    private  ImageView img;
    //LongClickListener longClickListener;

    public RowItemComponent(View v) {
        txtName = v.findViewById(R.id.item);
        img = v.findViewById(R.id.img);

        //v.setOnLongClickListener(this);
    }

    public TextView getTxtName() {
        return txtName;
    }

    public void setTxtName(TextView txtName) {
        this.txtName = txtName;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
  /*  public void setLongClickListener(LongClickListener longClickListener){
        this.longClickListener = longClickListener;
    }*/

   /* @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onItemLongClick();
        return false;
    }*/
}
