/*
 * Copyright © 2021 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.e2e.pages.actions;

import io.cdap.e2e.pages.locators.CdfLogLocators;
import io.cdap.e2e.utils.ElementHelper;
import io.cdap.e2e.utils.SeleniumHelper;
import stepsdesign.BeforeActions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Represents CdfLogActions
 */
public class CdfLogActions {
  public static CdfLogLocators cdfLogLocators;

  static {
    cdfLogLocators = SeleniumHelper.getPropertiesLocators(CdfLogLocators.class);
  }

  public static void validateErrorPopupLog() throws InterruptedException {
    ElementHelper.clickOnElement(cdfLogLocators.errorMessagePopup);
  }

  public static void validateErrorPopupLog(String error) throws InterruptedException {
    ElementHelper.clickOnElement(cdfLogLocators.errorMessagePopup);
  }

  public static void dismissPopup() {
    cdfLogLocators.dismissable.click();
  }

  public static void goToLogs() {
    cdfLogLocators.goToLogs.click();
  }

  public static void validateFailed() {
    cdfLogLocators.validateFailed.isDisplayed();
  }

  public static void validateCategoryError() {
    cdfLogLocators.validateCategoryError.isDisplayed();
  }

  public static void validateLogError() {
    cdfLogLocators.validateCategoryError.isDisplayed();
  }

  public static void goToAdvanceLogs() {
    cdfLogLocators.getGoToAdvanceLogs.click();
  }

  public static void validateSucceeded() {
    cdfLogLocators.validateSucceeded.isDisplayed();
  }

  public static void closeLogs() {
    cdfLogLocators.closeLogs.click();
  }

  public static void writeRawLogsToFile(File file, String message) throws FileNotFoundException {
    String rawLogs = CdfPipelineRunAction.captureRawLogs();
    BeforeActions.scenario.write(message);
    BeforeActions.scenario.write(rawLogs);
    PrintWriter out;
    if (file.exists()) {
      out = new PrintWriter(new FileOutputStream(file, true));
    } else {
      out = new PrintWriter(file);
    }
    out.println(message);
    out.println(rawLogs);
    out.close();
  }
}
