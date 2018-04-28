package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.ey;

class iw implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ iu f8751a;

    iw(iu iuVar) {
        this.f8751a = iuVar;
    }

    public void onClick(View view) {
        ey eyVar = new ey(this.f8751a.getContext());
        eyVar.m10595d(this.f8751a.f8748a.getMessage());
        eyVar.m10588a(C0258j.personal__personal_redeem_info_view__prompt);
        eyVar.m10592b(C0258j.personal__personal_redeem_info_view__save);
        eyVar.m10590a(new ix(this));
        eyVar.show();
    }
}
