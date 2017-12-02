package com.duokan.reader.common.c;

import android.content.Context;
import android.os.Looper;

import org.apache.http.HttpHost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

import java.util.HashMap;

public class a {
    static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());
    private static a b = null;
    private static final ThreadSafeClientConnManager c;
    private final Context d;
    private final DefaultHttpClient e;
    private final HashMap f = new HashMap();
    private boolean g = true;

    static {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        c = new ThreadSafeClientConnManager(b(null), schemeRegistry);
    }

    protected a(Context context) {
        this.d = context;
        this.e = a("", "Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
    }

    public synchronized void a(boolean z) {
        this.g = z;
    }

    public synchronized boolean a() {
        return this.g;
    }

    public synchronized DefaultHttpClient a(String str) {
        return a(str, "Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
    }

    public synchronized DefaultHttpClient a(String str, String str2) {
        DefaultHttpClient defaultHttpClient = null;
        synchronized (this) {
            if (str != null) {
                if (!this.f.containsKey(str)) {
                    HttpParams b = b(str2);
                    SchemeRegistry schemeRegistry = new SchemeRegistry();
                    schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
                    schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
                    defaultHttpClient = new d(this, c, b);
                    defaultHttpClient.setRedirectHandler(new c());
                    this.f.put(str, defaultHttpClient);
                }
            }
        }
        return defaultHttpClient;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (!a && Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new AssertionError();
            } else if (a || b == null) {
                b = new a(context);
            } else {
                throw new AssertionError();
            }
        }
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (a || b != null) {
                aVar = b;
            } else {
                throw new AssertionError();
            }
        }
        return aVar;
    }

    private static BasicHttpParams b(String str) {
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
