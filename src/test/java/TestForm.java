package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {
    @BeforeAll
    static void fullScreen() {
        Configuration.startMaximized = true;
    }

    @Test
    public void exampleJUnit() {
        //открыть сайт GitHub
        open("https://github.com/");

        //найти Selenide
        $("[name=q]").setValue("selenide").pressEnter();

        //открыть страничку Selenide на сайте GitHub
        $(".repo-list").find(byText("selenide/")).click();

        //перейти в раздел Wiki проекта
        $("[data-content=Wiki]").click();

        //проверить,есть ли в списке страница SoftAssertions
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));

        //перейти к SoftAssertions
        $(".wiki-rightbar").find(byText("SoftAssertions")).click();
        //проверить, есть ли на странице пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
