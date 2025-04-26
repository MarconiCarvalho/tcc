package com.faculdade.tcc.service;


import com.faculdade.tcc.Repositories.QuestionnaireRepository;
import com.faculdade.tcc.domain.dtos.requests.QuestionnaireRequestDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.domain.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionnarieService  {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private UserService userService;

    public void saveQuestionnarie(Questionnaire questionnaire){
        this.questionnaireRepository.save(questionnaire);
    }

    public Questionnaire createQuestionnarie(QuestionnaireRequestDTO questionnarieDTO) throws Exception {

        Questionnaire newQuestionnarie = new Questionnaire(questionnarieDTO);
        newQuestionnarie.setCreateAt(LocalDateTime.now());
        return questionnaireRepository.save(newQuestionnarie);

    }

    public Questionnaire updateQuestionnaire(UUID id, QuestionnaireRequestDTO questionnaireRequestDTO) throws Exception {

        Questionnaire newQuestionnaire = (Questionnaire) questionnaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Questionnaire id not found"));

        newQuestionnaire.setTitle(questionnaireRequestDTO.title());
        newQuestionnaire.setDescription(questionnaireRequestDTO.description());
        newQuestionnaire.setUpdateBy(questionnaireRequestDTO.updateBy());
        newQuestionnaire.setUpdateAt(LocalDateTime.now());
        return questionnaireRepository.save(newQuestionnaire);
    }
    public List<Questionnaire> findAllQuestionnarie(){
        return this.questionnaireRepository.findAll();
    }


    public Questionnaire findById(UUID id){
        return questionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questionnaire not  found"));
    }

    @Transactional
    public boolean deleteQuestionnarie(UUID id){
        if(questionnaireRepository.existsById(id)){
            questionnaireRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
