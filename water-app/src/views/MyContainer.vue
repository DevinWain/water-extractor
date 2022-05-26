<template>
<div id="mycontainer">
  <my-header></my-header>
  <el-row class="tac"> 
    <el-col :span="8">
      <my-sidebar></my-sidebar>
    </el-col>
    <el-col :span="16">
      <router-view />
    </el-col>
  </el-row>
  <my-footer></my-footer>
</div>
</template>

<script>
import MyHeader from "@/components/layouts/MyHeader";
import MyFooter from "@/components/layouts/MyFooter";
import MySidebar from "@/components/layouts/MySidebar";

export default {
    name: 'MyContainer',
    components:{
      MyHeader,MySidebar,MyFooter
    },
  }

</script>

<style>
.the-footer {
  display: flex;
  flex-direction: column;
}
</style>

