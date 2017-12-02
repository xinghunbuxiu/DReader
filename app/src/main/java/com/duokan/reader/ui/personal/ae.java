package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;

import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ui.general.ik;

public class ae extends my {
    static final /* synthetic */ boolean a = (!ae.class.desiredAssertionStatus());
    private final ik c;
    private final kg d = new kg(getContext());
    private final ds e;

    public ae(y yVar) {
        super(yVar, true);
        addSubController(this.d);
        this.e = new ds(getContext());
        addSubController(this.e);
        this.c = new af(this, getContext());
        this.c.a(getString(j.surfing__shared__purchased), this.d.getContentView());
        this.c.a(getString(j.surfing__shared__cloud), this.e.getContentView());
        LayoutInflater.from(getContext()).inflate(h.surfing__surfing_base_view__back, this.c.getLeftLayout(), true).setOnClickListener(new ag(this));
        this.c.setOnCurrentPageChangedListener(new ah(this));
        setContentView(this.c);
    }

    private e a(int i) {
        switch (i) {
            case 0:
                return this.d;
            case 1:
                return this.e;
            default:
                if (a) {
                    return this.d;
                }
                throw new AssertionError();
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.c.a(0);
            activate(this.d);
        }
    }
}
