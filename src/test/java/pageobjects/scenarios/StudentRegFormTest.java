package pageobjects.scenarios.scenarios;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegFormTest {
    StudentRegFormPage StudentRegFormPage = new StudentRegFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

    }
    @Test
    void homeWork() {
        StudentRegFormPage.openPage();
        StudentRegFormPage.fillForm();
        StudentRegFormPage.checkData();

    }

}
