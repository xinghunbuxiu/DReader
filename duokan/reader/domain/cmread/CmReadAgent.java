package com.duokan.reader.domain.cmread;

import android.content.Context;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public interface CmReadAgent {
    void addJavascriptInterface(WebView webView, JavascriptCallbacks javascriptCallbacks);

    CmQueryResult cmAccessToken(Looper looper, String str);

    CmQueryResult cmGetChapterInfo(Looper looper, String str, String str2);

    CmQueryResult cmGetChapterList(Looper looper, String str);

    CmQueryResult cmGetContentInfo(Looper looper, String str);

    String getBindMSISDNUrl();

    String getChannelName();

    String getOrderPostParamData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    String getSdkRedirectUrl();

    String getUnbindMSISDNUrl();

    String getUrlOrder();

    WebViewClient getWebViewClient(Context context, WebViewCallbacks webViewCallbacks);
}
