package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.os.Looper;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.kg;
import com.duokan.reader.domain.document.epub.C0936c;
import java.util.Collections;
import java.util.LinkedList;

public class DkCloudStorage implements ai {
    /* renamed from: a */
    static final /* synthetic */ boolean f3593a = (!DkCloudStorage.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<DkCloudStorage> f3594b = new aj();
    /* renamed from: c */
    private final Context f3595c;
    /* renamed from: d */
    private final C0709k f3596d;

    public enum ConflictStrategy {
        MERGE,
        TAKE_SERVER_VERSION,
        TAKE_LOCAL_VERSION
    }

    private DkCloudStorage(Context context, C0709k c0709k) {
        this.f3595c = context;
        this.f3596d = c0709k;
    }

    /* renamed from: a */
    public DkCloudStoreBook m5009a(String str) {
        DkCloudStoreBook b = DkUserPurchasedBooksManager.m5029a().m5062b(str);
        if (b == null) {
            return DkUserPurchasedFictionsManager.m5072a().m5101b(str);
        }
        return b;
    }

    /* renamed from: a */
    public void m5014a(String str, ah ahVar) {
        if (!f3593a && str == null) {
            throw new AssertionError();
        } else if (!f3593a && ahVar == null) {
            throw new AssertionError();
        } else if (f3593a || m5008b()) {
            this.f3596d.m3497a(PersonalAccount.class, new C0855p(this, str, ahVar));
            DkUserPurchasedBooksManager.m5029a().m5069d(str);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void m5012a(DkCloudReadingInfo dkCloudReadingInfo, ConflictStrategy conflictStrategy, String str, boolean z, ak akVar) {
        if (!f3593a && dkCloudReadingInfo == null) {
            throw new AssertionError();
        } else if (f3593a || akVar != null) {
            this.f3596d.m3495a(new C0887v(this, dkCloudReadingInfo, z, conflictStrategy, str, akVar));
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void m5013a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudAnnotation[] dkCloudAnnotationArr, String str, al alVar) {
        this.f3596d.m3495a(new C0889x(this, dkCloudReadingInfo, dkCloudAnnotationArr, str, alVar));
    }

    /* renamed from: a */
    public void m5010a(int i, kg kgVar, DkCloudReadingInfo dkCloudReadingInfo, ConflictStrategy conflictStrategy, String str, al alVar) {
        if (!f3593a && dkCloudReadingInfo == null) {
            throw new AssertionError();
        } else if (f3593a || alVar != null) {
            this.f3596d.m3495a(new C0891z(this, dkCloudReadingInfo, i, kgVar, str, alVar, conflictStrategy));
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void m5015a(String str, String str2, boolean z, ai aiVar) {
        this.f3596d.m3495a(new ab(this, str, z, str2, aiVar));
    }

    /* renamed from: a */
    public void m5011a(C0800c c0800c, C0936c c0936c, String str, String str2, String str3, boolean z, aj ajVar) {
        new ad(this, new al(this.f3596d.m3502b(PersonalAccount.class)), c0936c, c0800c, str, str2, str3, z, ajVar).open();
    }

    /* renamed from: a */
    public static void m4996a(Context context, C0709k c0709k, ReaderEnv readerEnv) {
        DkUserPurchasedBooksManager.m5033a(context, c0709k);
        DkUserPurchasedFictionsManager.m5076a(context, c0709k);
        DkUserReadingNotesManager.m5137a(c0709k);
        ap.m5295a(context, c0709k);
        DkUserReadBookManager.m5116a(context, c0709k, readerEnv);
        ex.m5518a(context, c0709k);
        fl.m5555a(c0709k);
        f3594b.m709a(new DkCloudStorage(context, c0709k));
    }

    /* renamed from: a */
    public static DkCloudStorage m4994a() {
        return (DkCloudStorage) f3594b.m707a();
    }

    /* renamed from: a */
    private void m5000a(DkCloudReadingInfo dkCloudReadingInfo, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo2, String str, ak akVar) {
        new ae(this, c0672a.mo832b(), C0629b.f2117a, c0672a, dkCloudReadingInfo2, akVar, str, dkCloudReadingInfo).open();
    }

    /* renamed from: a */
    private void m4995a(int i, kg kgVar, DkCloudReadingInfo dkCloudReadingInfo, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo2, String str, al alVar) {
        new af(this, c0672a.mo832b(), C0629b.f2117a, c0672a, dkCloudReadingInfo2, i, kgVar, dkCloudReadingInfo, alVar, str).open();
    }

    /* renamed from: a */
    private void m4998a(DkCloudReadingInfo dkCloudReadingInfo, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo2, ConflictStrategy conflictStrategy, String str, ak akVar) {
        new ag(this, c0672a.mo832b(), C0629b.f2117a, c0672a, dkCloudReadingInfo2, akVar, str, conflictStrategy, dkCloudReadingInfo).open();
    }

    /* renamed from: a */
    private void m4999a(DkCloudReadingInfo dkCloudReadingInfo, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo2, ConflictStrategy conflictStrategy, String str, al alVar) {
        new C0883r(this, c0672a.mo832b(), C0629b.f2117a, c0672a, dkCloudReadingInfo2, alVar, str, dkCloudReadingInfo).open();
    }

    /* renamed from: a */
    private void m5001a(DkCloudReadingInfo dkCloudReadingInfo, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo2, DkCloudAnnotation[] dkCloudAnnotationArr, String str, al alVar) {
        String b = c0672a.mo832b();
        Object linkedList = new LinkedList();
        for (DkCloudAnnotation dkCloudAnnotation : dkCloudReadingInfo2.getAnnotations()) {
            Object obj = null;
            for (DkCloudAnnotation cloudId : dkCloudAnnotationArr) {
                if (dkCloudAnnotation.getCloudId().equals(cloudId.getCloudId())) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                linkedList.add(dkCloudAnnotation);
            }
        }
        Collections.sort(linkedList, new C0884s(this));
        new C0885t(this, b, C0629b.f2117a, c0672a, new DkCloudReadingInfo(dkCloudReadingInfo2.getCloudId(), dkCloudReadingInfo2.getBookName(), dkCloudReadingInfo2.getIsDuokanBook(), dkCloudReadingInfo2.getCloudVersion(), dkCloudReadingInfo2.getDeviceId(), dkCloudReadingInfo2.getBookRevision(), dkCloudReadingInfo2.getKernelVersion(), dkCloudReadingInfo2.getReadingProgress(), (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0])), dkCloudReadingInfo2, alVar, str, dkCloudReadingInfo, dkCloudAnnotationArr).open();
    }

    /* renamed from: a */
    private void m4997a(DkCloudReadingInfo dkCloudReadingInfo) {
        int i = 0;
        for (DkCloudAnnotation dkCloudAnnotation : dkCloudReadingInfo.getAnnotations()) {
            if (dkCloudAnnotation instanceof DkCloudComment) {
                i++;
            }
        }
        DkUserReadingNotesManager.m5136a().m5153a(dkCloudReadingInfo.getCloudId(), i);
    }

    /* renamed from: b */
    private boolean m5008b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
