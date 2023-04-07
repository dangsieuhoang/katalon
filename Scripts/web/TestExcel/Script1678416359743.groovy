import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def data =  CustomKeywords.'utils.CommonUI.readFileJson'("data\\UAT\\dataTest\\data.json")

String user = data.name

WebUI.openBrowser('')

WebUI.navigateToUrl('https://seanet.vn/')

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/Page_SeABank Internet Banking/divKHCN'), 0)

WebUI.click(findTestObject('Object Repository/Web/Page_SeABank Internet Banking/divKHCN'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/Page_SeABank Internet Banking/input_user'), 0)

WebUI.setText(findTestObject('Object Repository/Web/Page_SeABank Internet Banking/input_user'), user)

WebUI.setEncryptedText(findTestObject('Object Repository/Web/Page_SeABank Internet Banking/input_pass'), 'H6/2S7XTE3a9wGfLhoH8sg==')

WebUI.click(findTestObject('Object Repository/Web/Page_SeABank Internet Banking/button_Login'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Web/Page_SeABank Internet Banking/img_logo'), 0)

String actualText = WebUI.getText(findTestObject('Web/Page_SeABank Internet Banking/span_userName'))

WebUI.verifyMatch(actualText, 'DINH LE HOANG', false)


