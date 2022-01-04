package coursework2.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    final Random random = new Random();
    @Autowired
    @Qualifier("java")
    private final QuestionService javaQuestionService;
    @Autowired
    @Qualifier("math")
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaQuestionService, @Qualifier("math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> javaRandomQuestionList = new ArrayList<>();
        int i = 0;
        while (i < amount) {
            Question newRandomQuestion = javaQuestionService.getRandom();
            if (!javaRandomQuestionList.contains(newRandomQuestion)) {
                javaRandomQuestionList.add(newRandomQuestion);
                i++;
            }
        }
        return javaRandomQuestionList;
    }


    public Collection<Question> getMathQuestions(int amount) {
        Collection<Question> mathRandomQuestionList = new ArrayList<>();
        int i = 0;
        while (i < amount) {

            Question newRandomQuestion = mathQuestionService.getRandom();
            if (!mathRandomQuestionList.contains(newRandomQuestion)) {
                mathRandomQuestionList.add(newRandomQuestion);
                i++;
            }
        }
        return mathRandomQuestionList;
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
