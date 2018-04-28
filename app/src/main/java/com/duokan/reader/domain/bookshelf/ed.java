package com.duokan.reader.domain.bookshelf;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

public class ed extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    private List<C0800c> f3082a = new ArrayList();
    /* renamed from: b */
    private ec f3083b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m4395a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4396a((Void) obj);
    }

    public ed(List<an> list, ec ecVar) {
        this.f3083b = ecVar;
        for (an anVar : list) {
            if (anVar instanceof C0800c) {
                this.f3082a.add((C0800c) anVar);
            }
        }
    }

    /* renamed from: a */
    protected Void m4395a(Void... voidArr) {
        if (!this.f3082a.isEmpty()) {
            ai.m3980a().m3915b(this.f3082a, false);
        }
        return null;
    }

    /* renamed from: a */
    protected void m4396a(Void voidR) {
        if (this.f3083b != null) {
            this.f3083b.mo1728a(false);
        }
    }
}
