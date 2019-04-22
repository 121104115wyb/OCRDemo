package com.baidu.ocr.ui.camera;

import android.content.Intent;

/**
 * Created by wyb on 2019-04-22.
 */


public interface TestCallBack {

    void onBdStart();

    void onBdResult(Intent intent,int resultCode);

    void onBdResultError();

//    void onBdResult();
}
