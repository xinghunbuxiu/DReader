package com.duokan.reader.ui.general;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.duokan.b.i;
import com.duokan.common.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;

import org.apache.http.HttpHost;

class kg extends WebViewClient {
    final /* synthetic */ jy a;

    kg(jy jyVar) {
        this.a = jyVar;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.a.h != null) {
            this.a.h.a(str);
        }
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            CharSequence scheme = parse.getScheme();
            if (TextUtils.equals("duokan-reader", scheme)) {
                this.a.dismiss();
                ((ReaderFeature) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(ReaderFeature.class)).navigate(str, "", true, null);
                return true;
            } else if (TextUtils.equals(scheme, "tel")) {
                String schemeSpecificPart = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart)) {
                    ap khVar = new kh(this, this.a.getContext(), schemeSpecificPart);
                    khVar.setTitle(this.a.getActivity().getString(i.general__shared__call));
                    khVar.setPrompt(schemeSpecificPart);
                    khVar.setOkLabel(i.general__shared__confirm);
                    khVar.setCancelLabel(i.general__shared__cancel);
                    khVar.show();
                    return true;
                }
            } else if (TextUtils.equals(scheme, "sms")) {
                Object schemeSpecificPart2 = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart2)) {
                    j.a(this.a.getContext(), schemeSpecificPart2, "");
                    return true;
                }
            } else {
                boolean z = TextUtils.equals(HttpHost.DEFAULT_SCHEME_NAME, scheme) || TextUtils.equals("https", scheme);
                if (!z) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    try {
                        this.a.getContext().startActivity(intent);
                        return true;
                    } catch (Exception e) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                }
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        this.a.h();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.a.c();
        super.onPageStarted(webView, str, bitmap);
        this.a.h();
    }

    public void onPageFinished(WebView webView, String str) {
        this.a.d();
        super.onPageFinished(webView, str);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }
}
