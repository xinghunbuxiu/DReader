package com.duokan.reader.common.c;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

import java.net.URI;

class c extends DefaultRedirectHandler {
    static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());

    private c() {
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
        HttpHost httpHost = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
        if (a || httpHost != null) {
            URI resolve;
            URI resolve2;
            try {
                resolve = URIUtils.resolve(new URI(httpHost.toURI()), super.getLocationURI(httpResponse, httpContext));
            } catch (Exception e) {
                e.printStackTrace();
                resolve = null;
            }
            if (resolve == null || e.c(resolve.toString())) {
                try {
                    String value = httpResponse.getFirstHeader("Location").getValue();
                    if (value == null) {
                        return null;
                    }
                    resolve2 = URIUtils.resolve(new URI(httpHost.toURI()), new URI(e.a(httpResponse, value)));
                    if (resolve2 != null) {
                        return resolve2;
                    }
                    httpContext.setAttribute("_http.redirect_location", resolve2.toString());
                    if (a && httpResponse.getStatusLine() == null) {
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
            if (a) {
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
