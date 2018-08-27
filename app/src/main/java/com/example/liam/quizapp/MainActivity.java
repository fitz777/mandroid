package com.example.liam.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rdoButton;
    CheckBox chkBox;
    boolean[] results = new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicked(View view) {
        // check question 1
        rdoButton = (RadioButton) findViewById(R.id.q1o3);
        boolean isQuestion1Correct = rdoButton.isChecked();
        results[0] = isQuestion1Correct;

        // check question 2
        rdoButton = (RadioButton) findViewById(R.id.q2o3);
        boolean isQuestion2Correct = rdoButton.isChecked();
        results[1] = isQuestion2Correct;

        // check question 3
        chkBox = (CheckBox) findViewById(R.id.q3o1);
        boolean isOption1Selected = chkBox.isChecked();

        chkBox = (CheckBox) findViewById(R.id.q3o2);
        boolean isOption2Selected = chkBox.isChecked();

        chkBox = (CheckBox) findViewById(R.id.q3o3);
        boolean isOption3Selected = chkBox.isChecked();

        chkBox = (CheckBox) findViewById(R.id.q3o4);
        boolean isOption4Selected = chkBox.isChecked();

        boolean isQuestion3Correct = isOption1Selected
                && !isOption2Selected
                && isOption3Selected
                && isOption4Selected;

        results[2] = isQuestion3Correct;

        // check question 4
        rdoButton = (RadioButton) findViewById(R.id.q4o4);
        boolean isQuestion4Correct = rdoButton.isChecked();
        results[3] = isQuestion4Correct;

        // check question 5
        EditText question5ResponseField = (EditText) findViewById(R.id.q5);
        String question5Response = question5ResponseField.getText().toString().trim();

        boolean isQuestion5Correct = false;
        if (tryParseInt(question5Response)) {
            isQuestion5Correct = Integer.parseInt(question5Response) == 20;
        }

        results[4] = isQuestion5Correct;
        int totalScore = calculateScore(results);

        Toast.makeText(this, "Your total score is " +  totalScore, Toast.LENGTH_SHORT).show();

    }

    private int calculateScore(boolean[] results) {
        int score = 0;

        for (boolean item : results)
        {
            if (item)
            {
                score++;
            }
        }

        return score;
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
