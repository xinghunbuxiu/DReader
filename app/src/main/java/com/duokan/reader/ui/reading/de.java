package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.af;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.duokan.CommentBook;
import com.duokan.reader.common.webservices.duokan.a;
import com.duokan.reader.common.webservices.duokan.ag;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.ui.general.DkGeneralFaceView;
import com.duokan.reader.ui.general.LoadingCircleView;
import com.duokan.reader.ui.store.comment.DkCommentScoreView;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TimeZone;

public class de extends FrameLayout {
    private static final LinkedList a = new LinkedList();
    private static af b = new af();
    private final ReaderFeature A;
    private final OnClickListener B;
    private final OnClickListener C = new df(this);
    private final OnClickListener D = new ds(this);
    private final Runnable E = new dy(this);
    private String F = null;
    private DkStoreItemDetail G;
    private boolean H = false;
    private boolean I = false;
    private final HashMap c = new HashMap();
    private final LinearScrollView d;
    private final sh e;
    private final View f;
    private final View g;
    private final TextView h;
    private final TextView i;
    private final DkCommentScoreView j;
    private final TextView k;
    private final EditText l;
    private final View m;
    private final View n;
    private final View o;
    private final TextView p;
    private final View q;
    private final View r;
    private final View s;
    private final LinearLayout t;
    private final View u;
    private final HashMap v = new HashMap();
    private final FrameLayout w;
    private final View x;
    private final c y;
    private final Runnable z;

    public de(Context context) {
        super(context);
        a.add(new WeakReference(this));
        this.A = (ReaderFeature) x.a(getContext()).queryFeature(ReaderFeature.class);
        this.e = (sh) x.a(context).queryFeature(sh.class);
        this.y = this.e.G();
        View inflate = LayoutInflater.from(context).inflate(h.reading__comment_view, null);
        addView(inflate, new LayoutParams(-1, -1));
        this.d = (LinearScrollView) findViewById(g.reading__comment_view__content);
        this.d.setOnScrollListener(new ea(this));
        this.w = new FrameLayout(getContext());
        this.w.setClickable(true);
        this.w.setBackgroundColor(-1);
        this.x = new LoadingCircleView(getContext());
        this.w.addView(this.x, new LayoutParams(-2, -2, 17));
        addView(this.w, new ViewGroup.LayoutParams(-1, -1));
        this.p = (TextView) inflate.findViewById(g.reading__comment_view__submit);
        this.j = (DkCommentScoreView) inflate.findViewById(g.reading__comment_view__score);
        this.j.setScoreChangeListener(new eb(this));
        this.l = (EditText) inflate.findViewById(g.reading__comment_view__comment_edit_text);
        this.k = (TextView) inflate.findViewById(g.reading__comment_view__level);
        this.B = new ec(this);
        this.p.setOnClickListener(this.B);
        this.n = inflate.findViewById(g.reading__comment_view__no_comment);
        this.o = inflate.findViewById(g.reading__comment_view__my_comment);
        this.m = inflate.findViewById(g.reading__comment_view__tip_container);
        this.q = this.m.findViewById(g.reading__comment_view__no_tip);
        this.r = this.m.findViewById(g.reading__comment_view__fans_list);
        this.s = this.m.findViewById(g.reading__comment_view__my_tip);
        this.f = findViewById(g.reading__comment_view__book_title_container);
        this.h = (TextView) findViewById(g.reading__comment_view__book_title);
        this.i = (TextView) findViewById(g.reading__comment_view__book_status);
        this.t = (LinearLayout) findViewById(g.reading__comment_view__related_books_container);
        this.u = findViewById(g.reading__comment_view__view_more);
        this.u.setOnClickListener(new ee(this));
        this.g = findViewById(g.reading__comment_view__off_shelf_book_container);
        findViewById(g.reading__comment_view__share).setOnClickListener(new ef(this));
        findViewById(g.reading__comment_view__back).setOnClickListener(new eg(this));
        this.G = this.e.bl();
        f();
        h();
        if (b.b()) {
            e();
        }
        setWillNotDraw(false);
        this.z = new dh(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t.c(this.z);
        for (String str : this.c.keySet()) {
            a aVar = new a();
            aVar.a = "ending_page_recommendation_v3";
            aVar.c = "exposure";
            aVar.b = getLabelPrefix() + str;
            aVar.e = ((Long) this.c.get(str)).longValue();
            com.duokan.reader.domain.statistics.a.k().a(aVar, false);
        }
        com.duokan.reader.domain.statistics.a.k().a();
        b = new af();
    }

    public void a() {
        if (this.G != null) {
            g();
            return;
        }
        this.G = this.e.bl();
        this.H = true;
        f();
        k();
    }

    public void b() {
        if (this.w.getVisibility() != 0 && this.e.U() != PageAnimationMode.VSCROLL) {
            com.duokan.reader.domain.statistics.a.k().b("ending_page_recommendation_v3", "exposure", getLabelPrefix() + "shown");
            t.c(this.z);
            t.a(this.z, 1000);
            this.I = true;
        }
    }

    private static void e() {
        if (b.b()) {
            eh ehVar = (eh) b.a();
            ListIterator listIterator = a.listIterator();
            while (listIterator.hasNext()) {
                de deVar = (de) ((WeakReference) listIterator.next()).get();
                if (deVar != null) {
                    deVar.b(ehVar);
                    deVar.a(ehVar);
                    deVar.c(ehVar);
                    deVar.g();
                } else {
                    listIterator.remove();
                }
            }
        }
    }

    private void a(int i) {
        switch (i) {
            case 0:
                this.k.setText(j.reading__comment_view__level);
                return;
            case 1:
                this.k.setText(j.reading__comment_view__level1);
                return;
            case 2:
                this.k.setText(j.reading__comment_view__level2);
                return;
            case 4:
                this.k.setText(j.reading__comment_view__level4);
                return;
            case 5:
                this.k.setText(j.reading__comment_view__level5);
                return;
            default:
                this.k.setText(j.reading__comment_view__level3);
                return;
        }
    }

    private void f() {
        if (this.y.k() && i() && (DkUserPurchasedFictionsManager.a().a(this.y.H()) == null || !((ej) this.y).bc().j)) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.h.setText(String.format(getContext().getString(j.general__shared__book_name), new Object[]{this.y.aw()}));
        if (!this.y.k()) {
            this.i.setText(getResources().getString(j.reading__comment_view__finished));
        } else if (((ej) this.y).bc().j) {
            this.i.setText(getResources().getString(j.reading__comment_view__finished));
        } else {
            this.i.setText(getResources().getString(j.reading__comment_view__to_be_continued));
        }
    }

    private void b(eh ehVar) {
        if (this.e.bm()) {
            this.m.setVisibility(0);
            if (ehVar.g.d > 0 && ehVar.g.b > 0 && ehVar.g.c > 0) {
                this.s.setVisibility(0);
                this.r.setVisibility(8);
                this.q.setVisibility(8);
                c(ehVar.g);
                return;
            } else if (ehVar.g.h.size() != 0) {
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                this.q.setVisibility(8);
                b(ehVar.g);
                return;
            } else {
                this.q.setVisibility(0);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                a(ehVar.g);
                return;
            }
        }
        this.m.setVisibility(8);
    }

    private void a(ag agVar) {
        ((DkGeneralFaceView) this.q.findViewById(g.reading__comment_view__no_tip_avatar)).setUser(agVar.a);
        ((TextView) this.q.findViewById(g.reading__comment_view__no_tip_first)).setText(b.a(j.reading__comment_view__no_tip, getResources().getString(j.reading__comment_view__no_tip_first_fan)));
        ((TextView) this.q.findViewById(g.reading__comment_view__no_tip_title)).getPaint().setFakeBoldText(true);
        this.q.findViewById(g.reading__comment_view__go_tip).setOnClickListener(this.D);
    }

    private void b(ag agVar) {
        ((TextView) this.r.findViewById(g.reading__comment_view__fans_title)).getPaint().setFakeBoldText(true);
        ((TextView) this.r.findViewById(g.reading__comment_view__fans_count)).setText(String.format(getResources().getString(j.reading__comment_view__tip_count), new Object[]{Integer.valueOf(agVar.i)}));
        LinearLayout linearLayout = (LinearLayout) this.r.findViewById(g.reading__comment_view__fans_avatars);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(UTools.getMinimumHeight(getContext(), 40.0f), UTools.getMinimumHeight(getContext(), 40.0f));
        layoutParams.leftMargin = UTools.getMinimumHeight(getContext(), 7.5f);
        layoutParams.rightMargin = UTools.getMinimumHeight(getContext(), 7.5f);
        linearLayout.removeAllViews();
        for (int i = 0; i < Math.min(agVar.h.size(), 6); i++) {
            View dkGeneralFaceView = new DkGeneralFaceView(getContext());
            dkGeneralFaceView.setUser((User) agVar.h.get(i));
            linearLayout.addView(dkGeneralFaceView, layoutParams);
        }
        if (agVar.h.size() > 6) {
            View imageView = new ImageView(getContext());
            imageView.setImageDrawable(getResources().getDrawable(f.reading__comment_view__more));
            imageView.setScaleType(ScaleType.CENTER);
            imageView.setOnClickListener(new di(this));
            imageView.setPadding(UTools.getMinimumHeight(getContext(), 5.0f), 0, UTools.getMinimumHeight(getContext(), 5.0f), 0);
            linearLayout.addView(imageView, new ViewGroup.LayoutParams(-2, -1));
        }
        this.r.findViewById(g.reading__comment_view__tip_author).setOnClickListener(this.D);
    }

    private void c(ag agVar) {
        ((TextView) this.s.findViewById(g.reading__comment_view__my_tip_title)).getPaint().setFakeBoldText(true);
        ((DkGeneralFaceView) this.s.findViewById(g.reading__comment_view__my_tip_avatar)).setUser(agVar.a);
        ((TextView) this.s.findViewById(g.reading__comment_view__my_tip_user_nick)).setText(agVar.a.mNickName);
        ((TextView) this.s.findViewById(g.reading__comment_view__my_tip_cash)).setText(b.a(j.reading__comment_view__tip_cash, 16, Integer.valueOf(agVar.b), Integer.valueOf(agVar.d), Integer.valueOf(agVar.c)));
        this.s.findViewById(g.reading__comment_view__my_tip_go_tip).setOnClickListener(this.D);
        this.s.findViewById(g.reading__comment_view__tip_list).setOnClickListener(new dj(this));
    }

    protected void a(eh ehVar) {
        WebLog.c().b(ehVar != null);
        LinkedList linkedList = ehVar.f;
        this.t.removeAllViews();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                View a = a((com.duokan.reader.common.webservices.duokan.af) it.next());
                if (a != null) {
                    this.t.addView(a);
                }
            }
        }
        if (this.t.getChildCount() == 0) {
            this.t.setVisibility(8);
            this.u.setVisibility(0);
            return;
        }
        this.t.setVisibility(0);
        this.u.setVisibility(8);
    }

    private View a(com.duokan.reader.common.webservices.duokan.af afVar) {
        int i = 0;
        if (afVar.a.size() == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(h.reading__comment_view__related_books, this.t, false);
        ImageView imageView = (ImageView) inflate.findViewById(g.reading__comment_view__related_banner);
        View findViewById = inflate.findViewById(g.reading__comment_view__view_topic);
        if (afVar.c == 2 || afVar.c == 3) {
            if (TextUtils.isEmpty(afVar.f)) {
                imageView.setVisibility(8);
            } else {
                Glide.with(getContext().getApplicationContext()).load(afVar.f).asBitmap().into(new dk(this, imageView, afVar));
            }
            if (TextUtils.isEmpty(afVar.e)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                this.v.put(findViewById, afVar.d + "_topic_view_more");
                findViewById.setOnClickListener(new dm(this, afVar));
            }
        } else {
            imageView.setVisibility(8);
            findViewById.setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(g.reading__comment_view__related_title);
        textView.setText(afVar.b);
        textView.getPaint().setFakeBoldText(true);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(g.reading__comment_view__related_list);
        int i2;
        View view;
        if (afVar.c == 1 || afVar.c == 3) {
            linearLayout.setOrientation(1);
            linearLayout.setPadding(0, 0, 0, 0);
            i2 = 0;
            for (CommentBook commentBook : afVar.a) {
                View a = a(commentBook);
                linearLayout.addView(a, new ViewGroup.LayoutParams(-1, -2));
                if (i2 < afVar.a.size() - 1) {
                    view = new View(getContext());
                    view.setBackgroundColor(Color.parseColor("#e5e5e5"));
                    linearLayout.addView(view, new ViewGroup.LayoutParams(-1, 1));
                }
                int i3 = i2 + 1;
                this.v.put(a, afVar.d + "_related_book_" + i3);
                a.setOnClickListener(new dn(this, commentBook, afVar, i3));
                i2++;
            }
        } else {
            LinearLayout linearLayout2;
            linearLayout.setOrientation(0);
            if (afVar.a.size() > 3) {
                findViewById = new LinearScrollView(getContext());
                findViewById.setOnScrollListener(new do (this));
                linearLayout.addView(findViewById, new ViewGroup.LayoutParams(-1, -1));
                findViewById.setPadding(UTools.getMinimumHeight(getContext(), 15.0f), 0, UTools.getMinimumHeight(getContext(), 15.0f), 0);
                linearLayout2 = findViewById;
                i2 = UTools.getMinimumHeight(getContext(), 20.0f);
            } else {
                linearLayout.setPadding(UTools.getMinimumHeight(getContext(), 15.0f), 0, UTools.getMinimumHeight(getContext(), 15.0f), 0);
                i2 = (((UTools.getWidthPixels(getContext()) - linearLayout.getPaddingLeft()) - linearLayout.getPaddingRight()) - (getResources().getDimensionPixelSize(e.general__shared__cover_detail_width) * 3)) / 2;
                linearLayout2 = linearLayout;
            }
            for (CommentBook commentBook2 : afVar.a) {
                view = b(commentBook2);
                linearLayout2.addView(view);
                if (i < afVar.a.size() - 1) {
                    linearLayout2.addView(new View(getContext()), new LinearLayout.LayoutParams(i2, -1));
                }
                int i4 = i + 1;
                this.v.put(view, afVar.d + "_related_book_" + i4);
                view.setOnClickListener(new dp(this, commentBook2, afVar, i4));
                i++;
            }
        }
        return inflate;
    }

    protected View a(CommentBook commentBook) {
        View inflate = LayoutInflater.from(getContext()).inflate(h.reading__related_book_view__vertical, null);
        ImageView imageView = (ImageView) inflate.findViewById(g.reading__related_book_view__cover);
        Drawable fVar = new com.duokan.reader.ui.general.f(getContext(), f.general__shared__book_category_book_shadow);
        fVar.a((DkStoreAbsBook) commentBook);
        imageView.setBackgroundDrawable(fVar);
        TextView textView = (TextView) inflate.findViewById(g.reading__related_book_view__name);
        textView.getPaint().setFakeBoldText(true);
        textView.setText(commentBook.getTitle());
        ((TextView) inflate.findViewById(g.reading__related_book_view__summary)).setText(commentBook.getDescription());
        ((TextView) inflate.findViewById(g.reading__related_book_view__author)).setText(commentBook.getNameLine());
        if (!TextUtils.isEmpty(commentBook.getTag())) {
            textView = (TextView) inflate.findViewById(g.reading__related_book_view__tag);
            textView.setVisibility(0);
            textView.setText(commentBook.getTag());
        }
        if (commentBook.getBookRate() > 8) {
            textView = (TextView) inflate.findViewById(g.reading__related_book_view__rate);
            textView.setVisibility(0);
            textView.setText(String.format(getResources().getString(j.reading__comment_view__related_books_rate), new Object[]{Integer.valueOf(commentBook.getBookRate())}));
        }
        return inflate;
    }

    private View b(CommentBook commentBook) {
        View inflate = LayoutInflater.from(getContext()).inflate(h.reading__related_book_view__horizontal, null);
        ImageView imageView = (ImageView) inflate.findViewById(g.reading__related_book_view__cover);
        Drawable fVar = new com.duokan.reader.ui.general.f(getContext(), f.general__shared__book_category_book_shadow);
        fVar.a((DkStoreAbsBook) commentBook);
        imageView.setBackgroundDrawable(fVar);
        ((TextView) inflate.findViewById(g.reading__related_book_view__title)).setText(commentBook.getTitle());
        return inflate;
    }

    private void c(eh ehVar) {
        WebLog.c().b(ehVar != null);
        if (this.y.k() && i() && (!((ej) this.y).bc().j || DkUserPurchasedFictionsManager.a().a(this.y.H()) == null)) {
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        } else if (ehVar.e > 0) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            d(ehVar);
        } else {
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            this.j.setScore(ehVar.e);
            this.l.setText(ehVar.d.l);
            this.p.setEnabled(false);
        }
    }

    private void d(eh ehVar) {
        ((DkGeneralFaceView) this.o.findViewById(g.reading__comment_view__my_comment_avatar)).setUser(ehVar.d.j);
        ((TextView) this.o.findViewById(g.reading__comment_view__my_comment_user_nick)).setText(ehVar.d.j.mNickName);
        ((TextView) this.o.findViewById(g.reading__comment_view__my_comment_title)).getPaint().setFakeBoldText(true);
        ((DkCommentScoreView) this.o.findViewById(g.reading__comment_view__my_comment_user_score)).setScore(ehVar.e);
        View findViewById = findViewById(g.reading__comment_view__my_comment_line);
        if (i()) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        TextView textView = (TextView) this.o.findViewById(g.reading__comment_view__my_comment_content);
        if (TextUtils.isEmpty(ehVar.d.l)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(ehVar.d.l);
            textView.setOnClickListener(new dq(this, textView));
        }
        this.o.findViewById(g.reading__comment_view__others_comment).setOnClickListener(this.C);
        ((TextView) this.o.findViewById(g.reading__comment_view__my_comment_time)).setText(a(ehVar.d.a() * 1000));
        this.o.findViewById(g.reading__comment_view__my_comment_edit).setOnClickListener(new dr(this, ehVar));
    }

    private String a(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getResources().getString(j.general__shared__month_day_hour_min));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0800"));
        return simpleDateFormat.format(date);
    }

    private void g() {
        if (this.G != null) {
            Rect rect = new Rect();
            if (this.e.U() != PageAnimationMode.VSCROLL && this.w.getVisibility() == 0 && getLocalVisibleRect(rect)) {
                com.duokan.reader.domain.statistics.a.k().b("ending_page_recommendation_v3", "exposure", getLabelPrefix() + "shown");
                t.c(this.z);
                t.a(this.z, 1000);
                this.I = true;
            }
            this.x.clearAnimation();
            this.w.setVisibility(4);
        } else if (!classc.f.b().e() || this.H) {
            this.x.clearAnimation();
            this.w.setVisibility(4);
        }
    }

    private void h() {
        if (j()) {
            af afVar = new af();
            b = afVar;
            eh ehVar = new eh();
            ehVar.a = i.f().c();
            ehVar.b = ehVar.a.i();
            ehVar.c = this.y;
            new dw(this, ehVar, afVar).open();
        }
    }

    private boolean i() {
        return !this.e.bn();
    }

    private boolean a(com.duokan.reader.domain.account.a aVar, com.duokan.reader.domain.account.a aVar2) {
        if (aVar != aVar2) {
            return false;
        }
        if (aVar.i() && !aVar2.i()) {
            return false;
        }
        if (aVar.i() || !aVar2.i()) {
            return true;
        }
        return false;
    }

    private boolean j() {
        com.duokan.reader.domain.account.a c = i.f().c();
        if (b.b() && ((eh) b.a()).b == c.i() && a(((eh) b.a()).a, c) && ((eh) b.a()).c == this.y) {
            return false;
        }
        return true;
    }

    private void k() {
        if (j()) {
            h();
        } else {
            new dx(this, (eh) b.a()).open();
        }
    }

    private void a(ScrollState scrollState) {
        if (scrollState != ScrollState.IDLE || this.e.U() == PageAnimationMode.VSCROLL || this.I) {
            t.c(this.z);
            this.I = false;
            return;
        }
        t.a(this.z, 1000);
        this.I = true;
    }

    private String getLabelPrefix() {
        if (i()) {
            return "unavailable_page_";
        }
        return "ending_page_";
    }
}
