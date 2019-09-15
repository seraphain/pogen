# pogen持久层代码生成器

pogen是Persistent Object GENerator的缩写，用于根据数据库结构生成持久层代码。

## 工程与构建

### 工程结构

```
pogen
|   .gitignore
|   mvnw
|   mvnw.cmd
|   pom.xml
|   README.md
|
+---.mvn
|
+---configurations // 配置文件
|       application.properties
|       templates.json
|       types.json
|
+---generated // 生成代码
|
+---scripts // 启动脚本
|       pogen.bat
|       pogen.sh
|
+---src
|   +---main
|   |   +---assembly
|   |   |       assembly.xml
|   |   |
|   |   +---java
|   |   |
|   |   \---resources
|   |
|   \---test
|       \---java
|
|
\---templates // 代码模板
```

### 构建

```
./mvnw clean package -Dmaven.test.skip=true
```

构建结果：`pogen/target/pogen-bin.zip`。

### 发布包结构

```
pogen
|   pogen.bat // Windows启动脚本
|   pogen.jar
|   pogen.sh // *nix启动脚本
|   
+---configurations // 配置文件
|       application.properties
|       templates.json
|       types.json
|
+---generated // 生成代码
|       
\---templates // 代码模板
```

## 使用

### 配置

修改`pogen/configurations/application.properties`：

```
# Spring数据源配置。
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/
spring.datasource.username=root
spring.datasource.password=root

# 要生成的schema。
pogen.table.schema=test

# 要生成的表，以逗号分隔。为空则生成schema中所有的表。
pogen.table.include=

# 表名前缀，生成类名时会将其删除。支持正则表达式。
pogen.table.prefix=test_

# 表名后缀，生成类名时会将其删除。支持正则表达式。
pogen.table.postfix=

# 基础Java包
pogen.package.base=com.github.seraphain.test

```

### 运行

* IDE：
  * main函数：`com.github.seraphain.pogen.PogenApplication`
  * JUnit用例：`com.github.seraphain.pogen.PogenApplicationTests`

* 发布包：
  * 运行`pogen.bat`或`pogen.sh`

生成代码在`pogen/generated`目录下。

### 模板修改

* 模板语法参考[Freemarker文档](https://freemarker.apache.org/docs/index.html)。
* 模板配置：`/pogen/configurations/templates.json`
  * 支持同时使用多套模板
  * key：模板目录，value：生成代码目录

```
{
    "templates/mybatis": "generated/mybatis"
}
```

