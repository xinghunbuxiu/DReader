package com.duokan.reader.domain.tts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import java.util.LinkedList;

public class TtsEngineIflytek {
    public static final int ERROR_AUTH_EXPIRED = 11200;
    public static final int ERROR_LOCAL_ENGINE_ERROR = 24000;
    public static final int ERROR_LOCAL_ENGINE_UNINIT = 24007;
    public static final int ERROR_NETWORK_CONNECTION_ERROR = 10114;
    public static final int ERROR_NETWORK_CONNECTION_ERROR_ANDROID = 20002;
    public static final int ERROR_NETWORK_ERROR = 20001;
    public static final int ERROR_NETWORK_HTTP_ERROR = 20003;
    public static final int ERROR_NETWORK_RECEIVE_ERROR = 10205;
    public static final int ERROR_NETWORK_SEND_ERROR = 10204;
    public static final int ERROR_NETWORK_SOCKET_ERROR = 10202;
    private static boolean sInitDone = false;
    private static SpeechSynthesizer sSpeechSynthesizer = null;
    private static SpeechUtility sSpeechUtility = null;
    private Context mContext;
    private final LinkedList<Runnable> mDelayedRunList = new LinkedList();
    private boolean mEngineIniting = false;
    private TtsTask mRunningTask = null;
    private TtsSpeaker mSpeaker = new TtsSpeaker("");
    private float mSpeed = 1.0f;

    /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$2 */
    class C11972 implements Runnable {
        C11972() {
        }

        public void run() {
            if (TtsEngineIflytek.this.mRunningTask != null) {
                TtsEngineIflytek.sSpeechSynthesizer.stopSpeaking();
                TtsTask access$000 = TtsEngineIflytek.this.mRunningTask;
                TtsEngineIflytek.this.mRunningTask = null;
                access$000.discard = true;
                if (!access$000.ended) {
                    access$000.onTaskCancel();
                }
            }
        }
    }

    /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$3 */
    class C11983 implements Runnable {
        C11983() {
        }

        public void run() {
            TtsEngineIflytek.sSpeechSynthesizer.resumeSpeaking();
        }
    }

    /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$4 */
    class C11994 implements Runnable {
        C11994() {
        }

        public void run() {
            TtsEngineIflytek.sSpeechSynthesizer.pauseSpeaking();
        }
    }

    /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$5 */
    class C12005 implements Runnable {
        C12005() {
        }

        public void run() {
            if (TtsEngineIflytek.this.mRunningTask == null) {
                TtsEngineIflytek.this.setupEngine(TtsEngineIflytek.this.mSpeaker, TtsEngineIflytek.this.mSpeed);
                return;
            }
            if (!(TtsEngineIflytek.this.mRunningTask.speaker.equals(TtsEngineIflytek.this.mSpeaker) && Float.compare(TtsEngineIflytek.this.mRunningTask.speed, TtsEngineIflytek.this.mSpeed) == 0)) {
                TtsEngineIflytek.this.setupEngine(TtsEngineIflytek.this.mSpeaker, TtsEngineIflytek.this.mSpeed);
            }
            TtsEngineIflytek.this.mRunningTask.discard = true;
            TtsEngineIflytek.this.mRunningTask = new TtsTask(TtsEngineIflytek.this.mRunningTask);
            TtsEngineIflytek.this.startTask(TtsEngineIflytek.this.mRunningTask);
        }
    }

    /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$6 */
    class C12016 implements ag<String> {
        C12016() {
        }

        public void run(String str) {
            TtsEngineIflytek.this.mEngineIniting = false;
            TtsEngineIflytek.sSpeechUtility = SpeechUtility.createUtility(TtsEngineIflytek.this.mContext, "appid=" + TtsManager.get().getTtsAppKey() + ",server_url=http://duokan.openspeech.cn/msp.do" + (TextUtils.isEmpty(str) ? "" : ",auth_id=" + TtsManager.get().getEncryptUserId(str)));
            if (TtsEngineIflytek.sSpeechUtility == null) {
                WebLog.init().c(LogLevel.ERROR, "vflynote", "fail to create a SpeechUtility");
            } else if (TtsEngineIflytek.sSpeechSynthesizer == null) {
                TtsEngineIflytek.sSpeechSynthesizer = SpeechSynthesizer.createSynthesizer(TtsEngineIflytek.this.mContext, null);
                TtsEngineIflytek.sInitDone = true;
                TtsEngineIflytek.this.setupEngine(TtsEngineIflytek.this.mSpeaker, TtsEngineIflytek.this.mSpeed);
                while (!TtsEngineIflytek.this.mDelayedRunList.isEmpty()) {
                    ((Runnable) TtsEngineIflytek.this.mDelayedRunList.poll()).run();
                }
            }
        }
    }

    class TtsTask implements SynthesizerListener {
        public boolean discard = false;
        public boolean ended = false;
        public SpeakingListener listener = null;
        public final TtsSpeaker speaker;
        public final float speed;
        public final String text;

        /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$TtsTask$2 */
        class C12072 implements Runnable {
            C12072() {
            }

            public void run() {
                if (TtsTask.this.listener != null) {
                    TtsTask.this.listener.onSpeakingResumed(TtsTask.this.text);
                }
            }
        }

        /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$TtsTask$3 */
        class C12083 implements Runnable {
            C12083() {
            }

            public void run() {
                if (TtsTask.this.listener != null) {
                    TtsTask.this.listener.onSpeakingPaused(TtsTask.this.text);
                }
            }
        }

        public TtsTask(String str, SpeakingListener speakingListener) {
            this.text = str;
            this.speaker = TtsEngineIflytek.this.mSpeaker;
            this.speed = TtsEngineIflytek.this.mSpeed;
            this.listener = speakingListener;
        }

        public TtsTask(TtsTask ttsTask) {
            this.text = ttsTask.text;
            this.speaker = TtsEngineIflytek.this.mSpeaker;
            this.speed = TtsEngineIflytek.this.mSpeed;
            this.ended = ttsTask.ended;
            this.listener = ttsTask.listener;
        }

        public void onCompleted(final SpeechError speechError) {
            UThread.runOnThread(new Runnable() {

                /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$TtsTask$1$1 */
                class C12051 implements Runnable {
                    C12051() {
                    }

                    public void run() {
                        TtsTask.this.onCompleted(null);
                    }
                }

                public void run() {
                    if (!TtsTask.this.discard) {
                        if (speechError != null) {
                            if (speechError.getErrorCode() == 20009) {
                                TtsTask.this.onSpeakBegin();
                                UThread.post(new C12051());
                                return;
                            }
                            TtsTask.this.onTaskError(speechError.getErrorCode(), speechError.getPlainDescription(true));
                        } else if (!TtsTask.this.ended) {
                            TtsTask.this.ended = true;
                            TtsTask.this.onTaskEnd();
                        }
                    }
                }
            });
        }

        public void onSpeakBegin() {
        }

        public void onSpeakResumed() {
            TtsEngineIflytek.this.safeRun(new C12072());
        }

        public void onSpeakPaused() {
            TtsEngineIflytek.this.safeRun(new C12083());
        }

        public void onSpeakProgress(final int i, final int i2, final int i3) {
            TtsEngineIflytek.this.safeRun(new Runnable() {
                public void run() {
                    if (TtsTask.this.listener != null) {
                        TtsTask.this.listener.onSpeakingProgress(TtsTask.this.text, i, i2, i3);
                    }
                }
            });
        }

        public void onBufferProgress(int i, int i2, int i3, String str) {
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
        }

        protected void onTaskBegin() {
            if (this.listener != null) {
                this.listener.onSpeakingStart(this.text);
            }
        }

        protected void onTaskEnd() {
            if (TtsEngineIflytek.this.mRunningTask == this) {
                TtsEngineIflytek.this.mRunningTask = null;
            }
            if (this.listener != null) {
                this.listener.onSpeakingEnd(this.text);
                this.listener = null;
            }
        }

        protected void onTaskCancel() {
            if (TtsEngineIflytek.this.mRunningTask == this) {
                TtsEngineIflytek.this.mRunningTask = null;
            }
            if (this.listener != null) {
                this.listener.onSpeakingCancel(this.text);
                this.listener = null;
            }
        }

        protected void onTaskError(int i, String str) {
            if (TtsEngineIflytek.this.mRunningTask == this) {
                TtsEngineIflytek.this.mRunningTask = null;
            }
            if (this.listener != null) {
                this.listener.onSpeakingError(i, str);
                this.listener = null;
            }
        }
    }

    public TtsEngineIflytek(Context context) {
        if (this.mContext == null) {
            synchronized (TtsEngineIflytek.class) {
                this.mContext = context.getApplicationContext();
                startEngine();
            }
        }
    }

    public boolean isSpeaking() {
        return this.mRunningTask != null;
    }

    public boolean startSpeaking(final String str, final SpeakingListener speakingListener) {
        if (str == null) {
            return false;
        }
        safeRun(new Runnable() {
            public void run() {
                if (TtsEngineIflytek.this.mRunningTask != null) {
                    TtsTask access$000 = TtsEngineIflytek.this.mRunningTask;
                    TtsEngineIflytek.this.mRunningTask = null;
                    access$000.discard = true;
                    if (!access$000.ended) {
                        access$000.onTaskCancel();
                    }
                }
                if (TtsEngineIflytek.this.mRunningTask == null) {
                    TtsEngineIflytek.this.mRunningTask = new TtsTask(str, speakingListener);
                    TtsEngineIflytek.this.startTask(TtsEngineIflytek.this.mRunningTask);
                }
            }
        });
        return true;
    }

    public void stopSpeaking() {
        safeRun(new C11972());
    }

    public void resumeSpeaking() {
        safeRun(new C11983());
    }

    public void pauseSpeaking() {
        safeRun(new C11994());
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
        applySettings();
    }

    public TtsSpeaker getSpeaker() {
        return this.mSpeaker;
    }

    public void setSpeaker(TtsSpeaker ttsSpeaker) {
        if (!ttsSpeaker.isEmpty()) {
            this.mSpeaker = ttsSpeaker;
            applySettings();
        }
    }

    private void applySettings() {
        safeRun(new C12005());
    }

    private void setupEngine(TtsSpeaker ttsSpeaker, float f) {
        WebLog.init().w();
        sSpeechSynthesizer.setParameter("voice_lang", "1");
        sSpeechSynthesizer.setParameter("voice_name", ttsSpeaker.mName);
        sSpeechSynthesizer.setParameter("voice_id", ttsSpeaker.mId);
        sSpeechSynthesizer.setParameter("speed", "" + Math.max(0, Math.min(Math.round(50.0f * f), 100)));
        sSpeechSynthesizer.setParameter("pitch", "50");
        if (ttsSpeaker.mEngineType.equals("local")) {
            sSpeechSynthesizer.setParameter("engine_type", "local");
            sSpeechSynthesizer.setParameter("tts_res_path", ttsSpeaker.mSpeakerPath);
        } else {
            sSpeechSynthesizer.setParameter("engine_type", "cloud");
            sSpeechSynthesizer.setParameter("tts_res_path", "");
        }
        sSpeechSynthesizer.setParameter("ent", ttsSpeaker.mEnt);
    }

    public void startEngine() {
        WebLog.init().w();
        if (!this.mEngineIniting) {
            this.mEngineIniting = true;
            if (sSpeechUtility == null) {
                WebLog.init().c(LogLevel.INFO, "vflynote", "start engine");
            } else {
                WebLog.init().c(LogLevel.INFO, "vflynote", "restart engine");
                if (sSpeechSynthesizer != null) {
                    sSpeechSynthesizer.destroy();
                    sSpeechSynthesizer = null;
                }
                sSpeechUtility.destroy();
                sSpeechUtility = null;
                sInitDone = false;
            }
            TtsManager.get().queryTtsUserId(new C12016());
        }
    }

    private void startTask(final TtsTask ttsTask) {
        WebLog.init().w();
        if (sSpeechSynthesizer == null || sSpeechSynthesizer.startSpeaking(ttsTask.text, ttsTask) == 0) {
            ttsTask.onTaskBegin();
            return;
        }
        WebLog.init().a(LogLevel.ERROR, "vflynote", "fail to start speaking, try to restart the engine...(error=%d)", Integer.valueOf(sSpeechSynthesizer.startSpeaking(ttsTask.text, ttsTask)));
        startEngine();
        safeRun(new Runnable() {
            public void run() {
                int startSpeaking = TtsEngineIflytek.sSpeechSynthesizer.startSpeaking(ttsTask.text, ttsTask);
                if (startSpeaking != 0) {
                    ttsTask.onTaskError(startSpeaking, "");
                } else {
                    ttsTask.onTaskBegin();
                }
            }
        });
    }

    private void safeRun(final Runnable runnable) {
        UThread.runOnThread(new Runnable() {

            /* renamed from: com.duokan.reader.domain.tts.TtsEngineIflytek$8$1 */
            class C12031 implements Runnable {
                C12031() {
                }

                public void run() {
                    TtsEngineIflytek.this.startEngine();
                }
            }

            public void run() {
                if (TtsEngineIflytek.sSpeechSynthesizer == null) {
                    if (TtsEngineIflytek.sSpeechUtility != null) {
                        TtsEngineIflytek.sSpeechSynthesizer = SpeechSynthesizer.createSynthesizer(TtsEngineIflytek.this.mContext, null);
                        TtsEngineIflytek.sInitDone = true;
                        TtsEngineIflytek.this.setupEngine(TtsEngineIflytek.this.mSpeaker, TtsEngineIflytek.this.mSpeed);
                        while (!TtsEngineIflytek.this.mDelayedRunList.isEmpty()) {
                            ((Runnable) TtsEngineIflytek.this.mDelayedRunList.poll()).run();
                        }
                    } else {
                        UThread.post(new C12031());
                    }
                }
                if (TtsEngineIflytek.sInitDone) {
                    UIdleHandler.runAction(runnable);
                } else {
                    TtsEngineIflytek.this.mDelayedRunList.add(runnable);
                }
            }
        });
    }
}
