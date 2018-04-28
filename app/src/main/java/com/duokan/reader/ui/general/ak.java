package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.common.C0267i;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.C0343f;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderEnv;
import java.util.ArrayList;

public class ak extends C0343f {
    /* renamed from: a */
    private final TextView f594a;
    /* renamed from: b */
    private final TextView f595b;
    /* renamed from: c */
    private final ViewGroup f596c;
    /* renamed from: d */
    private final ArrayList<FrameLayout> f597d = new ArrayList();
    /* renamed from: e */
    private final ViewGroup f598e;
    /* renamed from: f */
    private final ArrayList<FrameLayout> f599f = new ArrayList();
    /* renamed from: g */
    private final ViewGroup f600g;
    /* renamed from: h */
    private ao f601h = null;
    /* renamed from: i */
    private an f602i = null;

    public ak(Context context) {
        super(context);
        setContentView(C0245g.general__common_dialog_view);
        if (ReaderEnv.get().forHd()) {
            setGravity(17);
            ((BoxView) getContentView()).setMaxWidth(dv.m1932b(getContext(), 380.0f));
        } else {
            setGravity(80);
        }
        this.f594a = (TextView) findViewById(C0244f.general__common_dialog_view__title);
        this.f594a.getPaint().setFakeBoldText(true);
        this.f595b = (TextView) findViewById(C0244f.general__common_dialog_view__prompt);
        this.f596c = (ViewGroup) findViewById(C0244f.general__common_dialog_view__check_frame);
        this.f598e = (ViewGroup) findViewById(C0244f.general__common_dialog_view__button_frame);
        this.f600g = (ViewGroup) findViewById(C0244f.general__common_dialog_view__extra_content_frame);
        setWindowAttr();
    }

    public void setOnCheckStateChangedListener(ao aoVar) {
        this.f601h = aoVar;
    }

    public void setOnButtonClickedListener(an anVar) {
        this.f602i = anVar;
    }

    public void setTitle(int i) {
        this.f594a.setText(i);
        this.f594a.setVisibility(i == 0 ? 8 : 0);
    }

    public void setTitle(String str) {
        this.f594a.setText(str);
        this.f594a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setTitle(Drawable drawable) {
        this.f594a.setBackgroundDrawable(drawable);
        setTitle("  ");
    }

    public void setPrompt(int i) {
        this.f595b.setText(i);
        this.f595b.setVisibility(i == 0 ? 8 : 0);
    }

    public void setPrompt(String str) {
        this.f595b.setText(str);
        this.f595b.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setPromptLayoutGravity(int i) {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, (float) i);
        layoutParams.setMargins(0, dv.m1932b(getContext(), 10.0f), 0, 0);
        this.f595b.setLayoutParams(layoutParams);
    }

    public int addButtonView(int i) {
        return addButtonView(getContext().getString(i), getContext().getResources().getColor(C0241c.general__shared__c6));
    }

    public int addButtonView(int i, int i2) {
        return addButtonView(getContext().getString(i), i2);
    }

    public int addButtonView(String str, int i) {
        View newButtonFrameView = newButtonFrameView(newButtonView(str, i));
        if (this.f598e.getVisibility() != 0) {
            this.f598e.setVisibility(0);
        }
        this.f598e.addView(newButtonFrameView, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.f599f.add(newButtonFrameView);
        scheduleButtonBackground();
        return this.f599f.size() - 1;
    }

    public int addCheckBoxView(int i) {
        return addCheckBoxView(getContext().getString(i));
    }

    public int addCheckBoxView(String str) {
        View newCheckFrameView = newCheckFrameView(newCheckBoxView(str));
        this.f596c.setVisibility(0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 3;
        this.f596c.addView(newCheckFrameView, layoutParams);
        this.f597d.add(newCheckFrameView);
        if (this.f597d.size() > 1) {
            ((MarginLayoutParams) newCheckFrameView.getLayoutParams()).topMargin = C0267i.m598a(getContext(), 0.0f);
        }
        return this.f597d.size() - 1;
    }

    public void setButtonText(int i, int i2) {
        getButton(i).setText(i2);
    }

    public void setButtonText(int i, String str) {
        getButton(i).setText(str);
    }

    public void setCheckBoxText(int i, String str) {
        getCheckBox(i).setText(str);
    }

    public void setExtraContentResource(int i) {
        setExtraContentView(LayoutInflater.from(getContext()).inflate(i, null));
    }

    public void setExtraContentView(View view) {
        this.f600g.removeAllViews();
        if (view != null) {
            this.f600g.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.f600g.setVisibility(0);
            return;
        }
        this.f600g.setVisibility(8);
    }

    public void setChecked(int i, boolean z) {
        getCheckBox(i).setChecked(z);
    }

    public boolean isChecked(int i) {
        return getCheckBox(i).isChecked();
    }

    protected TextView getButton(int i) {
        return (TextView) ((FrameLayout) this.f599f.get(i)).getChildAt(0);
    }

    protected void onCheckStateChanged(int i) {
    }

    protected void onButtonClicked(int i) {
    }

    private void setWindowAttr() {
        int b = dv.m1932b(getContext(), 8.0f);
        getContentView().setBackgroundDrawable(new hb(new ColorDrawable(getContext().getResources().getColor(C0241c.general__shared__dialog)), (float) b));
        if (ReaderEnv.get().forHd()) {
            setEnterAnimation(C0240b.general__shared__scale_center_in);
            setExitAnimation(C0240b.general__shared__scale_center_out);
            return;
        }
        setEnterAnimation(C0240b.general__shared__push_down_in);
        setExitAnimation(C0240b.general__shared__push_down_out);
    }

    private void scheduleButtonBackground() {
        if (this.f599f.size() == 1) {
            getButton(0).setBackgroundDrawable(new hb(getContext().getResources().getDrawable(C0243e.general__shared__dialog_button_background), (float) dv.m1932b(getContext(), 6.0f), 12));
            return;
        }
        getButton(0).setBackgroundDrawable(new hb(getContext().getResources().getDrawable(C0243e.general__shared__dialog_button_background), (float) dv.m1932b(getContext(), 6.0f), 4));
        getButton(this.f599f.size() - 1).setBackgroundDrawable(new hb(getContext().getResources().getDrawable(C0243e.general__shared__dialog_button_background), (float) dv.m1932b(getContext(), 6.0f), 8));
    }

    private FrameLayout newCheckFrameView(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, new FrameLayout.LayoutParams(-2, -1));
        return frameLayout;
    }

    private View newCheckBoxView(String str) {
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(C0245g.general__common_check_box_view, null);
        checkBox.setText(str);
        checkBox.setOnCheckedChangeListener(new al(this));
        return checkBox;
    }

    private int getCheckIndex(View view) {
        for (int i = 0; i < this.f597d.size(); i++) {
            if (getCheckBox(i) == view) {
                return i;
            }
        }
        return -1;
    }

    private CheckBox getCheckBox(int i) {
        return (CheckBox) ((FrameLayout) this.f597d.get(i)).getChildAt(0);
    }

    private FrameLayout newButtonFrameView(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -2, 17));
        return frameLayout;
    }

    private View newButtonView(String str, int i) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0245g.general__common_dialog_view__button, null);
        int b = dv.m1932b(getContext(), 20.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setPadding(0, b, 0, b);
        textView.setBackgroundResource(C0243e.general__shared__dialog_button_background);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setOnClickListener(new am(this));
        return textView;
    }

    private int getButtonIndex(View view) {
        for (int i = 0; i < this.f599f.size(); i++) {
            if (getButton(i) == view) {
                return i;
            }
        }
        return -1;
    }
}
