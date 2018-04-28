package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkAnnotationBookInfo;
import com.duokan.reader.common.webservices.duokan.DkAnnotationsInfo;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.DkSyncService.NoteType;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import java.util.Arrays;
import java.util.LinkedList;

class eo extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3939a;
    /* renamed from: b */
    final /* synthetic */ en f3940b;
    /* renamed from: c */
    private C0621a<DkAnnotationsInfo> f3941c = null;
    /* renamed from: d */
    private C0621a<DkAnnotationsInfo> f3942d = null;
    /* renamed from: e */
    private C0621a<DkAnnotationsInfo> f3943e = null;
    /* renamed from: f */
    private DkCloudNoteBookInfo[] f3944f = new DkCloudNoteBookInfo[0];
    /* renamed from: g */
    private long f3945g = -1;

    eo(en enVar, String str, C0657i c0657i, al alVar) {
        this.f3940b = enVar;
        this.f3939a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        ev evVar = new ev(this.f3939a);
        evVar.m5513b();
        DkUserReadingNotesCacheInfo a = evVar.m5512a();
        DkSyncService dkSyncService = new DkSyncService((WebSession) this, this.f3939a);
        this.f3941c = dkSyncService.m2822a(NoteType.DUOKAN_BOOK_NOTE);
        this.f3942d = dkSyncService.m2822a(NoteType.DUOKAN_FICTION_NOTE);
        this.f3943e = dkSyncService.m2822a(NoteType.LOCAL_NOTE);
        LinkedList linkedList = new LinkedList();
        if (this.f3941c.b == 0 && this.f3942d.b == 0 && this.f3943e.b == 0) {
            for (DkAnnotationBookInfo dkCloudNoteBookInfo : ((DkAnnotationsInfo) this.f3941c.f2058a).mBookInfos) {
                linkedList.add(new DkCloudNoteBookInfo(dkCloudNoteBookInfo, true));
            }
            for (DkAnnotationBookInfo dkCloudNoteBookInfo2 : ((DkAnnotationsInfo) this.f3942d.f2058a).mBookInfos) {
                linkedList.add(new DkCloudNoteBookInfo(dkCloudNoteBookInfo2, true));
            }
            for (DkAnnotationBookInfo dkCloudNoteBookInfo22 : ((DkAnnotationsInfo) this.f3943e.f2058a).mBookInfos) {
                linkedList.add(new DkCloudNoteBookInfo(dkCloudNoteBookInfo22, false));
            }
            this.f3944f = (DkCloudNoteBookInfo[]) linkedList.toArray(new DkCloudNoteBookInfo[0]);
            Arrays.sort(this.f3944f, new er());
            evVar.replaceWithItems((Object[]) this.f3944f);
            a.mLatestFullRefreshTime = System.currentTimeMillis();
            a.mReadingNoteCount = 0;
            for (DkCloudNoteBookInfo noteCount : this.f3944f) {
                a.mReadingNoteCount += (long) noteCount.getNoteCount();
            }
            evVar.updateInfo(a);
            this.f3945g = a.mReadingNoteCount;
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3939a.m3365a(this.f3940b.f3938c.f3626d)) {
            this.f3940b.f3936a.mo1158a("");
        } else if (this.f3941c.b == 0 && this.f3942d.b == 0 && this.f3943e.b == 0) {
            this.f3940b.f3938c.f3627e = this.f3945g;
            this.f3940b.f3938c.m5150d();
            this.f3940b.f3938c.m5142a(this.f3944f);
            this.f3940b.f3936a.mo1159a(this.f3944f, false);
        } else {
            this.f3940b.f3936a.mo1158a("");
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3939a.m3365a(this.f3940b.f3938c.f3626d)) {
            this.f3940b.f3936a.mo1158a(str);
        } else {
            this.f3940b.f3936a.mo1158a("");
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return (this.f3941c.b == 1 || this.f3942d.b == 1 || this.f3943e.b == 1) && this.f3940b.f3937b;
    }
}
