package services.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import models.Demand;
import models.Product;
import services.ProductInterface;
import utils.IDUtil;
import utils.MailMessage;

public class ProductService implements ProductInterface {

	@Override
	public String addProduct(String prodName, String prodType, String prodInfo, double prodPrice, int prodQuantity,
			InputStream prodImage) {
		// TODO Auto-generated method stub
		String status = null;
		String prodId = IDUtil.generateId();

		Product product = new Product(prodId, prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage);

		status = addProduct(product);

		return status;
	}

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		String status = "Product Registration Failed!";

		if (product.getProdId() == null)
			product.setProdId(IDUtil.generateId());

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("insert into product values(?,?,?,?,?,?,?);");
			ps.setString(1, product.getProdId());
			ps.setString(2, product.getProdName());
			ps.setString(3, product.getProdType());
			ps.setString(4, product.getProdInfo());
			ps.setDouble(5, product.getProdPrice());
			ps.setInt(6, product.getProdQuantity());
			ps.setBlob(7, product.getProdImage());

			int k = ps.executeUpdate();

			if (k > 0) {

				status = "Product Added Successfully with Product Id: " + product.getProdId();

			} else {

				status = "Product Updation Failed!";
			}

		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);

		return status;
	}

	@Override
	public String removeProduct(String prodId) {
		// TODO Auto-generated method stub
		
		String status = "Product Removal Failed!";

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			ps = con.prepareStatement("delete from product where pid=?");
			ps.setString(1, prodId);

			int k = ps.executeUpdate();

			if (k > 0) {
				status = "Product Removed Successfully!";

				ps2 = con.prepareStatement("delete from usercart where prodid=?");

				ps2.setString(1, prodId);

				ps2.executeUpdate();

			}

		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);
		DBConnection.closeConnection(ps2);

		return status;
	}

	@Override
	public String updateProduct(Product prevProduct, Product updatedProduct) {
		// TODO Auto-generated method stub
		
		String status = "Product Updation Failed!";

		if (!prevProduct.getProdId().equals(updatedProduct.getProdId())) {

			status = "Both Products are Different, Updation Failed!";

			return status;
		}

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"update product set pname=?,ptype=?,pinfo=?,pprice=?,pquantity=?,image=? where pid=?");

			ps.setString(1, updatedProduct.getProdName());
			ps.setString(2, updatedProduct.getProdType());
			ps.setString(3, updatedProduct.getProdInfo());
			ps.setDouble(4, updatedProduct.getProdPrice());
			ps.setInt(5, updatedProduct.getProdQuantity());
			ps.setBlob(6, updatedProduct.getProdImage());
			ps.setString(7, prevProduct.getProdId());

			int k = ps.executeUpdate();

			if (k > 0)
				status = "Product Updated Successfully!";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);

		return status;
	}

	@Override
	public String updateProductPrice(String prodId, double updatedPrice) {
		// TODO Auto-generated method stub
		
		String status = "Price Updation Failed!";

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("update product set pprice=? where pid=?");

			ps.setDouble(1, updatedPrice);
			ps.setString(2, prodId);

			int k = ps.executeUpdate();

			if (k > 0)
				status = "Price Updated Successfully!";
		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);

		return status;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> products = new ArrayList<Product>();

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from product");

			rs = ps.executeQuery();

			while (rs.next()) {

				Product product = new Product();

				product.setProdId(rs.getString(1));
				product.setProdName(rs.getString(2));
				product.setProdType(rs.getString(3));
				product.setProdInfo(rs.getString(4));
				product.setProdPrice(rs.getDouble(5));
				product.setProdQuantity(rs.getInt(6));
				product.setProdImage(rs.getAsciiStream(7));

				products.add(product);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);
		DBConnection.closeConnection(rs);

		return products;
	}

	@Override
	public List<Product> getAllProductsByType(String type) {
		// TODO Auto-generated method stub
		
		List<Product> products = new ArrayList<Product>();

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * FROM `origin_tech`.product where lower(ptype) like ?;");
			ps.setString(1, "%" + type + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				Product product = new Product();

				product.setProdId(rs.getString(1));
				product.setProdName(rs.getString(2));
				product.setProdType(rs.getString(3));
				product.setProdInfo(rs.getString(4));
				product.setProdPrice(rs.getDouble(5));
				product.setProdQuantity(rs.getInt(6));
				product.setProdImage(rs.getAsciiStream(7));

				products.add(product);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);
		DBConnection.closeConnection(rs);

		return products;
	}

	@Override
	public List<Product> searchAllProducts(String search) {
		// TODO Auto-generated method stub
		
		List<Product> products = new ArrayList<Product>();

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(
					"SELECT * FROM `origin_tech`.product where lower(ptype) like ? or lower(pname) like ? or lower(pinfo) like ?");
			search = "%" + search + "%";
			ps.setString(1, search);
			ps.setString(2, search);
			ps.setString(3, search);
			rs = ps.executeQuery();

			while (rs.next()) {

				Product product = new Product();

				product.setProdId(rs.getString(1));
				product.setProdName(rs.getString(2));
				product.setProdType(rs.getString(3));
				product.setProdInfo(rs.getString(4));
				product.setProdPrice(rs.getDouble(5));
				product.setProdQuantity(rs.getInt(6));
				product.setProdImage(rs.getAsciiStream(7));

				products.add(product);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);
		DBConnection.closeConnection(rs);

		return products;
	}

	@Override
	public byte[] getImage(String prodId) {
		// TODO Auto-generated method stub
		byte[] image = null;

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select image from product where  pid=?");

			ps.setString(1, prodId);

			rs = ps.executeQuery();

			if (rs.next())
				image = rs.getBytes("image");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);
		DBConnection.closeConnection(rs);

		return image;
		
	}

	@Override
	public Product getProductDetails(String prodId) {
		// TODO Auto-generated method stub
		
		Product product = null;

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from product where pid=?");

			ps.setString(1, prodId);
			rs = ps.executeQuery();

			if (rs.next()) {
				product = new Product();
				product.setProdId(rs.getString(1));
				product.setProdName(rs.getString(2));
				product.setProdType(rs.getString(3));
				product.setProdInfo(rs.getString(4));
				product.setProdPrice(rs.getDouble(5));
				product.setProdQuantity(rs.getInt(6));
				product.setProdImage(rs.getAsciiStream(7));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);

		return product;
	}

	@Override
	public String updateProductWithoutImage(String prevProductId, Product updatedProduct) {
		// TODO Auto-generated method stub
		
		String status = "Product Updation Failed!";

		if (!prevProductId.equals(updatedProduct.getProdId())) {

			status = "Both Products are Different, Updation Failed!";

			return status;
		}  

		int prevQuantity = new ProductService().getProductQuantity(prevProductId);
		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("update product set pname=?,ptype=?,pinfo=?,pprice=?,pquantity=?,image=? where pid=?");

			ps.setString(1, updatedProduct.getProdName());
			ps.setString(2, updatedProduct.getProdType());
			ps.setString(3, updatedProduct.getProdInfo());
			ps.setDouble(4, updatedProduct.getProdPrice());
			ps.setInt(5, updatedProduct.getProdQuantity());
			ps.setBlob(6, updatedProduct.getProdImage());
			ps.setString(7, prevProductId);

			int k = ps.executeUpdate();
			// System.out.println("prevQuantity: "+prevQuantity);
			if ((k > 0) && (prevQuantity < updatedProduct.getProdQuantity())) {
				status = "Product Updated Successfully!";
				// System.out.println("updated!");
				List<Demand> demandList = new DemandService().haveDemanded(prevProductId);

				for (Demand demand : demandList) {

					String userFName = new UserService().getFName(demand.getUserName());
					try {
						MailMessage.productAvailableNow(demand.getUserName(), userFName, updatedProduct.getProdName(),
								prevProductId);
					} catch (Exception e) {
						System.out.println("Mail Sending Failed: " + e.getMessage());
					}
					boolean flag = new DemandService().removeProduct(demand.getUserName(), prevProductId);

					if (flag)
						status += " And Mail Send to the customers who were waiting for this product!";
				}
			} else if (k > 0)
				status = "Product Updated Successfully!";
			else
				status = "Product Not available in the store!";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);
		// System.out.println("Prod Update status : "+status);

		return status;
	}

	@Override
	public double getProductPrice(String prodId) {
		// TODO Auto-generated method stub
		
		double price = 0;

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from product where pid=?");

			ps.setString(1, prodId);
			rs = ps.executeQuery();

			if (rs.next()) {
				price = rs.getDouble("pprice");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);

		return price;

	}

	@Override
	public boolean sellNProduct(String prodId, int n) {
		// TODO Auto-generated method stub
		
		boolean flag = false;

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement("update product set pquantity=(pquantity - ?) where pid=?");

			ps.setInt(1, n);

			ps.setString(2, prodId);

			int k = ps.executeUpdate();

			if (k > 0)
				flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);

		return flag;
	}

	@Override
	public int getProductQuantity(String prodId) {
		// TODO Auto-generated method stub
		
		int quantity = 0;

		Connection con = DBConnection.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from product where pid=?");

			ps.setString(1, prodId);
			rs = ps.executeQuery();

			if (rs.next()) {
				quantity = rs.getInt("pquantity");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(con);
		DBConnection.closeConnection(ps);

		return quantity;
	}

	
}
