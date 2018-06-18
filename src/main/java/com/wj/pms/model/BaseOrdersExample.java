package com.wj.pms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseOrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseOrdersExample() {
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

        public Criteria andContractIsNull() {
            addCriterion("contract is null");
            return (Criteria) this;
        }

        public Criteria andContractIsNotNull() {
            addCriterion("contract is not null");
            return (Criteria) this;
        }

        public Criteria andContractEqualTo(String value) {
            addCriterion("contract =", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotEqualTo(String value) {
            addCriterion("contract <>", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThan(String value) {
            addCriterion("contract >", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThanOrEqualTo(String value) {
            addCriterion("contract >=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThan(String value) {
            addCriterion("contract <", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThanOrEqualTo(String value) {
            addCriterion("contract <=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLike(String value) {
            addCriterion("contract like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotLike(String value) {
            addCriterion("contract not like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractIn(List<String> values) {
            addCriterion("contract in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotIn(List<String> values) {
            addCriterion("contract not in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractBetween(String value1, String value2) {
            addCriterion("contract between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotBetween(String value1, String value2) {
            addCriterion("contract not between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andPapertypeIsNull() {
            addCriterion("paperType is null");
            return (Criteria) this;
        }

        public Criteria andPapertypeIsNotNull() {
            addCriterion("paperType is not null");
            return (Criteria) this;
        }

        public Criteria andPapertypeEqualTo(String value) {
            addCriterion("paperType =", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeNotEqualTo(String value) {
            addCriterion("paperType <>", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeGreaterThan(String value) {
            addCriterion("paperType >", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeGreaterThanOrEqualTo(String value) {
            addCriterion("paperType >=", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeLessThan(String value) {
            addCriterion("paperType <", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeLessThanOrEqualTo(String value) {
            addCriterion("paperType <=", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeLike(String value) {
            addCriterion("paperType like", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeNotLike(String value) {
            addCriterion("paperType not like", value, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeIn(List<String> values) {
            addCriterion("paperType in", values, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeNotIn(List<String> values) {
            addCriterion("paperType not in", values, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeBetween(String value1, String value2) {
            addCriterion("paperType between", value1, value2, "papertype");
            return (Criteria) this;
        }

        public Criteria andPapertypeNotBetween(String value1, String value2) {
            addCriterion("paperType not between", value1, value2, "papertype");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(String value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(String value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(String value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(String value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(String value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(String value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLike(String value) {
            addCriterion("width like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotLike(String value) {
            addCriterion("width not like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<String> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<String> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(String value1, String value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(String value1, String value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andLengthsIsNull() {
            addCriterion("lengths is null");
            return (Criteria) this;
        }

        public Criteria andLengthsIsNotNull() {
            addCriterion("lengths is not null");
            return (Criteria) this;
        }

        public Criteria andLengthsEqualTo(String value) {
            addCriterion("lengths =", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsNotEqualTo(String value) {
            addCriterion("lengths <>", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsGreaterThan(String value) {
            addCriterion("lengths >", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsGreaterThanOrEqualTo(String value) {
            addCriterion("lengths >=", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsLessThan(String value) {
            addCriterion("lengths <", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsLessThanOrEqualTo(String value) {
            addCriterion("lengths <=", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsLike(String value) {
            addCriterion("lengths like", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsNotLike(String value) {
            addCriterion("lengths not like", value, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsIn(List<String> values) {
            addCriterion("lengths in", values, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsNotIn(List<String> values) {
            addCriterion("lengths not in", values, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsBetween(String value1, String value2) {
            addCriterion("lengths between", value1, value2, "lengths");
            return (Criteria) this;
        }

        public Criteria andLengthsNotBetween(String value1, String value2) {
            addCriterion("lengths not between", value1, value2, "lengths");
            return (Criteria) this;
        }

        public Criteria andPrintRequireIsNull() {
            addCriterion("print_require is null");
            return (Criteria) this;
        }

        public Criteria andPrintRequireIsNotNull() {
            addCriterion("print_require is not null");
            return (Criteria) this;
        }

        public Criteria andPrintRequireEqualTo(String value) {
            addCriterion("print_require =", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireNotEqualTo(String value) {
            addCriterion("print_require <>", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireGreaterThan(String value) {
            addCriterion("print_require >", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireGreaterThanOrEqualTo(String value) {
            addCriterion("print_require >=", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireLessThan(String value) {
            addCriterion("print_require <", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireLessThanOrEqualTo(String value) {
            addCriterion("print_require <=", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireLike(String value) {
            addCriterion("print_require like", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireNotLike(String value) {
            addCriterion("print_require not like", value, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireIn(List<String> values) {
            addCriterion("print_require in", values, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireNotIn(List<String> values) {
            addCriterion("print_require not in", values, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireBetween(String value1, String value2) {
            addCriterion("print_require between", value1, value2, "printRequire");
            return (Criteria) this;
        }

        public Criteria andPrintRequireNotBetween(String value1, String value2) {
            addCriterion("print_require not between", value1, value2, "printRequire");
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

        public Criteria andPackageRequireIsNull() {
            addCriterion("package_require is null");
            return (Criteria) this;
        }

        public Criteria andPackageRequireIsNotNull() {
            addCriterion("package_require is not null");
            return (Criteria) this;
        }

        public Criteria andPackageRequireEqualTo(String value) {
            addCriterion("package_require =", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireNotEqualTo(String value) {
            addCriterion("package_require <>", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireGreaterThan(String value) {
            addCriterion("package_require >", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireGreaterThanOrEqualTo(String value) {
            addCriterion("package_require >=", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireLessThan(String value) {
            addCriterion("package_require <", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireLessThanOrEqualTo(String value) {
            addCriterion("package_require <=", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireLike(String value) {
            addCriterion("package_require like", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireNotLike(String value) {
            addCriterion("package_require not like", value, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireIn(List<String> values) {
            addCriterion("package_require in", values, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireNotIn(List<String> values) {
            addCriterion("package_require not in", values, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireBetween(String value1, String value2) {
            addCriterion("package_require between", value1, value2, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPackageRequireNotBetween(String value1, String value2) {
            addCriterion("package_require not between", value1, value2, "packageRequire");
            return (Criteria) this;
        }

        public Criteria andPartsIsNull() {
            addCriterion("parts is null");
            return (Criteria) this;
        }

        public Criteria andPartsIsNotNull() {
            addCriterion("parts is not null");
            return (Criteria) this;
        }

        public Criteria andPartsEqualTo(String value) {
            addCriterion("parts =", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsNotEqualTo(String value) {
            addCriterion("parts <>", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsGreaterThan(String value) {
            addCriterion("parts >", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsGreaterThanOrEqualTo(String value) {
            addCriterion("parts >=", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsLessThan(String value) {
            addCriterion("parts <", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsLessThanOrEqualTo(String value) {
            addCriterion("parts <=", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsLike(String value) {
            addCriterion("parts like", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsNotLike(String value) {
            addCriterion("parts not like", value, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsIn(List<String> values) {
            addCriterion("parts in", values, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsNotIn(List<String> values) {
            addCriterion("parts not in", values, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsBetween(String value1, String value2) {
            addCriterion("parts between", value1, value2, "parts");
            return (Criteria) this;
        }

        public Criteria andPartsNotBetween(String value1, String value2) {
            addCriterion("parts not between", value1, value2, "parts");
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