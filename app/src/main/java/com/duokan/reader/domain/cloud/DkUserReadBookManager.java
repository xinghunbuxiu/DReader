package com.duokan.reader.domain.cloud;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.common.webservices.duokan.DkStoreBookInfo;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import com.duokan.reader.domain.store.DkStoreBook;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class DkUserReadBookManager implements ah, av {
    private static final ai a = new ai();
    private final Context b;
    private final i c;
    private final h d;
    private final LinkedList e = new LinkedList();
    private ab f;

    public class ReadBook extends DkStoreBook {
        private static final long serialVersionUID = 1;
        public final ReadBookInfo mReadBookInfo;

        public ReadBook(ReadBookInfo readBookInfo) {
            super(readBookInfo);
            this.mReadBookInfo = readBookInfo;
        }

        public int getRate() {
            return this.mReadBookInfo.mRate;
        }

        public String getComment() {
            return this.mReadBookInfo.mComment;
        }

        public Calendar getReadTime() {
            return this.mReadBookInfo.mReadTime;
        }
    }

    public class ReadBookInfo extends DkStoreBookInfo {
        private static final long serialVersionUID = 1;
        public String mComment;
        public int mRate;
        public Calendar mReadTime;
    }

    private DkUserReadBookManager(Context context, i iVar, ReaderEnv readerEnv) {
        this.b = context;
        this.c = iVar;
        this.d = new el(this);
        this.f = new ab(this.c.c());
        DkApp.get().runPreReady(new em(this));
    }

    public static void a(Context context, i iVar, ReaderEnv readerEnv) {
        a.a(new DkUserReadBookManager(context, iVar, readerEnv));
    }

    public static DkUserReadBookManager a() {
        return (DkUserReadBookManager) a.a();
    }

    public void a(eu euVar) {
        this.e.add(euVar);
    }

    public void b(eu euVar) {
        this.e.remove(euVar);
    }

    public void a(String str, ew ewVar) {
        this.c.a(new en(this, ewVar, str));
    }

    public void a(a aVar) {
        a(false, new eq(this, aVar), 0, 0);
    }

    public void a(boolean z, ev evVar, long j, int i) {
        if (!z && this.f.b()) {
            evVar.a("");
        } else if (!this.f.b.equals(AccountType.ANONYMOUS)) {
            b(z, evVar, j, i);
        }
    }

    private void b(boolean z, ev evVar, long j, int i) {
        this.c.a(new er(this, j, i, evVar, z));
    }

    private void b() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((eu) it.next()).g();
        }
    }

    private void a(ReadBook[] readBookArr) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((eu) it.next()).a(readBookArr);
        }
    }

    private void b(ReadBook[] readBookArr) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((eu) it.next()).b(readBookArr);
        }
    }

    public void a(SharedKey sharedKey, Serializable serializable) {
        a(c.a);
    }

    public void a(SharedKey sharedKey) {
        a(c.a);
    }
}
