package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.domain.plugins.dict.d */
class C1109d implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1114i f5391a;
    /* renamed from: b */
    final /* synthetic */ int f5392b;
    /* renamed from: c */
    final /* synthetic */ C1106a f5393c;

    C1109d(C1106a c1106a, C1114i c1114i, int i) {
        this.f5393c = c1106a;
        this.f5391a = c1114i;
        this.f5392b = i;
    }

    public void onClick(View view) {
        ap c1110e = new C1110e(this, this.f5393c.f5386a.getContext());
        c1110e.setTitle(C0247i.reading__translation_view__delete_dict_confirm_title);
        c1110e.setPrompt(String.format(this.f5393c.f5386a.getString(C0247i.reading__translation_view__delete_dict_confirm_hint), new Object[]{this.f5391a.m8407a()}));
        c1110e.setOkLabelResid(C0247i.reading__translation_view__delete_dict_confirm_ok);
        c1110e.setNoLabel(C0247i.reading__translation_view__delete_dict_confirm_canel);
        c1110e.setCancelOnTouchOutside(true);
        c1110e.setCancelOnBack(true);
        c1110e.show();
    }
}
