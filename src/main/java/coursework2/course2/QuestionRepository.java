package coursework2.course2;

import java.util.ArrayList;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    ArrayList<Question> getAll();
}
