package com.example.httplibrary.base;

import com.example.kotlinbaselibrary.base.BaseModle;

import java.util.HashMap;

public class ModleFractory {
        private static HashMap<String, BaseModle>mMap=new HashMap<>();
        public static <M extends BaseModle> M creatModel(Class<M> mClass){
            if (mMap.get(mClass)!=null){
                return (M) mMap.get(mClass);
            }
            M model=null;
            try {
                //通过反射创建对象 子类model 必须无参构造
              model = mClass.newInstance();
              if (model!=null){
                  mMap.put(mClass.getName(),model);
              }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return model;
        }


}
