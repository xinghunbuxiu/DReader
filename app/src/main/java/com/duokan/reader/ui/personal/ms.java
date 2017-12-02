package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class ms implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ mq b;

    ms(mq mqVar, int i) {
        this.b = mqVar;
        this.a = i;
    }

    public boolean onLongClick(View view) {
        this.b.c.a(0, this.a);
        return true;
    }
}
