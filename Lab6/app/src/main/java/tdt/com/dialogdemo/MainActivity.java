package tdt.com.dialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button simpleDialog ;
    private  Button singleChoiceBtn;
    private  Button multiChoiceBtn;
    String selectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        simpleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog();
            }
        });

        singleChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoice();
            }
        });

    }

    private void showSingleChoice() {
        final String[] choice = new String[]{"Pepsi","Coke","Sprite","Seven Up"};
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setTitle("Choice....");
        builder.setSingleChoiceItems(choice, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedItem = choice[which];
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You choose " + selectedItem,Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Task");
        builder.setMessage("Dress up like Mario and throw mushrooms at people");
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"CANCEL",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"DELETE",Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    private void initView() {
        simpleDialog = findViewById(R.id.simpleDiaBtn);
        singleChoiceBtn = findViewById(R.id.siglechoiceBtn);
        multiChoiceBtn = findViewById(R.id.mutiplechoiceBtn);
    }
}
