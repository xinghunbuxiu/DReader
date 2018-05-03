package com.duokan.reader.ui.p049a;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.ja;

/* renamed from: com.duokan.reader.ui.a.d */
class C1217d implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1214a f5710a;

    C1217d(C1214a c1214a) {
        this.f5710a = c1214a;
    }

    public void onClick(View view) {
        AnimUtils.m1909a(this.f5710a.getContext());
        this.f5710a.f5707l = new ja(this.f5710a.getContext());
        this.f5710a.f5707l.m10843a(this.f5710a.getString(C0258j.general__shared__committing));
        this.f5710a.f5707l.setCancelOnBack(false);
        UThread.postDelayed(new C1218e(this), 2000);
        this.f5710a.f5707l.show();
        this.f5710a.f5696a.run(this.f5710a.m8752a(true));
    }
}
