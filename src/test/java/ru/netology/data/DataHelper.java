package ru.netology.data;

import lombok.Value;

public class DataHelper {
    static DataGenerator dateGenerator = new DataGenerator();

    @Value
    public static class CardInfo {
        String cardNumber;
        String year;
        String month;
        String owner;
        String cvc;
    }

    public static CardInfo getApprovedCardInformation() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(),
                dateGenerator.getValidExpirationDate().getYear(),
                dateGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(),
                DataGenerator.getValidCvc());
    }

    public static CardInfo getDeclinedCardInformation() {
        return new CardInfo(DataGenerator.getDeclinedCardNumber(),
                dateGenerator.getValidExpirationDate().getYear(),
                dateGenerator.getValidMonth().getMonth(),
                DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidCardInformation() {
        return new CardInfo(DataGenerator.getInvalidCardNumber(),
                dateGenerator.getValidExpirationDate().getYear(),
                dateGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(),
                DataGenerator.getValidCvc());
    }

    public static CardInfo getExpiredMonthCardInformation() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(),
                dateGenerator.getCurrentYear().getYear(),
                dateGenerator.getExpiredMonth().getMonth(),
                DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getExpiredYearCardInformation() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(),
                dateGenerator.getExpiredYear().getYear(),
                dateGenerator.getValidMonth().getMonth(),
                DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidExpirationDateCardInformation() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(),
                dateGenerator.getInvalidExpirationDate().getYear(),
                dateGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(),
                DataGenerator.getValidCvc());
    }

    public static CardInfo getEmptyCardInformation() {
        return new CardInfo(" ", " ", " ", " ", " ");
    }

    public static CardInfo getValidCardNumberWithInvalidOtherFields() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(),
                dateGenerator.getInvalidYear().getYear(),
                dateGenerator.getInvalidMonth().getMonth(),
                DataGenerator.getInvalidOwner(), DataGenerator.getInvalidCvc());
    }

    public static CardInfo getInvalidOwnerCard() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(),
                dateGenerator.getValidExpirationDate().getYear(),
                dateGenerator.getValidMonth().getMonth(),
                DataGenerator.getInvalidOwner(),
                DataGenerator.getValidCvc());
    }
}
