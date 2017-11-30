##Spring 后端
 
###Spring 数据访问

    Java Persistence API
    Spring Data
        Spring Data JPA
        缓存数据
    Spring Security


    JDBC
        数据访问模板化「模板方法模式」
        Spring将数据访问过程中固定的和可变的部分明确划分为两个不同的类：模板（template）和回调（callback）。
         
    Hibernate
    JPA 
    
    
    
###Spring提供的数据访问模板，分别适用于不同的持久化机制
        
    jca.cci.core.CciTemplate                            JCA连接
    jdbc.core.JdbcTemplate                              JDBC连接
    jdbc.core.namedparam.NamedParameterJdbcTemplate     支持命名参数的JDBC连接
    jdbc.core.simple.SimpleJdbcTemplate                 通过Java 5简化后的JDBC连接（Spring 3.1中已经废弃）
    orm.hibernate3.HibernateTemplate                    Hibernate 3.x以上的Session
    orm.ibatis.SqlMapClientTemplate                     iBATIS SqlMap客户端                                               
    orm.jdo.JdoTemplate                                 Java数据对象（Java Data Object）实现
    orm.jpa.JpaTemplate                                 Java持久化API的实体管理器

                                                                                
## mybatis
    
    // 自动映射: 配置成resultType="hashMap"是可以返回结果，但是结果是没有自动转成驼峰，要真正存在一个与它对应的驼峰Bean与它对应才生效，resultType="org.me.menu.Menu"
    Configuration configuration = new Configuration(environment);
    configuration.setMapUnderscoreToCamelCase(true);
    
###TOOL
jackson-databind
Jackson: json处理工具，比常见的Json-lib, Gson快

    @JsonProperty   用于JSON与Entity转换时映射
    @JsonIgnore     忽略属性
    @JsonUnwrapped  维护对象关系
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")    时间格式化
    
    @JsonAnyGetter @JsonAnySetter   除java对象中明确指定的属性外，我们希望能够随机的增加一些其他属性，让这些随机的属性也可以映射到json中去。这时我们就可以将这些不确定的属性放到一个map中去
    @JsonIgnoreProperties @JsonIgnore
    
    