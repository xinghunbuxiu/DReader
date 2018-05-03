package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.bookshelf.iq;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.p052a.C1317a;
import java.util.List;

public class ec extends LinearLayout implements ip, iq, db, ex {
    /* renamed from: a */
    private final aa f6369a;
    /* renamed from: b */
    private final dc f6370b = new dc(getItems(), getContext());
    /* renamed from: c */
    private final gz f6371c;
    /* renamed from: d */
    private final cw f6372d;
    /* renamed from: e */
    private final cz f6373e;
    /* renamed from: f */
    private final RelativeLayout f6374f;
    /* renamed from: g */
    private final EditText f6375g;
    /* renamed from: h */
    private final ImageView f6376h;
    /* renamed from: i */
    private boolean f6377i = false;

    public ec(Context context, aa aaVar) {
        super(context);
        this.f6369a = aaVar;
        this.f6372d = (cw) AppContext.getAppContext(context).queryFeature(cw.class);
        this.f6373e = (cz) AppContext.getAppContext(context).queryFeature(cz.class);
        this.f6370b.m9455a(new ed(this));
        this.f6371c = new gz(getContext());
        this.f6371c.m1250b(this.f6371c.getGridPaddingLeft(), AnimUtils.m1932b(getContext(), 20.0f), this.f6371c.getGridPaddingRight(), AnimUtils.m1932b(getContext(), 20.0f));
        this.f6371c.setAdapter(this.f6370b);
        this.f6371c.m1249b(C0256h.bookshelf__category_expand_tip_view);
        this.f6371c.setNumColumns(ea.m9503a(getContext()));
        this.f6371c.setOnItemClickListener(new ee(this));
        int b = AnimUtils.m1932b(getContext(), 10.0f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        this.f6376h = new ImageView(getContext());
        this.f6376h.setPadding(b, b, b, b);
        this.f6376h.setLayoutParams(layoutParams);
        this.f6376h.setImageDrawable(getResources().getDrawable(C0254f.store__store_search_root_view__cancel));
        this.f6376h.setVisibility(8);
        this.f6376h.setOnClickListener(new ef(this));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int b2 = AnimUtils.m1932b(getContext(), 30.0f);
        layoutParams.leftMargin = b2;
        layoutParams.rightMargin = b2;
        layoutParams.addRule(14);
        this.f6375g = new EditText(getContext());
        this.f6375g.setText(this.f6369a.m3770k());
        this.f6375g.setTextSize(0, (float) getResources().getDimensionPixelSize(C0253e.general_font__shared__a));
        this.f6375g.setSingleLine(true);
        this.f6375g.setPadding(b, b, b, b);
        this.f6375g.setImeOptions(6);
        this.f6375g.setInputType(1);
        this.f6375g.setSelectAllOnFocus(true);
        this.f6375g.setLayoutParams(layoutParams);
        this.f6375g.setFilters(new InputFilter[]{new LengthFilter(10)});
        this.f6375g.setOnEditorActionListener(new eg(this));
        this.f6375g.setEnabled(!this.f6373e.mo1657b());
        this.f6375g.setOnFocusChangeListener(new eh(this));
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (DkApp.get().forHd()) {
            b = Math.min(Math.max((AnimUtils.getWidthPixels(getContext()) - AnimUtils.m1932b(getContext(), 300.0f)) / 2, 0), AnimUtils.m1932b(getContext(), 100.0f));
        } else {
            b = AnimUtils.m1932b(getContext(), 40.0f);
        }
        layoutParams.rightMargin = b;
        layoutParams.leftMargin = b;
        this.f6374f = new RelativeLayout(getContext());
        this.f6374f.setLayoutParams(layoutParams);
        this.f6374f.setGravity(80);
        this.f6374f.addView(this.f6375g);
        this.f6374f.addView(this.f6376h);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setPadding(0, 0, 0, AnimUtils.m1932b(getContext(), 15.0f));
        linearLayout.setGravity(81);
        linearLayout.setBackgroundColor(Color.parseColor("#33666666"));
        linearLayout.addView(this.f6374f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams2.leftMargin = AnimUtils.m1932b(getContext(), 15.0f);
        layoutParams2.rightMargin = AnimUtils.m1932b(getContext(), 15.0f);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, 0, 2.0f));
        addView(this.f6371c, new LinearLayout.LayoutParams(-1, 0, 6.0f));
        linearLayout = new View(getContext());
        linearLayout.setBackgroundColor(Color.parseColor("#33666666"));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, 0, 2.0f));
        setOrientation(1);
        setBackgroundColor(Color.argb(Math.round(76.5f), 242, 242, 242));
        setOnTouchListener(new ei(this));
        setFocusableInTouchMode(true);
    }

    /* renamed from: a */
    public void mo1628a(cz czVar, boolean z) {
        boolean z2;
        EditText editText = this.f6375g;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        editText.setEnabled(z2);
        this.f6370b.mo2519h(0, this.f6370b.mo506c());
    }

    /* renamed from: a */
    public void mo1627a(cz czVar, List<an> list) {
        this.f6370b.mo2519h(0, this.f6370b.mo506c());
    }

    /* renamed from: b */
    public void mo1629b(cz czVar, List<an> list) {
        this.f6370b.mo2519h(0, this.f6370b.mo506c());
    }

    public void onItemsChanged() {
        m9542c();
    }

    public void onItemChanged(an anVar, int i) {
        if ((i & -705) != 0) {
            m9542c();
        }
    }

    public int[] getVisibleItemIndices() {
        return this.f6371c.getVisibleItemIndices();
    }

    public int getItemCount() {
        return this.f6370b.m9457b();
    }

    /* renamed from: a */
    public Rect mo1661a(int i) {
        Rect g = this.f6371c.m1265g(i);
        AnimUtils.m1936b(g, this.f6371c);
        return g;
    }

    public View[] getItemViews() {
        return this.f6371c.getItemViews();
    }

    /* renamed from: b */
    public de mo1670b(int i) {
        return (de) this.f6371c.m1241a(i);
    }

    public de getDraggingItemView() {
        View[] itemViews = getItemViews();
        for (int i = 0; i < itemViews.length; i++) {
            if (itemViews[i] instanceof de) {
                de deVar = (de) itemViews[i];
                if (deVar != null && deVar.getItem() == this.f6370b.m9463e()) {
                    return deVar;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public an mo1671c(int i) {
        if (i < 0 || i >= this.f6370b.mo506c()) {
            return null;
        }
        return (an) this.f6370b.mo509d(i);
    }

    /* renamed from: a */
    public void mo1668a(an anVar, boolean z) {
        this.f6370b.m9454a(anVar, z);
    }

    /* renamed from: a */
    public void mo1664a(Rect rect) {
        rect.set(0, 0, this.f6371c.getWidth(), this.f6371c.getHeight());
        AnimUtils.m1936b(rect, this.f6371c);
    }

    /* renamed from: a */
    public int m9526a(an anVar) {
        return this.f6370b.m9458b(anVar);
    }

    /* renamed from: a */
    public void mo1666a(an anVar, int i) {
        this.f6370b.m9452a(anVar, i);
    }

    /* renamed from: a */
    public void mo1665a(aa aaVar, an anVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo1667a(an anVar, an anVar2, int i) {
        this.f6370b.m9453a(anVar, anVar2, i);
    }

    public boolean d_() {
        return this.f6371c.m1258d();
    }

    public boolean e_() {
        return this.f6371c.m1261e();
    }

    /* renamed from: a */
    public void mo1662a(int i, int i2) {
        this.f6371c.scrollBy(i, i2);
        this.f6371c.m1263f();
    }

    /* renamed from: a */
    public void mo1663a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f6371c.mo434a(i, i2, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.f6371c.getGridScrollY();
    }

    /* renamed from: a */
    public boolean mo1669a(int i, de deVar) {
        return (i + 1) % this.f6371c.getNumColumns() == 0;
    }

    /* renamed from: b */
    public void m9539b(an anVar) {
        int a = m9526a(anVar);
        if (a >= 0) {
            this.f6371c.m1259e(a);
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.f6373e.mo1645a((db) this);
            ai.m3980a().m3889a((ip) this);
            ai.m3980a().m3890a((iq) this);
            m9542c();
            return;
        }
        this.f6373e.mo1653b((db) this);
        ai.m3980a().m3912b((ip) this);
        ai.m3980a().m3913b((iq) this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            this.f6373e.mo1645a((db) this);
            ai.m3980a().m3889a((ip) this);
            ai.m3980a().m3890a((iq) this);
            m9542c();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6373e.mo1653b((db) this);
        ai.m3980a().m3912b((ip) this);
        ai.m3980a().m3913b((iq) this);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    /* renamed from: c */
    public void m9542c() {
        List items = getItems();
        if (items.size() > 0) {
            this.f6370b.m9459b(items);
        } else {
            this.f6373e.mo1647a(null);
        }
    }

    /* renamed from: d */
    public boolean m9543d() {
        return this.f6377i;
    }

    /* renamed from: e */
    public void m9544e() {
        String obj = this.f6375g.getText().toString();
        boolean z = (TextUtils.equals(obj, this.f6369a.m3770k()) || TextUtils.equals(obj, "")) ? false : true;
        if (!z) {
            this.f6375g.setText(this.f6369a.m3770k());
        } else if (ai.m3980a().m3929g(obj) != null) {
            be.m10287a(getContext(), getResources().getString(C0258j.bookshelf__category_rename_view__name_exists), 0).show();
            return;
        }
        AnimUtils.m1909a(getContext());
        requestFocus();
        C1317a.m10197b(this.f6375g, 300, new ej(this, z, obj));
        C1317a.m10193a(this.f6376h, 1.0f, 0.0f, 300, Boolean.valueOf(false), null);
    }

    /* renamed from: f */
    public void m9545f() {
        if (!this.f6373e.mo1657b()) {
            ReaderUi.m10162a(getContext(), this.f6375g);
        }
    }

    private List<an> getItems() {
        return this.f6372d.m9434a(this.f6369a);
    }
}
