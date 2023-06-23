package top.huhuiyu.servlet.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.huhuiyu.servlet.dao.TbUserDAO;
import top.huhuiyu.servlet.entity.TbUser;
import top.huhuiyu.servlet.util.DBHelp;

import java.sql.Connection;
import java.util.List;

public class SqlTest {

  private static final Logger logger = LoggerFactory.getLogger(SqlTest.class);

  @Test
  public void connection() throws Exception {
    Connection connection = DBHelp.getConnection();
    logger.info(connection.getCatalog());
    connection.close();
  }

  @Test
  public void query() throws Exception {
    List<TbUser> list = new TbUserDAO().query();
    logger.info("查询结果{}", list);
  }
}
