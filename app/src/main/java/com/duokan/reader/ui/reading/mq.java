package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.duokan.core.app.AppContext;

class mq extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ mo f10637a;
    /* renamed from: b */
    private Bitmap f10638b;

    mq(mo moVar) {
        this.f10637a = moVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m14674a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m14675a((Void) obj);
    }

    /* renamed from: a */
    protected Void m14674a(Void... voidArr) {
        this.f10638b = ((su) AppContext.getAppContext(this.f10637a.getContext()).queryFeature(su.class)).getDocument().mo1210a(this.f10637a.f10634d.mo1396k().mo1401a(), new Rect(0, 0, this.f10637a.getWidth(), this.f10637a.getHeight()), this.f10637a.getWidth(), this.f10637a.getHeight());
        return null;
    }

    /* renamed from: a */
    protected void m14675a(Void voidR) {
        super.onPostExecute(voidR);
        this.f10637a.f10633c = this.f10638b;
        this.f10637a.invalidate();
    }
}
