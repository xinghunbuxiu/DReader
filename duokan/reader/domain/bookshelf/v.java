package com.duokan.reader.domain.bookshelf;

import java.util.LinkedList;
import java.util.List;

class v {
    public final c a;
    public final List b = new LinkedList();
    final /* synthetic */ c c;

    public v(c cVar, c cVar2) {
        this.c = cVar;
        this.a = cVar2;
    }

    public void a() {
        for (u a : this.b) {
            a.a();
        }
    }

    public void b() {
        for (u b : this.b) {
            b.b();
        }
    }

    public void c() {
        for (u c : this.b) {
            c.c();
        }
    }
}
