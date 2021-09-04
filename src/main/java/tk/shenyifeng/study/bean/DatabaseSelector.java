package tk.shenyifeng.study.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static tk.shenyifeng.study.bean.ClusteEnum.SLAVE;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DatabaseSelector {

    ClusteEnum value() default SLAVE;
    boolean clear() default true;
}
