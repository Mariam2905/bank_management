package com.example.services.validation;

import com.example.entity.enums.CardType;
import com.example.repository.CardRepository;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class Validation {

    private CardRepository cardRepository;

    Random random = new Random();

    public String cardValidation(String type) {
        StringBuilder stringBuilder = new StringBuilder();
        String cartType = "";
        int length = 0;
        switch (CardType.valueOf(type)) {
            case VISA:
                cartType = "4";
                length = 15;
                break;
            case MASTER_CARD:
                cartType = String.valueOf(random.nextInt(51, 56));
                length = 14;
                break;
            case AMERICAN_EXPRESS:
                cartType = String.valueOf(random.nextInt(34, 38));
                length = 13;
        }
        stringBuilder.append(cartType);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(9));
        }
        return stringBuilder.toString();
    }


    public String validateDate() {
        Format f = new SimpleDateFormat("MM/yy");
        StringBuilder sb = new StringBuilder();
        sb.append(f.format(new Date()));
        int date = Integer.parseInt(sb.substring(sb.length() - 2)) + 5;
        return sb.replace(sb.length() - 2, sb.length(), Integer.toString(date)).toString();
    }

    public String cvcValidation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(random.nextInt(9));
        }
        return stringBuilder.toString();
    }

    public String pinValidation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(random.nextInt(9));
        }
        return stringBuilder.toString();
    }




    public boolean isNumeric(String pin) {
        String regex = "[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(pin).matches();

    }
}
