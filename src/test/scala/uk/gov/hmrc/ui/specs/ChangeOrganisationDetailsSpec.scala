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

class ChangeOrganisationDetailsSpec extends BaseSpec {

  Feature("Enrolled user logs and add organisation details") {

    Scenario("1.Enrolled user logs and add organisation details") {
      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser("/enter-your-organisation-address", "HMRC-DISA-ORG", "ZREF", "Z1234")

      Then("Enter your organisation’s address page is displayed")
      EnterYourOrganisationAddressPage.verifyPageTitle(
        EnterYourOrganisationAddressPage.pageTitle,
        EnterYourOrganisationAddressPage.pageUrl
      ) shouldBe true

      When("User enters the address details and click on 'Continue' button")
      EnterYourOrganisationAddressPage.enterText("addressLine1", "Test address line 1")
      EnterYourOrganisationAddressPage.enterText("addressLine2", "Test address line 2")
      EnterYourOrganisationAddressPage.enterText("townOrCity", "London")
      EnterYourOrganisationAddressPage.enterText("postcode", "AA1 1AA")
      EnterYourOrganisationAddressPage.clickContinue()

      Then("What is the telephone number of your organisation?’s address page is displayed")
      OrganisationTelephoneNumberPage.verifyPageTitle(
        OrganisationTelephoneNumberPage.pageTitle,
        OrganisationTelephoneNumberPage.pageUrl
      ) shouldBe true

    }

  }
}
