<template>
  <div style="height: 100%">
      <el-container style="height: 100%; ">

          <el-header style="height: 60px">
              <Header/>
          </el-header>
          <el-container style="width: 100%">
              <el-aside  style=" height :80%;width: 15%;">
                  <Aside/>
              </el-aside>
              <el-main style="padding: 0 20px">
                  <router-view/>
              </el-main>
          </el-container>
      </el-container>

  </div>
</template>

<script>

// @ is an alias to /src
import Aside from "../components/Aside.vue"
import Header from "@/components/Header.vue";

export default {
    data(){
        return {

            collapseBtnClass : 'el-icon-s-fold',

        }
    },
    components:{
      Aside,
      Header
    },
    methods : {


    }
}
</script>
<style>

</style>