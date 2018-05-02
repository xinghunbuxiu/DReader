package com.duokan.reader.common.a;

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

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class b {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());
    private static final ExecutorService b = Executors.newSingleThreadExecutor();
    private final int c;
    private final Semaphore d = new Semaphore(1);
    private final ConcurrentLinkedQueue e = new ConcurrentLinkedQueue();
    private Thread f = null;
    private ExecutorService g = null;
    private ServerSocket h = null;

    public b(int i) {
        this.c = i;
    }

    public final int a() {
        return this.c;
    }

    public final boolean a(ExecutorService executorService, ConnectionReuseStrategy connectionReuseStrategy, HttpProcessor httpProcessor, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        if (!a && this.f != null) {
            throw new AssertionError();
        } else if (this.f != null) {
            return false;
        } else {
            this.g = executorService;
            HttpService a = a(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerResolver, httpExpectationVerifier, httpParams);
            try {
                this.h = new ServerSocket(this.c);
                this.f = new Thread(new c(this, a));
                this.f.start();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public final void b() {
        if (this.h != null) {
            try {
                this.h.close();
                this.f.join();
                this.g.shutdownNow();
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).shutdown();
                }
                while (!this.g.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(HttpService httpService) {
        while (this.h != null && !this.h.isClosed()) {
            try {
                this.d.acquire();
                Socket accept = this.h.accept();
                Executor c = c();
                e eVar = new e();
                HttpContext basicHttpContext = new BasicHttpContext();
                this.e.add(eVar);
                try {
                    eVar.bind(accept, httpService.getParams());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c.execute(new d(this, eVar, httpService, basicHttpContext));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private Executor c() {
        return this.g == null ? b : this.g;
    }

    private HttpService a(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
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
