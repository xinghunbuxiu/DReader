package com.duokan.reader.ui.general;

import android.view.LayoutInflater;

import com.duokan.b.g;
import com.duokan.core.app.e;
import com.duokan.core.app.y;

import java.util.ArrayList;

public class ja extends e {
    private final ik a = new jb(this, getContext());
    private final ArrayList b = new ArrayList();
    private int c = -1;

    public ja(y yVar) {
        super(yVar);
        LayoutInflater.from(getContext()).inflate(g.surfing__surfing_base_view__back, this.a.getLeftLayout(), true).setOnClickListener(new jc(this));
        this.a.setOnCurrentPageChangedListener(new jd(this));
        setContentView(this.a);
    }

    protected boolean a() {
        return true;
    }

    public void a(e eVar, String str) {
        this.b.add(eVar);
        addSubController(eVar);
        this.a.a(str, eVar.getContentView());
    }

    public void a(int i) {
        this.c = Math.min(i, this.b.size() - 1);
        if (this.c >= 0) {
            this.a.a(this.c);
            activate((e) this.b.get(this.c));
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && this.c < 0 && this.b.size() > 0) {
            a(0);
        }
    }
}
