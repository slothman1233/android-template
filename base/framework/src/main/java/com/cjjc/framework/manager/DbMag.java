package com.cjjc.framework.manager;

import com.cjjc.framework.BuildConfig;
import com.cjjc.lib_db.sql.tools.DbConstantConfig;
import com.cjjc.lib_tools.util.AppGlobalUtils;

/**
 * 数据库初始化配置
 */
public class DbMag {
    //数据库保存路径  默认放在缓存目录
    public static String DB_PATH = AppGlobalUtils.getApplication().getCacheDir().getAbsolutePath() + "/DB/";
    //数据库前缀项目名
    private static String PROJECT_NAME = BuildConfig.PROJECT_NAME;
    //数据库版本---总库
    private static double DB_VERSION_SUM = 1.0;
    //数据库版本---用户库
    private static double DB_VERSION_USER = 1.0;
    //数据库整体文件夹名
    public static String SUM_DB_DIR_NAME = "_HuaYunDb";
    //备份数据库整体文件夹名
    public static String BACK_DB_DIR_NAME = "_HuaYunBackDb";
    //用户管理总数据库名称
    public static String USER_MSG_DB_NAME = "_HuaYunUserMsg";
    //用户个人数据库名称
    public static String USER_DB_NAME = "_HauYunUserDB";
    //记录数据库版本升级的文件名
    public static String RECORD_UPDATE_FILE_NAME = "_HuaYunUpdate.txt";

    public static void init() {
        DbConstantConfig.initDbPath(DB_PATH, PROJECT_NAME, DB_VERSION_SUM, DB_VERSION_USER, SUM_DB_DIR_NAME,
                BACK_DB_DIR_NAME, USER_MSG_DB_NAME, USER_DB_NAME, RECORD_UPDATE_FILE_NAME);
    }
}
