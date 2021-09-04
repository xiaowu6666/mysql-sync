package tk.shenyifeng.study.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.shenyifeng.study.bean.DataSourceRouter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static tk.shenyifeng.study.bean.ClusteEnum.MASTER;
import static tk.shenyifeng.study.bean.ClusteEnum.SLAVE;

@Configuration
public class DataSourceConfig {

    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource master() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slave(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dynamicDB")
    public DataSourceRouter dynamicDB(@Qualifier("master") DataSource master,
                                      @Qualifier("slave") DataSource slave){
        DataSourceRouter router = new DataSourceRouter();
        Map<Object,Object> map = new HashMap<>();
        map.put(SLAVE,slave);
        map.put(MASTER,master);
        router.setTargetDataSources(map);
        router.setDefaultTargetDataSource(slave);
        return router;
    }
}
