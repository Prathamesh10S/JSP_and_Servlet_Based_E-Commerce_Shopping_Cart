# 🛒 Shopping Cart Web Application (JSP + Servlet + MySQL)

A simple shopping cart web application built using Java (JSP/Servlet), MySQL, and Apache Tomcat. This project allows users to browse products, add items to their cart, log in, and place orders.

## 📁 Project Structure

Shopping_Cart/
├── src/
│ └── main/
│ ├── java/
│ │ ├── shop_cart_Connection/
│ │ ├── shop_cart_dao/
│ │ ├── shop_cart_model/
│ │ └── shop_cart_servlet/
│ └── webapp/
│ ├── includes/
│ ├── META-INF/
│ ├── WEB-INF/
│ ├── index.jsp
│ ├── login.jsp
│ ├── cart.jsp
│ └── orders.jsp

---

## 🔁 Flow of Application

1. **Start Point:**  
   Application starts at `index.jsp` (configured in `web.xml`).

2. **User Authentication:**  
   Login via `login.jsp`, user session stored as `auth`.

3. **Product Browsing:**  
   `index.jsp` fetches and shows products via `ProductDao`.

4. **Cart Management:**  
   Cart data saved in session (`cart-list`), shown in `cart.jsp`.

5. **Order Placement:**  
   Orders stored in DB, history shown in `orders.jsp`.

---

## 🛠️ Technologies Used

- **Frontend:** JSP, HTML, CSS  
- **Backend:** Java Servlets, JDBC  
- **Database:** MySQL  
- **Server:** Apache Tomcat  
- **IDE:** Eclipse IDE

---
🚀 How to Run :
1.Clone the repository:
  git clone https://github.com/yourusername/shopping-cart.git
2.Import into Eclipse as a Maven or Dynamic Web Project.
3.Configure Tomcat server in Eclipse.
4.Set up the MySQL database and update credentials in:
  shop_cart_Connection/db_con.java
5.Run the project on the Tomcat server.

