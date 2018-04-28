package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.common.C0259a;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class DkUserReadingNotesManager implements ai {
    /* renamed from: a */
    private static final aj<DkUserReadingNotesManager> f3623a = new aj();
    /* renamed from: b */
    private final C0709k f3624b;
    /* renamed from: c */
    private final C0586j f3625c;
    /* renamed from: d */
    private al f3626d;
    /* renamed from: e */
    private long f3627e = 0;
    /* renamed from: f */
    private final LinkedList<et> f3628f = new LinkedList();

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

    private DkUserReadingNotesManager(C0709k c0709k) {
        this.f3624b = c0709k;
        this.f3625c = new eg(this);
        this.f3626d = new al(C0709k.m3476a().m3508d());
        DkApp.get().runPreReady(new ei(this));
    }

    /* renamed from: a */
    public static void m5137a(C0709k c0709k) {
        f3623a.m709a(new DkUserReadingNotesManager(c0709k));
    }

    /* renamed from: a */
    public static DkUserReadingNotesManager m5136a() {
        return (DkUserReadingNotesManager) f3623a.m707a();
    }

    /* renamed from: a */
    public void m5152a(et etVar) {
        if (etVar != null && !this.f3628f.contains(etVar)) {
            this.f3628f.add(etVar);
        }
    }

    /* renamed from: b */
    public void m5157b(et etVar) {
        if (etVar != null) {
            this.f3628f.remove(etVar);
        }
    }

    /* renamed from: b */
    public long m5156b() {
        return this.f3627e;
    }

    /* renamed from: a */
    public void m5151a(C0517a<Void> c0517a) {
        if (this.f3626d.m3366b()) {
            c0517a.mo730a(null);
        } else {
            C0259a.m568a(new ej(this, this.f3626d, c0517a), new Void[0]);
        }
    }

    /* renamed from: a */
    public void m5153a(String str, int i) {
        ev evVar = new ev(this.f3626d);
        evVar.m5513b();
        DkCloudNoteBookInfo dkCloudNoteBookInfo = (DkCloudNoteBookInfo) evVar.queryItem(str);
        if (dkCloudNoteBookInfo != null) {
            dkCloudNoteBookInfo.setNoteCount(i);
            dkCloudNoteBookInfo.setLastDate(new Date());
            m5142a(dkCloudNoteBookInfo);
            int noteCount = i - dkCloudNoteBookInfo.getNoteCount();
            if (i == 0) {
                evVar.deleteItemWithKey(str);
            } else {
                evVar.updateItem(dkCloudNoteBookInfo);
            }
            DkUserReadingNotesCacheInfo a = evVar.m5512a();
            if (a.mReadingNoteCount >= 0) {
                a.mReadingNoteCount += (long) noteCount;
                evVar.updateInfo(a);
            }
            this.f3627e = ((long) noteCount) + this.f3627e;
            m5150d();
            m5138a(dkCloudNoteBookInfo);
        }
    }

    /* renamed from: c */
    public void m5158c() {
        m5155a(false, false, new ek(this));
    }

    /* renamed from: a */
    public void m5155a(boolean z, boolean z2, eu euVar) {
        C0672a d = this.f3624b.m3508d();
        if (z || d == null || !d.mo839i()) {
            DkUserPurchasedBooksManager.m5029a().m5053a(new el(this, z2, z, euVar));
        } else {
            euVar.mo1158a("");
        }
    }

    /* renamed from: a */
    private void m5141a(boolean z, eu euVar) {
        this.f3624b.m3495a(new en(this, euVar, z));
    }

    /* renamed from: b */
    private void m5147b(boolean z, eu euVar) {
        if (z || this.f3624b.m3507c()) {
            this.f3624b.m3495a(new ep(this, euVar, z));
        } else {
            euVar.mo1158a("");
        }
    }

    /* renamed from: a */
    private DkCloudNoteBookInfo[] m5144a(ev evVar) {
        DkCloudNoteBookInfo[] dkCloudNoteBookInfoArr = (DkCloudNoteBookInfo[]) evVar.queryItems().toArray(new DkCloudNoteBookInfo[0]);
        Arrays.sort(dkCloudNoteBookInfoArr, new er());
        return dkCloudNoteBookInfoArr;
    }

    /* renamed from: a */
    private void m5142a(DkCloudNoteBookInfo... dkCloudNoteBookInfoArr) {
        for (DkCloudNoteBookInfo dkCloudNoteBookInfo : dkCloudNoteBookInfoArr) {
            if (dkCloudNoteBookInfo.isDuokanBookNote() && TextUtils.isEmpty(dkCloudNoteBookInfo.getBookName())) {
                DkCloudPurchasedBook a = DkUserPurchasedBooksManager.m5029a().m5052a(dkCloudNoteBookInfo.getBookUuid());
                DkCloudPurchasedFiction a2 = DkUserPurchasedFictionsManager.m5072a().m5093a(dkCloudNoteBookInfo.getBookUuid());
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

    /* renamed from: a */
    protected void m5154a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        Iterator it = this.f3628f.iterator();
        while (it.hasNext()) {
            ((et) it.next()).mo959a(str, dkCloudAnnotationArr);
        }
    }

    /* renamed from: d */
    private void m5150d() {
        Iterator it = this.f3628f.iterator();
        while (it.hasNext()) {
            ((et) it.next()).mo967f();
        }
    }

    /* renamed from: a */
    private void m5138a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        Iterator it = this.f3628f.iterator();
        while (it.hasNext()) {
            ((et) it.next()).mo958a(dkCloudNoteBookInfo);
        }
    }
}
