package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.annotation.JiraIssue;
import guru.qa.annotation.Layer;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("oleynik")
@Story("home and walkthrough")
@Layer("mobile")
class WikiTests extends TestBase {

    SelenideElement textView = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            continueButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            getStartedButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            searchContainer = $(MobileBy.id("org.wikipedia.alpha:id/search_container"));


    @Test
    @Tag("mobile")
    @JiraIssue("HOMEWORK-315")
    @DisplayName("Pass walkthrough")
    @Feature("walkthrough")
    void shouldPassWalkThrough() {
        step("Check text on first step", () -> {
            textView.shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click continue button and check text on second step", () -> {
            continueButton.click();
            textView.shouldHave(text("New ways to explore"));
        });

        step("Click continue button and check text on third step", () -> {
            continueButton.click();
            textView.shouldHave(text("Reading lists with sync"));
        });

        step("Click continue button and check text on fourth step", () -> {
            continueButton.click();
            textView.shouldHave(text("Send anonymous data"));
        });

        step("Click Get Started button and verify search input present", () -> {
            getStartedButton.click();
            searchContainer.shouldBe(visible);
        });
    }

    @Test
    @Tag("mobile")
    @JiraIssue("HOMEWORK-315")
    @DisplayName("Search by query")
    @Feature("search")
    void shouldSearch() {
        step("Wait fist step loaded", () -> {
            textView.shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Skip walkthrough", () -> {
            back();
        });

        step("Click to search input and type query", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Verify more than one result present", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
    }
}
