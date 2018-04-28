package com.duokan.reader.domain.umeng;

import android.content.Context;
import java.util.HashMap;

public interface UmengAgent {
    void onEvent(Context context, String str);

    void onEvent(Context context, String str, String str2);

    void onEvent(Context context, String str, HashMap<String, String> hashMap);

    void onPause(Context context);

    void onResume(Context context);

    void reportError(Context context, String str);

    void setDebugMode(boolean z);
}
