package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.j;
import com.duokan.core.sys.t;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.gi;

import java.util.Iterator;
import java.util.LinkedList;

class ww implements OnPreDrawListener {
    protected LinkedList b;
    final /* synthetic */ wl c;

    private ww(wl wlVar) {
        this.c = wlVar;
        this.b = new LinkedList();
    }

    public boolean a() {
        return this.b.isEmpty();
    }

    public void a(Runnable runnable) {
        t.a(new wx(this, runnable));
    }

    public boolean onPreDraw() {
        if (!a()) {
            t.b(new wz(this));
        }
        return true;
    }

    protected void b(boolean z) {
        a.c().b(t.a());
        try {
            if (this.b.isEmpty()) {
                if (!this.b.isEmpty()) {
                    j.a(new xa(this));
                }
            } else if (!this.c.a.J()) {
            } else {
                if (this.c.a.getDocument().b()) {
                    this.b.clear();
                    if (!this.b.isEmpty()) {
                        j.a(new xa(this));
                    }
                } else if (!this.c.a.getDocument().i()) {
                    PagesView showingPagesView = this.c.getShowingPagesView();
                    gi currentPagePresenter = showingPagesView.getCurrentPagePresenter();
                    View[] pageViews = showingPagesView.getPageViews();
                    int i = 0;
                    while (i < pageViews.length) {
                        View view = (gs) pageViews[i];
                        as pageDrawable = view.getPageDrawable();
                        if (currentPagePresenter == null || currentPagePresenter.d() != view || z || !pageDrawable.C()) {
                            if (pageDrawable != null) {
                                if (!(pageDrawable.F() || pageDrawable.G())) {
                                    if (!this.b.isEmpty()) {
                                        j.a(new xa(this));
                                        return;
                                    }
                                    return;
                                }
                            }
                            i++;
                        } else if (!this.b.isEmpty()) {
                            j.a(new xa(this));
                            return;
                        } else {
                            return;
                        }
                    }
                    if (showingPagesView.getScrollState() == ScrollState.IDLE) {
                        a(z);
                        if (!this.b.isEmpty()) {
                            j.a(new xa(this));
                        }
                    } else if (!this.b.isEmpty()) {
                        j.a(new xa(this));
                    }
                } else if (!this.b.isEmpty()) {
                    j.a(new xa(this));
                }
            }
        } finally {
            if (!this.b.isEmpty()) {
                j.a(new xa(this));
            }
        }
    }

    protected void a(boolean z) {
        LinkedList linkedList = this.b;
        this.b = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
