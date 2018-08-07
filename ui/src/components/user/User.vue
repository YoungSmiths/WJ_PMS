<template>
    <div id="user" class="container">
        <div class="breadcrumb">
            <router-link to="/">主页</router-link>
            <a class="bc-active">用户管理</a>
        </div>
        <table class="itemListTable">
            <thead id='Userthead'>
            <tr>
                <th>用户名</th>
                <th>真实姓名</th>
                <!--<th>邮箱</th>-->
                <th class='role'>用户角色</th>
                <th class='status'>用户状态</th>
                <th class='operation'>操作</th>
            </tr>
            </thead>
            <tbody id='Usertbody'>
            <UserItem v-for="(item,index) in userList"
                      :item="item"
                      :isLast="index===userList.length-1"
                      :key="item.id"
                      @refreshUserList="getList()">
            </UserItem>
            </tbody>
        </table>
    </div>
</template>
<script type="text/ecmascript-6">
    import UserItem from './UserItem.vue'
    import $ from 'jquery'
    import { mapGetters } from 'vuex'


    export default {
        components: {UserItem},
        data () {
            return {
                userList: []
            }
        },
        computed: {
            ...mapGetters({
                user: 'user'
            })
        },
        created () {
            if (this.$store.state.user.token === '') {
                this.$message.alert('请先登录');
                router.push('/');
                return;
            }
            this.getList();
        },
        methods: {
            getList () {
                alert(this.user.username)
                $.ajax({
                    url: `${this.apiBase}/api/user/getUsers/${this.user.username}`,
                    type: 'POST',
                    contentType: 'application/json; charset=utf-8',
                    cache: false,
                    processData: false,
                    success: (data) => {
                        if (data.code === 0) {
                            this.userList = data.data;
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
        mounted () {
        }
    }
</script>
<style>


    .user-ctrl-table tbody tr:nth-child(odd) {
        background-color: #eee
    }

    .UserShadow {
        position: absolute;
        top: 2px;
        left: -5px;
        z-index: -10;
    }

    #Userthead th {
        padding: 5px;
        width: 220px;
        text-align: left;
        height: 40px;
        line-height: 40px;
        font-size: 12px;
        color: #91B0C4;
        padding-left: 20px;
    }

    #Userthead .role, #Userthead .status {
        width: 140px;
    }

    #Userthead .operation {
        width: 280px;
    }

    #Usertbody tr {
        height: 60px;
        line-height: 20px;
    }

    #Usertbody td {
        text-align: left;
        padding-left: 20px;
        font-size: 12px;
        color: rgb(102, 102, 102);
    }

    #Usertbody .role {
        color: rgb(254, 80, 77);
    }
</style>
