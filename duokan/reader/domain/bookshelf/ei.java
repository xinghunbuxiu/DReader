package com.duokan.reader.domain.bookshelf;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class ei extends AsyncTask {
    private List a = new ArrayList();
    private eh b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    public ei(List list, eh ehVar) {
        this.b = ehVar;
        for (an anVar : list) {
            if (anVar instanceof c) {
                this.a.add((c) anVar);
            }
        }
    }

    protected Void a(Void... voidArr) {
        if (!this.a.isEmpty()) {
            ai.a().b(this.a, false);
        }
        return null;
    }

    protected void a(Void voidR) {
        if (this.b != null) {
            this.b.a(false);
        }
    }
}
