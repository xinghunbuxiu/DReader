package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.jx;
import com.duokan.reader.ui.general.ak;
import java.util.LinkedList;
import java.util.List;

class et extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ ak f6406a;
    /* renamed from: b */
    final /* synthetic */ es f6407b;
    /* renamed from: c */
    private TextView f6408c = null;
    /* renamed from: d */
    private TextView f6409d = null;
    /* renamed from: e */
    private C0800c[] f6410e = null;
    /* renamed from: f */
    private int f6411f = 0;
    /* renamed from: g */
    private int f6412g = 0;
    /* renamed from: h */
    private jx f6413h;

    et(es esVar, ak akVar) {
        this.f6407b = esVar;
        this.f6406a = akVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9568a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9569a((Void) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        m9570b((Void[]) objArr);
    }

    /* renamed from: a */
    protected Void m9568a(Void... voidArr) {
        this.f6413h.m4787b();
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        while (!isCancelled() && this.f6411f < this.f6410e.length) {
            C0800c c0800c = this.f6410e[this.f6411f];
            int aq = c0800c.aq();
            if (!(!ReaderEnv.get().isExternalStorageMounted() || c0800c.m4167T() || c0800c.m4242o() == BookType.SERIAL)) {
                if (aq == -1 || !this.f6413h.m4785a(c0800c)) {
                    linkedList.add(c0800c);
                    this.f6412g++;
                } else if (!c0800c.m4171X()) {
                    linkedList2.add(c0800c);
                }
            }
            this.f6411f++;
            publishProgress(new Void[0]);
        }
        if (!isCancelled()) {
            ai.m3980a().m3915b(linkedList, true);
            ai.m3980a().m3919c(linkedList2);
        }
        return null;
    }

    protected void onPreExecute() {
        this.f6408c = (TextView) this.f6406a.findViewById(C0244f.bookroom__clear_invalid_book_view__scanning);
        this.f6409d = (TextView) this.f6406a.findViewById(C0244f.bookroom__clear_invalid_book_view__removed);
        this.f6410e = ai.m3980a().m3934i();
        this.f6413h = new jx();
        this.f6413h.m4783a();
        this.f6406a.show();
    }

    /* renamed from: a */
    protected void m9569a(Void voidR) {
        this.f6408c.setText(C0247i.bookroom__clear_invalid_book_view__done);
        this.f6406a.setButtonText(0, C0247i.general__shared__ok);
    }

    /* renamed from: b */
    protected void m9570b(Void... voidArr) {
        Context context = this.f6406a.getContext();
        this.f6408c.setText(Html.fromHtml(String.format(context.getString(C0247i.bookroom__clear_invalid_book_view__scanning), new Object[]{Integer.valueOf(this.f6411f), Integer.valueOf(this.f6410e.length)})));
        this.f6409d.setText(Html.fromHtml(String.format(context.getString(C0247i.bookroom__clear_invalid_book_view__found), new Object[]{Integer.valueOf(this.f6412g)})));
    }

    protected void onCancelled() {
        this.f6406a.dismiss();
    }
}
