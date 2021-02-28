package com.example.mobileprogrammingapp.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mobileprogrammingapp.Database.MySingleton;
import com.example.mobileprogrammingapp.Object.CourseObj;
import com.example.mobileprogrammingapp.Object.Question;
import com.example.mobileprogrammingapp.Object.QuestionManager;
import com.example.mobileprogrammingapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Questioner extends AppCompatActivity {

    Button[] optionButtons = new Button[4];
    TextView questionText;

    private ArrayList<Question> questionArray;
    int level;
    Random random = new Random();
    Question currentQuestion;
    private int answerIndex;

    private int questionCounter = 0;
    private int correctCounter = 0;
    SharedPreferences sf;
    private boolean stopAssesment = false;

    int mode = 1; // 0 = down, 1 = normal, 2 = up

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questioner);

        dialog = new Dialog(this);

        optionButtons[0] = findViewById(R.id.optionA);
        optionButtons[1] = findViewById(R.id.optionB);
        optionButtons[2] = findViewById(R.id.optionC);
        optionButtons[3] = findViewById(R.id.optionD);

        questionText = findViewById(R.id.questionText);

        sf = this.getSharedPreferences("SETTING", Context.MODE_PRIVATE);
        level = sf.getInt("level",0);

        for (int i = 0; i < 4; i++) {
            int choosenOptionIndex = i;
            optionButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choosenOptionIndex == answerIndex) {
                        openTrueDialog();
                        correctCounter++;
                        updateQuestion();

                    } else {
                        updateQuestion();
                        openWrongDialog();
                    }
                }
            });
        }

        getQuestionFromDb();
    }

    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void getQuestionFromDb() {
        ProgressDialog pdialog = new ProgressDialog(this);
        pdialog.setMessage("Loading...");
        pdialog.setCancelable(false);
        pdialog.show();

        Question.getQuestion(this, level, new Question.OnGetResultListener() {
            @Override
            public void getResult(ArrayList<Question> result) {
                pdialog.dismiss();
                questionArray = result;
                Log.d("Response", questionArray.get(0).question);

                updateQuestion();
            }
            @Override
            public void onError(String error) {
                pdialog.dismiss();
                Toast.makeText(Questioner.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateQuestion() {
        if (questionCounter == 3) {
            leveling();
            questionCounter = 0;
            correctCounter = 0;

            if (!stopAssesment) {
                getQuestionFromDb();
            }
        } else if (!questionArray.isEmpty()) {
            int randomNumber = random.nextInt(questionArray.size());
            currentQuestion = questionArray.get(randomNumber);
            questionArray.remove(randomNumber);

            questionText.setText(currentQuestion.getQuestion());
            String[] options = currentQuestion.getOption();

            for (int i = 0; i < 4; i++){
                String optionText = options[i];
                if (optionText.contains("*")) {
                    answerIndex = i;
                    optionText = optionText.replace("*","");
                }
                optionButtons[i].setText(optionText);
            }

            questionCounter++;
        }
    }

    private void leveling() {
        if (level > 0 && level <= 5) {

            if (correctCounter >= 2) {
                level++;
                // Materi ini paham
                if (mode == 0) { // Mode turun
                    // Berhenti, level = level sekarang + 1
                    stopAssesment();
                } else { // Mode Naik
                    mode = 2;
                }

            } else {
                // Materi ini tidak paham
                if (mode == 2) { // Mode naik
                    // Berhenti, level = level sekarang
                    stopAssesment();
                }  else { // Mode turun
                    mode = 0;
                    level--;
                }
            }


            SharedPreferences.Editor editor = sf.edit();
            editor.putInt("level", level);
            editor.apply();

            String url = "https://undispensed-rose.000webhostapp.com/leveling.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("LEVELING RESULT", response);
                }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("LEVELING ERROR", error.getMessage());
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email", sf.getString("email", ""));
                    params.put("level", level+"");
                    return params;
                }
            };
            MySingleton.getInstance(Questioner.this).addToRequestque(stringRequest);

        } else {
            stopAssesment();
        }
    }

    private void stopAssesment() {
        stopAssesment = true;
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
                if (stopAssesment) {
                    openDialogEnd();
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (stopAssesment) {
                    openDialogEnd();
                }
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
                if (stopAssesment) {
                    openDialogEnd();
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (stopAssesment) {
                    openDialogEnd();
                }
            }
        });

        dialog.show();
    }

    private void openDialogEnd() {
        String materi;
        int lvl = sf.getInt("level", level);
        if (lvl > 1) {
            materi = CourseObj.getAll().get(lvl-2).title;
        } else {
            materi = "Nothing";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(Questioner.this);
        builder.setTitle("Assesment End");
        builder.setMessage("Your level of understanding is on \""+materi+"\". We have provide you courses that related with your level of understanding.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Questioner.this, MainActivity.class));
                finish();
            }
        });
        builder.setCancelable(false);
        builder.create().show();

    }
}