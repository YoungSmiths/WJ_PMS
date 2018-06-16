package com.wj.pms.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardOrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardOrdersExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNull() {
            addCriterion("parent_order_id is null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNotNull() {
            addCriterion("parent_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdEqualTo(String value) {
            addCriterion("parent_order_id =", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotEqualTo(String value) {
            addCriterion("parent_order_id <>", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThan(String value) {
            addCriterion("parent_order_id >", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_order_id >=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThan(String value) {
            addCriterion("parent_order_id <", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThanOrEqualTo(String value) {
            addCriterion("parent_order_id <=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLike(String value) {
            addCriterion("parent_order_id like", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotLike(String value) {
            addCriterion("parent_order_id not like", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIn(List<String> values) {
            addCriterion("parent_order_id in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotIn(List<String> values) {
            addCriterion("parent_order_id not in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdBetween(String value1, String value2) {
            addCriterion("parent_order_id between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotBetween(String value1, String value2) {
            addCriterion("parent_order_id not between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andVersionHouseIsNull() {
            addCriterion("version_house is null");
            return (Criteria) this;
        }

        public Criteria andVersionHouseIsNotNull() {
            addCriterion("version_house is not null");
            return (Criteria) this;
        }

        public Criteria andVersionHouseEqualTo(String value) {
            addCriterion("version_house =", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseNotEqualTo(String value) {
            addCriterion("version_house <>", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseGreaterThan(String value) {
            addCriterion("version_house >", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseGreaterThanOrEqualTo(String value) {
            addCriterion("version_house >=", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseLessThan(String value) {
            addCriterion("version_house <", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseLessThanOrEqualTo(String value) {
            addCriterion("version_house <=", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseLike(String value) {
            addCriterion("version_house like", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseNotLike(String value) {
            addCriterion("version_house not like", value, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseIn(List<String> values) {
            addCriterion("version_house in", values, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseNotIn(List<String> values) {
            addCriterion("version_house not in", values, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseBetween(String value1, String value2) {
            addCriterion("version_house between", value1, value2, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andVersionHouseNotBetween(String value1, String value2) {
            addCriterion("version_house not between", value1, value2, "versionHouse");
            return (Criteria) this;
        }

        public Criteria andOpenPaperIsNull() {
            addCriterion("open_paper is null");
            return (Criteria) this;
        }

        public Criteria andOpenPaperIsNotNull() {
            addCriterion("open_paper is not null");
            return (Criteria) this;
        }

        public Criteria andOpenPaperEqualTo(String value) {
            addCriterion("open_paper =", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperNotEqualTo(String value) {
            addCriterion("open_paper <>", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperGreaterThan(String value) {
            addCriterion("open_paper >", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperGreaterThanOrEqualTo(String value) {
            addCriterion("open_paper >=", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperLessThan(String value) {
            addCriterion("open_paper <", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperLessThanOrEqualTo(String value) {
            addCriterion("open_paper <=", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperLike(String value) {
            addCriterion("open_paper like", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperNotLike(String value) {
            addCriterion("open_paper not like", value, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperIn(List<String> values) {
            addCriterion("open_paper in", values, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperNotIn(List<String> values) {
            addCriterion("open_paper not in", values, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperBetween(String value1, String value2) {
            addCriterion("open_paper between", value1, value2, "openPaper");
            return (Criteria) this;
        }

        public Criteria andOpenPaperNotBetween(String value1, String value2) {
            addCriterion("open_paper not between", value1, value2, "openPaper");
            return (Criteria) this;
        }

        public Criteria andPrintIsNull() {
            addCriterion("print is null");
            return (Criteria) this;
        }

        public Criteria andPrintIsNotNull() {
            addCriterion("print is not null");
            return (Criteria) this;
        }

        public Criteria andPrintEqualTo(String value) {
            addCriterion("print =", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintNotEqualTo(String value) {
            addCriterion("print <>", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintGreaterThan(String value) {
            addCriterion("print >", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintGreaterThanOrEqualTo(String value) {
            addCriterion("print >=", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintLessThan(String value) {
            addCriterion("print <", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintLessThanOrEqualTo(String value) {
            addCriterion("print <=", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintLike(String value) {
            addCriterion("print like", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintNotLike(String value) {
            addCriterion("print not like", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintIn(List<String> values) {
            addCriterion("print in", values, "print");
            return (Criteria) this;
        }

        public Criteria andPrintNotIn(List<String> values) {
            addCriterion("print not in", values, "print");
            return (Criteria) this;
        }

        public Criteria andPrintBetween(String value1, String value2) {
            addCriterion("print between", value1, value2, "print");
            return (Criteria) this;
        }

        public Criteria andPrintNotBetween(String value1, String value2) {
            addCriterion("print not between", value1, value2, "print");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderIsNull() {
            addCriterion("out_side_hander is null");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderIsNotNull() {
            addCriterion("out_side_hander is not null");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderEqualTo(String value) {
            addCriterion("out_side_hander =", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderNotEqualTo(String value) {
            addCriterion("out_side_hander <>", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderGreaterThan(String value) {
            addCriterion("out_side_hander >", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderGreaterThanOrEqualTo(String value) {
            addCriterion("out_side_hander >=", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderLessThan(String value) {
            addCriterion("out_side_hander <", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderLessThanOrEqualTo(String value) {
            addCriterion("out_side_hander <=", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderLike(String value) {
            addCriterion("out_side_hander like", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderNotLike(String value) {
            addCriterion("out_side_hander not like", value, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderIn(List<String> values) {
            addCriterion("out_side_hander in", values, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderNotIn(List<String> values) {
            addCriterion("out_side_hander not in", values, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderBetween(String value1, String value2) {
            addCriterion("out_side_hander between", value1, value2, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOutSideHanderNotBetween(String value1, String value2) {
            addCriterion("out_side_hander not between", value1, value2, "outSideHander");
            return (Criteria) this;
        }

        public Criteria andOpenCardIsNull() {
            addCriterion("open_card is null");
            return (Criteria) this;
        }

        public Criteria andOpenCardIsNotNull() {
            addCriterion("open_card is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCardEqualTo(String value) {
            addCriterion("open_card =", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardNotEqualTo(String value) {
            addCriterion("open_card <>", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardGreaterThan(String value) {
            addCriterion("open_card >", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardGreaterThanOrEqualTo(String value) {
            addCriterion("open_card >=", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardLessThan(String value) {
            addCriterion("open_card <", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardLessThanOrEqualTo(String value) {
            addCriterion("open_card <=", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardLike(String value) {
            addCriterion("open_card like", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardNotLike(String value) {
            addCriterion("open_card not like", value, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardIn(List<String> values) {
            addCriterion("open_card in", values, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardNotIn(List<String> values) {
            addCriterion("open_card not in", values, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardBetween(String value1, String value2) {
            addCriterion("open_card between", value1, value2, "openCard");
            return (Criteria) this;
        }

        public Criteria andOpenCardNotBetween(String value1, String value2) {
            addCriterion("open_card not between", value1, value2, "openCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardIsNull() {
            addCriterion("blunt_card is null");
            return (Criteria) this;
        }

        public Criteria andBluntCardIsNotNull() {
            addCriterion("blunt_card is not null");
            return (Criteria) this;
        }

        public Criteria andBluntCardEqualTo(String value) {
            addCriterion("blunt_card =", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardNotEqualTo(String value) {
            addCriterion("blunt_card <>", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardGreaterThan(String value) {
            addCriterion("blunt_card >", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardGreaterThanOrEqualTo(String value) {
            addCriterion("blunt_card >=", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardLessThan(String value) {
            addCriterion("blunt_card <", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardLessThanOrEqualTo(String value) {
            addCriterion("blunt_card <=", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardLike(String value) {
            addCriterion("blunt_card like", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardNotLike(String value) {
            addCriterion("blunt_card not like", value, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardIn(List<String> values) {
            addCriterion("blunt_card in", values, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardNotIn(List<String> values) {
            addCriterion("blunt_card not in", values, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardBetween(String value1, String value2) {
            addCriterion("blunt_card between", value1, value2, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andBluntCardNotBetween(String value1, String value2) {
            addCriterion("blunt_card not between", value1, value2, "bluntCard");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoIsNull() {
            addCriterion("describe_info is null");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoIsNotNull() {
            addCriterion("describe_info is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoEqualTo(String value) {
            addCriterion("describe_info =", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoNotEqualTo(String value) {
            addCriterion("describe_info <>", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoGreaterThan(String value) {
            addCriterion("describe_info >", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoGreaterThanOrEqualTo(String value) {
            addCriterion("describe_info >=", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoLessThan(String value) {
            addCriterion("describe_info <", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoLessThanOrEqualTo(String value) {
            addCriterion("describe_info <=", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoLike(String value) {
            addCriterion("describe_info like", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoNotLike(String value) {
            addCriterion("describe_info not like", value, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoIn(List<String> values) {
            addCriterion("describe_info in", values, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoNotIn(List<String> values) {
            addCriterion("describe_info not in", values, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoBetween(String value1, String value2) {
            addCriterion("describe_info between", value1, value2, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andDescribeInfoNotBetween(String value1, String value2) {
            addCriterion("describe_info not between", value1, value2, "describeInfo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNull() {
            addCriterion("date_created is null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNotNull() {
            addCriterion("date_created is not null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedEqualTo(Date value) {
            addCriterion("date_created =", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotEqualTo(Date value) {
            addCriterion("date_created <>", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThan(Date value) {
            addCriterion("date_created >", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("date_created >=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThan(Date value) {
            addCriterion("date_created <", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThanOrEqualTo(Date value) {
            addCriterion("date_created <=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIn(List<Date> values) {
            addCriterion("date_created in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotIn(List<Date> values) {
            addCriterion("date_created not in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedBetween(Date value1, Date value2) {
            addCriterion("date_created between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotBetween(Date value1, Date value2) {
            addCriterion("date_created not between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedIsNull() {
            addCriterion("date_updated is null");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedIsNotNull() {
            addCriterion("date_updated is not null");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedEqualTo(Date value) {
            addCriterion("date_updated =", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedNotEqualTo(Date value) {
            addCriterion("date_updated <>", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedGreaterThan(Date value) {
            addCriterion("date_updated >", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("date_updated >=", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedLessThan(Date value) {
            addCriterion("date_updated <", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("date_updated <=", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedIn(List<Date> values) {
            addCriterion("date_updated in", values, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedNotIn(List<Date> values) {
            addCriterion("date_updated not in", values, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedBetween(Date value1, Date value2) {
            addCriterion("date_updated between", value1, value2, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("date_updated not between", value1, value2, "dateUpdated");
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