# Hibernate
Configuracion de hibernate con spring annotation y ejemplos de su ejecución

Java annotation
---

###RootConfigContext
````java
@EnableScheduling
@EnableTransactionManagement(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.LOWEST_PRECEDENCE
)
public class RootConfigContext
{
    /* ...... */
}
````
####Java Beans
#####Config Data Base
````java
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        driverManagerDataSource.setUsername("tomas");
        driverManagerDataSource.setPassword("tomas");
        return driverManagerDataSource;
    }
````
#####Properties of Hibernate
````java
    private Properties properties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }
````
#####Config Session 
````java
    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean()
    {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(new String[]{"com.tomas.test"});
        localSessionFactoryBean.setHibernateProperties(properties());
        return localSessionFactoryBean;
    }
````
#####Config HibernateTransactionManager  
````java
    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
````

#####Services and Respository
```java
@Repository
public class 
```

```java
@Inject
    private SessionFactory sessionFactory;
```

```java
public class PersonServicesImpDao implements PersonServicesDao
{


    @Inject
    private PersonRepositoryDao personRepositoryDao;

    @Override
    @Transactional
    public void addPerson(Person p)
    {
        personRepositoryDao.addPerson(p);
    }
}
````

##Sin Java annotation Solo con XML

#####DataBase
```xml
    <beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		destroy-method="close">
		<beans:property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<beans:property name="url"
			value="jdbc:mysql://localhost:3306/TestDB" />
		<beans:property name="username" value="pankaj" />
		<beans:property name="password" value="pankaj123" />
	</beans:bean>
```
#####Properties and Session
```xml
    <beans:bean id="hibernate4AnnotatedSessionFactory"
		class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<beans:property name="dataSource" ref="dataSource" />
		<beans:property name="annotatedClasses">
			<beans:list>
				<beans:value>com.journaldev.spring.model.Person</beans:value>
			</beans:list>
		</beans:property>
		<beans:property name="hibernateProperties">
			<beans:props>
				<beans:prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect
				</beans:prop>
				<beans:prop key="hibernate.show_sql">true</beans:prop>
			</beans:props>
		</beans:property>
	</beans:bean>
````
#####Beans 
```xml
	<beans:bean id="personDAO" class="com.your.class">
		<beans:property name="sessionFactory" ref="hibernate4AnnotatedSessionFactory" />
	</beans:bean>
	
	<beans:bean id="personService" class="com.your.class">
		<beans:property name="personDAO" ref="personDAO"></beans:property>
	</beans:bean>
	
	<tx:annotation-driven transaction-manager="transactionManager"/>
	<beans:bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
		<beans:property name="sessionFactory" ref="hibernate4AnnotatedSessionFactory" />
	</beans:bean>
````
