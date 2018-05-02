package com.duokan.core.p026a;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import java.io.File;


class C0289p implements C0288t {
    
    final  C0285n f484a;
    
    private SQLiteDatabase f485b = null;
    
    private int f486c = 1;

    C0289p(C0285n c0285n) {
        this.f484a = c0285n;
    }

    
    public SQLiteDatabase mo381a() {
        return this.f485b;
    }

    
    public SQLiteDatabase mo382b() {
        this.f484a.f477b.lock();
        try {
            int i = this.f486c + 1;
            this.f486c = i;
            if (i > 1 && this.f485b == null) {
                this.f484a.m665j();
                this.f485b = SQLiteDatabase.openOrCreateDatabase(new File(Uri.parse(this.f484a.f478c.f492a).getPath()), null);
            }
        } catch (Throwable th) {
            this.f484a.f477b.unlock();
        }
        this.f484a.f477b.unlock();
        return this.f485b;
    }

    
    public void mo383c() {
        this.f484a.f477b.lock();
        try {
            int i = this.f486c - 1;
            this.f486c = i;
            if (i == 0 && this.f485b != null) {
                this.f485b.close();
                this.f485b = null;
            }
            this.f484a.f477b.unlock();
        } catch (Throwable th) {
            this.f484a.f477b.unlock();
        }
    }
}
