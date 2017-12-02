package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.be;

class zl implements OnClickListener {
    final /* synthetic */ zk a;

    zl(zk zkVar) {
        this.a = zkVar;
    }

    public void onClick(View view) {
        Object trim = this.a.g.getEditableText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            be.a(this.a.getContext(), j.reading__send_error_view__toast, 1).show();
            return;
        }
        ReaderUi.a(this.a.getContext(), this.a.g);
        this.a.a((String) trim);
        this.a.f.setEnabled(false);
    }
}
