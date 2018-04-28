package com.duokan.reader.ui.bookshelf;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ag;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.p052a.C1317a;
import java.util.LinkedList;
import java.util.List;

public class ao extends ActivatedController implements da, db {
    /* renamed from: a */
    private final cz f6121a = ((cz) getContext().queryFeature(cz.class));
    /* renamed from: b */
    private final cw f6122b = ((cw) getContext().queryFeature(cw.class));
    /* renamed from: c */
    private final ViewGroup f6123c;
    /* renamed from: d */
    private final HeaderView f6124d;
    /* renamed from: e */
    private final ViewGroup f6125e;
    /* renamed from: f */
    private final LinearLayout f6126f;
    /* renamed from: g */
    private final View f6127g;
    /* renamed from: h */
    private final TextView f6128h;
    /* renamed from: i */
    private final TextView f6129i;
    /* renamed from: j */
    private final TextView f6130j;
    /* renamed from: k */
    private final TextView f6131k;
    /* renamed from: l */
    private final TextView f6132l;
    /* renamed from: m */
    private final TextView f6133m;
    /* renamed from: n */
    private final TextView f6134n;
    /* renamed from: o */
    private ek f6135o = null;
    /* renamed from: p */
    private boolean f6136p = false;
    /* renamed from: q */
    private boolean f6137q;
    /* renamed from: r */
    private boolean f6138r = true;

    public ao(IFeature mFeature) {
        super(mFeature);
        this.f6137q = this.f6121a.mo1660d() != null;
        setContentView(C0256h.bookshelf__book_manager_view);
        this.f6123c = (ViewGroup) getContentView();
        this.f6124d = (HeaderView) findViewById(C0255g.bookshelf__book_manager_view__header);
        this.f6124d.setHasBackButton(false);
        this.f6124d.m10144a(getString(C0258j.general__shared__cancel)).setOnClickListener(new ap(this));
        this.f6128h = this.f6124d.m10148b(getString(C0258j.general__shared__select_all));
        this.f6128h.setOnClickListener(new aw(this));
        this.f6125e = (ViewGroup) findViewById(C0255g.bookshelf__book_manager_view__footer);
        this.f6126f = (LinearLayout) findViewById(C0255g.bookshelf__book_manager_view__footer_buttons);
        this.f6127g = findViewById(C0255g.bookshelf__book_manager_view__line);
        this.f6129i = (TextView) findViewById(C0255g.bookshelf__book_manager_view__share);
        this.f6129i.setOnClickListener(new ax(this));
        this.f6130j = (TextView) findViewById(C0255g.bookshelf__book_manager_view__download);
        this.f6130j.setOnClickListener(new ay(this));
        this.f6131k = (TextView) findViewById(C0255g.bookshelf__book_manager_view__upload);
        this.f6131k.setOnClickListener(new az(this));
        this.f6132l = (TextView) findViewById(C0255g.bookshelf__book_manager_view__clear);
        this.f6132l.setOnClickListener(new ba(this));
        this.f6133m = (TextView) findViewById(C0255g.bookshelf__book_manager_view__move);
        this.f6133m.setOnClickListener(new bb(this));
        this.f6134n = (TextView) findViewById(C0255g.bookshelf__book_manager_view__delete);
        this.f6134n.setOnClickListener(new bc(this));
        this.f6124d.setCenterTitle(getString(C0258j.bookshelf__shared__select_books));
        this.f6138r = m9158h().m3767h();
        m9156g();
    }

    /* renamed from: a */
    public void m9174a() {
        this.f6137q = true;
        this.f6138r = true;
        m9145a(m9158h());
    }

    /* renamed from: b */
    public void m9177b() {
        this.f6137q = false;
        m9145a(ai.m3980a().m3937l());
    }

    /* renamed from: a */
    public void mo1628a(cz czVar, boolean z) {
    }

    /* renamed from: a */
    public void mo1627a(cz czVar, List<an> list) {
        m9156g();
    }

    /* renamed from: b */
    public void mo1629b(cz czVar, List<an> list) {
        m9156g();
    }

    /* renamed from: c */
    public void mo1630c() {
        m9173s();
    }

    /* renamed from: d */
    public void mo1631d() {
        m9172r();
    }

    protected void onActive(boolean z) {
        m9170p();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f6121a.mo1645a((db) this);
        this.f6121a.mo1644a((da) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f6121a.mo1653b((db) this);
        this.f6121a.mo1652b((da) this);
        this.f6121a.mo1655b((an[]) this.f6121a.mo1658c().toArray(new an[0]));
        m9169o();
    }

    protected boolean onBack() {
        if (this.f6135o != null) {
            m9169o();
            return true;
        } else if (this.f6137q && this.f6138r) {
            return false;
        } else {
            if (!this.f6136p) {
                return super.onBack();
            }
            m9171q();
            return true;
        }
    }

    /* renamed from: g */
    private void m9156g() {
        this.f6130j.setEnabled(false);
        this.f6130j.setVisibility(0);
        this.f6129i.setVisibility(0);
        this.f6131k.setVisibility(8);
        this.f6132l.setVisibility(8);
        this.f6133m.setEnabled(false);
        this.f6134n.setEnabled(false);
        this.f6129i.setEnabled(false);
        m9147a(this.f6137q);
        if (this.f6121a.mo1641a() > 0) {
            this.f6133m.setEnabled(true);
            this.f6134n.setEnabled(true);
            this.f6124d.setCenterTitle(String.format(getString(C0258j.bookshelf__shared__d_books_selected), new Object[]{Integer.valueOf(this.f6121a.mo1641a())}));
            for (an anVar : this.f6121a.mo1658c()) {
                if ((anVar instanceof C0800c) && ((C0800c) anVar).m4168U()) {
                    this.f6130j.setEnabled(true);
                    break;
                }
            }
            if (!this.f6130j.isEnabled()) {
                for (an anVar2 : this.f6121a.mo1658c()) {
                    if (anVar2 instanceof C0800c) {
                        C0800c c0800c = (C0800c) anVar2;
                        if (!c0800c.ak() && c0800c.am() == null) {
                            this.f6130j.setVisibility(8);
                            if (C0709k.m3476a().m3507c()) {
                                this.f6131k.setVisibility(0);
                            } else {
                                this.f6131k.setVisibility(8);
                            }
                            if (this.f6131k.getVisibility() == 8) {
                                for (an anVar22 : this.f6121a.mo1658c()) {
                                    if (!(anVar22 instanceof C0800c) && ((C0800c) anVar22).ae()) {
                                        this.f6130j.setVisibility(8);
                                        this.f6132l.setVisibility(0);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.f6131k.getVisibility() == 8) {
                    for (an anVar222 : this.f6121a.mo1658c()) {
                        if (!(anVar222 instanceof C0800c)) {
                        }
                    }
                }
            }
            this.f6129i.setEnabled(true);
            for (an anVar2222 : this.f6121a.mo1658c()) {
                if ((anVar2222 instanceof C0800c) && !((C0800c) anVar2222).ak()) {
                    this.f6129i.setVisibility(8);
                    break;
                }
            }
        } else {
            this.f6124d.setCenterTitle(getString(C0258j.bookshelf__shared__select_books));
        }
        m9145a(m9158h());
    }

    /* renamed from: a */
    private void m9147a(boolean z) {
        if (z) {
            this.f6124d.setBackgroundColor(0);
            this.f6125e.setBackgroundColor(0);
            this.f6126f.setShowDividers(0);
            this.f6127g.setVisibility(4);
            this.f6124d.setBottomLineColor(0);
            return;
        }
        this.f6124d.setBackgroundColor(-1);
        this.f6125e.setBackgroundColor(-1);
        this.f6126f.setShowDividers(2);
        this.f6127g.setVisibility(0);
        this.f6124d.setBottomLineColor(Color.parseColor("#cccccc"));
    }

    /* renamed from: a */
    private void m9145a(aa aaVar) {
        if (m9151b(aaVar)) {
            this.f6128h.setText(C0258j.general__shared__select_none);
        } else {
            this.f6128h.setText(C0258j.general__shared__select_all);
        }
    }

    /* renamed from: h */
    private aa m9158h() {
        return this.f6121a.mo1660d() == null ? ai.m3980a().m3937l() : this.f6121a.mo1660d();
    }

    /* renamed from: b */
    private boolean m9151b(aa aaVar) {
        int size = this.f6122b.m9434a(aaVar).size();
        return size == this.f6121a.mo1642a(aaVar) && size != 0;
    }

    /* renamed from: i */
    private void m9160i() {
        LinkedList linkedList = new LinkedList();
        for (an anVar : this.f6121a.mo1658c()) {
            if (anVar instanceof C0800c) {
                linkedList.add((C0800c) anVar);
            }
        }
        this.f6121a.mo1650a((C0800c[]) linkedList.toArray(new C0800c[0]));
        requestDetach();
    }

    /* renamed from: j */
    private void m9162j() {
        LinkedList linkedList = new LinkedList();
        for (an anVar : this.f6121a.mo1658c()) {
            if (anVar instanceof C0800c) {
                linkedList.add((C0800c) anVar);
            }
        }
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).downloadBooks((C0800c[]) linkedList.toArray(new C0800c[0]));
        requestDetach();
    }

    /* renamed from: k */
    private void m9164k() {
        LinkedList linkedList = new LinkedList();
        for (an anVar : this.f6121a.mo1658c()) {
            if (anVar instanceof C0800c) {
                linkedList.add((C0800c) anVar);
            }
        }
        C0709k.m3476a().m3495a(new bd(this, linkedList));
        requestDetach();
    }

    /* renamed from: l */
    private void m9166l() {
        m9144a(new aq(this));
    }

    /* renamed from: m */
    private void m9167m() {
        List linkedList = new LinkedList();
        for (an anVar : this.f6121a.mo1658c()) {
            if (anVar instanceof C0800c) {
                linkedList.add((C0800c) anVar);
            }
        }
        this.f6121a.mo1654b(linkedList, new ar(this), null);
    }

    /* renamed from: n */
    private void m9168n() {
        List linkedList = new LinkedList();
        for (an anVar : this.f6121a.mo1658c()) {
            if (anVar instanceof C0800c) {
                linkedList.add((C0800c) anVar);
            }
        }
        this.f6121a.mo1648a(linkedList, new as(this), null);
    }

    /* renamed from: a */
    private void m9144a(ag<aa> agVar) {
        if (this.f6135o == null) {
            this.f6135o = new ek(getContext(), new at(this, agVar));
            this.f6123c.addView(this.f6135o, new LayoutParams(-1, -1));
        }
    }

    /* renamed from: o */
    private void m9169o() {
        if (this.f6135o != null) {
            this.f6123c.removeView(this.f6135o);
            this.f6135o = null;
        }
    }

    /* renamed from: p */
    private void m9170p() {
        C1317a.m10195a(this.f6124d, 1, 0.0f, 0.0f, -1.0f, 0.0f, 300, Boolean.valueOf(true), null);
        C1317a.m10195a(this.f6125e, 1, 0.0f, 0.0f, 1.0f, 0.0f, 300, Boolean.valueOf(true), new au(this));
    }

    /* renamed from: q */
    private void m9171q() {
        C1317a.m10195a(this.f6124d, 1, 0.0f, 0.0f, 0.0f, -1.0f, 300, Boolean.valueOf(true), new av(this));
        C1317a.m10195a(this.f6125e, 1, 0.0f, 0.0f, 0.0f, 1.0f, 300, Boolean.valueOf(true), null);
    }

    /* renamed from: r */
    private void m9172r() {
        if (this.f6136p) {
            C1317a.m10195a(this.f6125e, 1, 0.0f, 0.0f, 1.0f, 0.0f, 300, Boolean.valueOf(true), null);
        }
    }

    /* renamed from: s */
    private void m9173s() {
        if (this.f6136p) {
            C1317a.m10195a(this.f6125e, 1, 0.0f, 0.0f, 0.0f, 1.0f, 300, Boolean.valueOf(true), null);
        }
    }

    /* renamed from: e */
    public void m9181e() {
        m9147a(true);
    }

    /* renamed from: f */
    public void m9182f() {
        m9147a(false);
    }
}
