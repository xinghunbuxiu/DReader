package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.gc;
import java.util.Iterator;
import java.util.LinkedList;

class xj implements OnPreDrawListener {
    /* renamed from: b */
    protected LinkedList<Runnable> f11144b;
    /* renamed from: c */
    final /* synthetic */ wy f11145c;

    private xj(wy wyVar) {
        this.f11145c = wyVar;
        this.f11144b = new LinkedList();
    }

    /* renamed from: a */
    public boolean m15066a() {
        return this.f11144b.isEmpty();
    }

    /* renamed from: a */
    public void m15064a(Runnable runnable) {
        UThread.runOnThread(new xk(this, runnable));
    }

    public boolean onPreDraw() {
        if (!m15066a()) {
            UThread.post(new xm(this));
        }
        return true;
    }

    /* renamed from: b */
    protected void m15067b(boolean z) {
        C0328a.m757c().m764b(UThread.isCurrentThread());
        try {
            if (this.f11144b.isEmpty()) {
                if (!this.f11144b.isEmpty()) {
                    UIdleHandler.addIdleHandler(new xn(this));
                }
            } else if (this.f11145c.f9698a.getDocument().mo1448b()) {
                this.f11144b.clear();
            } else if (this.f11145c.f9698a.mo1993J()) {
                if (!this.f11145c.f9698a.getDocument().mo1242i()) {
                    PagesView showingPagesView = this.f11145c.getShowingPagesView();
                    gc currentPagePresenter = showingPagesView.getCurrentPagePresenter();
                    View[] pageViews = showingPagesView.getPageViews();
                    int i = 0;
                    while (i < pageViews.length) {
                        View view = (gx) pageViews[i];
                        as pageDrawable = view.getPageDrawable();
                        if (currentPagePresenter == null || currentPagePresenter.mo2328d() != view || z || !pageDrawable.m6098C()) {
                            if (pageDrawable != null) {
                                if (!(pageDrawable.mo1283F() || pageDrawable.mo1284G())) {
                                    if (!this.f11144b.isEmpty()) {
                                        UIdleHandler.addIdleHandler(new xn(this));
                                        return;
                                    }
                                    return;
                                }
                            }
                            i++;
                        } else if (!this.f11144b.isEmpty()) {
                            UIdleHandler.addIdleHandler(new xn(this));
                            return;
                        } else {
                            return;
                        }
                    }
                    if (showingPagesView.getScrollState() == ScrollState.IDLE) {
                        mo2511a(z);
                        if (!this.f11144b.isEmpty()) {
                            UIdleHandler.addIdleHandler(new xn(this));
                        }
                    } else if (!this.f11144b.isEmpty()) {
                        UIdleHandler.addIdleHandler(new xn(this));
                    }
                } else if (!this.f11144b.isEmpty()) {
                    UIdleHandler.addIdleHandler(new xn(this));
                }
            } else if (!this.f11144b.isEmpty()) {
                UIdleHandler.addIdleHandler(new xn(this));
            }
        } finally {
            if (!this.f11144b.isEmpty()) {
                UIdleHandler.addIdleHandler(new xn(this));
            }
        }
    }

    /* renamed from: a */
    protected void mo2511a(boolean z) {
        LinkedList linkedList = this.f11144b;
        this.f11144b = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
