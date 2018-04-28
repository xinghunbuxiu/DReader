package com.duokan.reader.ui.general.web;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.C0435s;

class ew implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7804a;
    /* renamed from: b */
    final /* synthetic */ String f7805b;
    /* renamed from: c */
    final /* synthetic */ String f7806c;
    /* renamed from: d */
    final /* synthetic */ C1352a f7807d;
    /* renamed from: e */
    final /* synthetic */ eq f7808e;

    ew(eq eqVar, String str, String str2, String str3, C1352a c1352a) {
        this.f7808e = eqVar;
        this.f7804a = str;
        this.f7805b = str2;
        this.f7806c = str3;
        this.f7807d = c1352a;
    }

    public void run() {
        View inflate = LayoutInflater.from(this.f7808e.f7793b.f7581b.getContext()).inflate(C0256h.general__dk_text_input_dialog_view, null);
        EditText editText = (EditText) inflate.findViewById(C0255g.general__shared_text_input_dialog_view__edit);
        TextView textView = (TextView) inflate.findViewById(C0255g.general__shared_text_input_dialog_view__confirm);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setSoftInputMode(16);
        popupWindow.setInputMethodMode(0);
        if (!TextUtils.isEmpty(this.f7804a)) {
            editText.setHint(this.f7804a);
        }
        if (!TextUtils.isEmpty(this.f7805b)) {
            editText.setText(this.f7805b);
        }
        if (!TextUtils.isEmpty(this.f7806c)) {
            textView.setText(this.f7806c);
        }
        C0435s c0435s = (C0435s) this.f7808e.f7793b.f7581b.getContext().queryFeature(C0435s.class);
        popupWindow.showAtLocation(this.f7808e.f7793b.f7581b.js_getContentView(), 80, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        editText.postDelayed(new ex(this, editText), 200);
        textView.setOnClickListener(new ey(this, editText, popupWindow));
    }
}
