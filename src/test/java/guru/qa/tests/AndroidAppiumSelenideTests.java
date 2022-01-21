package guru.qa.tests;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.*;


public class AndroidAppiumSelenideTests extends TestBase {

    SelenideElement textView = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"));
    SelenideElement continueButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Test
    void shouldPassWalkThrough() {
        textView.shouldHave(text("The Free Encyclopedia …in over 300 languages"));

        continueButton.click();
        textView.shouldHave(text("New ways to explore"));

        continueButton.click();
        textView.shouldHave(text("Reading lists with sync"));

        continueButton.click();
        textView.shouldHave(text("Send anonymous data"));

        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();

        $(MobileBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(visible);

        $(MobileBy.id("org.wikipedia.alpha:id/view_announcement_header_image")).shouldBe(visible);
    }
}
