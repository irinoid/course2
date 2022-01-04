package coursework2.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("java")
public class JavaQuestionService implements QuestionService {
    final Random random = new Random();
    @Autowired
    @Qualifier("javaQuest")
    private QuestionRepository javaQuestionRepository;

    public JavaQuestionService( @Qualifier("javaQuest")QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (javaQuestionRepository.getAll().contains(newQuestion)) {
            throw new QuestionExistException();
        }
        javaQuestionRepository.getAll().add(newQuestion);
        return newQuestion;
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
    public Question getRandom() {
        return javaQuestionRepository.getAll().get(random.nextInt(javaQuestionRepository.getAll().size()));
    }
}
