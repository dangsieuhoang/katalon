import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startApplication('D:\\download\\platform-tools\\sea.apk', true)

Mobile.setText(findTestObject('Object Repository/mobile/android.widget.EditText - Tn ng nhp'), 'DANGSIEUHOANG', 0)

Mobile.setText(findTestObject('Object Repository/mobile/android.widget.EditText - Mt khu'), 'Hatinh2509@', 0)

Mobile.tap(findTestObject('Object Repository/mobile/android.widget.Button - ng nhp'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/mobile/android.widget.TextView - Qu khch cn ng k li Soft OTP  s dng Ebank trn thit b ny. Ngay khi chn ng k, Soft OTP trn thit b khc (nu c) ca Qu khch s b hy. Qu khch c mun tip tc'), 
    0)

Mobile.closeApplication()

