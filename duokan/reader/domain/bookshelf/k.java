package com.duokan.reader.domain.bookshelf;

import com.duokan.core.a.n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.as;
import com.duokan.reader.domain.document.av;

class k implements as {
    static final /* synthetic */ boolean a = (!c.class.desiredAssertionStatus());
    final /* synthetic */ av b;
    final /* synthetic */ c c;

    k(c cVar, av avVar) {
        this.c = cVar;
        this.b = avVar;
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        ju G = this.c.G();
        G.a = 0;
        G.b = 0;
        this.c.a(G);
        this.c.aL();
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (a || str != null) {
            n h;
            int i;
            try {
                this.c.D.a();
                if (str.equals(this.c.N())) {
                    Object obj = null;
                    if (dkCloudReadingInfo.getAnnotations() != dkCloudReadingInfo2.getAnnotations()) {
                        h = this.c.D.h();
                        if (h == null) {
                            this.c.D.b();
                            return;
                        }
                        h.b();
                        String str2 = "" + this.c.aF();
                        h.a("DELETE FROM annotations WHERE book_id = ?", new String[]{str2});
                        for (DkCloudAnnotation a : dkCloudReadingInfo2.getAnnotations()) {
                            a a2 = this.c.a(this.c.q(), a);
                            h.a("INSERT INTO annotations(book_id, added_date, annotation_type, annotation_range, annotation_body, annotation_sample, annotation_uuid, modified_date) VALUES(?,?,?,?,?,?,?,?)", new String[]{str2, "" + a2.g(), a2.a().toString(), a2.k(), a2.j(), a2.f(), a2.i(), "" + a2.h()});
                        }
                        h.f();
                        h.c();
                        obj = 1;
                    }
                    this.c.ar();
                    this.c.a(dkCloudReadingInfo2.getCloudVersion(), "");
                    if (obj != null) {
                        this.c.a(this.c, new l(this), false);
                    }
                    this.c.D.b();
                    return;
                }
                this.c.a(this.b);
                this.c.D.b();
            } catch (Exception e) {
                e.printStackTrace();
                h.c();
                i = 1;
            } catch (Throwable th) {
                this.c.D.b();
            }
        } else {
            throw new AssertionError();
        }
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
    }
}
