package com.example.izz.mathgames;

public class Question {
    private String mQuestions[] = {
            "How many digits are there in 1000",
            "How many factors are there in 71",
            "Which is the largest number in 90, 68, 21",
            "2 is a ________ number",
            "How many hours in 90 minutes",
            "What is the factors of 9",
            "How many digits answer we will get when we add 99 and 1",
            "What is the unit of volume",
            "Arrange the numbers in ascending order: 36, 12, 29, 21, 7",
            "What is the greatest two digit number"

    };


    private String mChoices[][] = {
            {"Four Digits", "Two Digits", "One Digit"},
            {"5", "7", "2"},
            {"21", "90", "68"},
            {"Small", "Odd", "Prime"},
            {"9 hours", "3 hours", "5 hours"},
            {"1,3 and 6", "2,3,6 and 9", "None of these"},
            {"100", "30", "3"},
            {"Units", "Cubic Units", "Square Units"},
            {"7, 12, 21, 29, 36", "36, 29, 21, 12, 7", "7, 21, 36, 29, 7"},
            {"67", "99", "250"}


    };


    private String mCorrectAnswers[] = {"Four Digits", "2", "90", "Prime", "3 hours", "None of these", "100", "Cubic Units", "7, 12, 21, 29, 36", "99"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}

