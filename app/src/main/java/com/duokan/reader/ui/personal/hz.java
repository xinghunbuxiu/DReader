package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class hz implements OnClickListener {
    final /* synthetic */ hw a;

    hz(hw hwVar) {
        this.a = hwVar;
    }

    public void onClick(View view) {
        this.a.b.pushHalfPageSmoothly(new hi(this.a.getContext()), null);
    }
}
