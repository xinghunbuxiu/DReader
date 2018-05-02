package com.duokan.reader.ui.bookshelf;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.ag;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.HeaderView;

import java.util.LinkedList;
import java.util.List;

public class ai extends ActivatedController implements cv, cw {
    private final cu a = ((cu) getContext().queryFeature(cu.class));
    private final cr b = ((cr) getContext().queryFeature(cr.class));
    private final ViewGroup c;
    private final HeaderView d;
    private final ViewGroup e;
    private final LinearLayout f;
    private final View g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final TextView n;
    private ec o = null;
    private boolean p = false;
    private boolean q;
    private boolean r = true;

    public ai(IFeature featrue) {
        super(featrue);
        this.q = this.a.d() != null;
        setContentView(h.bookshelf__book_manager_view);
        this.c = (ViewGroup) getContentView();
        this.d = (HeaderView) findViewById(g.bookshelf__book_manager_view__header);
        this.d.setHasBackButton(false);
        this.d.a(getString(j.general__shared__cancel)).setOnClickListener(new aj(this));
        this.h = this.d.b(getString(j.general__shared__select_all));
        this.h.setOnClickListener(new aq(this));
        this.e = (ViewGroup) findViewById(g.bookshelf__book_manager_view__footer);
        this.f = (LinearLayout) findViewById(g.bookshelf__book_manager_view__footer_buttons);
        this.g = findViewById(g.bookshelf__book_manager_view__line);
        this.i = (TextView) findViewById(g.bookshelf__book_manager_view__share);
        this.i.setOnClickListener(new ar(this));
        this.j = (TextView) findViewById(g.bookshelf__book_manager_view__download);
        this.j.setOnClickListener(new as(this));
        this.k = (TextView) findViewById(g.bookshelf__book_manager_view__upload);
        this.k.setOnClickListener(new at(this));
        this.l = (TextView) findViewById(g.bookshelf__book_manager_view__clear);
        this.l.setOnClickListener(new au(this));
        this.m = (TextView) findViewById(g.bookshelf__book_manager_view__move);
        this.m.setOnClickListener(new av(this));
        this.n = (TextView) findViewById(g.bookshelf__book_manager_view__delete);
        this.n.setOnClickListener(new aw(this));
        this.d.setCenterTitle(getString(j.bookshelf__shared__select_books));
        this.r = h().h();
        g();
    }

    public void a() {
        this.q = true;
        this.r = true;
        a(h());
    }

    public void b() {
        this.q = false;
        a(com.duokan.reader.domain.bookshelf.ai.a().l());
    }

    public void a(cu cuVar, boolean z) {
    }

    public void a(cu cuVar, List list) {
        g();
    }

    public void b(cu cuVar, List list) {
        g();
    }

    public void c() {
        s();
    }

    public void d() {
        r();
    }

    protected void onActive(boolean z) {
        p();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.a.a((cw) this);
        this.a.a((cv) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.a.b((cw) this);
        this.a.b((cv) this);
        this.a.b((an[]) this.a.c().toArray(new an[0]));
        o();
    }

    protected boolean onBack() {
        if (this.o != null) {
            o();
            return true;
        } else if (this.q && this.r) {
            return false;
        } else {
            if (!this.p) {
                return super.onBack();
            }
            q();
            return true;
        }
    }

    private void g() {
        this.j.setEnabled(false);
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setEnabled(false);
        this.n.setEnabled(false);
        this.i.setEnabled(false);
        a(this.q);
        if (this.a.a() > 0) {
            this.m.setEnabled(true);
            this.n.setEnabled(true);
            this.d.setCenterTitle(String.format(getString(j.bookshelf__shared__d_books_selected), new Object[]{Integer.valueOf(this.a.a())}));
            for (an anVar : this.a.c()) {
                if ((anVar instanceof c) && ((c) anVar).S()) {
                    this.j.setEnabled(true);
                    break;
                }
            }
            if (!this.j.isEnabled()) {
                for (an anVar2 : this.a.c()) {
                    if (anVar2 instanceof c) {
                        c cVar = (c) anVar2;
                        if (!cVar.ai() && cVar.ak() == null) {
                            this.j.setVisibility(8);
                            if (i.f().b()) {
                                this.k.setVisibility(0);
                            } else {
                                this.k.setVisibility(8);
                            }
                            if (this.k.getVisibility() == 8) {
                                for (an anVar22 : this.a.c()) {
                                    if (!(anVar22 instanceof c) && ((c) anVar22).ac()) {
                                        this.j.setVisibility(8);
                                        this.l.setVisibility(0);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.k.getVisibility() == 8) {
                    for (an anVar222 : this.a.c()) {
                        if (!(anVar222 instanceof c)) {
                        }
                    }
                }
            }
            this.i.setEnabled(true);
            for (an anVar2222 : this.a.c()) {
                if ((anVar2222 instanceof c) && !((c) anVar2222).ai()) {
                    this.i.setVisibility(8);
                    break;
                }
            }
        } else {
            this.d.setCenterTitle(getString(j.bookshelf__shared__select_books));
        }
        a(h());
    }

    private void a(boolean z) {
        if (z) {
            this.d.setBackgroundColor(0);
            this.e.setBackgroundColor(0);
            this.f.setShowDividers(0);
            this.g.setVisibility(4);
            this.d.setBottomLineColor(0);
            return;
        }
        this.d.setBackgroundColor(-1);
        this.e.setBackgroundColor(-1);
        this.f.setShowDividers(2);
        this.g.setVisibility(0);
        this.d.setBottomLineColor(Color.parseColor("#cccccc"));
    }

    private void a(aa aaVar) {
        if (b(aaVar)) {
            this.h.setText(j.general__shared__select_none);
        } else {
            this.h.setText(j.general__shared__select_all);
        }
    }

    private aa h() {
        return this.a.d() == null ? com.duokan.reader.domain.bookshelf.ai.a().l() : this.a.d();
    }

    private boolean b(aa aaVar) {
        int size = this.b.a(aaVar).size();
        return size == this.a.a(aaVar) && size != 0;
    }

    private void i() {
        LinkedList linkedList = new LinkedList();
        for (an anVar : this.a.c()) {
            if (anVar instanceof c) {
                linkedList.add((c) anVar);
            }
        }
        this.a.a((c[]) linkedList.toArray(new c[0]));
        requestDetach();
    }

    private void j() {
        LinkedList linkedList = new LinkedList();
        for (an anVar : this.a.c()) {
            if (anVar instanceof c) {
                linkedList.add((c) anVar);
            }
        }
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).downloadBooks((c[]) linkedList.toArray(new c[0]));
        requestDetach();
    }

    private void k() {
        LinkedList linkedList = new LinkedList();
        for (an anVar : this.a.c()) {
            if (anVar instanceof c) {
                linkedList.add((c) anVar);
            }
        }
        i.f().a(new ax(this, linkedList));
        requestDetach();
    }

    private void l() {
        a(new ak(this));
    }

    private void m() {
        List linkedList = new LinkedList();
        for (an anVar : this.a.c()) {
            if (anVar instanceof c) {
                linkedList.add((c) anVar);
            }
        }
        this.a.b(linkedList, new al(this), null);
    }

    private void n() {
        List linkedList = new LinkedList();
        for (an anVar : this.a.c()) {
            if (anVar instanceof c) {
                linkedList.add((c) anVar);
            }
        }
        this.a.a(linkedList, new am(this), null);
    }

    private void a(ag agVar) {
        if (this.o == null) {
            this.o = new ec(getContext(), new an(this, agVar));
            this.c.addView(this.o, new LayoutParams(-1, -1));
        }
    }

    private void o() {
        if (this.o != null) {
            this.c.removeView(this.o);
            this.o = null;
        }
    }

    private void p() {
        a.a(this.d, 1, 0.0f, 0.0f, -1.0f, 0.0f, 300, Boolean.valueOf(true), null);
        a.a(this.e, 1, 0.0f, 0.0f, 1.0f, 0.0f, 300, Boolean.valueOf(true), new ao(this));
    }

    private void q() {
        a.a(this.d, 1, 0.0f, 0.0f, 0.0f, -1.0f, 300, Boolean.valueOf(true), new ap(this));
        a.a(this.e, 1, 0.0f, 0.0f, 0.0f, 1.0f, 300, Boolean.valueOf(true), null);
    }

    private void r() {
        if (this.p) {
            a.a(this.e, 1, 0.0f, 0.0f, 1.0f, 0.0f, 300, Boolean.valueOf(true), null);
        }
    }

    private void s() {
        if (this.p) {
            a.a(this.e, 1, 0.0f, 0.0f, 0.0f, 1.0f, 300, Boolean.valueOf(true), null);
        }
    }

    public void e() {
        a(true);
    }

    public void f() {
        a(false);
    }
}
