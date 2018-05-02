package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;

import com.duokan.core.app.MyContextWrapper;

class mg extends AsyncTask {
    final /* synthetic */ me a;
    private Bitmap b;

    mg(me meVar) {
        this.a = meVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected Void a(Void... voidArr) {
        this.b = ((sh) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(sh.class)).getDocument().a(this.a.d.k().a(), new Rect(0, 0, this.a.getWidth(), this.a.getHeight()), this.a.getWidth(), this.a.getHeight());
        return null;
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
        this.a.c = this.b;
        this.a.invalidate();
    }
}
