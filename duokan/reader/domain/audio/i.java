package com.duokan.reader.domain.audio;

import android.text.TextUtils;

import com.duokan.reader.domain.document.y;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

import java.net.URLDecoder;

class i implements HttpRequestHandler {
    final /* synthetic */ g a;

    private i(g gVar) {
        this.a = gVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        a(httpRequest, httpResponse);
    }

    private void a(HttpRequest httpRequest, HttpResponse httpResponse) {
        long parseLong;
        y yVar;
        Header firstHeader = httpRequest.getFirstHeader("Range");
        if (firstHeader != null) {
            Object obj = firstHeader.getValue().replaceAll("bytes=", "").split("-")[0];
            if (!TextUtils.isEmpty(obj)) {
                parseLong = Long.parseLong(obj);
                yVar = (y) a(URLDecoder.decode(httpRequest.getRequestLine().getUri())).clone();
                yVar.reset();
                yVar.skip(parseLong);
                HttpEntity basicHttpEntity = new BasicHttpEntity();
                basicHttpEntity.setContent(yVar);
                basicHttpEntity.setContentLength(yVar.a());
                httpResponse.setEntity(basicHttpEntity);
            }
        }
        parseLong = 0;
        yVar = (y) a(URLDecoder.decode(httpRequest.getRequestLine().getUri())).clone();
        try {
            yVar.reset();
            yVar.skip(parseLong);
            HttpEntity basicHttpEntity2 = new BasicHttpEntity();
            basicHttpEntity2.setContent(yVar);
            basicHttpEntity2.setContentLength(yVar.a());
            httpResponse.setEntity(basicHttpEntity2);
        } catch (Exception e) {
        } finally {
            httpResponse.setHeader(HTTP.CONN_DIRECTIVE, "close");
            httpResponse.setHeader("Accept-Ranges", "bytes");
            httpResponse.setHeader("Content-Type", "audio/mpeg");
            httpResponse.setHeader("Content-Range", "bytes 0-" + (yVar.a() - 1) + "/" + yVar.a());
            httpResponse.setStatusCode(HttpStatus.SC_PARTIAL_CONTENT);
        }
    }

    private y a(String str) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        if (this.a.d.containsKey(str)) {
            return (y) this.a.d.get(str);
        }
        return null;
    }
}
