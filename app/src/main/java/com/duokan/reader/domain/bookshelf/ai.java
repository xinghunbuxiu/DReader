package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import android.net.Uri;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.sys.af;
import com.duokan.core.sys.o;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.webservices.duokan.z;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.store.DkStoreBookDetail;

import java.io.File;

public class ai extends aq {
    static final /* synthetic */ boolean a = (!ai.class.desiredAssertionStatus());
    private static final com.duokan.core.app.ai m = new com.duokan.core.app.ai();

    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public /* bridge */ /* synthetic */ void b(a aVar) {
        super.b(aVar);
    }

    public /* bridge */ /* synthetic */ af c() {
        return super.c();
    }

    public /* bridge */ /* synthetic */ void c(a aVar) {
        super.c(aVar);
    }

    public /* bridge */ /* synthetic */ void d(a aVar) {
        super.d(aVar);
    }

    public /* bridge */ /* synthetic */ void onConnectivityChanged(f fVar) {
        super.onConnectivityChanged(fVar);
    }

    protected ai(Context context, ReaderEnv readerEnv, f fVar, i iVar, iz izVar, com.duokan.reader.domain.store.a aVar, DkCloudStorage dkCloudStorage, b bVar) {
        super(context, readerEnv, fVar, iVar, izVar, aVar, dkCloudStorage, bVar);
        DkApp.get().runPreReady(new aj(this));
    }

    public static void a(Context context, ReaderEnv readerEnv, f fVar, i iVar, iz izVar, com.duokan.reader.domain.store.a aVar, DkCloudStorage dkCloudStorage, b bVar) {
        m.a(new ai(context, readerEnv, fVar, iVar, izVar, aVar, dkCloudStorage, bVar));
    }

    public static ai a() {
        return (ai) m.a();
    }

    public c a(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, af afVar) {
        try {
            this.k.a();
            if (!a && dkStoreBookDetail == null) {
                throw new AssertionError();
            } else if (a || dkCloudBookManifest != null) {
                UmengManager.get().onEvent("V2_SHELF_IMPORT_BOOK", "DuokanBook");
                a(dkStoreBookDetail, dkCloudBookManifest);
                c c = c(dkStoreBookDetail, dkCloudBookManifest, afVar);
                return c;
            } else {
                throw new AssertionError();
            }
        } finally {
            this.k.b();
        }
    }

    public c b(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, af afVar) {
        try {
            this.k.a();
            if (!a && dkStoreBookDetail == null) {
                throw new AssertionError();
            } else if (a || dkCloudBookManifest != null) {
                UmengManager.get().onEvent("V2_SHELF_IMPORT_BOOK", "DuokanBook");
                c c = c(dkStoreBookDetail, dkCloudBookManifest, afVar);
                return c;
            } else {
                throw new AssertionError();
            }
        } finally {
            this.k.b();
        }
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.UNDERGROUND) {
            t();
            a(0);
        }
    }

    private c c(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, af afVar) {
        try {
            this.k.a();
            c b = b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                this.k.b();
                return b;
            }
            int i;
            File file = new File(this.f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkCloudBookManifest.getBookRevision() + ".epub");
            DkPublic.rm(file);
            b.a(Uri.fromFile(file).toString());
            b.b(dkStoreBookDetail.getEpubSize());
            b.f(dkCloudBookManifest.getBookRevision());
            if (dkStoreBookDetail.getBook().isFree()) {
                i = 0;
            } else {
                i = dkStoreBookDetail.getBook().getNewPrice();
            }
            b.a(i);
            b.d(dkStoreBookDetail.getBook().getNameLine());
            b.a(b(dkStoreBookDetail));
            f(b);
            z bookCertification = dkCloudBookManifest.getBookCertification();
            if (bookCertification != null && bookCertification.b.length > 0 && bookCertification.c.length > 0) {
                b.a(new ad(this.f.getDeviceIdVersion(), bookCertification.a, o.a(bookCertification.b) + "\n" + o.a(bookCertification.c), 0));
                b.a(BookLimitType.NONE);
            }
            this.g.b();
            b.aM();
            this.g.f();
            this.g.c();
            b.a(b.f(), dkCloudBookManifest.getBookUri(), dkCloudBookManifest.getBookRevision(), dkCloudBookManifest.getBookMd5(), true, afVar);
            x();
            this.k.b();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            this.g.c();
            this.k.b();
            return null;
        } catch (Throwable th) {
            this.k.b();
        }
    }
}
