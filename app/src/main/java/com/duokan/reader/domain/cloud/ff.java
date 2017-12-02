package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkAnnotationBookInfo;
import com.duokan.reader.common.webservices.duokan.DkAnnotationsInfo;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.DkSyncService.NoteType;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.Arrays;
import java.util.LinkedList;

class ff extends b {
    final /* synthetic */ ab a;
    final /* synthetic */ fe b;
    private com.duokan.reader.common.webservices.b c = null;
    private com.duokan.reader.common.webservices.b d = null;
    private com.duokan.reader.common.webservices.b e = null;
    private DkCloudNoteBookInfo[] f = new DkCloudNoteBookInfo[0];
    private long g = -1;

    ff(fe feVar, ab abVar) {
        this.b = feVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        fn fnVar = new fn(this.a);
        fnVar.b();
        DkUserReadingNotesCacheInfo a = fnVar.a();
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.a);
        this.c = dkSyncService.a(NoteType.DUOKAN_BOOK_NOTE);
        this.d = dkSyncService.a(NoteType.DUOKAN_FICTION_NOTE);
        this.e = dkSyncService.a(NoteType.LOCAL_NOTE);
        LinkedList linkedList = new LinkedList();
        if (this.c.b == 0 && this.d.b == 0 && this.e.b == 0) {
            for (DkAnnotationBookInfo dkCloudNoteBookInfo : ((DkAnnotationsInfo) this.c.a).mBookInfos) {
                linkedList.add(new DkCloudNoteBookInfo(dkCloudNoteBookInfo, true));
            }
            for (DkAnnotationBookInfo dkCloudNoteBookInfo2 : ((DkAnnotationsInfo) this.d.a).mBookInfos) {
                linkedList.add(new DkCloudNoteBookInfo(dkCloudNoteBookInfo2, true));
            }
            for (DkAnnotationBookInfo dkCloudNoteBookInfo22 : ((DkAnnotationsInfo) this.e.a).mBookInfos) {
                linkedList.add(new DkCloudNoteBookInfo(dkCloudNoteBookInfo22, false));
            }
            this.f = (DkCloudNoteBookInfo[]) linkedList.toArray(new DkCloudNoteBookInfo[0]);
            Arrays.sort(this.f, new fj());
            fnVar.replaceWithItems((Object[]) this.f);
            a.mLatestFullRefreshTime = System.currentTimeMillis();
            a.mReadingNoteCount = 0;
            for (DkCloudNoteBookInfo noteCount : this.f) {
                a.mReadingNoteCount += (long) noteCount.getNoteCount();
            }
            fnVar.updateInfo(a);
            this.g = a.mReadingNoteCount;
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.b.c.d)) {
            this.b.a.a("");
        } else if (this.c.b == 1 || this.d.b == 1 || this.e.b == 1) {
            if (this.b.b) {
                i.f().a(this.a.a, new fg(this));
            } else {
                this.b.a.a("");
            }
        } else if (this.c.b == 0 && this.d.b == 0 && this.e.b == 0) {
            this.b.c.e = this.g;
            this.b.c.d();
            this.b.c.a(this.f);
            this.b.a.a(this.f, false);
        } else {
            this.b.a.a("");
        }
    }

    protected void onSessionFailed() {
        if (this.a.a(this.b.c.d)) {
            this.b.a.a("");
        } else {
            this.b.a.a("");
        }
    }
}
