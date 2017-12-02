package com.duokan.reader.domain.bookshelf;

import android.os.Handler;
import android.os.Looper;

import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.o;
import com.duokan.reader.domain.micloud.t;

class ja implements t {
    final /* synthetic */ iz a;

    ja(iz izVar) {
        this.a = izVar;
    }

    public void b(o oVar, bi biVar) {
        synchronized (this.a.m) {
            iy iyVar = new iy(biVar);
            String f = iyVar.f();
            boolean z = !this.a.l;
            new Handler(Looper.getMainLooper()).post(new jb(this, oVar, z, a(oVar, z), f, iyVar));
        }
    }

    public void a(o oVar, bi biVar) {
        synchronized (this.a.m) {
            String f = new iy(biVar).f();
            boolean z = !this.a.l;
            new Handler(Looper.getMainLooper()).post(new jc(this, oVar, z, a(oVar, z), f));
        }
    }

    public void a(o oVar) {
        new Handler(Looper.getMainLooper()).post(new jd(this, oVar, oVar.i()));
    }

    public void b(o oVar) {
        synchronized (this.a.m) {
            new Handler(Looper.getMainLooper()).post(new je(this, oVar, a(oVar, true)));
        }
    }

    private jj a(o oVar, boolean z) {
        jj jjVar = new jj();
        jjVar.a = oVar.i();
        if (z) {
            jjVar.a(oVar.b("/Books"));
        }
        return jjVar;
    }
}
