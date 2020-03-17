package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @SuppressWarnings("unchecked")
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("UTF-8");
    HttpSession cart_session = req.getSession();
    Map<String, Integer> cart = null;
    //标记获取的表单是否为空
    Object object = new Object();
    //标记map是否为空
    Object isNull = null;
    String errMsg = "这个家伙什么鸡儿都没选";
    object = cart_session.getAttribute("Cart");
    if (object == null) {
      cart = new HashMap<String, Integer>();
    } else {
      cart = (Map<String, Integer>)object;
    }
    // 从main.jsp的 表单中获取内容
    String computers[] = req.getParameterValues("computer");
    if (computers != null) {
      // 获取添加信息
      String add = req.getParameter("add_submit");
      System.out.println("add: " + add);
      // 获取删除信息
      String sub = req.getParameter("sub_submit");
      System.out.println("sub: " + sub);
      //添加
      if (add != null) {
        for (String computer_i : computers) {
          Integer add_count = cart.get(computer_i);
          if (add_count == null) {
            cart.put(computer_i, 1);
          } else {
            cart.put(computer_i, add_count + 1);
          }
        }
      } else {
        //删除
        for (String computer_i : computers) {
          if (cart.get(computer_i) == null) {
            continue;
          } else {
            Integer sub_count = (cart.get(computer_i) - 1);
            if (sub_count >= 1) {
              cart.put(computer_i, sub_count);
            } else {
              cart.remove(computer_i);
            }
            //查看当前cart是否为空
            System.out.println("empty：" + cart.isEmpty());
          }
        }
      }
      //在console中遍历，方便调代码
      for (Entry<String, Integer> cart_map : cart.entrySet()) {
        System.out.println(cart_map.getKey() + "  " + cart_map.getValue());
      }
      //查看最终cart map是否为空
      System.out.println("empty22：" + cart.isEmpty());
      if (cart.isEmpty()) {
        isNull = null;
        System.out.println(errMsg);
        req.setAttribute("errMsg", errMsg);
      } else {
        isNull = new Object();
      }
      System.out.println("isNull:" + isNull);
      cart_session.setAttribute("isNull", isNull);
      cart_session.setAttribute("Cart", cart);
    } else if (computers == null) {
      System.out.println(errMsg);
      req.setAttribute("errMsg", errMsg);
    }
    req.getRequestDispatcher("/cartlist.jsp").forward(req, resp);
  }
}
