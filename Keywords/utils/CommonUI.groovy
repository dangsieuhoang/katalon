package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

import groovy.json.JsonSlurper


public class CommonUI {
	def getDate(int date, int mouth, int year) {
		LocalDate dateObj = LocalDate.now();

		if(date != null) {
			dateObj.plusDays(date);
		}
		else if(mouth != null) {
			dateObj.plusMonths(mouth);
		}
		else if(year) {
			dateObj.plusYears(year);
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String dateOut = dateObj.format(formatter);

		return dateOut
	}

	@Keyword
	def static logEvidence(text) {
		KeywordUtil.logInfo((String)text);
	}

	@Keyword
	def readFileJson(location) {
		def inputFile = new File(location);
		def InputJSON = new JsonSlurper().parseText(inputFile.text);

		return InputJSON
	}
}
