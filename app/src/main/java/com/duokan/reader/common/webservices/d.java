package com.duokan.reader.common.webservices;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;

import com.duokan.reader.common.bitmap.a;
import com.duokan.reader.common.webservices.duokan.a.c;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class d {
    protected static final String b = d.class.getName();
    static final /* synthetic */ boolean d = (!d.class.desiredAssertionStatus());
    protected final WebSession c;

    public d(WebSession webSession) {
        if (d || webSession != null) {
            this.c = webSession;
            return;
        }
        throw new AssertionError();
    }

    public Bitmap a(String str) {
        InputStream c = a(new c().a(HttpGet.METHOD_NAME).b(str).a()).c();
        Options options = new Options();
        options.inDensity = 480;
        options.inScaled = false;
        Bitmap a = a.a(c, options);
        c.close();
        return a;
    }

    public JSONObject b(String str) {
        return new JSONObject(c(str));
    }

    public String c(String str) {
        return new String(d(str), HTTP.UTF_8);
    }

    public byte[] d(String str) {
        return b(a(new c().a(HttpGet.METHOD_NAME).b(str).a()));
    }

    public boolean a(String str, File file, boolean z) {
        return a(new c().a(HttpGet.METHOD_NAME).b(str).a()).a(file) >= 0;
    }

    public com.duokan.reader.common.webservices.duokan.a.d a(com.duokan.reader.common.webservices.duokan.a.a aVar) {
        return this.c.execute(aVar);
    }

    public JSONObject a(com.duokan.reader.common.webservices.duokan.a.d dVar) {
        return new JSONObject(b(dVar, HTTP.UTF_8));
    }

    public JSONObject a(com.duokan.reader.common.webservices.duokan.a.d dVar, String str) {
        return new JSONObject(b(dVar, str));
    }

    public String b(com.duokan.reader.common.webservices.duokan.a.d dVar, String str) {
        return new String(b(dVar), str);
    }

    public byte[] b(com.duokan.reader.common.webservices.duokan.a.d dVar) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(dVar.b() > 0 ? dVar.b() : 2048);
        dVar.a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
