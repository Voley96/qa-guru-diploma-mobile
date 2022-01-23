package guru.qa.tests;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


class AndroidAppiumSelenideTests extends TestBase {

    SelenideElement textView = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            continueButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            getStartedButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            searchContainer = $(MobileBy.id("org.wikipedia.alpha:id/search_container"));


    @Test
    void shouldPassWalkThrough() {
        textView.shouldHave(text("The Free Encyclopedia …in over 300 languages"));

        continueButton.click();
        textView.shouldHave(text("New ways to explore"));

        continueButton.click();
        textView.shouldHave(text("Reading lists with sync"));

        continueButton.click();
        textView.shouldHave(text("Send anonymous data"));

        getStartedButton.click();

        searchContainer.shouldBe(visible);
    }
}
