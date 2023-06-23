package top.huhuiyu.servlet.servlet;

import top.huhuiyu.servlet.dao.TbUserDAO;
import top.huhuiyu.servlet.entity.TbUser;
import top.huhuiyu.servlet.util.BeanTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * jsp版本用户管理servlet
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user.action")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final TbUserDAO TB_USER_DAO = new TbUserDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 通过action判定是添加还是查询
    String action = req.getParameter("action");
    try {
//    处理查询参数
      TbUser user = BeanTools.mapping(req.getParameterMap(), TbUser.class);
//    处理添加
      if ("add".equals(action)) {
        TbUser check = TB_USER_DAO.queryByUsername(user);
        if (check != null) {
          resp.sendRedirect(String.format("%s%s?message=%s", req.getContextPath(), "/user.action", URLEncoder.encode("用户名已经存在", "UTF-8")));
          return;
        }
        // 添加用户
        int count = TB_USER_DAO.add(user);
        resp.sendRedirect(String.format("%s%s?message=%s", req.getContextPath(), "/user.action", count == 1 ? URLEncoder.encode("用户添加成功", "UTF-8") : URLEncoder.encode("用户添加失败", "UTF-8")));
        return;
      }
//    查询处理
      List<TbUser> list = TB_USER_DAO.query(user);
      req.setAttribute("users", list);
      req.getRequestDispatcher("/user.jsp").forward(req, resp);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
