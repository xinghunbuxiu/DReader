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

import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.bookshelf.iw;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.be;

import java.util.List;

public class du extends LinearLayout implements iv, iw, cw, eq {
    private final aa a;
    private final cx b = new cx(getItems(), getContext());
    private final gs c;
    private final cr d;
    private final cu e;
    private final RelativeLayout f;
    private final EditText g;
    private final ImageView h;
    private boolean i = false;

    public du(Context context, aa aaVar) {
        super(context);
        this.a = aaVar;
        this.d = (cr) MyContextWrapper.getFeature(context).queryFeature(cr.class);
        this.e = (cu) MyContextWrapper.getFeature(context).queryFeature(cu.class);
        this.b.a(new UTools(this));
        this.c = new gs(getContext());
        this.c.b(this.c.getGridPaddingLeft(), UTools.getMinimumHeight(getContext(), 20.0f), this.c.getGridPaddingRight(), UTools.getMinimumHeight(getContext(), 20.0f));
        this.c.setAdapter(this.b);
        this.c.b(h.bookshelf__category_expand_tip_view);
        this.c.setNumColumns(ds.a(getContext()));
        this.c.setOnItemClickListener(new dw(this));
        int b = UTools.getMinimumHeight(getContext(), 10.0f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        this.h = new ImageView(getContext());
        this.h.setPadding(b, b, b, b);
        this.h.setLayoutParams(layoutParams);
        this.h.setImageDrawable(getResources().getDrawable(f.store__store_search_root_view__cancel));
        this.h.setVisibility(8);
        this.h.setOnClickListener(new dx(this));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int b2 = UTools.getMinimumHeight(getContext(), 30.0f);
        layoutParams.leftMargin = b2;
        layoutParams.rightMargin = b2;
        layoutParams.addRule(14);
        this.g = new EditText(getContext());
        this.g.setText(this.a.k());
        this.g.setTextSize(0, (float) getResources().getDimensionPixelSize(e.general_font__shared__a));
        this.g.setSingleLine(true);
        this.g.setPadding(b, b, b, b);
        this.g.setImeOptions(6);
        this.g.setInputType(1);
        this.g.setSelectAllOnFocus(true);
        this.g.setLayoutParams(layoutParams);
        this.g.setFilters(new InputFilter[]{new LengthFilter(10)});
        this.g.setOnEditorActionListener(new dy(this));
        this.g.setEnabled(!this.e.b());
        this.g.setOnFocusChangeListener(new dz(this));
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (DkApp.get().forHd()) {
            b = Math.min(Math.max((UTools.getWidthPixels(getContext()) - UTools.getMinimumHeight(getContext(), 300.0f)) / 2, 0), UTools.getMinimumHeight(getContext(), 100.0f));
        } else {
            b = UTools.getMinimumHeight(getContext(), 40.0f);
        }
        layoutParams.rightMargin = b;
        layoutParams.leftMargin = b;
        this.f = new RelativeLayout(getContext());
        this.f.setLayoutParams(layoutParams);
        this.f.setGravity(80);
        this.f.addView(this.g);
        this.f.addView(this.h);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setPadding(0, 0, 0, UTools.getMinimumHeight(getContext(), 15.0f));
        linearLayout.setGravity(81);
        linearLayout.setBackgroundColor(Color.parseColor("#33666666"));
        linearLayout.addView(this.f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams2.leftMargin = UTools.getMinimumHeight(getContext(), 15.0f);
        layoutParams2.rightMargin = UTools.getMinimumHeight(getContext(), 15.0f);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, 0, 2.0f));
        addView(this.c, new LinearLayout.LayoutParams(-1, 0, 6.0f));
        linearLayout = new View(getContext());
        linearLayout.setBackgroundColor(Color.parseColor("#33666666"));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, 0, 2.0f));
        setOrientation(1);
        setBackgroundColor(Color.argb(Math.round(76.5f), 242, 242, 242));
        setOnTouchListener(new ea(this));
        setFocusableInTouchMode(true);
    }

    public void a(cu cuVar, boolean z) {
        boolean z2;
        EditText editText = this.g;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        editText.setEnabled(z2);
        this.b.h(0, this.b.c());
    }

    public void a(cu cuVar, List list) {
        this.b.h(0, this.b.c());
    }

    public void b(cu cuVar, List list) {
        this.b.h(0, this.b.c());
    }

    public void onItemsChanged() {
        c();
    }

    public void onItemChanged(an anVar, int i) {
        if ((i & -705) != 0) {
            c();
        }
    }

    public int[] getVisibleItemIndices() {
        return this.c.getVisibleItemIndices();
    }

    public int getItemCount() {
        return this.b.b();
    }

    public Rect a(int i) {
        Rect g = this.c.g(i);
        UTools.closeAnimation(g, this.c);
        return g;
    }

    public View[] getItemViews() {
        return this.c.getItemViews();
    }

    public cz b(int i) {
        return (cz) this.c.a(i);
    }

    public cz getDraggingItemView() {
        View[] itemViews = getItemViews();
        for (int i = 0; i < itemViews.length; i++) {
            if (itemViews[i] instanceof cz) {
                cz czVar = (cz) itemViews[i];
                if (czVar != null && czVar.getItem() == this.b.e()) {
                    return czVar;
                }
            }
        }
        return null;
    }

    public an c(int i) {
        if (i < 0 || i >= this.b.c()) {
            return null;
        }
        return (an) this.b.d(i);
    }

    public void a(an anVar, boolean z) {
        this.b.a(anVar, z);
    }

    public void a(Rect rect) {
        rect.set(0, 0, this.c.getWidth(), this.c.getHeight());
        UTools.closeAnimation(rect, this.c);
    }

    public int a(an anVar) {
        return this.b.b(anVar);
    }

    public void a(an anVar, int i) {
        this.b.a(anVar, i);
    }

    public void a(aa aaVar, an anVar) {
        throw new UnsupportedOperationException();
    }

    public void a(an anVar, an anVar2, int i) {
        this.b.a(anVar, anVar2, i);
    }

    public boolean c_() {
        return this.c.d();
    }

    public boolean d_() {
        return this.c.e();
    }

    public void a(int i, int i2) {
        this.c.scrollBy(i, i2);
        this.c.f();
    }

    public void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.c.a(i, i2, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.c.getGridScrollY();
    }

    public boolean a(int i, cz czVar) {
        return (i + 1) % this.c.getNumColumns() == 0;
    }

    public void b(an anVar) {
        int a = a(anVar);
        if (a >= 0) {
            this.c.e(a);
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.e.a((cw) this);
            ai.a().a((iv) this);
            ai.a().a((iw) this);
            c();
            return;
        }
        this.e.b((cw) this);
        ai.a().b((iv) this);
        ai.a().b((iw) this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            this.e.a((cw) this);
            ai.a().a((iv) this);
            ai.a().a((iw) this);
            c();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.b((cw) this);
        ai.a().b((iv) this);
        ai.a().b((iw) this);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    public void c() {
        List items = getItems();
        if (items.size() > 0) {
            this.b.b(items);
        } else {
            this.e.a(null);
        }
    }

    public boolean d() {
        return this.i;
    }

    public void e() {
        String obj = this.g.getText().toString();
        boolean z = (TextUtils.equals(obj, this.a.k()) || TextUtils.equals(obj, "")) ? false : true;
        if (!z) {
            this.g.setText(this.a.k());
        } else if (ai.a().g(obj) != null) {
            be.a(getContext(), getResources().getString(j.bookshelf__category_rename_view__name_exists), 0).show();
            return;
        }
        UTools.hideSoftInputFromWindow(getContext());
        requestFocus();
        a.b(this.g, 300, new eb(this, z, obj));
        a.a(this.h, 1.0f, 0.0f, 300, Boolean.valueOf(false), null);
    }

    public void f() {
        if (!this.e.b()) {
            ReaderUi.a(getContext(), this.g);
        }
    }

    private List getItems() {
        return this.d.a(this.a);
    }
}
