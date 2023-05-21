<template>
  <div style="display: flex;height: 60px;justify-content: space-between;line-height: 60px;background-color: #83c5be">
      <el-breadcrumb separator-class="el-icon-arrow-right" style="line-height: 60px">
          <el-breadcrumb-item :to=" '/' ">TOP</el-breadcrumb-item>
          <el-breadcrumb-item>{{currentPathName}}</el-breadcrumb-item>
      </el-breadcrumb>
      <el-dropdown style="width: 100px;cursor: pointer">

          <span>{{user.name}}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
          <el-dropdown-menu slot="dropdown" style="width: 100px;text-align: center">
              <el-dropdown-item style="font-size: 14px;padding: 5px 0">
                  <span style="text-decoration: none" @click="logout">ログアウト</span>
              </el-dropdown-item>
          </el-dropdown-menu>
      </el-dropdown>

  </div>
</template>
<script>
import {defineComponent} from 'vue'

export default defineComponent({
    name: "Header",
    computed:{
        currentPathName(){
        return this.$store.state.currentPathName;
    }},
    data(){
            return{
                user:localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
            }
    },
    watch:{
        currentPathName(newVal,oldVal){
            console.log(newVal)
        }
    },
    methods:{
        logout(){
            this.$router.push("/Login")
            localStorage.removeItem("user")
            this.$message.success("ログアウトしました")
        }
    }

})
</script>
<style scoped>

</style>