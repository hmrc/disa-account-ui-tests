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

class ChangeProductInfoSpec extends BaseSpec {

  Feature("Change Products details") {

    Scenario("1.Verify user can access and update products details") {

      Given(" ISA manager logs in as an already enrolled organisation User")
      AuthLoginPage.loginAsEnrolledUser(
        "/change-information",
        "signatory@example.com",
        "HMRC-DISA-ORG",
        "ZREF",
        "Z1234"
      )

      Then("the user is navigated to the 'signatory-name' page")
      ChangeInformationPage.verifyPageTitle(
        ChangeInformationPage.pageTitle,
        ChangeInformationPage.pageUrl
      ) shouldBe true

    }

  }
}
