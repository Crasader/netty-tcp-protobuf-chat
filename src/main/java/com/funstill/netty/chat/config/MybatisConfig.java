package com.funstill.netty.chat.config;

/**
 * @author liukaiyang
 * @date 2017/12/12 18:01
 */
//@Configuration
//@MapperScan(basePackages = "com.funstill.netty.chat.mybatis.mapper",
//        sqlSessionTemplateRef = "mybatisMasterSqlSessionTemplate")
//@PropertySource("classpath:mybatis-config.properties")
public class MybatisConfig {

//
//    @Bean(name = "mybatisMasterDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidDataSource mybatisMasterDataSource(DataSourceProperties properties) {
//        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName(properties.;
//        ds.setUrl("jdbc:mysql://127.0.0.1:3306/my");
//        ds.setUsername("root");
//        ds.setPassword("root");
//        ds.setMinIdle(1);
//        ds.setMaxActive(10);
//        ds.setMaxWait(60000);
//        ds.setTimeBetweenEvictionRunsMillis(60000);
//        ds.setMinEvictableIdleTimeMillis(300000);
//        ds.setValidationQuery("SELECT 'X'");
//        ds.setTestWhileIdle(true);
//        ds.setTestOnBorrow(false);
//        ds.setTestOnReturn(false);
//
//        ds.setPoolPreparedStatements(false);
//        ds.setMaxPoolPreparedStatementPerConnectionSize(20);
////        ds.setFilters("stat");
//        return ds;
//    }
//
//
//    @Bean(name = "mybatisMasterSqlSessionFactory")
//    public SqlSessionFactory mybatisMasterSqlSessionFactory(@Qualifier("mybatisMasterDataSource") DruidDataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mybatis/mapper/master/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "mybatisMasterTransactionManager")
//    public DataSourceTransactionManager mybatisMasterTransactionManager(@Qualifier("mybatisMasterDataSource") DruidDataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "mybatisMasterSqlSessionTemplate")
//    public SqlSessionTemplate mybatisMasterSqlSessionTemplate(@Qualifier("mybatisMasterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
