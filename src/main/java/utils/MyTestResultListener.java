package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import base.Base;

public class MyTestResultListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // do what you want to do
    }

   @Override
    public void onTestSkipped(ITestResult result) {
        // do what you want to do
    }
}
