package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.sys.ah;
import com.duokan.reader.ui.bookshelf.ho;

import java.util.ArrayList;
import java.util.List;

public class e extends nm {
    private final j a;
    private final List k = new ArrayList();
    private final View l;

    public e(Context context, ho hoVar) {
        super(context, hoVar);
        this.b.setLeftTitle(getResources().getString(j.personal__personal_settings_view__auto_buy));
        this.c.setVisibility(8);
        this.e.setOnItemClickListener(new f(this));
        this.a = new j();
        setAdapter(this.a);
        this.l = LayoutInflater.from(getContext()).inflate(h.personal__auto_buy_group_title_view, this.e, false);
        this.e.setHatBodyView(this.l);
        this.l.setVisibility(8);
    }

    public void e_() {
        this.e.setPullDownRefreshEnabled(false);
        ah.b(new h(this));
    }

    public List getSelectedItems() {
        return this.a.j();
    }

    public void a(List list) {
        this.k.removeAll(list);
        a(false);
    }

    public void a(boolean z) {
        this.l.setVisibility(this.k.isEmpty() ? 8 : 0);
        super.a(z);
    }
}
