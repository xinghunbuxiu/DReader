package com.duokan.reader.common.p037c;

import android.content.Context;
import android.os.Looper;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* renamed from: com.duokan.reader.common.c.a */
public class C0554a {
    /* renamed from: a */
    static final /* synthetic */ boolean f1829a = (!C0554a.class.desiredAssertionStatus());
    /* renamed from: b */
    private static C0554a f1830b = null;
    /* renamed from: c */
    private static final ThreadSafeClientConnManager f1831c;
    /* renamed from: d */
    private final Context f1832d;
    /* renamed from: e */
    private final DefaultHttpClient f1833e;
    /* renamed from: f */
    private final HashMap<String, DefaultHttpClient> f1834f = new HashMap();
    /* renamed from: g */
    private boolean f1835g = true;

    static {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        f1831c = new ThreadSafeClientConnManager(C0554a.m2460b(null), schemeRegistry);
    }

    protected C0554a(Context context) {
        this.f1832d = context;
        this.f1833e = m2462a("", "Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
    }

    /* renamed from: a */
    public synchronized void m2463a(boolean z) {
        this.f1835g = z;
    }

    /* renamed from: a */
    public synchronized boolean m2464a() {
        return this.f1835g;
    }

    /* renamed from: a */
    public synchronized DefaultHttpClient m2461a(String str) {
        return m2462a(str, "Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
    }

    /* renamed from: a */
    public synchronized DefaultHttpClient m2462a(String str, String str2) {
        DefaultHttpClient defaultHttpClient = null;
        synchronized (this) {
            if (str != null) {
                if (!this.f1834f.containsKey(str)) {
                    HttpParams b = C0554a.m2460b(str2);
                    SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
                    SchemeRegistry schemeRegistry = new SchemeRegistry();
                    schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
                    schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
                    defaultHttpClient = new C0557d(this, f1831c, b);
                    defaultHttpClient.setRedirectHandler(new C0556c());
                    this.f1834f.put(str, defaultHttpClient);
                }
            }
        }
        return defaultHttpClient;
    }

    /* renamed from: a */
    public static synchronized void m2457a(Context context) {
        synchronized (C0554a.class) {
            if (!f1829a && Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new AssertionError();
            } else if (f1829a || f1830b == null) {
                f1830b = new C0554a(context);
            } else {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: b */
    public static synchronized C0554a m2459b() {
        C0554a c0554a;
        synchronized (C0554a.class) {
            if (f1829a || f1830b != null) {
                c0554a = f1830b;
            } else {
                throw new AssertionError();
            }
        }
        return c0554a;
    }

    /* renamed from: b */
    private static BasicHttpParams m2460b(String str) {
        Object basicHttpParams = new BasicHttpParams();
        if (str != null) {
            HttpProtocolParams.setUserAgent(basicHttpParams, str);
        }
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        ConnManagerParams.setTimeout(basicHttpParams, 60000);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 100);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(50));
        return basicHttpParams;
    }
}
