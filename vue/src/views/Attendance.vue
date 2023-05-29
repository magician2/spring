<template>
    <div>
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="勤務表" name="first">勤務表
                <el-table :data="tableData" border stripe>
                    <el-table-column prop="id" label="日付" width="50">
                    </el-table-column >
                    <el-table-column prop="name" label="日付" width="120">
                    </el-table-column>

                </el-table>
            </el-tab-pane>
            <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
            <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
            <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
import {defineComponent} from 'vue'

export default defineComponent({
    name: "Labor",
    data() {
        return {
            activeName: 'first',
            tableData: [],
            info :{},
            form:{address: ''},
            dialogTitle:"",
            total:0,
            pageNum : 1,
            pageSize:10,
            name:"",
            department: "",
            gender: "",
            date :"",
            hobby:"",
            mail:"",
            phone:"",
            academic:"",
            address:"",
            imgurl:"",
            zipcode:"",
            address1:"",
            address2:"",
            address3:"",
            address4:"",
            postaddress:"",
            search:"",
        };
    },
    created() {
        this.load()
    },
    methods: {
        handleClick(tab, event) {
            console.log(tab, event);
        },
        load(){
            this.request.get("/employeedata").then(res => {
                    this.tableData = res.data
                    this.total = res.data.total
                console.log(res)
                }
            )
        },
    }
})
</script>


<style scoped>

</style>