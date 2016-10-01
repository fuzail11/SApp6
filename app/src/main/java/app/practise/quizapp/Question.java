package app.practise.quizapp;

/**
 * Created by 192.168.3.22 on 18-Sep-16.
 */
public class Question {
    private int question;
    private boolean isTrue;

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        this.isTrue = aTrue;
    }

    Question(int question, boolean isTrue) {
        setQuestion(question);
        setTrue(isTrue);
    }
}
