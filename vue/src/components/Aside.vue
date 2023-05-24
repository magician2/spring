<template>
    <div style="height: 100%">
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" router style="height: 100%">
<!--            <el-menu-item index="/home">-->
<!--                <template slot="title">-->
<!--                    <i class="el-icon-house"></i>-->
<!--                    <span>TOP</span>-->
<!--                </template>-->
<!--            </el-menu-item>-->
            <el-menu-item index="/employee">
                <template slot="title">
                    <i class="el-icon-s-order"></i>
                    <span>社員一覧</span>
                </template>
            </el-menu-item>
            <el-menu-item index="">
                <template slot="title">
                    <i class="el-icon-s-data"></i>
                    <span>分析</span>
                </template>
            </el-menu-item>
        </el-menu>
    </div>

</template>
<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
    min-height: 400px;
}
</style>

<script>
export default {
    data() {
        return {
        };
    },
    methods: {

    },

}
</script>