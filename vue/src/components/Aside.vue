<template>
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" router style="">
                <el-menu-item index="/employee" style="min-width: 120px">
                    <template slot="title">
                        <i class="el-icon-s-order"></i>
                        <span>社員一覧</span>
                    </template>
                </el-menu-item>
                <el-menu-item index="/analyze" style="min-width: 120px">
                    <template slot="title">
                        <i class="el-icon-pie-chart"></i>
                        <span>分析</span>
                    </template>
                </el-menu-item>
                <el-menu-item index="/attendance" style="min-width: 120px">
                    <template slot="title">
                        <i class="el-icon-s-claim"></i>
                        <span>勤怠管理</span>
                    </template>
                </el-menu-item>
                <el-menu-item index="/attendance" style="min-width: 120px">
                    <template slot="title">
                        <i class="el-icon-notebook-1"></i>
                        <span>人材管理</span>
                    </template>
                </el-menu-item>
            <el-menu-item-group style="position: absolute;bottom: 20%;width: 100%">
                <template slot="title">{{user.name}}</template>
                <el-menu-item  @click="logout">
                    <i class="el-icon-switch-button"></i>
                    <span>Logout</span>
                </el-menu-item>
            </el-menu-item-group>
        </el-menu>



</template>
<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
    min-height: 400px;
    position: relative;
    padding-top: 20%;
    border: 0px;
    height: 100%;
    box-sizing: border-box;
    background: rgb(239, 242, 245);
}
.el-menu-item{
    padding-left: 20%!important;
    font-size: 16px!important;
    color: #909399;
}

.el-menu-item:hover, i:hover{
    color: #409EFF!important;
}
</style>

<script>
export default {
    data() {
        return {
            user:localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        };
    },
    methods: {
        logout(){
            this.$router.push("/Login")
            localStorage.removeItem("user")
            this.$message.success("ログアウトしました")
        }
    },

}
</script>