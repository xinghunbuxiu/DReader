package com.duokan.reader.ui.general.web;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;

import com.duokan.c.j;
import com.duokan.common.SysTools;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.ui.fr;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.ap;

import org.apache.http.HttpHost;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import miui.webkit.MiuiWebViewClient;

public class e extends MiuiWebViewClient {
    private final kd a;
    private final ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();
    private long c;

    public e(kd kdVar) {
        this.a = kdVar;
    }

    public void a(g gVar) {
        this.b.add(gVar);
    }

    protected Activity getActivity() {
        return this.a.getActivity();
    }

    public boolean shouldOverrideUrlLoading(fr frVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            CharSequence scheme = parse.getScheme();
            if (TextUtils.equals("duokan-reader", scheme)) {
                if (TextUtils.equals(parse.getQueryParameter("smoothly"), "0")) {
                    ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).navigate(str, null, false, null);
                } else {
                    ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).navigateSmoothly(str);
                }
                return true;
            } else if (TextUtils.equals(scheme, "tel")) {
                String schemeSpecificPart = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart)) {
                    ap fVar = new f(this, this.a.getContext(), schemeSpecificPart);
                    fVar.setTitle(this.a.getContext().getString(j.general__shared__call));
                    fVar.setPrompt(schemeSpecificPart);
                    fVar.setOkLabel(j.general__shared__confirm);
                    fVar.setCancelLabel(j.general__shared__cancel);
                    fVar.show();
                    return true;
                }
            } else if (TextUtils.equals(scheme, "sms")) {
                Object schemeSpecificPart2 = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart2)) {
                    SysTools.sendSms(this.a.getContext(), schemeSpecificPart2, "");
                    return true;
                }
            } else if (TextUtils.equals(scheme, "intent")) {
                Matcher matcher = Pattern.compile("scheme=([\\w-]+);").matcher(str);
                if (matcher.find()) {
                    Object group = matcher.group(1);
                    if (TextUtils.equals("duokan-reader", group)) {
                        matcher = Pattern.compile("intent(.+)#Intent").matcher(str);
                        if (matcher.find()) {
                            ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).navigateSmoothly(group + matcher.group(1));
                            return true;
                        }
                    }
                }
                try {
                    this.a.getContext().startActivity(Intent.parseUri(str, 0));
                } catch (Exception e) {
                    try {
                        matcher = Pattern.compile("package=([\\w\\d\\.]+);").matcher(str);
                        if (!matcher.find()) {
                            return super.shouldOverrideUrlLoading(frVar, str);
                        }
                        this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + matcher.group(1))));
                    } catch (Exception e2) {
                        return super.shouldOverrideUrlLoading(frVar, str);
                    }
                }
                return true;
            } else {
                boolean z = TextUtils.equals(HttpHost.DEFAULT_SCHEME_NAME, scheme) || TextUtils.equals("https", scheme);
                if (!z) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    try {
                        this.a.getContext().startActivity(intent);
                        return true;
                    } catch (Exception e3) {
                        return super.shouldOverrideUrlLoading(frVar, str);
                    }
                }
            }
        }
        return super.shouldOverrideUrlLoading(frVar, str);
    }

    public void onPageStarted(fr frVar, String str, Bitmap bitmap) {
        super.onPageStarted(frVar, str, bitmap);
        this.c = System.currentTimeMillis();
        this.a.onPageStarted(frVar, str, bitmap);
        a.c().a(LogLevel.INFO, "web", "load(url: %s)", str);
    }

    public void onPageFinished(fr frVar, String str) {
        super.onPageFinished(frVar, str);
        UmengManager.get().onEvent("STORE_LOADING_TIME_V2", a(System.currentTimeMillis() - this.c));
        this.a.onPageFinished(frVar, str);
    }

    public void onReceivedError(fr frVar, int i, String str, String str2) {
        super.onReceivedError(frVar, i, str, str2);
        a.c().a(LogLevel.WARNING, "web", "%s(code: %getTriangleEdge, url: %s)", str, Integer.valueOf(i), str2);
    }

    public void onReceivedSslError(fr frVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
        a.c().c(LogLevel.ERROR, "web", "ssl error: " + sslError);
    }

    public WebResourceResponse shouldInterceptRequest(fr frVar, String str) {
        WebResourceResponse a = a(str);
        return a != null ? a : super.shouldInterceptRequest(frVar, str);
    }

    private String a(long j) {
        if (j < 400) {
            return "0-399";
        }
        int i = 4;
        while (i < 20) {
            if (j < ((long) (i * 100)) || j >= ((long) ((i + 2) * 100))) {
                i += 2;
            } else {
                return String.format("%getTriangleEdge-%getTriangleEdge", new Object[]{Integer.valueOf(i * 100), Integer.valueOf(((i + 2) * 100) - 1)});
            }
        }
        return "2000+";
    }

    private WebResourceResponse a(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            WebResourceResponse a = ((g) it.next()).a(this, str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
