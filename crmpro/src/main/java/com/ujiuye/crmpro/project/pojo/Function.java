package com.ujiuye.crmpro.project.pojo;

import java.util.Date;
import java.util.List;

public class Function {
    private Integer id;

    private Integer proname;

    private Integer analysisname;

    private Integer moduleFk;

    private String functionname;

    private String level;

    private String simpledis;

    private String detaileddis;

    private String remark;

    private Date addtime;

    private Date updatetime;
    
    private List<Integer> ids;
    
    private Project project;
    
    private Analysis analysis;
    
    private Module module;
    
	public List<Integer> getIds() {
		return ids;
	}


	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public Analysis getAnalysis() {
		return analysis;
	}


	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}


	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProname() {
        return proname;
    }

    public void setProname(Integer proname) {
        this.proname = proname;
    }

    public Integer getAnalysisname() {
        return analysisname;
    }

    public void setAnalysisname(Integer analysisname) {
        this.analysisname = analysisname;
    }

    public Integer getModuleFk() {
        return moduleFk;
    }

    public void setModuleFk(Integer moduleFk) {
        this.moduleFk = moduleFk;
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname == null ? null : functionname.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getSimpledis() {
        return simpledis;
    }

    public void setSimpledis(String simpledis) {
        this.simpledis = simpledis == null ? null : simpledis.trim();
    }

    public String getDetaileddis() {
        return detaileddis;
    }

    public void setDetaileddis(String detaileddis) {
        this.detaileddis = detaileddis == null ? null : detaileddis.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}