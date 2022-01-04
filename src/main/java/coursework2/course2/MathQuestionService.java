package coursework2.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service("math")
public class MathQuestionService implements QuestionService {
    final Random random = new Random();

    @Autowired
    @Qualifier("mathQuest")
    private QuestionRepository mathQuestionRepository;

    public MathQuestionService( @Qualifier("mathQuest") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (mathQuestionRepository.getAll().contains(newQuestion)) {
            throw new QuestionExistException();
        }
        mathQuestionRepository.getAll().add(newQuestion);
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
    public ArrayList<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandom() {
        return mathQuestionRepository.getAll().get(random.nextInt(mathQuestionRepository.getAll().size()));
    }
}
