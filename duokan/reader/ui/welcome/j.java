package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

import java.util.HashMap;

public class j implements q {
    private final Context a;
    private final n b = new n();
    private final UserInput[] c = new UserInput[]{UserInput.CREATE_BOOK_CATEGORY, UserInput.DO_BOOK_MARK, UserInput.SHOW_BOOK_NAVIGATION, UserInput.SEEK_READING_BRIGHTNESS, UserInput.READING_SHOW_OPTION, UserInput.READING_FAST_OPERATION, UserInput.READING_SHOW_CARTOON};
    private final HashMap d = new HashMap();
    private g e = null;

    public j(Context context) {
        this.a = context;
        this.d.put(UserInput.DO_BOOK_MARK_GESTURE_START, UserInput.DO_BOOK_MARK);
        this.d.put(UserInput.SHOW_BOOK_NAVIGATION_GESTURE, UserInput.SHOW_BOOK_NAVIGATION);
        this.d.put(UserInput.SEEK_READING_BRIGHTNESS_GESTURE, UserInput.SEEK_READING_BRIGHTNESS);
        this.d.put(UserInput.READING_FAST_OPERATION_GESTURE, UserInput.READING_FAST_OPERATION);
        this.d.put(UserInput.READING_SHOW_CARTOON_GESTURE, UserInput.READING_SHOW_CARTOON);
    }

    public boolean a(Context context, UserInput userInput) {
        if (a(userInput)) {
            boolean z;
            if (this.b.a(userInput)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        } else if (this.d.get(userInput) != null) {
            b((UserInput) this.d.get(userInput));
            return false;
        } else if (userInput != UserInput.RESTORE_ALL_GUIDES) {
            return false;
        } else {
            a();
            return false;
        }
    }

    public View a(ViewGroup viewGroup, UserInput userInput) {
        if (this.e != null || !a(userInput) || this.b.a(userInput) || ReaderEnv.get().getBookOpenTimes() <= 5) {
            return null;
        }
        this.b.a(userInput, true);
        this.e = a(this.b.a(this.a, userInput), this.b.b(this.a, userInput), new k(this, viewGroup));
        this.e.setOnTouchListener(new l(this));
        this.e.setOnKeyListener(new m(this));
        viewGroup.addView(this.e, new LayoutParams(-1, -1));
        this.e.a(5000);
        return this.e;
    }

    private boolean a(UserInput userInput) {
        for (UserInput userInput2 : this.c) {
            if (userInput == userInput2) {
                return true;
            }
        }
        return false;
    }

    private void b(UserInput userInput) {
        this.b.a(userInput, true);
    }

    private void a() {
        this.b.a(this.c);
    }

    private g a(String str, Drawable drawable, Runnable runnable) {
        View dkLabelView = new DkLabelView(this.a);
        dkLabelView.setText(str);
        dkLabelView.setTextColor(-1);
        dkLabelView.setGravity(17);
        dkLabelView.setTextSize(2, 18.0f);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        dkLabelView.setCompoundDrawables(drawable, null, null, null);
        dkLabelView.setBackgroundResource(e.general__shared__guide_tips_bg);
        int round = Math.round(dkLabelView.getTextSize());
        dkLabelView.setPadding(round, round, round, round);
        g gVar = new g(this.a, runnable);
        gVar.addView(dkLabelView, new LayoutParams(-2, -2, 17));
        return gVar;
    }
}
