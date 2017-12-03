package com.duokan.reader.ui.bookshelf;

import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.a.a;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;

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

public abstract class iv extends jp {
    protected jt a = null;
    protected Runnable b = null;

    protected abstract void d();

    public iv(IFeature featrue) {
        super(featrue);
    }

    protected void onActive(boolean z) {
        HttpRequestHandlerResolver httpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
        httpRequestHandlerRegistry.register("*", new iw(this));
        httpRequestHandlerRegistry.register("/progress*", new ix(this));
        httpRequestHandlerRegistry.register("/files*", new iy(this));
        this.c.a(Executors.newScheduledThreadPool(5), null, null, null, httpRequestHandlerRegistry, null, null);
        super.onActive(z);
    }

    private void a(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
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

    private void b(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            Matcher matcher = Pattern.compile("/progress/(.*)\\?.*").matcher(httpRequest.getRequestLine().getUri());
            if (matcher.matches()) {
                jt jtVar = (jt) this.d.get(Uri.decode(matcher.group(1)));
                if (jtVar != null) {
                    jSONObject.put("fileName", jtVar.a);
                    jSONObject.put("progress", (double) jtVar.c);
                    if (jtVar.b >= 0) {
                        jSONObject.put("size", jtVar.b);
                    }
                }
            }
        } catch (Exception e) {
        }
        HttpEntity entityTemplate = new EntityTemplate(new iz(this, jSONObject));
        entityTemplate.setContentType("text/json");
        httpResponse.setEntity(entityTemplate);
        httpResponse.setStatusCode(HttpStatus.SC_OK);
    }

    private void c(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        String uri = httpRequest.getRequestLine().getUri();
        File file;
        if (uri.equals("/files")) {
            InputStream aVar = new a(((HttpEntityEnclosingRequest) httpRequest).getEntity());
            BufferedReader bufferedReader = new BufferedReader(new StringReader(a(aVar)));
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
                long a = ((aVar.a() - aVar.b()) - ((long) obj.length())) - ((long) "--\r\n".length());
                file = new File(ReaderEnv.get().getWiFiDirectory(), uri + ".tmp");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[8192];
                this.a = new jt();
                this.d.put(uri, this.a);
                this.a.a = uri;
                this.a.b = a;
                long j = 0;
                while (j != a) {
                    try {
                        i();
                        int min = (int) Math.min((long) aVar.read(bArr), a - j);
                        fileOutputStream.write(bArr, 0, min);
                        j += (long) min;
                        if (aVar.a() >= 0) {
                            this.a.c = ((float) aVar.b()) / ((float) aVar.a());
                        }
                    } catch (Throwable th) {
                        try {
                            aVar.close();
                            fileOutputStream.close();
                        } catch (Exception e) {
                        }
                        file.delete();
                        this.a = null;
                        i();
                    }
                }
                fileOutputStream.flush();
                try {
                    aVar.close();
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                file.renameTo(new File(ReaderEnv.get().getWiFiDirectory(), uri));
                ai.a().a(r4);
                TaskHandler.postTask(new ja(this));
                this.a.c = 1.0f;
                this.a = null;
                i();
            }
            httpResponse.setStatusCode(HttpStatus.SC_OK);
        } else if (uri.startsWith("/files?")) {
            r2 = new EntityTemplate(new jb(this));
            r2.setContentType("text/json");
            httpResponse.setStatusCode(HttpStatus.SC_OK);
            httpResponse.setEntity(r2);
        } else if (uri.startsWith("/files/")) {
            c a2 = a(Uri.decode(uri.substring("/files/".length())));
            if (a2 == null) {
                httpResponse.setStatusCode(HttpStatus.SC_NOT_FOUND);
                return;
            }
            file = new File(a2.e());
            if (httpRequest.getRequestLine().getMethod().equals(HttpPost.METHOD_NAME)) {
                ai.a().a(a2, true);
                file.delete();
            } else if (httpRequest.getRequestLine().getMethod().equals(HttpGet.METHOD_NAME)) {
                r2 = new FileEntity(file, URLConnection.guessContentTypeFromName(file.getName()));
                httpResponse.setHeader(MIME.CONTENT_DISPOSITION, "attachment; ");
                httpResponse.setEntity(r2);
                httpResponse.setStatusCode(HttpStatus.SC_OK);
            }
        }
    }

    private void i() {
        if (this.b == null) {
            this.b = new jc(this);
            runLater(this.b, 500);
        }
    }

    private String j() {
        c[] i = ai.a().i();
        JSONArray jSONArray = new JSONArray();
        File[] k = k();
        try {
            for (int length = i.length - 1; length >= 0; length--) {
                Object obj;
                c cVar = i[length];
                File file = new File(Uri.parse(cVar.f()).getPath());
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
                    jSONObject.put("size", DkPublic.formatBytes(cVar.C()));
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
        }
        return jSONArray.toString();
    }

    private File[] k() {
        File[] wiFiDirectories = ReaderEnv.get().getWiFiDirectories();
        File[] fileArr = new File[(wiFiDirectories.length + 1)];
        fileArr[0] = ReaderEnv.get().getWiFiDirectory();
        for (int i = 1; i < fileArr.length; i++) {
            fileArr[i] = wiFiDirectories[i - 1];
        }
        return fileArr;
    }

    private c a(String str) {
        try {
            for (File file : k()) {
                File file2 = new File(file, str);
                c d = ai.a().d(file2.getCanonicalPath());
                if (d != null && file2.exists()) {
                    return d;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
