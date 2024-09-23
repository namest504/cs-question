package com.lim1t.csq.application;

import com.lim1t.csq.domain.CsQuestionRepository;
import com.lim1t.csq.domain.CsQuestion;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CsQuestionService {

    private final CsQuestionRepository csQuestionRepository;

    public CsQuestionService(CsQuestionRepository csQuestionRepository) {
        this.csQuestionRepository = csQuestionRepository;
    }

    public void saveCsQuestion(CsQuestion csQuestion) {
        csQuestionRepository.saveCsQuestion(csQuestion);
    }

    public CsQuestion getCsQuestionById(String csQuestionId) {
        return csQuestionRepository.findCsQuestionById(csQuestionId);
    }

    public List<CsQuestion> getAll() {
        return csQuestionRepository.findAll();
    }

    public List<CsQuestion> getRandomCsQuestion(Integer limit) {
        return csQuestionRepository.getRandomCsQuestions(limit);
    }

    public void updateCsQuestion(CsQuestion csQuestion) {
        csQuestionRepository.updateCsQuestion(csQuestion);
    }

    public void deleteCsQuestion(String csQuestionId) {
        csQuestionRepository.deleteCsQuestion(csQuestionId);
    }
}
