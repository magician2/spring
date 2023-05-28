<template>
  <div style="display: flex;height: 60px;justify-content: space-between;line-height: 60px;background-color: #8c939d;padding: 0 10px">
      <el-breadcrumb separator-class="el-icon-arrow-right" style="line-height: 60px;margin-left: 30px">
<!--          <el-breadcrumb-item :to=" '/employee' " style="color: white"><p style="color: white">ホーム></p></el-breadcrumb-item>-->
          <el-breadcrumb-item ><p style="color: white">{{currentPathName}}</p></el-breadcrumb-item>
      </el-breadcrumb>

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

    methods:{

    }

})
</script>
<style>
.el-breadcrumb__inner{
       color: white;
    }
.el-breadcrumb__separator{
    color: white;
}
</style>