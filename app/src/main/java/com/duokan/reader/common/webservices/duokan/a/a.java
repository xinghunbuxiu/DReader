package com.duokan.reader.common.webservices.duokan.a;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a {
    private final String a;
    private final String b;
    private final Map c;
    private final List d;
    private final byte[] e;
    private final File f;
    private final String g;

    private a(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public synchronized void a(String str, String str2) {
        List list = (List) this.c.get(str);
        if (list == null) {
            list = new LinkedList();
            this.c.put(str, list);
        }
        list.add(str2);
    }

    public c c() {
        return new c(this);
    }

    public List d() {
        return this.d;
    }

    public byte[] e() {
        return this.e;
    }

    public File f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public List a(String str) {
        return (List) this.c.get(str);
    }

    public Map h() {
        return this.c;
    }

    public void b(String str, String str2) {
        List linkedList = new LinkedList();
        linkedList.add(str2);
        this.c.put(str, linkedList);
    }
}
