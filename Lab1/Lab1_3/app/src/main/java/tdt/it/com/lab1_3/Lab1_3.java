package tdt.it.com.lab1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Lab1_3 extends AppCompatActivity {
    private RadioButton radAndroid,radIOS,radWin,radRim;
    private Button resultBtn;
    private TextView resultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_3);

        radAndroid = findViewById(R.id.android);
        radIOS = findViewById(R.id.ios);
        radWin = findViewById(R.id.win);
        radRim = findViewById(R.id.rim);

        resultBtn = findViewById(R.id.resultbtn);
        resultTxt = findViewById(R.id.output);

        resultBtn.setOnClickListener(listenerGetResult);
    }

    private View.OnClickListener listenerGetResult = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resultTxt.setText("The following result is: "
                    + "\nAndroid : " + radAndroid.isChecked()
                    + "\nIOS : " + radIOS.isChecked()
                    + "\nWindow : " + radWin.isChecked()
                    + "\nRIM : " + radRim.isChecked()
            );
        }
    };
}