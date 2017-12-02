package com.duokan.reader.domain.micloud;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class p implements ad {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public bj a() {
        return this.a.a.a();
    }

    public void a(bj bjVar) {
        this.a.a.a(bjVar);
        List<t> linkedList = new LinkedList();
        synchronized (this.a) {
            linkedList.addAll(this.a.c);
        }
        for (t a : linkedList) {
            a.a(this.a);
        }
    }

    public bi a(String str) {
        return this.a.a.a(str);
    }

    public Collection b(String str) {
        return this.a.a.b(str);
    }

    public void a(bi biVar) {
        this.a.a.a(biVar);
    }

    public void a(String str, Collection collection) {
        this.a.a.a(str, collection);
    }

    public void c(String str) {
        this.a.a.c(str);
    }

    public void a(Collection collection) {
        this.a.a.a(collection);
    }
}
