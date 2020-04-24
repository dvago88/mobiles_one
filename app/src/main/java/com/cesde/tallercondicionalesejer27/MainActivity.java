package com.cesde.tallercondicionalesejer27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int BASE_PULSE_WOMEN = 220;
        final int BASE_PULSE_MEN = 220;
        final int PULSE_FORMULA_CONSTANT_DENOMINATOR = 10;
        final EditText ageEditText = findViewById(R.id.ageEditText);
        final EditText genderEditText = findViewById(R.id.genderEditText);
        final TextView resultTextView = findViewById(R.id.resultTextView);

        Button calculateButton = findViewById(R.id.caculateButton);
        Button layoutTwoButton = findViewById(R.id.layoutTwoButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double age = Integer.parseInt(ageEditText.getText().toString());
                String gender = genderEditText.getText().toString();
                double pulsePerMinute;
                if (isMasculine(gender)) {
                    pulsePerMinute = (BASE_PULSE_WOMEN - age) / PULSE_FORMULA_CONSTANT_DENOMINATOR;
                } else {
                    pulsePerMinute = (BASE_PULSE_MEN - age) / PULSE_FORMULA_CONSTANT_DENOMINATOR;
                }
                resultTextView.setText(pulsePerMinute + "");
            }
        });

        layoutTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondLayout = new Intent(MainActivity.this, Layout2.class);
                startActivity(secondLayout);
            }
        });
    }

    /**
     * Checks if the string is 'femenino' in any other case it will be considered 'masculino'.
     *
     * @param gender String with the gender written in spanish.
     * @return true if the string it's different to 'femenino'
     */
    protected boolean isMasculine(String gender) {
        return !gender.toLowerCase().equals("femenino");
    }
}
