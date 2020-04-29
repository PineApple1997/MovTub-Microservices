<template>
  <el-container>
    <el-main>
      <vue-plyr>
        <!-- <div data-plyr-provider="youtube" data-plyr-embed-id="bTqVqk7FSmY"></div> -->
        <div data-plyr-provider="youtube" :data-plyr-embed-id=embedid></div>
      </vue-plyr>
    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="24">{{movie_title}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="24">{{imdb_rating}}/10 · {{year}}</el-col>
      </el-row>
      <el-divider></el-divider>
      <el-row>
        <el-col :span="24">{{description}}</el-col>
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
        embedid: 'OrP_CtoeO9E', 
        urlGetAll: '/watch', 
        year: '1994', 
        imdb_rating: 9.2, 
        movie_title: 'The Shawshank Redemption', 
        description: 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 
      }
    }, 

    methods: {
      getAll() {
        this.$axios.get(this.urlGetAll, {
          params: {
            v: this.embedid, 
          }
        }).then(res => {
          this.year = res.data.year;
          this.imdb_rating = res.data.imdbRating;
          this.movie_title = res.data.movieTitle;
        });
      }, 
    }, 

    mounted() {
      this.getAll();
    },
  }
</script>