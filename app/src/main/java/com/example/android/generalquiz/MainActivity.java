package com.example.android.generalquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private boolean isQuestion1Correct()
    {
        RadioButton q1 = (RadioButton) findViewById(R.id.q1_sol);
        return q1.isChecked();
    }
    private boolean isQuestion2Correct()
    {
        EditText userInput = (EditText) findViewById(R.id.q2_user_input);
        String ans = userInput.getText().toString();
        return ans.equalsIgnoreCase("camel");
    }
    private boolean isQuestion3Correct()
    {
        CheckBox q3_1 = (CheckBox) findViewById(R.id.q3_option1);
        CheckBox q3_2 = (CheckBox) findViewById(R.id.q3_option2);
        CheckBox q3_3 = (CheckBox) findViewById(R.id.q3_option3);
        CheckBox q3_4 = (CheckBox) findViewById(R.id.q3_option4);
        return (q3_1.isChecked() && !q3_2.isChecked() && q3_3.isChecked() && !q3_4.isChecked());
    }
    private boolean isQuestion4Correct()
    {
        RadioButton q4_sol = (RadioButton) findViewById(R.id.q4_answer);
        return q4_sol.isChecked();
    }
    private boolean isQuestion5Correct()
    {
        RadioButton q5_sol = (RadioButton) findViewById(R.id.q5_answer);
        return q5_sol.isChecked();
    }
    public int getScore()
    {
        int score = 0;
        boolean a = isQuestion1Correct();
        boolean b = isQuestion2Correct();
        boolean c = isQuestion3Correct();
        boolean d = isQuestion4Correct();
        boolean e = isQuestion5Correct();
        if(a)
            score++;
        if(b)
            score++;
        if(c)
            score++;
        if(d)
            score++;
        if(e)
            score++;
        return score;
    }
    public void submit(View view)
    {
        Integer score = getScore();
        Context context = getApplicationContext();
        String text;
        if(score >= 3)
            text = "Good job! You got ";
        else
            text = "Poor Score! You got ";
        text += score.toString();
        CharSequence toastMessage = text;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.show();
    }
}
