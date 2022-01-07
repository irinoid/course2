package coursework2.course2;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Repository ("javaQuest")
public class JavaQuestionRepository implements QuestionRepository {
    private ArrayList<Question> javaQuestionList;

    public JavaQuestionRepository() {
        this.javaQuestionList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("1", "1"));
        add(new Question("2", "2"));
        add(new Question("3", "3"));
        add(new Question("4", "4"));
        add(new Question("5", "5"));
        add(new Question("6", "6"));
        add(new Question("7", "7"));

        System.out.println("This is from the init method java");
    }

    @Override
    public Question add(Question question) {
        if (!javaQuestionList.contains(question)) {
            javaQuestionList.add(question);
            return question;
        }
        throw new QuestionExistException();
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestionList.contains(question)) {
            javaQuestionList.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public ArrayList<Question> getAll() {
        return javaQuestionList;
    }
}
