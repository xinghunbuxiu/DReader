package com.duokan.reader.ui.personal;

import android.os.AsyncTask;

import com.duokan.reader.domain.bookshelf.iy;
import com.duokan.reader.domain.micloud.bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class ex extends AsyncTask {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ bj c;
    final /* synthetic */ ew d;

    ex(ew ewVar, ArrayList arrayList, ArrayList arrayList2, bj bjVar) {
        this.d = ewVar;
        this.a = arrayList;
        this.b = arrayList2;
        this.c = bjVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected Void a(Void... voidArr) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            this.b.add(new CustomCloudItem((iy) it.next()));
        }
        Collections.sort(this.b, new ey(this));
        return null;
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
        this.d.a.setSpaceQuota(this.c);
        this.d.a.setData(this.b);
        this.d.c();
    }
}
