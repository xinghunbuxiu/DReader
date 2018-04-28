package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import android.net.Uri;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.aj;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.af;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import java.io.File;

public class ai extends ar {
    /* renamed from: a */
    static final /* synthetic */ boolean f2763a = (!ai.class.desiredAssertionStatus());
    /* renamed from: m */
    private static final aj<ai> f2764m = new aj();

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo962b() {
        super.mo962b();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ af mo971c() {
        return super.mo971c();
    }

    public /* bridge */ /* synthetic */ void onAccountDetailChanged(C0672a c0672a) {
        super.onAccountDetailChanged(c0672a);
    }

    public /* bridge */ /* synthetic */ void onAccountLoginedBottomHalf(C0672a c0672a) {
        super.onAccountLoginedBottomHalf(c0672a);
    }

    public /* bridge */ /* synthetic */ void onAccountLoginedTopHalf(C0672a c0672a) {
        super.onAccountLoginedTopHalf(c0672a);
    }

    public /* bridge */ /* synthetic */ void onAccountLogoff(C0672a c0672a) {
        super.onAccountLogoff(c0672a);
    }

    protected ai(Context context, ReaderEnv readerEnv, C0559f c0559f, C0709k c0709k, it itVar, C1176a c1176a, DkCloudStorage dkCloudStorage, C1016b c1016b) {
        super(context, readerEnv, c0559f, c0709k, itVar, c1176a, dkCloudStorage, c1016b);
        DkApp.get().runPreReady(new aj(this));
    }

    /* renamed from: a */
    public static void m3981a(Context context, ReaderEnv readerEnv, C0559f c0559f, C0709k c0709k, it itVar, C1176a c1176a, DkCloudStorage dkCloudStorage, C1016b c1016b) {
        f2764m.m709a(new ai(context, readerEnv, c0559f, c0709k, itVar, c1176a, dkCloudStorage, c1016b));
    }

    /* renamed from: a */
    public static ai m3980a() {
        return (ai) f2764m.m707a();
    }

    /* renamed from: a */
    public C0800c m3984a(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, af<Boolean> afVar) {
        try {
            this.k.mo1090a();
            if (!f2763a && dkStoreBookDetail == null) {
                throw new AssertionError();
            } else if (f2763a || dkCloudBookManifest != null) {
                UmengManager.get().onEvent("V2_SHELF_IMPORT_BOOK", "DuokanBook");
                m3873a(dkStoreBookDetail, dkCloudBookManifest);
                C0800c c = m3982c(dkStoreBookDetail, dkCloudBookManifest, afVar);
                return c;
            } else {
                throw new AssertionError();
            }
        } finally {
            this.k.mo1096b();
        }
    }

    /* renamed from: b */
    public C0800c m3989b(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, af<Boolean> afVar) {
        try {
            this.k.mo1090a();
            if (!f2763a && dkStoreBookDetail == null) {
                throw new AssertionError();
            } else if (f2763a || dkCloudBookManifest != null) {
                UmengManager.get().onEvent("V2_SHELF_IMPORT_BOOK", "DuokanBook");
                C0800c c = m3982c(dkStoreBookDetail, dkCloudBookManifest, afVar);
                return c;
            } else {
                throw new AssertionError();
            }
        } finally {
            this.k.mo1096b();
        }
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.UNDERGROUND) {
            m3945t();
            m3973a(0);
        }
    }

    /* renamed from: c */
    private C0800c m3982c(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, af<Boolean> afVar) {
        try {
            this.k.mo1090a();
            C0800c b = m3906b(dkStoreBookDetail.getBook().getBookUuid());
            if (b == null) {
                this.k.mo1096b();
                return b;
            }
            int i;
            File file = new File(this.f.getCloudBookDirectory(), dkStoreBookDetail.getBook().getBookUuid() + "." + dkCloudBookManifest.getBookRevision() + ".epub");
            DkPublic.rm(file);
            b.m4196a(Uri.fromFile(file).toString());
            b.m4207b(dkStoreBookDetail.getEpubSize());
            b.m4227f(dkCloudBookManifest.getBookRevision());
            if (dkStoreBookDetail.getBook().isFree()) {
                i = 0;
            } else {
                i = dkStoreBookDetail.getBook().getNewPrice();
            }
            b.m4175a(i);
            b.m4221d(dkStoreBookDetail.getBook().getNameLine());
            b.m4186a(m3905b(dkStoreBookDetail));
            m3928f(b);
            C0651y bookCertification = dkCloudBookManifest.getBookCertification();
            if (bookCertification != null && bookCertification.f2184b.length > 0 && bookCertification.f2185c.length > 0) {
                b.mo1011a(new ad(this.f.getDeviceIdVersion(), bookCertification.f2183a, C0366o.m1031a(bookCertification.f2184b) + "\n" + C0366o.m1031a(bookCertification.f2185c), 0));
                b.m4183a(BookLimitType.NONE);
            }
            this.g.m677b();
            b.aO();
            this.g.m681f();
            this.g.m678c();
            b.m4198a(b.m4225f(), dkCloudBookManifest.getBookUri(), dkCloudBookManifest.getBookRevision(), dkCloudBookManifest.getBookMd5(), true, afVar);
            m3949x();
            this.k.mo1096b();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            this.g.m678c();
            this.k.mo1096b();
            return null;
        } catch (Throwable th) {
            this.k.mo1096b();
        }
    }
}
