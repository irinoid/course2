package coursework2.course2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private ArrayList<Question> javaQuestionList;
    final Random random = new Random();

    public JavaQuestionService() {
        this.javaQuestionList = new ArrayList<>();

        javaQuestionList.add(new Question("1", "1"));
        javaQuestionList.add(new Question("2", "2"));
        javaQuestionList.add(new Question("3", "3"));
        javaQuestionList.add(new Question("4", "4"));
        javaQuestionList.add(new Question("5", "5"));
        javaQuestionList.add(new Question("6", "6"));
        javaQuestionList.add(new Question("7", "7"));

    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (javaQuestionList.contains(newQuestion)) {
            throw new QuestionExistException();
        }
        javaQuestionList.add(newQuestion);
        return newQuestion;
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
    public Collection<Question> getAll() {
        return new ArrayList<>(javaQuestionList);
    }

    @Override
    public Question getRandom() {
        return javaQuestionList.get(random.nextInt(javaQuestionList.size()));
    }
}
