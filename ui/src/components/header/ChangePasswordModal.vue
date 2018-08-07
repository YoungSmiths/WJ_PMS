<template>
    <div class="modal change-password-modal" v-if="!hidden">
        <div class="modal-dialog">
            <div class="modal-content clearfix">
                <div class="modal-header" id='changePasswordHeader'>修改密码</div>
                <div class="modal-body clearfix">
                    <div class="form-group form-group-changePas">
                        <input type="password"
                               class="oldPassword changePassword"
                               v-model="oldPassword"
                               check-type="required password"
                               required-message="请输入原密码"
                               placeholder="请输入原密码">
                    </div>
                    <div class="form-group form-group-changePas">
                        <input type="password"
                               class="newPassword changePassword"
                               v-model="newPassword"
                               id="newPassword"
                               check-type="required password"
                               required-message="请输入新密码"
                               placeholder="请输入修改密码">
                    </div>
                    <div class="form-group form-group-changePas ">
                        <input type="password"
                               class="rePassword changePassword"
                               check-type="required"
                               equal="#newPassword"
                               required-message="请重复新密码"
                               placeholder="请确认修改密码">
                    </div>
                    <button class="btn btn-pri change-psw-btn" @click="changePassword">确定</button>
                </div>
            </div>
            <span class="modal-close" @click="hide"></span>
        </div>
    </div>
</template>

<script type="text/ecmascript-6">
    import Vue from 'vue'
    import $ from 'jquery'
    import { mapGetters } from 'vuex'
    import SHA1 from 'sha1'


    export default {
        data () {
            return {
                hidden: true,
                oldPassword: '',
                newPassword: ''
            }
        },
        computed: {
            ...mapGetters({
                user: 'user'
            })
        },
        methods: {
            show (options) {
                this.hidden = false;
            },
            hide () {
                this.hidden = true;
                $('.modal input').val('')
            },
            changePassword (e) {
                e.preventDefault();
//			if ($(".change-password-modal").valid(this, '内容出错') === false) {
//	            return false;
//	        }
                let param = {
                    userName: this.user.username,
                    oldPassword: SHA1(this.oldPassword),
                    newPassword: SHA1(this.newPassword)
                }
                alert(JSON.stringify(param))
                $.ajax({
                    url: `${this.apiBase}/api/user/changePassword`,
                    type: 'POST',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(param),
                    cache: false,
                    processData: false,
                    success: (data) => {
                        if (data.code === 0) {
                            this.$message.alert('修改成功,请重新登陆！');

                            let param = {
                                token: this.user.token
                            }
                            $.ajax({
                                url: `${this.apiBase}/api/user/logout`,
                                type: 'POST',
                                contentType: 'application/json; charset=utf-8',
                                data: JSON.stringify(param),
                                cache: false,
                                success: (data) => {
                                },
                                error: (data) => {
                                }
                            })
                            this.$store.dispatch('clearToken')

                            this.hidden = true;
                        } else {
                            this.appConfig.showErrorAlert(data.code);
                        }
                    },
                    error: (data) => {
                        this.appConfig.showErrorAlert('default');
                    }
                })
            }
        },
        watch: {
            hidden: function (hidden) {
                this.newPassword = '';
                this.oldPassword = '';
                Vue.nextTick(function () {
                    if (hidden === false) {
                        /*$('.change-password-modal').validation();*/
                    }
                })
            }
        }
    }
</script>
<style>

    #changePasswordHeader {
        margin-left: 65px;
    }

    .change-psw-btn {
        vertical-align: top;
        margin-top: -4px;
    }

    .changePassword {
        width: 350px !important;
        border-radius: 12px;
        padding-left: 15px;
        font-size: 12px;
        color: rgb(145, 176, 196);
        background-color: #f3f7fa;
    }

    .change-psw-btn {
        margin-left: 65px;
    }

    .form-group-changePas {
        width: 350px;
        margin-left: 65px;

        margin-bottom: 10px;
    }
</style>
