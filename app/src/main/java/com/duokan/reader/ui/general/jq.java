package com.duokan.reader.ui.general;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.duokan.common.C0268j;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.BaseActivity;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderFeature;
import org.apache.http.HttpHost;

class jq extends WebViewClient {
    /* renamed from: a */
    final /* synthetic */ ji f7454a;

    jq(ji jiVar) {
        this.f7454a = jiVar;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f7454a.f7444h != null) {
            this.f7454a.f7444h.m10876a(str);
        }
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            CharSequence scheme = parse.getScheme();
            if (TextUtils.equals("duokan-reader", scheme)) {
                this.f7454a.dismiss();
                ((ReaderFeature) AppContext.getAppContext(this.f7454a.getContext()).queryFeature(ReaderFeature.class)).navigate(str, "", true, null);
                return true;
            } else if (TextUtils.equals(scheme, "tel")) {
                String schemeSpecificPart = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart)) {
                    ap jrVar = new jr(this, this.f7454a.getContext(), schemeSpecificPart);
                    jrVar.setTitle(this.f7454a.getActivity().getString(C0247i.general__shared__call));
                    jrVar.setPrompt(schemeSpecificPart);
                    jrVar.setOkLabelResid(C0247i.general__shared__confirm);
                    jrVar.setCancelLabel(C0247i.general__shared__cancel);
                    jrVar.show();
                    return true;
                }
            } else if (TextUtils.equals(scheme, "sms")) {
                Object schemeSpecificPart2 = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart2) && (this.f7454a.getActivity() instanceof BaseActivity)) {
                    C0268j.m613a((BaseActivity) this.f7454a.getActivity(), schemeSpecificPart2, "");
                    return true;
                }
            } else {
                boolean z = TextUtils.equals(HttpHost.DEFAULT_SCHEME_NAME, scheme) || TextUtils.equals("https", scheme);
                if (!z) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    try {
                        this.f7454a.getContext().startActivity(intent);
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
        this.f7454a.m10865h();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f7454a.m10854c();
        super.onPageStarted(webView, str, bitmap);
        this.f7454a.m10865h();
    }

    public void onPageFinished(WebView webView, String str) {
        this.f7454a.m10857d();
        super.onPageFinished(webView, str);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }
}
