package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.domain.a.a;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.be;

class ec implements OnClickListener {
    final /* synthetic */ de a;

    ec(de deVar) {
        this.a = deVar;
    }

    public void onClick(View view) {
        if (de.b.b()) {
            eh ehVar = (eh) de.b.a();
            int score = (int) this.a.j.getScore();
            if (score < 1) {
                be.a(this.a.getContext(), j.store_comment__publish_comment_view__rating_null, 0).show();
                return;
            }
            String obj = this.a.l.getText().toString();
            ReaderUi.a(this.a.getContext(), this.a);
            a.a().a(this.a.y.H(), score, ehVar.d.i, obj, new ed(this, ehVar, score, obj));
        }
    }
}
