<template>
    <header>
        <div id="header" class="container">
            <router-link to='/'><img src="../../../static/img/logo1.png" alt="" class='logo'></router-link>
            <div class="userbar">
                <div v-if="user.token">
                    <a class="user-dropdown">
                        <span>{{userTypeCn}}</span>&nbsp;
                        <span>{{user.username}}</span>
                        <span class="triangle"></span>
                    </a>
                    <div class="user-controller" id='user-controller'>
                        <!--  <router-link v-if="user.userType==='super'" to="/user">用户管理</router-link>
                          <a @click="showChangeEmailModal">修改邮箱</a>
                          <a @click="showChangePasswordModal">修改密码</a>-->
                        <a @click="logout">安全退出</a>
                    </div>
                </div>
                <div v-else>
                    <a href="javascript:;" @click="showLoginModal">登录</a><a href="javascript:;"
                                                                            @click="showRegisterModal">注册</a>
                </div>
            </div>
        </div>

        <LoginModal ref="loginModal"></LoginModal>
        <ChangePasswordModal ref="changePasswordModal"></ChangePasswordModal>
    </header>
</template>
<script>
    import LoginModal from './LoginModal.vue'
    import ChangePasswordModal from './ChangePasswordModal.vue'
    import {mapGetters} from 'vuex'

    export default {
        components: {LoginModal, ChangePasswordModal},
        computed: {
            ...mapGetters({
                user: 'user'
            }),
            userTypeCn () {
                return this.user.userType === 'super' ? '管理员' : '用户'
            }
        },
        methods: {
            showLoginModal() {
                this.$refs.loginModal.show();
            },
            showRegisterModal() {
                this.$refs.loginModal.show('reg');
            },
            showChangePasswordModal() {
                this.$refs.changePasswordModal.show();
            },
            showChangeEmailModal() {
                this.$message.modal({
                    header: '修改邮箱',
                    body: `	<div class="form-group changeEmail">
								<input type="text"
										class="change-email-input form-control changeEmailInput"
										check-type="required mail"
										required-message="请输email"
										value=${this.user.email}>
							</div>`,
                    primaryBtn: '修改',
                    primaryClick: () => {
                        let email = $('.change-email-input').val(),
                            param = {
                                userName: this.user.username,
                                email: email
                            };
                        $.ajax({
                            url: `${this.apiBase}/api/user/updateCurrentUserEmail`,
                            type: 'POST',
                            contentType: 'application/json; charset=utf-8',
                            data: JSON.stringify(param),
                            cache: false,
                            success: (data) => {
                                if (data.code === 0) {
                                    this.$message.hide();
                                    this.$message.alert('修改成功！')
                                    this.$store.dispatch('setEmail', email)
                                } else {
                                    this.appConfig.showErrorAlert(data.code)
                                }
                            },
                            error: (data) => {
                                this.appConfig.showErrorAlert()
                            }
                        })
                    },
                    callback: () => {
                        // $('.modal-body').validation();
                    }
                })
            },
            logout() {
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
                        // this.$store.dispatch('clearToken')
                        // this.$store.dispatch('clearProjects')
                        //this.$message.alert('登出成功')
                    },
                    error: (data) => {
                        // this.$store.dispatch('clearToken')
                        // this.$store.dispatch('clearProjects')
                        // this.$message.alert('登出成功')
                    }
                })
                this.$store.dispatch('clearToken')
                this.$store.dispatch('clearProjects')
            }
        },
        mounted () {
            if (this.user.token === '') {
                this.showLoginModal();
            }

        },
        watch: {
            user: {
                handler: function () {
                    if (this.user.token === '') {
                        this.$router.push({name: 'home'});
                        this.showLoginModal();
                    } else {
//            this.$store.dispatch('getProjects');
                    }
                },
                deep: true
            }
        }
    }

</script>
<style>

    header {
        position: relative;
        z-index: 2;
        height: 80px;
        width: 100%;
        /*box-shadow: 0 2px 2px #ccc;*/
        border-bottom: 1px solid #cccccc;
    }

    #header {
        height: 80px;
        line-height: 80px;
    }

    .logo {
        padding-top: 0px;
        padding-bottom: 0px;
        /*
        padding-top: 20px;
        padding-bottom: 20px;
        */
    }

    .userbar {
        float: right;
        position: relative;
    }

    .userbar:hover .triangle {
        transform: rotate(180deg);
    }

    .user-dropdown {
        padding-right: 20px;
    }

    .userbar a {
        display: inline-block;
        line-height: 60px;
        margin-left: 10px;
        text-decoration: none;
        color: #91B0C4;
        font-size: 14px;
    }

    .triangle {
        position: absolute;
        right: 0;
        top: 38px;
        width: 0;
        height: 0;
        border-style: solid;
        border-left: 6px double transparent;
        border-right: 6px double transparent;
        border-bottom: 0;
        border-top: 6px solid #91B0C4;
        transition: transform .3s;
    }

    .userbar:hover .user-controller {
        display: block;
        right: -46px;
        top: 80px;
        opacity: 0.99;
    }

    .user-controller {
        position: absolute;
        display: none;
        right: -46px;
        top: 80px;
        width: 200px;
        background: rgba(255, 255, 255, 0.95);
        box-shadow: 3px 0px 5px #eef3f5, -3px 5px 5px #eef3f5;
        border-radius: 5px;
        opacity: 0;
        transition: all 1s;
    }

    .user-controller a {
        display: block;
        padding: 10px;
        margin: 0;
        line-height: 1.2;
        cursor: pointer;
    }

    .user-controller a:hover {
        background-color: #f3f7fa;
        text-decoration: none;
    }

    .changeEmail {
        margin-bottom: -3px;
    }

    .changeEmailInput {
        background: #f3f7fa;
        border-radius: 20px !important;
        padding-left: 25px !important;
        font-size: 12px;
        color: rgb(153, 153, 153);
        width: 270px !important;
        height: 30px !important;
    }
</style>
