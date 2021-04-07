import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Selenide {

    LocalDate date = LocalDate.now();
    LocalDate meetingDate = date.plusDays(3);
    DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Test
    public void shouldSubmitRightRequest() {
        open("http://0.0.0.0:9999");
        $("[data-test-id=city] input").setValue("Кызыл");
        $("[data-test-id=date] input").doubleClick().sendKeys(dt.format(meetingDate));
        $("[data-test-id=name] input").setValue("Петрова Анна-Мария");
        $("[data-test-id=phone] input").setValue("+77777777777");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
    }
}
