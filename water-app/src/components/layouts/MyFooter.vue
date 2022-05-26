<template>
  <div class="the-footer">
    <!-- <p v-for="(item, index) in footerList" :key="index">
      {{ item }}
    </p> -->
    <el-row type="flex" justify="center">
        <el-col :span="20" id="copyright">
          <el-divider></el-divider>
          <p>Copyright © 2022 Devin-Wain, Inc.</p>
        </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name:"my-footer",
  // data(){
  //     return{
  //       footerList:[
  //         "关于 | 帮助 | 条款 | 反馈",
  //         "Copyright © 2022 Devin-Wain",
  //       ]
  //   }
  // }
}
</script>

<style>
/* .the-footer {
  width: 100%;
  padding: 20px;
} */
#copyright {
  background: rgb(255, 255, 255);
  z-index: 5;
}


</style>
