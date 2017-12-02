package com.duokan.reader.domain.bookshelf;

import com.duokan.core.a.n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.ar;

class h implements ar {
    static final /* synthetic */ boolean a = (!c.class.desiredAssertionStatus());
    final /* synthetic */ y b;
    final /* synthetic */ boolean c;
    final /* synthetic */ c d;

    h(c cVar, y yVar, boolean z) {
        this.d = cVar;
        this.b = yVar;
        this.c = z;
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (dkCloudReadingInfo2.getReadingProgress() == null || dkCloudReadingInfo2.getReadingProgress().equals(dkCloudReadingInfo.getReadingProgress())) {
            this.b.a(this.d, false);
            return;
        }
        this.d.D().a = this.d.a(this.d.q(), dkCloudReadingInfo2.getReadingProgress().getStartPos(), this.d.I(), dkCloudReadingInfo2.getKernelVersion());
        this.b.a(this.d, true);
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.b.a(this.d, str);
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (a || str != null) {
            n h;
            try {
                this.d.D.a();
                if (!str.equals(this.d.N())) {
                    this.d.a(this.c, this.b);
                } else if (dkCloudReadingInfo.getAnnotations() != dkCloudReadingInfo2.getAnnotations()) {
                    h = this.d.D.h();
                    if (h == null) {
                        this.d.D.b();
                        return;
                    }
                    h.b();
                    String str2 = "" + this.d.aF();
                    h.a("DELETE FROM annotations WHERE book_id = ?", new String[]{str2});
                    for (DkCloudAnnotation a : dkCloudReadingInfo2.getAnnotations()) {
                        a a2 = this.d.a(this.d.q(), a);
                        h.a("INSERT INTO annotations(book_id, added_date, annotation_type, annotation_range, annotation_body, annotation_sample, annotation_uuid, modified_date) VALUES(?,?,?,?,?,?,?,?)", new String[]{str2, "" + a2.g(), a2.a().toString(), a2.k(), a2.j(), a2.f(), a2.i(), "" + a2.h()});
                    }
                    h.f();
                    h.c();
                    this.d.ar();
                    this.d.a(dkCloudReadingInfo2.getCloudVersion(), str);
                    this.d.a(this.d, new i(this), false);
                } else {
                    this.b.b(this.d, false);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.c();
            } catch (Throwable th) {
                this.d.D.b();
            }
            this.d.D.b();
            return;
        }
        throw new AssertionError();
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.b.b(this.d, str);
    }
}
