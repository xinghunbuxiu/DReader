package com.duokan.reader.ui.general;

import android.view.LayoutInflater;

import com.duokan.b.g;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;

import java.util.ArrayList;

public class ja extends ActivatedController {
    private final ik a = new jb(this, getContext());
    private final ArrayList b = new ArrayList();
    private int c = -1;

    public ja(IFeature featrue) {
        super(featrue);
        LayoutInflater.from(getContext()).inflate(g.surfing__surfing_base_view__back, this.a.getLeftLayout(), true).setOnClickListener(new jc(this));
        this.a.setOnCurrentPageChangedListener(new jd(this));
        setContentView(this.a);
    }

    protected boolean a() {
        return true;
    }

    public void a(ActivatedController activatedControllerVar, String str) {
        this.b.add(activatedControllerVar);
        addSubController(activatedControllerVar);
        this.a.a(str, activatedControllerVar.getContentView());
    }

    public void a(int i) {
        this.c = Math.min(i, this.b.size() - 1);
        if (this.c >= 0) {
            this.a.a(this.c);
            activate((ActivatedController) this.b.get(this.c));
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && this.c < 0 && this.b.size() > 0) {
            a(0);
        }
    }
}
