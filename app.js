var express = require('express');
var path = require('path');
var app = express();
var port = 80;

var server = app.listen(port, function() {
    var host = server.address().address;
    var port = server.address().port;
    console.log('Hello app listening at http://%s:%s', host, port);
});

// view engine setup
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

app.get('/', function(req, res) {
    res.render('home');
});


app.use(express.static('static'));