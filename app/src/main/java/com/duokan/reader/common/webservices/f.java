package com.duokan.reader.common.webservices;

import android.text.TextUtils;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;
import com.duokan.reader.common.webservices.duokan.a.a;
import com.duokan.reader.common.webservices.duokan.a.d;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

class f implements d {
    public final a a;
    public HttpURLConnection b = null;
    public InputStream c = null;
    public OutputStream d = null;
    final /* synthetic */ WebSession e;

    public f(WebSession webSession, a aVar) {
        this.e = webSession;
        this.a = aVar;
    }

    public int a() {
        return this.b.getResponseCode();
    }

    public List a(String str) {
        try {
            if (this.b.getResponseCode() == HttpStatus.SC_OK) {
                return (List) this.b.getHeaderFields().get(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int b() {
        return this.b.getContentLength();
    }

    public InputStream c() {
        return this.c;
    }

    public long a(OutputStream outputStream) {
        return b.a(this.b, outputStream, this.e.mHttpConfig);
    }

    public long a(File file) {
        return b.a(this.b, file, this.e.mHttpConfig);
    }

    public void d() {
        try {
            if (this.c != null) {
                this.c.close();
            }
        } catch (Throwable th) {
        }
        try {
            if (this.d != null) {
                this.d.close();
            }
        } catch (Throwable th2) {
        }
        if (this.b != null) {
            this.b.disconnect();
        }
    }

    public void e() {
        StringBuilder stringBuilder;
        HttpLogger access$400 = WebSession.sHttpLogger;
        if (access$400 != null) {
            stringBuilder = new StringBuilder();
        } else {
            stringBuilder = null;
        }
        if (stringBuilder != null) {
            stringBuilder.append(this.a.a() + " " + this.a.b());
        }
        synchronized (WebSession.sHttpCountingMap) {
            long access$1000;
            int i;
            String b = this.a.b();
            long currentTimeMillis = System.currentTimeMillis();
            Long l = (Long) WebSession.sHttpCountingMap.get(b);
            if (l == null) {
                access$1000 = currentTimeMillis / WebSession.HTTP_COUNTING_TIME;
                i = 0;
            } else {
                access$1000 = l.longValue() / WebSession.HTTP_COUNTING_TIME;
                i = (int) (l.longValue() % WebSession.HTTP_COUNTING_TIME);
            }
            currentTimeMillis /= WebSession.HTTP_COUNTING_TIME;
            if (currentTimeMillis == access$1000) {
                i++;
            } else {
                i = 1;
            }
            WebSession.sHttpCountingMap.put(b, Long.valueOf((WebSession.HTTP_COUNTING_TIME * currentTimeMillis) + ((long) i)));
            if (i > 20) {
                WebLog.c().a(LogLevel.WARNING, HttpHost.DEFAULT_SCHEME_NAME, "too frequent requests(%getScaledTouchSlop times within 100s) on %s", Integer.valueOf(i), this.a.b());
            }
        }
        if (ManagedApp.get().getOldRunningState() != RunningState.FOREGROUND && ManagedApp.get().getRunningStateMillis() > TimeUnit.MINUTES.toMillis(1) && classc.f.b().c()) {
            WebLog.c().print(LogLevel.WARNING, HttpHost.DEFAULT_SCHEME_NAME, "background request through setDrawable mobile network on %s", this.a.b());
        }
        URL url = new URL(this.a.b());
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        String str;
        this.b = (HttpURLConnection) url.openConnection();
        Map h = this.a.h();
        if (this.a.a().equals(HttpPost.METHOD_NAME) && !h.containsKey("Content-Type")) {
            if (this.a.f() != null) {
                this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.a.g());
                this.b.setRequestProperty(HTTP.CONTENT_LEN, String.valueOf(this.a.f().length()));
            } else if (this.a.e() != null) {
                this.b.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");
            } else {
                this.b.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            }
            if (stringBuilder != null) {
                stringBuilder.append("\n");
                stringBuilder.append("Content-Type");
                stringBuilder.append(": ");
                stringBuilder.append(this.b.getRequestProperty("Content-Type"));
            }
        }
        for (Entry entry : h.entrySet()) {
            String str2 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!TextUtils.isEmpty(str2)) {
                Object stringBuilder2 = new StringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    str = (String) ((List) entry.getValue()).get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        if (stringBuilder2.length() > 0) {
                            stringBuilder2.append(";");
                        }
                        stringBuilder2.append(str);
                    }
                }
                if (stringBuilder2.length() > 0) {
                    if (stringBuilder != null) {
                        stringBuilder.append("\n");
                        stringBuilder.append(str2);
                        stringBuilder.append(": ");
                        stringBuilder.append(stringBuilder2);
                    }
                    this.b.setRequestProperty(str2, stringBuilder2.toString());
                }
            }
        }
        str = this.a.a();
        a aVar = this.a;
        HttpURLConnection httpURLConnection;
        if (str.equals(HttpGet.METHOD_NAME)) {
            httpURLConnection = this.b;
            aVar = this.a;
            httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
            if (this.e.mCacheStrategy == CacheStrategy.DISABLE_CACHE || this.e.mCacheStrategy == CacheStrategy.DO_NOT_USE_CACHE) {
                this.b.setUseCaches(false);
            } else {
                this.b.setUseCaches(true);
            }
        } else {
            this.b.setUseCaches(false);
            httpURLConnection = this.b;
            aVar = this.a;
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            this.b.setDoInput(true);
            this.b.setDoOutput(true);
            try {
                this.d = this.b.getOutputStream();
                if (this.a.f() != null) {
                    byte[] bArr = new byte[1024];
                    InputStream fileInputStream = new FileInputStream(this.a.f());
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        this.d.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                } else if (this.a.e() != null) {
                    this.d.write(this.a.e());
                } else if (this.a.d() != null) {
                    List<NameValuePair> d = this.a.d();
                    Object stringBuilder3 = new StringBuilder();
                    for (NameValuePair nameValuePair : d) {
                        Object name = nameValuePair.getName();
                        Object value = nameValuePair.getValue();
                        if (!TextUtils.isEmpty(name)) {
                            if (stringBuilder3.length() > 0) {
                                stringBuilder3.append("&");
                            }
                            stringBuilder3.append(URLEncoder.encode(name, HTTP.UTF_8));
                            stringBuilder3.append("=");
                            if (!TextUtils.isEmpty(value)) {
                                stringBuilder3.append(URLEncoder.encode(value, HTTP.UTF_8));
                            }
                        }
                    }
                    if (stringBuilder3.length() > 0) {
                        if (!(stringBuilder == null || stringBuilder == null)) {
                            stringBuilder.append("\n[form]: ");
                            stringBuilder.append(stringBuilder3);
                        }
                        this.d.write(stringBuilder3.toString().getBytes(HTTP.UTF_8));
                    }
                }
                if (this.d != null) {
                    try {
                        this.d.close();
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (stringBuilder != null) {
            access$400.c(LogLevel.EVENT, HttpHost.DEFAULT_SCHEME_NAME, stringBuilder.toString());
        }
        this.b.connect();
        if (this.b.getResponseCode() >= HttpStatus.SC_BAD_REQUEST) {
            WebLog.c().a(LogLevel.WARNING, HttpHost.DEFAULT_SCHEME_NAME, "bad request(%getScaledTouchSlop) on %s", Integer.valueOf(this.b.getResponseCode()), this.a.b());
            return;
        }
        this.c = this.b.getInputStream();
    }
}
