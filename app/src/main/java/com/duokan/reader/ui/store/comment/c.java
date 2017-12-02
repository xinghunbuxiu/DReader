package com.duokan.reader.ui.store.comment;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.account.i;

class c implements cu {
    final /* synthetic */ boolean a;
    final /* synthetic */ DkCommentScoreView b;

    c(DkCommentScoreView dkCommentScoreView, boolean z) {
        this.b = dkCommentScoreView;
        this.a = z;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        if (!this.a) {
            this.b.a(pointF);
        } else if (i.f().b()) {
            this.b.a(pointF);
        } else {
            i.f().a(new d(this));
        }
    }
}
