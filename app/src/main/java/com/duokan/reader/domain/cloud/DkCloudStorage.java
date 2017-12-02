package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.os.Looper;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ju;

import java.util.Collections;
import java.util.LinkedList;

public class DkCloudStorage implements ah {
    static final /* synthetic */ boolean a = (!DkCloudStorage.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final Context c;
    private final i d;

    public enum ConflictStrategy {
        MERGE,
        TAKE_SERVER_VERSION,
        TAKE_LOCAL_VERSION
    }

    private DkCloudStorage(Context context, i iVar) {
        this.c = context;
        this.d = iVar;
    }

    public DkCloudStoreBook a(String str) {
        DkCloudStoreBook b = DkUserPurchasedBooksManager.a().b(str);
        if (b == null) {
            return DkUserPurchasedFictionsManager.a().b(str);
        }
        return b;
    }

    public void a(String str, ao aoVar) {
        if (!a && str == null) {
            throw new AssertionError();
        } else if (!a && aoVar == null) {
            throw new AssertionError();
        } else if (a || b()) {
            this.d.a(PersonalAccount.class, new q(this, str, aoVar));
            DkUserPurchasedBooksManager.a().d(str);
        } else {
            throw new AssertionError();
        }
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, ConflictStrategy conflictStrategy, String str, boolean z, ar arVar) {
        if (!a && dkCloudReadingInfo == null) {
            throw new AssertionError();
        } else if (a || arVar != null) {
            this.d.a(new y(this, dkCloudReadingInfo, z, conflictStrategy, str, arVar));
        } else {
            throw new AssertionError();
        }
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudAnnotation[] dkCloudAnnotationArr, String str, as asVar) {
        this.d.a(new aa(this, dkCloudReadingInfo, dkCloudAnnotationArr, str, asVar));
    }

    public void a(int i, ju juVar, DkCloudReadingInfo dkCloudReadingInfo, ConflictStrategy conflictStrategy, String str, as asVar) {
        if (!a && dkCloudReadingInfo == null) {
            throw new AssertionError();
        } else if (a || asVar != null) {
            this.d.a(new ac(this, dkCloudReadingInfo, i, juVar, str, asVar, conflictStrategy));
        } else {
            throw new AssertionError();
        }
    }

    public void a(String str, String str2, boolean z, ap apVar) {
        this.d.a(new ae(this, str, z, str2, apVar));
    }

    public void a(c cVar, com.duokan.reader.domain.document.epub.c cVar2, String str, String str2, String str3, boolean z, aq aqVar) {
        new ah(this, new ab(this.d.b(PersonalAccount.class)), cVar2, cVar, str, str2, str3, z, aqVar).open();
    }

    public static void a(Context context, i iVar, ReaderEnv readerEnv) {
        DkUserPurchasedBooksManager.a(context, iVar);
        DkUserPurchasedFictionsManager.a(context, iVar);
        DkUserReadingNotesManager.a(iVar);
        aw.a(context, iVar);
        DkUserReadBookManager.a(context, iVar, readerEnv);
        fp.a(context, iVar);
        gf.a(iVar);
        b.a(new DkCloudStorage(context, iVar));
    }

    public static DkCloudStorage a() {
        return (DkCloudStorage) b.a();
    }

    private void a(DkCloudReadingInfo dkCloudReadingInfo, a aVar, DkCloudReadingInfo dkCloudReadingInfo2, String str, ar arVar) {
        new ai(this, aVar, dkCloudReadingInfo2, aVar.b(), dkCloudReadingInfo, str, arVar).open();
    }

    private void a(int i, ju juVar, DkCloudReadingInfo dkCloudReadingInfo, a aVar, DkCloudReadingInfo dkCloudReadingInfo2, String str, as asVar) {
        new ak(this, aVar, dkCloudReadingInfo2, i, juVar, aVar.b(), dkCloudReadingInfo, str, asVar).open();
    }

    private void a(DkCloudReadingInfo dkCloudReadingInfo, a aVar, DkCloudReadingInfo dkCloudReadingInfo2, ConflictStrategy conflictStrategy, String str, ar arVar) {
        new am(this, aVar, dkCloudReadingInfo2, aVar.b(), dkCloudReadingInfo, conflictStrategy, str, arVar).open();
    }

    private void a(DkCloudReadingInfo dkCloudReadingInfo, a aVar, DkCloudReadingInfo dkCloudReadingInfo2, ConflictStrategy conflictStrategy, String str, as asVar) {
        new s(this, aVar, dkCloudReadingInfo2, aVar.b(), dkCloudReadingInfo, conflictStrategy, str, asVar).open();
    }

    private void a(DkCloudReadingInfo dkCloudReadingInfo, a aVar, DkCloudReadingInfo dkCloudReadingInfo2, DkCloudAnnotation[] dkCloudAnnotationArr, String str, as asVar) {
        String b = aVar.b();
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
        Collections.sort(linkedList, new u(this));
        new v(this, aVar, new DkCloudReadingInfo(dkCloudReadingInfo2.getCloudId(), dkCloudReadingInfo2.getBookName(), dkCloudReadingInfo2.getIsDuokanBook(), dkCloudReadingInfo2.getCloudVersion(), dkCloudReadingInfo2.getDeviceId(), dkCloudReadingInfo2.getBookRevision(), dkCloudReadingInfo2.getKernelVersion(), dkCloudReadingInfo2.getReadingProgress(), (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0])), b, dkCloudReadingInfo, dkCloudReadingInfo2, dkCloudAnnotationArr, str, asVar).open();
    }

    private void a(DkCloudReadingInfo dkCloudReadingInfo) {
        int i = 0;
        for (DkCloudAnnotation dkCloudAnnotation : dkCloudReadingInfo.getAnnotations()) {
            if (dkCloudAnnotation instanceof DkCloudComment) {
                i++;
            }
        }
        DkUserReadingNotesManager.a().a(dkCloudReadingInfo.getCloudId(), i);
    }

    private boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
