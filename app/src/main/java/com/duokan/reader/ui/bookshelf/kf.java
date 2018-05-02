package com.duokan.reader.ui.bookshelf;

import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p034a.C0511a;
import com.duokan.reader.domain.p044b.C0781b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URLConnection;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.FileEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class kf extends kn {
    /* renamed from: a */
    protected kr f6700a = null;
    /* renamed from: b */
    protected Runnable f6701b = null;

    /* renamed from: f */
    protected abstract void mo1724f();

    public kf(IFeature mFeature) {
        super(mFeature);
    }

    protected void onActive(boolean z) {
        HttpRequestHandlerResolver httpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
        httpRequestHandlerRegistry.register("*", new kg(this));
        httpRequestHandlerRegistry.register("/progress*", new kh(this));
        httpRequestHandlerRegistry.register("/files*", new ki(this));
        this.c.m2223a(Executors.newScheduledThreadPool(5), null, null, null, httpRequestHandlerRegistry, null, null);
        super.onActive(z);
    }

    /* renamed from: a */
    private void m9897a(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        String uri = httpRequest.getRequestLine().getUri();
        File file = new File(ReaderEnv.get().getWwwDirectory() + "/wifi");
        if (uri.equals("/")) {
            uri = "/font_index.html";
        }
        File file2 = new File(file, uri);
        if (Pattern.compile("lang.*js").matcher(file2.getName()).find()) {
            File file3;
            if (Locale.getDefault().equals(Locale.SIMPLIFIED_CHINESE)) {
                file3 = new File(file, "/scripts/lang.zh-Hans.js");
                if (file3.exists()) {
                    httpResponse.setEntity(new FileEntity(file3, URLConnection.guessContentTypeFromName(file3.getName())));
                    httpResponse.setStatusCode(HttpStatus.SC_OK);
                    return;
                }
            } else if (Locale.getDefault().equals(Locale.ENGLISH)) {
                file3 = new File(file, "/scripts/lang.en.js");
                if (file3.exists()) {
                    httpResponse.setEntity(new FileEntity(file3, URLConnection.guessContentTypeFromName(file3.getName())));
                    httpResponse.setStatusCode(HttpStatus.SC_OK);
                    return;
                }
            } else if (Locale.getDefault().equals(Locale.TRADITIONAL_CHINESE)) {
                file3 = new File(file, "/scripts/lang.zh-Hant.js");
                if (file3.exists()) {
                    httpResponse.setEntity(new FileEntity(file3, URLConnection.guessContentTypeFromName(file3.getName())));
                    httpResponse.setStatusCode(HttpStatus.SC_OK);
                    return;
                }
            }
        }
        if (file2.exists()) {
            httpResponse.setEntity(new FileEntity(file2, URLConnection.guessContentTypeFromName(file2.getName())));
            httpResponse.setStatusCode(HttpStatus.SC_OK);
            return;
        }
        httpResponse.setStatusCode(HttpStatus.SC_NOT_FOUND);
    }

    /* renamed from: b */
    private void m9899b(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            Matcher matcher = Pattern.compile("/progress/(.*)\\?.*").matcher(httpRequest.getRequestLine().getUri());
            if (matcher.matches()) {
                kr krVar = (kr) this.d.get(Uri.decode(matcher.group(1)));
                if (krVar != null) {
                    jSONObject.put("fileName", krVar.f6721a);
                    jSONObject.put("progress", (double) krVar.f6723c);
                    if (krVar.f6722b >= 0) {
                        jSONObject.put("size", krVar.f6722b);
                    }
                }
            }
        } catch (Exception e) {
        }
        HttpEntity entityTemplate = new EntityTemplate(new kj(this, jSONObject));
        entityTemplate.setContentType("text/json");
        httpResponse.setEntity(entityTemplate);
        httpResponse.setStatusCode(HttpStatus.SC_OK);
    }

    /* renamed from: c */
    private void m9901c(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        String uri = httpRequest.getRequestLine().getUri();
        if (uri.equals("/files")) {
            InputStream c0511a = new C0511a(((HttpEntityEnclosingRequest) httpRequest).getEntity());
            BufferedReader bufferedReader = new BufferedReader(new StringReader(m9877a(c0511a)));
            Pattern compile = Pattern.compile("Content-Disposition: .*filename=\"(.*)\"");
            uri = "";
            Object obj = "";
            for (CharSequence readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (TextUtils.isEmpty(obj)) {
                    obj = "\r\n" + readLine;
                } else {
                    Matcher matcher = compile.matcher(readLine);
                    if (matcher.matches()) {
                        String[] split;
                        uri = matcher.group(1);
                        if (uri.contains("//")) {
                            split = uri.split("/+");
                            uri = split[split.length - 1];
                        }
                        if (uri.contains("\\")) {
                            split = uri.split("\\\\+");
                            uri = split[split.length - 1];
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(uri)) {
                long a = ((c0511a.m2214a() - c0511a.m2215b()) - ((long) obj.length())) - ((long) "--\r\n".length());
                File file = new File(ReaderEnv.get().getUserFontDirectory(), uri + ".tmp");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[8192];
                this.f6700a = new kr();
                this.d.put(uri, this.f6700a);
                this.f6700a.f6721a = uri;
                this.f6700a.f6722b = a;
                long j = 0;
                while (j != a) {
                    try {
                        m9902i();
                        int min = (int) Math.min((long) c0511a.read(bArr), a - j);
                        fileOutputStream.write(bArr, 0, min);
                        j += (long) min;
                        if (c0511a.m2214a() >= 0) {
                            this.f6700a.f6723c = ((float) c0511a.m2215b()) / ((float) c0511a.m2214a());
                        }
                    } catch (Throwable th) {
                        try {
                            c0511a.close();
                            fileOutputStream.close();
                        } catch (Exception e) {
                        }
                        file.delete();
                        this.f6700a = null;
                        m9902i();
                    }
                }
                fileOutputStream.flush();
                try {
                    c0511a.close();
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                file.renameTo(new File(ReaderEnv.get().getUserFontDirectory(), uri));
                this.f6700a.f6723c = 1.0f;
                C0781b.m3667b().m3688a(true);
                this.f6700a = null;
                m9902i();
            }
            httpResponse.setStatusCode(HttpStatus.SC_OK);
        } else if (uri.startsWith("/files?")) {
            HttpEntity entityTemplate = new EntityTemplate(new kk(this));
            entityTemplate.setContentType("text/json");
            httpResponse.setStatusCode(HttpStatus.SC_OK);
            httpResponse.setEntity(entityTemplate);
        } else if (!uri.startsWith("/files/")) {
        }
    }

    /* renamed from: i */
    private void m9902i() {
        if (this.f6701b == null) {
            this.f6701b = new kl(this);
            runLater(this.f6701b, 500);
        }
    }

    /* renamed from: j */
    private String m9903j() {
        JSONArray jSONArray = new JSONArray();
        File[] listFiles = ReaderEnv.get().getUserFontDirectory().listFiles(new km(this));
        try {
            for (int length = listFiles.length - 1; length >= 0; length--) {
                File file = listFiles[length];
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", file.getName());
                jSONObject.put("size", DkPublic.formatBytes(file.length()));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
        }
        return jSONArray.toString();
    }
}
