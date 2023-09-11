package com.example.services;

import com.example.entity.CardEntity;
import com.example.entity.enums.CardStatus;
import com.example.entity.enums.Currency;
import com.example.model.CardModel;
import com.example.repository.CardRepository;
import com.example.services.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    Validation validation = new Validation();

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    public void createCard(CardModel card){
        String cardNumber = validation.cardValidation(card.getType());
        while (true) {
            if (cardRepository.findCardEntityByCardNumber(cardNumber).isPresent()) {
                cardNumber = validation.cardValidation(cardNumber);
            } else break;
        }




        card.setCardNumber(cardNumber);
        card.setType(card.getType());
        card.setExpirationDate(validation.validateDate());
        card.setCvcCode(validation.cvcValidation());
        card.setStatus(CardStatus.ACTIVE.toString());
        card.setPin(validation.pinValidation());
        card.setCurrency(Currency.valueOf(card.getCurrency()).toString());
        card.setDeleted(false);
        card.setExpirationDate(validation.validateDate());

        CardEntity cardEntity = new CardEntity(card.getCardNumber(),card.getType(),card.getBalance(),
                card.getExpirationDate(),card.getCvcCode(),
                card.getStatus(),card.getPin(),card.getCurrency(),card.getDeleted());

        cardRepository.save(cardEntity);
    }


    public Optional<CardEntity> getCard(String cardNumber){
        return cardRepository.findCardEntityByCardNumber(cardNumber);
    }


    public List<CardEntity> getAllCard(){
        return cardRepository.findAll();
    }


    public void updateIsDeleted(String cardNumber){
        cardRepository.updateIsDeleted(cardNumber);

    }

    public void deactivate(String cardNumber){
        cardRepository.deactivate(cardNumber);
    }

    public String activate(String cardNumber){
        Optional<CardEntity> cardEntity = cardRepository.findCardEntityByCardNumber(cardNumber);
        if (!cardEntity.get().getDeleted()){
            cardRepository.activate(cardNumber);
            return "";
        }
        return "Not valid card number";
    }

    public String block(String cardNumber){
        Optional<CardEntity> cardEntity = cardRepository.findCardEntityByCardNumber(cardNumber);
        if (!cardEntity.get().getDeleted()){
            cardRepository.block(cardNumber);
            return "";
        }
        return "Not valid card number";
    }


    public String changePin(String cardNumber,String newPin){
        Optional<CardEntity> cardEntity =  cardRepository.findCardEntityByCardNumber(cardNumber);
        if (validation.isNumeric(newPin)){
            cardEntity.get().setPin(newPin);
            cardRepository.save(cardEntity.get());
        }
        return "Your pin has been changed";
    }

/**
 public String updateStatus(String cardNumber, String status) {
 CardEntity cardEntity=cardRepository.findCardEntitiesByCardNumber(cardNumber);
 if (cardEntity.getDeleted()){
 return "Card has been deleted";
 }
 cardEntity.setStatus(CardStatus.valueOf(status.toUpperCase()).toString());
 cardRepository.save(cardEntity);
 return "Status updated";
 }
 */
}