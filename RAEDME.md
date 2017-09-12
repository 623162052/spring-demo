### mybatis
    
    // 自动映射: 配置成resultType="hashMap"是可以返回结果，但是结果是没有自动转成驼峰，要真正存在一个与它对应的驼峰Bean与它对应才生效，resultType="org.me.menu.Menu"
    Configuration configuration = new Configuration(environment);
    configuration.setMapUnderscoreToCamelCase(true);