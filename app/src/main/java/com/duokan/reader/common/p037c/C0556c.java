package com.duokan.reader.common.p037c;

import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.duokan.reader.common.c.c */
class C0556c extends DefaultRedirectHandler {
    /* renamed from: a */
    static final /* synthetic */ boolean f1836a = (!C0554a.class.desiredAssertionStatus());

    private C0556c() {
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
        HttpHost httpHost = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
        if (f1836a || httpHost != null) {
            URI resolve;
            URI resolve2;
            try {
                resolve = URIUtils.resolve(new URI(httpHost.toURI()), super.getLocationURI(httpResponse, httpContext));
            } catch (Exception e) {
                e.printStackTrace();
                resolve = null;
            }
            if (resolve == null || C0558e.m2469c(resolve.toString())) {
                try {
                    String value = httpResponse.getFirstHeader("Location").getValue();
                    if (value == null) {
                        return null;
                    }
                    resolve2 = URIUtils.resolve(new URI(httpHost.toURI()), new URI(C0558e.m2467a(httpResponse, value)));
                    if (resolve2 != null) {
                        return resolve2;
                    }
                    httpContext.setAttribute("_http.redirect_location", resolve2.toString());
                    if (f1836a && httpResponse.getStatusLine() == null) {
                        throw new AssertionError();
                    } else if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_PERMANENTLY) {
                        return resolve2;
                    } else {
                        httpContext.setAttribute("_http.permanent_redirect_location", resolve2.toString());
                        return resolve2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            resolve2 = resolve;
            if (resolve2 != null) {
                return resolve2;
            }
            httpContext.setAttribute("_http.redirect_location", resolve2.toString());
            if (f1836a) {
            }
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_PERMANENTLY) {
                return resolve2;
            }
            httpContext.setAttribute("_http.permanent_redirect_location", resolve2.toString());
            return resolve2;
        }
        throw new AssertionError();
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        boolean isRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
        return isRedirectRequested ? isRedirectRequested : isRedirectRequested;
    }
}
