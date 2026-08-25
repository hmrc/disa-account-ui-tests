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

class AddOrganisationEmailSpec extends BaseSpec {

  Feature("Add an organisation") {

    Scenario("1.Verify user can change email information for an organisation") {

      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser("/organisation-email-address", "HMRC-DISA-ORG", "ZREF", "Z1234")

      Then("Enter your organisation’s address page is displayed")
      OrganisationEmailPage.verifyPageTitle(
        OrganisationEmailPage.pageTitle,
        OrganisationEmailPage.pageUrl
      ) shouldBe true

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

    }

  }
}
