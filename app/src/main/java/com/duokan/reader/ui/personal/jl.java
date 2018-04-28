package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.ui.C0342j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.ui.general.ja;

class jl implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8783a;

    jl(jg jgVar) {
        this.f8783a = jgVar;
    }

    public void onClick(View view) {
        boolean z = true;
        C0342j a = ja.m10832a(DkApp.get().getTopActivity(), "", this.f8783a.getString(C0450R.string.general__shared__push_server_accept), true, true);
        C0857b a2 = C0857b.m5649a();
        if (ReaderEnv.get().getReceivePushes()) {
            z = false;
        }
        a2.m5685a(z, new jm(this, a));
        this.f8783a.m12047a();
    }
}
