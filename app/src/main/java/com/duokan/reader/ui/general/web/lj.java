package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.BaseDialog;
import com.duokan.core.ui.fr;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.gs;
import java.util.concurrent.ConcurrentHashMap;

public abstract class lj extends gs implements li {
    protected static final String BLANK_SCREEN_URL = "about:blank";
    protected static final String CALL_BACK_JS_FORMAT = "javascript:(function() { try { %s } catch(e) { fictionApi.log(e.message); } }())";
    protected static final ConcurrentHashMap<String, String> sParcelMap = new ConcurrentHashMap();
    protected boolean mCallBackSucceed = false;
    protected boolean mPageLoading = false;
    protected final DkWebView mWebView;

    protected abstract void webPageError(boolean z);

    public lj(IFeature mFeature) {
        super(mFeature);
        if (VERSION.SDK_INT >= 17 && ReaderEnv.get().forHd()) {
            Configuration configuration = new Configuration(((Context) mFeature).getResources().getConfiguration());
            Configuration configuration2 = getContext().getApplicationContext().getResources().getConfiguration();
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration.fontScale *= (float) (configuration.densityDpi / configuration2.densityDpi);
                configuration.densityDpi = configuration2.densityDpi;
            }
            getContext().initConfiguration(configuration);
        }
        initContentView();
        this.mWebView = (DkWebView) findViewById(C0255g.general__web_core_view__web);
    }

    protected boolean onBack() {
        int pageBackSteps = pageBackSteps();
        if (pageBackSteps <= 0) {
            return false;
        }
        this.mWebView.mo1813a(-pageBackSteps);
        return true;
    }

    public void refresh() {
        resetPageStatus();
        this.mWebView.mo1818c();
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
        setContentView(C0256h.general__web_view);
    }

    protected void doShowToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(getContext(), (CharSequence) str, 1).show();
        }
    }

    public BaseDialog js_showDialog(String str, String str2, String str3, String str4, Runnable runnable, Runnable runnable2) {
        BaseDialog lkVar = new lk(this, getContext(), runnable, runnable2);
        if (!TextUtils.isEmpty(str)) {
            lkVar.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            lkVar.setPrompt(str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            lkVar.setCancelLabel(str4);
        }
        if (TextUtils.isEmpty(str3)) {
            lkVar.setOkLabel(C0258j.general__shared__ok);
        } else {
            lkVar.setOkLabel(str3);
        }
        lkVar.show();
        return lkVar;
    }

    public void showDialog(String str, boolean z, JsResult jsResult) {
        UThread.runOnThread(new ll(this, str, z, jsResult));
    }

    protected boolean web_isDestroyed() {
        return this.mWebView.mo1822k();
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
        if (!this.mWebView.mo1822k()) {
            this.mWebView.setVisibility(0);
        }
    }

    private int pageBackSteps() {
        if (!this.mWebView.mo1819d()) {
            return 0;
        }
        WebBackForwardList e = this.mWebView.mo1820e();
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
        if (C0641o.m2934i().m2952a().equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }
}
