package com.duokan.core.app;

public interface Inavigate {
    boolean navigate(String str, Object obj, boolean z, Runnable runnable);

    boolean navigateSmoothly(String str);
}
