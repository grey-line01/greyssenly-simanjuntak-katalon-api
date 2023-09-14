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
import groovy.json.JsonOutput as JsonOutput

def bookingId = 1 

def url = "https://restful-booker.herokuapp.com/booking/$bookingId"

def headers = [('Accept') : 'application/json']

def response = WS.sendRequest(findTestObject('Booking/GetBooking'))

if (response.getStatusCode() == 200) {
    
    def responseBody = [('firstname') : 'Sally', ('lastname') : 'Brown', ('totalprice') : 111, ('depositpaid') : true, ('bookingdates') : [
            ('checkin') : '2013-02-23', ('checkout') : '2014-10-23'], ('additionalneeds') : 'Breakfast']

    
    def jsonResponse = JsonOutput.toJson(responseBody)

    // Menampilkan respons JSON yang dihasilkan
    println(jsonResponse) 
} else {
    println('Failed to receive a valid response.')

    println('Response Status: ' + response.getStatusCode())

    println('Response Body: ' + response.getResponseBodyContent())
}

