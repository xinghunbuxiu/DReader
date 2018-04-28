package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.duokan.reader.DkApp;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class cn {
    /* renamed from: a */
    private static Map<Integer, co> f7036a = new HashMap();

    /* renamed from: a */
    public static Drawable m10370a(Context context, int i) {
        Bitmap bitmap;
        Drawable cpVar;
        Throwable th;
        Resources resources = context.getResources();
        if (!DkApp.get().forHd()) {
            return resources.getDrawable(i);
        }
        if (f7036a.containsKey(Integer.valueOf(i))) {
            co coVar = (co) f7036a.get(Integer.valueOf(i));
            return new cp(coVar.f7037a, coVar.f7038b);
        }
        Rect rect = new Rect();
        InputStream openRawResource;
        try {
            TypedValue typedValue = new TypedValue();
            openRawResource = resources.openRawResource(i, typedValue);
            try {
                Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, openRawResource, rect, null);
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (IOException e) {
                        bitmap = decodeResourceStream;
                    }
                }
                bitmap = decodeResourceStream;
            } catch (Exception e2) {
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (IOException e3) {
                        bitmap = null;
                    }
                }
                bitmap = null;
                if (bitmap != null) {
                    return null;
                }
                cpVar = new cp(bitmap, rect);
                f7036a.put(Integer.valueOf(i), new co(bitmap, rect));
                return cpVar;
            } catch (Throwable th2) {
                th = th2;
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            openRawResource = null;
            if (openRawResource != null) {
                openRawResource.close();
            }
            bitmap = null;
            if (bitmap != null) {
                return null;
            }
            cpVar = new cp(bitmap, rect);
            f7036a.put(Integer.valueOf(i), new co(bitmap, rect));
            return cpVar;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openRawResource = null;
            th = th4;
            if (openRawResource != null) {
                openRawResource.close();
            }
            throw th;
        }
        if (bitmap != null) {
            return null;
        }
        cpVar = new cp(bitmap, rect);
        f7036a.put(Integer.valueOf(i), new co(bitmap, rect));
        return cpVar;
    }
}
