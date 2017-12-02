package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;

import com.duokan.c.h;
import com.duokan.core.app.y;
import com.duokan.core.sys.t;
import com.duokan.core.ui.fr;
import com.duokan.core.ui.j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.c.g;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hd;

import java.util.concurrent.ConcurrentHashMap;

public abstract class ke extends hd implements g, kd {
    protected static final String BLANK_SCREEN_URL = "about:blank";
    protected static final String CALL_BACK_JS_FORMAT = "javascript:(function() { try { %s } catch(e) { fictionApi.log(e.message); } }())";
    protected static final ConcurrentHashMap sParcelMap = new ConcurrentHashMap();
    protected boolean mCallBackSucceed = false;
    protected boolean mPageLoading = false;
    protected final DkWebView mWebView;

    protected abstract void webPageError(boolean z);

    public ke(y yVar) {
        super(yVar);
        if (VERSION.SDK_INT >= 17 && ReaderEnv.get().forHd()) {
            Configuration configuration = new Configuration(((Context) yVar).getResources().getConfiguration());
            Configuration configuration2 = getContext().getApplicationContext().getResources().getConfiguration();
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration.fontScale *= (float) (configuration.densityDpi / configuration2.densityDpi);
                configuration.densityDpi = configuration2.densityDpi;
            }
            getContext().a(configuration);
        }
        initContentView();
        this.mWebView = (DkWebView) findViewById(com.duokan.c.g.general__web_core_view__web);
    }

    protected boolean onBack() {
        int pageBackSteps = pageBackSteps();
        if (pageBackSteps <= 0) {
            return false;
        }
        this.mWebView.a(-pageBackSteps);
        return true;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        f.b().a((g) this);
    }

    protected void onDeactive() {
        f.b().b(this);
        super.onDeactive();
    }

    public void onConnectivityChanged(f fVar) {
    }

    public void refresh() {
        resetPageStatus();
        this.mWebView.c();
    }

    public String getCurrentUrl() {
        return this.mWebView.getCurrentUrl();
    }

    public boolean isLoading() {
        return webPageLoading();
    }

    protected void resetPageStatus() {
        webPageLoading(true);
        webPageError(false);
    }

    protected boolean checkPageError() {
        return this.mWebView.getLoadingError() != 0;
    }

    protected boolean webPageLoading() {
        return this.mPageLoading;
    }

    protected void webPageLoading(boolean z) {
        if (this.mPageLoading != z) {
            this.mPageLoading = z;
        }
    }

    protected void initContentView() {
        setContentView(h.general__web_view);
    }

    protected void doShowToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(getContext(), (CharSequence) str, 1).show();
        }
    }

    public j js_showDialog(String str, String str2, String str3, String str4, Runnable runnable, Runnable runnable2) {
        j kfVar = new kf(this, getContext(), runnable, runnable2);
        if (!TextUtils.isEmpty(str)) {
            kfVar.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            kfVar.setPrompt(str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            kfVar.setCancelLabel(str4);
        }
        if (TextUtils.isEmpty(str3)) {
            kfVar.setOkLabel(com.duokan.c.j.general__shared__ok);
        } else {
            kfVar.setOkLabel(str3);
        }
        kfVar.show();
        return kfVar;
    }

    public void showDialog(String str, boolean z, JsResult jsResult) {
        t.a(new kg(this, str, z, jsResult));
    }

    protected boolean web_isDestroyed() {
        return this.mWebView.k();
    }

    public void onPageStarted(fr frVar, String str, Bitmap bitmap) {
        webPageLoading(true);
    }

    public void onPageFinished(fr frVar, String str) {
        boolean checkPageError = checkPageError();
        webPageLoading(false);
        if (checkPageError) {
            webPageError(true);
            return;
        }
        webPageError(false);
        if (!this.mWebView.k()) {
            this.mWebView.setVisibility(0);
        }
    }

    private int pageBackSteps() {
        if (!this.mWebView.d()) {
            return 0;
        }
        WebBackForwardList e = this.mWebView.e();
        int currentIndex = e.getCurrentIndex();
        if (currentIndex < 0) {
            return 0;
        }
        int i = currentIndex - 1;
        currentIndex = 1;
        for (int i2 = i; i2 >= 0; i2--) {
            String url = e.getItemAtIndex(i2).getUrl();
            if (BLANK_SCREEN_URL.equalsIgnoreCase(url)) {
                currentIndex++;
            } else if (!isPreloadPage(url)) {
                return currentIndex;
            } else {
                if (i2 == 0) {
                    return 0;
                }
                currentIndex++;
            }
        }
        return currentIndex;
    }

    private boolean isPreloadPage(String str) {
        if (p.i().a().equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }
}
