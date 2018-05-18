package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.p041a.C0664a;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.be;

class ei implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ dg f10073a;

    ei(dg dgVar) {
        this.f10073a = dgVar;
    }

    public void onClick(View view) {
        if (dg.f9991b.m861b()) {
            el elVar = (el) dg.f9991b.m858a();
            int score = (int) this.f10073a.f10010k.getScore();
            if (score < 1) {
                be.m10286a(this.f10073a.getContext(), C0258j.store_comment__publish_comment_view__rating_null, 0).show();
                return;
            }
            String obj = this.f10073a.f10012m.getText().toString();
            ReaderUi.m10161a(this.f10073a.getContext(), this.f10073a);
            C0664a.m3108a().m3113a(this.f10073a.f10025z.getId(), score, elVar.f10082d.f2064i, obj, new ej(this, elVar, score, obj));
        }
    }
}
