package com.example.mobileprogrammingapp.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileprogrammingapp.Activity.Questioner;
import com.example.mobileprogrammingapp.Object.QuestionManager;
import com.example.mobileprogrammingapp.R;

public class Quiz extends Fragment {

    Button[] optionButtons = new Button[4];
    TextView questionText;

    private QuestionManager questionManager = new QuestionManager();
    private String[] optionList;
    private String answer;
    private int questionAmount = questionManager.questionList.length;
    private int questionIndex = 0;

    public Quiz() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);


        optionButtons[0] = view.findViewById(R.id.optionA);
        optionButtons[1] = view.findViewById(R.id.optionB);
        optionButtons[2] = view.findViewById(R.id.optionC);
        optionButtons[3] = view.findViewById(R.id.optionD);

        questionText = view.findViewById(R.id.questionText);

        for (Button optionButton : optionButtons) {
            optionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(optionButton.getText() == answer) {
                        if(questionIndex >= questionAmount - 1) {
                            endQuestioner(getContext());
                        }
                        else {
                            questionIndex++;
                            updateQuestion(questionIndex);
                        }
                    }
                    else {
                        endQuestioner(getContext());
                    }
                }
            });
        }

        updateQuestion(questionIndex);

        return view;
    }

    private void updateQuestion(int index) {
        questionText.setText(questionManager.getQuestion(index));
        answer = questionManager.getAnswer(index);

        optionList = questionManager.getOption(index);
        for (int optionIndex = 0; optionIndex < 4; optionIndex++) {
            optionButtons[optionIndex].setText(optionList[optionIndex]);
        }

    }

    private void endQuestioner(Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setMessage("Quiz End");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}