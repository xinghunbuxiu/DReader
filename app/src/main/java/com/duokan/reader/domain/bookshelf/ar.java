package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ah;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.C0613k;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.store.C1176a;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract class ar extends hc {
    /* renamed from: b */
    protected final it f2762b;

    protected ar(Context context, ReaderEnv readerEnv, C0559f c0559f, C0709k c0709k, it itVar, C1176a c1176a, DkCloudStorage dkCloudStorage, C1016b c1016b) {
        super(context, readerEnv, c0559f, c0709k, c1176a, dkCloudStorage, c1016b);
        this.f2762b = itVar;
    }

    /* renamed from: c */
    public af<Boolean> mo971c() {
        if (this.e.m3501b().equals(AccountType.ANONYMOUS)) {
            return new af(Boolean.valueOf(false));
        }
        if (ReaderEnv.get().hasPrefKey(PrivatePref.BOOKSHELF, "auto_upload_books_on_wifi")) {
            return new af(Boolean.valueOf(ReaderEnv.get().getPrefBoolean(PrivatePref.BOOKSHELF, "auto_upload_books_on_wifi", false)));
        }
        return new af();
    }

    /* renamed from: a */
    public void mo972a(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.BOOKSHELF, "auto_upload_books_on_wifi", z);
        ReaderEnv.get().commitPrefs();
        if (z) {
            m3953a();
        } else {
            this.f2762b.m4735f();
        }
    }

    /* renamed from: a */
    public void mo973a(boolean z, boolean z2) {
        m3948w();
        C0517a asVar = new as(this, new C0613k(Integer.valueOf(0)), z, z2);
        DkUserPurchasedBooksManager.m5029a().m5053a(asVar);
        DkUserPurchasedFictionsManager.m5072a().m5103b(asVar);
        it.m4692a().m4716a(new bb(this, asVar));
    }

    /* renamed from: a */
    public C0800c mo968a(is isVar) {
        String encode = Uri.encode(hc.m3814a("", isVar), File.separator);
        Iterator it = m3926f(String.format("SELECT _id FROM books WHERE book_uri GLOB '*%s'", new Object[]{encode})).iterator();
        while (it.hasNext()) {
            C0800c c0800c = (C0800c) it.next();
            if (c0800c.ao() && TextUtils.equals(c0800c.am().m4686f(), isVar.m4686f())) {
                return c0800c;
            }
        }
        encode = Uri.encode(isVar.m4682b(), File.separator);
        it = m3926f(String.format("SELECT _id FROM books WHERE book_uri GLOB '*%s'", new Object[]{encode})).iterator();
        while (it.hasNext()) {
            c0800c = (C0800c) it.next();
            if (c0800c.ao() && TextUtils.equals(c0800c.am().m4686f(), isVar.m4686f())) {
                return c0800c;
            }
        }
        return null;
    }

    /* renamed from: b */
    public void mo962b() {
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.j = new al(c0672a);
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m3954a(this.j);
        if (!ReaderEnv.get().needAddNewbieBook() || !ai.m3980a().m3930g()) {
            mo973a(true, true);
        }
    }

    public void onAccountLogoff(C0672a c0672a) {
        this.j = new al(null);
        ReaderEnv.get().getDb().m633b("bookshelf_book_latest_time");
        ReaderEnv.get().getDb().m633b("bookshelf_book_revision");
        m3944s();
        m3936k();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    public void mo949a(C0559f c0559f) {
        ah.m866a(new bc(this, c0559f), c);
    }

    /* renamed from: a */
    public List<C0800c> mo969a(List<File> list, boolean z) {
        List<C0800c> a = super.mo969a((List) list, z);
        if (!a.isEmpty()) {
            m3953a();
        }
        return a;
    }

    /* renamed from: a */
    protected void mo970a(String str, int i, List<C0800c> list) {
        super.mo970a(str, i, (List) list);
        m3969d(list);
    }

    /* renamed from: a */
    private void m3953a() {
        ah.m866a(new bd(this), c);
    }

    /* renamed from: a */
    private void m3960a(boolean z, boolean z2, int i) {
        if (!PersonalPrefs.m5175a().m5250z()) {
            DkUserPurchasedBooksManager.m5029a().m5058a(false);
            DkUserPurchasedFictionsManager.m5072a().m5105b(false, C0519c.f1752a);
        } else if (this.j.m3367c() && this.i == null && m3942q()) {
            m3940o();
            m3961a(z, z2, i, this.j, this.i);
        }
    }

    /* renamed from: a */
    private void m3961a(boolean z, boolean z2, int i, al alVar, ik ikVar) {
        DkUserPurchasedFictionsManager.m5072a().m5105b(false, new be(this, ikVar, z, z2, i, alVar));
    }

    /* renamed from: a */
    private void m3954a(al alVar) {
        m3963b(alVar);
    }

    /* renamed from: b */
    private void m3963b(al alVar) {
        if (PersonalPrefs.m5175a().m5250z()) {
            de.m4313a().m4340a(new bg(this, alVar));
        }
    }

    /* renamed from: b */
    private void m3965b(boolean z, boolean z2, int i, al alVar, ik ikVar) {
        de.m4313a().m4341a(new bi(this, ikVar, alVar, z, z2, i));
    }

    /* renamed from: c */
    private void m3966c(al alVar) {
        if (PersonalPrefs.m5175a().m5250z()) {
            bu.m4077a().m4107a(new bk(this, alVar));
        }
    }

    /* renamed from: c */
    private void m3968c(boolean z, boolean z2, int i, al alVar, ik ikVar) {
        bu.m4077a().m4111a(z, new bm(this, ikVar, alVar, z, z2, i));
    }

    /* renamed from: a */
    protected void m3973a(int i) {
        UThread.post(new at(this, i));
    }

    /* renamed from: b */
    private void m3962b(int i) {
        if (!this.j.m3366b() && PersonalPrefs.m5175a().m5250z()) {
            jx jxVar = new jx();
            jxVar.m4783a();
            bu.m4077a().m4108a(jxVar, new av(this, i));
        }
    }

    /* renamed from: a */
    private C0800c m3952a(bt btVar, DkCloudPurchasedBook dkCloudPurchasedBook, String str, long j) {
        C0800c b = m3906b(dkCloudPurchasedBook.getBookUuid());
        if (b != null) {
            if (b.az() < j) {
                b.m4220d(j);
            }
            b.aN();
            return b;
        }
        C0800c a = m3864a(BookFormat.EPUB, BookPackageType.EPUB, BookType.NORMAL, BookState.CLOUD_ONLY);
        a.m4224e(dkCloudPurchasedBook.getBookUuid());
        a.m4196a(Uri.fromFile(new File(this.f.getCloudBookDirectory(), dkCloudPurchasedBook.getBookUuid() + "." + str + ".epub")).toString());
        a.m4207b(0);
        a.m4227f(str);
        a.m4176a(btVar.f2861e);
        a.m4220d(j);
        a.mo955p(dkCloudPurchasedBook.getTitle());
        a.m4184a(BookType.NORMAL);
        a.m4175a(0);
        a.m4221d(dkCloudPurchasedBook.getAuthorLine());
        a.m4186a(new ab("", "", "", "", false, -1, "", null, null, "", "", ""));
        a.m4212b(dkCloudPurchasedBook.getCoverUri());
        m3925e(a);
        m3895a(btVar.f2859c, a);
        return a;
    }

    /* renamed from: a */
    private C0800c m3951a(bt btVar, jx jxVar, Map<String, String> map, jy jyVar) {
        try {
            this.k.mo1090a();
            dd ddVar = (dd) jyVar.f3433c.get(btVar.f2858b);
            long j = ddVar == null ? 0 : ddVar.f3004c;
            C0800c a;
            if (btVar.f2857a == 0) {
                DkCloudPurchasedBook a2 = jxVar.m4782a(btVar.f2858b);
                if (a2 != null) {
                    String str = (String) map.get(a2.getBookUuid());
                    if (!TextUtils.isEmpty(str)) {
                        a = m3952a(btVar, a2, str, j);
                        return a;
                    }
                }
            } else if (btVar.f2857a == 1) {
                DkCloudPurchasedFiction b = jxVar.m4786b(btVar.f2858b);
                if (b != null) {
                    a = m3866a(btVar, b, j);
                    this.k.mo1096b();
                    return a;
                }
            } else if (btVar.f2857a == 3) {
                is c = jxVar.m4790c(btVar.f2858b);
                if (!(c == null || FileTypeRecognizer.m567a(c.m4682b()) == FileType.UNSUPPORTED)) {
                    a = m3865a(btVar, c, j);
                    this.k.mo1096b();
                    return a;
                }
            }
            this.k.mo1096b();
            return null;
        } finally {
            this.k.mo1096b();
        }
    }

    /* renamed from: d */
    private void m3970d(boolean z, boolean z2, int i, al alVar, ik ikVar) {
        it.m4692a().m4714a(new aw(this, ikVar, z, z2, i, alVar));
        it.m4692a().m4724a(true);
    }

    /* renamed from: d */
    private void m3969d(List<C0800c> list) {
        UThread.post(new ba(this, list));
    }
}
