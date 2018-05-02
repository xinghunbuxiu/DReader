package com.duokan.reader.domain.bookshelf;

import com.duokan.core.p026a.C0285n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.ak;

/* renamed from: com.duokan.reader.domain.bookshelf.h */
class C0810h implements ak {
    /* renamed from: a */
    static final /* synthetic */ boolean f3280a = (!C0800c.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0801y f3281b;
    /* renamed from: c */
    final /* synthetic */ boolean f3282c;
    /* renamed from: d */
    final /* synthetic */ C0800c f3283d;

    C0810h(C0800c c0800c, C0801y c0801y, boolean z) {
        this.f3283d = c0800c;
        this.f3281b = c0801y;
        this.f3282c = z;
    }

    /* renamed from: a */
    public void mo1084a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (dkCloudReadingInfo2.getReadingProgress() == null || dkCloudReadingInfo2.getReadingProgress().equals(dkCloudReadingInfo.getReadingProgress())) {
            this.f3281b.mo1001a(this.f3283d, false);
            return;
        }
        this.f3283d.m4152E().f3445a = this.f3283d.m4124a(this.f3283d.mo1039q(), dkCloudReadingInfo2.getReadingProgress().getStartPos(), this.f3283d.m4157J(), dkCloudReadingInfo2.getKernelVersion());
        this.f3281b.mo1001a(this.f3283d, true);
    }

    /* renamed from: a */
    public void mo1085a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.f3281b.mo1000a(this.f3283d, str);
    }

    /* renamed from: b */
    public void mo1086b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (f3280a || str != null) {
            C0285n h;
            try {
                this.f3283d.D.mo1090a();
                if (!str.equals(this.f3283d.m4162O())) {
                    this.f3283d.m4202a(this.f3282c, this.f3281b);
                } else if (dkCloudReadingInfo.getAnnotations() != dkCloudReadingInfo2.getAnnotations()) {
                    h = this.f3283d.D.mo1105h();
                    if (h == null) {
                        this.f3283d.D.mo1096b();
                        return;
                    }
                    h.m677b();
                    String str2 = "" + this.f3283d.aH();
                    h.m674a("DELETE FROM annotations WHERE book_id = ?", new String[]{str2});
                    for (DkCloudAnnotation a : dkCloudReadingInfo2.getAnnotations()) {
                        C0798a a2 = this.f3283d.m4121a(this.f3283d.mo1039q(), a);
                        h.m674a("INSERT INTO annotations(book_id, added_date, annotation_type, annotation_range, annotation_body, annotation_sample, annotation_uuid, modified_date) VALUES(?,?,?,?,?,?,?,?)", new String[]{str2, "" + a2.m3730g(), a2.mo956a().toString(), a2.m3734k(), a2.mo1008j(), a2.m3729f(), a2.m3732i(), "" + a2.m3731h()});
                    }
                    h.m681f();
                    h.m678c();
                    this.f3283d.at();
                    this.f3283d.m4177a(dkCloudReadingInfo2.getCloudVersion(), str);
                    this.f3283d.m4130a(this.f3283d, new C0813i(this), false);
                } else {
                    this.f3281b.mo1003b(this.f3283d, false);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.m678c();
            } catch (Throwable th) {
                this.f3283d.D.mo1096b();
            }
            this.f3283d.D.mo1096b();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void mo1087b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.f3281b.mo1002b(this.f3283d, str);
    }
}
