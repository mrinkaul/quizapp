package com.example.testapplication1;

public class Question {
    String longLine;
    String question;
    String answerA;
    String answerB;
    String answerC;
    String answerD;
    String correctAnswerIndex;

    public Question(String longLine) {
        this.longLine = longLine;
        String[] parts = longLine.split("~");
        this.question = parts[0];
        this.answerA = parts[1];
        this.answerB = parts[2];
        this.answerC = parts[3];
        this.answerD = parts[4];
        this.correctAnswerIndex = parts[5];
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
