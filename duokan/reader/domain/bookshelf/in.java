package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.cloud.PersonalPrefs;

class in implements Runnable {
    final /* synthetic */ hi a;

    in(hi hiVar) {
        this.a = hiVar;
    }

    public void run() {
        if (!this.a.j.b() && PersonalPrefs.a().y()) {
            jl jlVar = new jl();
            jlVar.a();
            dh.a().a(jlVar, new io(this));
        }
    }
}
