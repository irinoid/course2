package coursework2.course2;

import java.util.Set;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Set<Question> getAll();
}
