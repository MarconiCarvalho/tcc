package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.AnswersRepository;
import com.faculdade.tcc.domain.answers.Answers;
import com.faculdade.tcc.domain.dtos.requests.AnswersRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {

    @Autowired
    private AnswersRepository answersRepository;

    public void saveAnswers(Answers answers){
        this.answersRepository.save(answers);
    }

    public Answers createAnswers(AnswersRequestDTO data){
        Answers newAnswers = new Answers(data);
        this.answersRepository.save(newAnswers);
        return newAnswers;
    }

    public List<Answers> findAllAnswers(){
        return this.answersRepository.findAll();
    }

    public Answers findById(Long id) throws Exception {
       return this.answersRepository.findById(id).orElseThrow(() -> new Exception("Answer not found"));
    }

}
