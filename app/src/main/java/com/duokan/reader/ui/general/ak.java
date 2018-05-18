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

import com.duokan.common.CommonUtils;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.C0343f;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderEnv;

import java.util.ArrayList;

public class ak extends C0343f {

    private final TextView general__common_dialog_view__title;

    private final TextView common_dialog_view__prompt;

    private final ViewGroup common_dialog_view__check_frame;
    
    private final ArrayList<FrameLayout> checkFrameViews = new ArrayList();

    private final ViewGroup common_dialog_view__button_frame;
    
    private final ArrayList<FrameLayout> buttonFrameViews = new ArrayList();

    private final ViewGroup common_dialog_view__extra_content_frame;

    private OnCheckStateChangedListener checkStateChangedListener = null;

    private OnButtonClickedListener onButtonClickedListener = null;

    public ak(Context context) {
        super(context);
        setContentView(R.layout.general__common_dialog_view);
        if (ReaderEnv.get().forHd()) {
            setGravity(17);
            ((BoxView) getContentView()).setMaxWidth(AnimUtils.m1932b(getContext(), 380.0f));
        } else {
            setGravity(80);
        }
        this.general__common_dialog_view__title = (TextView) findViewById(R.id.general__common_dialog_view__title);
        this.general__common_dialog_view__title.getPaint().setFakeBoldText(true);
        this.common_dialog_view__prompt = (TextView) findViewById(R.id.general__common_dialog_view__prompt);
        this.common_dialog_view__check_frame = (ViewGroup) findViewById(R.id.general__common_dialog_view__check_frame);
        this.common_dialog_view__button_frame = (ViewGroup) findViewById(R.id.general__common_dialog_view__button_frame);
        this.common_dialog_view__extra_content_frame = (ViewGroup) findViewById(R.id.general__common_dialog_view__extra_content_frame);
        setWindowAttr();
    }

    public void setOnCheckStateChangedListener(OnCheckStateChangedListener checkStateChangedListener) {
        this.checkStateChangedListener = checkStateChangedListener;
    }

    public void setOnButtonClickedListener(OnButtonClickedListener onButtonClickedListener) {
        this.onButtonClickedListener = onButtonClickedListener;
    }

    public void setTitle(int resId) {
        this.general__common_dialog_view__title.setText(resId);
        this.general__common_dialog_view__title.setVisibility(resId == 0 ? View.GONE : View.VISIBLE);
    }

    public void setTitle(String str) {
        this.general__common_dialog_view__title.setText(str);
        this.general__common_dialog_view__title.setVisibility(TextUtils.isEmpty(str) ? View.GONE : View.VISIBLE);
    }

    public void setTitle(Drawable drawable) {
        this.general__common_dialog_view__title.setBackgroundDrawable(drawable);
        setTitle("  ");
    }

    public void setPrompt(int prompt) {
        this.common_dialog_view__prompt.setText(prompt);
        this.common_dialog_view__prompt.setVisibility(prompt == 0 ? View.GONE : View.VISIBLE);
    }

    public void setPrompt(String str) {
        this.common_dialog_view__prompt.setText(str);
        this.common_dialog_view__prompt.setVisibility(TextUtils.isEmpty(str) ? View.GONE : View.VISIBLE);
    }

    public void setPromptLayoutGravity(int weight) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, weight);
        layoutParams.setMargins(0, AnimUtils.m1932b(getContext(), 10.0f), 0, 0);
        this.common_dialog_view__prompt.setLayoutParams(layoutParams);
    }

    public int addButtonView(int resId) {
        return addButtonView(getContext().getString(resId), getContext().getResources().getColor(R.color.general__shared__c6));
    }

    public int addButtonView(int i, int i2) {
        return addButtonView(getContext().getString(i), i2);
    }

    public int addButtonView(String str, int i) {
        FrameLayout newButtonFrameView = newButtonFrameView(newButtonView(str, i));
        if (this.common_dialog_view__button_frame.getVisibility() != 0) {
            this.common_dialog_view__button_frame.setVisibility(0);
        }
        this.common_dialog_view__button_frame.addView(newButtonFrameView, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.buttonFrameViews.add(newButtonFrameView);
        scheduleButtonBackground();
        return this.buttonFrameViews.size() - 1;
    }

    public int addCheckBoxView(int i) {
        return addCheckBoxView(getContext().getString(i));
    }

    public int addCheckBoxView(String str) {
        FrameLayout newCheckFrameView = newCheckFrameView(newCheckBoxView(str));
        this.common_dialog_view__check_frame.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        layoutParams.gravity = 3;
        this.common_dialog_view__check_frame.addView(newCheckFrameView, layoutParams);
        this.checkFrameViews.add(newCheckFrameView);
        if (this.checkFrameViews.size() > 1) {
            ((MarginLayoutParams) newCheckFrameView.getLayoutParams()).topMargin = CommonUtils.dip2px(getContext(), 0.0f);
        }
        return this.checkFrameViews.size() - 1;
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
        this.common_dialog_view__extra_content_frame.removeAllViews();
        if (view != null) {
            this.common_dialog_view__extra_content_frame.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.common_dialog_view__extra_content_frame.setVisibility(0);
            return;
        }
        this.common_dialog_view__extra_content_frame.setVisibility(8);
    }

    public void setChecked(int i, boolean z) {
        getCheckBox(i).setChecked(z);
    }

    public boolean isChecked(int i) {
        return getCheckBox(i).isChecked();
    }

    protected TextView getButton(int i) {
        return (TextView) ((FrameLayout) this.buttonFrameViews.get(i)).getChildAt(0);
    }

    protected void onCheckStateChanged(int i) {
    }

    protected void onButtonClicked(int i) {
    }

    private void setWindowAttr() {
        int b = AnimUtils.m1932b(getContext(), 8.0f);
        getContentView().setBackgroundDrawable(new hb(new ColorDrawable(getContext().getResources().getColor(C0241c.general__shared__dialog)), (float) b));
        if (ReaderEnv.get().forHd()) {
            setEnterAnimation(R.anim.general__shared__scale_center_in);
            setExitAnimation(R.anim.general__shared__scale_center_out);
            return;
        }
        setEnterAnimation(R.anim.general__shared__push_down_in);
        setExitAnimation(R.anim.general__shared__push_down_out);
    }

    private void scheduleButtonBackground() {
        if (this.buttonFrameViews.size() == 1) {
            getButton(0).setBackgroundDrawable(new hb(getContext().getResources().getDrawable(R.drawable.general__shared__dialog_button_background), (float) AnimUtils.m1932b(getContext(), 6.0f), 12));
            return;
        }
        getButton(0).setBackgroundDrawable(new hb(getContext().getResources().getDrawable(R.drawable.general__shared__dialog_button_background), (float) AnimUtils.m1932b(getContext(), 6.0f), 4));
        getButton(this.buttonFrameViews.size() - 1).setBackgroundDrawable(new hb(getContext().getResources().getDrawable(R.drawable.general__shared__dialog_button_background), (float) AnimUtils.m1932b(getContext(), 6.0f), 8));
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
        for (int i = 0; i < this.checkFrameViews.size(); i++) {
            if (getCheckBox(i) == view) {
                return i;
            }
        }
        return -1;
    }

    private CheckBox getCheckBox(int i) {
        return (CheckBox) ((FrameLayout) this.checkFrameViews.get(i)).getChildAt(0);
    }

    private FrameLayout newButtonFrameView(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -2, 17));
        return frameLayout;
    }

    private View newButtonView(String str, int i) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.luout.general__common_dialog_view__button, null);
        int b = AnimUtils.m1932b(getContext(), 20.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setPadding(0, b, 0, b);
        textView.setBackgroundResource(R.luout.general__shared__dialog_button_background);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setOnClickListener(new am(this));
        return textView;
    }

    private int getButtonIndex(View view) {
        for (int i = 0; i < this.buttonFrameViews.size(); i++) {
            if (getButton(i) == view) {
                return i;
            }
        }
        return -1;
    }
}
