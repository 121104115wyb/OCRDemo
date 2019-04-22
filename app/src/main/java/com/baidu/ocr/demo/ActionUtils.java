package com.baidu.ocr.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.TestActivity;
import com.baidu.ocr.ui.camera.TestCallBack;

/**
 * Created by wyb on 2019-04-22.
 */


public class ActionUtils {

    private Activity context;

    private static String aaa;
    private boolean hasGotToken = false;
    private Toast mToast = null;

    private TestCallBack callBack;

    public ActionUtils(Activity context, TestCallBack callBack){
        this.context = context;
        this.callBack = callBack;

    }

    /**
     * 测试1
     */
    public void callTest1(){

//        if (checkTokenStatus()){
            Intent intent = new Intent(context, TestActivity.class);
            intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                    FileUtil.getSaveFile(context.getApplicationContext()).getAbsolutePath());
            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                    CameraActivity.CONTENT_TYPE_GENERAL);
            context.startActivityForResult(intent, 129);
//        }
    }



    private void actionActivity(){




    }

    private boolean checkTokenStatus() {
        if (!hasGotToken) {
            Toast.makeText(context.getApplicationContext(), "token还未成功获取", Toast.LENGTH_LONG).show();
        }
        return hasGotToken;
    }

    /**
     * 以license文件方式初始化
     */
    private void initAccessToken() {
        OCR.getInstance(context).initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token = accessToken.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                //alertText("licence方式获取token失败", error.getMessage());
            }
        }, context.getApplicationContext());
    }

    /**
     * 用明文ak，sk初始化
     */
//    private void initAccessTokenWithAkSk() {
//        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
//            @Override
//            public void onResult(AccessToken result) {
//                String token = result.getAccessToken();
//                hasGotToken = true;
//            }
//
//            @Override
//            public void onError(OCRError error) {
//                error.printStackTrace();
//                alertText("AK，SK方式获取token失败", error.getMessage());
//            }
//        }, getApplicationContext(),  "0WRtj0aT9YME0lxsoGvjlir0", "T6KbKoiXfRHIrO3U3IEQ0atPMeBb7Hzx");
//    }


}
