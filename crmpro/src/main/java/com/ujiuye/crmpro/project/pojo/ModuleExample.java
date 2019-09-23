package com.ujiuye.crmpro.project.pojo;

import java.util.ArrayList;
import java.util.List;

public class ModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleExample() {
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

        public Criteria andProjectnameIsNull() {
            addCriterion("projectname is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("projectname is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("projectname =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("projectname <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("projectname >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("projectname >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("projectname <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("projectname <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("projectname like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("projectname not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("projectname in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("projectname not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("projectname between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("projectname not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkIsNull() {
            addCriterion("analysis_fk is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkIsNotNull() {
            addCriterion("analysis_fk is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkEqualTo(Integer value) {
            addCriterion("analysis_fk =", value, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkNotEqualTo(Integer value) {
            addCriterion("analysis_fk <>", value, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkGreaterThan(Integer value) {
            addCriterion("analysis_fk >", value, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("analysis_fk >=", value, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkLessThan(Integer value) {
            addCriterion("analysis_fk <", value, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkLessThanOrEqualTo(Integer value) {
            addCriterion("analysis_fk <=", value, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkIn(List<Integer> values) {
            addCriterion("analysis_fk in", values, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkNotIn(List<Integer> values) {
            addCriterion("analysis_fk not in", values, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkBetween(Integer value1, Integer value2) {
            addCriterion("analysis_fk between", value1, value2, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andAnalysisFkNotBetween(Integer value1, Integer value2) {
            addCriterion("analysis_fk not between", value1, value2, "analysisFk");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNull() {
            addCriterion("modelname is null");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNotNull() {
            addCriterion("modelname is not null");
            return (Criteria) this;
        }

        public Criteria andModelnameEqualTo(String value) {
            addCriterion("modelname =", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotEqualTo(String value) {
            addCriterion("modelname <>", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThan(String value) {
            addCriterion("modelname >", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThanOrEqualTo(String value) {
            addCriterion("modelname >=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThan(String value) {
            addCriterion("modelname <", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThanOrEqualTo(String value) {
            addCriterion("modelname <=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLike(String value) {
            addCriterion("modelname like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotLike(String value) {
            addCriterion("modelname not like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameIn(List<String> values) {
            addCriterion("modelname in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotIn(List<String> values) {
            addCriterion("modelname not in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameBetween(String value1, String value2) {
            addCriterion("modelname between", value1, value2, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotBetween(String value1, String value2) {
            addCriterion("modelname not between", value1, value2, "modelname");
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