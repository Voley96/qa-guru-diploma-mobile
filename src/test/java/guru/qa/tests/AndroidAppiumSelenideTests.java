package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


public class AndroidAppiumSelenideTests extends TestBase {

    @Test
    void shouldSearch() {
        step("Type BrowserStack in search query", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Verify text view size greater than 0", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    void shouldHaveTextWhenEmptyArticles() {
        step("Click to history tab", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/icon")).get(2).click();
        });

        step("Verify text is present", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/history_empty_title"))
                    .shouldHave(Condition.text("No recently viewed articles"));
        });
    }
}
