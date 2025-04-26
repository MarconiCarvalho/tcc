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
        newAnswers.setCreateAt(LocalDateTime.now());
        this.answersRepository.save(newAnswers);
        return newAnswers;
    }

    public List<Answers> findAllAnswers(){
        return this.answersRepository.findAll();
    }

    public Answers findById(UUID id) throws Exception {
       return this.answersRepository.findById(id).orElseThrow(() -> new Exception("Answer not found"));
    }

    public Answers updateAnswers(UUID id, AnswersRequestDTO answersRequestDTO){
        Answers newAnswers = this.answersRepository.findById(id).orElseThrow(() -> new RuntimeException("Answers com ID: " + id + " not found"));

        newAnswers.setUserId(answersRequestDTO.userId());
        newAnswers.setIdQuestion(answersRequestDTO.idQuestion());
        newAnswers.setOption(answersRequestDTO.option());
        newAnswers.setCreateBy(answersRequestDTO.createBy());
        newAnswers.setCreateAt(LocalDateTime.now());
        return this.answersRepository.save(newAnswers);
    }

    public boolean deleteAnswers(UUID id){
        if(answersRepository.existsById(id)){
            this.answersRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
