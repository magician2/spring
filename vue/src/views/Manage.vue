<template>
  <div style="height: 100%">
      <el-container style="height: 100%; ">
          <el-aside :width="sideWidth + 'px' " style=" height :100%">

            <Aside/>
          </el-aside>
          <el-container>

              <el-header style="font-size: 12px; border-bottom: 1px solid #ccc;line-height: 60px;display: flex; justify-content: flex-end " >

                  <el-dropdown style="width: 100px;cursor: pointer">
                      <span>朴雄権</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
                      <el-dropdown-menu slot="dropdown">
                          <el-dropdown-item>個人情報</el-dropdown-item>
                          <el-dropdown-item>ログアウト</el-dropdown-item>
                      </el-dropdown-menu>
                  </el-dropdown>
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
import Employee from "@/views/Employee.vue";
export default {
    data(){
        return {

            collapseBtnClass : 'el-icon-s-fold',
            sideWidth:250,

        }
    },
    components:{
      Aside
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