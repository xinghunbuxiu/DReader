package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class DkUserReadingNotesManager implements ah {
    private static final ai a = new ai();
    private final i b;
    private final h c;
    private ab d;
    private long e = 0;
    private final LinkedList f = new LinkedList();

    class DkUserReadingNotesCacheInfo implements Serializable {
        public String mAccountName;
        public String mAccountUuid;
        public long mLatestFullRefreshTime;
        public long mReadingNoteCount;

        private DkUserReadingNotesCacheInfo() {
            this.mAccountUuid = null;
            this.mAccountName = null;
        }
    }

    private DkUserReadingNotesManager(i iVar) {
        this.b = iVar;
        this.c = new ex(this);
        this.d = new ab(i.f().c());
        DkApp.get().runPreReady(new ez(this));
    }

    public static void a(i iVar) {
        a.a(new DkUserReadingNotesManager(iVar));
    }

    public static DkUserReadingNotesManager a() {
        return (DkUserReadingNotesManager) a.a();
    }

    public void a(fl flVar) {
        if (flVar != null && !this.f.contains(flVar)) {
            this.f.add(flVar);
        }
    }

    public void b(fl flVar) {
        if (flVar != null) {
            this.f.remove(flVar);
        }
    }

    public long b() {
        return this.e;
    }

    public void a(a aVar) {
        if (this.d.b()) {
            aVar.a(null);
        } else {
            com.duokan.common.a.a(new fa(this, this.d, aVar), new Void[0]);
        }
    }

    public void a(String str, int i) {
        fn fnVar = new fn(this.d);
        fnVar.b();
        DkCloudNoteBookInfo dkCloudNoteBookInfo = (DkCloudNoteBookInfo) fnVar.queryItem(str);
        if (dkCloudNoteBookInfo != null) {
            dkCloudNoteBookInfo.setNoteCount(i);
            dkCloudNoteBookInfo.setLastDate(new Date());
            a(dkCloudNoteBookInfo);
            int noteCount = i - dkCloudNoteBookInfo.getNoteCount();
            if (i == 0) {
                fnVar.deleteItemWithKey(str);
            } else {
                fnVar.updateItem(dkCloudNoteBookInfo);
            }
            DkUserReadingNotesCacheInfo a = fnVar.a();
            if (a.mReadingNoteCount >= 0) {
                a.mReadingNoteCount += (long) noteCount;
                fnVar.updateInfo(a);
            }
            this.e = ((long) noteCount) + this.e;
            d();
            a(dkCloudNoteBookInfo);
        }
    }

    public void c() {
        a(false, false, new fb(this));
    }

    public void a(boolean z, boolean z2, fm fmVar) {
        com.duokan.reader.domain.account.a c = this.b.c();
        if (z || c == null || !c.i()) {
            DkUserPurchasedBooksManager.a().a(new fc(this, z2, z, fmVar));
        } else {
            fmVar.a("");
        }
    }

    private void a(boolean z, fm fmVar) {
        this.b.a(new fe(this, fmVar, z));
    }

    private void b(boolean z, fm fmVar) {
        if (z || this.b.b()) {
            this.b.a(new fh(this, fmVar, z));
        } else {
            fmVar.a("");
        }
    }

    private DkCloudNoteBookInfo[] a(fn fnVar) {
        DkCloudNoteBookInfo[] dkCloudNoteBookInfoArr = (DkCloudNoteBookInfo[]) fnVar.queryItems().toArray(new DkCloudNoteBookInfo[0]);
        Arrays.sort(dkCloudNoteBookInfoArr, new fj());
        return dkCloudNoteBookInfoArr;
    }

    private void a(DkCloudNoteBookInfo... dkCloudNoteBookInfoArr) {
        for (DkCloudNoteBookInfo dkCloudNoteBookInfo : dkCloudNoteBookInfoArr) {
            if (dkCloudNoteBookInfo.isDuokanBookNote() && TextUtils.isEmpty(dkCloudNoteBookInfo.getBookName())) {
                DkCloudPurchasedBook a = DkUserPurchasedBooksManager.a().a(dkCloudNoteBookInfo.getBookUuid());
                DkCloudPurchasedFiction a2 = DkUserPurchasedFictionsManager.a().a(dkCloudNoteBookInfo.getBookUuid());
                if (a != null) {
                    dkCloudNoteBookInfo.setTitle(a.getTitle());
                    dkCloudNoteBookInfo.setBookEditor(a.getEditorLine());
                    dkCloudNoteBookInfo.setBookAuthor(a.getAuthorLine());
                    dkCloudNoteBookInfo.setBookCoverUrl(a.getCoverUri());
                } else if (a2 != null) {
                    dkCloudNoteBookInfo.setTitle(a2.getTitle());
                    dkCloudNoteBookInfo.setBookEditor(a2.getEditorLine());
                    dkCloudNoteBookInfo.setBookAuthor(a2.getAuthorLine());
                    dkCloudNoteBookInfo.setBookCoverUrl(a2.getCoverUri());
                }
            }
        }
    }

    protected void a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((fl) it.next()).a(str, dkCloudAnnotationArr);
        }
    }

    private void d() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((fl) it.next()).f();
        }
    }

    private void a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((fl) it.next()).a(dkCloudNoteBookInfo);
        }
    }
}
