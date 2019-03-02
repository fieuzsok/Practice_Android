package tdt.com.newactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String USERNAME_INTENT = "username";
    private TextView txtMsg;
    private EditText txtEmail;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initScreen();
        enventHandler();
    }

    private void enventHandler() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = txtEmail.getText().toString();
                Intent intent = new Intent(MainActivity.this,Screen2Activity.class);
                intent.putExtra(USERNAME_INTENT,inputEmail);
                startActivityForResult(intent,400);
                finish();
            }
        });
    }

    private void initScreen() {
        txtMsg = findViewById(R.id.txtMsg);
        txtEmail = findViewById(R.id.emailTxt);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 400){
            txtMsg.setText("Hẹn gặp lại");
            txtEmail.setText(data.getStringExtra("name"));
            btnLogin.setVisibility(View.GONE);
        }

    }
}
