import Vue from 'vue'
import Router from 'vue-router'

import AlertRoot from '../components/module/alert/AlertRoot.vue'
import AlertEventRoot from '../components/module/alert/AlertEventRoot.vue'
import AlertEventList from '../components/module/alert/AlertEventList.vue'
import AlertEventDetail from '../components/module/alert/AlertEventDetail.vue'
import AlertRuleRoot from '../components/module/alert/AlertRuleRoot.vue'
import AlertRuleList from '../components/module/alert/AlertRuleList.vue'
import AlertRuleDetail from '../components/module/alert/AlertRuleDetail.vue'

import BusinessRoot from '../components/module/system/BusinessRoot.vue'

import SystemRoot from '../components/module/system/SystemRoot.vue'
import SystemList from '../components/module/system/SystemList.vue'
import SystemDetail from '../components/module/system/SystemDetail.vue'

import JobRoot from '../components/module/system/JobRoot.vue'
import JobList from '../components/module/system/JobList.vue'
import JobDetail from '../components/module/system/JobDetail.vue'

import TaskRoot from '../components/module/system/TaskRoot.vue'
import TaskList from '../components/module/system/TaskList.vue'
import TaskDetail from '../components/module/system/TaskDetail.vue'

import NodeRoot from '../components/module/node/NodeRoot.vue'
import NodeList from '../components/module/node/NodeList.vue'
import NodeDetail from '../components/module/node/NodeDetail.vue'

import PackageRoot from '../components/module/package/PackageRoot.vue'
import PackageList from '../components/module/package/PackageList.vue'
import PackageDetail from '../components/module/package/PackageDetail.vue'

import Home from '../components/module/home/Home.vue'
import Root from '../components/module/Root.vue'
import User from '../components/user/User.vue'

import Echarts from '../components/module/alert/Echarts.vue'

import LogRoot from '../components/module/log/LogRoot.vue'
import LogList from '../components/module/log/LogList.vue'

import AppModuleRoot from '../components/module/appmodule/AppModuleRoot.vue'
import AppModuleList from '../components/module/appmodule/AppModuleList.vue'
import AppModuleDetail from '../components/module/appmodule/AppModuleDetail.vue'
import AppModuleCheckDetail from '../components/module/appmodule/AppModuleCheckDetail.vue'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'root',
            component: Root,
            redirect: '/home',
            children: [
                {
                    path: '/home',
                    name: 'home',
                    component: Home,
                    meta: {
                        breadcrumb: '首页'
                    }
                }, {
                    path: 'business',
                    component: BusinessRoot,
                    redirect: '/business/system',
                    meta: {
                        breadcrumb: '业务系统'
                    },
                    children: [
                        {
                            path: 'system',
                            component: SystemRoot,
                            meta: {
                                breadcrumb: '业务列表'
                            },
                            children: [
                                {
                                    path: '',
                                    name: 'systemList',
                                    component: SystemList
                                }, {
                                    path: ':systemId',
                                    name: 'systemDetail',
                                    component: SystemDetail,
                                    meta: {
                                        breadcrumb: '业务详情'
                                    }
                                }, {
                                    path: ':systemId/job/:jobId',
                                    name: 'systemJobDetail',
                                    component: JobDetail,
                                    meta: {
                                        breadcrumb: '业务详情'
                                    }
                                }, {
                                    path: ':systemId/module/:moduleId',
                                    name: 'systemModuleDetail',
                                    component: AppModuleDetail,
                                    meta: {
                                        breadcrumb: '业务模块详情'
                                    }
                                }
                            ]
                        }, {
                            path: 'job',
                            component: JobRoot,
                            meta: {
                                breadcrumb: '作业列表'
                            },
                            children: [
                                {
                                    path: '',
                                    name: 'jobList',
                                    component: JobList
                                }, {
                                    path: ':jobId',
                                    name: 'jobDetail',
                                    component: JobDetail,
                                    meta: {
                                        breadcrumb: '作业详情'
                                    }
                                }, {
                                    path: ':jobId/task/:taskId',
                                    name: 'jobTaskDetail',
                                    component: TaskDetail,
                                    meta: {
                                        breadcrumb: '任务详情'
                                    }
                                }
                            ]
                        }, {
                            path: 'task',
                            component: TaskRoot,
                            meta: {
                                breadcrumb: '任务列表'
                            },
                            children: [
                                {
                                    path: '',
                                    name: 'taskList',
                                    component: TaskList
                                }, {
                                    path: ':taskId',
                                    name: 'taskDetail',
                                    component: TaskDetail,
                                    meta: {
                                        breadcrumb: '任务详情'
                                    }
                                }
                            ]
                        }
                    ]
                }, {
                    path: "/node",
                    component: NodeRoot,
                    meta: {
                        breadcrumb: '节点信息'
                    },
                    children: [
                        {
                            path: '',
                            name: 'nodeList',
                            component: NodeList
                        }, {
                            path: ':nodeId',
                            name: 'nodeDetail',
                            component: NodeDetail,
                            meta: {
                                breadcrumb: '结点详情'
                            }
                        }
                    ]

                }, {
                    path: '/package',
                    component: PackageRoot,
                    meta: {
                        breadcrumb: '软件包管理'
                    },
                    children: [
                        {
                            path: '',
                            name: 'packageList',
                            component: PackageList
                        }, {
                            path: ':packageId',
                            name: 'packageDetail',
                            component: PackageDetail,
                            meta: {
                                breadcrumb: '软件包详情'
                            }
                        }
                    ]
                }, {
                    path: '/module',
                    component: AppModuleRoot,
                    meta: {
                        breadcrumb: '业务模块'
                    },
                    children: [
                        {
                            path: '',
                            name: 'moduleList',
                            component: AppModuleList
                        }, {
                            path: ':moduleId',
                            name: 'moduleDetail',
                            component: AppModuleDetail,
                            meta: {
                                breadcrumb: '业务模块详情'
                            }
                        }, {
                            path: ':moduleId/moduleCheck/:moduleCheckId',
                            name: 'moduleCheckDetail',
                            component: AppModuleCheckDetail,
                            meta: {
                                breadcrumb: 'URL详情'
                            }
                        }
                    ]
                }, {
                    path: '/monitor',
                    component: AlertEventList,
                    meta: {
                        breadcrumb: '监控报警'
                    },
                    children: [
                        {
                            path: '/metric',
                            name: 'monitor',
                            component: Echarts
                        }
                    ]
                }, {
                    path: '/alert',
                    component: AlertRoot,
                    meta: {
                        breadcrumb: '报警管理'
                    },
                    children: [
                        {
                            path: 'event',
                            component: AlertEventRoot,
                            meta: {
                                breadcrumb: '报警列表'
                            },
                            children: [
                                {
                                    path: '',
                                    name: 'alertEventList',
                                    component: AlertEventList
                                }, {
                                    path: ':alertEventId',
                                    name: 'alertEventDetail',
                                    component: AlertEventDetail,
                                    meta: {
                                        breadcrumb: '报警详情'
                                    }
                                }
                            ]
                        },
                        {
                            path: 'rule',
                            component: AlertRuleRoot,
                            meta: {
                                breadcrumb: '报警规则列表'
                            },
                            children: [
                                {
                                    path: '',
                                    name: 'alertRuleList',
                                    component: AlertRuleList
                                }, {
                                    path: ':alertRuleId',
                                    name: 'alertRuleDetail',
                                    component: AlertRuleDetail,
                                    meta: {
                                        breadcrumb: '报警规则详情'
                                    }
                                }
                            ]
                        }
                    ]
                }, {
                    path: '/user',
                    name: 'user',
                    component: User
                }, {
                    path: '/operationRecordList',
                    component: LogRoot,
                    meta: {
                        breadcrumb: '操作日志'
                    },
                    children: [
                        {
                            path: '/',
                            name: 'operationRecordList',
                            component: LogList
                        }
                    ]
                }
            ]
        }
    ]
})

