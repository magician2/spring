<template>
  <div style="height: 100%">
      <el-container style="height: 100%; ">
          <el-aside :width="sideWidth + 'px' " style=" height :100%">

            <Aside/>
          </el-aside>
          <el-container>

              <el-header style="height: 60px">
                    <Header/>
              </el-header>
              <el-main>
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
            sideWidth:250,

        }
    },
    components:{
      Aside,
      Header
    },
    methods : {

        collapse(){
            this.isCollapse = !this.isCollapse
            if(this.isCollapse){
                this.sideWidth = 64
                this.collapseBtnClass = 'el-icon-s-unfold'
                this.logoTextShow = !this.logoTextShow
            }
            else {
                this.sideWidth = 250
                this.collapseBtnClass = 'el-icon-s-fold'
                this.logoTextShow = !this.logoTextShow
            }
        },

    }
}
</script>
<style>

</style>