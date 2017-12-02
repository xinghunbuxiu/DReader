package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.general.cc;
import com.duokan.reader.ui.general.expandable.ViewMode;

class ce extends gw {
    final /* synthetic */ cd a;

    ce(cd cdVar) {
        this.a = cdVar;
    }

    protected void b() {
        this.a.a.clear();
    }

    protected void e(int i) {
        this.a.a(i, false);
    }

    protected boolean e() {
        this.a.a(this.a.a.size() + 1, true);
        return true;
    }

    public int c() {
        return this.a.a.size();
    }

    public Object d(int i) {
        return this.a.a.get(i);
    }

    protected int k() {
        return 1;
    }

    protected int f(int i) {
        return c();
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        y a = x.a(this.a.getContext());
        k kVar = (k) this.a.a.get(i);
        View a2 = new bf(a, kVar, view, viewGroup).a();
        CheckBox checkBox = (CheckBox) a2.findViewById(g.personal__feed_message_item_view__checkbox);
        if (f() == ViewMode.Edit) {
            checkBox.setVisibility(0);
            checkBox.setChecked(b(0, i));
        } else {
            checkBox.setVisibility(8);
        }
        a2.setOnClickListener(new cf(this, i, kVar, a));
        a2.setOnLongClickListener(new cg(this, i));
        return a2;
    }

    public View a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc(this.a.getContext());
        ccVar.a(f.personal__no_message_icon);
        ccVar.b(j.personal__message_empty_view__no_message);
        ccVar.c(j.personal__message_empty_view__no_message_description);
        return ccVar.a();
    }
}
