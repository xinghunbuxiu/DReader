package com.duokan.reader.domain.bookshelf;

import android.os.AsyncTask;

class n extends AsyncTask {
    final /* synthetic */ c a;
    final /* synthetic */ a[] b;
    final /* synthetic */ u c;
    final /* synthetic */ c d;

    n(c cVar, c cVar2, a[] aVarArr, u uVar) {
        this.d = cVar;
        this.a = cVar2;
        this.b = aVarArr;
        this.c = uVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected Void a(Void... voidArr) {
        this.d.a(this.a, this.b, new o(this));
        return null;
    }
}
