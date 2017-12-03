package com.duokan.reader.ui.store;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.UmengManager;

import java.util.LinkedList;

public class j extends ActivatedController {
    private final String a;
    private final LinkedList b = new LinkedList();
    private final l c;

    public j(IFeature featrue, String str) {
        super(featrue);
        this.a = str;
        this.c = new l(this, getContext());
        setContentView(this.c);
        UmengManager.get().onEvent("V2_STORE_BOOK_DETAILPAGE_ACTION", "RevisionHistory");
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            a(0);
        }
    }

    private void a(int i) {
        a.a().a(this.a, i, 10, new k(this));
    }
}
