package com.duokan.reader.domain.audio;

import android.text.TextUtils;
import com.duokan.reader.domain.document.C1012y;
import java.net.URLDecoder;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

/* renamed from: com.duokan.reader.domain.audio.i */
class C0778i implements HttpRequestHandler {
    /* renamed from: a */
    final /* synthetic */ C0776g f2618a;

    private C0778i(C0776g c0776g) {
        this.f2618a = c0776g;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        m3655a(httpRequest, httpResponse);
    }

    /* renamed from: a */
    private void m3655a(HttpRequest httpRequest, HttpResponse httpResponse) {
        long parseLong;
        C1012y c1012y;
        Header firstHeader = httpRequest.getFirstHeader("Range");
        if (firstHeader != null) {
            Object obj = firstHeader.getValue().replaceAll("bytes=", "").split("-")[0];
            if (!TextUtils.isEmpty(obj)) {
                parseLong = Long.parseLong(obj);
                c1012y = (C1012y) m3654a(URLDecoder.decode(httpRequest.getRequestLine().getUri())).clone();
                c1012y.reset();
                c1012y.skip(parseLong);
                HttpEntity basicHttpEntity = new BasicHttpEntity();
                basicHttpEntity.setContent(c1012y);
                basicHttpEntity.setContentLength(c1012y.m7783a());
                httpResponse.setEntity(basicHttpEntity);
            }
        }
        parseLong = 0;
        c1012y = (C1012y) m3654a(URLDecoder.decode(httpRequest.getRequestLine().getUri())).clone();
        try {
            c1012y.reset();
            c1012y.skip(parseLong);
            HttpEntity basicHttpEntity2 = new BasicHttpEntity();
            basicHttpEntity2.setContent(c1012y);
            basicHttpEntity2.setContentLength(c1012y.m7783a());
            httpResponse.setEntity(basicHttpEntity2);
        } catch (Exception e) {
        } finally {
            httpResponse.setHeader(HTTP.CONN_DIRECTIVE, "close");
            httpResponse.setHeader("Accept-Ranges", "bytes");
            httpResponse.setHeader("Content-Type", "audio/mpeg");
            httpResponse.setHeader("Content-Range", "bytes 0-" + (c1012y.m7783a() - 1) + "/" + c1012y.m7783a());
            httpResponse.setStatusCode(HttpStatus.SC_PARTIAL_CONTENT);
        }
    }

    /* renamed from: a */
    private C1012y m3654a(String str) {
        if (str.startsWith("/")) {
            Object str2 = str2.substring(1);
        }
        if (this.f2618a.f2616d.containsKey(str2)) {
            return (C1012y) this.f2618a.f2616d.get(str2);
        }
        return null;
    }
}
