package coursework2.course2;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Repository ("javaQuest")
public class JavaQuestionRepository implements QuestionRepository {
    private ArrayList<Question> javaQuestionList;

    public JavaQuestionRepository() {
        this.javaQuestionList = new ArrayList<>();

        javaQuestionList.add(new Question("1", "1"));
        javaQuestionList.add(new Question("2", "2"));
        javaQuestionList.add(new Question("3", "3"));
        javaQuestionList.add(new Question("4", "4"));
        javaQuestionList.add(new Question("5", "5"));
        javaQuestionList.add(new Question("6", "6"));
        javaQuestionList.add(new Question("7", "7"));
    }

    @PostConstruct
    public void init() {
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
