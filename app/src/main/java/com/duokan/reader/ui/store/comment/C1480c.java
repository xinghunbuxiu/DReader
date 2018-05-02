package com.duokan.reader.ui.store.comment;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.account.C0709k;

/* renamed from: com.duokan.reader.ui.store.comment.c */
class C1480c implements cu {
    /* renamed from: a */
    final /* synthetic */ boolean f11401a;
    /* renamed from: b */
    final /* synthetic */ DkCommentScoreView f11402b;

    C1480c(DkCommentScoreView dkCommentScoreView, boolean z) {
        this.f11402b = dkCommentScoreView;
        this.f11401a = z;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        if (!this.f11401a) {
            this.f11402b.m15364a(pointF);
        } else if (C0709k.m3476a().m3507c()) {
            this.f11402b.m15364a(pointF);
        } else {
            C0709k.m3476a().m3495a(new C1481d(this));
        }
    }
}
