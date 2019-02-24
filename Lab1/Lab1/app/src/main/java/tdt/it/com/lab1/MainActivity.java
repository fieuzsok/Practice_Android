package tdt.it.com.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showbtn;
    private EditText nameTxt;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showbtn = findViewById(R.id.showbtn);
        nameTxt = findViewById(R.id.name);
        output = findViewById(R.id.textOutput);
        showbtn.setOnClickListener(listenerButton);

        nameTxt.addTextChangedListener(infochangeListener);
    }

    private View.OnClickListener listenerButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String namestr = nameTxt.getText().toString();
            if(namestr.isEmpty()){
                Toast.makeText(MainActivity.this,"Vui long nhap thong tin",Toast.LENGTH_SHORT).show();
            }
            else{
                output.setText(namestr);
                nameTxt.setText("");
            }

        }
    };
    private TextWatcher infochangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String content = nameTxt.getText().toString();
            if(content.equals("OFF")){
                showbtn.setEnabled(false);
            }else if(content.equals("ON")){
                showbtn.setEnabled(true);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
