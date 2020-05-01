<template>
  <div>

    <el-container>
      <el-header>
        <el-row>
          <el-col :span="2" class="movtub">
            <p @click="backToHomePage()">MovTub</p>
          </el-col>
          <el-col :span="8" :offset="6">
            <div>
              <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
                <el-button slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </div>
          </el-col>
          <el-col :span="4">
            <el-button @click="changeUserID">
              change user
            </el-button>
          </el-col>
          <el-col  class="avater" :span="2">
            <el-avatar :size="60" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
          </el-col>

        </el-row>
        

      </el-header>
      <el-container>
        <el-aside width="200px">
          
          <el-row class="tac">
            <el-col :span="24">
              <el-menu
                default-active="1"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">
                <el-menu-item index="1">
                  <i class="el-icon-s-home"></i>
                  <span slot="title" class="title">Home</span>
                </el-menu-item>
                <el-menu-item index="2">
                  <i class="el-icon-data-line"></i>
                  <span slot="title" class="title">Trending</span>
                </el-menu-item>
                <el-menu-item index="3">
                  <i class="el-icon-document"></i>
                  <span slot="title" class="title">Subscriptions</span>
                </el-menu-item>
                <el-divider></el-divider>
                <el-menu-item index="4">
                  <i class="el-icon-notebook-1"></i>
                  <span slot="title" class="title">Library</span>
                </el-menu-item>
                <el-menu-item index="5">
                  <i class="el-icon-folder-opened"></i>
                  <span slot="title" class="title">History</span>
                </el-menu-item>
                <el-menu-item index="6">
                  <i class="el-icon-watch"></i>
                  <span slot="title" class="title">Watch later</span>
                </el-menu-item>
                <el-menu-item index="7">
                  <i class="el-icon-star-off"></i>
                  <span slot="title" class="title">Liked videos</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>

        <el-main>
          <div class="video-player">
            <VideoPlayer :userID='userID'> </VideoPlayer>
          </div>
        </el-main>

      </el-container>
    </el-container>

    
    
  </div>
</template>



<script>
import VideoPlayer from '@/components/VideoPlayer.vue'
export default {
  components: {
    VideoPlayer
  },
  name: 'Home',
  data() {
    return {
      list: [], 
      input3: '',
      count: 0, 
      page: 1, 
      userID: 1,
    };
  },

  mounted() {

  }, 

  methods: {
    backToHomePage() {
      this.$router.go(0);
    }, 
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    changeUserID(){
      this.userID = 1+ Math.floor(Math.random()*600);
    }
  }
}
</script>

<style scoped>

.card {
  margin: 15px;
}

.el-header, .el-footer {
    background-color: rgb(236, 239, 245);
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: rgb(236, 239, 245);
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-menu-vertical-demo {
    background-color: rgb(236, 239, 245);
  }
  
  .el-main {
    background-color: rgb(241, 244, 247);
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }

  .el-select .el-input {
    width: 130px;
  }
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

  .infinite-list {
    height: 100%;
    padding: 0;
    margin: 0;
    list-style: none;
    overflow: auto;
  }

  .infinite-list .infinite-list-item {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 50px;
      background: #e8f3fe;
      margin: 10px;
      color: #7dbcfc;
  } 

  .video-player{
      width: 100%;
  }

  .title{
    font-family: "Helvetica Neue";
  }

  .movtub {
    font-size:25px;
    font-family: "Helvetica Neue";
    font-weight: bold;
    cursor: pointer;
    margin: 10px;
  }

  .avater {
    cursor: pointer;
  }

</style>>
