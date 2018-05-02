package com.duokan.reader.domain.p044b;

import android.content.IntentFilter;
import android.os.AsyncTask;
import com.duokan.reader.domain.downloadcenter.C1016b;

/* renamed from: com.duokan.reader.domain.b.e */
class C0784e extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ boolean f2633a;
    /* renamed from: b */
    final /* synthetic */ C0783d f2634b;

    C0784e(C0783d c0783d, boolean z) {
        this.f2634b = c0783d;
        this.f2633a = z;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3695a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3696a((Void) obj);
    }

    /* renamed from: a */
    protected Void m3695a(Void... voidArr) {
        if (this.f2633a) {
            this.f2634b.f2632a.m3676h();
        } else {
            this.f2634b.f2632a.m3677i();
        }
        return null;
    }

    /* renamed from: a */
    protected void m3696a(Void voidR) {
        super.onPostExecute(voidR);
        this.f2634b.f2632a.f2627i.startWatching();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addDataScheme("file");
        this.f2634b.f2632a.f2621b.registerReceiver(this.f2634b.f2632a, intentFilter);
        C1016b.m7857p().m7872a(this.f2634b.f2632a);
    }
}
