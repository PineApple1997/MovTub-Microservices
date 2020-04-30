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
                <p class="thumbnail-views" >{{video.genres}}</p>
              </div>
              <br>
          </li>
        </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VideoPlayer',
  data () {
    return {
      videos: [], 
      urlGetVideos: '/catalog/homepage', 
      epoch: 1, 
      userId: 30, 
    }
  }, 
  methods: {
    chooseVideo(video){
        //INCREASE THE VIDEOS VIEWS BY 1
        video.views += 1;
    }, 
    getVideos() {
      this.$axios.get(this.urlGetVideos, {
          params: {
            userId: this.userId, 
            epoch: this.epoch
          }
        }).then(res => {
          this.videos = res.data;
        });
    }
  }, 
  mounted: function() {
    this.getVideos();
  }
}
</script>

<style scoped>
  .thumbnail{
    display:flex;
    cursor: pointer;
    line-height:110%;
  }

  .thumbnail img{
      width:368px;
      cursor: pointer;
      line-height:110%;
  }

  .thumbnail-info{
      margin-left:20px;
      cursor: pointer;
  }

  .thumbnail h3{
      font-size:16px;
      cursor: pointer;
      line-height:110%;
  }

  h3,
  p{
      margin:0;
      padding:0;
      line-height:110%;
  }

  .thumbnail-views{
      font-size:14px;
      line-height:110%;
  }

  .video-player{
      display:flex;
      width:1200px;
      margin:auto;
  }

  .video-container{
      margin-right:40px;
  }

  .row{
      display:flex;
      justify-content:space-between;
  }

  button{
      background:#D0021B;
      color:white;
      border:none;
      padding:10px 20px;
  }

  .video-list ul {
		width: 100%;
	}

	.video-list li {
		width: 24%;   /*如果显示三列 则width改为70px*/
		float: left;
		display: block;
	}
</style>