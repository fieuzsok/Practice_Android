package tdt.com.newactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity {

    private TextView txtMsg;
    private EditText txtName;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        initScreen();
        enventHandler();

        getIntentValue();
    }

    private void getIntentValue() {
        String email = getIntent().getStringExtra(MainActivity.USERNAME_INTENT);
        String content = "Xin chào, " + email + ". Vui lòng nhập tên";
        txtMsg.setText(content);

    }

    private void enventHandler() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                Intent intent = new Intent(Screen2Activity.this, MainActivity.class);
                intent.putExtra("name", name);
                setResult(400, intent);
                finish();
               // startActivityForResult(intent, 400);
            }
        });
    }

    private void initScreen() {
        txtMsg = findViewById(R.id.txtMess);
        txtName = findViewById(R.id.name);
        btnLogin = findViewById(R.id.save);

    }
}
