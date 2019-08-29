package com.ServiceNode.bean;

import java.util.ArrayList;
import java.util.List;

public class ContextExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContextExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andCtitleIsNull() {
            addCriterion("ctitle is null");
            return (Criteria) this;
        }

        public Criteria andCtitleIsNotNull() {
            addCriterion("ctitle is not null");
            return (Criteria) this;
        }

        public Criteria andCtitleEqualTo(String value) {
            addCriterion("ctitle =", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleNotEqualTo(String value) {
            addCriterion("ctitle <>", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleGreaterThan(String value) {
            addCriterion("ctitle >", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleGreaterThanOrEqualTo(String value) {
            addCriterion("ctitle >=", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleLessThan(String value) {
            addCriterion("ctitle <", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleLessThanOrEqualTo(String value) {
            addCriterion("ctitle <=", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleLike(String value) {
            addCriterion("ctitle like", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleNotLike(String value) {
            addCriterion("ctitle not like", value, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleIn(List<String> values) {
            addCriterion("ctitle in", values, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleNotIn(List<String> values) {
            addCriterion("ctitle not in", values, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleBetween(String value1, String value2) {
            addCriterion("ctitle between", value1, value2, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCtitleNotBetween(String value1, String value2) {
            addCriterion("ctitle not between", value1, value2, "ctitle");
            return (Criteria) this;
        }

        public Criteria andCsrcIsNull() {
            addCriterion("csrc is null");
            return (Criteria) this;
        }

        public Criteria andCsrcIsNotNull() {
            addCriterion("csrc is not null");
            return (Criteria) this;
        }

        public Criteria andCsrcEqualTo(String value) {
            addCriterion("csrc =", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcNotEqualTo(String value) {
            addCriterion("csrc <>", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcGreaterThan(String value) {
            addCriterion("csrc >", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcGreaterThanOrEqualTo(String value) {
            addCriterion("csrc >=", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcLessThan(String value) {
            addCriterion("csrc <", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcLessThanOrEqualTo(String value) {
            addCriterion("csrc <=", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcLike(String value) {
            addCriterion("csrc like", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcNotLike(String value) {
            addCriterion("csrc not like", value, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcIn(List<String> values) {
            addCriterion("csrc in", values, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcNotIn(List<String> values) {
            addCriterion("csrc not in", values, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcBetween(String value1, String value2) {
            addCriterion("csrc between", value1, value2, "csrc");
            return (Criteria) this;
        }

        public Criteria andCsrcNotBetween(String value1, String value2) {
            addCriterion("csrc not between", value1, value2, "csrc");
            return (Criteria) this;
        }

        public Criteria andCtextIsNull() {
            addCriterion("ctext is null");
            return (Criteria) this;
        }

        public Criteria andCtextIsNotNull() {
            addCriterion("ctext is not null");
            return (Criteria) this;
        }

        public Criteria andCtextEqualTo(String value) {
            addCriterion("ctext =", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextNotEqualTo(String value) {
            addCriterion("ctext <>", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextGreaterThan(String value) {
            addCriterion("ctext >", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextGreaterThanOrEqualTo(String value) {
            addCriterion("ctext >=", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextLessThan(String value) {
            addCriterion("ctext <", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextLessThanOrEqualTo(String value) {
            addCriterion("ctext <=", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextLike(String value) {
            addCriterion("ctext like", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextNotLike(String value) {
            addCriterion("ctext not like", value, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextIn(List<String> values) {
            addCriterion("ctext in", values, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextNotIn(List<String> values) {
            addCriterion("ctext not in", values, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextBetween(String value1, String value2) {
            addCriterion("ctext between", value1, value2, "ctext");
            return (Criteria) this;
        }

        public Criteria andCtextNotBetween(String value1, String value2) {
            addCriterion("ctext not between", value1, value2, "ctext");
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