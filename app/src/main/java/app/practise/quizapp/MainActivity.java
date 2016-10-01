package app.practise.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextQuestion;
    private Button mButtonTrue;
    private Button mButtonFalse;
    private Button mButtonNext;
    private Button mButtonPrevious;
    private ArrayList<Question> questionList = new ArrayList<>();
    private QuestionBank questionBank = new QuestionBank();
    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextQuestion = (TextView) findViewById(R.id.text_question);

        setQuestions();
        updateQuestion(questionIndex);

        mButtonTrue = (Button) findViewById(R.id.button_true);
        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionList.get(questionIndex).isTrue()){
                    generateToast("You are right");
                }
                else {
                    generateToast("You are wrong");
                }
            }
        });

        mButtonFalse = (Button) findViewById(R.id.button_false);
        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!questionList.get(questionIndex).isTrue()){
                    generateToast("You are right");
                }
                else {
                    generateToast("You are wrong");
                }
            }
        });

        mButtonNext = (Button) findViewById(R.id.button_next);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionIndex = (questionIndex + 1) % questionList.size();
                updateQuestion(questionIndex);
            }
        });

        mButtonPrevious = (Button) findViewById(R.id.button_previous);
        mButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionIndex -= 1;
                if(questionIndex < 0) {
                    questionIndex = 0;
                }
                updateQuestion(questionIndex);
            }
        });
    }

    private void generateToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion(int questionIndex) {
        mTextQuestion.setText(questionList.get(questionIndex).getQuestion());
    }

    private void setQuestions() {
        questionList = this.questionBank.getQuestions();
    }
}
