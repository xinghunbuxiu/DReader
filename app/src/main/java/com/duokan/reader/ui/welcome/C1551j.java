package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import java.util.HashMap;

/* renamed from: com.duokan.reader.ui.welcome.j */
public class C1551j implements C1550q {
    /* renamed from: a */
    private final Context f11617a;
    /* renamed from: b */
    private final C1555n f11618b = new C1555n();
    /* renamed from: c */
    private final UserInput[] f11619c = new UserInput[]{UserInput.CREATE_BOOK_CATEGORY, UserInput.DO_BOOK_MARK, UserInput.SHOW_BOOK_NAVIGATION, UserInput.SEEK_READING_BRIGHTNESS, UserInput.READING_SHOW_OPTION, UserInput.READING_FAST_OPERATION, UserInput.READING_SHOW_CARTOON};
    /* renamed from: d */
    private final HashMap<UserInput, UserInput> f11620d = new HashMap();
    /* renamed from: e */
    private C1547g f11621e = null;

    public C1551j(Context context) {
        this.f11617a = context;
        this.f11620d.put(UserInput.DO_BOOK_MARK_GESTURE_START, UserInput.DO_BOOK_MARK);
        this.f11620d.put(UserInput.SHOW_BOOK_NAVIGATION_GESTURE, UserInput.SHOW_BOOK_NAVIGATION);
        this.f11620d.put(UserInput.SEEK_READING_BRIGHTNESS_GESTURE, UserInput.SEEK_READING_BRIGHTNESS);
        this.f11620d.put(UserInput.READING_FAST_OPERATION_GESTURE, UserInput.READING_FAST_OPERATION);
        this.f11620d.put(UserInput.READING_SHOW_CARTOON_GESTURE, UserInput.READING_SHOW_CARTOON);
    }

    /* renamed from: a */
    public boolean mo2568a(Context context, UserInput userInput) {
        if (m15575a(userInput)) {
            boolean z;
            if (this.f11618b.m15582a(userInput)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        } else if (this.f11620d.get(userInput) != null) {
            m15576b((UserInput) this.f11620d.get(userInput));
            return false;
        } else if (userInput != UserInput.RESTORE_ALL_GUIDES) {
            return false;
        } else {
            m15574a();
            return false;
        }
    }

    /* renamed from: a */
    public View mo2567a(ViewGroup viewGroup, UserInput userInput) {
        if (this.f11621e != null || !m15575a(userInput) || this.f11618b.m15582a(userInput) || ReaderEnv.get().getBookOpenTimes() <= 5) {
            return null;
        }
        this.f11618b.m15580a(userInput, true);
        this.f11621e = m15573a(this.f11618b.m15579a(this.f11617a, userInput), this.f11618b.m15583b(this.f11617a, userInput), new C1552k(this, viewGroup));
        this.f11621e.setOnTouchListener(new C1553l(this));
        this.f11621e.setOnKeyListener(new C1554m(this));
        viewGroup.addView(this.f11621e, new LayoutParams(-1, -1));
        this.f11621e.mo2565a(5000);
        return this.f11621e;
    }

    /* renamed from: a */
    private boolean m15575a(UserInput userInput) {
        for (UserInput userInput2 : this.f11619c) {
            if (userInput == userInput2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m15576b(UserInput userInput) {
        this.f11618b.m15580a(userInput, true);
    }

    /* renamed from: a */
    private void m15574a() {
        this.f11618b.m15581a(this.f11619c);
    }

    /* renamed from: a */
    private C1547g m15573a(String str, Drawable drawable, Runnable runnable) {
        View dkLabelView = new DkLabelView(this.f11617a);
        dkLabelView.setText(str);
        dkLabelView.setTextColor(-1);
        dkLabelView.setGravity(17);
        dkLabelView.setTextSize(2, 18.0f);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        dkLabelView.setCompoundDrawables(drawable, null, null, null);
        dkLabelView.setBackgroundResource(C0243e.general__shared__guide_tips_bg);
        int round = Math.round(dkLabelView.getTextSize());
        dkLabelView.setPadding(round, round, round, round);
        C1547g c1547g = new C1547g(this.f11617a, runnable);
        c1547g.addView(dkLabelView, new LayoutParams(-2, -2, 17));
        return c1547g;
    }
}
