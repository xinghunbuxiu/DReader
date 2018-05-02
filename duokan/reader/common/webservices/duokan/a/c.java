package com.duokan.reader.common.webservices.duokan.a;

import org.apache.http.client.methods.HttpGet;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c {
    private String a;
    private String b;
    private Map c;
    private List d;
    private byte[] e;
    private File f;
    private String g;

    public c(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public a a() {
        if (this.c == null) {
            this.c = new HashMap();
        }
        if (this.d == null) {
            this.d = new LinkedList();
        }
        if (this.b == null) {
            this.b = HttpGet.METHOD_NAME;
        }
        return new a();
    }

    public c a(String str) {
        this.b = str;
        return this;
    }

    public c b(String str) {
        this.a = str;
        return this;
    }

    public c a(List list) {
        this.d = list;
        return this;
    }

    public c a(byte[] bArr) {
        this.e = bArr;
        return this;
    }

    public c a(File file) {
        this.f = file;
        return this;
    }

    public c c(String str) {
        this.g = str;
        return this;
    }
}
