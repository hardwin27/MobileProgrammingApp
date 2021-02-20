package com.example.mobileprogrammingapp;

public class QuestionManager {
    public String questionList[] = {
            "Correct answer is \"Distraction\"",
            "Correct answer is \"LOL\"",
            "Correct answer is \"Panda\"",
            "Correct answer is \"123\"",
            "Correct answer is \"ABC\"",
    };

    public String optionList[][] = {
            {"Distraction", "Regeneration", "You", "Enemy"},
            {"Haha", "wkwk", "LOL", "wwww"},
            {"Bear", "Panda", "Polar Bear", "All answer"},
            {"987", "456", "876", "123"},
            {"ABC", "DEF", "GHI", "JKL"}
    };

    public String answerList[] = {
            "Distraction",
            "LOL",
            "Panda",
            "123",
            "ABC"
    };

    public String getQuestion(int index) {
        return  questionList[index];
    }

    public String[] getOption(int index) {
        return optionList[index];
    }

    public String getAnswer(int index) {
        return answerList[index];
    }
}
