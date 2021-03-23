package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void fullScreen() {
        Configuration.startMaximized = true;
    }

    @Test
    public void dragAndDrop() {
        //перейти на сайт the-internet.herokuapp.com
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //перенести прямоугольник А на место прямоугольника В
        $("#column-a").dragAndDropTo($("#column-b"));

        //проверить, что прямоугольник А стоит на месте прямоугольника В
        $("#column-a").shouldHave(text("B"));
        // проверить, что прямоугольник В стоит на месте прямоугольника А
        $("#column-b").shouldHave(text("A"));
    }
}
