package com.duokan.reader.domain.bookshelf;

import java.util.List;

class ba implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f2801a;
    /* renamed from: b */
    final /* synthetic */ ar f2802b;

    ba(ar arVar, List list) {
        this.f2802b = arVar;
        this.f2801a = list;
    }

    public void run() {
        try {
            this.f2802b.k.mo1090a();
            for (C0800c c0800c : this.f2801a) {
                if (c0800c.am() == null) {
                    is a = this.f2802b.f2762b.m4712a(c0800c);
                    if (a != null) {
                        c0800c.m4189a(a);
                        c0800c.aN();
                    }
                }
            }
        } finally {
            this.f2802b.k.mo1096b();
        }
    }
}
