package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.sbk.b;
import com.duokan.reader.domain.document.sbk.f;
import com.duokan.reader.domain.document.txt.p;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public abstract class a {
    private long a;
    private long b;
    private long c;
    private long d;
    private av e;
    private av f;
    private String g;
    private String h;

    public abstract AnnotationType a();

    public abstract a l();

    protected a() {
    }

    public long b() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public long c() {
        return this.b;
    }

    public void b(long j) {
        this.b = j;
    }

    public av d() {
        return this.e;
    }

    public void a(av avVar) {
        this.e = avVar;
    }

    public av e() {
        return this.f;
    }

    public void b(av avVar) {
        this.f = avVar;
    }

    public String f() {
        return this.g;
    }

    public String a(boolean z) {
        if (z) {
            return DkUtils.chs2chtText(f());
        }
        return f();
    }

    public void a(String str) {
        this.g = str;
    }

    public long g() {
        return this.c;
    }

    public void c(long j) {
        this.c = j;
    }

    public long h() {
        return this.d;
    }

    public void d(long j) {
        this.d = j;
    }

    public String i() {
        return this.h;
    }

    public void b(String str) {
        this.h = str;
    }

    public static a a(AnnotationType annotationType, String str) {
        if (annotationType == AnnotationType.BOOKMARK) {
            return c(str);
        }
        if (annotationType == AnnotationType.COMMENT) {
            return d(str);
        }
        return null;
    }

    public static a c(String str) {
        a ahVar = new ah();
        ahVar.c(System.currentTimeMillis());
        ahVar.d(System.currentTimeMillis());
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        ahVar.b(str);
        return ahVar;
    }

    public static a d(String str) {
        a efVar = new ef();
        efVar.c(System.currentTimeMillis());
        efVar.d(System.currentTimeMillis());
        if (TextUtils.isEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        efVar.b(str);
        return efVar;
    }

    public void a(BookFormat bookFormat, String str) {
        if (TextUtils.isEmpty(str)) {
            switch (b.a[bookFormat.ordinal()]) {
                case 1:
                    this.e = s.a(0, 0, 0);
                    this.f = s.a(0, 0, 0);
                    return;
                case 2:
                    this.e = f.a(0, 0, 0);
                    this.f = f.a(0, 0, 0);
                    return;
                case 3:
                    this.e = p.b(0);
                    this.f = p.b(0);
                    return;
                case 4:
                    this.e = d.a(0, 0, 0);
                    this.f = d.a(0, 0, 0);
                    return;
                default:
                    return;
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            JSONObject jSONObject2 = jSONArray.getJSONObject(1);
            switch (b.a[bookFormat.ordinal()]) {
                case 1:
                    this.e = c.a(jSONObject);
                    this.f = c.a(jSONObject2);
                    return;
                case 2:
                    this.e = b.a(jSONObject);
                    this.f = b.a(jSONObject2);
                    return;
                case 3:
                    this.e = com.duokan.reader.domain.document.txt.b.a(jSONObject);
                    this.f = com.duokan.reader.domain.document.txt.b.a(jSONObject2);
                    return;
                case 4:
                    this.e = com.duokan.reader.domain.document.a.a.a(jSONObject);
                    this.f = com.duokan.reader.domain.document.a.a.a(jSONObject2);
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
        }
    }

    public String j() {
        return "";
    }

    public String k() {
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(0, this.e.f());
            jSONArray.put(1, this.f.f());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }
}
