package com.lim1t.csq.presentation;

import com.lim1t.csq.application.CsQuestionService;
import com.lim1t.csq.domain.CsQuestion;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cs-questions")
public class CsQuestionController {

    private final CsQuestionService csQuestionService;

    public CsQuestionController(CsQuestionService csQuestionService) {
        this.csQuestionService = csQuestionService;
    }

    @PostMapping
    public void uploadQuestion(@RequestBody CsQuestion csQuestion) {
        csQuestionService.saveCsQuestion(csQuestion);
    }

    @GetMapping("/{id}")
    public CsQuestion getQuestion(@PathVariable String id) {
        return csQuestionService.getCsQuestionById(id);
    }

    @GetMapping
    public List<CsQuestion> getAllQuestions() {
        return csQuestionService.getAll();
    }

    @GetMapping("/random")
    public List<CsQuestion> getRandomQuestions(@RequestParam("limit") Integer limit) {
        return csQuestionService.getRandomCsQuestion(limit);
    }
}
