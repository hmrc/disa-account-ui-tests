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

class ChangeSignatorySpec extends BaseSpec {

  Feature("Edit Signatory details") {

    Scenario("1.Verify user can access Add a signatory and edit the name and title") {

      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser("/signatory-name?id=signatory-test-id-1", "HMRC-DISA-ORG", "ZREF", "Z1234")


      Then("the user is navigated to the 'signatory-name' page")
      SignatoryNamePage.verifyPageTitle(SignatoryNamePage.pageTitle, SignatoryNamePage.pageUrl) shouldBe true

      When("the user enters the full name and clicks on Save and continue button")
      SignatoryNamePage.enterText("value", "Signatory One")
      SignatoryNamePage.clickContinue()

      Then("the user is navigated to the 'signatory-job-title' page")
      SignatoryJobTitlePage.verifyPageTitle(
        SignatoryJobTitlePage.pageTitle,
        SignatoryJobTitlePage.pageUrl
      ) shouldBe true

      When("the user enters the JobTitle value and clicks on Save and continue button")
      SignatoryJobTitlePage.enterText("value", "QA")
      SignatoryJobTitlePage.clickContinue()

      Then("the user is navigated to the 'check signatory details' page")
      SignatoryCheckDetailsPage.verifyPageTitle(
        SignatoryCheckDetailsPage.pageTitle,
        SignatoryCheckDetailsPage.pageUrl
      ) shouldBe true

    }

  }
}
