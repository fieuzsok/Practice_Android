package tdt.it.com.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Lab1_2 extends AppCompatActivity {
    private CheckBox checkBoxAndroid,checkBoxIOS,checkBoxWin,checkBoxRim;
    private Button resultBtn;
    private TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_2);

        checkBoxAndroid = findViewById(R.id.android);
        checkBoxIOS = findViewById(R.id.ios);
        checkBoxWin = findViewById(R.id.win);
        checkBoxRim = findViewById(R.id.rim);

        resultBtn = findViewById(R.id.resultbtn);
        resultTxt = findViewById(R.id.output);

        resultBtn.setOnClickListener(listenerGetResult);

    }

    private View.OnClickListener listenerGetResult = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resultTxt.setText("The following result is: "
             + "\nAndroid : " + checkBoxAndroid.isChecked()
             + "\nIOS : " + checkBoxIOS.isChecked()
             + "\nWindow : " + checkBoxWin.isChecked()
             + "\nRIM : " + checkBoxRim.isChecked()
            );
        }
    };
}
