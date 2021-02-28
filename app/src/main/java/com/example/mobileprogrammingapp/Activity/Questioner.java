package com.example.mobileprogrammingapp.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprogrammingapp.Object.QuestionManager;
import com.example.mobileprogrammingapp.R;

public class Questioner extends AppCompatActivity {

    Button[] optionButtons = new Button[4];
    TextView questionText;
    Dialog dialog;

    private QuestionManager questionManager = new QuestionManager();
    private String[] optionList;
    private String answer;
    private int questionAmount = questionManager.questionList.length;
    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dialog = new Dialog(this);

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


    
    private void openTrueDialog(){
        dialog.setContentView(R.layout.true_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);
        Button btnOk = dialog.findViewById(R.id.btn_ok);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void openWrongDialog(){
        dialog.setContentView(R.layout.wrong_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);
        Button btnOk = dialog.findViewById(R.id.btn_ok);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}