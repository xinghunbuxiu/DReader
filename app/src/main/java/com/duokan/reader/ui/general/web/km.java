package com.duokan.reader.ui.general.web;

import android.os.Build.VERSION;
import android.webkit.WebSettings;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.duokan.p;

public class km {
    public static void a(WebSettings webSettings) {
        if (webSettings != null) {
            webSettings.setJavaScriptEnabled(true);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setBuiltInZoomControls(false);
            webSettings.setSupportZoom(false);
            webSettings.setSaveFormData(true);
            webSettings.setSavePassword(false);
            webSettings.setUseWideViewPort(false);
            webSettings.setAppCacheEnabled(true);
            webSettings.setAppCacheMaxSize(8388608);
            webSettings.setAppCachePath(ReaderEnv.get().getCacheDirectory().getPath());
            webSettings.setAllowFileAccess(true);
            if (VERSION.SDK_INT >= 16) {
                webSettings.setAllowFileAccessFromFileURLs(true);
            }
            if (classc.ConnectivityReceiver.b().e()) {
                webSettings.setCacheMode(-1);
            } else {
                webSettings.setCacheMode(1);
            }
            if (!p.i().k()) {
                webSettings.setCacheMode(2);
            }
            webSettings.setDomStorageEnabled(true);
            webSettings.setDatabaseEnabled(true);
            if (VERSION.SDK_INT < 19) {
                webSettings.setDatabasePath(ReaderEnv.get().getDatabaseDirectory().getPath());
            }
            webSettings.setUserAgentString("Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 XiaoMi/MiuiBrowser/2.1.1");
            if (VERSION.SDK_INT >= 21) {
                webSettings.setMixedContentMode(0);
            }
        }
    }
}
