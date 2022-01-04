package coursework2.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RequestMapping("/exam")
@RestController
public class MathQuestionController {
    @Autowired
    @Qualifier("math")
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("math")QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/math/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/math/remove")
    public Question deleteEmployee(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping("/math")
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }
}
