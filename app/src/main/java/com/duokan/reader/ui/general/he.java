package com.duokan.reader.ui.general;

import android.net.Uri;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import java.io.DataOutputStream;

class he implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Uri f7326a;
    /* renamed from: b */
    final /* synthetic */ ServerSettingActivity f7327b;

    he(ServerSettingActivity serverSettingActivity, Uri uri) {
        this.f7327b = serverSettingActivity;
        this.f7326a = uri;
    }

    public void run() {
        DataOutputStream dataOutputStream;
        Throwable th;
        Process process = null;
        if (this.f7326a != null) {
            try {
                int parseInt = Integer.parseInt(this.f7326a.getQueryParameter("online"));
                if (parseInt < 1 || parseInt > 3) {
                    this.f7327b.m10174a("切换失败!", 1);
                    return;
                }
                String str;
                ReaderEnv.get().setPrefInt(PrivatePref.STORE, "server_config_key", parseInt);
                ReaderEnv.get().commitPrefs();
                C0641o.m2934i().m2959a(parseInt);
                switch (parseInt) {
                    case 1:
                        str = "线上服务器";
                        break;
                    case 2:
                        str = "公网测试服务器";
                        break;
                    default:
                        str = "内网测试服务器";
                        break;
                }
                Process exec;
                DataOutputStream dataOutputStream2;
                try {
                    exec = Runtime.getRuntime().exec("su");
                    try {
                        dataOutputStream2 = new DataOutputStream(exec.getOutputStream());
                        try {
                            String str2;
                            dataOutputStream2.writeBytes("mount -o rw,remount /system \n");
                            dataOutputStream2.writeBytes("touch /etc/hosts \n");
                            dataOutputStream2.writeBytes("chmod 777 /etc/hosts \n");
                            dataOutputStream2.writeBytes("echo '127.0.0.1 localhost' > /etc/hosts \n");
                            if (parseInt == 3) {
                                str2 = "'10.99.184.243 login.dushu.xiaomi.com'";
                            } else {
                                str2 = "''";
                            }
                            dataOutputStream2.writeBytes("echo " + str2 + " >> /etc/hosts \n");
                            dataOutputStream2.writeBytes("exit \n");
                            dataOutputStream2.flush();
                            exec.waitFor();
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e) {
                                }
                            }
                            if (exec != null) {
                                exec.destroy();
                            }
                            String format = String.format("已切换至 [%s]", new Object[]{str});
                            PersonalAccount personalAccount = (PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class);
                            if (personalAccount.mo839i() || !personalAccount.mo835e().equals(AccountType.XIAO_MI)) {
                                this.f7327b.m10171a();
                                this.f7327b.m10174a(format, 3);
                                return;
                            }
                            personalAccount.mo830a(new hf(this, format));
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataOutputStream2 != null) {
                                dataOutputStream2.close();
                            }
                            if (exec != null) {
                                exec.destroy();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        dataOutputStream2 = null;
                        if (dataOutputStream2 != null) {
                            dataOutputStream2.close();
                        }
                        if (exec != null) {
                            exec.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    dataOutputStream2 = null;
                    exec = null;
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.f7327b.m10174a("切换失败!", 1);
            }
        }
    }
}
