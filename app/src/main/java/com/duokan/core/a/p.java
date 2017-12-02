package com.duokan.core.a;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.io.File;

class p implements t {
    final /* synthetic */ n a;
    private SQLiteDatabase b = null;
    private int c = 1;

    p(n nVar) {
        this.a = nVar;
    }

    public SQLiteDatabase a() {
        return this.b;
    }

    public SQLiteDatabase b() {
        this.a.b.lock();
        try {
            int i = this.c + 1;
            this.c = i;
            if (i > 1 && this.b == null) {
                this.a.j();
                this.b = SQLiteDatabase.openOrCreateDatabase(new File(Uri.parse(this.a.c.a).getPath()), null);
            }
        } catch (Throwable th) {
            this.a.b.unlock();
        }
        this.a.b.unlock();
        return this.b;
    }

    public void c() {
        this.a.b.lock();
        try {
            int i = this.c - 1;
            this.c = i;
            if (i == 0 && this.b != null) {
                this.b.close();
                this.b = null;
            }
            this.a.b.unlock();
        } catch (Throwable th) {
            this.a.b.unlock();
        }
    }
}
