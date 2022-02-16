package coursework2.course2.interfaces;

import coursework2.course2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
    Collection<Question> getRandomQuestions(int amount);
}
