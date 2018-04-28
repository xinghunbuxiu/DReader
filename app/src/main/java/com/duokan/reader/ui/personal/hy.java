package com.duokan.reader.ui.personal;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.ee;
import com.duokan.reader.ui.bookshelf.hv;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class hy extends oa {
    /* renamed from: a */
    private final Context f8683a;
    /* renamed from: l */
    private final Calendar f8684l;
    /* renamed from: m */
    private final LinkedList<ReadBook> f8685m = new LinkedList();
    /* renamed from: n */
    private final LinkedList<List<ReadBook>> f8686n = new LinkedList();
    /* renamed from: o */
    private final LinearLayout f8687o;
    /* renamed from: p */
    private final View f8688p;
    /* renamed from: q */
    private final TextView f8689q;
    /* renamed from: r */
    private final nc f8690r;
    /* renamed from: s */
    private final ReaderFeature f8691s;
    /* renamed from: t */
    private final C1401if f8692t;
    /* renamed from: u */
    private boolean f8693u;

    public hy(Context context, nc ncVar, hv hvVar) {
        super(context, hvVar);
        this.f8683a = context;
        this.f8684l = Calendar.getInstance();
        this.f8684l.set(2015, 6, 1);
        this.f8693u = false;
        this.f8691s = (ReaderFeature) AppContext.getAppContext(context).queryFeature(ReaderFeature.class);
        this.f8690r = ncVar;
        this.b.setTitleTextColor(getResources().getColor(C0252d.general__shared__ffffff));
        this.b.setBackgroundColor(getResources().getColor(C0252d.general__shared__1b314a));
        this.b.setBottomLineHeight(0);
        this.b.setDarkTitle(false);
        this.c.setVisibility(8);
        this.f8687o = (LinearLayout) LayoutInflater.from(context).inflate(C0256h.personal__readed_books_view, null);
        this.f8688p = this.f8687o.findViewById(C0255g.personal__readed_books_view__sync);
        this.f8688p.setClickable(true);
        this.f8687o.findViewById(C0255g.personal__readed_books_view__sync_switcher).setOnClickListener(new ia(this, new Handler(new hz(this))));
        this.f8689q = (TextView) this.f8687o.findViewById(C0255g.personal__readed_books_view__ranking_total);
        this.f8692t = new C1401if();
        this.f.setHatBodyView(this.f8687o);
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(C0252d.general__shared__1b314a));
        this.f.setHatBackgroundView(view);
        setAdapter(this.f8692t);
    }

    /* renamed from: d */
    private void m11966d() {
        this.f8688p.setVisibility(!PersonalPrefs.m5175a().m5250z() ? 0 : 8);
    }

    /* renamed from: a */
    public void mo1924a(int i, int i2) {
        long j;
        DkUserReadBookManager a = DkUserReadBookManager.m5115a();
        ee ibVar = new ib(this, i);
        if (i == 0) {
            j = 0;
        } else {
            j = (((ReadBook) this.f8685m.getLast()).getReadTime().getTimeInMillis() / 1000) - 1;
        }
        a.m5131a(true, ibVar, j, i2);
    }

    /* renamed from: g */
    private void m11970g() {
        this.f8686n.clear();
        if (!this.f8685m.isEmpty()) {
            Calendar readTime = ((ReadBook) this.f8685m.getFirst()).getReadTime();
            int i = 0;
            while (i < this.f8685m.size()) {
                if (this.f8686n.isEmpty() || !(readTime.before(this.f8684l) || (readTime.get(1) == ((ReadBook) this.f8685m.get(i)).getReadTime().get(1) && readTime.get(2) == ((ReadBook) this.f8685m.get(i)).getReadTime().get(2)))) {
                    List linkedList = new LinkedList();
                    this.f8686n.add(linkedList);
                    linkedList.add(this.f8685m.get(i));
                    readTime = ((ReadBook) this.f8685m.get(i)).getReadTime();
                } else {
                    ((List) this.f8686n.getLast()).add(this.f8685m.get(i));
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    public void m11977a(Runnable runnable) {
        this.f8690r.mo1904a(getContext(), new id(this, runnable));
    }

    public List<Object> getSelectedItems() {
        return this.f8692t.m9788j();
    }

    /* renamed from: a */
    public void m11978a(ArrayList<ReadBook> arrayList) {
        m11977a(new ie(this, arrayList));
    }

    /* renamed from: a */
    public void mo1891a() {
        super.mo1891a();
        this.f8687o.setEnabled(false);
        if (!m11530k()) {
            this.f.setPullDownRefreshEnabled(false);
        }
    }

    /* renamed from: b */
    public void mo1892b() {
        super.mo1892b();
        this.f8687o.setEnabled(true);
        if (!m11530k()) {
            this.f.setPullDownRefreshEnabled(true);
        }
    }
}
