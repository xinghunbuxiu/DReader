package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.an;

class eu implements an {
    /* renamed from: a */
    final /* synthetic */ AsyncTask f6414a;
    /* renamed from: b */
    final /* synthetic */ ak f6415b;
    /* renamed from: c */
    final /* synthetic */ es f6416c;

    eu(es esVar, AsyncTask asyncTask, ak akVar) {
        this.f6416c = esVar;
        this.f6414a = asyncTask;
        this.f6415b = akVar;
    }

    /* renamed from: a */
    public void mo1689a(int i) {
        if (this.f6416c.f6405b.f6399a != null) {
            this.f6416c.f6405b.f6399a.m9573a();
        }
        if (this.f6414a.getStatus() == Status.FINISHED) {
            this.f6415b.dismiss();
        } else {
            this.f6414a.cancel(false);
        }
    }
}
