package coursework2.course2.controller;

import coursework2.course2.interfaces.ExaminerService;
import coursework2.course2.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getRandomQuestions(@PathVariable int amount) {
        return examinerService.getRandomQuestions(amount);
    }
}
