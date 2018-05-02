package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.store.comment.DkCommentScoreView;
import com.duokan.reader.ui.store.comment.e;

class eb implements e {
    final /* synthetic */ de a;

    eb(de deVar) {
        this.a = deVar;
    }

    public boolean a(DkCommentScoreView dkCommentScoreView, boolean z) {
        return false;
    }

    public void a(DkCommentScoreView dkCommentScoreView, int i, boolean z) {
        if (i > 0) {
            this.a.p.setEnabled(true);
        }
        this.a.a(i);
    }
}
