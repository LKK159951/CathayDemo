package com.example.demo.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	String disclaimer;
	@Column
	String chartName;
	@Column
	String code;
	@Column
	String symbol;
	@Column
	String rate;
	@Column
	String description;
	@Column
	String rateFloat;
	@Column
	Date updated;
	@Column
	Date updatedISO;
	@Column
	Date updateduk;

	public Currency() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRateFloat() {
		return rateFloat;
	}

	public void setRateFloat(String rateFloat) {
		this.rateFloat = rateFloat;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getUpdatedISO() {
		return updatedISO;
	}

	public void setUpdatedISO(Date updatedISO) {
		this.updatedISO = updatedISO;
	}

	public Date getUpdateduk() {
		return updateduk;
	}

	public void setUpdateduk(Date updateduk) {
		this.updateduk = updateduk;
	}

}
