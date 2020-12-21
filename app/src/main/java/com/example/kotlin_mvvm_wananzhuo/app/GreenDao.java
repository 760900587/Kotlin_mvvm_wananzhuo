    package com.example.kotlin_mvvm_wananzhuo.app;

public class GreenDao {
//    // 添加代码仓库  步骤1  在project的gradle下
//    mavenCentral()
////greenDao生产代码插件  步骤2
//    classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2' // add plugin
//    // apply plugin 步骤3  在app的gradle下
//    apply plugin: 'org.greenrobot.greendao'
////greenDAO配置  步骤4
//    implementation 'org.greenrobot:greendao:3.2.2' // add library
//    implementation 'org.greenrobot:greendao-generator:3.2.2'
////greendao配置  步骤5  在buildTypes下面添加
//    greendao {
//        //数据库版本号，升级时修改
//        schemaVersion 1
//        //生成的DAO，DaoMaster和DaoSession的包路径。默认与表实体所在的包路径相同
//        daoPackage 'com.example.xts.greendaodemo.db'
//        //生成源文件的路径。默认源文件目录是在build目录中的(build/generated/source/greendao)
//        targetGenDir 'src/main/java'
//    }
//
//    //第六步，
//    建bean类 实体类和数据库对应，，添加相关注解，，然后编译项目生成相关文件   锤项目
//    @Entity
//    public class Bean {
//        @Id    //表示是表中的主键
//        private Long id; //一定是Long型
//        private String date;
//        @Unique   //此字段的值唯一约束：不能重复
//        private String name;
//        private int step;
//    }
//
//
//
////第七步，
//    创建一个自己的application类，在application中完成DaoSession的初始化，避免以后重复初始化，便于使用  ，，，要配置到清单中
//    public class BaseApp extends Application {
//        private static BaseApp sInstance;
//        private DaoMaster.DevOpenHelper mHelper;
//        private DaoMaster mDaoMaster;
//        private DaoSession mDaoSession;
//        @Override
//        public void onCreate() {
//            super.onCreate();
//            sInstance = this;
//            setDatabase();
//        }
//        /**
//         * 设置greenDao
//         */
//        private void setDatabase() {
//            //通过DaoMaster内部类DevOpenHelper可以获取一个SQLiteOpenHelper 对象
//            // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
//            // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
//            // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
//            // 此处MyDb表示数据库名称 可以任意填写
//            mHelper = new DaoMaster.DevOpenHelper(this, "MyDb", null);    // MyDb是数据库的名字，更具自己的情况修改
//            SQLiteDatabase db = mHelper.getWritableDatabase();
//            mDaoMaster = new DaoMaster(db);
//            mDaoSession = mDaoMaster.newSession();
//        }
//        public static BaseApp getInstance(){
//            return sInstance;
//        }
//        public DaoSession getDaoSession(){
//            return mDaoSession;
//        }
//
//    }
//
//
////第八步
//    在清单中使用此BaseApp
//            <application
//    android:name=".BaseApp"
//    android:allowBackup="true"
//
////第九步
//    使用，BeanDao beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();//得到对象
//    完成数据库的创建，表的创建，插入数据insert
//	beanDao.insert(new Bean(1l,"2019-8-27","张三","添加"));
//

}
