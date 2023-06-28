package top.huhuiyu.servlet.servlet;

import top.huhuiyu.servlet.filter.DTokenFilter;
import top.huhuiyu.servlet.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示token用servlet
 *
 * @author 胡辉煜
 */
@WebServlet(name = "TokenServlet", urlPatterns = "/demo.token")
public class TokenServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    try {
      resp.getWriter().println(JsonUtil.stringify(DTokenFilter.getTokenInfo(req)));
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
