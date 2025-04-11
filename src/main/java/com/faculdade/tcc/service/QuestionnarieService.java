package com.faculdade.tcc.service;


import com.faculdade.tcc.Repositories.QuestionnarieRepository;
import com.faculdade.tcc.domain.dtos.requests.QuestionnaireRequestDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnarieService  {

    @Autowired
    private QuestionnarieRepository questionnarieRepository;

    public void saveQuestionnarie(Questionnaire questionnarie){
        this.questionnarieRepository.save(questionnarie);
    }

    public Questionnaire createQuestionnarie(QuestionnaireRequestDTO questionnarieDTO){
        Questionnaire newQuestionnarie = new Questionnaire(questionnarieDTO);
        this.questionnarieRepository.save(newQuestionnarie);
        return newQuestionnarie;
    }

    public List<Questionnaire> findAllQuestionnarie(){
        return this.questionnarieRepository.findAll();
    }

    public Questionnaire findById(Long id){
      return  this.questionnarieRepository.findById(id).orElseThrow(() -> new RuntimeException("Questionnarie not found"));
    }

    public void deleteQuestionnarie(Long id){
        this.questionnarieRepository.findById(id);
    }
}
