package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.ja;

class ge extends AsyncTask<String, Void, Integer> {
    /* renamed from: a */
    final /* synthetic */ fy f6500a;
    /* renamed from: b */
    private ja f6501b;

    private ge(fy fyVar) {
        this.f6500a = fyVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9711a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9712a((Integer) obj);
    }

    protected void onPreExecute() {
        this.f6501b = new ja(this.f6500a.getContext());
        this.f6501b.m10843a(this.f6500a.getContext().getString(C0258j.organizebooks));
        this.f6501b.setCancelOnBack(false);
        this.f6501b.setCancelOnTouchOutside(false);
        this.f6501b.show();
        super.onPreExecute();
    }

    /* renamed from: a */
    protected Integer m9711a(String... strArr) {
        this.f6500a.m9647a(this.f6500a.f6477e);
        return null;
    }

    /* renamed from: a */
    protected void m9712a(Integer num) {
        super.onPostExecute(num);
        this.f6501b.dismiss();
        this.f6500a.f6474b.m9726a();
    }
}
