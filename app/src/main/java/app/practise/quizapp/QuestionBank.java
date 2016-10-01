package app.practise.quizapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 192.168.3.22 on 18-Sep-16.
 */
public class QuestionBank {
    private ArrayList<Question> questionsList;

    QuestionBank(){
        questionsList = new ArrayList<Question>();
    }

    public ArrayList<Question> getQuestions(){
        initializeQuestionList();
        return questionsList;
    }

    private void initializeQuestionList() {
        questionsList.add(new Question(R.string.question_1, false));
        questionsList.add(new Question(R.string.question_2, true));
        questionsList.add(new Question(R.string.question_3, true));
        questionsList.add(new Question(R.string.question_4, false));
    }

}
