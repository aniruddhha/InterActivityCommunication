package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_CALCULATED_DATA = "calculatedData";

    private EditText edtCalculatedData;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        edtCalculatedData = (EditText) findViewById(R.id.edtCalculatedData);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent messagePasser = new Intent();
                messagePasser.putExtra(KEY_CALCULATED_DATA, edtCalculatedData.getText().toString());
                if(edtCalculatedData.getText().toString().length() > 5)
                setResult(RESULT_OK,messagePasser);
                else
                    setResult(RESULT_CANCELED,messagePasser);

                finish();
            }
        });

        Intent intentResponsible = getIntent();
        Bundle bundle = intentResponsible.getExtras();
        String someData = null;
        if(bundle != null)
            someData = bundle.getString(MainActivity.KEY_SOME_DATA);

        edtCalculatedData.setText(someData + System.currentTimeMillis());
    }
}
