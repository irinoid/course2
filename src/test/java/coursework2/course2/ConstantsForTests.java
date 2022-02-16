package coursework2.course2;

import coursework2.course2.model.Question;

import java.util.*;

public class ConstantsForTests {
    public static final String JAVA_QUESTION_1 = "Java_Question_Test1";
    public static final String JAVA_ANSWER_1 = "Java_Answer_Test1";
    public static final Question QUESTION_1 = new Question(JAVA_QUESTION_1, JAVA_ANSWER_1);
    public static final String JAVA_QUESTION_2 = "2";
    public static final String JAVA_ANSWER_2 = "2";
    public static final Question QUESTION_2 = new Question(JAVA_QUESTION_2, JAVA_ANSWER_2);
    public static final String JAVA_QUESTION_6 = "2+2";
    public static final String JAVA_ANSWER_6 = "4";
    public static final Question QUESTION_6 = new Question(JAVA_QUESTION_6, JAVA_ANSWER_6);

    public static final String JAVA_QUESTION_3 = "Java_Question_Test3";
    public static final String JAVA_ANSWER_3 = "Java_Answer_Test3";
    public static final String JAVA_QUESTION_4 = "Java_Question_Test4";
    public static final String JAVA_ANSWER_4 = "Java_Answer_Test4";
    public static final String JAVA_QUESTION_5 = "Java_Question_Test5";
    public static final String JAVA_ANSWER_5 = "Java_Answer_Test5";

    public static final Question QUESTION_3 = new Question(JAVA_QUESTION_3, JAVA_ANSWER_3);

    public static final Set<Question> TEST_LIST = new HashSet<>(List.of(new Question(JAVA_QUESTION_3, JAVA_ANSWER_3),
            new Question(JAVA_QUESTION_4, JAVA_ANSWER_4),
            new Question(JAVA_QUESTION_5, JAVA_ANSWER_5)));


}
