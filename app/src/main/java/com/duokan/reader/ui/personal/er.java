package com.duokan.reader.ui.personal;

import android.os.AsyncTask;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.micloud.bj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class er extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ ArrayList f8517a;
    /* renamed from: b */
    final /* synthetic */ ArrayList f8518b;
    /* renamed from: c */
    final /* synthetic */ bj f8519c;
    /* renamed from: d */
    final /* synthetic */ eq f8520d;

    er(eq eqVar, ArrayList arrayList, ArrayList arrayList2, bj bjVar) {
        this.f8520d = eqVar;
        this.f8517a = arrayList;
        this.f8518b = arrayList2;
        this.f8519c = bjVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11769a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m11770a((Void) obj);
    }

    /* renamed from: a */
    protected Void m11769a(Void... voidArr) {
        Iterator it = this.f8517a.iterator();
        while (it.hasNext()) {
            this.f8518b.add(new CustomCloudItem((is) it.next()));
        }
        Collections.sort(this.f8518b, new es(this));
        return null;
    }

    /* renamed from: a */
    protected void m11770a(Void voidR) {
        super.onPostExecute(voidR);
        this.f8520d.f8516a.setSpaceQuota(this.f8519c);
        this.f8520d.f8516a.setData(this.f8518b);
        this.f8520d.m11767b();
    }
}
