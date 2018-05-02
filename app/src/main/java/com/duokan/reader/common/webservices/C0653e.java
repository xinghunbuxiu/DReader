package com.duokan.reader.common.webservices;

import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.p027b.p028a.C0321b;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.iflytek.speech.VoiceWakeuperAidl;
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
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.common.webservices.e */
class C0653e implements C0627d {
    /* renamed from: a */
    public final C0624a f2191a;
    /* renamed from: b */
    public HttpURLConnection f2192b = null;
    /* renamed from: c */
    public InputStream f2193c = null;
    /* renamed from: d */
    public OutputStream f2194d = null;
    /* renamed from: e */
    final /* synthetic */ WebSession f2195e;

    public C0653e(WebSession webSession, C0624a c0624a) {
        this.f2195e = webSession;
        this.f2191a = c0624a;
    }

    /* renamed from: a */
    public int mo812a() {
        return this.f2192b.getResponseCode();
    }

    /* renamed from: a */
    public List<String> mo815a(String str) {
        try {
            if (this.f2192b.getResponseCode() == HttpStatus.SC_OK) {
                return (List) this.f2192b.getHeaderFields().get(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: b */
    public int mo816b() {
        return this.f2192b.getContentLength();
    }

    /* renamed from: c */
    public InputStream mo817c() {
        return this.f2193c;
    }

    /* renamed from: a */
    public long mo814a(OutputStream outputStream) {
        return C0321b.m728a(this.f2192b, outputStream, this.f2195e.mHttpConfig);
    }

    /* renamed from: a */
    public long mo813a(File file) {
        return C0321b.m727a(this.f2192b, file, this.f2195e.mHttpConfig);
    }

    /* renamed from: d */
    public void mo818d() {
        try {
            if (this.f2193c != null) {
                this.f2193c.close();
            }
        } catch (Throwable th) {
        }
        try {
            if (this.f2194d != null) {
                this.f2194d.close();
            }
        } catch (Throwable th2) {
        }
        if (this.f2192b != null) {
            this.f2192b.disconnect();
        }
    }

    /* renamed from: e */
    public void m3091e() {
        StringBuilder stringBuilder;
        HttpLogger access$400 = WebSession.sHttpLogger;
        if (access$400 != null) {
            stringBuilder = new StringBuilder();
        } else {
            stringBuilder = null;
        }
        if (stringBuilder != null) {
            stringBuilder.append(this.f2191a.m2833a() + " " + this.f2191a.m2836b());
        }
        synchronized (WebSession.sHttpCountingMap) {
            long access$1000;
            int i;
            String b = this.f2191a.m2836b();
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
                WebLog.init().a(LogLevel.WARNING, HttpHost.DEFAULT_SCHEME_NAME, "too frequent requests(%d times within 100s) on %s", Integer.valueOf(i), this.f2191a.m2836b());
            }
        }
        if (ManagedApp.get().getRunningState() != RunningState.FOREGROUND && ManagedApp.get().getRunningStateMillis() > TimeUnit.MINUTES.toMillis(1) && C0559f.m2476b().m2484c()) {
            WebLog.init().a(LogLevel.WARNING, HttpHost.DEFAULT_SCHEME_NAME, "background request through a mobile network on %s", this.f2191a.m2836b());
        }
        URL url = new URL(this.f2191a.m2836b());
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        String str;
        this.f2192b = (HttpURLConnection) url.openConnection();
        Map h = this.f2191a.m2843h();
        if (this.f2191a.m2833a().equals(HttpPost.METHOD_NAME) && !h.containsKey("Content-Type")) {
            if (this.f2191a.m2841f() != null) {
                this.f2192b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f2191a.m2842g());
                this.f2192b.setRequestProperty(HTTP.CONTENT_LEN, String.valueOf(this.f2191a.m2841f().length()));
            } else if (this.f2191a.m2840e() != null) {
                this.f2192b.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");
            } else {
                this.f2192b.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            }
            if (stringBuilder != null) {
                stringBuilder.append("\n");
                stringBuilder.append("Content-Type");
                stringBuilder.append(": ");
                stringBuilder.append(this.f2192b.getRequestProperty("Content-Type"));
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
                            stringBuilder2.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
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
                    this.f2192b.setRequestProperty(str2, stringBuilder2.toString());
                }
            }
        }
        str = this.f2191a.m2833a();
        C0624a c0624a = this.f2191a;
        HttpURLConnection httpURLConnection;
        if (str.equals(HttpGet.METHOD_NAME)) {
            httpURLConnection = this.f2192b;
            c0624a = this.f2191a;
            httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
            if (this.f2195e.mCacheStrategy == CacheStrategy.DISABLE_CACHE || this.f2195e.mCacheStrategy == CacheStrategy.DO_NOT_USE_CACHE) {
                this.f2192b.setUseCaches(false);
            } else {
                this.f2192b.setUseCaches(true);
            }
        } else {
            this.f2192b.setUseCaches(false);
            httpURLConnection = this.f2192b;
            c0624a = this.f2191a;
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            this.f2192b.setDoInput(true);
            this.f2192b.setDoOutput(true);
            try {
                this.f2194d = this.f2192b.getOutputStream();
                if (this.f2191a.m2841f() != null) {
                    byte[] bArr = new byte[1024];
                    InputStream fileInputStream = new FileInputStream(this.f2191a.m2841f());
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        this.f2194d.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                } else if (this.f2191a.m2840e() != null) {
                    this.f2194d.write(this.f2191a.m2840e());
                } else if (this.f2191a.m2839d() != null) {
                    List<NameValuePair> d = this.f2191a.m2839d();
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
                        this.f2194d.write(stringBuilder3.toString().getBytes(HTTP.UTF_8));
                    }
                }
                if (this.f2194d != null) {
                    try {
                        this.f2194d.close();
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
        this.f2192b.connect();
        if (this.f2192b.getResponseCode() >= HttpStatus.SC_BAD_REQUEST) {
            WebLog.init().a(LogLevel.WARNING, HttpHost.DEFAULT_SCHEME_NAME, "bad request(%d) on %s", Integer.valueOf(this.f2192b.getResponseCode()), this.f2191a.m2836b());
            return;
        }
        this.f2193c = this.f2192b.getInputStream();
    }
}
