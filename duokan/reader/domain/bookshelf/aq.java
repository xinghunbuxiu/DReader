package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ah;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.async.a.c;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.k;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.store.a;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract class aq extends hi {
    protected final iz b;

    protected aq(Context context, ReaderEnv readerEnv, classc.ConnectivityReceiver connectivity, i iVar, iz izVar, a aVar, DkCloudStorage dkCloudStorage, b bVar) {
        super(context, readerEnv, connectivity, iVar, aVar, dkCloudStorage, bVar);
        this.b = izVar;
        this.b.a(new ar(this));
    }

    public af c() {
        if (this.e.a().equals(AccountType.ANONYMOUS)) {
            return new af(Boolean.valueOf(false));
        }
        if (ReaderEnv.get().hasPrefKey(PrivatePref.BOOKSHELF, "auto_upload_books_on_wifi")) {
            return new af(Boolean.valueOf(ReaderEnv.get().getPrefBoolean(PrivatePref.BOOKSHELF, "auto_upload_books_on_wifi", false)));
        }
        return new af();
    }

    public void a(boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.BOOKSHELF, "auto_upload_books_on_wifi", z);
        ReaderEnv.get().commitPrefs();
        ah.future(new be(this, z), c);
    }

    public void a(boolean z, boolean z2) {
        w();
        com.duokan.reader.common.async.a.a bfVar = new bf(this, new k(Integer.valueOf(0)), z, z2);
        DkUserPurchasedBooksManager.a().a(bfVar);
        DkUserPurchasedFictionsManager.a().b(bfVar);
        iz.a().a(new bg(this, bfVar));
    }

    public c a(iy iyVar) {
        String encode = Uri.encode(hi.a("", iyVar), File.separator);
        Iterator it = f(String.format("SELECT _id FROM books WHERE book_uri GLOB '*%s'", new Object[]{encode})).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.am() && TextUtils.equals(cVar.ak().f(), iyVar.f())) {
                return cVar;
            }
        }
        encode = Uri.encode(iyVar.b(), File.separator);
        it = f(String.format("SELECT _id FROM books WHERE book_uri GLOB '*%s'", new Object[]{encode})).iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (cVar.am() && TextUtils.equals(cVar.ak().f(), iyVar.f())) {
                return cVar;
            }
        }
        return null;
    }

    public void b() {
    }

    public void a(com.duokan.reader.domain.account.a aVar) {
        this.j = new ab(aVar);
    }

    public void b(com.duokan.reader.domain.account.a aVar) {
        a(this.j);
        if (!ReaderEnv.get().needAddNewbieBook() || !ai.a().g()) {
            a(true, true);
        }
    }

    public void c(com.duokan.reader.domain.account.a aVar) {
        this.j = new ab(null);
        ReaderEnv.get().getDb().b("bookshelf_book_latest_time");
        ReaderEnv.get().getDb().b("bookshelf_book_revision");
        s();
        k();
    }

    public void d(com.duokan.reader.domain.account.a aVar) {
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        ah.future(new bh(this, connectivity), c);
    }

    public List a(List list, boolean z) {
        List a = super.a(list, z);
        if (!a.isEmpty()) {
            a();
        }
        return a;
    }

    protected void a(String str, int i, List list) {
        super.a(str, i, list);
        e(list);
    }

    private void a() {
        ah.future(new bi(this), c);
    }

    private void a(boolean z, boolean z2, int i) {
        if (!PersonalPrefs.a().y()) {
            DkUserPurchasedBooksManager.a().a(false);
            DkUserPurchasedFictionsManager.a().b(false, c.a);
        } else if (this.j.c() && this.i == null && q()) {
            o();
            a(z, z2, i, this.j, this.i);
        }
    }

    private void a(boolean z, boolean z2, int i, ab abVar, iq iqVar) {
        DkUserPurchasedFictionsManager.a().b(false, new bj(this, iqVar, z, z2, i, abVar));
    }

    private void a(ab abVar) {
        b(abVar);
    }

    private void b(ab abVar) {
        if (PersonalPrefs.a().y()) {
            dh.a().a(new bl(this, abVar));
        }
    }

    private void b(boolean z, boolean z2, int i, ab abVar, iq iqVar) {
        dh.a().a(new bn(this, iqVar, abVar, z, z2, i));
    }

    private void c(ab abVar) {
        if (PersonalPrefs.a().y()) {
            bv.a().a(new as(this, abVar));
        }
    }

    private void c(boolean z, boolean z2, int i, ab abVar, iq iqVar) {
        bv.a().a(z, new au(this, iqVar, abVar, z, z2, i));
    }

    protected void a(int i) {
        TaskHandler.PostTask(new aw(this, i));
    }

    private void b(int i) {
        if (!this.j.b() && PersonalPrefs.a().y()) {
            jl jlVar = new jl();
            jlVar.a();
            bv.a().a(jlVar, new ay(this, i));
        }
    }

    private c a(bu buVar, DkCloudPurchasedBook dkCloudPurchasedBook, String str, long j) {
        c b = b(dkCloudPurchasedBook.getBookUuid());
        if (b != null) {
            if (b.ax() < j) {
                b.d(j);
            }
            b.aL();
            return b;
        }
        c a = a(BookFormat.EPUB, BookPackageType.EPUB, BookType.NORMAL, BookState.CLOUD_ONLY);
        a.e(dkCloudPurchasedBook.getBookUuid());
        a.a(Uri.fromFile(new File(this.f.getCloudBookDirectory(), dkCloudPurchasedBook.getBookUuid() + "." + str + ".epub")).toString());
        a.b(0);
        a.f(str);
        a.a(buVar.e);
        a.d(j);
        a.o(dkCloudPurchasedBook.getTitle());
        a.a(BookType.NORMAL);
        a.a(0);
        a.d(dkCloudPurchasedBook.getAuthorLine());
        a.a(new ab("", "", "", "", false, -1, "", null, null, "", "", ""));
        a.b(dkCloudPurchasedBook.getCoverUri());
        e(a);
        a(buVar.c, a);
        return a;
    }

    private c a(bu buVar, jl jlVar, Map map, jm jmVar) {
        try {
            this.k.a();
            dg dgVar = (dg) jmVar.c.get(buVar.b);
            long j = dgVar == null ? 0 : dgVar.c;
            c a;
            if (buVar.a == 0) {
                DkCloudPurchasedBook a2 = jlVar.a(buVar.b);
                if (a2 != null) {
                    String str = (String) map.get(a2.getBookUuid());
                    if (!TextUtils.isEmpty(str)) {
                        a = a(buVar, a2, str, j);
                        return a;
                    }
                }
            } else if (buVar.a == 1) {
                DkCloudPurchasedFiction b = jlVar.b(buVar.b);
                if (b != null) {
                    a = a(buVar, b, j);
                    this.k.b();
                    return a;
                }
            } else if (buVar.a == 3) {
                iy c = jlVar.c(buVar.b);
                if (!(c == null || FileTypeRecognizer.a(c.b()) == FileType.UNSUPPORTED)) {
                    a = a(buVar, c, j);
                    this.k.b();
                    return a;
                }
            }
            this.k.b();
            return null;
        } finally {
            this.k.b();
        }
    }

    private void d(boolean z, boolean z2, int i, ab abVar, iq iqVar) {
        iz.a().a(new az(this, iqVar, z, z2, i, abVar));
        iz.a().a(true);
    }

    private void e(List list) {
        TaskHandler.PostTask(new bd(this, list));
    }
}
