package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.a.g;

class tn implements g {
    final /* synthetic */ tc a;

    tn(tc tcVar) {
        this.a = tcVar;
    }

    public void a(int i) {
        if (this.a.c != i) {
            this.a.c = i;
            if (this.a.isActive()) {
                this.a.c();
            }
        }
    }

    public void a(String str) {
    }
}
