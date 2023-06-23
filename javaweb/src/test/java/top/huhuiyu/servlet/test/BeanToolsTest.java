package top.huhuiyu.servlet.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.huhuiyu.servlet.entity.TbUser;
import top.huhuiyu.servlet.util.BeanTools;

import java.util.HashMap;
import java.util.Map;

public class BeanToolsTest {
  private static final Logger logger = LoggerFactory.getLogger(BeanToolsTest.class);

  @Test
  public void one() throws Exception {
    TbUser user;
    Map<String, Object> map = new HashMap<>();
    map.put("uid", 100);
    user = BeanTools.mapping(map, TbUser.class);
    logger.debug("{}", user);
    map.put("username", "黑暗骑士");
    BeanTools.mapping(map, user);
    logger.debug("{}", user);
  }
}