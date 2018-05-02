package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;

import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.an;

class en implements an {
    final /* synthetic */ AsyncTask a;
    final /* synthetic */ ak b;
    final /* synthetic */ el c;

    en(el elVar, AsyncTask asyncTask, ak akVar) {
        this.c = elVar;
        this.a = asyncTask;
        this.b = akVar;
    }

    public void a(int i) {
        if (this.c.b.a != null) {
            this.c.b.a.a();
        }
        if (this.a.getStatus() == Status.FINISHED) {
            this.b.dismiss();
        } else {
            this.a.cancel(false);
        }
    }
}
