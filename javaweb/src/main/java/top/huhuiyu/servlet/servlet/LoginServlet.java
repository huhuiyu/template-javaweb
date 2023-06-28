package top.huhuiyu.servlet.servlet;

import top.huhuiyu.servlet.base.BaseResult;
import top.huhuiyu.servlet.dao.TbUserDAO;
import top.huhuiyu.servlet.entity.TbToken;
import top.huhuiyu.servlet.entity.TbUser;
import top.huhuiyu.servlet.entity.TokenInfo;
import top.huhuiyu.servlet.filter.DTokenFilter;
import top.huhuiyu.servlet.util.BeanTools;
import top.huhuiyu.servlet.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示登录用servlet
 *
 * @author 胡辉煜
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/user/login.token")
public class LoginServlet extends HttpServlet {

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
      TbToken token = DTokenFilter.getTokenInfo(req);
      // 处理查询参数
      TbUser user = BeanTools.mapping(req.getParameterMap(), TbUser.class);
      // 应答token
      BaseResult<TbUser> result = new BaseResult<>();
      result.setToken(token.getToken());
      // 查询用户名是否存在
      TbUser check = tbUserDAO.queryByUsername(user);
      if (check == null) {
        result.setCode(500);
        result.setSuccess(false);
        result.setMessage("用户名不存在");
        resp.getWriter().println(JsonUtil.stringify(result));
        return;
      }
      // 校验密码
      if (!check.getPassword().equalsIgnoreCase(user.getPassword())) {
        result.setCode(500);
        result.setSuccess(false);
        result.setMessage("密码错误");
        resp.getWriter().println(JsonUtil.stringify(result));
        return;
      }
      // 更新token中的用户信息
      TokenInfo tokenInfo = token.content();
      tokenInfo.setUser(check);
      token.setTokenInfo(JsonUtil.stringify(tokenInfo));
      result.setCode(200);
      result.setSuccess(true);
      result.setMessage("登录成功");
      resp.getWriter().println(JsonUtil.stringify(result));
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
