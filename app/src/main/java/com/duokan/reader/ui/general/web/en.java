package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.PopupWindow;

class en implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ PopupWindow b;
    final /* synthetic */ el c;

    en(el elVar, EditText editText, PopupWindow popupWindow) {
        this.c = elVar;
        this.a = editText;
        this.b = popupWindow;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.a.getText().toString())) {
            this.c.d.a(r0);
        }
        this.b.dismiss();
    }
}
