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

import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.f;
import com.duokan.reader.ReaderEnv;

import java.util.ArrayList;

public class ak extends f {
    private final TextView a;
    private final TextView b;
    private final ViewGroup c;
    private final ArrayList d = new ArrayList();
    private final ViewGroup e;
    private final ArrayList f = new ArrayList();
    private final ViewGroup g;
    private ao h = null;
    private an i = null;

    public ak(Context context) {
        super(context);
        setContentView(g.general__common_dialog_view);
        if (ReaderEnv.get().forHd()) {
            setGravity(17);
            ((BoxView) getContentView()).setMaxWidth(UTools.getMinimumHeight(getContext(), 380.0f));
        } else {
            setGravity(80);
        }
        this.a = (TextView) findViewById(com.duokan.b.f.general__common_dialog_view__title);
        this.a.getPaint().setFakeBoldText(true);
        this.b = (TextView) findViewById(com.duokan.b.f.general__common_dialog_view__prompt);
        this.c = (ViewGroup) findViewById(com.duokan.b.f.general__common_dialog_view__check_frame);
        this.e = (ViewGroup) findViewById(com.duokan.b.f.general__common_dialog_view__button_frame);
        this.g = (ViewGroup) findViewById(com.duokan.b.f.general__common_dialog_view__extra_content_frame);
        setWindowAttr();
    }

    public void setOnCheckStateChangedListener(ao aoVar) {
        this.h = aoVar;
    }

    public void setOnButtonClickedListener(an anVar) {
        this.i = anVar;
    }

    public void setTitle(int i) {
        this.a.setText(i);
        this.a.setVisibility(i == 0 ? 8 : 0);
    }

    public void setTitle(String str) {
        this.a.setText(str);
        this.a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setTitle(Drawable drawable) {
        this.a.setBackgroundDrawable(drawable);
        setTitle("  ");
    }

    public void setPrompt(int i) {
        this.b.setText(i);
        this.b.setVisibility(i == 0 ? 8 : 0);
    }

    public void setPrompt(String str) {
        this.b.setText(str);
        this.b.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setPromptLayoutGravity(int i) {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, (float) i);
        layoutParams.setMargins(0, UTools.getMinimumHeight(getContext(), 10.0f), 0, 0);
        this.b.setLayoutParams(layoutParams);
    }

    public int addButtonView(int i) {
        return addButtonView(getContext().getString(i), getContext().getResources().getColor(c.general__shared__c6));
    }

    public int addButtonView(int i, int i2) {
        return addButtonView(getContext().getString(i), i2);
    }

    public int addButtonView(String str, int i) {
        View newButtonFrameView = newButtonFrameView(newButtonView(str, i));
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        this.e.addView(newButtonFrameView, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.f.add(newButtonFrameView);
        scheduleButtonBackground();
        return this.f.size() - 1;
    }

    public int addCheckBoxView(int i) {
        return addCheckBoxView(getContext().getString(i));
    }

    public int addCheckBoxView(String str) {
        View newCheckFrameView = newCheckFrameView(newCheckBoxView(str));
        this.c.setVisibility(0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 3;
        this.c.addView(newCheckFrameView, layoutParams);
        this.d.add(newCheckFrameView);
        if (this.d.size() > 1) {
            ((MarginLayoutParams) newCheckFrameView.getLayoutParams()).topMargin = i.a(getContext(), 0.0f);
        }
        return this.d.size() - 1;
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
        this.g.removeAllViews();
        if (view != null) {
            this.g.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.g.setVisibility(0);
            return;
        }
        this.g.setVisibility(8);
    }

    public void setChecked(int i, boolean z) {
        getCheckBox(i).setChecked(z);
    }

    public boolean isChecked(int i) {
        return getCheckBox(i).isChecked();
    }

    protected TextView getButton(int i) {
        return (TextView) ((FrameLayout) this.f.get(i)).getChildAt(0);
    }

    protected void onCheckStateChanged(int i) {
    }

    protected void onButtonClicked(int i) {
    }

    private void setWindowAttr() {
        int b = UTools.getMinimumHeight(getContext(), 8.0f);
        getContentView().setBackgroundDrawable(new hm(new ColorDrawable(getContext().getResources().getColor(c.general__shared__dialog)), (float) b));
        if (ReaderEnv.get().forHd()) {
            setEnterAnimation(b.general__shared__scale_center_in);
            setExitAnimation(b.general__shared__scale_center_out);
            return;
        }
        setEnterAnimation(b.general__shared__push_down_in);
        setExitAnimation(b.general__shared__push_down_out);
    }

    private void scheduleButtonBackground() {
        if (this.f.size() == 1) {
            getButton(0).setBackgroundDrawable(new hm(getContext().getResources().getDrawable(e.general__shared__dialog_button_background), (float) UTools.getMinimumHeight(getContext(), 6.0f), 12));
            return;
        }
        getButton(0).setBackgroundDrawable(new hm(getContext().getResources().getDrawable(e.general__shared__dialog_button_background), (float) UTools.getMinimumHeight(getContext(), 6.0f), 4));
        getButton(this.f.size() - 1).setBackgroundDrawable(new hm(getContext().getResources().getDrawable(e.general__shared__dialog_button_background), (float) UTools.getMinimumHeight(getContext(), 6.0f), 8));
    }

    private FrameLayout newCheckFrameView(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, new FrameLayout.LayoutParams(-2, -1));
        return frameLayout;
    }

    private View newCheckBoxView(String str) {
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(g.general__common_check_box_view, null);
        checkBox.setText(str);
        checkBox.setOnCheckedChangeListener(new al(this));
        return checkBox;
    }

    private int getCheckIndex(View view) {
        for (int i = 0; i < this.d.size(); i++) {
            if (getCheckBox(i) == view) {
                return i;
            }
        }
        return -1;
    }

    private CheckBox getCheckBox(int i) {
        return (CheckBox) ((FrameLayout) this.d.get(i)).getChildAt(0);
    }

    private FrameLayout newButtonFrameView(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -2, 17));
        return frameLayout;
    }

    private View newButtonView(String str, int i) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(g.general__common_dialog_view__button, null);
        int b = UTools.getMinimumHeight(getContext(), 20.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setPadding(0, b, 0, b);
        textView.setBackgroundResource(e.general__shared__dialog_button_background);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setOnClickListener(new am(this));
        return textView;
    }

    private int getButtonIndex(View view) {
        for (int i = 0; i < this.f.size(); i++) {
            if (getButton(i) == view) {
                return i;
            }
        }
        return -1;
    }
}
