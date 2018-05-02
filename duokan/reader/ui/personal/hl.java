package com.duokan.reader.ui.personal;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.ev;
import com.duokan.reader.ui.bookshelf.ho;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class hl extends nm {
    private final Context a;
    private final Calendar k;
    private final LinkedList l = new LinkedList();
    private final LinkedList m = new LinkedList();
    private final LinearLayout n;
    private final View o;
    private final TextView p;
    private final mo q;
    private final ReaderFeature r;
    private final hs s;
    private boolean t;

    public hl(Context context, mo moVar, ho hoVar) {
        super(context, hoVar);
        this.a = context;
        this.k = Calendar.getInstance();
        this.k.set(2015, 6, 1);
        this.t = false;
        this.r = (ReaderFeature) MyContextWrapper.getFeature(context).queryFeature(ReaderFeature.class);
        this.q = moVar;
        this.b.setTitleTextColor(getResources().getColor(d.general__shared__ffffff));
        this.b.setBackgroundColor(getResources().getColor(d.general__shared__1b314a));
        this.b.setBottomLineHeight(0);
        this.b.setDarkTitle(false);
        this.c.setVisibility(8);
        this.n = (LinearLayout) LayoutInflater.from(context).inflate(h.personal__readed_books_view, null);
        this.o = this.n.findViewById(g.personal__readed_books_view__sync);
        this.o.setClickable(true);
        this.n.findViewById(g.personal__readed_books_view__sync_switcher).setOnClickListener(new hn(this, new Handler(new hm(this))));
        this.p = (TextView) this.n.findViewById(g.personal__readed_books_view__ranking_total);
        this.s = new hs();
        this.e.setHatBodyView(this.n);
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(d.general__shared__1b314a));
        this.e.setHatBackgroundView(view);
        setAdapter(this.s);
    }

    private void d() {
        this.o.setVisibility(!PersonalPrefs.a().y() ? 0 : 8);
    }

    public void a(int i, int i2) {
        long j;
        DkUserReadBookManager a = DkUserReadBookManager.a();
        ev hoVar = new ho(this, i);
        if (i == 0) {
            j = 0;
        } else {
            j = (((ReadBook) this.l.getLast()).getReadTime().getTimeInMillis() / 1000) - 1;
        }
        a.a(true, hoVar, j, i2);
    }

    private void g() {
        this.m.clear();
        if (!this.l.isEmpty()) {
            Calendar readTime = ((ReadBook) this.l.getFirst()).getReadTime();
            int i = 0;
            while (i < this.l.size()) {
                if (this.m.isEmpty() || !(r2.before(this.k) || (r2.get(1) == ((ReadBook) this.l.get(i)).getReadTime().get(1) && r2.get(2) == ((ReadBook) this.l.get(i)).getReadTime().get(2)))) {
                    List linkedList = new LinkedList();
                    this.m.add(linkedList);
                    linkedList.add(this.l.get(i));
                    readTime = ((ReadBook) this.l.get(i)).getReadTime();
                } else {
                    ((List) this.m.getLast()).add(this.l.get(i));
                }
                i++;
            }
        }
    }

    public void a(Runnable runnable) {
        this.q.a(getContext(), new hq(this, runnable));
    }

    public List getSelectedItems() {
        return this.s.j();
    }

    public void a(ArrayList arrayList) {
        a(new hr(this, arrayList));
    }

    public void a() {
        super.a();
        this.n.setEnabled(false);
        if (!k()) {
            this.e.setPullDownRefreshEnabled(false);
        }
    }

    public void b() {
        super.b();
        this.n.setEnabled(true);
        if (!k()) {
            this.e.setPullDownRefreshEnabled(true);
        }
    }
}
