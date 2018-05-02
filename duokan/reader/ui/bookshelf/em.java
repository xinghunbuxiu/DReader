package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import com.duokan.b.i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.jl;
import com.duokan.reader.ui.general.ak;

import java.util.LinkedList;
import java.util.List;

class em extends AsyncTask {
    final /* synthetic */ ak a;
    final /* synthetic */ el b;
    private TextView c = null;
    private TextView d = null;
    private c[] e = null;
    private int f = 0;
    private int g = 0;
    private jl h;

    em(el elVar, ak akVar) {
        this.b = elVar;
        this.a = akVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        b((Void[]) objArr);
    }

    protected Void a(Void... voidArr) {
        this.h.b();
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        while (!isCancelled() && this.f < this.e.length) {
            c cVar = this.e[this.f];
            int ao = cVar.ao();
            if (!(!ReaderEnv.get().isExternalStorageMounted() || cVar.R() || cVar.o() == BookType.SERIAL)) {
                if (ao == -1 || !this.h.a(cVar)) {
                    linkedList.add(cVar);
                    this.g++;
                } else if (!cVar.V()) {
                    linkedList2.add(cVar);
                }
            }
            this.f++;
            publishProgress(new Void[0]);
        }
        if (!isCancelled()) {
            ai.a().b(linkedList, true);
            ai.a().d(linkedList2);
        }
        return null;
    }

    protected void onPreExecute() {
        this.c = (TextView) this.a.findViewById(f.bookroom__clear_invalid_book_view__scanning);
        this.d = (TextView) this.a.findViewById(f.bookroom__clear_invalid_book_view__removed);
        this.e = ai.a().i();
        this.h = new jl();
        this.h.a();
        this.a.show();
    }

    protected void a(Void voidR) {
        this.c.setText(i.bookroom__clear_invalid_book_view__done);
        this.a.setButtonText(0, i.general__shared__ok);
    }

    protected void b(Void... voidArr) {
        Context context = this.a.getContext();
        this.c.setText(Html.fromHtml(String.format(context.getString(i.bookroom__clear_invalid_book_view__scanning), new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e.length)})));
        this.d.setText(Html.fromHtml(String.format(context.getString(i.bookroom__clear_invalid_book_view__found), new Object[]{Integer.valueOf(this.g)})));
    }

    protected void onCancelled() {
        this.a.dismiss();
    }
}
