package android.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button mCalculatorButton;
    private TextView mResultText;
    private EditText mAge;
    private EditText mFeet;
    private EditText mInches;
    private RadioButton mFemaleButton;
    private RadioButton mMaleButton;
    private EditText mWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        setUpButtonClickListener();


    }

    private void setUpButtonClickListener() {
        mCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String ageText = mAge.getText().toString();

                int age = Integer.parseInt(ageText);

                if (age >= 18){
                    calculateBMI();
                }
                else{
                    double juvenileBMI = calculateBMI();
                    getDisplayGuidance(juvenileBMI);
                }



            }
        });
    }




    private double calculateBMI() {

        String ageText = mAge.getText().toString();
        String feet = mFeet.getText().toString();
        String inches = mInches.getText().toString();
        String weight = mWeight.getText().toString();

        int ifeet = Integer.parseInt(feet);
        int iweight = Integer.parseInt(weight);
        int iinches = Integer.parseInt(inches);
        int iage = Integer.parseInt(ageText);


        int totalInches = ifeet * 12 + iinches;

        double heightInMeters = totalInches * 0.0254;

        double bmi = iweight / (heightInMeters * heightInMeters);


        displayHealth(bmi);

        return iweight / (heightInMeters * heightInMeters);

    }


    private void displayHealth(double bmi) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");


        String bmiTextResults = decimalFormat.format(bmi);

        String fullResultString;

        if(bmi < 18.5){

            fullResultString = bmiTextResults + " - You're underweight";


        }
        else if(bmi > 25){

            fullResultString = bmiTextResults + " - You're overweight";

        }
        else{

            fullResultString = bmiTextResults + " - You're healthy weight";

        }


        mResultText.setText(fullResultString);

    }

    private void getDisplayGuidance(double juvenileBMI) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");


        String bmiTextResults = decimalFormat.format(juvenileBMI);

        String fullResultString;

        if(mMaleButton.isChecked()){

            fullResultString = bmiTextResults + " - Since you're under the age of 18, please consult with your doctor";


        }
        else if(mFemaleButton.isChecked()){

            fullResultString = bmiTextResults + " - Since you're under the age of 18, please consult with your doctor";

        }

        else{

            fullResultString = bmiTextResults + " - Since you're under the age of 18, please consult with your doctor";

        }

        mResultText.setText(fullResultString);




    }

    private void findViews(){

        mResultText = findViewById(R.id.resultText);
        mAge = findViewById(R.id.ageText);
        mFeet = findViewById(R.id.feetText);
        mInches = findViewById(R.id.inchesText);
        mCalculatorButton = findViewById(R.id.calculatorButton);
        mFemaleButton = findViewById(R.id.femaleButton);
        mMaleButton = findViewById(R.id.maleButton);
        mWeight = findViewById(R.id.weightText);

    }
}