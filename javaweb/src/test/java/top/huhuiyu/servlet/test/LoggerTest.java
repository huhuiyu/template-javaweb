package top.huhuiyu.servlet.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
  private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

  @Test
  public void test() {
    logger.debug("这是测试信息");
    logger.info("这是标准信息");
    logger.error("这是错误信息", new Exception("错误测试"));
  }
}