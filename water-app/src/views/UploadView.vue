<template>
  <div class="about">
    <h3>请上传需要提取水体🌊的图像</h3>
      <el-upload
        class="upload-demo"
        drag
        action="http://localhost:8888/api/photo"
        list-type="picture"
        :on-success="handleUploadSuccess"
        multiple>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">支持上传jpg/png/tiff文件，且不超过50MB</div>
        <div v-show="isUpload" slot="tip">
          <h5>上传成功！点击左侧导航栏跳转到预处理环节~</h5>
        </div>
      </el-upload> 
  </div>
</template>

<script>
import Vue from 'vue'
import global from "@/global/global.js"
Vue.prototype.global = global

export default {
    name: "UploadView",
    data() {
      return {
        // fileList: [],
        backend_root: "http://localhost:8888",
        fileList: global.fileList,
        isUpload: false,
      };
    },
    methods: {
      handleUploadSuccess(response, file, fileList) {
        console.log(fileList);
        let re_url = fileList[fileList.length - 1].response.name.replaceAll("\\", "/");
        this.fileList.push({name : fileList[fileList.length - 1].name, url : this.backend_root+re_url});
        console.log(this.fileList);
        console.log(response);
        console.log(file);
        console.log(fileList);
        this.isUpload = true;
      }
    }
  };

</script>