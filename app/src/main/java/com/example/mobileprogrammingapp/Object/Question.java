package com.example.mobileprogrammingapp.Object;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mobileprogrammingapp.Database.MySingleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question {

    public interface OnGetResultListener {
        public void getResult(ArrayList<Question> result);
        public void onError(String error);
    }

    public int level;
    public String materi;
    public String question;
    public String[] option;

    public Question(int level, String materi , String question, String[] option) {
        this.materi = materi;
        this.level = level;
        this.question = question;
        this.option = option;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOption() {
        return option;
    }

    public void setOption(String[] option) {
        this.option = option;
    }

    public static void getQuestion(Context context, int level, OnGetResultListener listener) {
        String url = "https://undispensed-rose.000webhostapp.com/get_question.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ArrayList<Question> questionArray = new ArrayList<>();

                String[] splitLine = response.split("\n");
                for (String row: splitLine) {
                    String[] splitRow = row.split(Character.toString((char) 96));
                    int level = Integer.parseInt(splitRow[0]);
                    String materi = splitRow[1].trim();
                    String question = splitRow[2].trim();
                    String[] option = splitRow[3].trim().split("\\|");

                    Question q = new Question(level, materi, question, option);
                    questionArray.add(q);
                }
                listener.getResult(questionArray);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("level", level+"");
                return params;
            }
        };
        MySingleton.getInstance(context).addToRequestque(stringRequest);
    }
}
