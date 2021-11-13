package com.example.testapplication1;

import static com.example.testapplication1.Constants.GLOBAL_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = GLOBAL_TAG + "MainActivity";

    TextView questionTextView;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    TextView commentTextView;
    Button buttonSkip;
    List<Question> fullQuesionList;
    Question[] fullQuestionArray;
    int currentQuestionIndex = 0;
    Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started......");
        acquireHandles();
        commentTextView.setText("");
        readQuestionFile();
        //currentQuestion = new Question("When was NASA founded ?~1995~1974~1947~1999~C");
        //setupQuestion();
        goToNextQuestion(0);
    }

    private void acquireHandles() {
        // Get handles to various views
        questionTextView = (TextView) findViewById(R.id.question);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonSkip = (Button) findViewById(R.id.buttonSkip);
        commentTextView = (TextView) findViewById(R.id.textViewComment);
        Log.d(TAG, "Setup Handles");
    }

    private void readQuestionFile() {
        // Read resources text file with list of questions
        // Create an array of questions
        // Line by Line reading, and for each line, call
        // Question q = new Question(..... the line);
        // fullQuestionList.add(q);

        // Once the fullQuestionList is ready, convert from List<Question> to Question[]
        // Google how to convert from List to Array


        // Finally,  fullQuestionsArray should be proper
    }

    private void setupQuestion() {
        questionTextView.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getAnswerA());
        buttonB.setText(currentQuestion.getAnswerB());
        buttonC.setText(currentQuestion.getAnswerC());
        buttonD.setText(currentQuestion.getAnswerD());
    }

    private void goToNextQuestion(int index) {
        if(index >= fullQuestionArray.length) {
            commentTextView.setText("All Questions answered or skipped");
            Log.d(TAG, "Done with all questions");
            goToNextQuestion(0);
        }
        currentQuestion = fullQuestionArray[index];
        currentQuestionIndex = index;
    }

    private void setComment(Boolean a) {
        if(a) {
            commentTextView.setText("Correct!");
            Log.d(TAG, "Correct");
            goToNextQuestion(currentQuestionIndex++);
        } else {
            commentTextView.setText("Incorrect, Try Again !");
        }
    }

    public void onClickButtonA(View view) {
        Log.d(TAG, "Button A");
        if(currentQuestion.getCorrectAnswerIndex().equals("A"))
            setComment(true);
        else
            setComment(false);
    }

    public void onClickButtonB(View view) {
        Log.d(TAG, "Button B");
        if(currentQuestion.getCorrectAnswerIndex().equals("B"))
            setComment(true);
        else
            setComment(false);
    }

    public void onClickButtonC(View view) {
        Log.d(TAG, "Button C");
        if(currentQuestion.getCorrectAnswerIndex().equals("C"))
            setComment(true);
        else
            setComment(false);
    }

    public void onClickButtonD(View view) {
        Log.d(TAG, "Button D");
        if(currentQuestion.getCorrectAnswerIndex().equals("D"))
            setComment(true);
        else
            setComment(false);
    }

    public void onClickButtonSkip(View view) {
        Log.d(TAG, "Button Skip");
        goToNextQuestion(currentQuestionIndex++);
    }
}