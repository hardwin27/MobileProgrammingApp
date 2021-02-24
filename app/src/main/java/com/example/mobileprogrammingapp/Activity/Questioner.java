package com.example.mobileprogrammingapp.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileprogrammingapp.Object.QuestionManager;
import com.example.mobileprogrammingapp.R;

public class Questioner extends AppCompatActivity {

    Button[] optionButtons = new Button[4];
    TextView questionText;

    private QuestionManager questionManager = new QuestionManager();
    private String[] optionList;
    private String answer;
    private int questionAmount = questionManager.questionList.length;
    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questioner);

        optionButtons[0] = (Button) findViewById(R.id.optionA);
        optionButtons[1] = (Button) findViewById(R.id.optionB);
        optionButtons[2] = (Button) findViewById(R.id.optionC);
        optionButtons[3] = (Button) findViewById(R.id.optionD);

        questionText = (TextView) findViewById(R.id.questionText);

        for (Button optionButton : optionButtons) {
            optionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(optionButton.getText() == answer) {
                        if(questionIndex >= questionAmount - 1) {
                            endQuestioner();
                        }
                        else {
                            questionIndex++;
                            updateQuestion(questionIndex);
                        }
                    }
                    else {
                        endQuestioner();
                    }
                }
            });
        }

        updateQuestion(questionIndex);
    }

    private void updateQuestion(int index) {
        questionText.setText(questionManager.getQuestion(index));
        answer = questionManager.getAnswer(index);

        optionList = questionManager.getOption(index);
        for (int optionIndex = 0; optionIndex < 4; optionIndex++) {
            optionButtons[optionIndex].setText(optionList[optionIndex]);
        }

    }

    private void endQuestioner() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Questioner.this);
        alertDialogBuilder
                .setMessage("Quiz End");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}