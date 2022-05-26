<template>
<el-row class="tac"> 
  <el-col :span="10">
    <!-- <el-menu router :default-active="$route.path" class="el-menu-vertical-demo" @open="handleOpen"> -->
    <el-menu router :default-active="$route.path" class="el-menu-vertical-demo">
      <el-menu-item index="upload">
        <h3 slot="title">上传图片</h3>
      </el-menu-item>
      
      <el-submenu index="2">
        <template slot="title">
          <h3>预处理</h3>
        </template>
        <el-menu-item index="downsample">下采样</el-menu-item>
        <el-menu-item index="2-2">滤波</el-menu-item>
        <!-- </el-menu-item-group> -->     
      </el-submenu>
    
    <el-submenu index="3">
        <template slot="title">
          <h3>Otsu法</h3>
        </template>
        <el-menu-item index="otsu-1d">一维Otsu</el-menu-item>
        <el-menu-item index="3-2">二维Otsu</el-menu-item>
        <el-menu-item index="3-3">开运算</el-menu-item>
        <el-menu-item index="3-4">闭运算</el-menu-item>
        <el-menu-item index="3-5">移除斑点</el-menu-item>
        <el-menu-item index="3-6">填补小洞</el-menu-item>
    </el-submenu> 
    
    <el-submenu index="4">
        <template slot="title">
          <h3>深度学习法</h3>
        </template>
        <el-menu-item index="4-1">Unet++</el-menu-item>
    </el-submenu> 
    </el-menu>
  </el-col>
</el-row>
</template>


<script >
export default {
    name:"my-sidebar",
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style>
.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}

.el-tabs--right .el-tabs__content,
.el-tabs--left .el-tabs__content {
  height: 100%;
}
</style>
