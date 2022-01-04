package coursework2.course2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Repository("mathQuest")
public class MathQuestionRepository implements QuestionRepository{
    private ArrayList<Question> mathQuestionList;

    public MathQuestionRepository() {
        this.mathQuestionList = new ArrayList<>();

        mathQuestionList.add(new Question("1+1", "2"));
        mathQuestionList.add(new Question("2+2", "4"));
        mathQuestionList.add(new Question("3+3", "6"));
        mathQuestionList.add(new Question("4+4", "8"));
        mathQuestionList.add(new Question("5+5", "10"));
        mathQuestionList.add(new Question("6+6", "12"));
        mathQuestionList.add(new Question("7+7", "14"));
    }

    @PostConstruct
    public void init(){
        System.out.println("This is from the init method math");
    }


    public Question add(Question question) {
        if (!mathQuestionList.contains(question)) {
            mathQuestionList.add(question);
            return question;
        }
        throw new QuestionExistException();
    }

    public Question remove(Question question) {
        if (mathQuestionList.contains(question)) {
            mathQuestionList.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }

    public ArrayList<Question> getAll() {
        return mathQuestionList;
    }
}
