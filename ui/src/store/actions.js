import $ from 'jquery'
import Vue from 'vue'
let echarts = require('echarts');
function makeJsonRequest(url, method, data) {
    if (method == "GET") {
        data = null;
    }
    return new Promise(function (resolve, reject) {
        $.ajax({
            url: Vue.prototype.appConfig.apiBase + url,
            type: method,
            contentType: 'application/json; charset=utf-8',
            data: data != null ? JSON.stringify(data) : null,
            cache: false,
            success: (data) => {
                if (data.code === 0) {
                    resolve(data.data);
                } else {
                    reject(data);
                }
            },
            error: (data) => {
                reject(data);
            }
        });
    });
}

export const makeObjectOperation = function (context, baseUrl, action, object) {
    let name = baseUrl.split("/").reverse()[0];
    let url = null;
    if (action == "update" && !object.id) {
        action = "create";
    }
    if (action == "create" || action == "list") {
        url = baseUrl;
    } else if (object === null) {
        url = baseUrl;
    } else {
        url = baseUrl + "/" + object.id;
    }
    let method = {
        "list": "GET",
        "create": "POST",
        "get": "GET",
        "update": "POST",
        "delete": "DELETE",
        "put": "PUT"
    }[action];
    return makeJsonRequest(url, method, object).then(function (result) {
        if (action == "list") {
            context.commit("UPDATE_BUSINESS_BY_NAME", {
                name: name + "List",
                value: result
            });
        } else {
            result = result || {};
            context.commit("UPDATE_BUSINESS_BY_NAME", {
                name: name,
                value: result
            });
        }
        return result;
    });
};

export const clearToken = function ({commit}) {
    commit('CLEARTOKEN')
};

export const setToken = function ({commit}, user) {
    commit('SETTOKEN', user)
};

export const setEmail = function ({commit}, email) {
    commit('SETEMAIL', email)
};

export const systemOperation = function (context, {action, system}) {
    return makeObjectOperation(context, "/api/business/system", action, system);
};
export const jobOperation = function (context, {action, job}) {
    return makeObjectOperation(context, "/api/business/job", action, job);
};
export const taskOperation = function (context, {action, task}) {
    return makeObjectOperation(context, "/api/business/task", action, task);
};
export const nodeOperation = function (context, {action, node}) {
    return makeObjectOperation(context, "/api/node", action, node);
};

export const packageOperation = function (context, {action, pkg}) {
    return makeObjectOperation(context, "/api/package", action, pkg);
};

export const alertEventOperation = function (context, {action, event}) {
    return makeObjectOperation(context, "/api/alert/event", action, event);
};
export const alertRuleOperation = function (context, {action, rule}) {
    return makeObjectOperation(context, "/api/alert/rule", action, rule);
};

export const getChartdata = function ({commit}, param, myChart) {
    return makeJsonRequest('/api/metric/getChartData', 'POST', param).then(
        function (data) {
            if (data.length > 0) {
                data[data.length - 1].isLast = true;
            }
            return data;
        }
    )
}

export const userGetCurrent = function (context) {
    return makeJsonRequest("/api/user/current", "GET", null).then(function (data) {
        context.commit("SETUSER", data);
        return data;
    });
}

export const getLogs = function (context) {
    return makeJsonRequest("/api/logs/getUserOperationRecordInfos", "GET", null).then(function (data) {
        context.commit("GETLOGS", data);
        return data;
    });
}

export const moduleOperation = function (context, {action, module}) {
    return makeObjectOperation(context, "/api/appModule", action, module);
};

export const moduleCheckOperation = function (context, {action, moduleCheck}) {
    return makeObjectOperation(context, '/api/moduleCheck', action, moduleCheck);
};

export const homeOperation = function (context, {action}) {
    return makeObjectOperation(context, '/api/business/allInfo', action, null);
};



