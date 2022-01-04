package coursework2.course2;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
    Collection<Question> getRandomQuestions(int amount);
}
