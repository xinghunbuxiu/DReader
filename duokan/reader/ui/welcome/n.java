package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.duokan.b.e;
import com.duokan.b.i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

public class n {
    public String a(Context context, UserInput userInput) {
        switch (o.a[userInput.ordinal()]) {
            case 1:
                return context.getString(i.user_guide__create_book_category);
            case 2:
                return context.getString(i.user_guide__do_book_mark);
            case 3:
                return context.getString(i.user_guide__show_book_navigation);
            case 4:
                return context.getString(i.user_guide__seek_reading_brightness);
            case 5:
                return context.getString(i.user_guide__reading_show_option);
            case 6:
                return context.getString(i.user_guide__reading_fast_operation);
            case 7:
                return context.getString(i.user_guide__reading_show_cartoon);
            default:
                return "";
        }
    }

    public Drawable b(Context context, UserInput userInput) {
        switch (o.a[userInput.ordinal()]) {
            case 1:
                return context.getResources().getDrawable(e.guide__shared__finger_00);
            case 2:
                return context.getResources().getDrawable(e.guide__shared__finger_02);
            case 3:
                return context.getResources().getDrawable(e.guide__shared__finger_03);
            case 4:
                return context.getResources().getDrawable(e.guide__shared__finger_04);
            case 5:
                return context.getResources().getDrawable(e.guide__shared__finger_05);
            case 6:
                return context.getResources().getDrawable(e.guide__shared__finger_01);
            case 7:
                return context.getResources().getDrawable(e.guide__shared__finger_05);
            default:
                return null;
        }
    }

    public void a(UserInput userInput, boolean z) {
        ReaderEnv.get().setPrefBoolean(PrivatePref.USER_GUIDE, userInput.name(), z);
        ReaderEnv.get().commitPrefs();
    }

    public boolean a(UserInput userInput) {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.USER_GUIDE, userInput.name(), false);
    }

    public void a(UserInput[] userInputArr) {
        for (UserInput name : userInputArr) {
            ReaderEnv.get().setPrefBoolean(PrivatePref.USER_GUIDE, name.name(), false);
        }
        ReaderEnv.get().commitPrefs();
    }
}
