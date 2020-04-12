<template>
  <el-container>
    <el-main>
      <div class="plyr__video-embed" id="player">
        <iframe
            src="https://www.youtube.com/embed/bTqVqk7FSmY?origin=https://plyr.io&amp;iv_load_policy=3&amp;modestbranding=1&amp;playsinline=1&amp;showinfo=0&amp;rel=0&amp;enablejsapi=1"
            allowfullscreen
            allowtransparency
            allow="autoplay"
            height="800px"
            width="100%"
        ></iframe>
      </div>
    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="24">The Shawshank Redemption - Official Trailer</el-col>
      </el-row>
      <el-row>
        <el-col :span="24">9.3/10 · 1994</el-col>
      </el-row>
      <el-divider></el-divider>
      <el-row>
        <el-col :span="24">Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.</el-col>
      </el-row>
      <el-divider></el-divider>
      <el-row>comments</el-row>
      <el-row>comments</el-row>
      <el-row>comments</el-row>
      <el-row>comments</el-row>
      <br>
      <br>
      <br>
      <br>
    </el-footer>
  </el-container>
</template>

<script>
  export default {
    data() {
      return {
        value: 9.2
      }
    }
  }
</script>