package com.baidu.ocr.ui.camera;

/**
 * Created by wyb on 2019-04-22.
 */


public class TestManager {

    TestCallBack testCallBack;
    static TestManager testManager;

    public static synchronized TestManager getTestManager() {
        if (null == testManager) {
            testManager = new TestManager();
        }
        return testManager;
    }

    public void setTestCallBack(TestCallBack testCallBack) {
        this.testCallBack = testCallBack;
    }

    public TestCallBack getTestCallBack() {
        return testCallBack;
    }
}
