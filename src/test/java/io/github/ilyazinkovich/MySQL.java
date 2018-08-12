package io.github.ilyazinkovich;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_latest;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;

public class MySQL {

  private static final MysqldConfig mysqlConfig =
      aMysqldConfig(v5_7_latest)
          .withPort(3306)
          .withUser("user", "pass")
          .build();
  public static final EmbeddedMysql mysql =
      anEmbeddedMysql(mysqlConfig)
          .addSchema("testdb", classPathScript("db/schema.sql"))
          .start();
}
