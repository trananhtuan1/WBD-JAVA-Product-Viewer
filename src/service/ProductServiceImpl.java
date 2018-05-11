package service;

import models.Product;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/product_viewer";
    static final String DB_USER="root";
    static final String DB_PASSWORD="123456";

    public ProductServiceImpl(){
    }

    @Override
    public List<Product> findAll() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        Connection conn = null;
        Statement stmt = null;

        log("dang ket noi toi co so du lieu ...");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        log("tao truy van SQL...");
        stmt = conn.createStatement();
        String sql;
        sql ="SELECT id, code, name, price FROM product";

        log("Dang thuc hien truy van ....");
        ResultSet rs = stmt.executeQuery(sql);

        List<Product> products = new ArrayList<>();
        log("dang thu nhap ket qua.......");
        while(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setCode(rs.getString("code"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getFloat("price"));

            products.add(product);
        }

        log("hoan thanh nhiem vu thu thap kq. dang dong cac ket noi....");
        rs.close();
        stmt.close();
        conn.close();

        log("xong het");
        return products;
    }

    private void log(String message) {
        System.out.println("Dịch vụ sản phẩm" + message);
    }
}
