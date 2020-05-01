<template>
  <div class="video-player">
    <div class="video-list">
      <ul>
        <li @click="chooseVideo(video)" :key="video.id" v-for="video in videos" class="thumbnail">
          <div class="thumbnail-img">
            <img :src="video.thumbnail" />
          </div>
          <div class="thumbnail-info">
            <h3>{{video.title}}</h3>
            <p class="thumbnail-views">{{video.genres}}</p>
          </div>
          <br />
        </li>
        <el-row>
          <el-col :span="24">
            <i class="el-icon-loading" v-if="loading"></i>
            <el-button v-else @click="loadMoreVideos">See more</el-button>
          </el-col>
        </el-row>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "VideoPlayer",
  data() {
    return {
      videos: [],
      urlGetVideos: "/catalog/homepage",
      epoch: 1,
      userId: this.userID,
      loading: true
    };
  },
  props: {
    userID: {
      type: Number,
      default: 1
    }
  },
  watch: {
    userID: function(userID) {
      this.userId = userID;
      this.videos = [];
      this.getVideos();
      console.log("watched: ", this.userId);
      this.loading = true;
    }
  },
  methods: {
    chooseVideo(video) {
      this.$router.push({
        name: "Watch",
        params: { v: video.embed_id, t: video.title }
      });
    },
    getVideos() {
      console.log("call api: get userID", this.userId);
      console.log("call api: get epoch", this.epoch);
      this.$axios
        .get(this.urlGetVideos, {
          params: {
            userId: this.userId,
            epoch: this.epoch
          }
        })
        .then(res => {
          console.log("res.data", res.data);
          console.log("res.data.length", res.data.length);
          this.videos.push.apply(this.videos, res.data);
          this.loading = false;
          // this.videos = res.data;
        });
    },
    loadMoreVideos() {
      this.loading = true;
      this.epoch++;
      this.getVideos();
    }
  },
  created: function() {
    this.getVideos();
  }
};
</script>

<style>
.thumbnail {
  display: flex;
  cursor: pointer;
  line-height: 150%;
}

.thumbnail img {
  width: 368px;
  cursor: pointer;
  line-height: 150%;
}

.thumbnail-info {
  margin-left: 20px;
  cursor: pointer;
}

.thumbnail h3 {
  font-size: 16px;
  cursor: pointer;
  line-height: 150%;
}

h3,
p {
  margin: 0;
  padding: 0;
  line-height: 150%;
}

.thumbnail-views {
  font-size: 14px;
  line-height: 150%;
}

.video-player {
  display: flex;
  width: 1200px;
  margin: auto;
}

.video-container {
  margin-right: 40px;
}

.row {
  display: flex;
  justify-content: space-between;
}

button {
  background: #d0021b;
  color: white;
  border: none;
  padding: 10px 20px;
}

.video-list ul {
  width: 100%;
  height: 99%;
}

.video-list li {
  width: 24%; /*如果显示三列 则width改为70px*/
  height: 350px;
  float: left;
  display: block;
}
</style>