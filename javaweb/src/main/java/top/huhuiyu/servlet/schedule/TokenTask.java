package top.huhuiyu.servlet.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.huhuiyu.servlet.dao.TbTokenDAO;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * token计划任务
 *
 * @author 胡辉煜
 */
public class TokenTask implements Runnable {
  private static final Logger loger = LoggerFactory.getLogger(TokenTask.class);
  private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
  private TbTokenDAO tbTokenDAO = new TbTokenDAO();

  @Override
  public void run() {
    try {
      loger.debug("处理过期的token信息");
      int count = tbTokenDAO.removeExpireToken();
      loger.debug("处理过期的token信息的数量：{}", count);
    } catch (Exception ex) {
      loger.debug("处理过期的token信息发生错误：{}", ex.getMessage());
    }
  }

  /**
   * 启动计划任务
   */
  public void startup() {
    service.scheduleAtFixedRate(this, 1, 1, TimeUnit.MINUTES);
  }

  /**
   * 停止计划任务
   */
  public void shutdown() {
    service.shutdown();
  }
}
