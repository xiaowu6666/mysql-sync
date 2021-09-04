package tk.shenyifeng.study.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import tk.shenyifeng.study.config.DataSourceContextHolder;

public class DataSourceRouter extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
