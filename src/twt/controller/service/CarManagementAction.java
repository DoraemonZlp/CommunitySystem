package twt.controller.service;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.opensymphony.xwork2.Action;

import twt.model.CarPassRecord;
import twt.model.Household;

public class CarManagementAction implements Action{
	private Integer id;
	private Household household;
	private String number;
	private CarPassRecord carPassRecord;
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner", nullable = false)
	public Household getHousehold() {
		return this.household;
	}

	public void setHousehold(Household household) {
		this.household = household;
	}

	@Column(name = "number", nullable = false, length = 7)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "car")
	public CarPassRecord getCarPassRecord() {
		return this.carPassRecord;
	}

	public void setCarPassRecord(CarPassRecord carPassRecord) {
		this.carPassRecord = carPassRecord;
	}
public String execute()throws Exception{
	return "success";
}
}
