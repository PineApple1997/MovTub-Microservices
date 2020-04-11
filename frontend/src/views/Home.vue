<template>
  <div>

    <el-container>
      <el-header>

        <el-row>
          <el-col :span="6">MovTub</el-col>
          <el-col :span="6"><el-button type="primary" icon="el-icon-search">搜索</el-button></el-col>

        </el-row>
        

      </el-header>
      <el-container>
        <el-aside width="200px">
          
          <el-row class="tac">
            <el-col :span="24">
              <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">
                <el-menu-item index="1">
                  <i class="el-icon-s-home"></i>
                  <span slot="title">Home</span>
                </el-menu-item>
                <el-menu-item index="2">
                  <i class="el-icon-data-line"></i>
                  <span slot="title">Trending</span>
                </el-menu-item>
                <el-menu-item index="3">
                  <i class="el-icon-document"></i>
                  <span slot="title">Subscriptions</span>
                </el-menu-item>
                <el-divider></el-divider>
                <el-menu-item index="4">
                  <i class="el-icon-notebook-1"></i>
                  <span slot="title">Library</span>
                </el-menu-item>
                <el-menu-item index="5">
                  <i class="el-icon-folder-opened"></i>
                  <span slot="title">History</span>
                </el-menu-item>
                <el-menu-item index="6">
                  <i class="el-icon-watch"></i>
                  <span slot="title">Watch later</span>
                </el-menu-item>
                <el-menu-item index="7">
                  <i class="el-icon-star-off"></i>
                  <span slot="title">Liked videos</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
          
        </el-aside>
        <el-main>


          
    
          <el-card class="card" v-for="(item, $index) in list" :key="$index">
            Card {{ $index + 1 }}
          </el-card>
          <infinite-loading @infinite="infiniteHandler"></infinite-loading>

        </el-main>
      </el-container>
    </el-container>

    
    
  </div>
</template>

<script>

import InfiniteLoading from 'vue-infinite-loading';

export default {
  components: {
    InfiniteLoading,
  },
  name: 'Home',
  data() {
    return {
      list: []
    };
  },

  mounted() {

  }, 

  methods: {
    infiniteHandler ($state) {
      setTimeout(() => {
        this.list.push('', '', '', '', '');
        $state.loaded();
      }, 2000);
    }, 
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }, 
  }
}
</script>

<style scoped>

.card {
  margin: 15px;
}

.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    background-color: #E9EEF3;
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

</style>>
