package com.duokan.reader.common.webservices;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.c */
public class C0237c {
    /* renamed from: b */
    protected static final String f375b = C0237c.class.getName();
    /* renamed from: d */
    static final /* synthetic */ boolean f376d = (!C0237c.class.desiredAssertionStatus());
    /* renamed from: c */
    protected final WebSession f377c;

    public C0237c(WebSession webSession) {
        if (f376d || webSession != null) {
            this.f377c = webSession;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Bitmap m545a(String str) {
        InputStream c = mo376a(new C0626c().m2853a(HttpGet.METHOD_NAME).m2856b(str).m2851a()).mo817c();
        Options options = new Options();
        options.inDensity = 480;
        options.inScaled = false;
        Bitmap a = C0544a.m2439a(c, options);
        c.close();
        return a;
    }

    /* renamed from: b */
    public JSONObject m551b(String str) {
        return new JSONObject(m553c(str));
    }

    /* renamed from: c */
    public String m553c(String str) {
        return new String(m554d(str), HTTP.UTF_8);
    }

    /* renamed from: d */
    public byte[] m554d(String str) {
        return m552b(mo376a(new C0626c().m2853a(HttpGet.METHOD_NAME).m2856b(str).m2851a()));
    }

    /* renamed from: a */
    public boolean m549a(String str, File file, boolean z) {
        return mo376a(new C0626c().m2853a(HttpGet.METHOD_NAME).m2856b(str).m2851a()).mo813a(file) >= 0;
    }

    /* renamed from: a */
    public C0627d mo376a(C0624a c0624a) {
        return this.f377c.execute(c0624a);
    }

    /* renamed from: a */
    public JSONObject m547a(C0627d c0627d) {
        return new JSONObject(m550b(c0627d, HTTP.UTF_8));
    }

    /* renamed from: a */
    public JSONObject m548a(C0627d c0627d, String str) {
        return new JSONObject(m550b(c0627d, str));
    }

    /* renamed from: b */
    public String m550b(C0627d c0627d, String str) {
        return new String(m552b(c0627d), str);
    }

    /* renamed from: b */
    public byte[] m552b(C0627d c0627d) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(c0627d.mo816b() > 0 ? c0627d.mo816b() : 2048);
        c0627d.mo814a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
