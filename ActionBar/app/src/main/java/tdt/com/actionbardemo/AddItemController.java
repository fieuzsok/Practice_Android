package tdt.com.actionbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemController extends AppCompatActivity {
    private Button btnAdd;
    private EditText txtItemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        txtItemName = (EditText) findViewById(R.id.itemName);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = txtItemName.getText().toString();
                if(!itemName.isEmpty()){
                    Intent intent = new Intent(AddItemController.this,MainActivity.class);
                    intent.putExtra("itemName",itemName);
                    setResult(400,intent);
                    finish();
                }
            }
        });

    }
}
