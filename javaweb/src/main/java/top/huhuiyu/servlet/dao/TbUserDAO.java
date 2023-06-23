package top.huhuiyu.servlet.dao;

import top.huhuiyu.servlet.entity.TbUser;
import top.huhuiyu.servlet.util.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TbUserDAO {
  public List<TbUser> query() throws Exception {
    List<TbUser> list = new ArrayList<>();
    Connection connection = DBHelp.getConnection();
    PreparedStatement ps = connection.prepareStatement("select * from tb_user");
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      TbUser tbUser = new TbUser();
      tbUser.setUid(rs.getInt("uid"));
      tbUser.setUsername(rs.getString("username"));
      tbUser.setPassword(rs.getString("password"));
      tbUser.setNickname(rs.getString("nickname"));
      tbUser.setEnable(rs.getString("enable"));
      tbUser.setLastupdate(rs.getDate("lastupdate"));
      list.add(tbUser);
    }
    connection.close();
    return list;
  }
}
