package com.ujiuye.crmpro.project.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FunctionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPronameIsNull() {
            addCriterion("proname is null");
            return (Criteria) this;
        }

        public Criteria andPronameIsNotNull() {
            addCriterion("proname is not null");
            return (Criteria) this;
        }

        public Criteria andPronameEqualTo(Integer value) {
            addCriterion("proname =", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotEqualTo(Integer value) {
            addCriterion("proname <>", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThan(Integer value) {
            addCriterion("proname >", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThanOrEqualTo(Integer value) {
            addCriterion("proname >=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThan(Integer value) {
            addCriterion("proname <", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThanOrEqualTo(Integer value) {
            addCriterion("proname <=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameIn(List<Integer> values) {
            addCriterion("proname in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotIn(List<Integer> values) {
            addCriterion("proname not in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameBetween(Integer value1, Integer value2) {
            addCriterion("proname between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotBetween(Integer value1, Integer value2) {
            addCriterion("proname not between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameIsNull() {
            addCriterion("analysisname is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameIsNotNull() {
            addCriterion("analysisname is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameEqualTo(Integer value) {
            addCriterion("analysisname =", value, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameNotEqualTo(Integer value) {
            addCriterion("analysisname <>", value, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameGreaterThan(Integer value) {
            addCriterion("analysisname >", value, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameGreaterThanOrEqualTo(Integer value) {
            addCriterion("analysisname >=", value, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameLessThan(Integer value) {
            addCriterion("analysisname <", value, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameLessThanOrEqualTo(Integer value) {
            addCriterion("analysisname <=", value, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameIn(List<Integer> values) {
            addCriterion("analysisname in", values, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameNotIn(List<Integer> values) {
            addCriterion("analysisname not in", values, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameBetween(Integer value1, Integer value2) {
            addCriterion("analysisname between", value1, value2, "analysisname");
            return (Criteria) this;
        }

        public Criteria andAnalysisnameNotBetween(Integer value1, Integer value2) {
            addCriterion("analysisname not between", value1, value2, "analysisname");
            return (Criteria) this;
        }

        public Criteria andModuleFkIsNull() {
            addCriterion("module_fk is null");
            return (Criteria) this;
        }

        public Criteria andModuleFkIsNotNull() {
            addCriterion("module_fk is not null");
            return (Criteria) this;
        }

        public Criteria andModuleFkEqualTo(Integer value) {
            addCriterion("module_fk =", value, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkNotEqualTo(Integer value) {
            addCriterion("module_fk <>", value, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkGreaterThan(Integer value) {
            addCriterion("module_fk >", value, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_fk >=", value, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkLessThan(Integer value) {
            addCriterion("module_fk <", value, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkLessThanOrEqualTo(Integer value) {
            addCriterion("module_fk <=", value, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkIn(List<Integer> values) {
            addCriterion("module_fk in", values, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkNotIn(List<Integer> values) {
            addCriterion("module_fk not in", values, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkBetween(Integer value1, Integer value2) {
            addCriterion("module_fk between", value1, value2, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andModuleFkNotBetween(Integer value1, Integer value2) {
            addCriterion("module_fk not between", value1, value2, "moduleFk");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIsNull() {
            addCriterion("functionname is null");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIsNotNull() {
            addCriterion("functionname is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionnameEqualTo(String value) {
            addCriterion("functionname =", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotEqualTo(String value) {
            addCriterion("functionname <>", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameGreaterThan(String value) {
            addCriterion("functionname >", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameGreaterThanOrEqualTo(String value) {
            addCriterion("functionname >=", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLessThan(String value) {
            addCriterion("functionname <", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLessThanOrEqualTo(String value) {
            addCriterion("functionname <=", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLike(String value) {
            addCriterion("functionname like", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotLike(String value) {
            addCriterion("functionname not like", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIn(List<String> values) {
            addCriterion("functionname in", values, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotIn(List<String> values) {
            addCriterion("functionname not in", values, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameBetween(String value1, String value2) {
            addCriterion("functionname between", value1, value2, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotBetween(String value1, String value2) {
            addCriterion("functionname not between", value1, value2, "functionname");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andSimpledisIsNull() {
            addCriterion("simpledis is null");
            return (Criteria) this;
        }

        public Criteria andSimpledisIsNotNull() {
            addCriterion("simpledis is not null");
            return (Criteria) this;
        }

        public Criteria andSimpledisEqualTo(String value) {
            addCriterion("simpledis =", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisNotEqualTo(String value) {
            addCriterion("simpledis <>", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisGreaterThan(String value) {
            addCriterion("simpledis >", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisGreaterThanOrEqualTo(String value) {
            addCriterion("simpledis >=", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisLessThan(String value) {
            addCriterion("simpledis <", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisLessThanOrEqualTo(String value) {
            addCriterion("simpledis <=", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisLike(String value) {
            addCriterion("simpledis like", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisNotLike(String value) {
            addCriterion("simpledis not like", value, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisIn(List<String> values) {
            addCriterion("simpledis in", values, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisNotIn(List<String> values) {
            addCriterion("simpledis not in", values, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisBetween(String value1, String value2) {
            addCriterion("simpledis between", value1, value2, "simpledis");
            return (Criteria) this;
        }

        public Criteria andSimpledisNotBetween(String value1, String value2) {
            addCriterion("simpledis not between", value1, value2, "simpledis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisIsNull() {
            addCriterion("detaileddis is null");
            return (Criteria) this;
        }

        public Criteria andDetaileddisIsNotNull() {
            addCriterion("detaileddis is not null");
            return (Criteria) this;
        }

        public Criteria andDetaileddisEqualTo(String value) {
            addCriterion("detaileddis =", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisNotEqualTo(String value) {
            addCriterion("detaileddis <>", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisGreaterThan(String value) {
            addCriterion("detaileddis >", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisGreaterThanOrEqualTo(String value) {
            addCriterion("detaileddis >=", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisLessThan(String value) {
            addCriterion("detaileddis <", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisLessThanOrEqualTo(String value) {
            addCriterion("detaileddis <=", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisLike(String value) {
            addCriterion("detaileddis like", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisNotLike(String value) {
            addCriterion("detaileddis not like", value, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisIn(List<String> values) {
            addCriterion("detaileddis in", values, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisNotIn(List<String> values) {
            addCriterion("detaileddis not in", values, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisBetween(String value1, String value2) {
            addCriterion("detaileddis between", value1, value2, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andDetaileddisNotBetween(String value1, String value2) {
            addCriterion("detaileddis not between", value1, value2, "detaileddis");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterionForJDBCDate("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterionForJDBCDate("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterionForJDBCDate("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}