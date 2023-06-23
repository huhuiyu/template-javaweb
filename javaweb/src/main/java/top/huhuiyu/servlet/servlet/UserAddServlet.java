package top.huhuiyu.servlet.servlet;

import top.huhuiyu.servlet.base.BaseResult;
import top.huhuiyu.servlet.dao.TbUserDAO;
import top.huhuiyu.servlet.entity.TbUser;
import top.huhuiyu.servlet.util.BeanTools;
import top.huhuiyu.servlet.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * json应答的用户添加servlet
 */
@WebServlet(name = "UserAddServlet", urlPatterns = "/user/add.servlet")
public class UserAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final TbUserDAO TB_USER_DAO = new TbUserDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    try {
      // 处理查询参数
      TbUser user = BeanTools.mapping(req.getParameterMap(), TbUser.class);
      // 查询添加
      BaseResult<TbUser> result = new BaseResult<>();
      // 查询用户名是否存在
      TbUser check = TB_USER_DAO.queryByUsername(user);
      if (check != null) {
        result.setCode(500);
        result.setSuccess(false);
        result.setMessage("用户名已经存在");
        resp.getWriter().println(JsonUtil.stringify(result));
        return;
      }
      // 添加用户
      int count = TB_USER_DAO.add(user);
      result.setCode(count == 1 ? 200 : 500);
      result.setSuccess(count == 1);
      result.setMessage(count == 1 ? "用户添加成功" : "用户添加失败");
      // 返回被添加的信息（成功的情况会带回自动增长主键信息）
      result.setData(user);
      resp.getWriter().println(JsonUtil.stringify(result));
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
