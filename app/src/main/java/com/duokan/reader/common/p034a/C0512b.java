package com.duokan.reader.common.p034a;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpResponseFactory;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpExpectationVerifier;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;

/* renamed from: com.duokan.reader.common.a.b */
public class C0512b {
    /* renamed from: a */
    static final /* synthetic */ boolean f1733a = (!C0512b.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final ExecutorService f1734b = Executors.newSingleThreadExecutor();
    /* renamed from: c */
    private final int f1735c;
    /* renamed from: d */
    private final Semaphore f1736d = new Semaphore(1);
    /* renamed from: e */
    private final ConcurrentLinkedQueue<C0515e> f1737e = new ConcurrentLinkedQueue();
    /* renamed from: f */
    private Thread f1738f = null;
    /* renamed from: g */
    private ExecutorService f1739g = null;
    /* renamed from: h */
    private ServerSocket f1740h = null;

    public C0512b(int i) {
        this.f1735c = i;
    }

    /* renamed from: a */
    public final int m2222a() {
        return this.f1735c;
    }

    /* renamed from: a */
    public final boolean m2223a(ExecutorService executorService, ConnectionReuseStrategy connectionReuseStrategy, HttpProcessor httpProcessor, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        if (!f1733a && this.f1738f != null) {
            throw new AssertionError();
        } else if (this.f1738f != null) {
            return false;
        } else {
            this.f1739g = executorService;
            HttpService a = m2217a(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerResolver, httpExpectationVerifier, httpParams);
            try {
                this.f1740h = new ServerSocket(this.f1735c);
                this.f1738f = new Thread(new C0513c(this, a));
                this.f1738f.start();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: b */
    public final void m2224b() {
        if (this.f1740h != null) {
            try {
                this.f1740h.close();
                this.f1738f.join();
                this.f1739g.shutdownNow();
                Iterator it = this.f1737e.iterator();
                while (it.hasNext()) {
                    ((C0515e) it.next()).shutdown();
                }
                while (!this.f1739g.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m2219a(HttpService httpService) {
        while (this.f1740h != null && !this.f1740h.isClosed()) {
            try {
                this.f1736d.acquire();
                Socket accept = this.f1740h.accept();
                Executor c = m2221c();
                C0515e c0515e = new C0515e();
                HttpContext basicHttpContext = new BasicHttpContext();
                this.f1737e.add(c0515e);
                try {
                    c0515e.bind(accept, httpService.getParams());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c.execute(new C0514d(this, c0515e, httpService, basicHttpContext));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private Executor m2221c() {
        return this.f1739g == null ? f1734b : this.f1739g;
    }

    /* renamed from: a */
    private HttpService m2217a(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        if (httpProcessor == null) {
            httpProcessor = new BasicHttpProcessor();
            httpProcessor.addInterceptor(new ResponseDate());
            httpProcessor.addInterceptor(new ResponseServer());
            httpProcessor.addInterceptor(new ResponseContent());
            httpProcessor.addInterceptor(new ResponseConnControl());
            httpProcessor.addInterceptor(new ResponseProcessCookies());
        }
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = new DefaultConnectionReuseStrategy();
        }
        if (httpResponseFactory == null) {
            httpResponseFactory = new DefaultHttpResponseFactory();
        }
        if (httpParams == null) {
            httpParams = new BasicHttpParams();
        }
        HttpService httpService = new HttpService(httpProcessor, connectionReuseStrategy, httpResponseFactory);
        httpService.setHandlerResolver(httpRequestHandlerResolver);
        httpService.setExpectationVerifier(httpExpectationVerifier);
        httpService.setParams(httpParams);
        return httpService;
    }
}
