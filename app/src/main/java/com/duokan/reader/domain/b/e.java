package com.duokan.reader.domain.b;

import android.content.IntentFilter;
import android.os.AsyncTask;

class e extends AsyncTask {
    final /* synthetic */ boolean a;
    final /* synthetic */ d b;

    e(d dVar, boolean z) {
        this.b = dVar;
        this.a = z;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected Void a(Void... voidArr) {
        if (this.a) {
            this.b.a.h();
        } else {
            this.b.a.i();
        }
        return null;
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
        this.b.a.i.startWatching();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addDataScheme("file");
        this.b.a.b.registerReceiver(this.b.a, intentFilter);
        b.n().a(this.b.a);
    }
}
