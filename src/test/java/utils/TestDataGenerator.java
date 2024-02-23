package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestDataGenerator {


    public static String getRandomNumber(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }

        return stringBuilder.toString();
    }


    public static String getCharactersByNumbers(String number) {
        List<Integer> twoDigitNumbers = convertLongNumberToTwoDigitNumbersArray(number);

        StringBuilder result = new StringBuilder();

        for (Integer twoDigitNumber : twoDigitNumbers) {
            int num = twoDigitNumber % 26;
            char letter = (char) ('a' + num);
            result.append(letter);
        }

        return result.toString();
    }

    private static List<Integer> convertLongNumberToTwoDigitNumbersArray(String number) {
        List<String> result = new ArrayList<>();
        if (number.length() % 2 != 0) {
            number = number.substring(0, number.length() - 1) + "0" + number.charAt(number.length() - 1);
        }

        for (int i = 0; i < number.length(); i = i + 2) {
            result.add(number.substring(i, i + 2));
        }

        return result.stream().map(Integer::parseInt).collect(Collectors.toList());
    }


}
