package shop_cart_servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import shop_cart_Connection.db_con;
import shop_cart_dao.OrderDao;
import shop_cart_model.Cart;
import shop_cart_model.Order;
import shop_cart_model.User;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
        User auth = (User) request.getSession().getAttribute("auth");

        if (cart_list != null && auth != null) {
            for (Cart c : cart_list) {
                Order order = new Order();
                order.setId(c.getId());
                order.setUid(auth.getId());
                order.setQunatity(c.getQuantity());
                order.setDate(formatter.format(date));

                OrderDao oDao = new OrderDao(db_con.getConnection());
                boolean result = oDao.insertOrder(order);
                if (!result) {
                    // You might want to handle failed insert here
                    break;
                }
            }
            cart_list.clear();
            response.sendRedirect("orders.jsp");
            return; // prevent further processing
        } else {
            if (auth == null) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("cart.jsp");
            }
            return;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
