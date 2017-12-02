package com.duokan.reader.ui.personal;

import android.widget.CheckBox;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.hk;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.be;

import java.util.HashSet;
import java.util.Set;

public class ng extends e {
    private final CheckBox a;
    private final CheckBox b;
    private final CheckBox c;
    private final CheckBox d;
    private final Set e = new HashSet();

    public ng(x xVar) {
        super(xVar);
        setContentView(h.personal__user_type_view);
        ((PageHeaderView) findViewById(g.personal__user_type_view__header)).setCenterTitle(j.personal__user_type_view__header);
        this.a = (CheckBox) findViewById(g.personal__user_type_view__pub_checkbox);
        this.b = (CheckBox) findViewById(g.personal__user_type_view__male_checkbox);
        this.c = (CheckBox) findViewById(g.personal__user_type_view__female_checkbox);
        this.d = (CheckBox) findViewById(g.personal__user_type_view__comic_checkbox);
        findViewById(g.personal__user_type_view__pub).setOnClickListener(new nh(this));
        findViewById(g.personal__user_type_view__male).setOnClickListener(new ni(this));
        findViewById(g.personal__user_type_view__female).setOnClickListener(new nj(this));
        findViewById(g.personal__user_type_view__comic).setOnClickListener(new nk(this));
        findViewById(g.personal__user_type_view__go_to_store).setOnClickListener(new nl(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            if (PersonalPrefs.a().c() == null) {
                int b = PersonalPrefs.a().b();
                if (b > 0) {
                    PersonalPrefs.a().a(b);
                } else {
                    PersonalPrefs.a().h();
                }
            }
            if (PersonalPrefs.a().c() == null) {
                PersonalPrefs.a().a(this.e, true);
            } else {
                this.e.clear();
                this.e.addAll(PersonalPrefs.a().c());
            }
            a();
        }
    }

    protected boolean onBack() {
        if (b()) {
            return super.onBack();
        }
        return true;
    }

    private void a(String str, boolean z) {
        if (z) {
            this.e.remove(str);
        } else {
            this.e.add(str);
        }
    }

    private void a() {
        if (this.e.contains(hk.a)) {
            this.a.setChecked(false);
        } else {
            this.a.setChecked(true);
        }
        if (this.e.contains(hk.b)) {
            this.b.setChecked(false);
        } else {
            this.b.setChecked(true);
        }
        if (this.e.contains(hk.c)) {
            this.c.setChecked(false);
        } else {
            this.c.setChecked(true);
        }
        if (this.e.contains(hk.d)) {
            this.d.setChecked(false);
        } else {
            this.d.setChecked(true);
        }
    }

    private boolean b() {
        if (this.e.size() == 4) {
            be.a(getContext(), (CharSequence) "您还没有选择偏好", 0).show();
            return false;
        }
        PersonalPrefs.a().a(this.e, true);
        return true;
    }
}
