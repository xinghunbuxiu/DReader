package com.duokan.reader.domain.tts;

public interface SpeakingListener {
    void onSpeakingCancel(String str);

    void onSpeakingEnd(String str);

    void onSpeakingError(int i, String str);

    void onSpeakingPaused(String str);

    void onSpeakingProgress(String str, int i, int i2, int i3);

    void onSpeakingResumed(String str);

    void onSpeakingStart(String str);
}
