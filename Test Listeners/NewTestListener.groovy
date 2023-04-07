import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable
import utils.CommonUI
class NewTestListener {
    /**
     * Executes after every test case ends.
     * @param testCaseContext related information of the executed test case.
     */
    @AfterTestCase
    def sampleAfterTestCase(TestCaseContext testCaseContext) {
        String result = testCaseContext.getTestCaseStatus()
        int row =  CustomKeywords.'utils.excelUtils.findRow'(testCaseContext.getTestCaseId() , GlobalVariable.url_report + 'report.xlsx')
        CustomKeywords.'utils.excelUtils.setCellData'(result, row, 2, GlobalVariable.url_report + 'report.xlsx')
        CommonUI.logEvidence(result)
        
        
    }

    /**
     * Executes before every test suite starts.
     * @param testSuiteContext: related information of the executed test suite.
     */
    @BeforeTestSuite
    def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
        println testSuiteContext.getTestSuiteId()
    }

    /**
     * Executes after every test suite ends.
     * @param testSuiteContext: related information of the executed test suite.
     */
    @AfterTestSuite
    def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
        println testSuiteContext.getTestSuiteId()
    }
}