<template>
    <div>
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="勤務表" name="first">
                <el-table :data="tableData" border stripe>
                    <el-table-column prop="date" label="日付" width="90">
                    </el-table-column >
                    <el-table-column prop="name" label="勤務区分" width="80">
                    </el-table-column>
                    <el-table-column prop="commencementTime" label="出社時刻" width="80">
                    </el-table-column >
                    <el-table-column prop="leavingTime" label="退勤時刻" width="80">
                    </el-table-column>
                    <el-table-column prop="" label="労勤時間" width="80">
                    </el-table-column >
                    <el-table-column prop="" label="残業時間" width="80">
                    </el-table-column>
                    <el-table-column prop="" label="勤怠グラフ" width="400">
                    </el-table-column>

                </el-table>
            </el-tab-pane>
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
            timeAuto:[]
        };
    },
    created() {
        this.attendanceLoad()
    },
    mounted() {
        setTimeout(()=>{
            var timeAuto = 0;
            for(let i =0;i < this.tableData.length;i++){
                var leavingTime =new Date(this.tableData[i].leavingTime)
                var commencementTime = new Date(this.tableData[i].commencementTime)
                var difftime = (leavingTime - commencementTime) /1000
                var days = parseInt(difftime/86400)
                var hours = parseInt(difftime/3600)-24*days
                var minutes = parseInt(difftime%3600/60);
                timeAuto = hours + "時間" + minutes + "分"
                this.timeAuto.push(timeAuto)
            }
            console.log(this.timeAuto)
        },500)

    },
    methods: {
        handleClick(tab, event) {
            console.log(tab, event);
        },
        // load(){
        //     this.request.get("/employeedata").then(res => {
        //             this.tableData = res.data
        //             this.total = res.data.total
        //         console.log(res)
        //         }
        //     )
        // },
        attendanceLoad(){
            this.request.get("/attendance/page?",{
                params:{
                    pageNum:1,
                    pageSize:1000
                }
            }).then(res => {
                    // this.tableData = res.data.records
                    // this.total = res.data.total
                    console.log(res)
                this.tableData = res.data

                }
            )
        },
    }
})
</script>


<style scoped>

</style>