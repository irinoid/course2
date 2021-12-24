package coursework2.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static coursework2.course2.ConstantsForTests.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();
    @Test
    public void shouldReturnCorrectAddQuestion() {
        Question result = out.add(JAVA_QUESTION_1, JAVA_ANSWER_1);
        Assertions.assertEquals(result, QUESTION_1);
    }

    @Test
    public void shouldReturnExceptionWhenQuestionExist() {
        Assertions.assertThrows(QuestionExistException.class,
                () -> out.add(JAVA_QUESTION_2, JAVA_ANSWER_2)
        );
    }

    @Test
    public void shouldReturnQuestion1WhenAddQuestion1() {
        Question result = out.add(QUESTION_1);
        Assertions.assertEquals(result, QUESTION_1);
    }

    @Test
    public void shouldReturnException1WhenQuestion1Exist() {
        Assertions.assertThrows(QuestionExistException.class,
                () -> out.add(QUESTION_2)
        );
    }

    @Test
    public void shouldReturnRemoveQuestion2WhenRemoveQuestion2() {
        Question result = out.remove(QUESTION_2);
        Assertions.assertEquals(result, QUESTION_2);
    }

    @Test
    public void shouldReturnNotFoundWhenRemoveQuestionNotExist() {
        Assertions.assertThrows(QuestionNotFoundException.class,
                () -> out.remove(QUESTION_1)
        );
    }
}