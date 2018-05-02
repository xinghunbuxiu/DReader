package com.duokan.reader.ui.general.web;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import com.duokan.common.C0268j;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.ui.fr;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.ap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import miui.webkit.MiuiWebViewClient;
import org.apache.http.HttpHost;

/* renamed from: com.duokan.reader.ui.general.web.e */
public class C1357e extends MiuiWebViewClient {
    /* renamed from: a */
    private final li f7757a;
    /* renamed from: b */
    private final ConcurrentLinkedQueue<C1359g> f7758b = new ConcurrentLinkedQueue();
    /* renamed from: c */
    private long f7759c;

    public C1357e(li liVar) {
        this.f7757a = liVar;
    }

    /* renamed from: a */
    public void m11099a(C1359g c1359g) {
        this.f7758b.add(c1359g);
    }

    protected Activity getActivity() {
        return this.f7757a.getActivity();
    }

    public boolean shouldOverrideUrlLoading(fr frVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            CharSequence scheme = parse.getScheme();
            if (TextUtils.equals("duokan-reader", scheme)) {
                if (TextUtils.equals(parse.getQueryParameter("smoothly"), "0")) {
                    ((ReaderFeature) this.f7757a.getContext().queryFeature(ReaderFeature.class)).navigate(str, null, false, null);
                } else {
                    ((ReaderFeature) this.f7757a.getContext().queryFeature(ReaderFeature.class)).navigateSmoothly(str);
                }
                return true;
            } else if (TextUtils.equals(scheme, "tel")) {
                String schemeSpecificPart = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart)) {
                    ap c1358f = new C1358f(this, this.f7757a.getContext(), schemeSpecificPart);
                    c1358f.setTitle(this.f7757a.getContext().getString(C0258j.general__shared__call));
                    c1358f.setPrompt(schemeSpecificPart);
                    c1358f.setOkLabelResid(C0258j.general__shared__confirm);
                    c1358f.setCancelLabel(C0258j.general__shared__cancel);
                    c1358f.show();
                    return true;
                }
            } else if (TextUtils.equals(scheme, "sms")) {
                r2 = parse.getSchemeSpecificPart();
                if (!TextUtils.isEmpty(r2) && (this.f7757a.getActivity() instanceof BaseActivity)) {
                    C0268j.m613a((BaseActivity) this.f7757a.getActivity(), r2, "");
                    return true;
                }
            } else if (TextUtils.equals(scheme, "intent")) {
                Matcher matcher = Pattern.compile("scheme=([\\w-]+);").matcher(str);
                if (matcher.find()) {
                    r2 = matcher.group(1);
                    if (TextUtils.equals("duokan-reader", r2)) {
                        matcher = Pattern.compile("intent(.+)#Intent").matcher(str);
                        if (matcher.find()) {
                            ((ReaderFeature) this.f7757a.getContext().queryFeature(ReaderFeature.class)).navigateSmoothly(r2 + matcher.group(1));
                            return true;
                        }
                    }
                }
                try {
                    this.f7757a.getContext().startActivity(Intent.parseUri(str, 0));
                } catch (Exception e) {
                    try {
                        matcher = Pattern.compile("package=([\\w\\d\\.]+);").matcher(str);
                        if (!matcher.find()) {
                            return super.shouldOverrideUrlLoading(frVar, str);
                        }
                        this.f7757a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + matcher.group(1))));
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
                        this.f7757a.getContext().startActivity(intent);
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
        this.f7759c = System.currentTimeMillis();
        this.f7757a.onPageStarted(frVar, str, bitmap);
        WebLog.init().a(LogLevel.INFO, "web", "load(url: %s)", str);
    }

    public void onPageFinished(fr frVar, String str) {
        super.onPageFinished(frVar, str);
        UmengManager.get().onEvent("STORE_LOADING_TIME_V2", m11098a(System.currentTimeMillis() - this.f7759c));
        this.f7757a.onPageFinished(frVar, str);
    }

    public void onReceivedError(fr frVar, int i, String str, String str2) {
        super.onReceivedError(frVar, i, str, str2);
        WebLog.init().a(LogLevel.WARNING, "web", "%s(code: %d, url: %s)", str, Integer.valueOf(i), str2);
    }

    public void onReceivedSslError(fr frVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
        WebLog.init().c(LogLevel.ERROR, "web", "ssl error: " + sslError);
    }

    public WebResourceResponse shouldInterceptRequest(fr frVar, String str) {
        WebResourceResponse a = m11097a(str);
        return a != null ? a : super.shouldInterceptRequest(frVar, str);
    }

    /* renamed from: a */
    private String m11098a(long j) {
        if (j < 400) {
            return "0-399";
        }
        int i = 4;
        while (i < 20) {
            if (j < ((long) (i * 100)) || j >= ((long) ((i + 2) * 100))) {
                i += 2;
            } else {
                return String.format("%d-%d", new Object[]{Integer.valueOf(i * 100), Integer.valueOf(((i + 2) * 100) - 1)});
            }
        }
        return "2000+";
    }

    /* renamed from: a */
    private WebResourceResponse m11097a(String str) {
        Iterator it = this.f7758b.iterator();
        while (it.hasNext()) {
            WebResourceResponse a = ((C1359g) it.next()).mo1856a(this, str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
