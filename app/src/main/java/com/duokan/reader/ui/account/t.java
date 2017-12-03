package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.View;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.hd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t extends hd {
    private final u a = new u(this, getContext());
    private String b;
    private String c;
    private String d;
    private List e;
    private c f;
    private HashMap g;
    private ArrayList h;

    public t(IFeature featrue, c cVar, HashMap hashMap, ArrayList arrayList) {
        super(featrue);
        View view = new View((Context) featrue);
        view.setBackgroundColor(0);
        setContentView(view);
        this.f = cVar;
        this.g = hashMap;
        this.h = arrayList;
    }

    public t(IFeature featrue, List list, String str, String str2, String str3) {
        super(featrue);
        View view = new View((Context) featrue);
        view.setBackgroundColor(0);
        setContentView(view);
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = list;
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (super.onRequestDetach(activatedControllerVar) && getPopupCount() < 1) {
            requestDetach();
        }
        return true;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            showPopup(this.a, true);
        }
    }
}
