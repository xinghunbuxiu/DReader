package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.y;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.social.message.b;
import com.duokan.reader.domain.social.message.c;
import com.duokan.reader.domain.social.message.d;
import com.duokan.reader.domain.social.message.e;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.store.bv;
import com.duokan.reader.ui.store.comment.a;

class cf implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ k b;
    final /* synthetic */ y c;
    final /* synthetic */ ce d;

    cf(ce ceVar, int i, k kVar, y yVar) {
        this.d = ceVar;
        this.a = i;
        this.b = kVar;
        this.c = yVar;
    }

    public void onClick(View view) {
        if (this.d.f() == ViewMode.Edit) {
            this.d.a.b(0, this.a);
            return;
        }
        switch (this.b.c) {
            case 5:
                a.a(this.c, ((d) this.b.h).b.a);
                return;
            case 10:
                a.a(this.c, ((e) this.b.h).b.a);
                return;
            case 17:
                b bVar = (b) this.b.h;
                ((ReaderFeature) this.c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(a.a(this.c, bVar.a.c, bVar.a.d), null);
                return;
            case 18:
                c cVar = (c) this.b.h;
                if (cVar.a.b != 2) {
                    ((ReaderFeature) this.c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(a.a(this.c, cVar.a.b, cVar.a.c), null);
                    return;
                }
                return;
            case 19:
                ((ReaderFeature) this.c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(bv.a(this.c, ((com.duokan.reader.domain.social.message.a) this.b.h).a.d), null);
                return;
            default:
                return;
        }
    }
}
