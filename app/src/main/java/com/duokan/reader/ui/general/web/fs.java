package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.duokan.core.ui.dv;
import org.json.JSONObject;

class fs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ EditText f7857a;
    /* renamed from: b */
    final /* synthetic */ fp f7858b;

    fs(fp fpVar, EditText editText) {
        this.f7858b = fpVar;
        this.f7857a = editText;
    }

    public void onClick(View view) {
        CharSequence obj = this.f7857a.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operation", 1);
                jSONObject.put("text", obj);
                if (this.f7858b.f7852g.f7845b.f7581b.mInputFlag != null) {
                    jSONObject.put("flag", this.f7858b.f7852g.f7845b.f7581b.mInputFlag);
                }
                this.f7858b.f7852g.f7845b.f7581b.triggerEventOnCurrentUrl("input", jSONObject.toString());
            } catch (Throwable th) {
            }
        }
        this.f7857a.setText("");
        this.f7857a.clearFocus();
        dv.m1909a(this.f7858b.f7852g.f7845b.f7581b.getContext());
    }
}
