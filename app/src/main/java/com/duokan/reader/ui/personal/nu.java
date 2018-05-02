package com.duokan.reader.ui.personal;

import android.widget.CheckBox;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gq;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.be;
import java.util.HashSet;
import java.util.Set;

public class nu extends ActivatedController {
    /* renamed from: a */
    private final CheckBox f9019a;
    /* renamed from: b */
    private final CheckBox f9020b;
    /* renamed from: c */
    private final CheckBox f9021c;
    /* renamed from: d */
    private final CheckBox f9022d;
    /* renamed from: e */
    private final Set<String> f9023e = new HashSet();

    public nu(AppContext appContext) {
        super(appContext);
        setContentView(C0256h.personal__user_type_view);
        ((PageHeaderView) findViewById(C0255g.personal__user_type_view__header)).setCenterTitle(C0258j.personal__user_type_view__header);
        this.f9019a = (CheckBox) findViewById(C0255g.personal__user_type_view__pub_checkbox);
        this.f9020b = (CheckBox) findViewById(C0255g.personal__user_type_view__male_checkbox);
        this.f9021c = (CheckBox) findViewById(C0255g.personal__user_type_view__female_checkbox);
        this.f9022d = (CheckBox) findViewById(C0255g.personal__user_type_view__comic_checkbox);
        findViewById(C0255g.personal__user_type_view__pub).setOnClickListener(new nv(this));
        findViewById(C0255g.personal__user_type_view__male).setOnClickListener(new nw(this));
        findViewById(C0255g.personal__user_type_view__female).setOnClickListener(new nx(this));
        findViewById(C0255g.personal__user_type_view__comic).setOnClickListener(new ny(this));
        findViewById(C0255g.personal__user_type_view__go_to_store).setOnClickListener(new nz(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            if (PersonalPrefs.m5175a().m5219c() == null) {
                int b = PersonalPrefs.m5175a().m5210b();
                if (b > 0) {
                    PersonalPrefs.m5175a().m5198a(b);
                } else {
                    PersonalPrefs.m5175a().m5231h();
                }
            }
            if (PersonalPrefs.m5175a().m5219c() == null) {
                PersonalPrefs.m5175a().m5207a(this.f9023e, true);
            } else {
                this.f9023e.clear();
                this.f9023e.addAll(PersonalPrefs.m5175a().m5219c());
            }
            m12365a();
        }
    }

    protected boolean onBack() {
        if (m12369b()) {
            return super.onBack();
        }
        return true;
    }

    /* renamed from: a */
    private void m12367a(String str, boolean z) {
        if (z) {
            this.f9023e.remove(str);
        } else {
            this.f9023e.add(str);
        }
    }

    /* renamed from: a */
    private void m12365a() {
        if (this.f9023e.contains(gq.f4062a)) {
            this.f9019a.setChecked(false);
        } else {
            this.f9019a.setChecked(true);
        }
        if (this.f9023e.contains(gq.f4063b)) {
            this.f9020b.setChecked(false);
        } else {
            this.f9020b.setChecked(true);
        }
        if (this.f9023e.contains(gq.f4064c)) {
            this.f9021c.setChecked(false);
        } else {
            this.f9021c.setChecked(true);
        }
        if (this.f9023e.contains(gq.f4065d)) {
            this.f9022d.setChecked(false);
        } else {
            this.f9022d.setChecked(true);
        }
    }

    /* renamed from: b */
    private boolean m12369b() {
        if (this.f9023e.size() == 4) {
            be.m10287a(getContext(), (CharSequence) "您还没有选择偏好", 0).show();
            return false;
        }
        PersonalPrefs.m5175a().m5207a(this.f9023e, true);
        return true;
    }
}
