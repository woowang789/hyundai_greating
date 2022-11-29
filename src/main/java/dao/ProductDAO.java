package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.GrtVO;
import vo.IgdtVO;
import vo.OrderProductBeforeVO;
import vo.ProductDetailVO;
import vo.ProductOptionVO;
import vo.ProductVO;
import vo.SellerVO;

final public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		return instance;
	}

	public ProductDetailVO getProductDetail(int prodId) {
		ProductDetailVO detail = new ProductDetailVO();
		String query = "{call find_prod_by_id(?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setInt(1, prodId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();

			// seller 와 product
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				int pId = rs.getInt(1);
				String prodName = rs.getString(2);
				String thumbImgUrl = rs.getString(3);
				String storage = rs.getString(4);
				String prodSubName = rs.getString(5);
				int maxDiscount = rs.getInt(6);
				int prodCal = rs.getInt(7);
				int prodVol = rs.getInt(8);
				String origin = rs.getString(9);

				String sellerName = rs.getString(10);
				String sellerTel = rs.getString(11);

				int originPrice = rs.getInt(12);
				int marketPrice = rs.getInt(13);
				String prodText = rs.getString(14);
				String prodImgUrl = rs.getString(15);
				String prodPkgImgUrl = rs.getString(16);
				String type = rs.getString(17);
				String contextImgUrl = rs.getString(18);

				ProductVO prod = new ProductVO();
				prod.setId(pId);
				prod.setName(prodName);
				prod.setThumbImgUrl(thumbImgUrl);
				prod.setSubName(prodSubName);
				prod.setStorage(storage);
				prod.setDiscountRate(maxDiscount);
				prod.setOriginPrice(originPrice);
				prod.setMarketPrice(marketPrice);

				detail.setCal(prodCal);
				detail.setVol(prodVol);
				detail.setOrigin(origin);
				detail.setText(prodText);
				detail.setImgUrl(prodImgUrl);
				detail.setPkgUrl(prodPkgImgUrl);
				detail.setType(type);

				if (contextImgUrl.contains(",")) {
					String[] strs = contextImgUrl.split(",");
					for (String s : strs)
						detail.getContextUrls().add(s);
				} else
					detail.getContextUrls().add(contextImgUrl);

				SellerVO seller = new SellerVO();
				seller.setName(sellerName);
				seller.setTel(sellerTel);

				detail.setSeller(seller);
				detail.setProd(prod);
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		int pId = detail.getProd().getId();
		detail.setIgdtList(getIgdtList(pId));
		detail.setGrtList(getGrtList(pId));
		detail.setOptnList(getOptnList(prodId));

		return detail;
	}

	private List<IgdtVO> getIgdtList(int prodId) {
		List<IgdtVO> igdts = new ArrayList<>();
		String query = "{call p_prod_igdt(?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setInt(1, prodId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				int id = rs.getInt(1);
				String iconUrl = rs.getString(2);
				String name = rs.getString(3);

				IgdtVO vo = new IgdtVO();
				vo.setId(id);
				vo.setIconUrl(iconUrl);
				vo.setName(name);

				igdts.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return igdts;
	}

	private List<GrtVO> getGrtList(int prodId) {
		List<GrtVO> grts = new ArrayList<>();
		String query = "{call p_prod_grt(?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setInt(1, prodId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				int id = rs.getInt(1);
				String iconUrl = rs.getString(2);
				String name = rs.getString(3);

				GrtVO vo = new GrtVO();
				vo.setId(id);
				vo.setIconurl(iconUrl);
				vo.setName(name);
				System.out.println(id + " " + name);

				grts.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grts;
	}

	private List<ProductOptionVO> getOptnList(int prodId) {
		List<ProductOptionVO> optns = new ArrayList<>();
		String query = "{call p_prod_optn(?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setInt(1, prodId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int stock = rs.getInt(3);

				ProductOptionVO vo = new ProductOptionVO();
				vo.setId(id);
				vo.setName(name);
				vo.setStock(stock);

				optns.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optns;
	}

	public OrderProductBeforeVO getOrderProduct(int optnId) {
		OrderProductBeforeVO vo = new OrderProductBeforeVO();
		String query = "{call p_get_prod_before_order(?,?,?,?,?,?,?,?,?,?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setInt(1, optnId);
			cstmt.registerOutParameter(2, OracleTypes.NUMBER);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(6, OracleTypes.NUMBER);
			cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(8, OracleTypes.NUMBER);
			cstmt.registerOutParameter(9, OracleTypes.NUMBER);
			cstmt.registerOutParameter(10, OracleTypes.NUMBER);
			cstmt.registerOutParameter(11, OracleTypes.NUMBER);
			
			cstmt.execute();
			
			int prodId = cstmt.getInt(2);
			int optoinId = cstmt.getInt(6);
			String thumbUrl = cstmt.getString(3);
			String type = cstmt.getString(4);
			String prodName = cstmt.getString(5);
			String optnName = cstmt.getString(7);
			int optnStock = cstmt.getInt(8);
			int discntRate = cstmt.getInt(9);
			int originPrice = cstmt.getInt(10);
			int marketPrice = cstmt.getInt(11);
			
			vo.setProdId(prodId);
			vo.setOptnId(optoinId);
			vo.setThumbUrl(thumbUrl);
			vo.setType(type);
			vo.setProdName(prodName);
			vo.setOptnName(optnName);
			vo.setStock(optnStock);
			vo.setDiscountRate(discntRate);
			vo.setOriginPrice(originPrice);
			vo.setMarketPrice(marketPrice);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	public List<ProductVO> getProductList(String cateId) {
		List<ProductVO> list = new ArrayList<>();
		String query = "{call find_prod_by_cate(?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setString(1, cateId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();

			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String thumbUrl = rs.getString(3);
				String storage = rs.getString(4);
				String subName = rs.getString(5);
				int stock = rs.getInt(6);
				String grts = rs.getString(7);
				int discnt = rs.getInt(8);
				int originPrice = rs.getInt(9);
				int marketPrice = rs.getInt(10);

				ProductVO p = new ProductVO();
				p.setId(id);
				p.setThumbImgUrl(thumbUrl);
				p.setName(name);
				p.setSubName(subName);
				p.setStorage(storage);
				p.setOriginPrice(originPrice);
				p.setStock(stock);
				p.setMarketPrice(marketPrice);
				p.setDiscountRate(discnt);
				p.setGrts(grts);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
