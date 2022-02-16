package coursework2.course2.service;

import coursework2.course2.interfaces.QuestionService;
import coursework2.course2.interfaces.QuestionRepository;
import coursework2.course2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("java")
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();

    @Qualifier("javaQuest")
    private QuestionRepository javaQuestionRepository;

    public JavaQuestionService( @Qualifier("javaQuest")QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        /*if (javaQuestionRepository.getAll().contains(newQuestion)) {
            throw new QuestionExistException();
        }
        javaQuestionRepository.getAll().add(newQuestion);
        return newQuestion;*/
        return javaQuestionRepository.add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(javaQuestionRepository.getAll());
        int listSize = list.size();
        return list.get(random.nextInt(listSize));
    }
}
