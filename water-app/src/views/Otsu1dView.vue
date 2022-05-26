<template>
  <div class="about">
    hello!
    {{this.fileList}}
    <el-card :body-style="{ padding: '0px' }">
   
    <div class="demo-image__placeholder">
        <el-col :span="8">
        <div class="block">
            <span class="demonstration">原图</span>
            <el-image :src="src_org"></el-image>
        </div>
        </el-col>
        <el-col :span="8">
            <div> 111</div>
            <el-button type="primary" round @click="handleClick">处理</el-button>
        </el-col>
        <el-col :span="8">
        <div v-show="isShow" class="block">
            <span class="demonstration">处理后</span>
            <el-image :src="src_after">
                <div slot="placeholder" class="image-slot">
                    加载中<span class="dot">...</span>
                </div>
            </el-image>
        </div>
        </el-col>
    </div>
    </el-card>
  </div>
</template>

<script>
import Vue from 'vue'
import global from "@/global/global.js"
import { HttpManager } from "@/api/index.js"
Vue.prototype.global = global

export default {
    name: "Otsu1dView",
    data() {
      return {
          fileList: global.fileList,
          src_org: global.fileList[global.fileList.length - 1].url,
          src_after: "",
          isShow: false
      };
    },
    methods: {
      handleClick(){
        let fileName = global.fileList[global.fileList.length - 1].url.split("/").slice(-1);
        console.log(fileName);
        HttpManager.getOtsu1d(fileName).then((res) => {
          this.src_after = "http://localhost:8888/data/img/processed/" + res.url;
          this.isShow = true;
          console.log(this.src_after);
        })
        .catch((err) => {
          console.error(err);
        });
      }  
    }
  };

</script>