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
  private static final TbUserDAO TB_USER_DAO = new TbUserDAO();
  @Test
  public void connection() throws Exception {
    Connection connection = DBHelp.getConnection();
    logger.info(connection.getCatalog());
    connection.close();
  }

  @Test
  public void query() throws Exception {
    List<TbUser> list = TB_USER_DAO.query(null);
    logger.info("查询结果1：{}", list);
    TbUser user = new TbUser();
    user.setUsername("a");
    list = TB_USER_DAO.query(user);
    logger.info("查询结果2：{}", list);
    user = new TbUser();
    user.setEnable("y");
    list = TB_USER_DAO.query(user);
    logger.info("查询结果3{}", list);
    user = new TbUser();
    user.setUsername("a");
    user.setEnable("n");
    list = TB_USER_DAO.query(user);
    logger.info("查询结果4{}", list);
  }
}
