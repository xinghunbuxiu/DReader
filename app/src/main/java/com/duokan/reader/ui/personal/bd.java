package com.duokan.reader.ui.personal;

import android.content.Context;
import android.widget.TextView;

import com.duokan.a.a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.UTools;

class bd extends a {
    final /* synthetic */ TextView b;
    final /* synthetic */ LinearScrollView c;
    final /* synthetic */ bc d;

    bd(bc bcVar, Context context, TextView textView, LinearScrollView linearScrollView) {
        this.d = bcVar;
        this.b = textView;
        this.c = linearScrollView;
        super(context);
    }

    protected void onSessionProgressUpdate(Object obj) {
        if (obj instanceof String) {
            this.b.append(obj + "\n");
            UTools.addAnimation(this.c, new be(this));
        }
    }

    protected void onSessionSucceeded() {
        WebLog.c().c(LogLevel.EVENT, "DIAGNOSTICS", this.b.getText().toString());
    }
}
