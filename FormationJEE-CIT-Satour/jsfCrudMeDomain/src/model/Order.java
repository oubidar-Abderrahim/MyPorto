package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name ="`Order`")
@NamedQueries({
	
	@NamedQuery(name="getAllOrders", query="SELECT o FROM Order o"),
	@NamedQuery(name="getFirstOrder", query="SELECT o FROM Order o WHERE o.orderNo = 7")
	
})
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderNo;

	private int price;

	private String productName;

	private int qty;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category category;

	public Order() {
	}

	public int getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String toString(){
		
		return productName;
		
	}
}