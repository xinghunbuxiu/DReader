package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

/* renamed from: com.duokan.reader.ui.welcome.n */
public class C1555n {
    /* renamed from: a */
    public String m15579a(Context context, UserInput userInput) {
        switch (C1556o.f11626a[userInput.ordinal()]) {
            case 1:
                return context.getString(C0247i.user_guide__create_book_category);
            case 2:
                return context.getString(C0247i.user_guide__do_book_mark);
            case 3:
                return context.getString(C0247i.user_guide__show_book_navigation);
            case 4:
                return context.getString(C0247i.user_guide__seek_reading_brightness);
            case 5:
                return context.getString(C0247i.user_guide__reading_show_option);
            case 6:
                return context.getString(C0247i.user_guide__reading_fast_operation);
            case 7:
                return context.getString(C0247i.user_guide__reading_show_cartoon);
            default:
                return "";
        }
    }

    /* renamed from: b */
    public Drawable m15583b(Context context, UserInput userInput) {
        switch (C1556o.f11626a[userInput.ordinal()]) {
            case 1:
                return context.getResources().getDrawable(C0243e.guide__shared__finger_00);
            case 2:
                return context.getResources().getDrawable(C0243e.guide__shared__finger_02);
            case 3:
                return context.getResources().getDrawable(C0243e.guide__shared__finger_03);
            case 4:
                return context.getResources().getDrawable(C0243e.guide__shared__finger_04);
            case 5:
                return context.getResources().getDrawable(C0243e.guide__shared__finger_05);
            case 6:
                return context.getResources().getDrawable(C0243e.guide__shared__finger_01);
            case 7:
                return context.getResources().getDrawable(C0243e.guide__shared__finger_05);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void m15580a(UserInput userInput, boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.USER_GUIDE, userInput.name(), z);
        ReaderEnv.get().commitPrefs();
    }

    /* renamed from: a */
    public boolean m15582a(UserInput userInput) {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.USER_GUIDE, userInput.name(), false);
    }

    /* renamed from: a */
    public void m15581a(UserInput[] userInputArr) {
        for (UserInput name : userInputArr) {
            ReaderEnv.get().setPrefBoolean(PrivatePref.USER_GUIDE, name.name(), false);
        }
        ReaderEnv.get().commitPrefs();
    }
}
