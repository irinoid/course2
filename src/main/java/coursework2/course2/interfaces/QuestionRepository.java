package coursework2.course2.interfaces;

import coursework2.course2.model.Question;

import java.util.Set;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Set<Question> getAll();
}
