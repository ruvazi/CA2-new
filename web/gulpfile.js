var gulp = require('gulp');
var sass = require('gulp-sass');
var express = require('express');
var lr;

var EXPRESS_PORT = 4000;
var EXPRESS_ROOT = __dirname;
var LIVERELOAD_PORT = 35729;

function startExpress() {
  var app = express();
  app.use(require('connect-livereload')());
  app.use(express.static(EXPRESS_ROOT));
  app.listen(EXPRESS_PORT);
}

function startLR() {
  lr = require('tiny-lr')();
  lr.listen(LIVERELOAD_PORT);
};

function notifyLR(event) {
  var fileName = require('path').relative(EXPRESS_ROOT, event.path);

  lr.changed({
    body: {
      files: [fileName]
    }
  });
}

gulp.task('styles', function() {
    gulp.src('sass/**/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(gulp.dest('css'))
});


gulp.task('default',function() {
    gulp.watch('sass/**/*.scss', ['styles']);
    startExpress();
    startLR();
    gulp.watch('*.html', notifyLR);
    gulp.watch('partials/*.html', notifyLR);
    gulp.watch('scss/*.scss', notifyLR);
});
