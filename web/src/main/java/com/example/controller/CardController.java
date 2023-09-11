package com.example.controller;

import com.example.entity.CardEntity;
import com.example.entity.enums.CardStatus;
import com.example.model.CardModel;
import com.example.services.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/get/{cardNumber}")
    public Optional<CardEntity> getCard(@PathVariable("cardNumber")String cardNumber){
        return cardService.getCard(cardNumber);
    }


    @GetMapping("/getAll")
    public List<CardEntity> getAll(){
        return cardService.getAllCard();
    }

    @PostMapping("/new")
    public void createCard(@RequestBody CardEntity cardEntity){
        CardModel cardModel = new CardModel();
        cardModel.setType(cardEntity.getType());
        cardModel.setCurrency(cardEntity.getCurrency());
        cardService.createCard(cardModel);
    }

    @DeleteMapping("/delete/{cardNumber}")
    public void updateIsDeleted(@PathVariable("cardNumber") String cardNumber){
        cardService.updateIsDeleted(cardNumber);
        cardService.deactivate(cardNumber);
    }

    @PutMapping("/activate/{cardNumber}")
    public String activate(@PathVariable("cardNumber") String cardNumber){
        return cardService.activate(cardNumber);
    }

    @PutMapping("/block/{cardNumber}")
    public String block(@PathVariable("cardNumber") String cardNumber){
        return  cardService.block(cardNumber);
    }

    @PutMapping("/deactivate/{cardNumber}")
    public void deactivate(@PathVariable("cardNumber") String cardNumber){
        cardService.deactivate(cardNumber);
    }

    @PutMapping("/change/{cardNumber}/{newPin}")
    public String changePin(@PathVariable String cardNumber,
                            @PathVariable String newPin) {
        return cardService.changePin(cardNumber, newPin);
    }


/**
 @GetMapping("/update/{cardNumber}/{status}")
 public String updateStatus(@PathVariable("cardNumber") String cardNumber, @PathVariable("status") String status) {
 return cardService.updateStatus(cardNumber,status);
 }
 */
}
