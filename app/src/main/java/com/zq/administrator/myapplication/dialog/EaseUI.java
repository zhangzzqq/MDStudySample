package com.zq.administrator.myapplication.dialog;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;

import com.zq.administrator.myapplication.widget.EaseEmojicon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by steven on 2018/6/9.
 */
public final class EaseUI {
    private static final String TAG = EaseUI.class.getSimpleName();

    /**
     * the global EaseUI instance
     */
    private static EaseUI instance = null;

    /**
     * EMEventListener
     */

    /**
     * 用户属性提供者
     */
    private EaseUserProfileProvider userProvider;


    private MainActivityProvider mainActivityProvider;

    private SYOASettingsProvider syoaSettingsProvider;

    /**
     * application context
     */
    private Context appContext = null;

    /**
     * init flag: test if the sdk has been inited before, we don't need to init
     * again
     */
    private boolean sdkInited = false;


    /**
     * 用来记录注册了eventlistener的foreground Activity
     */
    private List<Activity> activityList = new ArrayList<Activity>();

    public void pushActivity(Activity activity) {
        if (!activityList.contains(activity)) {
            activityList.add(0, activity);
        }
    }

    public void popActivity(Activity activity) {
        activityList.remove(activity);
    }


    private EaseUI() {
    }

    /**
     * 获取EaseUI单实例对象
     *
     * @return
     */
    public synchronized static EaseUI getInstance() {
        if (instance == null) {
            instance = new EaseUI();
        }
        return instance;
    }

    /**
     * this function will initialize the HuanXin SDK
     *
     * @param context
     * @return
     */
    public synchronized boolean init(Context context) {
        if (sdkInited) {
            return true;
        }
        appContext = context;

        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);

        Log.d(TAG, "process app name : " + processAppName);

        // 如果app启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的app会在以包名为默认的process name下运行，如果查到的process name不是app的process
        // name就立即返回
        if (processAppName == null || !processAppName.equalsIgnoreCase(appContext.getPackageName())) {
            Log.e(TAG, "enter the service process!");

            // 则此application::onCreate 是被service 调用的，直接返回
            return false;
        }


        sdkInited = true;
        return true;
    }


    /**
     * 读取manifest.xml中application标签下的配置项，如果不存在，则返回空字符串
     *
     * @param key 键名
     * @return 返回字符串
     */
    public static String getConfigString(Context context, String key) {
        String val = "";
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            val = appInfo.metaData.getString(key);
            if (val == null) {
                Log.e(TAG, "please set config value for " + key + " in manifest.xml first");
            }
        } catch (Exception e) {
            Log.w(TAG, e);
        }
        return val;
    }


    public Context getContext() {
        return appContext;
    }


    protected void initChatOptions() {
    }



    /**
     * 设置用户属性提供者
     *
     * @param userProvider
     */
    public void setUserProfileProvider(EaseUserProfileProvider userProvider) {
        this.userProvider = userProvider;
    }

    /**
     * 获取用户属性提供者
     *
     * @return
     */
    public EaseUserProfileProvider getUserProfileProvider() {
        return userProvider;
    }




    /**
     * （待增加 下面三个方法）
     * 获取主界面属性提供者
     *
     * @return
     */

    public interface MainActivityProvider {
        Class<?> getMainActivity();

        /**
         * 获得消息保存到云笔记的activity
         *
         * @return
         */
        Class<?> getNoteSaveActivity();

        /**
         * 获得云笔记详情展示的activity
         *
         * @return
         */
        Class<?> getNoteActivity();

        /**
         * 获得所有已下载的附件预览展示activity,传递文件的本地路径
         *
         * @return
         */
        Class<?> getYunpanSaveActivity();

        /**
         * 获得云盘详情展示的activity
         *
         * @return
         */
        Class<?> getYunpanActivity();

        /**
         * 获得员工社区详情展示的activity
         *
         * @return
         */
        Class<?> getCommunityActivity();

        /**
         * 咪咕记忆跳转 activity
         *
         * @return
         */
        Class<?> getMemoryActivity();

        /**
         * IM我的网盘,专辑,收藏
         *
         * @return
         */
        Class<?> getEaseActivity();

        /**
         * 获得消息保存到邮件的activity
         *
         * @return
         */
        Class<?> getEmailActivity();

        /**
         * 获得云笔记列表页面,返回需要发送的云笔记信息
         *
         * @return
         */
        Class<?> getNoteIndexActivity();

        /**
         * 获得云盘列表页面,返回需要发送的云盘信息
         *
         * @return
         */
        Class<?> getYunpanIndexActivity();
    }

    public MainActivityProvider getMainActivityProvider() {
        return mainActivityProvider;
    }

    public void setMainActivityProvider(MainActivityProvider mainActivityProvider) {
        this.mainActivityProvider = mainActivityProvider;
    }

    public SYOASettingsProvider getSyoaSettingsProvider() {
        return syoaSettingsProvider;
    }

    public void setSyoaSettingsProvider(SYOASettingsProvider syoaSettingsProvider) {
        this.syoaSettingsProvider = syoaSettingsProvider;
    }


    /**
     * check the application process name if process name is not qualified, then
     * we think it is a service process and we will not init SDK
     *
     * @param pID
     * @return
     */
    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) appContext.getSystemService(Context.ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = appContext.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    CharSequence c = pm
                            .getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
                    // Log.d("Process", "Id: "+ info.pid +" ProcessName: "+
                    // info.processName +" Label: "+c.toString());
                    // processName = c.toString();
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }


    public static abstract class SYOASettingsProvider {


        public int getEntryCount() {
            return 0;
        }

        /**
         * 是否显示邮箱入口
         */
        public boolean showEmailEntry() {
            return false;
        }

        /**
         * 是否显示待办提醒入口
         */
        public boolean showTodoEntry() {
            return false;
        }

        /**
         * 是否显示新闻入口
         */
        public boolean showNewsEntry() {
            return false;
        }

        /**
         * 是否显示公告入口
         */
        public boolean showNoticeEntry() {
            return false;
        }

        /**
         * 是否显示定时消息入口
         */
        public boolean showTimedMessageEntry() {
            return false;
        }

        /**
         * 是否显示企业公告入口
         */
        public boolean showEnterpriseNoticeEntry() {
            return false;
        }

        /**
         * 是否显示日程入口
         */
        public boolean showScheduleEntry() {
            return false;
        }

        /**
         * 邮箱入口位置
         */
        public int showEmailEntryPosition() {
            return -1;
        }

        /**
         * 待办提醒入口位置
         */
        public int showTodoEntryPosition() {
            return -1;
        }

        /**
         * 新闻入口位置
         */
        public int showNewsEntryPosition() {
            return -1;
        }

        /**
         * 公告入口位置
         */
        public int showNoticeEntryPosition() {
            return -1;
        }

        /**
         * 定时消息入口位置
         */
        public int showTimedMessageEntryPosition() {
            return -1;
        }

        /**
         * 企业公告入口位置
         */
        public int showEnterpriseNoticeEntryPosition() {
            return -1;
        }

        /**
         * 日程入口位置
         */
        public int showScheduleEntryPosition() {
            return -1;
        }

        public int getIcon(int position) {
            return 0;
        }

        public String getTitle(int position) {
            return "";
        }

        public String getMessage(int position) {
            return "";
        }

        public String getLastTime(int position) {
            return "";
        }

        /**
         * 入口小红点
         */
        public View getBadgeView(int position) {
            return null;
        }

        public int getIcon(String userName) {
            return 0;
        }

        public String getTitle(String userName) {
            return "";
        }

        public String getMessage(String userName) {
            return "";
        }

        public String getLastTime(String userName) {
            return "";
        }

        /**
         * 入口小红点
         */
        public View getBadgeView(String userName) {
            return null;
        }

        /**
         * 未读消息
         */
        public void notifyNewMessage(int count) {

        }

        public abstract int getSiteVersion();

    }


    /**
     * 用户属性提供者
     *
     * @author wei
     */
    public interface EaseUserProfileProvider {
        /**
         * 返回此username对应的user
         *
         * @param username 环信id
         * @return
         */
    }

    /**
     * 表情信息提供者
     */
    public interface EaseEmojiconInfoProvider {
        /**
         * 根据唯一识别号返回此表情内容
         *
         * @param emojiconIdentityCode
         * @return
         */
        EaseEmojicon getEmojiconInfo(String emojiconIdentityCode);

        /**
         * 获取文字表情的映射Map,map的key为表情的emoji文本内容，value为对应的图片资源id或者本地路径(不能为网络地址)
         *
         * @return
         */
        Map<String, Object> getTextEmojiconMapping();
    }

    private EaseEmojiconInfoProvider emojiconInfoProvider;

    /**
     * 获取表情提供者
     *
     * @return
     */
    public EaseEmojiconInfoProvider getEmojiconInfoProvider() {
        return emojiconInfoProvider;
    }

    /**
     * 设置表情信息提供者
     *
     * @param emojiconInfoProvider
     */
    public void setEmojiconInfoProvider(EaseEmojiconInfoProvider emojiconInfoProvider) {
        this.emojiconInfoProvider = emojiconInfoProvider;
    }

}

