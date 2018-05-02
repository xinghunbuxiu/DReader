package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
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
import com.duokan.core.app.AppContext;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.C0543b;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0628a;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.common.webservices.duokan.CommentBook;
import com.duokan.reader.common.webservices.duokan.ag;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.ui.general.C1332f;
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

public class dg extends FrameLayout {
    /* renamed from: a */
    private static final LinkedList<WeakReference<dg>> f9990a = new LinkedList();
    /* renamed from: b */
    private static af<el> f9991b = new af();
    /* renamed from: A */
    private final Runnable f9992A;
    /* renamed from: B */
    private final ReaderFeature f9993B;
    /* renamed from: C */
    private final OnClickListener f9994C;
    /* renamed from: D */
    private final OnClickListener f9995D = new dh(this);
    /* renamed from: E */
    private final OnClickListener f9996E = new du(this);
    /* renamed from: F */
    private final Runnable f9997F = new ec(this);
    /* renamed from: G */
    private String f9998G = null;
    /* renamed from: H */
    private DkStoreItemDetail f9999H;
    /* renamed from: I */
    private boolean f10000I = false;
    /* renamed from: J */
    private boolean f10001J = false;
    /* renamed from: c */
    private final HashMap<String, Long> f10002c = new HashMap();
    /* renamed from: d */
    private final PointF f10003d = new PointF();
    /* renamed from: e */
    private final LinearScrollView f10004e;
    /* renamed from: f */
    private final su f10005f;
    /* renamed from: g */
    private final View f10006g;
    /* renamed from: h */
    private final View f10007h;
    /* renamed from: i */
    private final TextView f10008i;
    /* renamed from: j */
    private final TextView f10009j;
    /* renamed from: k */
    private final DkCommentScoreView f10010k;
    /* renamed from: l */
    private final TextView f10011l;
    /* renamed from: m */
    private final EditText f10012m;
    /* renamed from: n */
    private final View f10013n;
    /* renamed from: o */
    private final View f10014o;
    /* renamed from: p */
    private final View f10015p;
    /* renamed from: q */
    private final TextView f10016q;
    /* renamed from: r */
    private final View f10017r;
    /* renamed from: s */
    private final View f10018s;
    /* renamed from: t */
    private final View f10019t;
    /* renamed from: u */
    private final LinearLayout f10020u;
    /* renamed from: v */
    private final View f10021v;
    /* renamed from: w */
    private final HashMap<View, String> f10022w = new HashMap();
    /* renamed from: x */
    private final FrameLayout f10023x;
    /* renamed from: y */
    private final View f10024y;
    /* renamed from: z */
    private final C0800c f10025z;

    public dg(Context context) {
        super(context);
        f9990a.add(new WeakReference(this));
        this.f9993B = (ReaderFeature) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class);
        this.f10005f = (su) AppContext.getAppContext(context).queryFeature(su.class);
        this.f10025z = this.f10005f.mo1992G();
        View inflate = LayoutInflater.from(context).inflate(C0256h.reading__comment_view, null);
        addView(inflate, new LayoutParams(-1, -1));
        this.f10004e = (LinearScrollView) findViewById(C0255g.reading__comment_view__content);
        this.f10004e.setOnTouchListener(new ee(this));
        this.f10004e.setOnClickListener(new ef(this));
        this.f10004e.setOnScrollListener(new eg(this));
        this.f10023x = new FrameLayout(getContext());
        this.f10023x.setClickable(true);
        this.f10023x.setBackgroundColor(-1);
        this.f10024y = new LoadingCircleView(getContext());
        this.f10023x.addView(this.f10024y, new LayoutParams(-2, -2, 17));
        addView(this.f10023x, new ViewGroup.LayoutParams(-1, -1));
        this.f10016q = (TextView) inflate.findViewById(C0255g.reading__comment_view__submit);
        this.f10010k = (DkCommentScoreView) inflate.findViewById(C0255g.reading__comment_view__score);
        this.f10010k.setScoreChangeListener(new eh(this));
        this.f10012m = (EditText) inflate.findViewById(C0255g.reading__comment_view__comment_edit_text);
        this.f10011l = (TextView) inflate.findViewById(C0255g.reading__comment_view__level);
        this.f9994C = new ei(this);
        this.f10016q.setOnClickListener(this.f9994C);
        this.f10014o = inflate.findViewById(C0255g.reading__comment_view__no_comment);
        this.f10015p = inflate.findViewById(C0255g.reading__comment_view__my_comment);
        this.f10013n = inflate.findViewById(C0255g.reading__comment_view__tip_container);
        this.f10017r = this.f10013n.findViewById(C0255g.reading__comment_view__no_tip);
        this.f10018s = this.f10013n.findViewById(C0255g.reading__comment_view__fans_list);
        this.f10019t = this.f10013n.findViewById(C0255g.reading__comment_view__my_tip);
        this.f10006g = findViewById(C0255g.reading__comment_view__book_title_container);
        this.f10008i = (TextView) findViewById(C0255g.reading__comment_view__book_title);
        this.f10009j = (TextView) findViewById(C0255g.reading__comment_view__book_status);
        this.f10020u = (LinearLayout) findViewById(C0255g.reading__comment_view__related_books_container);
        this.f10021v = findViewById(C0255g.reading__comment_view__view_more);
        this.f10021v.setOnClickListener(new ek(this));
        this.f10007h = findViewById(C0255g.reading__comment_view__off_shelf_book_container);
        findViewById(C0255g.reading__comment_view__share).setOnClickListener(new dj(this));
        findViewById(C0255g.reading__comment_view__back).setOnClickListener(new dk(this));
        this.f9999H = this.f10005f.bm();
        m13971f();
        m13974h();
        if (f9991b.m861b()) {
            m13969e();
        }
        setWillNotDraw(false);
        this.f9992A = new dl(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UThread.removeCallbacks(this.f9992A);
        for (String str : this.f10002c.keySet()) {
            C0628a c0628a = new C0628a();
            c0628a.f2093a = "ending_page_recommendation_v3";
            c0628a.f2095c = "exposure";
            c0628a.f2094b = getLabelPrefix() + str;
            c0628a.f2097e = ((Long) this.f10002c.get(str)).longValue();
            C1163a.m8627k().m8635a(c0628a, false);
        }
        C1163a.m8627k().m8629a();
        f9991b = new af();
    }

    /* renamed from: a */
    public void m13990a() {
        if (this.f9999H != null) {
            m13973g();
            return;
        }
        this.f9999H = this.f10005f.bm();
        this.f10000I = true;
        m13971f();
        m13981k();
    }

    /* renamed from: b */
    public void m13992b() {
        if (this.f10023x.getVisibility() != 0 && this.f10005f.mo2004U() != PageAnimationMode.VSCROLL) {
            C1163a.m8627k().m8655c("ending_page_recommendation_v3", "exposure", getLabelPrefix() + "shown");
            UThread.removeCallbacks(this.f9992A);
            UThread.postDelayed(this.f9992A, 1000);
            this.f10001J = true;
        }
    }

    /* renamed from: a */
    private void m13948a(View view) {
        Rect bk = this.f10005f.bk();
        RectF rectF = new RectF((float) bk.left, (float) bk.top, (float) (view.getWidth() - bk.right), (float) (view.getHeight() - bk.bottom));
        if (rectF.contains(this.f10003d.x, this.f10003d.y)) {
            this.f10005f.bp();
        } else if (this.f10005f.mo2004U() == PageAnimationMode.VSCROLL) {
            if (this.f10003d.y < rectF.top) {
                this.f10005f.mo2018a(this.f10003d, null, null);
            } else if (this.f10003d.y > rectF.bottom) {
                this.f10005f.mo2099b(this.f10003d, null, null);
            }
        } else if (this.f10005f.al()) {
            if (this.f10003d.x < rectF.left) {
                this.f10005f.mo2099b(this.f10003d, null, null);
            } else if (this.f10003d.x > rectF.right) {
                if (!this.f10005f.aL()) {
                    this.f10005f.mo2018a(this.f10003d, null, null);
                } else if (this.f10005f.aL()) {
                    this.f10005f.mo2099b(this.f10003d, null, null);
                }
            } else if (this.f10003d.y < rectF.top) {
                this.f10005f.mo2018a(this.f10003d, null, null);
            } else if (this.f10003d.y > rectF.bottom) {
                this.f10005f.mo2099b(this.f10003d, null, null);
            }
        } else if (this.f10003d.x < rectF.left) {
            if (!this.f10005f.aL()) {
                this.f10005f.mo2018a(this.f10003d, null, null);
            } else if (this.f10005f.aL()) {
                this.f10005f.mo2099b(this.f10003d, null, null);
            }
        } else if (this.f10003d.x > rectF.right) {
            this.f10005f.mo2099b(this.f10003d, null, null);
        } else if (this.f10003d.y < rectF.top) {
            this.f10005f.mo2018a(this.f10003d, null, null);
        } else if (this.f10003d.y > rectF.bottom) {
            this.f10005f.mo2099b(this.f10003d, null, null);
        }
    }

    /* renamed from: e */
    private static void m13969e() {
        if (f9991b.m861b()) {
            el elVar = (el) f9991b.m858a();
            ListIterator listIterator = f9990a.listIterator();
            while (listIterator.hasNext()) {
                dg dgVar = (dg) ((WeakReference) listIterator.next()).get();
                if (dgVar != null) {
                    dgVar.m13960b(elVar);
                    dgVar.m13991a(elVar);
                    dgVar.m13964c(elVar);
                    dgVar.m13973g();
                } else {
                    listIterator.remove();
                }
            }
        }
    }

    /* renamed from: a */
    private void m13947a(int i) {
        switch (i) {
            case 0:
                this.f10011l.setText(C0258j.reading__comment_view__level);
                return;
            case 1:
                this.f10011l.setText(C0258j.reading__comment_view__level1);
                return;
            case 2:
                this.f10011l.setText(C0258j.reading__comment_view__level2);
                return;
            case 4:
                this.f10011l.setText(C0258j.reading__comment_view__level4);
                return;
            case 5:
                this.f10011l.setText(C0258j.reading__comment_view__level5);
                return;
            default:
                this.f10011l.setText(C0258j.reading__comment_view__level3);
                return;
        }
    }

    /* renamed from: f */
    private void m13971f() {
        if (this.f10025z.mo1038k() && m13977i() && (DkUserPurchasedFictionsManager.m5072a().m5093a(this.f10025z.m4156I()) == null || !((ee) this.f10025z).be().f3516j)) {
            this.f10006g.setVisibility(8);
            this.f10007h.setVisibility(0);
            return;
        }
        this.f10006g.setVisibility(0);
        this.f10007h.setVisibility(8);
        this.f10008i.setText(String.format(getContext().getString(C0258j.general__shared__book_name), new Object[]{this.f10025z.ay()}));
        if (!this.f10025z.mo1038k()) {
            this.f10009j.setText(getResources().getString(C0258j.reading__comment_view__finished));
        } else if (((ee) this.f10025z).be().f3516j) {
            this.f10009j.setText(getResources().getString(C0258j.reading__comment_view__finished));
        } else {
            this.f10009j.setText(getResources().getString(C0258j.reading__comment_view__to_be_continued));
        }
    }

    /* renamed from: b */
    private void m13960b(el elVar) {
        if (this.f10005f.bn()) {
            this.f10013n.setVisibility(0);
            if (elVar.f10085g.f2111d > 0 && elVar.f10085g.f2109b > 0 && elVar.f10085g.f2110c > 0) {
                this.f10019t.setVisibility(0);
                this.f10018s.setVisibility(8);
                this.f10017r.setVisibility(8);
                m13963c(elVar.f10085g);
                return;
            } else if (elVar.f10085g.f2115h.size() != 0) {
                this.f10018s.setVisibility(0);
                this.f10019t.setVisibility(8);
                this.f10017r.setVisibility(8);
                m13958b(elVar.f10085g);
                return;
            } else {
                this.f10017r.setVisibility(0);
                this.f10018s.setVisibility(8);
                this.f10019t.setVisibility(8);
                m13950a(elVar.f10085g);
                return;
            }
        }
        this.f10013n.setVisibility(8);
    }

    /* renamed from: a */
    private void m13950a(ag agVar) {
        ((DkGeneralFaceView) this.f10017r.findViewById(C0255g.reading__comment_view__no_tip_avatar)).setUser(agVar.f2108a);
        ((TextView) this.f10017r.findViewById(C0255g.reading__comment_view__no_tip_first)).setText(C0543b.m2419a(C0258j.reading__comment_view__no_tip, getResources().getString(C0258j.reading__comment_view__no_tip_first_fan)));
        ((TextView) this.f10017r.findViewById(C0255g.reading__comment_view__no_tip_title)).getPaint().setFakeBoldText(true);
        this.f10017r.findViewById(C0255g.reading__comment_view__go_tip).setOnClickListener(this.f9996E);
    }

    /* renamed from: b */
    private void m13958b(ag agVar) {
        ((TextView) this.f10018s.findViewById(C0255g.reading__comment_view__fans_title)).getPaint().setFakeBoldText(true);
        ((TextView) this.f10018s.findViewById(C0255g.reading__comment_view__fans_count)).setText(String.format(getResources().getString(C0258j.reading__comment_view__tip_count), new Object[]{Integer.valueOf(agVar.f2116i)}));
        LinearLayout linearLayout = (LinearLayout) this.f10018s.findViewById(C0255g.reading__comment_view__fans_avatars);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(dv.m1932b(getContext(), 40.0f), dv.m1932b(getContext(), 40.0f));
        layoutParams.leftMargin = dv.m1932b(getContext(), 7.5f);
        layoutParams.rightMargin = dv.m1932b(getContext(), 7.5f);
        linearLayout.removeAllViews();
        for (int i = 0; i < Math.min(agVar.f2115h.size(), 6); i++) {
            View dkGeneralFaceView = new DkGeneralFaceView(getContext());
            dkGeneralFaceView.setUser((User) agVar.f2115h.get(i));
            linearLayout.addView(dkGeneralFaceView, layoutParams);
        }
        if (agVar.f2115h.size() > 6) {
            View imageView = new ImageView(getContext());
            imageView.setImageDrawable(getResources().getDrawable(C0254f.reading__comment_view__more));
            imageView.setScaleType(ScaleType.CENTER);
            imageView.setOnClickListener(new dm(this));
            imageView.setPadding(dv.m1932b(getContext(), 5.0f), 0, dv.m1932b(getContext(), 5.0f), 0);
            linearLayout.addView(imageView, new ViewGroup.LayoutParams(-2, -1));
        }
        this.f10018s.findViewById(C0255g.reading__comment_view__tip_author).setOnClickListener(this.f9996E);
    }

    /* renamed from: c */
    private void m13963c(ag agVar) {
        ((TextView) this.f10019t.findViewById(C0255g.reading__comment_view__my_tip_title)).getPaint().setFakeBoldText(true);
        ((DkGeneralFaceView) this.f10019t.findViewById(C0255g.reading__comment_view__my_tip_avatar)).setUser(agVar.f2108a);
        ((TextView) this.f10019t.findViewById(C0255g.reading__comment_view__my_tip_user_nick)).setText(agVar.f2108a.mNickName);
        ((TextView) this.f10019t.findViewById(C0255g.reading__comment_view__my_tip_cash)).setText(C0543b.m2417a(C0258j.reading__comment_view__tip_cash, 16, Integer.valueOf(agVar.f2109b), Integer.valueOf(agVar.f2111d), Integer.valueOf(agVar.f2110c)));
        this.f10019t.findViewById(C0255g.reading__comment_view__my_tip_go_tip).setOnClickListener(this.f9996E);
        this.f10019t.findViewById(C0255g.reading__comment_view__tip_list).setOnClickListener(new dn(this));
    }

    /* renamed from: a */
    protected void m13991a(el elVar) {
        WebLog.init().w(elVar != null);
        LinkedList linkedList = elVar.f10084f;
        this.f10020u.removeAllViews();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                View a = m13943a((com.duokan.reader.common.webservices.duokan.af) it.next());
                if (a != null) {
                    this.f10020u.addView(a);
                }
            }
        }
        if (this.f10020u.getChildCount() == 0) {
            this.f10020u.setVisibility(8);
            this.f10021v.setVisibility(0);
            return;
        }
        this.f10020u.setVisibility(0);
        this.f10021v.setVisibility(8);
    }

    /* renamed from: a */
    private View m13943a(com.duokan.reader.common.webservices.duokan.af afVar) {
        int i = 0;
        if (afVar.f2102a.size() == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.reading__comment_view__related_books, this.f10020u, false);
        ImageView imageView = (ImageView) inflate.findViewById(C0255g.reading__comment_view__related_banner);
        View findViewById = inflate.findViewById(C0255g.reading__comment_view__view_topic);
        if (afVar.f2104c == 2 || afVar.f2104c == 3) {
            if (TextUtils.isEmpty(afVar.f2107f)) {
                imageView.setVisibility(8);
            } else {
                Glide.with(getContext().getApplicationContext()).load(afVar.f2107f).asBitmap().into(new C1451do(this, imageView, afVar));
            }
            if (TextUtils.isEmpty(afVar.f2106e)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                this.f10022w.put(findViewById, afVar.f2105d + "_topic_view_more");
                findViewById.setOnClickListener(new dq(this, afVar));
            }
        } else {
            imageView.setVisibility(8);
            findViewById.setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(C0255g.reading__comment_view__related_title);
        textView.setText(afVar.f2103b);
        textView.getPaint().setFakeBoldText(true);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C0255g.reading__comment_view__related_list);
        int i2;
        View view;
        if (afVar.f2104c == 1 || afVar.f2104c == 3) {
            linearLayout.setOrientation(1);
            linearLayout.setPadding(0, 0, 0, 0);
            i2 = 0;
            for (CommentBook commentBook : afVar.f2102a) {
                View a = m13989a(commentBook);
                linearLayout.addView(a, new ViewGroup.LayoutParams(-1, -2));
                if (i2 < afVar.f2102a.size() - 1) {
                    view = new View(getContext());
                    view.setBackgroundColor(Color.parseColor("#e5e5e5"));
                    linearLayout.addView(view, new ViewGroup.LayoutParams(-1, 1));
                }
                int i3 = i2 + 1;
                this.f10022w.put(a, afVar.f2105d + "_related_book_" + i3);
                a.setOnClickListener(new dr(this, commentBook, afVar, i3));
                i2++;
            }
        } else {
            LinearLayout linearLayout2;
            linearLayout.setOrientation(0);
            if (afVar.f2102a.size() > 3) {
                findViewById = new LinearScrollView(getContext());
                findViewById.setOnScrollListener(new ds(this));
                linearLayout.addView(findViewById, new ViewGroup.LayoutParams(-1, -1));
                findViewById.setPadding(dv.m1932b(getContext(), 15.0f), 0, dv.m1932b(getContext(), 15.0f), 0);
                linearLayout2 = findViewById;
                i2 = dv.m1932b(getContext(), 20.0f);
            } else {
                linearLayout.setPadding(dv.m1932b(getContext(), 15.0f), 0, dv.m1932b(getContext(), 15.0f), 0);
                i2 = (((dv.getWidthPixels(getContext()) - linearLayout.getPaddingLeft()) - linearLayout.getPaddingRight()) - (getResources().getDimensionPixelSize(C0253e.general__shared__cover_detail_width) * 3)) / 2;
                linearLayout2 = linearLayout;
            }
            for (CommentBook commentBook2 : afVar.f2102a) {
                view = m13956b(commentBook2);
                linearLayout2.addView(view);
                if (i < afVar.f2102a.size() - 1) {
                    linearLayout2.addView(new View(getContext()), new LinearLayout.LayoutParams(i2, -1));
                }
                int i4 = i + 1;
                this.f10022w.put(view, afVar.f2105d + "_related_book_" + i4);
                view.setOnClickListener(new dt(this, commentBook2, afVar, i4));
                i++;
            }
        }
        return inflate;
    }

    /* renamed from: a */
    protected View m13989a(CommentBook commentBook) {
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.reading__related_book_view__vertical, null);
        ImageView imageView = (ImageView) inflate.findViewById(C0255g.reading__related_book_view__cover);
        Drawable c1332f = new C1332f(getContext(), C0254f.general__shared__book_category_book_shadow);
        c1332f.m10610a((DkStoreAbsBook) commentBook);
        imageView.setBackgroundDrawable(c1332f);
        TextView textView = (TextView) inflate.findViewById(C0255g.reading__related_book_view__name);
        textView.getPaint().setFakeBoldText(true);
        textView.setText(commentBook.getTitle());
        ((TextView) inflate.findViewById(C0255g.reading__related_book_view__summary)).setText(commentBook.getDescription());
        ((TextView) inflate.findViewById(C0255g.reading__related_book_view__author)).setText(commentBook.getNameLine());
        if (!TextUtils.isEmpty(commentBook.getTag())) {
            textView = (TextView) inflate.findViewById(C0255g.reading__related_book_view__tag);
            textView.setVisibility(0);
            textView.setText(commentBook.getTag());
        }
        if (commentBook.getBookRate() > 8) {
            textView = (TextView) inflate.findViewById(C0255g.reading__related_book_view__rate);
            textView.setVisibility(0);
            textView.setText(String.format(getResources().getString(C0258j.reading__comment_view__related_books_rate), new Object[]{Integer.valueOf(commentBook.getBookRate())}));
        }
        return inflate;
    }

    /* renamed from: b */
    private View m13956b(CommentBook commentBook) {
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.reading__related_book_view__horizontal, null);
        ImageView imageView = (ImageView) inflate.findViewById(C0255g.reading__related_book_view__cover);
        Drawable c1332f = new C1332f(getContext(), C0254f.general__shared__book_category_book_shadow);
        c1332f.m10610a((DkStoreAbsBook) commentBook);
        imageView.setBackgroundDrawable(c1332f);
        ((TextView) inflate.findViewById(C0255g.reading__related_book_view__title)).setText(commentBook.getTitle());
        return inflate;
    }

    /* renamed from: c */
    private void m13964c(el elVar) {
        WebLog.init().w(elVar != null);
        if (this.f10025z.mo1038k() && m13977i() && (!((ee) this.f10025z).be().f3516j || DkUserPurchasedFictionsManager.m5072a().m5093a(this.f10025z.m4156I()) == null)) {
            this.f10015p.setVisibility(8);
            this.f10014o.setVisibility(8);
        } else if (elVar.f10083e > 0) {
            this.f10015p.setVisibility(0);
            this.f10014o.setVisibility(8);
            m13967d(elVar);
        } else {
            this.f10015p.setVisibility(8);
            this.f10014o.setVisibility(0);
            this.f10010k.setScore(5);
            this.f10012m.setText(elVar.f10082d.f2067l);
        }
    }

    /* renamed from: d */
    private void m13967d(el elVar) {
        ((DkGeneralFaceView) this.f10015p.findViewById(C0255g.reading__comment_view__my_comment_avatar)).setUser(elVar.f10082d.f2065j);
        ((TextView) this.f10015p.findViewById(C0255g.reading__comment_view__my_comment_user_nick)).setText(elVar.f10082d.f2065j.mNickName);
        ((TextView) this.f10015p.findViewById(C0255g.reading__comment_view__my_comment_title)).getPaint().setFakeBoldText(true);
        ((DkCommentScoreView) this.f10015p.findViewById(C0255g.reading__comment_view__my_comment_user_score)).setScore(elVar.f10083e);
        View findViewById = findViewById(C0255g.reading__comment_view__my_comment_line);
        if (m13977i()) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        TextView textView = (TextView) this.f10015p.findViewById(C0255g.reading__comment_view__my_comment_content);
        if (TextUtils.isEmpty(elVar.f10082d.f2067l)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(elVar.f10082d.f2067l);
            textView.setOnClickListener(new dy(this, textView));
        }
        this.f10015p.findViewById(C0255g.reading__comment_view__others_comment).setOnClickListener(this.f9995D);
        ((TextView) this.f10015p.findViewById(C0255g.reading__comment_view__my_comment_time)).setText(m13945a(elVar.f10082d.m2817a() * 1000));
        this.f10015p.findViewById(C0255g.reading__comment_view__my_comment_edit).setOnClickListener(new dz(this, elVar));
    }

    /* renamed from: a */
    private String m13945a(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getResources().getString(C0258j.general__shared__month_day_hour_min));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0800"));
        return simpleDateFormat.format(date);
    }

    /* renamed from: g */
    private void m13973g() {
        if (this.f9999H != null) {
            Rect rect = new Rect();
            if (this.f10005f.mo2004U() != PageAnimationMode.VSCROLL && this.f10023x.getVisibility() == 0 && getLocalVisibleRect(rect)) {
                C1163a.m8627k().m8655c("ending_page_recommendation_v3", "exposure", getLabelPrefix() + "shown");
                UThread.removeCallbacks(this.f9992A);
                UThread.postDelayed(this.f9992A, 1000);
                this.f10001J = true;
            }
            this.f10024y.clearAnimation();
            this.f10023x.setVisibility(4);
        } else if (!C0559f.m2476b().m2486e() || this.f10000I) {
            this.f10024y.clearAnimation();
            this.f10023x.setVisibility(4);
        }
    }

    /* renamed from: h */
    private void m13974h() {
        if (m13979j()) {
            af afVar = new af();
            f9991b = afVar;
            el elVar = new el();
            elVar.f10079a = C0709k.m3476a().m3508d();
            elVar.f10080b = elVar.f10079a.mo839i();
            elVar.f10081c = this.f10025z;
            new ea(this, C0643q.f2173a, elVar, afVar).open();
        }
    }

    /* renamed from: i */
    private boolean m13977i() {
        return !this.f10005f.bo();
    }

    /* renamed from: a */
    private boolean m13955a(C0672a c0672a, C0672a c0672a2) {
        if (c0672a != c0672a2) {
            return false;
        }
        if (c0672a.mo839i() && !c0672a2.mo839i()) {
            return false;
        }
        if (c0672a.mo839i() || !c0672a2.mo839i()) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    private boolean m13979j() {
        C0672a d = C0709k.m3476a().m3508d();
        if (f9991b.m861b() && ((el) f9991b.m858a()).f10080b == d.mo839i() && m13955a(((el) f9991b.m858a()).f10079a, d) && ((el) f9991b.m858a()).f10081c == this.f10025z) {
            return false;
        }
        return true;
    }

    /* renamed from: k */
    private void m13981k() {
        if (m13979j()) {
            m13974h();
            return;
        }
        new eb(this, C0643q.f2173a, (el) f9991b.m858a()).open();
    }

    /* renamed from: a */
    private void m13949a(ScrollState scrollState) {
        if (scrollState != ScrollState.IDLE || this.f10005f.mo2004U() == PageAnimationMode.VSCROLL || this.f10001J) {
            UThread.removeCallbacks(this.f9992A);
            this.f10001J = false;
            return;
        }
        UThread.postDelayed(this.f9992A, 1000);
        this.f10001J = true;
    }

    private String getLabelPrefix() {
        if (m13977i()) {
            return "unavailable_page_";
        }
        return "ending_page_";
    }
}
