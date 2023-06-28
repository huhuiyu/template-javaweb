package top.huhuiyu.servlet.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.huhuiyu.servlet.entity.TbUser;

import java.util.Optional;

/**
 * 临时用测试
 *
 * @author 胡辉煜
 */
public class TempTest {
  private static final Logger logger = LoggerFactory.getLogger(TempTest.class);

  public String makeString(boolean mode) {
    return mode ? null : "黑暗骑士";
  }

  public TbUser makeTbUser(boolean mode) {
    if (mode) {
      return null;
    }
    TbUser user = new TbUser();
    user.setUsername("哈哈哈");
    user.setNickname("嘻嘻嘻");
    return user;
  }


  @Test
  public void one() throws Exception {
    logger.info("字符串演示1：{}", Optional.ofNullable(makeString(false)).orElse("默认字符串"));
    logger.info("字符串演示2：{}", Optional.ofNullable(makeString(true)).orElse("默认字符串"));

    logger.info("对象演示1：{}", Optional.ofNullable(makeTbUser(false)).orElse(new TbUser()));
    logger.info("对象演示2：{}", Optional.ofNullable(makeTbUser(true)).orElse(new TbUser()));
  }
}
