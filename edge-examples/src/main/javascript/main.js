// run edge-tests/src/javascript/main/main.js -cp bin;edge-tests/src/javascript/main/

load('vertx.js')
load('edge.js');

var log = vertx.logger;
var app = Edge();

app
.get('/', function(req,res){
	res.renderText("This is the index page");
})

.get('/info', function(req,res){
	console.log(req.query.get('another'));
	res.renderText(req.query);
})

.get('/:value', function(req,res){
	res.renderText(req.params.get('value'));
})

.get('/blogs/:name', function(req,res){
	var name = req.params.name;

	if(name == ""){
		res.renderText("Index of Blogs");
	}else{
		res.renderText("Blog Entry : " + name);
	}
})

.get('*', function(req,res){
	res
		.status(404)
		.renderText("404");
})

.listen(8080,'localhost');