package com.faculdade.tcc.service;


import com.faculdade.tcc.Repositories.QuestionnarieRepository;
import com.faculdade.tcc.domain.dtos.QuestionDTO;
import com.faculdade.tcc.domain.dtos.QuestionnarieDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnarie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnarieService  {

    @Autowired
    private QuestionnarieRepository questionnarieRepository;

    public void saveQuestionnarie(Questionnarie questionnarie){
        this.questionnarieRepository.save(questionnarie);
    }

    public Questionnarie createQuestionnarie(QuestionnarieDTO questionnarieDTO){
        Questionnarie newQuestionnarie = new Questionnarie(questionnarieDTO);
        this.questionnarieRepository.save(newQuestionnarie);
        return newQuestionnarie;
    }

    public List<Questionnarie> findAllQuestionnarie(){
        return this.questionnarieRepository.findAll();
    }

    public Questionnarie findById(Long id){
      return  this.questionnarieRepository.findById(id).orElseThrow(() -> new RuntimeException("Questionnarie not found"));
    }

    public void deleteQuestionnarie(Long id){
        this.questionnarieRepository.findById(id);
    }
}
