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
import java.util.List;

/**
 * json应答的用户查询servlet
 */
@WebServlet(name = "UserQueryServlet", urlPatterns = "/user/query.servlet")
public class UserQueryServlet extends HttpServlet {
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
//    上面的代码时用来替换下面被注释的代码
//    TbUser user = new TbUser();
//    user.setUsername(req.getParameter("username"));
//    user.setEnable(req.getParameter("enable"));
      // 查询处理
      BaseResult<List<TbUser>> result = new BaseResult<>();
      result.setCode(200);
      result.setSuccess(true);
      result.setData(TB_USER_DAO.query(user));
      resp.getWriter().println(JsonUtil.stringify(result));
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
