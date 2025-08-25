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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.G_url)

WebUI.maximizeWindow()

WebUI.delay(1)

stays = 'accommodations'

WebUI.click(findTestObject('Object Repository/Homepage/id_param', [('id_param') : stays]))

WebUI.delay(3)

WebUI.setText(findTestObject('Object Repository/Homepage/name_parameter', [('name_parameter') : 'ss']), 'jakarta')

WebUI.click(findTestObject('Object Repository/Homepage/li-placeallparam', [('pos') : 1]))

Destination = 'Jakarta, Jakarta Province, Indonesia'

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Homepage/name_parameter', [('name_parameter') : 'ss']), 
    'value', Destination, 10)

int nextClicks = 13

for (int i = 0; i < nextClicks; i++) {
    WebUI.click(findTestObject('Object Repository/Homepage/button-nextmonth'))
}

startDate = '2026-09-02'

endDate = '2026-09-18'

WebUI.click(findTestObject('Object Repository/Homepage/calldate_parameter', [('date_parameter') : startDate]))

WebUI.click(findTestObject('Object Repository/Homepage/calldate_parameter', [('date_parameter') : endDate]))

startDateLabel = 'Wed, Sep 2'

endDateLabel = 'Fri, Sep 18'

WebUI.verifyElementText(findTestObject('Object Repository/Homepage/datatestid_param', [('datatestid_parameter') : 'date-display-field-start']), 
    startDateLabel)

WebUI.verifyElementText(findTestObject('Object Repository/Homepage/datatestid_param', [('datatestid_parameter') : 'date-display-field-end']), 
    endDateLabel)

datatestid = 'occupancy-config'

WebUI.click(findTestObject('Object Repository/Homepage/datatestid_param', [('datatestid_parameter') : datatestid]))

int increaseAdult = 2

for (int i = 0; i < increaseAdult; i++) {
    WebUI.click(findTestObject('Object Repository/Homepage/button_incrdecradultchildroom', [('pos') : 2]))
}

int increaseChildren = 1

for (int i = 0; i < increaseChildren; i++) {
    WebUI.click(findTestObject('Object Repository/Homepage/button_incrdecradultchildroom', [('pos') : 4]))

    WebUI.delay(0.5)
}

int increaseRoom = 1

for (int i = 0; i < increaseRoom; i++) {
    WebUI.click(findTestObject('Object Repository/Homepage/button_incrdecradultchildroom', [('pos') : 6]))
}

WebUI.delay(5)

TestObject child1 = new TestObject('child1')
child1.addProperty('xpath', ConditionType.EQUALS,
	"(//div[@data-testid='kids-ages-select']//select[@name='age'])[1]")

WebUI.waitForElementVisible(child1, 10)
WebUI.selectOptionByValue(child1, "5", false)


aria = WebUI.getAttribute(findTestObject('Object Repository/Homepage/datatestid_param', [('datatestid_parameter') : datatestid]), 
    'aria-label')

assert aria.contains('4 adults')
assert aria.contains('1 child')
assert aria.contains('2 rooms')

WebUI.delay(1)

type = 'submit'
WebUI.click(findTestObject('Object Repository/Homepage/type_param', [('type_param') : type]))

WebUI.delay(3)

String searchResult = WebUI.getText(findTestObject('Object Repository/Search Result/text_searchresult'))
assert searchResult.contains("Jakarta")

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()
