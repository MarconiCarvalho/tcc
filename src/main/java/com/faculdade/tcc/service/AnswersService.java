package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.AnswersRepository;
import com.faculdade.tcc.domain.answers.Answers;
import com.faculdade.tcc.domain.dtos.requests.AnswersRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AnswersService {

    @Autowired
    private AnswersRepository answersRepository;

    public void saveAnswers(Answers answers){
        this.answersRepository.save(answers);
    }

    public Answers createAnswers(AnswersRequestDTO data){
        Answers newAnswers = new Answers(data);
        newAnswers.setUserId(data.userId());
        newAnswers.setCreateAt(LocalDateTime.now());
        this.saveAnswers(newAnswers);
        return newAnswers;
    }

    public List<Answers> findAllAnswers(){
        return this.answersRepository.findAll();
    }

    public Answers findById(UUID id) throws Exception {
       return this.answersRepository.findById(id).orElseThrow(() -> new Exception("Answer not found"));
    }

    public boolean deleteAnswers(UUID id){
        if(answersRepository.existsById(id)){
            this.answersRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
