package com.duokan.reader.ui.general;

import android.net.Uri;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

import java.io.DataOutputStream;

class hp implements Runnable {
    final /* synthetic */ Uri a;
    final /* synthetic */ ServerSettingActivity b;

    hp(ServerSettingActivity serverSettingActivity, Uri uri) {
        this.b = serverSettingActivity;
        this.a = uri;
    }

    public void run() {
        Process exec;
        DataOutputStream dataOutputStream;
        Throwable th;
        Process process = null;
        if (this.a != null) {
            try {
                int parseInt = Integer.parseInt(this.a.getQueryParameter("online"));
                if (parseInt < 1 || parseInt > 3) {
                    this.b.a("切换失败!", 1);
                    return;
                }
                String str;
                ReaderEnv.get().setPrefInt(PrivatePref.STORE, "server_config_key", parseInt);
                ReaderEnv.get().commitPrefs();
                p.i().a(parseInt);
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
                            PersonalAccount personalAccount = (PersonalAccount) i.f().b(PersonalAccount.class);
                            if (personalAccount.i() || !personalAccount.e().equals(AccountType.XIAO_MI)) {
                                this.b.a();
                                this.b.a(format, 3);
                                return;
                            }
                            personalAccount.a(new hq(this, format));
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
                this.b.a("切换失败!", 1);
            }
        }
    }
}
