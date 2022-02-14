package coursework2.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("math")
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();

    private QuestionRepository mathQuestionRepository;

    public MathQuestionService( @Qualifier("mathQuest") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        mathQuestionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Set<Question> getAll() {
        return new HashSet<>(mathQuestionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(mathQuestionRepository.getAll());
        int listSize = list.size();
        return list.get(random.nextInt(listSize));
    }
}
