package com.faculdade.tcc.service;


import com.faculdade.tcc.Repositories.QuestionnarieRepository;
import com.faculdade.tcc.Repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.requests.QuestionnaireRequestDTO;
import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
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
    private QuestionnarieRepository questionnarieRepository;
    @Autowired
    private UserService userService;

    public void saveQuestionnarie(Questionnaire questionnarie){
        this.questionnarieRepository.save(questionnarie);
    }

    public Questionnaire createQuestionnarie(QuestionnaireRequestDTO questionnarieDTO) throws Exception {
        Questionnaire newQuestionnarie = new Questionnaire();

        newQuestionnarie.setTitle(questionnarieDTO.title());
        newQuestionnarie.setDescription(questionnarieDTO.description());

        User creator = (User) userService.findUserById(questionnarieDTO.createBy());
        User updater = (User) userService.findUserById(questionnarieDTO.updateBy());
        newQuestionnarie.setCreateBy(creator);
        newQuestionnarie.setUpdateBy(updater);
        newQuestionnarie.setCreateAt(LocalDateTime.now());
        newQuestionnarie.setUpdateAt(LocalDateTime.now());
        return this.questionnarieRepository.save(newQuestionnarie);

    }

    public Questionnaire updateQuestionnaire(UUID id, QuestionnaireRequestDTO questionnaireRequestDTO) throws Exception {
        Questionnaire questionnaire = (Questionnaire) questionnarieRepository.findById(id).orElseThrow(() -> new RuntimeException("Questionnaire id not found"));

       User updater = (User) userService.findUserById(questionnaireRequestDTO.updateBy());
        questionnaire.setTitle(questionnaireRequestDTO.title());
        questionnaire.setDescription(questionnaireRequestDTO.description());
        questionnaire.setUpdateBy(updater);
        questionnaire.setUpdateAt(LocalDateTime.now());
        return questionnarieRepository.save(questionnaire);
    }
    public List<Questionnaire> findAllQuestionnarie(){
        return this.questionnarieRepository.findAll();
    }


    public Questionnaire findById(UUID id){
        return (Questionnaire) this.questionnarieRepository.findById(id).orElseThrow(() -> new RuntimeException("Questionnaire found found"));
    }

    @Transactional
    public boolean deleteQuestionnarie(UUID id){
        if(questionnarieRepository.existsById(id)){
            questionnarieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
