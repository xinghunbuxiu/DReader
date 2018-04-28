package com.duokan.reader.domain.cloud.push;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.statistics.C1163a;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

public class DkPushMessageReceiver extends PushMessageReceiver {
    private static final String TAG = DkPushMessageReceiver.class.getName();

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        C0328a.m757c().m752c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{TAG, "onReceivePassThroughMessage", miPushMessage.toString()}));
        C0880y.m5742a().m5751a(miPushMessage);
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        C0328a.m757c().m752c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{TAG, "onNotificationMessageClicked", miPushMessage.toString()}));
        C0880y.m5742a().m5751a(miPushMessage);
        try {
            if (C0880y.m5747b(miPushMessage)) {
                C1163a.m8627k().m8646a(miPushMessage.getMessageId(), "PUSH_CHAPTER_UPDATE_V2", "clicked");
                UmengManager.get().onEvent("PUSH_CHAPTER_UPDATE_V2", "clicked");
                return;
            }
            C1163a.m8627k().m8646a(miPushMessage.getMessageId(), "PUSH_MESSAGE_V2", "clicked");
            UmengManager.get().onEvent("PUSH_MESSAGE_V2", "clicked");
        } catch (Throwable th) {
        }
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        C0328a.m757c().m752c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{TAG, "onNotificationMessageArrived", miPushMessage.toString()}));
        String str = "notify_foreground";
        int i = (miPushMessage.getExtra().containsKey("notify_foreground") && TextUtils.equals((CharSequence) miPushMessage.getExtra().get("notify_foreground"), "0")) ? 1 : 0;
        if (ManagedApp.get().getRunningState() == RunningState.FOREGROUND && i != 0) {
            C0880y.m5742a().m5751a(miPushMessage);
        }
    }

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        C0328a.m757c().m752c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{TAG, "onCommandResult", miPushCommandMessage.toString()}));
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        C0328a.m757c().m752c(LogLevel.EVENT, "push", String.format("class: %s, method: %s, message: %s", new Object[]{TAG, "onReceiveRegisterResult", miPushCommandMessage.toString()}));
        String command = miPushCommandMessage.getCommand();
        List commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            String str2 = (String) commandArguments.get(1);
        }
        if ("register".equals(command) && miPushCommandMessage.getResultCode() == 0) {
            C0328a.m757c().m752c(LogLevel.EVENT, "push", "register success");
            C0880y.m5742a().m5749a(miPushCommandMessage.getResultCode(), str, miPushCommandMessage.getReason());
        }
    }
}
