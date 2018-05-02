package com.duokan.reader.domain.bookshelf;

import com.duokan.core.p026a.C0285n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.al;
import com.duokan.reader.domain.document.av;

/* renamed from: com.duokan.reader.domain.bookshelf.k */
class C0816k implements al {
    /* renamed from: a */
    static final /* synthetic */ boolean f3435a = (!C0800c.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ av f3436b;
    /* renamed from: c */
    final /* synthetic */ C0800c f3437c;

    C0816k(C0800c c0800c, av avVar) {
        this.f3437c = c0800c;
        this.f3436b = avVar;
    }

    /* renamed from: a */
    public void mo1112a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        kg H = this.f3437c.m4155H();
        H.f3453a = 0;
        H.f3454b = 0;
        this.f3437c.m4191a(H);
        this.f3437c.aN();
    }

    /* renamed from: a */
    public void mo1113a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
    }

    /* renamed from: b */
    public void mo1114b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (f3435a || str != null) {
            C0285n h;
            int i;
            try {
                this.f3437c.D.mo1090a();
                if (str.equals(this.f3437c.m4162O())) {
                    Object obj = null;
                    if (dkCloudReadingInfo.getAnnotations() != dkCloudReadingInfo2.getAnnotations()) {
                        h = this.f3437c.D.mo1105h();
                        if (h == null) {
                            this.f3437c.D.mo1096b();
                            return;
                        }
                        h.m677b();
                        String str2 = "" + this.f3437c.aH();
                        h.m674a("DELETE FROM annotations WHERE book_id = ?", new String[]{str2});
                        for (DkCloudAnnotation a : dkCloudReadingInfo2.getAnnotations()) {
                            C0798a a2 = this.f3437c.m4121a(this.f3437c.mo1039q(), a);
                            h.m674a("INSERT INTO annotations(book_id, added_date, annotation_type, annotation_range, annotation_body, annotation_sample, annotation_uuid, modified_date) VALUES(?,?,?,?,?,?,?,?)", new String[]{str2, "" + a2.m3730g(), a2.mo956a().toString(), a2.m3734k(), a2.mo1008j(), a2.m3729f(), a2.m3732i(), "" + a2.m3731h()});
                        }
                        h.m681f();
                        h.m678c();
                        obj = 1;
                    }
                    this.f3437c.at();
                    this.f3437c.m4177a(dkCloudReadingInfo2.getCloudVersion(), "");
                    if (obj != null) {
                        this.f3437c.m4130a(this.f3437c, new C0825l(this), false);
                    }
                    this.f3437c.D.mo1096b();
                    return;
                }
                this.f3437c.m4194a(this.f3436b);
                this.f3437c.D.mo1096b();
            } catch (Exception e) {
                e.printStackTrace();
                h.m678c();
                i = 1;
            } catch (Throwable th) {
                this.f3437c.D.mo1096b();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void mo1115b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
    }
}
