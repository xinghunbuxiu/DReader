package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.social.message.C1139a;
import com.duokan.reader.domain.social.message.C1141b;
import com.duokan.reader.domain.social.message.C1142c;
import com.duokan.reader.domain.social.message.C1143d;
import com.duokan.reader.domain.social.message.C1144e;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.store.bv;
import com.duokan.reader.ui.store.comment.C1478a;

class by implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8382a;
    /* renamed from: b */
    final /* synthetic */ C1151k f8383b;
    /* renamed from: c */
    final /* synthetic */ IFeature f8384c;
    /* renamed from: d */
    final /* synthetic */ bx f8385d;

    by(bx bxVar, int i, C1151k c1151k, IFeature mFeature) {
        this.f8385d = bxVar;
        this.f8382a = i;
        this.f8383b = c1151k;
        this.f8384c = mFeature;
    }

    public void onClick(View view) {
        if (this.f8385d.mo1714f() == ViewMode.Edit) {
            this.f8385d.f8381a.m11522b(0, this.f8382a);
            return;
        }
        switch (this.f8383b.f5556c) {
            case 5:
                C1478a.m15369a(this.f8384c, ((C1143d) this.f8383b.f5561h).f5535b.f2073a);
                return;
            case 10:
                C1478a.m15369a(this.f8384c, ((C1144e) this.f8383b.f5561h).f5537b.f2073a);
                return;
            case 17:
                C1141b c1141b = (C1141b) this.f8383b.f5561h;
                ((ReaderFeature) this.f8384c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(C1478a.m15368a(this.f8384c, c1141b.f5532a.f2127c, c1141b.f5532a.f2128d), null);
                return;
            case 18:
                C1142c c1142c = (C1142c) this.f8383b.f5561h;
                if (c1142c.f5533a.f2132b != 2) {
                    ((ReaderFeature) this.f8384c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(C1478a.m15368a(this.f8384c, c1142c.f5533a.f2132b, c1142c.f5533a.f2133c), null);
                    return;
                }
                return;
            case 19:
                ((ReaderFeature) this.f8384c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(bv.m15354a(this.f8384c, ((C1139a) this.f8383b.f5561h).f5483a.f2123d), null);
                return;
            default:
                return;
        }
    }
}
