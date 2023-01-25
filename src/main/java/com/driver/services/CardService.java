package com.driver.services;

import com.driver.models.Student;
import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.repositories.CardRepository;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository3;
    @Autowired
    private StudentRepository studentRepository;

    public Card createAndReturn(Student student){
        Card card=Card.builder().
                        cardStatus(CardStatus.ACTIVATED).
                        student(student).build();
        //link student with a new card
        student.setCard(card);
        return card;
    }

    public void deactivateCard(int student_id){
        cardRepository3.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
//        studentRepository.deleteById(student_id);
    }
}
