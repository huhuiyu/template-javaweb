package top.huhuiyu.servlet.servlet;

import top.huhuiyu.servlet.base.BaseResult;
import top.huhuiyu.servlet.dao.TbUserDAO;
import top.huhuiyu.servlet.entity.TbToken;
import top.huhuiyu.servlet.entity.TbUser;
import top.huhuiyu.servlet.entity.TokenInfo;
import top.huhuiyu.servlet.filter.DTokenFilter;
import top.huhuiyu.servlet.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示安全退出用servlet
 *
 * @author 胡辉煜
 */
@WebServlet(name = "LogoutServlet", urlPatterns = "/user/logout.token")
public class LogoutServlet extends HttpServlet {

  private TbUserDAO tbUserDAO = new TbUserDAO();
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    try {
      BaseResult<TbUser> result = new BaseResult<>();
      // 更新token中的用户信息
      TbToken token = DTokenFilter.getTokenInfo(req);
      TokenInfo tokenInfo = token.content();
      tokenInfo.setUser(null);
      token.setTokenInfo(JsonUtil.stringify(tokenInfo));
      result.setCode(200);
      result.setSuccess(true);
      result.setToken(token.getToken());
      result.setMessage("安全退出成功");
      resp.getWriter().println(JsonUtil.stringify(result));
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
