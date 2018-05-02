package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;

import com.duokan.c.j;
import com.duokan.reader.ui.general.jq;

class fx extends AsyncTask {
    final /* synthetic */ fr a;
    private jq b;

    private fx(fr frVar) {
        this.a = frVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected void onPreExecute() {
        this.b = new jq(this.a.getContext());
        this.b.a(this.a.getContext().getString(j.organizebooks));
        this.b.setCancelOnBack(false);
        this.b.setCancelOnTouchOutside(false);
        this.b.show();
        super.onPreExecute();
    }

    protected Integer a(String... strArr) {
        this.a.a(this.a.e);
        return null;
    }

    protected void a(Integer num) {
        super.onPostExecute(num);
        this.b.dismiss();
        this.a.b.a();
    }
}
