<template>
    <tr>
        <td>{{item.userName}}</td>
        <td>{{item.realName}}</td>
        <td>{{item.email}}</td>
        <td class='role'>{{item.userType==='super'?'超级管理员':item.userType==='admin'?'管理员':'普通用户'}}</td>
        <td class='status'>
            <div v-if="item.userStatus ==='success'" class='success'>
                <img src="../../../static/img/green.png" height="12" width="12" alt="">
            </div>
            <div v-if="item.userStatus ==='denied'" class='failed'>
                <img src="../../../static/img/gray.png" height="12" width="12" alt="">
            </div>
        </td>
        <td class="operation">
            <div v-if="item.userType!=='super'" id='userIcon'>
                <div @click="confirm" class='pass' v-if="item.userStatus==='registering'" title='通过审核'>
                    <span class='passExam' title='通过审核'></span>
                </div>
                <div class="sheng" @click="admin" v-else-if="item.userType==='general'" title='升级为管理员'>
                    <span class='shengManager' title='升级为管理员'></span>
                </div>
                <div class="down" @click="general" v-else-if="item.userType==='admin'" title='降级为普通用户'>
                    <span class='downUser' title='降级为普通用户'></span>
                </div>
                <div class="free" @click="freeze" v-if="item.userStatus==='success'" title='冻结用户'>
                    <span class='freeze' title='冻结用户'></span>
                </div>
                <div class="act" @click="confirm" v-if="item.userStatus==='denied'" title='解冻用户'>
                    <span class='active' title='解冻用户'></span>
                </div>
                <div class="del" @click="remove" title='删除用户'>
                    <span class='delete' title='删除用户'> </span>
                </div>
            </div>
        </td>
    </tr>
</template>
<script type="text/ecmascript-6">
    import { mapGetters } from 'vuex'
    import $ from 'jquery'
    import Vue from 'vue'

    export default {
        props: ['item', 'isLast'],
        data () {
            return {}
        },
        computed: {
            ...mapGetters({
                user: 'user'
            })
        },
        methods: {
            confirm () {
                let param = {
                    userName: this.item.userName,
                    userStatus: 'success'
                }
                this.updateUser(param);
            },
            freeze () {
                let param = {
                    userName: this.item.userName,
                    userStatus: 'denied'
                }
                this.updateUser(param);
            },
            admin () {
                let param = {
                    userName: this.item.userName,
                    userType: 'admin'
                }
                this.authorization(param)
            },
            general () {
                let param = {
                    userName: this.item.userName,
                    userType: 'general'
                }
                this.authorization(param)
            },
            updateUser (param) {
                $.ajax({
                    url: `${this.apiBase}/api/user/updateUserStatus/${this.user.username}`,
                    type: 'POST',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(param),
                    cache: false,
                    success: (data) => {
                        if (data.code === 0) {
                            this.$message.alert('用户状态更新成功！');
                            this.$emit('refreshUserList')
                        } else {
                            this.appConfig.showErrorAlert(data.code);
                        }
                    },
                    error: (data) => {
                        this.appConfig.showErrorAlert('default');
                    }
                })
            },
            authorization (param) {
                $.ajax({
                    url: `${this.apiBase}/api/user/authorization/${this.user.username}`,
                    type: 'POST',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(param),
                    cache: false,
                    success: (data) => {
                        if (data.code === 0) {
                            this.$message.alert('用户状态更新成功！');
                            this.$emit('refreshUserList')
                        } else {
                            this.appConfig.showErrorAlert(data.code);
                        }

                    },
                    error: (data) => {
                        this.appConfig.showErrorAlert('default');
                    }
                })
            },
            remove () {
                this.$message.delModal({
                    header: '请确认是否要删除该用户',
                    body: '',
                    primaryClick: ()=> {
                        let param = {
                            userName: this.item.userName
                        }
                        $.ajax({
                            url: `${this.apiBase}/api/user/delete/${this.user.username}`,
                            type: 'POST',
                            contentType: 'application/json; charset=utf-8',
                            data: JSON.stringify(param),
                            cache: false,
                            success: (data) => {
                                if (data.code === 0) {
                                    this.$message.hide('delModal');
                                    this.$message.alert('删除成功！');
                                    this.$emit('refreshUserList')
                                } else {
                                    this.appConfig.showErrorAlert(data.code);
                                }
                            },
                            error: (data) => {
                                this.appConfig.showErrorAlert();
                            }
                        })
                    }
                })
            }
        },
        mounted () {
            if (this.isLast) {
                $('.project-table').dataTable(this.appConfig.dataTableChinese('用户名'));
            }
        }
    }
</script>
<style>
    #Userthead .role, #Userthead .status {
        width: 140px;
    }

    #Userthead .operation {
        width: 280px;
    }

    #Usertbody .status div {
        margin-left: 10px;
    }

    #userIcon div {
        width: 38px;
        height: 20px;
        margin-right: 21px;
        border-radius: 16px;
        box-shadow: none;
        display: inline-block;
        text-align: center;
        padding-top: 5px;
        transition: all 1s;
    }

    .pass span {
        width: 17px;
        height: 17px;
        display: inline-block;
        background: url(../../../static/img/pass.png) no-repeat;
    }

    .pass:hover {
        background-color: #e3f2fa;
    }

    .pass:hover span {
        background: url(../../../static/img/Cpass.png) no-repeat;
    }

    .sheng span {
        width: 17px;
        height: 17px;
        display: inline-block;
        background: url(../../../static/img/upji.png) no-repeat;
    }

    .sheng:hover {
        background-color: #e3f2fa;
    }

    .sheng:hover span {
        background: url(../../../static/img/Cupji.png) no-repeat;
    }

    .down span {
        width: 17px;
        height: 17px;
        display: inline-block;
        background: url(../../../static/img/downji.png) no-repeat;
    }

    .down:hover {
        background-color: #e3f2fa;
    }

    .down:hover span {
        background: url(../../../static/img/Cdownji.png) no-repeat;
    }

    .free span {
        width: 17px;
        height: 17px;
        display: inline-block;
        background: url(../../../static/img/dongjie.png) no-repeat;
    }

    .free:hover {
        background-color: #e3f2fa;
    }

    .free:hover span {
        background: url(../../../static/img/Cdongjie.png) no-repeat;
    }

    .act span {
        width: 17px;
        height: 17px;
        display: inline-block;
        background: url(../../../static/img/act.png) no-repeat;
    }

    .act:hover {
        background-color: #e3f2fa;
    }

    .act:hover span {
        background: url(../../../static/img/Cact.png) no-repeat;
    }

    .del span {
        width: 17px;
        height: 17px;
        display: inline-block;
        background: url(../../../static/img/del.png) no-repeat;
    }

    .del:hover {
        background-color: #e3f2fa;
    }

    .del:hover span {
        background: url(../../../static/img/Cdel.png) no-repeat;
    }
</style>
