package com.duokan.reader.ui.general;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public abstract class ReaderUi extends dv {

    public enum ScreenType {
        SMALL,
        MEDIUM,
        LARGE,
        XLARGE,
        XXLARGE
    }

    /* renamed from: a */
    public static int m10153a(Activity activity, int i) {
        if (activity == null) {
            return -1;
        }
        if (VERSION.SDK_INT < 18) {
            switch (i) {
                case 11:
                    i = 6;
                    break;
                case 12:
                    i = 7;
                    break;
            }
        }
        int requestedOrientation = activity.getRequestedOrientation();
        activity.setRequestedOrientation(i);
        return requestedOrientation;
    }

    /* renamed from: a */
    public static int m10154a(Context context, int i, float f) {
        if (Float.compare(f, 1.0f) >= 0) {
            return 0;
        }
        if (DkPublic.isLandscape(context)) {
            return i / 2;
        }
        int max = Math.max(Math.round(((float) i) * f), dv.m1932b(context, 420.0f));
        return max > i - dv.m1932b(context, 40.0f) ? dv.m1932b(context, 40.0f) : i - max;
    }

    /* renamed from: c */
    public static int m10165c(Context context, int i) {
        float dimension = context.getResources().getDimension(C0242d.general__shared__cover_grid_space);
        return Math.max(Math.round((((float) i) + dimension) / (dimension + context.getResources().getDimension(C0242d.general__shared__cover_grid_width))), 3);
    }

    /* renamed from: d */
    public static int m10168d(Context context, int i) {
        int c = m10165c(context, i);
        return (i - (((int) Math.ceil((double) context.getResources().getDimension(C0242d.general__shared__cover_grid_space))) * (c - 1))) / c;
    }

    /* renamed from: a */
    public static ef m10157a(DkWebListView dkWebListView) {
        return new gz(dkWebListView);
    }

    /* renamed from: a */
    public static void m10162a(Context context, EditText editText) {
        if (context != null && editText != null) {
            editText.requestFocus();
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    /* renamed from: a */
    public static void m10161a(Context context, View view) {
        if (context != null && view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        }
    }

    /* renamed from: a */
    public static String m10160a(String str) {
        if (Pattern.compile("^\\w+(\\.*\\+*-*\\w\\+*\\.*)*@(\\w+-*\\w*\\.){1,10}[a-zA-Z]{2,6}$").matcher(str).find()) {
            return str.split("@")[0] + "@...";
        }
        return str;
    }

    /* renamed from: a */
    public static String m10158a(Context context, long j) {
        return m10159a(context, j, true);
    }

    /* renamed from: a */
    public static String m10159a(Context context, long j, boolean z) {
        String str = "";
        Date date = new Date();
        Date date2 = new Date(j);
        if (z) {
            long time = date.getTime() - date2.getTime();
            if (time < 60000) {
                str = context.getString(C0247i.general__shared__within_1minutes);
            } else if (time < 259200000) {
                str = context.getString(C0247i.general__shared__before_s, new Object[]{m10163b(context, time)});
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (date.getYear() == date2.getYear()) {
            return new SimpleDateFormat("MM-dd").format(date2);
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date2);
    }

    /* renamed from: b */
    public static String m10163b(Context context, long j) {
        if (j / 86400000 > 0) {
            return context.getString(C0247i.general__shared__d_days, new Object[]{Integer.valueOf((int) r0)});
        }
        if (j / 3600000 > 0) {
            return context.getString(C0247i.general__shared__d_hours, new Object[]{Integer.valueOf((int) r0)});
        }
        if (j / 60000 <= 0) {
            return context.getString(C0247i.general__shared__within_1minutes);
        }
        return context.getString(C0247i.general__shared__d_minutes, new Object[]{Integer.valueOf((int) r0)});
    }

    /* renamed from: b */
    public static void m10164b(View view, int i) {
        Rect rect = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        view.setBackgroundResource(i);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: c */
    public static String m10166c(Context context, long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        if (currentTimeMillis <= 0) {
            return "";
        }
        if (currentTimeMillis < 900000) {
            return context.getString(C0247i.general__shared__timed_reading_nearly_over);
        }
        String format;
        if (currentTimeMillis < 3600000) {
            format = String.format(context.getString(C0247i.general__shared__d_minutes), new Object[]{Long.valueOf(currentTimeMillis / 60000)});
            return String.format(context.getString(C0247i.general__shared__timed_reading_left), new Object[]{format});
        } else if (currentTimeMillis < 86400000) {
            format = String.format(context.getString(C0247i.general__shared__d_hours), new Object[]{Long.valueOf(currentTimeMillis / 3600000)});
            return String.format(context.getString(C0247i.general__shared__timed_reading_left), new Object[]{format});
        } else {
            format = String.format(context.getString(C0247i.general__shared__d_days), new Object[]{Long.valueOf(currentTimeMillis / 86400000)});
            return String.format(context.getString(C0247i.general__shared__timed_reading_left), new Object[]{format});
        }
    }

    /* renamed from: c */
    public static void m10167c(View view, int i) {
        if (i == 0) {
            view.setVisibility(8);
        } else {
            Drawable background = view.getBackground();
            if (background == null || !(background instanceof er)) {
                background = new er(view.getContext());
                view.setBackgroundDrawable(background);
            }
            ((er) background).m10570a("" + i);
            view.setVisibility(0);
        }
        view.invalidate();
    }

    /* renamed from: a */
    public static Point m10155a(Activity activity) {
        if (!ReaderEnv.get().forHd()) {
            return new Point(-1, -1);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int b = (displayMetrics.widthPixels > displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels) - dv.m1932b((Context) activity, 30.0f);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(C0242d.general__shared__max_center_dialog_width_at_hd);
        if (dimensionPixelSize > b) {
            dimensionPixelSize = b;
        }
        int i = (dimensionPixelSize * 4) / 3;
        if (i <= b) {
            b = i;
        }
        return new Point(dimensionPixelSize, b);
    }

    /* renamed from: a */
    public static final SpannableString m10156a(String str, String str2, int i) {
        SpannableString spannableString = new SpannableString(str);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return spannableString;
        }
        int i2 = 0;
        do {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf == -1) {
                break;
            }
            i2 = str2.length() + indexOf;
            spannableString.setSpan(new ForegroundColorSpan(i), indexOf, i2, 33);
        } while (i2 < str.length());
        return spannableString;
    }

    /* renamed from: l */
    public static ScreenType m10169l(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double sqrt = Math.sqrt(Math.pow((double) (((float) displayMetrics.heightPixels) / dv.m1967i(context)), 2.0d) + Math.pow((double) (((float) displayMetrics.widthPixels) / dv.m1965h(context)), 2.0d));
        if (Double.compare(sqrt, 4.5d) <= 0) {
            return ScreenType.SMALL;
        }
        if (Double.compare(sqrt, 5.2d) <= 0) {
            return ScreenType.MEDIUM;
        }
        if (Double.compare(sqrt, 6.5d) <= 0) {
            return ScreenType.LARGE;
        }
        if (Double.compare(sqrt, 8.0d) <= 0) {
            return ScreenType.XLARGE;
        }
        return ScreenType.XXLARGE;
    }

    /* renamed from: m */
    public static boolean m10170m(Context context) {
        ScreenType l = m10169l(context);
        return l == ScreenType.XXLARGE || l == ScreenType.XLARGE;
    }
}
