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
import uk.gov.hmrc.ui.specs.tags.WIP

class ChangeLiaisonOfficerSpec extends BaseSpec {

  Feature("Edit Liaison officer details") {

    Scenario("1.Verify user can access Add a Liaison officer and edit the changes") {

      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser(
        "/liaison-officer-name",
        "signatory@example.com",
        "HMRC-DISA-ORG",
        "ZREF",
        "Z1234"
      )

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

    }

  }
}
