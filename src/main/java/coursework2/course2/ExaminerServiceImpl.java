package coursework2.course2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> javaRandomQuestionList = new ArrayList<>();
        int i = 0;
        while (i < amount) {
            Question newRandomQuestion = questionService.getRandom();
            if (!javaRandomQuestionList.contains(newRandomQuestion)) {
                javaRandomQuestionList.add(newRandomQuestion);
                i++;
            }
        }
        return javaRandomQuestionList;
    }
}
