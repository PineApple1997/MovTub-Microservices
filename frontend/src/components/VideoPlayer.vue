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
                <p>{{video.creator}}</p>
                <p class="thumbnail-views">{{video.views}} Views</p>
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
      urlGetVideos: '/videos', 
      epoch: 1, 
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
            epoch: this.epoch
          }
        }).then(res => {
          this.videos = res.data.videos;
        });
    }
  }, 
  mounted: function() {
    this.videos = [
      {
        id: 1,
        title: "18-core iMac Pro Review: Not a Trap!",
        genres: 'genres genres genres', 
        embed_id: 'bTqVqk7FSmY', 
        thumbnail:
          "https://i.ytimg.com/vi/jn9mHzXJIV0/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLAvJvk4k_UNB9nst4pFP-txM1TLZA",
        
        creator: "Marques Brownlee",
      },
      {
        id: 2,
        title: "Dope Tech: Camera Robots!",
        thumbnail:
          "https://i.ytimg.com/vi/UIwdCN4dV6w/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLDhlan32jHSvicGZezDFPjAOdXGUA",
        youtubeURL: "https://www.youtube.com/embed/UIwdCN4dV6w",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      },
      {
        id: 3,
        title: "Let's Talk About Tesla Roadster 2020!",
        thumbnail:
          "https://i.ytimg.com/vi/ctx4YBEdOxo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLBDnlrC2rVwXamNkicEEbc3Mf4T0w",
        youtubeURL: "https://www.youtube.com/embed/ctx4YBEdOxo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      },
      {
        id: 4,
        title: "Talking Tech with Neil deGrasse Tyson!",
        thumbnail:
          "https://i.ytimg.com/vi/pqQrL1K0Z5g/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLA5hTiwkz4Tr1w1hSMhPlwtmQeyYw",
        youtubeURL: "https://www.youtube.com/embed/pqQrL1K0Z5g",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      },
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }, 
      {
        id: 5,
        title: "The Apple Ecosystem: Explained!",
        thumbnail:
          "https://i.ytimg.com/vi/KB4_WIPE7vo/hqdefault.jpg?sqp=-oaymwEZCNACELwBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCCxXm7aoPShOwON74nhMlGYMUkHw",
        youtubeURL: "https://www.youtube.com/embed/KB4_WIPE7vo",
        creator: "Marques Brownlee",
        likes: 0,
        views: 0
      }
    ];
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