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

WebUI.openBrowser(GlobalVariable.G_url)

WebUI.maximizeWindow()

WebUI.delay(3)

datatestid ="occupancy-config"

WebUI.click(findTestObject('Object Repository/Homepage/datatestid_param', [('datatestid_parameter') : datatestid]))

int increaseAdult = 28
for (int i = 0; i < increaseAdult; i++) {
	WebUI.click(findTestObject('Object Repository/Homepage/button_incrdecradultchildroom', [('pos') : 2]))}

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Homepage/datatestid_param', [('datatestid_parameter') : datatestid]))

WebUI.verifyElementNotClickable(findTestObject('Object Repository/Homepage/button_incrdecradultchildroom', [('pos') : 2]))

WebUI.delay(1)

aria = WebUI.getAttribute(findTestObject('Object Repository/Homepage/datatestid_param',[('datatestid_parameter') : datatestid]), 'aria-label')

// verifikasi occupancy 
assert aria.contains('30 adult')
assert aria.contains('0 children')
assert aria.contains('1 room')

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()