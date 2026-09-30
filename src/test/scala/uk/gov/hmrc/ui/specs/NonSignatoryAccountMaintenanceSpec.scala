/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.*

class NonSignatoryAccountMaintenanceSpec extends BaseSpec {

  Feature("Non Signatory user features") {

    Scenario("1.Non Signatory user logs and change organisation details") {
      Given("Non Signatory user logs in")
      AuthLoginPage.loginAsEnrolledUser(
        "/manage-isas",
        "nonsignatory@example.com",
        "HMRC-DISA-ORG",
        "ZREF",
        "Z1234"
      )

      Then("Manage ISAs page is displayed")
      ManageIsasPage.verifyPageTitle(
        ManageIsasPage.pageTitle,
        ManageIsasPage.pageUrl
      ) shouldBe true

      Then("the user clicks on update information link")
      ManageIsasPage.clicksOnLinks("change-information")

      Then("Change information page is displayed")
      ChangeInformationPage.verifyPageTitle(
        ChangeInformationPage.pageTitle,
        ChangeInformationPage.pageUrl
      ) shouldBe true

      Then("the user clicks on view all information checkbox and then clicks on continue")
      ChangeInformationPage.selectViewAllCheckBox()
      ChangeInformationPage.clickContinue()

      Then("Change of circumstances page is displayed")
      ChangeOfCircumstancesPage.verifyPageTitle(
        ChangeOfCircumstancesPage.pageTitle,
        ChangeOfCircumstancesPage.pageUrl
      ) shouldBe true

      // Changing org details

      Then("the user clicks on change link for Change Trading name")
      ChangeOfCircumstancesPage.clicksOnLinks("trading-name")

      Then("Trading name page is displayed")
      OrganisationTradingNamePage.verifyPageTitle(
        OrganisationTradingNamePage.pageTitle,
        OrganisationTradingNamePage.pageUrl
      ) shouldBe true

      Then("the user enters the new trading name value and clicks on continue button")
      OrganisationTradingNamePage.enterText("value", "trading name new")
      OrganisationTradingNamePage.clickContinue()

      Then("the user clicks on change link for Organisation Address")
      ChangeOfCircumstancesPage.clicksOnLinks("enter-your-organisation-address")

      Then("Enter your organisation’s address page is displayed")
      EnterYourOrganisationAddressPage.verifyPageTitle(
        EnterYourOrganisationAddressPage.pageTitle,
        EnterYourOrganisationAddressPage.pageUrl
      ) shouldBe true

      When("User enters the address details and click on 'Continue' button")
      EnterYourOrganisationAddressPage.enterText("addressLine1", "Test address line 1")
      EnterYourOrganisationAddressPage.enterText("addressLine2", "Test address line 2")
      EnterYourOrganisationAddressPage.enterText("townOrCity", "London")
      EnterYourOrganisationAddressPage.enterText("postcode", "AA1 1AB")
      EnterYourOrganisationAddressPage.clickContinue()

      Then("the user clicks on change link for Organisation email")
      ChangeOfCircumstancesPage.clicksOnLinks("organisation-email-address")

      Then("the user is navigated to the 'Organisation email address' page")
      OrganisationEmailPage.verifyPageTitle(
        OrganisationEmailPage.pageTitle,
        OrganisationEmailPage.pageUrl
      ) shouldBe true

      Then("the user enters the email value and clicks on Save and continue button")
      OrganisationEmailPage.enterText("value", "codesent@sendcode.com")
      OrganisationEmailPage.clickContinue()

      Then("the user is navigated to the 'Email code verification' page")
      OrganisationEmailVerificationCodePage.verifyPageTitle(
        OrganisationEmailVerificationCodePage.pageTitle,
        OrganisationEmailVerificationCodePage.pageUrl
      ) shouldBe true

      Then("the user enters the code and clicks on Save and continue button")
      OrganisationEmailVerificationCodePage.enterText("value", "ABCDEF")
      OrganisationEmailVerificationCodePage.clickContinue()

      When("the user clicks on continue button")
      ChangeOfCircumstancesPage.clickContinue()

      Then("the user is navigated to the Declaration for changes page")
      DeclarationForChangesPage.verifyPageTitle(
        DeclarationForChangesPage.pageTitleTwo,
        DeclarationForChangesPage.pageUrl
      ) shouldBe true

      When("the user clicks on Agree and Submit button")
      DeclarationForChangesPage.clickAgreeSubmit()

      Then("the user is navigated to the Changes completed page")
      ChangesCompletedPage.verifyPageTitle(
        ChangesCompletedPage.pageTitle,
        ChangesCompletedPage.pageUrl
      ) shouldBe true
    }

    Scenario("2.Non Signatory user logs and change Liaison officers details") {
      Given("Non Signatory user logs in")
      AuthLoginPage.loginAsEnrolledUser(
        "/manage-isas",
        "nonsignatory@example.com",
        "HMRC-DISA-ORG",
        "ZREF",
        "Z1234"
      )

      Then("Manage ISAs page is displayed")
      ManageIsasPage.verifyPageTitle(
        ManageIsasPage.pageTitle,
        ManageIsasPage.pageUrl
      ) shouldBe true

      Then("the user clicks on update information link")
      ManageIsasPage.clicksOnLinks("change-information")

      Then("Change information page is displayed")
      ChangeInformationPage.verifyPageTitle(
        ChangeInformationPage.pageTitle,
        ChangeInformationPage.pageUrl
      ) shouldBe true

      Then("the user clicks on view all information checkbox and then clicks on continue")
      ChangeInformationPage.selectViewAllCheckBox()
      ChangeInformationPage.clickContinue()

      Then("Change of circumstances page is displayed")
      ChangeOfCircumstancesPage.verifyPageTitle(
        ChangeOfCircumstancesPage.pageTitle,
        ChangeOfCircumstancesPage.pageUrl
      ) shouldBe true

      // Changing Liaison officers details

      Then("the user clicks on change link for Liaison officer details")
      ChangeOfCircumstancesPage.clicksOnLinks("added-liaison-officers")

      Then("Liaison officers added page is displayed")
      AddedLiaisonOfficersPage.verifyPageTitle(
        AddedLiaisonOfficersPage.pageTitle,
        AddedLiaisonOfficersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on yes radio button on Liaison officers added page and then clicks on continue button")
      AddedLiaisonOfficersPage.clickRadioButton("Yes")
      AddedLiaisonOfficersPage.clickContinue()

      Then("the user is navigated to the 'liaison-officer-name' page")
      LiaisonOfficerNamePage.verifyPageTitle(
        LiaisonOfficerNamePage.pageTitle,
        LiaisonOfficerNamePage.pageUrl
      ) shouldBe true

      Then("the user enters the full name and clicks on Save and continue button")
      LiaisonOfficerNamePage.enterText("value", "Liaison One")
      LiaisonOfficerNamePage.clickContinue()

      Then("the user is navigated to the 'liaison-officer-email' page")
      LiaisonOfficerEmailPage.verifyPageTitle(
        LiaisonOfficerEmailPage.pageTitle,
        LiaisonOfficerEmailPage.pageUrl
      ) shouldBe true

      Then("the user enters the email value and clicks on Save and continue button")
      LiaisonOfficerEmailPage.enterText("value", "loone@email.com")
      LiaisonOfficerEmailPage.clickContinue()

      Then("the user is navigated to the 'liaison-officer-phone-number' page")
      LiaisonOfficerPhoneNumberPage.verifyPageTitle(
        LiaisonOfficerPhoneNumberPage.pageTitle,
        LiaisonOfficerPhoneNumberPage.pageUrl
      ) shouldBe true

      Then("the user enters the phone number and clicks on Save and continue button")
      LiaisonOfficerPhoneNumberPage.enterText("value", "07733773372")
      LiaisonOfficerPhoneNumberPage.clickContinue()

      Then("the user is navigated to the 'liaison-officer-communication' page")
      LiaisonOfficerCommunicationPage.verifyPageTitle(
        LiaisonOfficerCommunicationPage.pageTitle,
        LiaisonOfficerCommunicationPage.pageUrl
      ) shouldBe true

      Then("the user selects all communication modes and clicks on Save and continue button")
      LiaisonOfficerCommunicationPage.selectCommunicationModes()
      LiaisonOfficerCommunicationPage.clickContinue()

      Then("the user is navigated to the 'check-added-liaison-officer' page")
      CheckAddedLiaisonOfficerPage.verifyPageTitle(
        CheckAddedLiaisonOfficerPage.pageTitle,
        CheckAddedLiaisonOfficerPage.pageUrl
      ) shouldBe true

      Then("the user clicks on continue button on check-added-liaison-officer' page ")
      CheckAddedLiaisonOfficerPage.clicksOnLinks("added-liaison-officers")

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(
        AddedLiaisonOfficersPage.pageTitleTwo,
        AddedLiaisonOfficersPage.pageUrl
      ) shouldBe true

      When("the user clicks on remove link for the added user ")
      CheckAddedLiaisonOfficerPage.clicksOnLinks("remove-liaison-officer")

      Then("the user is navigated to the 'remove-liaison-officer' page")
      RemoveLiaisonOfficerPage.verifyPageTitle(
        RemoveLiaisonOfficerPage.pageTitle,
        RemoveLiaisonOfficerPage.pageUrl
      ) shouldBe true

      Then("the user clicks on no radio button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickRadioButton("No")

      Then("the user clicks on Save and continue button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickContinue()

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(
        AddedLiaisonOfficersPage.pageTitleTwo,
        AddedLiaisonOfficersPage.pageUrl
      ) shouldBe true

      When("the user clicks on remove link for the added user ")
      CheckAddedLiaisonOfficerPage.clicksOnLinks("remove-liaison-officer")

      Then("the user is navigated to the 'remove-liaison-officer' page")
      RemoveLiaisonOfficerPage.verifyPageTitle(
        RemoveLiaisonOfficerPage.pageTitle,
        RemoveLiaisonOfficerPage.pageUrl
      ) shouldBe true

      Then("the user clicks on Yes radio button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickRadioButton("Yes")

      Then("the user clicks on Save and continue button on 'remove-liaison-officer' page ")
      RemoveLiaisonOfficerPage.clickContinue()

      Then("the user is navigated to the 'added-liaison-officer' page")
      AddedLiaisonOfficersPage.verifyPageTitle(
        AddedLiaisonOfficersPage.pageTitle,
        AddedLiaisonOfficersPage.pageUrl
      ) shouldBe true

      Then("the user clicks on no radio button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickRadioButton("No")

      Then("the user clicks on Save and continue button on 'added-liaison-officer' page ")
      AddedLiaisonOfficersPage.clickContinue()

      When("the user clicks on continue button")
      ChangeOfCircumstancesPage.clickContinue()

      Then("the user is navigated to the Declaration for changes  page")
      DeclarationForChangesPage.verifyPageTitle(
        DeclarationForChangesPage.pageTitleTwo,
        DeclarationForChangesPage.pageUrl
      ) shouldBe true

      When("the user clicks on Agree and Submit  button")
      DeclarationForChangesPage.clickAgreeSubmit()

      Then("the user is navigated to the Changes completed page")
      ChangesCompletedPage.verifyPageTitle(
        ChangesCompletedPage.pageTitle,
        ChangesCompletedPage.pageUrl
      ) shouldBe true
    }
  }
}
