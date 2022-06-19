package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import java.time.Duration;

public class DashboardPage {
    private final SelenideElement paymentButton = $$("button").find(exactText("Купить"));
    private final SelenideElement creditButton = $$("button").find(exactText("Купить в кредит"));
    private final SelenideElement payCard = $$("h3").find(text("Оплата по карте"));
    private final SelenideElement payCredit = $$("h3").find(text("Кредит по данным карты"));

    public PaymentPage payByDebitCard() {
        paymentButton.click();
        payCard.shouldBe(visible);
        return new PaymentPage();
    }

    public PaymentPage payByCreditCard() {
        creditButton.click();
        payCredit.shouldBe(visible);
        return new PaymentPage();
    }
}
