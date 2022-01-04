package coursework2.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static coursework2.course2.ConstantsForTests.*;
import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private final MathQuestionRepository out = new MathQuestionRepository();

    @Test
    public void shouldReturnQ1WhenQ1Added() {
        Question result = out.add(QUESTION_1);
        Assertions.assertEquals(result, QUESTION_1);
    }

    @Test
    public void shouldReturnExceptionWhenQ3Added() {
        out.add(QUESTION_3);
        Assertions.assertThrows(QuestionExistException.class,
                () -> out.add(QUESTION_3)
        );
    }

    @Test
    public void shouldReturnQ2WhenQ2Removed() {
        Question result = out.remove(QUESTION_6);
        Assertions.assertEquals(result, QUESTION_6);
    }

    @Test
    public void shouldReturnExceptionWhenQ3Removed() {
        Assertions.assertThrows(QuestionNotFoundException.class,
                () -> out.remove(QUESTION_1)
        );
    }

    @Test
    public void getListOfAllJavaQuestions() {
        ArrayList<Question> result = out.getAll();
        Assertions.assertEquals(result, out.getAll());
    }

}