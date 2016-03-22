package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_SOME_DATA="someData";
    public static final Integer REQUEST_CODE_NEXT_ACT = 1001;

    private EditText edtSomeData;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSomeData = (EditText) findViewById(R.id.edtSomeData);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                intent.putExtra(KEY_SOME_DATA,edtSomeData.getText().toString());
                //startActivity(intent);

                startActivityForResult(intent,REQUEST_CODE_NEXT_ACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_NEXT_ACT){

            if(resultCode == RESULT_OK){

                if(data != null) {

                    Bundle bundle = data.getExtras();
                    String calculatedData = bundle.getString(NextActivity.KEY_CALCULATED_DATA);

                    edtSomeData.setText(calculatedData);
                }
            }
        }
    }
}
