<template>

</template>


<script>
export default {
    name: "HomeView",
    // data() {
    //   return {
    //     activeName: 'second'
    //   };
    // },
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
  };

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


