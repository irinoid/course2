package coursework2.course2;

import coursework2.course2.exception.QuestionExistException;
import coursework2.course2.exception.QuestionNotFoundException;
import coursework2.course2.repository.JavaQuestionRepository;
import coursework2.course2.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static coursework2.course2.ConstantsForTests.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void shouldReturnCorrectAddQuestion() {
        when(javaQuestionRepository.getAll())
                .thenReturn(TEST_LIST);
        assertEquals(QUESTION_1, out.add(JAVA_QUESTION_1, JAVA_ANSWER_1));
    }

    @Test
    public void shouldReturnExceptionWhenQuestionExist() {
        when(javaQuestionRepository.getAll())
                .thenReturn(TEST_LIST);
        assertThrows(QuestionExistException.class, () -> out.add(JAVA_QUESTION_3, JAVA_ANSWER_3));
    }

    @Test
    public void shouldReturnQuestion1WhenAddQuestion1() {
        when(javaQuestionRepository.add(QUESTION_1))
                .thenReturn(QUESTION_1);
        assertEquals(QUESTION_1, out.add(QUESTION_1));
    }

    @Test
    public void shouldReturnRemoveQuestion2WhenRemoveQuestion2() {
        when(javaQuestionRepository.remove(QUESTION_3))
                .thenReturn(QUESTION_3);
        assertEquals(QUESTION_3, out.remove(QUESTION_3));
    }

    @Test
    public void shouldNotFoundExceptionWhenRemoveQuestion3() {
        when(javaQuestionRepository.remove(QUESTION_6))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_6));
    }

    @Test
    public void shouldReturnTestListWhenGetAll() {
        when(javaQuestionRepository.getAll())
                .thenReturn(TEST_LIST);
        assertEquals(TEST_LIST, out.getAll());
    }

}