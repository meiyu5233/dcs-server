@ECHO OFF
java -cp .;mybatis-generator-core-1.4.0.jar org.mybatis.generator.api.ShellRunner -configfile config-mysql.xml -overwrite
@ECHO ON