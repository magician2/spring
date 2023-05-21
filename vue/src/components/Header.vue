<template>
  <div style="display: flex;height: 60px;justify-content: space-between;line-height: 60px;background-color: #83c5be">
      <el-breadcrumb separator-class="el-icon-arrow-right" style="line-height: 60px">
          <el-breadcrumb-item :to=" '/' ">TOP</el-breadcrumb-item>
          <el-breadcrumb-item>{{currentPathName}}</el-breadcrumb-item>
      </el-breadcrumb>
      <el-dropdown style="width: 100px;cursor: pointer">

          <span>管理人</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
          <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>ログアウト</el-dropdown-item>
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
            }
    },
    watch:{
        currentPathName(newVal,oldVal){
            console.log(newVal)
        }
    }

})
</script>
<style scoped>

</style>