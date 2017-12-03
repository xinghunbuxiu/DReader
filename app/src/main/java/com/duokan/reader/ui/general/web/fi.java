package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.duokan.core.ui.UTools;

import org.json.JSONObject;

class fi implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ ff b;

    fi(ff ffVar, EditText editText) {
        this.b = ffVar;
        this.a = editText;
    }

    public void onClick(View view) {
        CharSequence obj = this.a.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operation", 1);
                jSONObject.put("text", obj);
                if (this.b.g.b.b.mInputFlag != null) {
                    jSONObject.put("flag", this.b.g.b.b.mInputFlag);
                }
                this.b.g.b.b.triggerEventOnCurrentUrl("input", jSONObject.toString());
            } catch (Throwable th) {
            }
        }
        this.a.setText("");
        this.a.clearFocus();
        UTools.hideSoftInputFromWindow(this.b.g.b.b.getContext());
    }
}
