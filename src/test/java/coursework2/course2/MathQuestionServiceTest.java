package coursework2.course2;

import coursework2.course2.exception.QuestionExistException;
import coursework2.course2.exception.QuestionNotFoundException;
import coursework2.course2.repository.MathQuestionRepository;
import coursework2.course2.service.MathQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static coursework2.course2.ConstantsForTests.*;
import static coursework2.course2.ConstantsForTests.TEST_LIST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    private MathQuestionService out;

    @Test
    public void shouldReturnCorrectAddQuestion() {
        when(mathQuestionRepository.getAll())
                .thenReturn(TEST_LIST);
        assertEquals(QUESTION_1, out.add(JAVA_QUESTION_1, JAVA_ANSWER_1));
    }

    @Test
    public void shouldReturnExceptionWhenQuestionExist() {
        when(mathQuestionRepository.getAll())
                .thenReturn(TEST_LIST);
        assertThrows(QuestionExistException.class, () -> out.add(JAVA_QUESTION_3, JAVA_ANSWER_3));
    }

    @Test
    public void shouldReturnQuestion1WhenAddQuestion1() {
        when(mathQuestionRepository.add(QUESTION_1))
                .thenReturn(QUESTION_1);
        assertEquals(QUESTION_1, out.add(QUESTION_1));
    }
    @Test
    public void shouldReturnRemoveQuestion2WhenRemoveQuestion2() {
        when(mathQuestionRepository.remove(QUESTION_2))
                .thenReturn(QUESTION_2);
        assertEquals(QUESTION_2, out.remove(QUESTION_2));
    }
    @Test
    public void shouldNotFoundExceptionWhenRemoveQuestion3() {
        when(mathQuestionRepository.remove(QUESTION_3))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_3));
    }

    @Test
    public void shouldReturnTestListWhenGetAll() {
        when(mathQuestionRepository.getAll())
                .thenReturn(TEST_LIST);
        assertEquals(TEST_LIST, out.getAll());
    }

}