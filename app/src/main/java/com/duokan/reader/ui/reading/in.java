package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.epub.ay;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.gh;

import miuipub.date.Calendar;

public class in extends fs {
    final /* synthetic */ ij d;

    public in(ij ijVar, a aVar) {
        this.d = ijVar;
        super(ijVar, aVar);
    }

    public gh a(int i) {
        if (this.d.a.h() && i == 1) {
            Object obj;
            this.d.d = 1 + this.d.d;
            ej ejVar = (ej) this.d.a.G();
            n document = this.d.a.getDocument();
            long round = (long) Math.round((float) ((Math.max(this.d.b - 2, 1) * 60) * Calendar.MILLISECOND_OF_SECOND));
            long max = (long) ((Math.max(this.d.b, 1) * 60) * Calendar.MILLISECOND_OF_SECOND);
            long currentTimeMillis = System.currentTimeMillis() - this.d.c;
            if (this.d.d <= 5) {
                obj = null;
            } else if (ejVar.o() == BookType.SERIAL) {
                if (currentTimeMillis < round) {
                    obj = null;
                } else {
                    r2 = document.a(this.a);
                    document.d(r2);
                    if (r2.a(500)) {
                        round = ((ay) r2).k().g();
                        if (((ho) this.d.a).g(round) != (short) 0) {
                            obj = null;
                        } else if (currentTimeMillis < max) {
                            r1 = document.f(r2);
                            document.d(r1);
                            obj = r1.a(200) ? round != ((ay) r1).k().g() ? 1 : null : null;
                        } else {
                            obj = 1;
                        }
                    } else {
                        obj = null;
                    }
                }
            } else if (currentTimeMillis < round) {
                obj = null;
            } else if (currentTimeMillis < max) {
                r1 = document.a(this.a);
                r2 = document.f(r1);
                document.d(r1);
                document.d(r2);
                obj = (r1.a(200) && r2.a(200)) ? ((ay) r1).k().g() != ((ay) r2).k().g() ? 1 : null : null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.d.b = ejVar.be();
                this.d.c = System.currentTimeMillis();
                this.d.d = 0;
                View a = this.d.a.a(this.d.getContext());
                if (a != null) {
                    gh ilVar = new il(this.d, b(i), null, a);
                    if (ilVar != null) {
                        return ilVar;
                    }
                }
            }
        }
        return super.a(i);
    }
}
