package tdt.com.lab3_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button goToLink;
    private EditText txtLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        eventHandle();
    }

    private void eventHandle() {
        goToLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = txtLink.getText().toString();
                if(!link.isEmpty()){
                    openBrowser(link);
                }


            }


        });
    }
    private void openBrowser(String link) {

        Uri uri = Uri.parse(link);
        Intent browser = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(browser);

    }
    private void initView() {
        goToLink = findViewById(R.id.openBrowser);
        txtLink = findViewById(R.id.txtLink);
    }


}
