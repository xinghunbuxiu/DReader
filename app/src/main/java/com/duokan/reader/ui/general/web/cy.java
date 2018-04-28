package com.duokan.reader.ui.general.web;

import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.C0435s;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class cy implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ ci f7710a;

    cy(ci ciVar) {
        this.f7710a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11073a();
    }

    /* renamed from: a */
    public String m11073a() {
        JSONObject jSONObject = new JSONObject();
        int pageHeaderPaddingTop = ((C0435s) AppContext.getAppContext(this.f7710a.f7581b.getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderPaddingTop();
        if (!ReaderEnv.get().isNotchDevice()) {
            pageHeaderPaddingTop = 0;
        }
        jSONObject.put("top", Integer.valueOf(pageHeaderPaddingTop));
        jSONObject.put("bottom", 0);
        jSONObject.put("left", 0);
        jSONObject.put("right", 0);
        return jSONObject.toString();
    }
}
