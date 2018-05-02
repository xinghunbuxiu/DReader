package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class n implements OnClickListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public void onClick(View view) {
        l lVar = (l) view.getTag();
        if (lVar != null && !lVar.e) {
            this.a.post(new o(this, lVar));
        }
    }
}
