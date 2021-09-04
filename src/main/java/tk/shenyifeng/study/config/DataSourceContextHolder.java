package tk.shenyifeng.study.config;

import lombok.extern.slf4j.Slf4j;
import tk.shenyifeng.study.bean.ClusteEnum;

@Slf4j
public class DataSourceContextHolder  {

    private static final ThreadLocal<ClusteEnum> contextHolder = new ThreadLocal<>();

    public static void  setEnum(ClusteEnum clusteEnum){
        contextHolder.set(clusteEnum);
    }

    public static  void  remove(){
        contextHolder.remove();
    }

    public static ClusteEnum get(){
        ClusteEnum clusteEnum = contextHolder.get();
        log.info("enum {}",clusteEnum);
        return clusteEnum;
    }
}
