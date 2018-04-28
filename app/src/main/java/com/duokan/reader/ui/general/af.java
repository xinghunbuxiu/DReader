package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.ui.C0343f;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ReaderEnv;

public class af extends C0343f {
    private static int mDialogHeight = 0;
    private static int mDialogWidth = 0;
    private final FrameLayout mContentContainer = new FrameLayout(getContext());
    private View mContentView = null;
    private Drawable mDefaultHdBgDrawable = null;

    public af(Context context) {
        super(new ah(context));
        initContent(this.mContentContainer);
        super.setContentView(this.mContentContainer);
        setEnterAnimation(ReaderEnv.get().forHd() ? C0240b.general__shared__scale_center_in : C0240b.general__shared__push_down_in);
        setExitAnimation(ReaderEnv.get().forHd() ? C0240b.general__shared__scale_center_out : C0240b.general__shared__push_down_out);
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(getContext()).inflate(i, this.mContentContainer, false));
    }

    public void setContentView(View view) {
        setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new LayoutParams(-1, -1));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (this.mContentView != null) {
            this.mContentContainer.removeView(this.mContentView);
            this.mContentView = null;
        }
        if (view != null) {
            this.mContentView = view;
            this.mContentContainer.addView(this.mContentView, 0, layoutParams);
        }
    }

    public void show() {
        super.show();
        UIdleHandler.addIdleHandler(new ag(this));
    }

    public void dismiss() {
        View focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            ReaderUi.m10161a(getContext(), focusedEditText);
        }
        super.dismiss();
    }

    protected EditText getFocusedEditText() {
        return getFocusedEditTextOfView(this.mContentContainer);
    }

    private boolean hasFocusableEditText(View view) {
        int i = 0;
        if (!(view instanceof ViewGroup)) {
            return (view instanceof EditText) && view.isFocusable() && view.isShown();
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            boolean z = false;
            while (i < viewGroup.getChildCount()) {
                z = hasFocusableEditText(viewGroup.getChildAt(i));
                if (z) {
                    return z;
                }
                i++;
            }
            return z;
        }
    }

    private EditText getFocusedEditTextOfView(View view) {
        EditText editText = null;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                editText = getFocusedEditTextOfView(viewGroup.getChildAt(i));
                if (editText != null) {
                    return editText;
                }
            }
            return editText;
        } else if ((view instanceof EditText) && view.isFocused()) {
            return (EditText) view;
        } else {
            return null;
        }
    }

    public void setContentBackgroundColor(int i) {
        if (ReaderEnv.get().forHd()) {
            this.mContentContainer.setBackgroundDrawable(new hc((float) dv.m1932b(getContext(), 7.0f), (float) dv.m1932b(getContext(), 7.0f), i));
            return;
        }
        this.mContentContainer.setBackgroundColor(i);
    }

    public void setContentBackgroundResources(int i) {
        this.mContentContainer.setBackgroundResource(i);
    }

    protected void initContent(FrameLayout frameLayout) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (ReaderEnv.get().forHd()) {
            this.mDefaultHdBgDrawable = frameLayout.getResources().getDrawable(C0243e.general__shared__center_dialog_bg);
            frameLayout.setBackgroundDrawable(this.mDefaultHdBgDrawable);
            initHdContent(frameLayout, layoutParams);
        } else {
            frameLayout.setBackgroundColor(getContext().getResources().getColor(C0241c.general__shared__ffffff));
        }
        frameLayout.setLayoutParams(layoutParams);
    }

    protected void initHdContent(FrameLayout frameLayout, FrameLayout.LayoutParams layoutParams) {
        if (mDialogWidth == 0) {
            Point a = ReaderUi.m10155a(getActivity());
            mDialogWidth = a.x;
            mDialogHeight = a.y;
        }
        layoutParams.width = mDialogWidth;
        layoutParams.height = mDialogHeight;
    }

    public static void initCenterDialogHeaderStyle(HeaderView headerView) {
        if (ReaderEnv.get().forHd()) {
            headerView.setBackgroundColor(0);
            headerView.setTitleTextColor(headerView.getResources().getColor(C0241c.general__shared__666666));
            headerView.setTitleTextSize((float) headerView.getResources().getDimensionPixelSize(C0242d.general_font__shared__c));
        }
    }

    public static void initWebViewCenterDialog(af afVar, WebView webView) {
        initWebViewCenterDialog(afVar, webView, webView.getContext().getResources().getColor(C0241c.general__shared__ebebeb));
    }

    public static void initWebViewCenterDialog(af afVar, WebView webView, int i) {
        initCenterDialogWebViewBg(webView, i);
        afVar.setContentBackgroundColor(i);
    }

    public static void initCenterDialogWebViewBg(WebView webView, int i) {
        if (ReaderEnv.get().forHd()) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webView.getLayoutParams();
            marginLayoutParams.bottomMargin = dv.m1932b(webView.getContext(), 7.0f);
            webView.setLayoutParams(marginLayoutParams);
        }
        webView.setBackgroundColor(i);
    }
}
