package coursework2.course2;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Question question1 = (Question) other;
        return question.equals(question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question);
    }

    @Override
    public String toString() {
        return question;
    }
}
