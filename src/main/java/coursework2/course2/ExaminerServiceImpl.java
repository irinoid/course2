package coursework2.course2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Random random = new Random();

    @Qualifier("java")
    private final QuestionService javaQuestionService;

    @Qualifier("math")
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService, @Qualifier("math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> javaRandomQuestionList = new HashSet<>();
        return getRandomQuestionList(amount, javaRandomQuestionList, javaQuestionService);
    }

    public Collection<Question> getMathQuestions(int amount) {
        Collection<Question> mathRandomQuestionList = new HashSet<>();
        return getRandomQuestionList(amount, mathRandomQuestionList, mathQuestionService);
    }

    private Collection<Question> getRandomQuestionList(int amount, Collection<Question> List, QuestionService service) {
        while (List.size() != amount) {
            Question newRandomQuestion = service.getRandomQuestion();
            List.add(newRandomQuestion);
        }
        return List;
    }

    @Override
    public Collection<Question> getRandomQuestions(int amount) {
        Collection<Question> javaRandomQuestionList = new ArrayList<>();
        int javaQuestionNumber = random.nextInt(amount + 1);
        int mathQuestionNumber = amount - javaQuestionNumber;
        javaRandomQuestionList.addAll(getQuestions(javaQuestionNumber));
        javaRandomQuestionList.addAll(getMathQuestions(mathQuestionNumber));
        return javaRandomQuestionList;
    }
}
