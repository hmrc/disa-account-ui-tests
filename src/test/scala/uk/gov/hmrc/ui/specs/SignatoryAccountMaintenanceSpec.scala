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

class SignatoryAccountMaintenanceSpec extends BaseSpec {

  Feature("Signatory user features") {

    Scenario("1.Signatory user logs and change organisation details") {
      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser(
        "/manage-isas",
        "signatory@example.com",
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

    Scenario("2.Signatory user logs and change product details") {
      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser(
        "/manage-isas",
        "signatory@example.com",
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

      // Changing product details

      Then("the user clicks on change link for Change products")
      ChangeOfCircumstancesPage.clicksOnLinks("change-products")

      Then("Change products page is displayed")
      ChangeProductsPage.verifyPageTitle(
        ChangeProductsPage.pageTitle,
        ChangeProductsPage.pageUrl
      ) shouldBe true

      Then("the user selects previously unselected products and click continue button")
      ChangeProductsPage.selectProductsCheckBox()
      ChangeProductsPage.clickContinue()

      Then("the user clicks on change link for Innovative Finances ISAs type")
      ChangeOfCircumstancesPage.clicksOnLinks("innovative-financial-products")

      Then("Innovative Financial products page is displayed")
      InnovativeFinancialProductsPage.verifyPageTitle(
        InnovativeFinancialProductsPage.pageTitle,
        InnovativeFinancialProductsPage.pageUrl
      ) shouldBe true

      Then("the user selects previously unselected products and click continue button")
      InnovativeFinancialProductsPage.selectFinancialProductsCheckBox()
      InnovativeFinancialProductsPage.clickContinue()

      Then("the user clicks on change link for peer to peer loans")
      ChangeOfCircumstancesPage.clicksOnLinks("peer-to-peer-loans")

      Then("the user is navigated to the 'Peer to peer loans' page")
      PeerToPeerLoansPage.verifyPageTitle(
        PeerToPeerLoansPage.pageTitle,
        PeerToPeerLoansPage.pageUrl
      ) shouldBe true

      Then("the user changes platform name value and clicks continue button")
      PeerToPeerLoansPage.enterText("value", "test platform new")
      PeerToPeerLoansPage.clickContinue()

      When("the user clicks on continue button")
      ChangeOfCircumstancesPage.clickContinue()

      Then("the user is navigated to the Declaration for changes  page")
      DeclarationForChangesPage.verifyPageTitle(
        DeclarationForChangesPage.pageTitle,
        DeclarationForChangesPage.pageUrl
      ) shouldBe true

      When("the user clicks on Agree and Submit  button")
      DeclarationForChangesPage.clickAgreeSubmit()

      Then("the user is navigated to the Changes completed  page")
      ChangesCompletedPage.verifyPageTitle(
        ChangesCompletedPage.pageTitle,
        ChangesCompletedPage.pageUrl
      ) shouldBe true
    }

    Scenario("3.Signatory user logs and change signatory details") {
      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser(
        "/manage-isas",
        "signatory@example.com",
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

      // Changing signatory details

      Then("the user clicks on change link for Signatory")
      ChangeOfCircumstancesPage.clicksOnLinks("added-signatories")

      Then("Signatories added page is displayed")
      SignatoriesAddedPage.verifyPageTitle(
        SignatoriesAddedPage.pageTitle,
        SignatoriesAddedPage.pageUrl
      ) shouldBe true

      Then("the user clicks on yes radio button on Signatories added page and then clicks on continue button")
      SignatoriesAddedPage.clickRadioButton("Yes")
      SignatoriesAddedPage.clickContinue()

      Then("the user is navigated to the 'signatory-name' page")
      SignatoryNamePage.verifyPageTitle(SignatoryNamePage.pageTitle, SignatoryNamePage.pageUrl) shouldBe true

      When("the user enters the full name and clicks on continue button")
      SignatoryNamePage.enterText("value", "Signatory One")
      SignatoryNamePage.clickContinue()

      Then("the user is navigated to the 'signatory-job-title' page")
      SignatoryJobTitlePage.verifyPageTitle(
        SignatoryJobTitlePage.pageTitle,
        SignatoryJobTitlePage.pageUrl
      ) shouldBe true

      When("the user enters the JobTitle value and clicks on continue button")
      SignatoryJobTitlePage.enterText("value", "QA")
      SignatoryJobTitlePage.clickContinue()

      Then("the user is navigated to the 'check signatory details' page")
      SignatoryCheckDetailsPage.verifyPageTitle(
        SignatoryCheckDetailsPage.pageTitle,
        SignatoryCheckDetailsPage.pageUrl
      ) shouldBe true

      When("the user clicks on continue button")
      SignatoryCheckDetailsPage.clickContinue()

      Then("the user is navigated to the 'signatories added' page")
      SignatoriesAddedPage.verifyPageTitle(
        SignatoriesAddedPage.pageTitleTwo,
        SignatoriesAddedPage.pageUrl
      ) shouldBe true

      Then("the user clicks on No radio button on Signatories added page and then clicks on continue button")
      SignatoriesAddedPage.clickRadioButton("No")
      SignatoriesAddedPage.clickContinue()

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
