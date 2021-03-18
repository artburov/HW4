import com.codeborne.selenide.Configuration;
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
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void homeWork() {
        open("https://demoqa.com/automation-practice-form");


        $("#firstName").setValue("Wanda");
        $("#lastName").setValue("Maximoff");
        $("#userEmail").setValue("ScarletWitch@avenger.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("9862010101");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1964");
        $("[aria-label='Choose Wednesday, March 4th, 1964']").click();
        $("#subjectsInput").setValue("Chemistry");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("History");
        $("#subjectsInput").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("ScarletWitch.jpg");
        $("#currentAddress").setValue("New York City");
        $("#react-select-3-input").setValue("Haryana");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Karnal");
        $("#react-select-4-input").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Wanda"),
                text("Maximoff"),
                text("ScarletWitch@avenger.com"),
                text("Female"),
                text("9862010101"),
                text("04 March,1964"),
                text("Chemistry, History"),
                text("Reading"),
                text("ScarletWitch.jpg"),
                text("New York City"),
                text("Haryana"),
                text("Karnal"));



    }
}
