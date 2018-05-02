package com.duokan.reader.common.webservices.duokan.p040a;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;

/* renamed from: com.duokan.reader.common.webservices.duokan.a.c */
public class C0626c {
    /* renamed from: a */
    private String f2086a;
    /* renamed from: b */
    private String f2087b;
    /* renamed from: c */
    private Map<String, List<String>> f2088c;
    /* renamed from: d */
    private List<NameValuePair> f2089d;
    /* renamed from: e */
    private byte[] f2090e;
    /* renamed from: f */
    private File f2091f;
    /* renamed from: g */
    private String f2092g;

    public C0626c(C0624a c0624a) {
        this.f2086a = c0624a.f2079a;
        this.f2087b = c0624a.f2080b;
        this.f2088c = c0624a.f2081c;
        this.f2089d = c0624a.f2082d;
        this.f2090e = c0624a.f2083e;
    }

    /* renamed from: a */
    public C0624a m2851a() {
        if (this.f2088c == null) {
            this.f2088c = new HashMap();
        }
        if (this.f2089d == null) {
            this.f2089d = new LinkedList();
        }
        if (this.f2087b == null) {
            this.f2087b = HttpGet.METHOD_NAME;
        }
        return new C0624a();
    }

    /* renamed from: a */
    public C0626c m2853a(String str) {
        this.f2087b = str;
        return this;
    }

    /* renamed from: b */
    public C0626c m2856b(String str) {
        this.f2086a = str;
        return this;
    }

    /* renamed from: a */
    public C0626c m2854a(List<NameValuePair> list) {
        this.f2089d = list;
        return this;
    }

    /* renamed from: a */
    public C0626c m2855a(byte[] bArr) {
        this.f2090e = bArr;
        return this;
    }

    /* renamed from: a */
    public C0626c m2852a(File file) {
        this.f2091f = file;
        return this;
    }

    /* renamed from: c */
    public C0626c m2857c(String str) {
        this.f2092g = str;
        return this;
    }
}
