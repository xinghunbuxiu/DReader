package com.duokan.reader.ui.bookshelf;

import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.UThread;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p034a.C0511a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class jt extends kn {
    /* renamed from: a */
    protected kr f6681a = null;
    /* renamed from: b */
    protected Runnable f6682b = null;

    /* renamed from: f */
    protected abstract void mo1722f();

    public jt(IFeature mFeature) {
        super(mFeature);
    }

    protected void onActive(boolean z) {
        HttpRequestHandlerResolver httpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
        httpRequestHandlerRegistry.register("*", new ju(this));
        httpRequestHandlerRegistry.register("/progress*", new jv(this));
        httpRequestHandlerRegistry.register("/files*", new jw(this));
        this.c.m2223a(Executors.newScheduledThreadPool(5), null, null, null, httpRequestHandlerRegistry, null, null);
        super.onActive(z);
    }

    /* renamed from: a */
    private void m9884a(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        String uri = httpRequest.getRequestLine().getUri();
        File file = new File(ReaderEnv.get().getWwwDirectory() + "/wifi");
        if (uri.equals("/")) {
            uri = "/index.html";
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
    private void m9886b(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
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
        HttpEntity entityTemplate = new EntityTemplate(new jx(this, jSONObject));
        entityTemplate.setContentType("text/json");
        httpResponse.setEntity(entityTemplate);
        httpResponse.setStatusCode(HttpStatus.SC_OK);
    }

    /* renamed from: c */
    private void m9888c(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        String uri = httpRequest.getRequestLine().getUri();
        File file;
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
                file = new File(ReaderEnv.get().getWiFiDirectory(), uri + ".tmp");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[8192];
                this.f6681a = new kr();
                this.d.put(uri, this.f6681a);
                this.f6681a.f6721a = uri;
                this.f6681a.f6722b = a;
                long j = 0;
                while (j != a) {
                    try {
                        m9889i();
                        int min = (int) Math.min((long) c0511a.read(bArr), a - j);
                        fileOutputStream.write(bArr, 0, min);
                        j += (long) min;
                        if (c0511a.m2214a() >= 0) {
                            this.f6681a.f6723c = ((float) c0511a.m2215b()) / ((float) c0511a.m2214a());
                        }
                    } catch (Throwable th) {
                        try {
                            c0511a.close();
                            fileOutputStream.close();
                        } catch (Exception e) {
                        }
                        file.delete();
                        this.f6681a = null;
                        m9889i();
                    }
                }
                fileOutputStream.flush();
                try {
                    c0511a.close();
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                file.renameTo(new File(ReaderEnv.get().getWiFiDirectory(), uri));
                ai.m3980a().m3881a(r4);
                UThread.runOnThread(new jy(this));
                this.f6681a.f6723c = 1.0f;
                this.f6681a = null;
                m9889i();
            }
            httpResponse.setStatusCode(HttpStatus.SC_OK);
        } else if (uri.startsWith("/files?")) {
            r2 = new EntityTemplate(new jz(this));
            r2.setContentType("text/json");
            httpResponse.setStatusCode(HttpStatus.SC_OK);
            httpResponse.setEntity(r2);
        } else if (uri.startsWith("/files/")) {
            C0800c a2 = m9881a(Uri.decode(uri.substring("/files/".length())));
            if (a2 == null) {
                httpResponse.setStatusCode(HttpStatus.SC_NOT_FOUND);
                return;
            }
            file = new File(a2.m4222e());
            if (httpRequest.getRequestLine().getMethod().equals(HttpPost.METHOD_NAME)) {
                ai.m3980a().m3886a(a2, true);
                file.delete();
            } else if (httpRequest.getRequestLine().getMethod().equals(HttpGet.METHOD_NAME)) {
                r2 = new FileEntity(file, URLConnection.guessContentTypeFromName(file.getName()));
                httpResponse.setHeader(MIME.CONTENT_DISPOSITION, "attachment; ");
                httpResponse.setEntity(r2);
                httpResponse.setStatusCode(HttpStatus.SC_OK);
            }
        }
    }

    /* renamed from: i */
    private void m9889i() {
        if (this.f6682b == null) {
            this.f6682b = new ka(this);
            runLater(this.f6682b, 500);
        }
    }

    /* renamed from: j */
    private String m9890j() {
        C0800c[] i = ai.m3980a().m3934i();
        JSONArray jSONArray = new JSONArray();
        File[] k = m9891k();
        try {
            for (int length = i.length - 1; length >= 0; length--) {
                Object obj;
                C0800c c0800c = i[length];
                File file = new File(Uri.parse(c0800c.m4225f()).getPath());
                for (File canonicalPath : k) {
                    if (file.getCanonicalPath().startsWith(canonicalPath.getCanonicalPath())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", file.getName());
                    jSONObject.put("size", DkPublic.formatBytes(c0800c.m4151D()));
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
        }
        return jSONArray.toString();
    }

    /* renamed from: k */
    private File[] m9891k() {
        File[] wiFiDirectories = ReaderEnv.get().getWiFiDirectories();
        File[] fileArr = new File[(wiFiDirectories.length + 1)];
        fileArr[0] = ReaderEnv.get().getWiFiDirectory();
        for (int i = 1; i < fileArr.length; i++) {
            fileArr[i] = wiFiDirectories[i - 1];
        }
        return fileArr;
    }

    /* renamed from: a */
    private C0800c m9881a(String str) {
        try {
            for (File file : m9891k()) {
                File file2 = new File(file, str);
                C0800c d = ai.m3980a().m3920d(file2.getCanonicalPath());
                if (d != null && file2.exists()) {
                    return d;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
