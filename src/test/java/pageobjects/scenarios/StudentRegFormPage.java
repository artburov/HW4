package pageobjects.scenarios.scenarios;


import com.github.javafaker.Faker;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegFormPage {
    Faker faker = new Faker();

    String name = faker.name().firstName(),
            lastname = faker.name().lastName(),
            useremail = faker.internet().emailAddress(),
            userphone = faker.number().digits(10),
            useraddress = faker.address().streetAddress();

    public void openPage() {

        open("https://demoqa.com/automation-practice-form");
    }

    public void fillForm() {
        $("#firstName").val(name);
        $("#lastName").val(lastname);
        $("#userEmail").val(useremail);
        $(byText("Female")).click();
        $("#userNumber").val(userphone);
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
        $("#currentAddress").val(useraddress);
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

    }

    public void checkData() {
        $(".modal-content").shouldHave(
                text(name),
                text(lastname),
                text(useremail),
                text("Female"),
                text(userphone),
                text("04 March,1964"),
                text("Chemistry, History"),
                text("Reading"),
                text("ScarletWitch.jpg"),
                text(useraddress),
                text("Haryana"),
                text("Karnal"));

    }
}
