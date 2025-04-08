package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.QuestionRepository;
import com.faculdade.tcc.domain.dtos.QuestionDTO;
import com.faculdade.tcc.domain.question.Question;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void saveQuestion(Question question){
        this.saveQuestion(question);
    }

    public Question createUser(QuestionDTO data){
        Question newQuestion = new Question(data);
        this.saveQuestion(newQuestion);
        return newQuestion;
    }

    public List<Question> findAllQuestion(){
      return this.questionRepository.findAll();
    }
    public void findById(Long id) throws Exception {
        this.questionRepository.findById(id).orElseThrow(() -> new Exception("Question not found"));
    }

    public void deleteQuestionById(Long id){
        this.questionRepository.deleteById(id);
    }
}
