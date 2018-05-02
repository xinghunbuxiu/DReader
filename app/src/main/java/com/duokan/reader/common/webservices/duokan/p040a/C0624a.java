package com.duokan.reader.common.webservices.duokan.p040a;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* renamed from: com.duokan.reader.common.webservices.duokan.a.a */
public class C0624a {
    /* renamed from: a */
    private final String f2079a;
    /* renamed from: b */
    private final String f2080b;
    /* renamed from: c */
    private final Map<String, List<String>> f2081c;
    /* renamed from: d */
    private final List<NameValuePair> f2082d;
    /* renamed from: e */
    private final byte[] f2083e;
    /* renamed from: f */
    private final File f2084f;
    /* renamed from: g */
    private final String f2085g;

    private C0624a(C0626c c0626c) {
        this.f2079a = c0626c.f2086a;
        this.f2080b = c0626c.f2087b;
        this.f2081c = c0626c.f2088c;
        this.f2082d = c0626c.f2089d;
        this.f2083e = c0626c.f2090e;
        this.f2084f = c0626c.f2091f;
        this.f2085g = c0626c.f2092g;
    }

    /* renamed from: a */
    public String m2833a() {
        return this.f2080b;
    }

    /* renamed from: b */
    public String m2836b() {
        return this.f2079a;
    }

    /* renamed from: a */
    public synchronized void m2835a(String str, String str2) {
        List list = (List) this.f2081c.get(str);
        if (list == null) {
            list = new LinkedList();
            this.f2081c.put(str, list);
        }
        list.add(str2);
    }

    /* renamed from: c */
    public C0626c m2838c() {
        return new C0626c(this);
    }

    /* renamed from: d */
    public List<NameValuePair> m2839d() {
        return this.f2082d;
    }

    /* renamed from: e */
    public byte[] m2840e() {
        return this.f2083e;
    }

    /* renamed from: f */
    public File m2841f() {
        return this.f2084f;
    }

    /* renamed from: g */
    public String m2842g() {
        return this.f2085g;
    }

    /* renamed from: a */
    public List<String> m2834a(String str) {
        return (List) this.f2081c.get(str);
    }

    /* renamed from: h */
    public Map<String, List<String>> m2843h() {
        return this.f2081c;
    }

    /* renamed from: b */
    public void m2837b(String str, String str2) {
        List linkedList = new LinkedList();
        linkedList.add(str2);
        this.f2081c.put(str, linkedList);
    }
}
