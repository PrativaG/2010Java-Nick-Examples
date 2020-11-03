package com.revature.project0.pojos;

/*This is the model that holds information about supplier*/
public class Supplier {
	
	private int supplierId;
	
	private String supplierName;
	
	private String supplierContactNum;
	
	private String email;
	

	public Supplier() {
		super();
	}

	public Supplier(int supplierId, String supplierName, String supplierContactNum, String email) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierContactNum = supplierContactNum;
		this.email = email;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierContactNum() {
		return supplierContactNum;
	}

	public void setSupplierContactNum(String supplierContactNum) {
		this.supplierContactNum = supplierContactNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
