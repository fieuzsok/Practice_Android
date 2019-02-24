package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtUsername;
    private EditText txtPassword;
    private Button loginBtn;
    private CheckBox ckbIsRemember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.etUsername);
        txtPassword = findViewById(R.id.etPassword);
        loginBtn = findViewById(R.id.btnLogin);
        ckbIsRemember = findViewById(R.id.cbRemember);

        loginBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        String userName = txtUsername.getText().toString();
        String pwd = txtPassword.getText().toString();

        if(userName.isEmpty() || pwd.isEmpty()){
            Toast.makeText(this,"Vui long nhap user name va password",Toast.LENGTH_LONG).show();
        }
        else if(userName.equals(pwd)){
            Toast.makeText(this,"Dang Nhap Thanh Cong!!",Toast.LENGTH_LONG).show();
            if(ckbIsRemember.isChecked()){
                Toast.makeText(this,"Mật khẩu đã được lưu!!",Toast.LENGTH_LONG).show();
            }
        }

        else{
            Toast.makeText(this,"Dang Nhap That Bai",Toast.LENGTH_LONG).show();
        }
    }
}
