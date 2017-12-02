package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.b.i;
import com.duokan.reader.ui.general.ap;

class d implements OnClickListener {
    final /* synthetic */ i a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;

    d(a aVar, i iVar, int i) {
        this.c = aVar;
        this.a = iVar;
        this.b = i;
    }

    public void onClick(View view) {
        ap eVar = new e(this, this.c.a.getContext());
        eVar.setTitle(i.reading__translation_view__delete_dict_confirm_title);
        eVar.setPrompt(String.format(this.c.a.getString(i.reading__translation_view__delete_dict_confirm_hint), new Object[]{this.a.a()}));
        eVar.setOkLabel(i.reading__translation_view__delete_dict_confirm_ok);
        eVar.setNoLabel(i.reading__translation_view__delete_dict_confirm_canel);
        eVar.setCancelOnTouchOutside(true);
        eVar.setCancelOnBack(true);
        eVar.show();
    }
}
