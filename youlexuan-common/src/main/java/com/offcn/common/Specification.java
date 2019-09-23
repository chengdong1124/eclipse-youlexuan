package com.offcn.common;

import java.io.Serializable;
import java.util.List;

import com.offcn.pojo.TbSpecification;
import com.offcn.pojo.TbSpecificationOption;

public class Specification implements Serializable{
	private TbSpecification tbSpecification;
	private List<TbSpecificationOption> specificationOptionList;

	public Specification(TbSpecification tbSpecification, List<TbSpecificationOption> specificationOptionList) {
		super();
		this.tbSpecification = tbSpecification;
		this.specificationOptionList = specificationOptionList;
	}

	public Specification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TbSpecification getTbSpecification() {
		return tbSpecification;
	}

	public void setTbSpecification(TbSpecification tbSpecification) {
		this.tbSpecification = tbSpecification;
	}

	public List<TbSpecificationOption> getspecificationOptionList() {
		return specificationOptionList;
	}

	public void setspecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}

}
