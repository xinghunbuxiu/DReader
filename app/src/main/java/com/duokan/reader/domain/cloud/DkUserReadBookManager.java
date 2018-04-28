package com.duokan.reader.domain.cloud;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.common.webservices.duokan.DkStoreBookInfo;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import com.duokan.reader.domain.store.DkStoreBook;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class DkUserReadBookManager implements ai, ao {
    /* renamed from: a */
    private static final aj<DkUserReadBookManager> f3617a = new aj();
    /* renamed from: b */
    private final Context f3618b;
    /* renamed from: c */
    private final C0709k f3619c;
    /* renamed from: d */
    private final C0586j f3620d;
    /* renamed from: e */
    private final LinkedList<ed> f3621e = new LinkedList();
    /* renamed from: f */
    private al f3622f;

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

    private DkUserReadBookManager(Context context, C0709k c0709k, ReaderEnv readerEnv) {
        this.f3618b = context;
        this.f3619c = c0709k;
        this.f3620d = new dw(this);
        this.f3622f = new al(this.f3619c.m3508d());
        DkApp.get().runPreReady(new dx(this));
    }

    /* renamed from: a */
    public static void m5116a(Context context, C0709k c0709k, ReaderEnv readerEnv) {
        f3617a.m709a(new DkUserReadBookManager(context, c0709k, readerEnv));
    }

    /* renamed from: a */
    public static DkUserReadBookManager m5115a() {
        return (DkUserReadBookManager) f3617a.m707a();
    }

    /* renamed from: a */
    public void m5129a(ed edVar) {
        this.f3621e.add(edVar);
    }

    /* renamed from: b */
    public void m5132b(ed edVar) {
        this.f3621e.remove(edVar);
    }

    /* renamed from: a */
    public void m5130a(String str, ef efVar) {
        this.f3619c.m3495a(new dy(this, efVar, str));
    }

    /* renamed from: a */
    public void m5126a(C0517a<Void> c0517a) {
        m5131a(false, new ea(this, c0517a), 0, 0);
    }

    /* renamed from: a */
    public void m5131a(boolean z, ee eeVar, long j, int i) {
        if (!z && this.f3622f.m3366b()) {
            eeVar.mo1156a("");
        } else if (!this.f3622f.f2361b.equals(AccountType.ANONYMOUS)) {
            m5122b(z, eeVar, j, i);
        }
    }

    /* renamed from: b */
    private void m5122b(boolean z, ee eeVar, long j, int i) {
        this.f3619c.m3495a(new eb(this, j, i, eeVar, z));
    }

    /* renamed from: b */
    private void m5119b() {
        Iterator it = this.f3621e.iterator();
        while (it.hasNext()) {
            ((ed) it.next()).mo1920g();
        }
    }

    /* renamed from: a */
    private void m5118a(ReadBook[] readBookArr) {
        Iterator it = this.f3621e.iterator();
        while (it.hasNext()) {
            ((ed) it.next()).mo1916a(readBookArr);
        }
    }

    /* renamed from: b */
    private void m5123b(ReadBook[] readBookArr) {
        Iterator it = this.f3621e.iterator();
        while (it.hasNext()) {
            ((ed) it.next()).mo1918b(readBookArr);
        }
    }

    /* renamed from: a */
    public void mo1154a(SharedKey sharedKey, Serializable serializable) {
        m5126a(C0519c.f1752a);
    }

    /* renamed from: a */
    public void mo1153a(SharedKey sharedKey) {
        m5126a(C0519c.f1752a);
    }
}
