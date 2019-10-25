/*package pl.edu.pjwstk.jazapp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.cdi.CDILiquibaseConfig;
import liquibase.integration.cdi.annotations.Liquibase;

import javax.ejb.ApplicationException;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class LiquibaseConfig {
    @Produces

    @Liquibase
    public CDILiquibaseConfig createConfig() {
        CDILiquibaseConfig config = new CDILiquibaseConfig();
        config.setChangeLog("db.changelog/db.changelog.yaml");
        return config;
    }
}*/
