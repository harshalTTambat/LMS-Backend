package com.LMSbackend.LMS_backendApplication.Service;

import com.LMSbackend.LMS_backendApplication.Enums.CardStatus;
import com.LMSbackend.LMS_backendApplication.Models.Card;
import com.LMSbackend.LMS_backendApplication.Models.Student;
import com.LMSbackend.LMS_backendApplication.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card createCard(Student student){

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        //link student with a new card
        card.setStudent(student);
        student.setCard(card);

        cardRepository.save(card);
        return card;
    }

    public void deactivateCard(int student_id){
        cardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}
