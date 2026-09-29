/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object InnovativeFinancialProductsPage extends BasePage {
  val pageUrl: String   = s"$baseUrl/innovative-financial-products"
  val pageTitle: String =
    "Which types of innovative finance products will your organisation offer? - Manage ISAs - GOV.UK"

  private val P2P36HCheckBox: By         = By.id("value_0")
  private val P2P36HPlatformCheckBox: By = By.id("value_1")
  private val CrowdFundedCheckBox: By    = By.id("value_2")
  private val LTAsCheckBox: By           = By.id("value_3")

  def selectFinancialProductsCheckBox(): Unit = {

    selectCheckbox(P2P36HCheckBox)
    selectCheckbox(CrowdFundedCheckBox)

  }

  def unSelectFinancialProductsCheckBox(): Unit = {

    selectCheckbox(P2P36HPlatformCheckBox)
    selectCheckbox(LTAsCheckBox)

  }
}
