<template>
  <div style="display: flex;height: 60px;justify-content: space-between;line-height: 60px;background-color: #83c5be">
      <el-breadcrumb separator-class="el-icon-arrow-right" style="line-height: 60px">
          <el-breadcrumb-item :to=" '/' ">TOP</el-breadcrumb-item>
          <el-breadcrumb-item>dd</el-breadcrumb-item>
      </el-breadcrumb>
      <el-dropdown style="width: 100px;cursor: pointer">
          <span>朴雄権</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
          <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>個人情報</el-dropdown-item>
              <el-dropdown-item>ログアウト</el-dropdown-item>
          </el-dropdown-menu>
      </el-dropdown>

  </div>
</template>
<script>
import {defineComponent} from 'vue'

export default defineComponent({
    name: "Header",

    data(){
            return{
            }
    }

})
</script>
<style scoped>

</style>