package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.QuestionRepository;
import com.faculdade.tcc.domain.dtos.requests.QuestionRequestDTO;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.domain.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnarieService questionnaireService;
    @Autowired
    private UserService userService;

    public void saveQuestion(Question question){
        this.questionRepository.save(question);
    }

    public Question createQuestion(QuestionRequestDTO questionRequestDTO) throws Exception {
        Question newQuestion = new Question(questionRequestDTO);
        newQuestion.setCreateAt(LocalDateTime.now());
        return questionRepository.save(newQuestion);
    }
    public Question updateQuestion(UUID id,QuestionRequestDTO questionRequestDTO){
        Question newQuestion = (Question) questionRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));

        if(questionRequestDTO.idQuestionnaire() != null){
           newQuestion.setIdQuestionnaire(questionRequestDTO.idQuestionnaire());
        }

        newQuestion.setUpdateBy(questionRequestDTO.updateBy());
        newQuestion.setUpdateAt(LocalDateTime.now());
        newQuestion.setDescription(questionRequestDTO.description());
        newQuestion.setIdOrder(questionRequestDTO.idOrder());
        return questionRepository.save(newQuestion);
    }

    public List<Question> findAllQuestion(){
      return this.questionRepository.findAll();
    }

    public Question findById(UUID id) {
       return (Question) this.questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
        }

    @Transactional
    public boolean deleteQuestionById(UUID id){
        if( questionRepository.existsById(id)){
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
