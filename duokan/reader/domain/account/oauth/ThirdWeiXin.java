package com.duokan.reader.domain.account.oauth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;

import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.analytics.pro.j;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class ThirdWeiXin {
    private static boolean mInstalled = false;
    private final int THUMB_MAX_BYTE_COUNT = 32768;
    private final int THUMB_SCALE_SIZE = j.e;
    private final Context mContext = DkApp.get();

    public void login() {
        BaseReq req = new Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        createWxApi(0).sendReq(req);
    }

    public void share(String str, String str2, String str3, Bitmap bitmap, boolean z, boolean z2) {
        int i = 1;
        IWXAPI createWxApi = createWxApi(2);
        if (TextUtils.isEmpty(str3) || !z) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            BaseReq req = new SendMessageToWX.Req();
            wXMediaMessage.mediaObject = new WXImageObject(bitmap);
            req.transaction = buildTransaction("img");
            req.message = wXMediaMessage;
            wXMediaMessage.title = subString(str, j.e);
            wXMediaMessage.description = subString(str2, j.g);
            if (!(isSupportShareWeiXinFriends(this.mContext) && z2)) {
                i = 0;
            }
            req.scene = i;
            createWxApi.sendReq(req);
            return;
        }
        IMediaObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage2 = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage2.title = subString(str, j.e);
        wXMediaMessage2.description = subString(str2, j.g);
        byte[] bmpToByteArray = bmpToByteArray(Bitmap.createScaledBitmap(bitmap, j.e, j.e, true), true);
        if (bmpToByteArray.length <= 32768) {
            wXMediaMessage2.thumbData = bmpToByteArray;
        }
        BaseReq req2 = new SendMessageToWX.Req();
        req2.transaction = buildTransaction("webpage");
        req2.message = wXMediaMessage2;
        if (!(isSupportShareWeiXinFriends(this.mContext) && z2)) {
            i = 0;
        }
        req2.scene = i;
        createWxApi.sendReq(req2);
    }

    public void send2Friend(String str, String str2) {
        IMediaObject wXTextObject = new WXTextObject();
        wXTextObject.text = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = str;
        BaseReq req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        getShareAppKey();
        createWxApi(2).sendReq(req);
    }

    public static String getAppKey() {
        return ReaderEnv.get().forHd() ? "wx102ed2cf6beb29a7" : "wxd57423973661aabe";
    }

    public static String getShareAppKey() {
        return ReaderEnv.get().forHd() ? "wx1d4c011a2e35f45e" : "wx8b777d060608ec99";
    }

    public static void asyncResetInstalledStatus() {
        new WebSession() {
            protected void onSessionTry() {
                ThirdWeiXin.resetInstalledStatus();
            }

            protected void onSessionSucceeded() {
            }

            protected void onSessionFailed() {
            }
        }.open();
    }

    public static synchronized void resetInstalledStatus() {
        synchronized (ThirdWeiXin.class) {
            Context context = DkApp.get();
            if (context != null) {
                mInstalled = WXAPIFactory.createWXAPI(context, getAppKey()).isWXAppInstalled();
            }
        }
    }

    public static boolean isWeiXinInstalled(Context context) {
        return mInstalled && WXAPIFactory.createWXAPI(context, getAppKey()).isWXAppSupportAPI();
    }

    public static boolean isWeiXinPaySupported(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, getAppKey());
        return createWXAPI.isWXAppInstalled() && createWXAPI.getWXAppSupportAPI() >= 570425345;
    }

    public static boolean isSupportShareWeiXinFriends(Context context) {
        return WXAPIFactory.createWXAPI(context, getAppKey()).getWXAppSupportAPI() >= 553779201;
    }

    private String buildTransaction(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    private byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 75, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toByteArray;
    }

    private String subString(String str, int i) {
        return (str == null || str.length() <= i) ? str : str.substring(0, i);
    }

    public static IWXAPI createWxApi(int i) {
        String shareAppKey;
        IWXAPI createWXAPI;
        switch (i) {
            case 1:
                return WXAPIFactory.createWXAPI(DkApp.get(), null);
            case 2:
                shareAppKey = getShareAppKey();
                createWXAPI = WXAPIFactory.createWXAPI(DkApp.get(), shareAppKey, true);
                createWXAPI.registerApp(shareAppKey);
                return createWXAPI;
            default:
                shareAppKey = getAppKey();
                createWXAPI = WXAPIFactory.createWXAPI(DkApp.get(), shareAppKey, true);
                createWXAPI.registerApp(shareAppKey);
                return createWXAPI;
        }
    }
}
