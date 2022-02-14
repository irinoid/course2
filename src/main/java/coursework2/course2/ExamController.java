package coursework2.course2;

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
